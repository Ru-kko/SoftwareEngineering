package com.taller02.domain


class CreditCapacity(
    val monthIngress: Float,
    val netEgress: Float,
    val creditDeb: Float,
    val creditTime: Int
) {
    private val ACTUAL_TAX = 0.09

    companion object {
        fun fromSet(set: Set<String>): CreditCapacity {
            val data = set.toList()


            return CreditCapacity(
                monthIngress = data[0].toFloat(),
                netEgress = data[1].toFloat(),
                creditDeb = data[2].toFloat(),
                creditTime = data[3].toInt()
            )
        }
    }

    fun calculateDebCapacity(): Float {
        return (monthIngress * 0.40f) - creditTime
    }

    fun maxCredit(): Int {
        return calculateDebCapacity().toInt() * creditTime
    }

    fun monthlyPayment(): Double {
        return (maxCredit() / creditTime) * (1 + ACTUAL_TAX)
    }

    fun toStringSet(): Set<String> {
        return setOf(
            monthIngress.toString(),
            netEgress.toString(),
            creditDeb.toString(),
            creditTime.toString()
        )
    }
}