import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ServicioEmpleos servicio = null;
        try {
            servicio = new ServicioEmpleos("data/job_salary_prediction_dataset.csv");
        }
        catch (Exception e) {
            System.out.println("Error al cargar el archivo: " + e.getMessage());
            return;
        }
        int opcion;

        do {
            System.out.println("¡Hola, encargado de empleos y salarios!");
            System.out.println("Ingrese su número de opción: ");
            System.out.println("1. Total de registros");
            System.out.println("2. Mostrar primeros 10 registros");
            System.out.println("3. Ordenar por salario (descendente)");
            System.out.println("4. Ordenar por experiencia y salario");
            System.out.println("5. Mostrar cargo y salario de cada empleo");
            System.out.println("6. Filtrar empleos con salario mayor a 120000");
            System.out.println("7. Filtrar empleos remotos");
            System.out.println("8. Filtrar empleos remotos con salario mayor a 120000");
            System.out.println("9. Mostrar una descripción de cada empleo");
            System.out.println("10. Mostrar reporte de puesto y salario ofrecido");
            System.out.println("11. Cargos distintos");
            System.out.println("12. Industrias distintas");
            System.out.println("13. Filtrar industria Technology");
            System.out.println("14. Mostrar cargos en mayúsculas");
            System.out.println("15. Salario promedio");
            System.out.println("16. Estadísticas de salario (total, máximo, mínimo)");
            System.out.println("17. Empleos por nivel educativo");
            System.out.println("18. Top 5 industrias con más empleos");
            System.out.println("19. Top 10 cargos más frecuentes");
            System.out.println("20. Generar reporte (archivo .txt)");
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
                    servicio.ordenarPorSalario();
                }
                else if (opcion == 4) {
                    servicio.ordenarPorExperiencia();
                }
                else if (opcion == 5) {
                    servicio.ejemploConsumer();
                }
                else if (opcion == 6) {
                    servicio.ejemploPredicateSalario();
                }
                else if (opcion == 7) {
                    servicio.ejemploPredicateRemoto();
                }
                else if (opcion == 8) {
                    servicio.ejemploPredicateCombinado();
                }
                else if (opcion == 9) {
                    servicio.ejemploFunction();
                }
                else if (opcion == 10) {
                    servicio.ejemploBiFunction();
                }
                else if (opcion == 11) {
                    servicio.cargosDistintos();
                }
                else if (opcion == 12) {
                    servicio.industriasDistintas();
                }
                else if (opcion == 13) {
                    servicio.filtrarPorIndustriaTecnologia();
                }
                else if (opcion == 14) {
                    servicio.mapMayusculas();
                }
                else if (opcion == 15) {
                    servicio.salarioPromedio();
                }
                else if (opcion == 16) {
                    servicio.estadisticasSalario();
                }
                else if (opcion == 17) {
                    servicio.empleosPorNivelEducativo();
                }
                else if (opcion == 18) {
                    servicio.empleosPorIndustria();
                }
                else if (opcion == 19) {
                    servicio.topCargosMasComunes();
                }
                else if (opcion == 20) {
                    servicio.generarReporte();
                }
                else if (opcion == 0) {
                    System.out.println("¡Gracias por usar el sistema de empleos y salarios!");
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