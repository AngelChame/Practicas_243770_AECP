package Practica1

fun main() {
    var n: Int
    var total: Int=0
    var factorial: Int=1
    var n2: Int=1

    println("ingresa tu numero: ")
    n = readLine()!!.toInt()

    for (i in 1..n) {
        total = i+total
    }
    println("el total es1 = $total")

    while (n2<=n) {
        factorial *= n2
        n2++
        println("factorial = $factorial")


    }

}