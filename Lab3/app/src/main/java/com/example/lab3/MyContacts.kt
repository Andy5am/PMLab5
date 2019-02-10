package com.example.lab3

class MyContacts {
    val contactos: ArrayList<Contact> = ArrayList()

    lateinit var currentContact: Contact


    fun createAndAddContact(nombre:String, telefono:String,correo:String){
        val contacto = Contact(nombre,telefono,correo)
        contactos.add(contacto)
    }



}