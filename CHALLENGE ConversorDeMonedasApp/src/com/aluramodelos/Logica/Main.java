package com.aluramodelos.Logica;

import java.util.Scanner;
import com.aluramodelos.Persistencia.ConectarConApi;
import java.io.IOException;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura = new Scanner(System.in);
        int eleccion = 0;
        String base = "";
        String target = "";

        while (eleccion != 7) {
            System.out.println("*************************************************");

            String menu = """
                    \nSea Bienvenido(a) al conversor de moneda:
                    
                    1) Dólar ==> Peso Argentino
                    2)Peso Argentino ==> Dólar
                    3) Dólar ==> Real Brasileño
                    4) Real Brasileño ==> Dólar
                    5) Dólar ==> Peso Colombiano
                    6) Peso Colombiano ==> Dólar
                    7) Salir
                    Elíge una opcion valída:
                    """;
            System.out.println(menu);
            try {
                eleccion = Integer.parseInt(lectura.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número del 1 al 7.");
                continue;
            }

            System.out.println("\n*******************************************************");


            switch (eleccion) {
                case 1 -> {base = "USD";target = "ARS";}
                case 2 -> {base = "ARS";target = "USD";}
                case 3 -> {base = "USD";target = "BRL";}
                case 4 -> {base = "BRL";target = "USD";}
                case 5 -> {base = "USD";target = "COP";}
                case 6 -> {base = "COP";target = "USD";}
                case 7 -> {
                    System.out.println("Muchas gracias por utilizar nuestro servicio, ¡Vuelva pronto!");
                break;
                }
                default -> {
                    System.out.println("Opción no válida, por favor elige una opción del 1 al 7.");
                    continue;
                }
            }

            if (eleccion <= 6 && eleccion >= 1) {
                System.out.println("Ingrese el monto a convertir: $ ");

                double monto = 0;
                try {
                    monto = Double.parseDouble(lectura.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Entrada no válida. Por favor, ingrese un número válido para el monto.");
                    continue;
                }

                Cotizacion cotizacion = ConectarConApi.obtenerCotizacion(base, target);
                double montoConvertido = monto * cotizacion.getConversionDeMoneda();
                cotizacion.setMontoConvertido(montoConvertido);

                System.out.println("\nMonto original: " + monto + " " + base);
                cotizacion.muestraCotizacion();
                System.out.println("Monto convertido: " + montoConvertido + " " + target);

            }
        }
    }
}