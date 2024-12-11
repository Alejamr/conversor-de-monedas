package com.conversor.conversor_moneda;

import com.conversor.conversor_moneda.modelo.Historial;
import com.conversor.conversor_moneda.servicio.ConversorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication
public class Principal implements CommandLineRunner {

    private static final Scanner entradaUsuario = new Scanner(System.in);

    @Autowired
    private ConversorService conversorService;

    private static final Historial historial = new Historial();

    public static void main(String[] args) {
        SpringApplication.run(Principal.class, args);
    }

    // Este método se ejecuta automáticamente después de que la aplicación se inicia
    @Override
    public void run(String... args) {
        boolean continuar = true;

        while (continuar) {
            try {
                mostrarMenu();
                int opcion = leerOpcionUsuario();

                if (opcion == 0) {
                    mostrarHistorial();
                } else if (opcion == 9) {
                    despedirUsuario();
                    continuar = false;
                } else {
                    procesarConversion(opcion);
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠ Entrada no válida. Por favor, ingrese un número válido.");
            } catch (IOException e) {
                System.out.println("⚠ Error al guardar el historial. Intente nuevamente.");
            } catch (Exception e) {
                System.out.println("⚠ Ocurrió un error inesperado: " + e.getMessage());
            }
        }
    }

    private void mostrarMenu() {
        System.out.println("**********************************************\n"
                + "**** Bienvenido/a al conversor de monedas ****\n"
                + "******************* MENU *********************\n"
                + "* 1.- Dólar (USD) a Peso Chileno (CLP)       *\n"
                + "* 2.- Peso Chileno a Dólar                   *\n"
                + "* 3.- Euro (EUR) a Peso Chileno (CLP)        *\n"
                + "* 4.- Peso Chileno a Euro (EUR)              *\n"
                + "* 5.- Real Brasileño (BRL) a Peso Chileno    *\n"
                + "* 6.- Peso Chileno a Real Brasileño (BRL)    *\n"
                + "* 0.- Ver historial                          *\n"
                + "* 9.- Salir                                  *\n"
                + "**********************************************");
    }

    private int leerOpcionUsuario() {
        System.out.print("Seleccione una opción: ");
        return Integer.parseInt(entradaUsuario.nextLine());
    }

    private void procesarConversion(int opcion) throws IOException {
        try {
            System.out.print("Ingrese el monto a convertir: ");
            double monto = Double.parseDouble(entradaUsuario.nextLine());

            String resultado;
            switch (opcion) {
                case 1:
                    resultado = conversorService.convertir("USD", "CLP", monto);
                    break;
                case 2:
                    resultado = conversorService.convertir("CLP", "USD", monto);
                    break;
                case 3:
                    resultado = conversorService.convertir("EUR", "CLP", monto);
                    break;
                case 4:
                    resultado = conversorService.convertir("CLP", "EUR", monto);
                    break;
                case 5:
                    resultado = conversorService.convertir("BRL", "CLP", monto);
                    break;
                case 6:
                    resultado = conversorService.convertir("CLP", "BRL", monto);
                    break;
                default:
                    resultado = "Opción no válida";
                    break;
            }

            System.out.println("Resultado: " + resultado);
            historial.agregarRegistro(resultado);
        } catch (NumberFormatException e) {
            System.out.println("⚠ Monto no válido. Por favor, ingrese un número válido.");
        }
    }

    private void mostrarHistorial() {
        System.out.println("**** Historial de Conversiones ****");
        historial.mostrarRegistros();
    }

    private void despedirUsuario() {
        System.out.println("Gracias por usar el conversor de monedas. ¡Hasta luego!");
    }
}
