package com.example.lab3

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class NewContactActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_contact)

        val contactos = (this.application as MyApplication)

        val botonReturn = findViewById<Button>(R.id.buttonReturn)
        botonReturn.setOnClickListener { val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)}

        val idInput = findViewById<EditText>(R.id.idInput)
        val nameInput = findViewById<EditText>(R.id.nameInput)
        val phoneInput = findViewById<EditText>(R.id.numInput)
        val mailInput = findViewById<EditText>(R.id.mailInput)

        val botonAgregar = findViewById<Button>(R.id.buttonCreate)
        botonAgregar.setOnClickListener {
            val name = nameInput.text.toString()
            contactos.addContact(idInput,nameInput, phoneInput, mailInput)
            val toastAgregado = Toast.makeText(this.applicationContext,"Se agrego a ${name} a sus contactos",Toast.LENGTH_LONG)
            toastAgregado.show()
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }



    }
}
