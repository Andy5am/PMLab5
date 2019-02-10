package com.example.lab3

import android.R
import android.app.Application
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView


class MyApplication: Application() {
    internal var db: ContactProvider = ContactProvider(this)
    internal var contactsList: List<Contact> = ArrayList()
    lateinit var currentContact: Contact

    fun refreshData(list_contacts: ListView) {
        contactsList = db.allContact
        val adapter = ArrayAdapter(this, R.layout.simple_list_item_1, contactsList)
        list_contacts.adapter = adapter
    }

    fun addContact(edt_id: EditText, edt_nombre: EditText, edt_telefono: EditText, edt_correo: EditText) {
        val contact = Contact (
            Integer.parseInt(edt_id.text.toString()),
            edt_nombre.text.toString(),
            edt_telefono.text.toString(),
            edt_correo.text.toString()
        )
        db.addContact(contact)
    }

    fun updateContact(edt_id: EditText, edt_nombre: TextView, edt_telefono: EditText, edt_correo: EditText) {
        val contact = Contact (
            Integer.parseInt(edt_id.text.toString()),
            edt_nombre.text.toString(),
            edt_telefono.text.toString(),
            edt_correo.text.toString()
        )
        db.updateContact(contact)
    }

    fun deleteContact(contact: Int) {
        db.deleteContact(this.contactsList[contact])
    }

    fun getContacts(): List<Contact> {
        return this.contactsList
    }





}