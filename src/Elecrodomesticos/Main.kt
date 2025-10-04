package Elecrodomesticos

import Elecrodomesticos.Models.Electronics
import Elecrodomesticos.Models.WashingMachine
import Elecrodomesticos.Models.Television

fun main() {
    val appliances: Array<Electronics> = arrayOf(
        WashingMachine(200.0, "white", 'A', 40.0, 35),
        WashingMachine(150.0, "red", 'C', 25.0, 20),
        Television(500.0, "black", 'B', 30.0, 42, true),
        Television(300.0, "blue", 'D', 20.0, 32, false),
        Electronics(100.0, "gray", 'E', 10.0),
        Electronics(120.0, "green", 'F', 50.0), // color inválido → se pone "white"
        WashingMachine(250.0, "black", 'B', 60.0, 40),
        Television(800.0, "white", 'A', 25.0, 50, true),
        Electronics(180.0, "red", 'C', 70.0),
        WashingMachine(300.0, "blue", 'D', 80.0, 28)
    )

    var totalAppliances = 0.0
    var totalWashers = 0.0
    var totalTVs = 0.0

    for (appliance in appliances) {
        val price = appliance.finalPrice()
        totalAppliances += price

        when (appliance) {
            is WashingMachine -> totalWashers += price
            is Television -> totalTVs += price
        }
    }

    println("Total price of appliances: $totalAppliances")
    println("Total price of washing machines: $totalWashers")
    println("Total price of televisions: $totalTVs")
}