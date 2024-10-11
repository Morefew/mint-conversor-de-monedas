package modelo;

import java.util.Map;

/**
 * Class that represents a Moneda
 *
 * project AluraConversorMoneda
 *
 * @author Lenny Gonzalez
 * Correo badil17@yahoo.com
 * @Version 1.0.0.0
 * @since 10/11/2024
 */
public class Moneda {
    private String result;
    private String base_code;
    private Map<String, Double> conversion_rates;

    // Constructor
    public Moneda() {
    }

    // Getters and setters
    public String getResult() {
        return result;
    }

    public String getBaseCode() {
        return base_code;
    }

    public Map<String, Double> getConversionRates() {
        return conversion_rates;
    }