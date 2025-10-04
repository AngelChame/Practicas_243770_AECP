package Practica3

fun main() {
    var numero: Int
    do {
        println("Ingrese un mnumero")
        numero = readLine()!!.toInt()
        if (numero<0) {
            println("Vuelva a ingresar un numero mayor a 0")
        }

        for (i in 1..numero) {
            if (i % 2 == 0) {
                println("el numero $i es par")
            }


        }
    }while (numero <0)
}