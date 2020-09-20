package cl.inacap.misconciertos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import cl.inacap.misconciertos.dto.Evento;

public class ListAdapter extends ArrayAdapter<Evento> {

    private List<Evento> listaEvento;
    private Context miContexto;
    private int miResource;

    public ListAdapter(@NonNull Context context, int resource, @NonNull List<Evento> objects) {
        super(context, resource, objects);
        this.listaEvento=objects;
        this.miContexto = context;
        this.miResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if(view == null){
            view = LayoutInflater.from(miContexto).inflate(miResource,null);

        }
        Evento e = listaEvento.get(position);

        TextView textoFecha = view.findViewById(R.id.fechalv);
        textoFecha.setText(e.getFechaEvento());

        TextView textoArtista = view.findViewById(R.id.artistalv);
        textoArtista.setText(e.getNombreArtista());

        TextView textoEntrada = view.findViewById(R.id.valorlv);
        textoEntrada.setText(e.getValorEntrada());



        return view;
    }
}
