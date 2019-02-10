package com.example.lab3

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ContactProvider (context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VER){
    companion object {
        private val DATABASE_VER = 1
        private val DATABASE_NAME = "CONTACTSDB.db"

        //Table
        private val TABLE_NAME = "Contact"
        private val COL_ID = "Id"
        private val COL_NOMBRE = "Nombre"
        private val COL_TELEFONO = "Telefono"
        private val COL_CORREO = "Correo"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE_QUERY: String = ("CREATE TABLE $TABLE_NAME ( $COL_ID INTEGER PRIMARY KEY, $COL_NOMBRE TEXT, $COL_TELEFONO TEXT, $COL_CORREO TEXT)")
        db!!.execSQL(CREATE_TABLE_QUERY)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db!!)
    }

    //CRUD

    val allContact: List<Contact>
        get() {
            val contactsList = ArrayList<Contact>()
            val selectQuery = "SELECT * FROM $TABLE_NAME"
            val db:SQLiteDatabase = this.writableDatabase
            val cursor: Cursor = db.rawQuery(selectQuery, null)

            if (cursor.moveToFirst()) {
                do {
                    val contact = Contact()
                    contact.id = cursor.getInt(cursor.getColumnIndex(COL_ID))
                    contact.nombre = cursor.getString(cursor.getColumnIndex(COL_NOMBRE))
                    contact.telefono = cursor.getString(cursor.getColumnIndex(COL_TELEFONO))
                    contact.correo = cursor.getString(cursor.getColumnIndex(COL_CORREO))

                    contactsList.add(contact)
                } while (cursor.moveToNext())
            }
            db.close()
            return contactsList
        }

    fun addContact(contact: Contact) {
        val db: SQLiteDatabase = this.writableDatabase
        val values = ContentValues()
        values.put(COL_ID, contact.id)
        values.put(COL_NOMBRE, contact.nombre)
        values.put(COL_TELEFONO, contact.telefono)
        values.put(COL_CORREO, contact.correo)

        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun updateContact(contact: Contact): Int {
        val db: SQLiteDatabase = this.writableDatabase
        val values = ContentValues()
        values.put(COL_ID, contact.id)
        values.put(COL_NOMBRE, contact.nombre)
        values.put(COL_TELEFONO, contact.telefono)
        values.put(COL_CORREO, contact.correo)

        return db.update(TABLE_NAME,values, "$COL_ID=?", arrayOf(contact.id.toString()))

    }

    fun deleteContact(contact: Contact) {
        val db: SQLiteDatabase = this.writableDatabase
        db.delete(TABLE_NAME, "$COL_ID=?", arrayOf(contact.id.toString()))
        db.close()
    }
}