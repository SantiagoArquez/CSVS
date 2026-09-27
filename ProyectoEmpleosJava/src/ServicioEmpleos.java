import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ServicioEmpleos {

    private List<Empleo> empleos;

    public ServicioEmpleos(String archivo) throws IOException {

        Path ruta = Paths.get(archivo);

        empleos = Files.lines(ruta)
                .skip(1)
                .map(linea -> linea.split(","))
                .filter(datos -> datos.length >= 10)
                .map(datos -> new Empleo(
                        datos[0],
                        Integer.parseInt(datos[1]),
                        datos[2],
                        Integer.parseInt(datos[3]),
                        datos[4],
                        datos[5],
                        datos[6],
                        datos[7],
                        Integer.parseInt(datos[8]),
                        Double.parseDouble(datos[9])
                ))
                .collect(Collectors.toList());
    }

    // 1. Total de registros cargados
    public void totalRegistros() {
        System.out.println("TOTAL REGISTROS: " + empleos.size());
    }

    // 2. Primeros 10 registros
    public void mostrarPrimeros10() {
        System.out.println("PRIMEROS 10 REGISTROS");
        empleos.stream()
                .limit(10)
                .forEach(System.out::println);
    }

    // 3. Ordenar por salario descendente (Comparator)
    public void ordenarPorSalario() {
        System.out.println("EMPLEOS ORDENADOS POR SALARIO (DESCENDENTE)");
        empleos.stream()
                .sorted(Comparator.comparingDouble(Empleo::getSalario).reversed())
                .limit(10)
                .forEach(System.out::println);
    }

    // 4. Ordenar por experiencia y, en caso de empate, por salario (thenComparing)
    public void ordenarPorExperiencia() {
        System.out.println("EMPLEOS ORDENADOS POR EXPERIENCIA Y SALARIO");
        Comparator<Empleo> porExperiencia = Comparator.comparingInt(Empleo::getAniosExperiencia);
        Comparator<Empleo> porSalario = Comparator.comparingDouble(Empleo::getSalario);

        empleos.stream()
                .sorted(porExperiencia.thenComparing(porSalario))
                .limit(10)
                .forEach(System.out::println);
    }

    // 5. Mostrar cargo y salario usando Consumer
    public void ejemploConsumer() {
                System.out.println("Cargo y salario de cada empleo");

        Consumer<Empleo> consumidor =
                empleo -> System.out.println(
                        empleo.getCargo() + " -> $" + empleo.getSalario());

        empleos.stream()
                .limit(10)
                .forEach(consumidor);
    }

    // 6. Filtrar empleos con salario mayor a 120000 usando Predicate
    public void ejemploPredicateSalario() {
        System.out.println("PREDICATE - SALARIO MAYOR A 120000");

        Predicate<Empleo> salarioAlto = empleo -> empleo.getSalario() > 120000;

        empleos.stream()
                .filter(salarioAlto)
                .limit(10)
                .forEach(System.out::println);
    }

    // 7. Filtrar empleos remotos ("Yes") usando Predicate
    public void ejemploPredicateRemoto() {
        System.out.println("PREDICATE - EMPLEOS REMOTOS");

        Predicate<Empleo> esRemoto = empleo -> empleo.getTrabajoRemoto().equalsIgnoreCase("Yes");

        empleos.stream()
                .filter(esRemoto)
                .limit(10)
                .forEach(System.out::println);
    }

    // 8. Combinar dos predicados con and(): remoto Y salario alto
    public void ejemploPredicateCombinado() {
        System.out.println("PREDICATE COMBINADO - REMOTOS CON SALARIO MAYOR A 120000");

        Predicate<Empleo> esRemoto = empleo -> empleo.getTrabajoRemoto().equalsIgnoreCase("Yes");
        Predicate<Empleo> salarioAlto = empleo -> empleo.getSalario() > 120000;

        empleos.stream()
                .filter(esRemoto.and(salarioAlto))
                .limit(10)
                .forEach(System.out::println);
    }

    // 9. Construir una descripcion personalizada de cada empleo usando Function
    public void ejemploFunction() {
        System.out.println("FUNCTION");

        Function<Empleo, String> descripcion =
                empleo -> empleo.getCargo() + " (" + empleo.getAniosExperiencia() + " anios) - $" + empleo.getSalario();

        empleos.stream()
                .limit(10)
                .map(descripcion)
                .forEach(System.out::println);
    }

    // 10. Combinar cargo y salario en un texto tipo reporte usando BiFunction
    public void ejemploBiFunction() {
        System.out.println("BIFUNCTION");

        BiFunction<String, Double, String> reporte =
                (cargo, salario) -> "Puesto: " + cargo + " | Salario ofrecido: $" + salario;

        empleos.stream()
                .limit(10)
                .forEach(e -> System.out.println(reporte.apply(e.getCargo(), e.getSalario())));
    }

    // 11. Listar los cargos distintos
    public void cargosDistintos() {
        System.out.println("CARGOS DISTINTOS");

        empleos.stream()
                .map(Empleo::getCargo)
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }

    // 12. Listar las industrias distintas
    public void industriasDistintas() {
        System.out.println("INDUSTRIAS DISTINTAS");

        empleos.stream()
                .map(Empleo::getIndustria)
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }

    // 13. Filtrar empleos de la industria "Technology"
    public void filtrarPorIndustriaTecnologia() {
        System.out.println("EMPLEOS DEL SECTOR TECHNOLOGY");

        empleos.stream()
                .filter(e -> e.getIndustria().equalsIgnoreCase("Technology"))
                .limit(10)
                .forEach(System.out::println);
    }

    // 14. Transformar los cargos a mayusculas usando map
    public void mapMayusculas() {
        System.out.println("MAP - CARGOS EN MAYUSCULAS");

        empleos.stream()
                .map(e -> e.getCargo().toUpperCase())
                .distinct()
                .forEach(System.out::println);
    }

    // 15. Calcular el salario promedio
    public void salarioPromedio() {
        double promedio =
                empleos.stream()
                        .mapToDouble(Empleo::getSalario)
                        .average()
                        .orElse(0);

        System.out.println("SALARIO PROMEDIO: " + promedio);
    }

    // 16. Calcular estadisticas: total, maximo y minimo
    public void estadisticasSalario() {

        double total =
                empleos.stream()
                        .mapToDouble(Empleo::getSalario)
                        .sum();

        double maximo =
                empleos.stream()
                        .mapToDouble(Empleo::getSalario)
                        .max()
                        .orElse(0);

        double minimo =
                empleos.stream()
                        .mapToDouble(Empleo::getSalario)
                        .min()
                        .orElse(0);

        System.out.println("TOTAL SALARIOS: " + total);
        System.out.println("SALARIO MAXIMO: " + maximo);
        System.out.println("SALARIO MINIMO: " + minimo);
    }

    // 17. Agrupar y contar empleos por nivel educativo
    public void empleosPorNivelEducativo() {
        System.out.println("\nEMPLEOS POR NIVEL EDUCATIVO");

        Map<String, Long> resultado =
                empleos.stream()
                        .collect(Collectors.groupingBy(
                                Empleo::getNivelEducativo,
                                Collectors.counting()));

        resultado.forEach((nivel, cantidad) ->
                System.out.println(nivel + ": " + cantidad));
    }

    // 18. Agrupar y contar empleos por industria (top 5)
    public void empleosPorIndustria() {
        System.out.println("TOP 5 INDUSTRIAS CON MAS EMPLEOS");

        Map<String, Long> resultado =
                empleos.stream()
                        .collect(Collectors.groupingBy(
                                Empleo::getIndustria,
                                Collectors.counting()));

        resultado.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .forEach(System.out::println);
    }

    // 19. Determinar los cargos mas frecuentes del dataset (top 10)
    public void topCargosMasComunes() {
        System.out.println("TOP 10 CARGOS MAS FRECUENTES");

        Map<String, Long> resultado =
                empleos.stream()
                        .collect(Collectors.groupingBy(
                                Empleo::getCargo,
                                Collectors.counting()));

        resultado.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .forEach(System.out::println);
    }

    // 20. Generar un archivo de reporte con estadisticas generales
    public void generarReporte() throws IOException {

        long registros = empleos.size();

        double total =
                empleos.stream()
                        .mapToDouble(Empleo::getSalario)
                        .sum();

        double promedio =
                empleos.stream()
                        .mapToDouble(Empleo::getSalario)
                        .average()
                        .orElse(0);

        double maximo =
                empleos.stream()
                        .mapToDouble(Empleo::getSalario)
                        .max()
                        .orElse(0);

        double minimo =
                empleos.stream()
                        .mapToDouble(Empleo::getSalario)
                        .min()
                        .orElse(0);

        List<String> reporte = List.of(
                "REPORTE DE EMPLEOS Y SALARIOS",
                "------------------------------",
                "Total registros: " + registros,
                "Salario total: " + total,
                "Salario promedio: " + promedio,
                "Salario maximo: " + maximo,
                "Salario minimo: " + minimo
        );

        Files.write(
                Paths.get("reporte_empleos.txt"),
                reporte
        );

        System.out.println("\nReporte generado correctamente.");
    }
}
