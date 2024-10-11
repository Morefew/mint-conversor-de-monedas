package main;

import com.google.gson.Gson;
import modelo.Moneda;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

public class Main {


    static Scanner scanner = new Scanner(System.in);

    private static final String CONFIG_FILE = "config.properties";
    private static String apiKey;

    private static void loadAPIKey() {
        System.out.println("Intentando cargar el archivo de configuración...");
        try {
            InputStream input = Main.class.getClassLoader().getResourceAsStream(CONFIG_FILE);

            if (input == null) {
                System.out.println("No se encontró en el classpath, intentando cargar desde el sistema de archivos...");
                input = new FileInputStream(CONFIG_FILE);
            }

            Properties prop = new Properties();
            prop.load(input);
            apiKey = prop.getProperty("api_key");

            if (apiKey == null || apiKey.isEmpty()) {
                throw new IllegalStateException("La clave API no se encontró en config.properties");
            }

            System.out.println("Clave API cargada exitosamente");
        } catch (IOException e) {
            System.err.println("Error al cargar el archivo config.properties: " + e.getMessage());
            e.printStackTrace();
        } catch (IllegalStateException e) {
            System.err.println(e.getMessage());
        }
    }


    private static String menu() {
        System.out.println("=======================================================================");
        System.out.println(" ");
        System.out.println("|------------->              Bienvenidos a              <-------------|");
        System.out.println("|------------->                 M I N T                 <-------------|");
        System.out.println("|------------->          Conversor de Monedas           <-------------|");
        System.out.println(" ");
        System.out.println("=======================================================================");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Elige tu moneda a convertir");
        System.out.println("USD, EUR, GBP, CAD, AUD, CHF, JPY, MXN, CNY, RUB");
        System.out.println(" ");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Si ha terminado y desea cerrar la aplicación presione 'q'");
        System.out.println("-----------------------------------------------------------------------");
        return scanner.nextLine().toUpperCase();
    }


    public static void main(String[] args) {
        String flag = "C";


        do {
            loadAPIKey();

            if (apiKey == null || apiKey.isEmpty()) {
                System.err.println("No se pudo cargar la clave API. El programa no puede continuar.");
                return;
            }
            String fromCurrency = menu();
            try {
                URI url = URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" +
                        fromCurrency);

                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(url)
                        .build();

                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
                String json = response.body();
                Gson gson = new Gson();
                Moneda toCurrency = gson.fromJson(json, Moneda.class);
                Map<String, Double> conversionRates = toCurrency.getConversionRates();

                if (conversionRates == null || conversionRates.isEmpty()) {
                    System.out.println("Error: No se pudo obtener las tasas de conversión para " + fromCurrency);
                    fromCurrency = menu();
                    continue;
                }

                List<String> currencyCodes = new ArrayList<>(conversionRates.keySet());
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("Monedas disponibles para conversión:");
                System.out.println("-----------------------------------------------------------------------");
                for (int i = 0; i < currencyCodes.size(); i++) {
                    System.out.print(currencyCodes.get(i));
                    if (i < currencyCodes.size() - 1) {
                        System.out.print(", ");
                    }
                    if ((i + 1) % 10 == 0 || i == currencyCodes.size() - 1) {
                        System.out.println(" ");
                    }
                }
                System.out.println("-----------------------------------------------------------------------");
                System.out.println(" ");
                System.out.println("Codigo Moneda a Convertir: " + toCurrency.getBaseCode());
                System.out.println(" ");
                System.out.println("-----------------------------------------------------------------------");

                String convertToCurrency;
                while (true) {
                    System.out.println("Elija la moneda a la que quiere convertir: ");
                    convertToCurrency = scanner.nextLine().toUpperCase();
                    if (conversionRates.containsKey(convertToCurrency)) {
                        break;
                    } else {
                        System.out.println("Moneda no válida. Por favor, elija una moneda de la lista.");
                    }
                }

                double fromAmount;
                while (true) {
                    System.out.println("Ingrese la cantidad en " + fromCurrency + " a convertir: ");
                    try {
                        fromAmount = Double.parseDouble(scanner.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Cantidad no válida. Por favor, ingrese un número.");
                    }
                }

                double conversionRate = conversionRates.get(convertToCurrency);
                double total = fromAmount * conversionRate;

                System.out.println("-----------------------------------------------------------------------");
                System.out.println("-----------------------------------------------------------------------");
                System.out.println(" ");
                System.out.println(fromAmount + " " + fromCurrency + " se convertirá en " + convertToCurrency);
                System.out.println(" ");
                System.out.printf("Tasa de conversión: %.4f %s x %s%n", conversionRate, convertToCurrency, fromCurrency);
                System.out.println(" ");
                System.out.printf("La cantidad total es: %.2f %s%n", total, convertToCurrency);
                System.out.println(" ");
                System.out.println("-----------------------------------------------------------------------");

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Por favor, intente de nuevo.");
            }
            System.out.println("Desea... presione:");
            System.out.println("Continuar: C ");
            System.out.println("Terminar: T ");
            flag = scanner.nextLine().toUpperCase();

        }while(!flag.equals("T"));

        System.out.println("=======================================================================");
        System.out.println("");
        System.out.println("|------------->               Hasta luego               <-------------|");
        System.out.println("|------------->                 M I N T                 <-------------|");
        System.out.println("|------------->          Conversor de Monedas           <-------------|");
        System.out.println("");
        System.out.println("=======================================================================");
    }
}