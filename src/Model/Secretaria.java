package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Secretaria extends Usuario{
    //Atributos
    private String facultad;
    private String programaEducativo;

    public Secretaria(String nombre, String correo) {
        super(nombre, correo);
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getProgramaEducativo() {
        return programaEducativo;
    }

    public void setProgramaEducativo(String programaEducativo) {
        this.programaEducativo = programaEducativo;
    }

    ArrayList<Secretaria.CitaSecretariaDisponible> citasDisponibles = new ArrayList<>();
    public void addCitaDisponible(String date, String hora){
        citasDisponibles.add(new Secretaria.CitaSecretariaDisponible(date, hora));
    }

    public ArrayList<Secretaria.CitaSecretariaDisponible> getCitasDisponibles(){
        return citasDisponibles;
    }

    //Clase anidada
    public static class CitaSecretariaDisponible extends CitaDisponible{
        public CitaSecretariaDisponible(String fecha, String hora) {
            super(fecha, hora);
        }
    }

    @Override
    public void mostrarInformacionUsuario() {
        System.out.println("Secretaria de la UV");
    }
}
