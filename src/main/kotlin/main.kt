import kotlin.math.max

const val TYPE_MASTERCARD = "MasterCard"
const val TYPE_MIR = "MIR"
const val TYPE_VISA = "VISA"
const val TYPE_VKPAY = "VKPAY"


const val MAX_TRANSFER = 150_000
const val ERROR_LIMIT = -1
const val ERROR_WRONG_TYPE = -2

fun main() {
    println(calculateComission(TYPE_MASTERCARD, 500, 301))
    println(calculateComission(TYPE_VISA, 66656, 0))

}

fun calculateComission(typeCard: String, amount: Int, history: Int): Int {
    return when (typeCard) {
        TYPE_VKPAY -> if (amount + history > MAX_TRANSFER) ERROR_LIMIT else 0
        TYPE_MIR -> if (amount + history > MAX_TRANSFER) ERROR_LIMIT else max(35, (amount * 0.0075).toInt())
        TYPE_VISA -> if (amount + history > MAX_TRANSFER) ERROR_LIMIT else max(35, (amount * 0.0075).toInt())
        TYPE_MASTERCARD -> if (amount + history > MAX_TRANSFER) ERROR_LIMIT else
            if (history in 300..75000) 0 else (amount * 0.006 + 20).toInt()

        else -> ERROR_WRONG_TYPE
    }
}