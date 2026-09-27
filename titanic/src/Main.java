package src;
import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TitanicService servicio = null;
        try {
            servicio = new TitanicService("data/Titanic.txt");
        }
        catch (IOException e) {
            System.out.println("Error procesando el archivo: " + e.getMessage());
            return;
        }
        int opcion;
        do {
            System.out.println("¡Hola, encargado de los datos del Titanic!");
            System.out.println("Ingrese su número de opción: ");
            System.out.println("1. Mostrar pasajeros de una clase");
            System.out.println("2. Mostrar mujeres sobrevivientes de una clase");
            System.out.println("3. Mostrar mujeres no sobrevivientes de una clase");
            System.out.println("4. Mostrar hombres sobrevivientes de una clase");
            System.out.println("5. Mostrar hombres no sobrevivientes de una clase");
            System.out.println("0. Para salir del programa");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpieza de buffer
            try {
                if (opcion >= 1 && opcion <= 5) {
                    String clase = pedirClase(sc);
                    if (clase == null) {
                        System.out.println("Clase no válida.");
                    }
                    else if (opcion == 1) {
                        servicio.imprimirPorClase(clase);
                    }
                    else if (opcion == 2) {
                        servicio.mujeresSobrevivientes(clase);
                    }
                    else if (opcion == 3) {
                        servicio.mujeresNoSobrevivientes(clase);
                    }
                    else if (opcion == 4) {
                        servicio.hombresSobrevivientes(clase);
                    }
                    else if (opcion == 5) {
                        servicio.hombresNoSobrevivientes(clase);
                    }
                }
                else if (opcion == 0) {
                    System.out.println("¡Gracias por usar el sistema de datos del Titanic!");
                }
                else {
                    System.out.println("Opción no valida.");
                }
            }
            catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (opcion != 0);
        sc.close();
    }
    private static String pedirClase(Scanner sc) {
        System.out.println("¿De que clase desea consultar?");
        System.out.println("1. Primera clase");
        System.out.println("2. Segunda clase");
        System.out.println("3. Tercera clase");
        System.out.print("Opción: ");
        int claseOpcion = sc.nextInt();
        sc.nextLine(); // Limpieza de buffer
        if (claseOpcion == 1) {
            return "1st";
        }
        else if (claseOpcion == 2) {
            return "2nd";
        }
        else if (claseOpcion == 3) {
            return "3rd";
        }
        else {
            return null;
        }
    }
}