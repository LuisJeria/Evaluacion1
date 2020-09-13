package cl.inacap.misconciertos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import static cl.inacap.misconciertos.dto.Evento.getCalificacion;
import static cl.inacap.misconciertos.dto.Evento.getGenero;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerGenero;
    private Spinner spinnerCalificacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Spinner de genero
        ArrayAdapter adapter1=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,getGenero());
        spinnerGenero=this.findViewById(R.id.spGenero);
        spinnerGenero.setAdapter(adapter1);

        //Spinner de calificacion
        ArrayAdapter adapter2=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,getCalificacion());
        spinnerCalificacion=this.findViewById(R.id.spCalificacion);
        spinnerCalificacion.setAdapter(adapter2);
    }
}