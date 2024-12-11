package com.conversor.conversor_moneda.modelo;

import java.util.ArrayList;
import java.util.List;

public class Historial {

    private List<String> registros = new ArrayList<>();

    public void agregarRegistro(String registro) {
        registros.add(registro);
    }

    public void mostrarRegistros() {
        if (registros.isEmpty()) {
            System.out.println("No hay registros en el historial.");
        } else {
            for (String registro : registros) {
                System.out.println(registro);
            }
        }
    }
}
