package com.example.lab3

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class EditContactActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_contact)

        val contactos = (this.application as MyApplication)

        val currentId = findViewById<TextView>(R.id.idEdit)
        currentId.text = contactos.currentContact.id.toString()
        val currentName = findViewById<TextView>(R.id.nameEdit)
        currentName.text = contactos.currentContact.nombre
        val currentNum = findViewById<TextView>(R.id.phoneEdit)
        currentNum.text = contactos.currentContact.telefono
        val currentMail = findViewById<TextView>(R.id.mailEdit)
        currentMail.text = contactos.currentContact.correo

        val backButton = findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener {
            val intent = Intent(this,ContactViewActivity::class.java)
            startActivity(intent)
        }

        val saveButton = findViewById<Button>(R.id.saveButton)
        saveButton.setOnClickListener {
            contactos.updateContact(currentId,currentName,currentNum,currentMail)
            val toastEdited = Toast.makeText(applicationContext,"Se ha editado el contacto", Toast.LENGTH_LONG)
            toastEdited.show()
            val intent = Intent(this,ContactViewActivity::class.java)
            startActivity(intent)
        }
    }
}
