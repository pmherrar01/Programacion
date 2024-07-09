public class Alumno {
    private String nombre;
    private int edad;
    private float notaMedia;

    public Alumno() {
        this.nombre = "";
        this.edad = 0;
        this.notaMedia = 0;
    }

    public Alumno(String nombre, int edad, float notaMedia) {
        this.nombre = nombre;
        this.edad = edad;
        this.notaMedia = notaMedia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getNotaMedia() {
        return notaMedia;
    }

    public void setNotaMedia(float notaMedia) {
        this.notaMedia = notaMedia;
    }

    @Override
    public String toString() {
        return nombre + ", edad: " + edad + ", notaMedia: " + notaMedia;
    }

}
