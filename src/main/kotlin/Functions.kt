fun costLitre (consum: Int): Double {
    var costLitre = 0.0
    costLitre = when (consum) {
        in 0..<50 -> 0.0
        in 50..200 -> 0.15
        else -> 0.30
    }
    return costLitre
}

fun descompteFM (): Double {
    var membresFamilia = readInt("Membres de la familia", "Introdueixi un nombre")
    var descompteFM: Double = (10*membresFamilia)/100.0
    return descompteFM
}
A


