package com.example.lab3

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class NewContactActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_contact)

        val contactos = (this.application as MyApplication).getContacts()

        val botonReturn = findViewById<Button>(R.id.buttonReturn)
        botonReturn.setOnClickListener { val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)}

        val nameInput = findViewById<TextView>(R.id.nameInput)
        val phoneInput = findViewById<TextView>(R.id.numInput)
        val mailInput = findViewById<TextView>(R.id.mailInput)

        val botonAgregar = findViewById<Button>(R.id.buttonCreate)
        botonAgregar.setOnClickListener {
            val name = nameInput.text.toString()
            val telefono = phoneInput.text.toString()
            val mail = mailInput.text.toString()
            contactos.createAndAddContact(name, telefono, mail)
            val toastAgregado = Toast.makeText(this.applicationContext,"Se agrego a ${name} a sus contactos",Toast.LENGTH_LONG)
            toastAgregado.show()
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }



    }
}
