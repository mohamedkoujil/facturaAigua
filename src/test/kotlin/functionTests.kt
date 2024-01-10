import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class functionsTests {

    // Tests de la funció costLitre
    @Test
    fun testCostLitreConsumMoltAlt() {
        val consum = 100000

        val resultat = costLitre(consum)

        assertEquals(0.30, resultat)
    }
    @Test
    fun testCostLitreConsumMitja() {
        val consum = 50

        val resultat = costLitre(consum)

        assertEquals(0.15, resultat)
    }
    @Test
    fun testCostLitreConsumBaix() {
        val consum = 49

        val resultat = costLitre(consum)

        assertEquals(0.0, resultat)
    }

    // Tests de la funció descompteFM
    @Test
    fun testDescompteFNMembresFamiliaAlt() {
        val membresFamilia = 15

        val resultat = descompteFN(membresFamilia)

        assertEquals(0.5, resultat)
    }

    @Test
    fun testDescompteFNMembresFamBaix() {
        val membresFamilia = 0

        val resultat = descompteFN(membresFamilia)

        assertEquals(0.0, resultat)
    }

    // Tests de la funció total
    @Test
    fun testTotalSenseRes() {
        val quotaFixa = 6.0
        val quotaVariable = 0.0
        val consum = 0
        val descompteBS = 0.0
        val descompteFN = 0.0

        val resultat = total(quotaFixa, quotaVariable, consum, descompteBS, descompteFN)

        assertEquals(6.0, resultat)
    }
    @Test
    fun testTotalSenseConsumAmbDescompteFN() {
        val quotaFixa = 6.0
        val quotaVariable = 0.0
        val consum = 0
        val descompteBS = 0.0
        val descompteFN = 0.5

        val resultat = total(quotaFixa, quotaVariable, consum, descompteBS, descompteFN)

        assertEquals(3.0, resultat)
    }


}