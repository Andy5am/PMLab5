package com.example.lab3

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mail)

        val contactos = (this.application as MyApplication).getContacts()

        val messageInput = findViewById<TextView>(R.id.messageInput)
        val fromInput = findViewById<TextView>(R.id.fromInput)
        val toInput = findViewById<TextView>(R.id.toInput)

        toInput.text = contactos.currentContact.correo

        messageInput.text = "Mi nombre es ${contactos.currentContact.nombre} y me telefono es "

        val botonEnviar = findViewById<Button>(R.id.buttonSend)
        botonEnviar.setOnClickListener {
            val toastEnviado = Toast.makeText(applicationContext, "Enviado desde ${fromInput.text} hacia ${contactos.currentContact.correo}",Toast.LENGTH_LONG)
            toastEnviado.show()
            val intent = Intent(this,ContactViewActivity::class.java)
            startActivity(intent)
        }



    }
}
