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

public class EventosAdapter extends ArrayAdapter<Evento> {

    private List<Evento> mList;
    private Context mContext;
    private int resourceLayout;
    private final static int[] imgCalificaciones ={R.drawable.infeliz,R.drawable.infeliz,R.drawable.infeliz,R.drawable.confundido,R.drawable.confundido,R.drawable.sonriente,R.drawable.sonriente};

    public EventosAdapter(@NonNull Context context, int resource, @NonNull List<Evento> objects) {
        super(context, resource, objects);
        this.mList = objects;
        this.mContext = context;
        this.resourceLayout = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       View item = convertView;
       if(item == null) {
            item = LayoutInflater.from(mContext).inflate(resourceLayout, null);
       }
       Evento e =mList.get(position);
       TextView fecha = item.findViewById(R.id.fechalv);
       fecha.setText(e.getFechaEvento());
       TextView artista = item.findViewById(R.id.artistalv);
       artista.setText(e.getNombreArtista());
       TextView entrada = item.findViewById(R.id.valorlv);
       entrada.setText(String.valueOf(e.getValorEntrada()));
       ImageView imagen = item.findViewById(R.id.imagenlv);
       imagen.setImageResource(imgCalificaciones[e.getCalificacion()]);

       return item;
    }
}
