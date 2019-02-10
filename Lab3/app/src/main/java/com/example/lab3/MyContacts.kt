package com.example.lab3

class MyContacts {
    val contactos: ArrayList<Contact> = ArrayList()

    lateinit var currentContact: Contact


    fun createAndAddContact(id:Int,nombre:String, telefono:String,correo:String){
        val contacto = Contact(id,nombre,telefono,correo)
        contactos.add(contacto)
    }



}