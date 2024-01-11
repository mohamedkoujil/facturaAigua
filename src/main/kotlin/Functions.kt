import java.util.concurrent.TimeUnit
/**
 * Aquesta funció rep el consum i retorna el cost per litre segons el consum
 * @author mohamedkoujil
 * @since 10/01/2023
 * @param consum Quantitat de litres consumits
 * @return Cost per litre segons el consum
 */
fun costLitre (consum: Int): Double {
    var costLitre = 0.0
    costLitre = when (consum) {
        in 0..<50 -> 0.0
        in 50..200 -> 0.15
        else -> 0.30
    }
    return costLitre
}

/**
 * Aquesta funció calula el descompte de familia nombrosa o monoparental segons el nombre de membres de la familia
 * @author mohamedkoujil
 * @since 10/01/2023
 * @return Descompte de familia nombrosa o monoparental
 */
fun descompteFN (membresFamilia: Int): Double {
    var descompteFM: Double = (10*membresFamilia)/100.0
    if (descompteFM > 0.5) descompteFM = 0.5
    return descompteFM
}

fun total (quotaFixa: Double, quotaVariable: Double, consum: Int, descompteBS: Double, descompteFN: Double): Double {
    var totalSenseDescomptes = quotaVariable+quotaFixa
    var descomptes = (totalSenseDescomptes*descompteFN) + (totalSenseDescomptes*descompteBS)
    var total = totalSenseDescomptes - descomptes
    return total
}

/**
 * Aquesta funció rep la quota fixa, la quota variable, el consum, el descompte del bo social i el descompte de familia nombrosa o monoparental i imprimeix la factura amb els descomptes aplicats i el total a pagar
 * @author mohamedkoujil
 * @since 10/01/2023
 * @param quotaFixa Quota fixa
 * @param quotaVariable Quota variable
 * @param consum Consum
 * @param descompteBS Descompte del bo social
 * @param descompteFN Descompte de familia nombrosa o monoparental
 * @return Factura amb els descomptes aplicats i el total a pagar
 */
fun factura (quotaFixa: Double, quotaVariable: Double, consum: Int, descompteBS: Double, descompteFN: Double) {
    var totalSenseDescomptes = quotaVariable+quotaFixa
    var descomptes = (totalSenseDescomptes*descompteFN) + (totalSenseDescomptes*descompteBS)

    println("           FACTURA")
    println("---------------------------")
    println("- Quota fixa:        ${formatMoneda(quotaFixa)}")
    println("- Quota variable:    ${formatMoneda(quotaVariable)}")
    println("- Consum:            $consum L")
    println("- Total Brut:        ${formatMoneda(totalSenseDescomptes)}")
    println("- Descompte FN:      ${formatPercentage(descompteFN)}")
    println("- Descompte BS:      ${formatPercentage(descompteBS)}")
    println("                     ------")
    println("- TOTAL:             ${formatMoneda(total(quotaFixa, quotaVariable, consum, descompteBS, descompteFN))}")
}

/**
 * Aquesta funció formata un nombre al format de moneda
 * @author mohamedkoujil
 * @since 10/01/2023
 * @param amount Quantitat a transformar
 * @return Quantitat amb el format de moneda
 */
fun formatMoneda(amount: Double): String {
    return "%.2f€".format(amount)
}

/**
 * Aquesta funció formata un nombre amb al format de percentatge
 * @author mohamedkoujil
 * @since 10/01/2023
 * @param percentage Quantitat a transformar
 * @return Quantitat amb el format de percentatge
 */
fun formatPercentage(percentage: Double): String {
    return "${(percentage * 100)}%"
}

/**
 * Aquesta funcio converteix les dades de l'usuari en un array
 * @author mohamedkoujil
 * @since 11/01/2023
 * @param quotaFixa Quota fixa
 * @param quotaVariable Quota variable
 * @param consum Consum
 * @param descompteBS Descompte del bo social
 * @param descompteFN Descompte de familia nombrosa o monoparental
 * @param contFactures Contador de factures
 * @return Array amb les dades de la factura
 */
fun historialFactures(quotaFixa: Double, quotaVariable: Double, consum: Int, descompteBS: Double, descompteFN: Double, contFactures: Int): Array<Double> {
    var totalSenseDescomptes = quotaVariable + quotaFixa
    var descomptes = (totalSenseDescomptes * descompteFN) + (totalSenseDescomptes * descompteBS)
    var total = totalSenseDescomptes - descomptes

    var novaFactura = arrayOf(
        contFactures.toDouble(),
        quotaFixa,
        quotaVariable,
        consum.toDouble(),
        totalSenseDescomptes,
        descompteFN,
        descompteBS,
        total)
    return novaFactura
}

/**
 * Aquesta funcio imprimeix la factura segons la factura seleccionada per l'usuari en l'historial de factures
 * @author mohamedkoujil
 * @since 11/01/2023
 * @param historialFactures Historial de factures
 * @param facturaUsr Factura seleccionada per l'usuari
 */
fun facturaEnHistorialUsr (historialFactures: MutableList<Array<Double>>, facturaUsr: Int) {
    var factura = facturaUsr-1
    println("           FACTURA")
    println("---------------------------")
    println("- Quota fixa:        ${formatMoneda(historialFactures[factura][1])}")
    println("- Quota variable:    ${formatMoneda(historialFactures[factura][2])}")
    println("- Consum:            ${historialFactures[factura][3].toInt()} L")
    println("- Total Brut:        ${formatMoneda(historialFactures[factura][4])}")
    println("- Descompte FN:      ${formatPercentage(historialFactures[factura][5])}")
    println("- Descompte BS:      ${formatPercentage(historialFactures[factura][6])}")
    println("                     ------")
    println("- TOTAL:             ${formatMoneda(historialFactures[factura][7])}")
    println("---------------------------")
}

/**
 * Aquesta funcio imprimeix l'historial de factures i permet seleccionar una factura per veure-la amb més detall o tornar al menu principal si no hi ha cap factura en l'historial de factures
 * @author mohamedkoujil
 * @since 11/01/2023
 * @param historialFactures Historial de factures
 */
fun veureHistorial(historialFactures: MutableList<Array<Double>>) {
    if (historialFactures.isEmpty()) {
        println(RED + "No hi ha cap factura en l'historial" + RESET)
        TimeUnit.SECONDS.sleep(2)
    } else {
        do {
            var facturaUsr = readInt(
                "Seleccioni una opció:\n" +
                buildString {
                    for (i in historialFactures.indices) {
                        append("${i + 1}. Factura num: ${i + 1}\n")
                    }
                } +
                        "${historialFactures.lastIndex + 2}. Tornar al menu",
                "Introdueixi un número",
                "Factura no existent",
                1,
                historialFactures.lastIndex + 2
            )
            if (facturaUsr == historialFactures.lastIndex + 2) break
            facturaEnHistorialUsr(historialFactures, facturaUsr)
            TimeUnit.SECONDS.sleep(2)
        } while (true)
    }
}



