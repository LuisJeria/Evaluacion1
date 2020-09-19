package cl.inacap.misconciertos.dto;

import java.util.Calendar;

public class Evento {
    private String nombreArtista;
    private String fechaEvento;
    private String generoElegido;
    private int valorEntrada;
    private String calificacion;

    public String getNombreArtista() {
        return nombreArtista;
    }

    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }

    public String getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(String fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public String getGeneroElegido() {
        return generoElegido;
    }

    public void setGeneroElegido(String generoElegido) {
        this.generoElegido = generoElegido;
    }

    public int getValorEntrada() {
        return valorEntrada;
    }

    public void setValorEntrada(int valorEntrada) {
        this.valorEntrada = valorEntrada;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "nombreArtista='" + nombreArtista + '\'' +
                ", fechaEvento=" + fechaEvento +
                ", generoElegido='" + generoElegido + '\'' +
                ", valorEntrada=" + valorEntrada +
                ", calificacion=" + calificacion +
                '}';
    }
}
