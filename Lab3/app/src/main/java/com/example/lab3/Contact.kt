package com.example.lab3

class Contact(val nombre:String, val telefono: String, val correo:String) {
    override fun toString(): String {
        return """
            ${this.nombre} - ${this.telefono}
        """.trimIndent()
    }
}