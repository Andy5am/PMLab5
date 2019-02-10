package com.example.lab3

class Contact{
    constructor(){}

    constructor(id: Int,nombre: String, telefono: String, correo: String){
        this.id = id
        this.nombre = nombre
        this.telefono = telefono
        this.correo = correo
    }

    var id: Int = 0
    var nombre:String = ""
    var telefono: String = ""
    var correo:String = ""

    override fun toString(): String {
        return """
            ${this.nombre} - ${this.telefono}
        """.trimIndent()
    }
}