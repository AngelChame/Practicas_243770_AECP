package Practica4

import kotlin.math.pow
import kotlin.math.sqrt

class Raices(private val a: Double, private val b: Double, private val c: Double) {


    fun getDiscriminante(): Double {

        return b.pow(2) - 4 * a * c
    }


    fun tieneRaices(): Boolean {
        return getDiscriminante() >= 0
    }

    fun tieneRaiz(): Boolean {
        return getDiscriminante() == 0.0
    }


    fun obtenerRaices() {
        if (tieneRaices()) {
            val discriminante = getDiscriminante()
            val raiz1 = (-b + sqrt(discriminante)) / (2 * a)
            val raiz2 = (-b - sqrt(discriminante)) / (2 * a)
            println("Las dos posibles soluciones son: Raíz 1 = $raiz1, Raíz 2 = $raiz2")
        } else {
            println("No hay dos soluciones reales.")
        }
    }


    fun obtenerRaiz() {
        if (tieneRaiz()) {
            val raiz = -b / (2 * a)
            println("Hay una única solución: Raíz = $raiz")
        } else {
            println("No hay una única solución real.")
        }
    }

    fun calcular() {
        val discriminante = getDiscriminante()
        when {
            discriminante > 0 -> {
                println("La ecuación tiene dos soluciones.")
                obtenerRaices()
            }
            discriminante == 0.0 -> {
                println("La ecuación tiene una única solución.")
                obtenerRaiz()
            }
            else -> {
                println("La ecuación no tiene soluciones reales.")
            }
        }
    }
}

// Función principal para probar la clase 'Raices'
fun main() {

    val ecuacion1 = Raices(a = 1.0, b = 5.0, c = 6.0)
    ecuacion1.calcular()
    println("---------------------------------")


    val ecuacion2 = Raices(a = 1.0, b = 4.0, c = 4.0)
    ecuacion2.calcular()
    println("---------------------------------")


    val ecuacion3 = Raices(a = 1.0, b = 1.0, c = 1.0)
    ecuacion3.calcular()
}