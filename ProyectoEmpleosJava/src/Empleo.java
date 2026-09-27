public class Empleo {

    private String cargo;
    private int aniosExperiencia;
    private String nivelEducativo;
    private int cantidadHabilidades;
    private String industria;
    private String tamanoEmpresa;
    private String ubicacion;
    private String trabajoRemoto;
    private int certificaciones;
    private double salario;

    public Empleo(String cargo, int aniosExperiencia, String nivelEducativo,
                  int cantidadHabilidades, String industria, String tamanoEmpresa,
                  String ubicacion, String trabajoRemoto, int certificaciones,
                  double salario) {

        this.cargo = cargo;
        this.aniosExperiencia = aniosExperiencia;
        this.nivelEducativo = nivelEducativo;
        this.cantidadHabilidades = cantidadHabilidades;
        this.industria = industria;
        this.tamanoEmpresa = tamanoEmpresa;
        this.ubicacion = ubicacion;
        this.trabajoRemoto = trabajoRemoto;
        this.certificaciones = certificaciones;
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    public String getNivelEducativo() {
        return nivelEducativo;
    }

    public int getCantidadHabilidades() {
        return cantidadHabilidades;
    }

    public String getIndustria() {
        return industria;
    }

    public String getTamanoEmpresa() {
        return tamanoEmpresa;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getTrabajoRemoto() {
        return trabajoRemoto;
    }

    public int getCertificaciones() {
        return certificaciones;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return String.format(
                "Cargo=%s | Experiencia=%d anios | Educacion=%s | Industria=%s | Remoto=%s | Salario=%.2f",
                cargo, aniosExperiencia, nivelEducativo, industria, trabajoRemoto, salario);
    }
}
