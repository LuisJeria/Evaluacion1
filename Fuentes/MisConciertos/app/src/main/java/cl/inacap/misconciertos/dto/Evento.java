package cl.inacap.misconciertos.dto;

import java.util.Calendar;

public class Evento {
    private String nombreArtista;
    private Calendar fechaEvento;
    private final static String[] genero={"Rock","Jazz","Pop","Reggaeton","Salsa","Metal"};
    private int valorEntrada;
    private final static String[] calificacion={"1","2","3","4","5","6","7"};

    public String getNombreArtista() {
        return nombreArtista;
    }

    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }

    public Calendar getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(Calendar fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public static String[] getGenero() {
        return genero;
    }

    public int getValorEntrada() {
        return valorEntrada;
    }

    public void setValorEntrada(int valorEntrada) {
        this.valorEntrada = valorEntrada;
    }

    public static String[] getCalificacion() {
        return calificacion;
    }
}
