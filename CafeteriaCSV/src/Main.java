import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ServicioVentas servicio = null;
        try {
            servicio = new ServicioVentas("data/Coffe_sales.csv");
        }
        catch (Exception e) {
            System.out.println("Error al cargar el archivo: " + e.getMessage());
            return;
        }
        int opcion;
        do {
            System.out.println("¡Hola, encargado de ventas de café!");
            System.out.println("Ingrese su número de opción: ");
            System.out.println("1. Total de registros");
            System.out.println("2. Mostrar primeros 10 registros");
            System.out.println("3. Ejemplo Comparator (ordenar por dinero)");
            System.out.println("4. Ejemplo Consumer");
            System.out.println("5. Ejemplo Predicate (ventas > 35)");
            System.out.println("6. Ejemplo Function (descripción de venta)");
            System.out.println("7. Ejemplo BiFunction (reporte)");
            System.out.println("8. Cafés distintos");
            System.out.println("9. Filtrar solo Latte");
            System.out.println("10. Map a mayúsculas");
            System.out.println("11. Promedio de ventas");
            System.out.println("12. Estadísticas (total, máximo, mínimo)");
            System.out.println("13. Top cafés más vendidos");
            System.out.println("14. Generar reporte (archivo .txt)");
            System.out.println("15. Ventas en la mañana (Morning)");
            System.out.println("16. Ventas por franja horaria");
            System.out.println("17. Ordenar por jornada");
            System.out.println("0. Para salir del programa");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpieza de buffer
            try {
                if (opcion == 1) {
                    servicio.totalRegistros();
                }

                else if (opcion == 2) {
                    servicio.mostrarPrimeros10();
                }

                else if (opcion == 3) {
                    servicio.ejemploComparator();
                }

                else if (opcion == 4) {
                    servicio.ejemploConsumer();
                }

                else if (opcion == 5) {
                    servicio.ejemploPredicate();
                }

                else if (opcion == 6) {
                    servicio.ejemploFunction();
                }

                else if (opcion == 7) {
                    servicio.ejemploBiFunction();
                }

                else if (opcion == 8) {
                    servicio.cafesDistintos();
                }

                else if (opcion == 9) {
                    servicio.filtroLatte();
                }

                else if (opcion == 10) {
                    servicio.mapMayusculas();
                }

                else if (opcion == 11) {
                    servicio.promedioVentas();
                }

                else if (opcion == 12) {
                    servicio.estadisticas();
                }

                else if (opcion == 13) {
                    servicio.topCafesVendidos();
                }

                else if (opcion == 14) {
                    servicio.generarReporte();
                }

                else if (opcion == 15) {
                    servicio.obtenerVentasdia();
                }

                else if (opcion == 16) {
                    servicio.obtenerVentasFranja();
                }

                else if (opcion == 17) {
                    servicio.ordenarPorJornada();
                }

                else if (opcion == 0) {
                    System.out.println("¡Gracias por usar el sistema de ventas de café!");
                }

                else {
                    System.out.println("Opción no válida.");
                }
            }
            catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (opcion != 0);

        sc.close();
    }
}