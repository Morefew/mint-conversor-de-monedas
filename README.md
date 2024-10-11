# Conversor de Monedas MINT 
## Descripción
El Conversor de Monedas MINT es una aplicación de línea de comandos desarrollada en Java que permite a los usuarios convertir entre diferentes monedas utilizando tasas de cambio en tiempo real. La aplicación utiliza la API de Exchange Rate para obtener las tasas de cambio más recientes y realizar conversiones precisas.

## Funcionalidades

- **Selección de moneda base:** El usuario puede elegir la moneda desde la cual desea convertir.

- **Visualización de monedas disponibles:** Muestra una lista de todas las monedas disponibles para la conversión.

- **Selección de moneda destino:** El usuario puede elegir la moneda a la que desea convertir.

- **Ingreso de cantidad:** Permite al usuario ingresar la cantidad que desea convertir.

- **Cálculo y visualización de resultados:** Muestra el resultado de la conversión, incluyendo la tasa de cambio utilizada.

- **Manejo de errores:** Proporciona mensajes de error claros para entradas inválidas o problemas de conexión.

## Ejemplos de Uso
### Inicio de la aplicación

````
=======================================================================

|------------->              Bienvenidos a              <-------------|
|------------->                 M I N T                 <-------------|
|------------->          Conversor de Monedas           <-------------|

=======================================================================
-----------------------------------------------------------------------
Elige tu moneda a convertir
USD, EUR, GBP, CAD, AUD, CHF, JPY, MXN, CNY, RUB
 
-----------------------------------------------------------------------
Si ha terminado y desea cerrar la aplicación presione 'q'
-----------------------------------------------------------------------
````

### Selección de moneda base

````
USD
-----------------------------------------------------------------------
Monedas disponibles para conversión:
-----------------------------------------------------------------------
AED, AFN, ALL, AMD, ANG, AOA, ARS, AUD, AWG, AZN, BAM, BBD, BDT, BGN, 
BHD, BIF, BMD, BND, BOB, BRL, BSD, BTN, BWP, BYN, BZD, CAD, CDF, CHF, 
CLP, CNY, COP, CRC, CUP, CVE, CZK, DJF, DKK, DOP, DZD, EGP, ERN, ETB, 
EUR, FJD, FKP, FOK, GBP, GEL, GGP, GHS, GIP, GMD, GNF, GTQ, GYD, HKD, 
HNL, HRK, HTG, HUF, IDR, ILS, IMP, INR, IQD, IRR, ISK, JEP, JMD, JOD, 
JPY, KES, KGS, KHR, KID, KMF, KRW, KWD, KYD, KZT, LAK, LBP, LKR, LRD, 
LSL, LYD, MAD, MDL, MGA, MKD, MMK, MNT, MOP, MRU, MUR, MVR, MWK, MXN, 
MYR, MZN, NAD, NGN, NIO, NOK, NPR, NZD, OMR, PAB, PEN, PGK, PHP, PKR, 
PLN, PYG, QAR, RON, RSD, RUB, RWF, SAR, SBD, SCR, SDG, SEK, SGD, SHP, 
SLE, SOS, SRD, SSP, STN, SYP, SZL, THB, TJS, TMT, TND, TOP, TRY, TTD, 
TVD, TWD, TZS, UAH, UGX, UYU, UZS, VES, VND, VUV, WST, XAF, XCD, XDR, 
XOF, XPF, YER, ZAR, ZMW, ZWL
-----------------------------------------------------------------------
 
Codigo Moneda a Convertir: USD
 
-----------------------------------------------------------------------
Elija la moneda a la que quiere convertir:
````
Selección de moneda destino y cantidad

````
EUR
Ingrese la cantidad en USD a convertir: 
100
-----------------------------------------------------------------------
-----------------------------------------------------------------------
 
100.0 USD se convertirá en EUR
 
Tasa de conversión: 0.9163 EUR x USD
 
La cantidad total es: 91.63 EUR
 
-----------------------------------------------------------------------
````

Finalización de la aplicación

````
q
=======================================================================

|------------->               Hasta luego               <-------------|
|------------->                 M I N T                 <-------------|
|------------->          Conversor de Monedas           <-------------|

=======================================================================
````

## Cómo ejecutar la aplicación
Para ejecutar la aplicación después de descargar el código, sigue estos pasos:

1. Asegúrate de tener Java instalado en tu sistema (se recomienda Java 17 o superior).
2. Clona o descarga el repositorio del proyecto.
3. Navega hasta el directorio del proyecto en tu terminal.
4. Crea un archivo `config.properties` en la carpeta `src/main/resources/` (o en la carpeta de recursos de tu proyecto) con el siguiente contenido:
````
api.key=tu_clave_api_aquí
````
Reemplaza tu_clave_api_aquí con tu clave API real de Exchange Rate API.

5. Compila el proyecto. Si estás usando un IDE como IntelliJ IDEA, puedes usar la opción de compilación del IDE. Si estás usando la línea de comandos, puedes usar:
````
javac -d out src/main/java/main/*.java
````
6.  Ejecuta la applicacion
````
java -cp out main.Main
````
Nota: Asegúrate de que el archivo ```config.properties``` esté en la carpeta

¡Disfruta usando el Conversor de Monedas MINT!
