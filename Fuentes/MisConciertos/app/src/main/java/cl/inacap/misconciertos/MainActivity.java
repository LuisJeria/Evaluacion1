package cl.inacap.misconciertos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


import cl.inacap.misconciertos.dao.EventosDAO;
import cl.inacap.misconciertos.dto.Evento;



public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private final static String[] genero={"---Seleccione Genero---","Rock","Jazz","Pop","Reggaeton","Salsa","Metal"};
    private final static String[] calificacion={"---Calificacion---","1","2","3","4","5","6","7"};
    private EditText artistaTxt;
    private EditText etFecha;
    private Spinner spinnerGenero;
    private EditText entradaTxt;
    private Spinner spinnerCalificacion;
    private Button btnRegistrar;
    private ListView registrolv;
    private EventosAdapter eventoAdapter;




    EventosDAO eventosDAO = new EventosDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.artistaTxt=findViewById(R.id.artista_txt);
        this.entradaTxt=findViewById(R.id.entrada_txt);
        this.btnRegistrar=findViewById(R.id.btn_registrar);
        this.registrolv=findViewById(R.id.registroLV);
        eventoAdapter = new EventosAdapter(MainActivity.this,R.layout.fila_lista,eventosDAO.getEventos());
        registrolv.setAdapter(eventoAdapter);



        //Calendario desplegable
        this.etFecha=findViewById(R.id.fecha_txt);
        this.etFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });
        this.btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<String>errores = new ArrayList<>();
                int precio = 0;
                int imagenInt=0;
                if(artistaTxt.getText().toString().isEmpty()){
                    errores.add("Debe ingresar un Artista Valido");
                }
                if(etFecha.getText().toString().isEmpty()){
                    errores.add("Debe escoger una Fecha");
                }
                if(spinnerGenero.getSelectedItemPosition()==0){
                    errores.add("Debe escoger un Genero");
                }
                try{
                    precio= Integer.parseInt(entradaTxt.getText().toString());
                    if(precio <=0){
                        errores.add("La entrada debe tener un valor mayor a 0 ");
                    }
                }catch (NumberFormatException ex){
                    errores.add("Debe ingresar un Valor Numerico");
                }
                if(spinnerCalificacion.getSelectedItemPosition()==0){
                    errores.add("Debe colocar una Calificacion");
                }
                if(errores.isEmpty()) {
                    Evento e = new Evento();
                    e.setNombreArtista(artistaTxt.getText().toString());
                    e.setFechaEvento(etFecha.getText().toString());
                    e.setGeneroElegido(spinnerGenero.getItemAtPosition(spinnerGenero.getSelectedItemPosition()).toString());
                    e.setValorEntrada(precio);
                    imagenInt =(Integer.parseInt(spinnerCalificacion.getItemAtPosition(spinnerCalificacion.getSelectedItemPosition()).toString())-1);
                    e.setCalificacion(imagenInt);
                    eventosDAO.add(e);
                    eventoAdapter.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this,"Ingreso Correcto",Toast.LENGTH_SHORT).show();
                }
                else{
                    mostrarErrores(errores);
                }


            }
        });
        //Spinner de genero
        ArrayAdapter adapter1=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,genero);
        this.spinnerGenero=findViewById(R.id.spGenero);
        spinnerGenero.setAdapter(adapter1);
        spinnerGenero.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //Spinner de calificacion
        ArrayAdapter adapter2=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,calificacion);
        this.spinnerCalificacion=findViewById(R.id.spCalificacion);
        spinnerCalificacion.setAdapter(adapter2);
        spinnerCalificacion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }


    private void showDatePickerDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker datePicker, int anio, int mes, int dia) {
        String fecha=dia+"/"+(mes+1)+"/"+anio;

        etFecha.setText(fecha);
    }
    private void mostrarErrores(List<String> errores){
        String mensaje="";
        for(String e:errores){
            mensaje+= "-"+ e +"\n";
        }
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);
        alertBuilder.setTitle("Error de Validacion")
                .setMessage(mensaje)
                .setPositiveButton("Aceptar",null)
                .create().show();
    }

}