package com.marylin.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static List<Municipio> municipios = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Bienvenidos a INETER \n");
            System.out.println("Ingrese una opción:");
            System.out.println("1. Agregar municipio");
            System.out.println("2. Mostrar municipios");
            System.out.println("3. Salir");

            int opcionMun = Integer.parseInt(leer.readLine());

            switch (opcionMun) {
                case 1:
                    Municipio municipio = crearMunicipio(scanner);
                    int opcionMenuSuceso = menuSuceso();
                    Suceso suceso = null;
                    switch (opcionMenuSuceso) {
                        case 1:
                            int opcionSucesoInterno = menuSucesoInterno();
                            if (opcionSucesoInterno == 1) {
                                suceso = crearLluvia(scanner);
                            } else if (opcionSucesoInterno == 2) {
                                suceso = crearTemblor(scanner);
                            }
                            break;
                        case 2:
                            mostrarMunicipios();
                            break;
                        default:
                            System.out.println("Opción inválida. No se agregarán sucesos.");
                            break;
                    }
                    // Agregar suceso al municipio y municipio a la lista de municipios
                    if (suceso != null) {
                        municipio.agregarSuceso(suceso);
                    }
                    municipios.add(municipio);
                    break;
                case 2:
                    // Mostrar municipios y sus sucesos
                    System.out.println("Mostrando los municipios y sus sucesos:");
                    for (Municipio mun : municipios) {
                        System.out.println(mun);
                        mun.mostrarSucesos();
                    }
                    break;
                case 3:
                    // Salir
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione 1, 2 o 3.");
                    break;
            }

        }
    }

    private static Municipio crearMunicipio(Scanner scanner) {
        System.out.println("Ingrese el nombre del municipio:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese la extensión territorial del municipio:");
        double extensionTerritorial = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea

        return new Municipio(nombre, extensionTerritorial);
    }

    private static void mostrarMunicipios() {
        if (municipios.isEmpty()) {
            System.out.println("No hay municipios para mostrar.");
            return;
        }

        for (int i = 0; i < municipios.size(); i++) {
            System.out.println((i + 1) + ". " + municipios.get(i));
        }
    }

    // private static void mostrarMenuEliminarSuceso(Municipio municipio, Scanner scanner) {
    //     while (true) {
    //         System.out.println("=== Menú Eliminar Suceso ===");
    //         System.out.println("Municipio: " + municipio.getNombre());
    //         System.out.println("Seleccione el suceso que desea eliminar:");
    //         municipio.mostrarSucesos();
    //         System.out.println("0. Volver al menú anterior");

    //         int opcion = scanner.nextInt();
    //         scanner.nextLine(); // Limpiar el buffer de entrada

    //         if (opcion == 0) {
    //             System.out.println("Volviendo al menú anterior...");
    //             break;
    //         } else if (opcion > 0 && opcion <= municipio.mostrarSucesos().size()) {
    //             municipio.eliminarSuceso(opcion - 1); // El índice en la lista es opcion - 1
    //         } else {
    //             System.out.println("Opción inválida. Intente de nuevo.");
    //         }
    //     }
    // }

    private static int menuSuceso() {
        Scanner leer = new Scanner(System.in);
        int opcionSeleccionada = 0;
        System.out.println("Desea agregar un suceso:");
        System.out.println("1. Si");
        System.out.println("2. No");
        System.out.println("3. Salir");
        try {
            opcionSeleccionada = leer.nextInt();
        } catch (Exception e) {
            System.out.println("Opción inválida");
        }
        return opcionSeleccionada;
    }

    private static int menuSucesoInterno() {
        Scanner leer = new Scanner(System.in);
        int opcionSeleccionada = 0;
        System.out.println("Seleccione el tipo de suceso:");
        System.out.println("1. Lluvia");
        System.out.println("2. Temblor");
        System.out.println("3. Salir");
        try {
            opcionSeleccionada = leer.nextInt();
        } catch (Exception e) {
            System.out.println("Opción inválida");
        }
        return opcionSeleccionada;
    }

    private static Lluvia crearLluvia(Scanner scanner) {
        System.out.println("Ingrese los milímetros de lluvia por hora:");
        int milimetros = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.println("Ingrese el tipo de lluvia (tormenta, normal, brisa):");
        String tipoLluvia = scanner.nextLine();
        return new Lluvia(milimetros, tipoLluvia, LocalDateTime.now(), Duration.ofHours(1));
    }

    private static Temblor crearTemblor(Scanner scanner) {
        System.out.println("Ingrese la latitud del temblor:");
        int latitud = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.println("Ingrese la longitud del temblor:");
        int longitud = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.println("Ingrese el valor de la escala de Richter:");
        float escalaRichter = scanner.nextFloat();
        scanner.nextLine(); // Consumir el salto de línea
        return new Temblor(latitud, longitud, escalaRichter, LocalDateTime.now(), Duration.ofMinutes(30));
    }
}
