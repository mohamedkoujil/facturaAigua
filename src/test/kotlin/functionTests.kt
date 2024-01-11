import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test

class FacturaTest {

    // Test para la función costLitre
    @Test
    fun testCostLitre_ConsumBajo_RetornaCostLitreCero() {
        val result = costLitre(30)
        assertEquals(0.0, result)
    }

    @Test
    fun testCostLitre_ConsumMedio_RetornaCostLitreQuinceCents() {
        val result = costLitre(120)
        assertEquals(0.15, result)
    }

    @Test
    fun testCostLitre_ConsumAlto_RetornaCostLitreTrentaCents() {
        val result = costLitre(250)
        assertEquals(0.30, result)
    }

    // Test para la función descompteFN
    @Test
    fun testDescompteFN_MembresFamiliaZero_RetornaZero() {
        val result = descompteFN(0)
        assertEquals(0.0, result)
    }

    @Test
    fun testDescompteFN_MembresFamiliaCinco_RetornaCinquantaPerCent() {
        val result = descompteFN(5)
        assertEquals(0.5, result)
    }

    @Test
    fun testDescompteFN_MembresFamiliaDiez_RetornaCincPerCent() {
        val result = descompteFN(10)
        assertEquals(0.5, result)
    }

    // Test para la función total
    @Test
    fun testTotal_ValorsNegatius_RetornaZero() {
        val result = total(-10.0, -20.0, -30, -0.5, -0.3)
        assertEquals(0.0, result)
    }

    @Test
    fun testTotal_ValorsPositius_RetornaTotalCorrecte() {
        val result = total(20.0, 30.0, 150, 0.2, 0.0)
        assertEquals(40.0, result)
    }

    // Resto de las funciones con retorno...

}
