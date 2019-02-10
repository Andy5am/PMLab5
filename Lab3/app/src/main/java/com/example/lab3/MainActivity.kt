package com.example.lab3

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonNewContact = findViewById<Button>(R.id.buttonNewContact)
        botonNewContact.setOnClickListener{val intent = Intent(this,NewContactActivity::class.java)
            startActivity(intent)}

        val contactos:MyContacts = (this.application as MyApplication).getContacts()

        val contactList = findViewById<ListView>(R.id.contactList)
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,contactos.contactos)
        contactList.adapter = adapter

        contactList.setOnItemClickListener { parent, view, position, id ->
            contactos.currentContact= contactos.contactos.get(position)
            val intent = Intent(this,ContactViewActivity::class.java)
            startActivity(intent)
        }
    }
}
