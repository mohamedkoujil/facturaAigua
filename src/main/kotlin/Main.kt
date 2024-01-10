fun main() {
    do {
        var quotaFixa = 6.0
        var quotaVariable = 0.0
        var descompteFN = 0.0
        var descompteBS = 0.0
        var menu = readInt(
            "Benvingut a la calculadora de factura d'aigua\n" +
                    "1. Calcular factura d'aigua\n" +
                    "2. Sortir\n",
            "Introdueixi un nombre vàlid",
            "Introdueixi una opció vàlida",
            1,
            2
        )
        if (menu == 2) break

        var consum = readInt(
            "Introdueixi el seu consum en litres\n",
            "Introdueixi un número",
            "Introdueixi un nombre vàlid",
            1,
            Int.MAX_VALUE
        )

        var costLitre = costLitre(consum)
        quotaVariable = costLitre * consum

        var descompte = readInt(
            "Posseeixes algun d'aquests titols?\n" +
                    YELLOW + "Recordatori: Si es tenen els 2 titols, només s'aplicarà el descompte del bo social\n" + RESET +
                    "1. Familia nombrosa o monoparental\n" +
                    "2. Bo Social\n" +
                    "3. Els 2\n" +
                    "4. No poseeixo cap tipus d'ajuda\n",
            "Introdueixi un numero",
            "Introdueixi un nombre valid",
            1,
            4
        )

        when (descompte) {
            1 -> {
                var membresFamilia = readInt("Membres de la familia", "Introdueixi un nombre", "Introdueixi un nombre valid", 1, 50)
                descompteFN = descompteFN(membresFamilia)
            }

            2 -> {
                descompteBS = 0.8
                quotaFixa = 3.0
            }
            //Si es tenen els 2 titols, només s'aplicarà el descompte del bo social
            3 -> {
                descompteBS = 0.8
                quotaFixa = 3.0
            }
        }
        factura(quotaFixa, quotaVariable, consum, descompteBS, descompteFN)
    }while (true)
}