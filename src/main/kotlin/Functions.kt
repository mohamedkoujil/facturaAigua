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
fun descompteFM (): Double {
    var membresFamilia = readInt("Membres de la familia", "Introdueixi un nombre")
    var descompteFM: Double = (10*membresFamilia)/100.0
    return descompteFM
}

/**
 * Aquesta funció rep la quota fixa, la quota variable, el consum, el descompte del bo social i el descompte de familia nombrosa o monoparental i imprimeix la factura amb els descomptes aplicats i el total a pagar
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
    var total = totalSenseDescomptes - descomptes


    println("Quota fixa: $quotaFixa")
    println("Consum: $consum L")
    println("Total Brut: %.2f€".format(totalSenseDescomptes))
    println("Descompte FN: ${descompteFN*100}%\n" +
            "Descompte BS: ${descompteBS*100}%")
    println("Total: %.2f€".format(total))
}

