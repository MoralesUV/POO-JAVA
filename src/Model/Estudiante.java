package Model;

import java.util.ArrayList;
import java.util.Date;

public class Estudiante extends Usuario{
    //Atributos
    private String semestre;
    private ArrayList<CitaMaestro> citaMaestros = new ArrayList<>();

    //Metodo constructor
    public Estudiante(String nombre, String correo){
        super(nombre,correo);
    }

    //Comportamientos
    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public ArrayList<CitaMaestro> getCitaMaestros() {
        return citaMaestros;
    }

    public void addCitaMaestros(Maestro maestro, Date fecha, String hora) {
        CitaMaestro citaMaestro = new CitaMaestro(maestro, this);
        citaMaestro.agendar(fecha, hora);
        citaMaestros.add(citaMaestro);
    }

    @Override
    public String toString() {
        return super.toString() + ", Semestre: " + semestre;
    }

    @Override
    public void mostrarInformacionUsuario() {
        System.out.println("Soy un estiante de LIS");
    }


}
