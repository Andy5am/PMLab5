package com.example.lab3

import android.app.Application

class MyApplication :Application(){
        private var contacts:MyContacts = MyContacts()

    fun getContacts (): MyContacts {
        return this.contacts
    }

}