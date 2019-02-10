package com.example.lab3

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonNewContact = findViewById<Button>(R.id.buttonNewContact)
        botonNewContact.setOnClickListener{val intent = Intent(this,NewContactActivity::class.java)
            startActivity(intent)}

        val contactos = (this.application as MyApplication)

        val contactList = findViewById<ListView>(R.id.contactList)
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,contactos.getContacts())
        contactList.adapter = adapter
        contactos.refreshData(contactList)

        contactList.setOnItemClickListener { parent, view, position, id ->
            contactos.currentContact= contactos.getContacts().get(position)
            val intent = Intent(this,ContactViewActivity::class.java)
            startActivity(intent)
        }

        contactList.setOnItemLongClickListener { parent, view, position, id ->
            contactos.deleteContact(position)
            adapter.notifyDataSetChanged()
            contactos.refreshData(contactList)
            val toastEliminado = Toast.makeText(applicationContext, "Se ha eliminado el contacto", Toast.LENGTH_LONG)
            toastEliminado.show()
            true
        }
    }
}
