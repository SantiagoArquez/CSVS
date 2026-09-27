package src;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
public class TitanicService {
	private List<Persona> personas;
	// =====================================================
	// CONSTRUCTOR
	// =====================================================
	public TitanicService(String archivo) throws IOException {
		personas = Files.lines(Paths.get(archivo))
				.filter(linea -> !linea.trim().isEmpty())
				.map(linea -> linea.split(","))
				.filter(datos -> datos.length == 4)
				.map(datos -> new Persona(
						datos[0].trim(),
						datos[1].trim(),
						datos[2].trim(),
						datos[3].trim()))
				.collect(Collectors.toList());
	}
	// =====================================================
	// GETTER
	// =====================================================
	public List<Persona> getPersonas() {
		return personas;
	}
	// =====================================================
	// IMPRIMIR PASAJEROS POR CLASE
	// =====================================================
	public void imprimirPorClase(String clase) {
		long totalClase = personas.stream()
				.filter(p -> p.getClase().equalsIgnoreCase(clase))
				.count();
        System.out.println("\n=================================");
        System.out.println("PASAJEROS DE LA CLASE " + clase);
        System.out.println("=================================");
        personas.stream()
		.filter(p -> p.getClase().equalsIgnoreCase(clase))
		.limit(10)
		.forEach(System.out::println);
		System.out.println("---------------------------------");
		System.out.println("Total pasajeros de la clase "
				+ clase + ": " + totalClase);
	}
	// =====================================================
	// MUJERES SOBREVIVIENTES
	// =====================================================
	public void mujeresSobrevivientes(String clase) {
		long mujeres = personas.stream()
				.filter(p -> p.getClase().equalsIgnoreCase(clase))
				.filter(p -> p.getSexo().equalsIgnoreCase("femenino"))
				.filter(p -> p.getSobrevivio().equalsIgnoreCase("si"))
				.count();
		System.out.println("\n=================================");
        System.out.println("MUJERES SOBREVIVIENTES DE " + clase);
        System.out.println("=================================");
		personas.stream()
		.filter(p -> p.getClase().equalsIgnoreCase(clase))
		.filter(p -> p.getSexo().equalsIgnoreCase("femenino"))
		.filter(p -> p.getSobrevivio().equalsIgnoreCase("si"))
		.limit(10)
		.forEach(System.out::println);
		System.out.println("---------------------------------");
		System.out.println("Total pasajeros mujeres de la clase "
				+ clase + ": " + mujeres);
	}
	public void mujeresNoSobrevivientes(String clase) {
		long mujeresN = personas.stream()
				.filter(p -> p.getClase().equalsIgnoreCase(clase))
				.filter(p -> p.getSexo().equalsIgnoreCase("femenino"))
				.filter(p -> p.getSobrevivio().equalsIgnoreCase("no"))
				.count();
		System.out.println("\n=================================");
        System.out.println("MUJERES NO SOBREVIVIENTES DE " + clase);
        System.out.println("=================================");
		personas.stream()
		.filter(p -> p.getClase().equalsIgnoreCase(clase))
		.filter(p -> p.getSexo().equalsIgnoreCase("femenino"))
		.filter(p -> p.getSobrevivio().equalsIgnoreCase("no"))
		.limit(10)
		.forEach(System.out::println);
		
		System.out.println("---------------------------------");
		System.out.println("Total pasajeros mujeres NO SOBREVIVIENTES de la clase "
				+ clase + ": " + mujeresN);
	}

	public void hombresSobrevivientes(String clase) {

		long hombres = personas.stream()
				.filter(p -> p.getClase().equalsIgnoreCase(clase))
				.filter(p -> p.getSexo().equalsIgnoreCase("masculino"))
				.filter(p -> p.getSobrevivio().equalsIgnoreCase("si"))
				.count();
		System.out.println("\n=================================");
        System.out.println("HOMBRES SOBREVIVIENTES DE " + clase);
        System.out.println("=================================");
		personas.stream()
		.filter(p -> p.getClase().equalsIgnoreCase(clase))
		.filter(p -> p.getSexo().equalsIgnoreCase("masculino"))
		.filter(p -> p.getSobrevivio().equalsIgnoreCase("si"))
		.limit(10)
		.forEach(System.out::println);
		
		System.out.println("---------------------------------");
		System.out.println("Total pasajeros hombre sobrevivientes de la clase "
				+ clase + ": " + hombres);
	}
	public void hombresNoSobrevivientes(String clase) {

		long hombresn = personas.stream()
				.filter(p -> p.getClase().equalsIgnoreCase(clase))
				.filter(p -> p.getSexo().equalsIgnoreCase("masculino"))
				.filter(p -> p.getSobrevivio().equalsIgnoreCase("no"))
				.count();
		System.out.println("\n=================================");
        System.out.println("HOMBRES NO SOBREVIVIENTES DE " + clase);
        System.out.println("=================================");
		personas.stream()
		.filter(p -> p.getClase().equalsIgnoreCase(clase))
		.filter(p -> p.getSexo().equalsIgnoreCase("masculino"))
		.filter(p -> p.getSobrevivio().equalsIgnoreCase("no"))
		.limit(10)
		.forEach(System.out::println);
		
		System.out.println("---------------------------------");
		System.out.println("Total pasajeros hombre no sobrevivientes de la clase "
				+ clase + ": " + hombresn);
	}

}