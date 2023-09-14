package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class CitaDisponible {
    //Atributos
    private int id;
    private Date fecha;
    private String hora;
    SimpleDateFormat fechaFormateda = new SimpleDateFormat("dd/MM/yyyy");

    public CitaDisponible(String fecha, String hora) {
        try {
            this.fecha = fechaFormateda.parse(fecha);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Cita disponible: " + fecha + ", Hora: " + hora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getFecha(String format) {
        return fechaFormateda.format(this.fecha);
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
