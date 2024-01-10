fun main() {
    var quotaFixa = 6.0
    var quotaVariable = 0.0
    var descompteFN = 0.0
    var descompteBS = 0.0
    var consum = readInt("Introdueixi el seu consum d'aigua",
                        "Introdueixi un número",
                        "Introdueixi un nombre vàlid",
                        1,
                        Int.MAX_VALUE)

    var costLitre = costLitre(consum)
    quotaVariable = costLitre*consum

    var descompte = readInt("Posseeixes algun d'aquests titols?\n" +
            YELLOW + "Recordatori: Si es tenen els 2 titols, només s'aplicarà el descompte del bo social\n" + RESET +
            "1. Familia nombrosa o monoparental\n" +
            "2. Bo Social\n" +
            "3. Els 2\n" +
            "4. No poseeixo cap tipus d'ajuda\n",
        "Introdueixi un numero",
        "Introdueixi un nombre valid",
        1,
        4)

    when (descompte) {
        1 -> descompteFN = descompteFM()
        2 -> {
            descompteBS = 0.8
            quotaFixa = 3.0
        }
        3 -> {
            descompteBS = 0.8
            quotaFixa = 3.0
        }
    }

}