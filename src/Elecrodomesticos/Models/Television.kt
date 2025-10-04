package Elecrodomesticos.Models


class Television(
    basePrice: Double = BASE_PRICE,
    color: String = DEFAULT_COLOR,
    energyConsumption: Char = DEFAULT_CONSUMPTION,
    weight: Double = DEFAULT_WEIGHT,
    var resolution: Int = DEFAULT_RESOLUTION,
    var tdt: Boolean = DEFAULT_TDT
) : Electronics(basePrice, color, energyConsumption, weight) {

    companion object {
        const val DEFAULT_RESOLUTION = 20
        const val DEFAULT_TDT = false
    }

    override fun finalPrice(): Double {
        var price = super.finalPrice()
        if (resolution > 40) {
            price += price * 0.3
        }
        if (tdt) {
            price += 50
        }
        return price
    }
}
