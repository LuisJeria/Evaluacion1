package cl.inacap.misconciertos.dao;

import java.util.ArrayList;
import java.util.List;

import cl.inacap.misconciertos.dto.Evento;

public class EventosDAO {
    List<Evento> eventos = new ArrayList<>();
    public void add(Evento e){
        eventos.add(e);
    }

    @Override
    public String toString() {
        return "EventosDAO{" +
                "eventos=" + eventos +
                '}';
    }
}
