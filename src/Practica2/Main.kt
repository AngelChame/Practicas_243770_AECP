package Practica2

fun main() {
    var kilometros: Float = 0.0f

    println("Ingresa su distancia")
    kilometros = readLine()!!.toFloat()

    if (kilometros <=0.5 ) {
        println("Esta disponle?")
        val disponibilidad: String? = readLine()
        if (disponibilidad == "si") {
            println("Listo para iniciar el viaje")
            println("Conductor en camino")
        }else{
            println("Conductor no disponible")
        }
    }
    if (kilometros > 0.5) {
        println("Esta disponible?")
        val disponibilidad: String? = readLine()
        if (disponibilidad == "si") {
            println("conductor disponible pero muy lejos, aplicaran tarifas mas altas" )
        }else{
            println("conductor no disponible")
        }
    }

}