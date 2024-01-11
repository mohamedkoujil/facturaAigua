import java.util.concurrent.TimeUnit
fun main() {
    var historial: MutableList<Array<Double>> = mutableListOf()
    var contFactures = 0
    do {
        var quotaFixa = 6.0
        var quotaVariable = 0.0
        var descompteFN = 0.0
        var descompteBS = 0.0

        var menu: Int
        //Es mostra el menu fins que es trii la opció 1
        do {
            menu = readInt(
                "Benvingut a la calculadora de factura d'aigua\n" +
                        "1. Calcular factura d'aigua\n" +
                        "2. Historial de factures\n" +
                        "3. Sortir",
                "Introdueixi un nombre vàlid",
                "Introdueixi una opció vàlida",
                1,
                3
            )

            when (menu) {
                2 -> {
                    if (historial.isEmpty()) {
                        println(RED + "No hi ha cap factura en l'historial" + RESET)
                        TimeUnit.SECONDS.sleep(2)
                    } else {
                        veureHistorial(historial)
                    }
                }
                1 -> break
            }
        } while (menu != 3)

        //Si es tria la opció 3, es surt del programa
        if (menu == 3) break

        var consum = readInt(
            "Introdueixi el seu consum en litres",
            "Introdueixi un número",
            "Introdueixi un nombre vàlid",
            1,
            Int.MAX_VALUE
        )

        //Es calcula el cost per litre i la quota variable
        var costLitre = costLitre(consum)
        quotaVariable = costLitre * consum

        //Es pregunta si es posseeix algun dels titols
        var descompte = readInt(
            "Posseeixes algun d'aquests titols?\n" +
                    YELLOW + "Recordatori: Si es tenen els 2 titols, només s'aplicarà el descompte del bo social\n" + RESET +
                    "1. Familia nombrosa o monoparental\n" +
                    "2. Bo Social\n" +
                    "3. Els 2\n" +
                    "4. No poseeixo cap tipus d'ajuda",
            "Introdueixi un numero",
            "Introdueixi un nombre valid",
            1,
            4
        )

        //Es calcula el descompte depenent dels titols que es posseeixen
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
        TimeUnit.SECONDS.sleep(2)
        historial.add(historialFactures(quotaFixa, quotaVariable, consum, descompteBS, descompteFN, contFactures))
        contFactures++

    }while (true)

}