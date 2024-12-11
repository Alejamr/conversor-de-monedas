package com.conversor.conversor_moneda.modelo;

import java.util.List;

public class Moneda {
    private final List<Moneda> monedasSoportadas = List.of(
            new Moneda("USD", "Dólar estadounidense", "$"),
            new Moneda("CLP", "Peso chileno", "CLP"),
            new Moneda("EUR", "Euro", "€"),
            new Moneda("BRL", "Real brasileño", "R$")
    );

    public Moneda(String usd, String dólarEstadounidense, String $) {
    }

    private void validarMoneda(String codigo) {
        boolean esValido = monedasSoportadas.stream()
                .anyMatch(moneda -> moneda.getCodigo().equals(codigo));

        if (!esValido) {
            throw new IllegalArgumentException("⚠ Moneda no soportada: " + codigo);
        }
    }

    private Object getCodigo() {
        return null;
    }
}