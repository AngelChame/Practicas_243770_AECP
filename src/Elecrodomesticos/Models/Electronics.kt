package Elecrodomesticos.Models

open class Electronics(
    var basePrice: Double = BASE_PRICE,
    var color: String = DEFAULT_COLOR,
    var energyConsumption: Char = DEFAULT_CONSUMPTION,
    var weight: Double = DEFAULT_WEIGHT
) {
    companion object {
        const val DEFAULT_COLOR = "Blanco"
        const val DEFAULT_CONSUMPTION = 'F'
        const val BASE_PRICE = 100.0
        const val DEFAULT_WEIGHT = 5.0

        val validColors = listOf("blanco", "negro", "rojo", "azul", "gris")
        val validConsumptions = listOf('A', 'B', 'C', 'D', 'E', 'F')
    }

    init {
        color = checkColor(color)
        energyConsumption = checkEnergyConsumption(energyConsumption)
    }

    private fun checkEnergyConsumption(letter: Char): Char =
        if (letter in validConsumptions) letter else DEFAULT_CONSUMPTION

    private fun checkColor(color: String): String =
        validColors.find { it.equals(color, ignoreCase = true) } ?: DEFAULT_COLOR

    open fun finalPrice(): Double {
        var price = basePrice

        // Según consumo energético
        price += when (energyConsumption) {
            'A' -> 100
            'B' -> 80
            'C' -> 60
            'D' -> 50
            'E' -> 30
            'F' -> 10
            else -> 0
        }

        // Según peso
        price += when (weight) {
            in 0.0..19.0 -> 10
            in 20.0..49.0 -> 50
            in 50.0..79.0 -> 80
            else -> 100
        }

        return price
    }

}
