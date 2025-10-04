package Elecrodomesticos.Models


open class WashingMachine(
    basePrice: Double = BASE_PRICE,
    color: String = DEFAULT_COLOR,
    energyConsumption: Char = DEFAULT_CONSUMPTION,
    weight: Double = DEFAULT_WEIGHT,
    var load: Int = DEFAULT_LOAD
) : Electronics(basePrice, color, energyConsumption, weight) {

    companion object {
        const val DEFAULT_LOAD = 5
    }

    override fun finalPrice(): Double {
        var price = super.finalPrice()
        if (load > 30) {
            price += 50
        }
        return price
    }
}
