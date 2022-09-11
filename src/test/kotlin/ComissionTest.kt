import org.junit.Test
import kotlin.test.assertEquals

class ComissionTest {

    @Test
    fun WrongTypeCardSystem() {
        val typeCard = "Union Pay"
        val amount = 5_000_000
        val history = 0

        val result = calculateComission(typeCard, amount, history)

        assertEquals(ERROR_WRONG_TYPE, result)

    }

    @Test
    fun testMasterCardNormal() {
        val typeCard = TYPE_MASTERCARD
        val amount = 500
        val history = 76000

        val result = calculateComission(typeCard, amount, history)

        assertEquals(23, result)
    }

    @Test
    fun testMasterCardLimit() {
        val typeCard = TYPE_MASTERCARD
        val amount = 500000000
        val history = 0

        val result = calculateComission(typeCard, amount, history)

        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun testMasterCardMonthLimit() {
        val typeCard = TYPE_MASTERCARD
        val amount = 10000
        val history = 300

        val result = calculateComission(typeCard, amount, history)

        assertEquals(0, result)
    }

    @Test
    fun testMasterCardNormal2() {
        val typeCard = TYPE_MASTERCARD
        val amount = 500
        val history = 0

        val result = calculateComission(typeCard, amount, history)

        assertEquals(23, result)

    }

    @Test
    fun testVkPayNormal() {
        val typeCard = TYPE_VKPAY
        val amount = 500
        val history = 0

        val result = calculateComission(typeCard, amount, history)

        assertEquals(0, result)

    }

    @Test
    fun testVkPayLimit() {
        val typeCard = TYPE_VKPAY
        val amount = 5_000_000
        val history = 0

        val result = calculateComission(typeCard, amount, history)

        assertEquals(ERROR_LIMIT, result)

    }

    @Test
    fun testVisaNormal() {
        val typeCard = TYPE_VISA
        val amount = 500
        val history = 0

        val result = calculateComission(typeCard, amount, history)

        assertEquals(35, result)

    }

    @Test
    fun testVisaLimit() {
        val typeCard = TYPE_VISA
        val amount = 5_000_000
        val history = 0

        val result = calculateComission(typeCard, amount, history)

        assertEquals(ERROR_LIMIT, result)

    }

    @Test
    fun testMirNormal() {
        val typeCard = TYPE_MIR
        val amount = 500
        val history = 0

        val result = calculateComission(typeCard, amount, history)

        assertEquals(35, result)

    }

    @Test
    fun testMirLimit() {
        val typeCard = TYPE_MIR
        val amount = 5_000_000
        val history = 0

        val result = calculateComission(typeCard, amount, history)

        assertEquals(ERROR_LIMIT, result)

    }
}