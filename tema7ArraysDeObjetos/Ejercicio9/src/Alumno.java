public class Alumno {
    
    private String nombreAlumno;
    private Asignatura[] vAsignaturas;

    public Alumno() {
        this.nombreAlumno = "";
        this.vAsignaturas = new Asignatura[4];
    }
    
    public Alumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
        this.vAsignaturas = new Asignatura[4];
    }
    public String getNombreAlumno() {
        return nombreAlumno;
    }
    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }
    public Asignatura[] getvAsignaturas() {
        return vAsignaturas;
    }
    public void setvAsignaturas(Asignatura[] vAsignaturas) {
        this.vAsignaturas = vAsignaturas;
    }

    
}
