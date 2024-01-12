
# Factura Aigua

Aquesta aplicacio agafa dades de l'usuari per crear una factura del seu consum. Les factures es guarden per tenir un historial i consultar aquestes les vegades que facis falta



## Contingut

- [Funcionalitats](#funcionalitats)
- [Entrada de dades](#entradaDades)
- [Screenshots Codi](#screenshotCodi)
- [Running tests](#tests)

## Funcionalitats
<a id="funcionalitats" />

Aquestes funcions estan ubicades al fitxer [Functions.](/src/main/kotlin/Functions.kt) 

Aquesta aplicació calcula el preu [total](#total) de la factura mitjançant la quota fixa (valor personalitzable), la quota variable i els diferents descomptes.

Les factures que es generen es guarden en l'historial per poder visulitzarles després

### Quota variable

La quota variable es cualcula depenent del preu del litre i el consum de l'usuari. El preu per litre es pot personalitzar en la funció [costLitre](#costLitre)

### Descomptes

Si l'usuari disposa de familia nombrosa o monoparental es fa un [descompte](#descompteFN) a la quota variable del 10% per cada familiar. Si disposa de bo social, es fa un descompte del 80%, i a més, la quota fixa es redueix a 3€(personalitzable). Cal reacalcar que si l'usuari disposta de tots 2, només s'aplicará el descompte del bo social

## Entrada de dades
<a id="entradaDades" />

L'archiu [Utilites](/src/main/kotlin/Utilities.kt) comprova que l'entrada de dades és la correcte, per tant l'aplicació no fallarà si l'usuari introdueix una opció equivocada

## Screenshots Codi
<a id="screenshotCodi" />

- fun costLitre <a id="costLitre" />
  
  ![image](https://github.com/mohamedkoujil/facturaAigua/assets/74406781/0b65fb9b-8932-4507-8c8e-b154ad96ee73)
  
- fun descompteFN <a id="descompteFN" />
  
  ![image](https://github.com/mohamedkoujil/facturaAigua/assets/74406781/60be9201-eab3-436b-8ef9-466e059e573f)

- fun total <a id="total" />
- 
  ![image](https://github.com/mohamedkoujil/facturaAigua/assets/74406781/e254a0c4-875d-4f70-8a74-b98a2f9571ae)


- fun historialFactures <a id="historialFactures" />

  ![image](https://github.com/mohamedkoujil/facturaAigua/assets/74406781/4b153e41-76f2-4843-9a60-90d79382d736)

- fun veureHistorial <a id="veureHistorial" />
  
  ![image](https://github.com/mohamedkoujil/facturaAigua/assets/74406781/8d80c56a-5879-4d26-b26e-26abbb81d15d)

- fun facturaSeleccionada <a id="facturaSeleccionada" />
  
  ![image](https://github.com/mohamedkoujil/facturaAigua/assets/74406781/47a986bd-d81d-421c-80ec-c1eeba94f23e)

## Tests 
<a id="tests" />
Tots els tests estan en aquest [fitxer](/src/test/kotlin/functionTests.kt)

