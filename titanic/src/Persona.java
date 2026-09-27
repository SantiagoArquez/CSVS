package src;
public class Persona {
    private String clase;
    private String edad;
    private String sexo;
    private String sobrevivio;
    public Persona(String clase,String edad,String sexo,String sobrevivio) {
        this.clase = clase;
        this.edad = edad;
        this.sexo = sexo;
        this.sobrevivio = sobrevivio;
    }
    public String getClase() {
        return this.clase;
    }
    public void setClase(String clase) {
        this.clase = clase;
    }
    public String getEdad() {
        return this.edad;
    }
    public void setEdad(String edad) {
        this.edad = edad;
    }
    public String getSexo() {
        return this.sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public String getSobrevivio() {
        return this.sobrevivio;
    }
    public void setSobrevivio(String sobrevivio) {
        this.sobrevivio = sobrevivio;
    }
    @Override
    public String toString() {
        return "¨ " +
            " clase='" + getClase() + "'" +
            ", edad='" + getEdad() + "'" +
            ", sexo='" + getSexo() + "'" +
            ", sobrevivio= " + getSobrevivio() + "" +
            " ¨";
    }
}