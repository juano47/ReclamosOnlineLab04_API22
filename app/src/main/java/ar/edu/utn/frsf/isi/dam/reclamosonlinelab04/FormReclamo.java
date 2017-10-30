package ar.edu.utn.frsf.isi.dam.reclamosonlinelab04;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;

import java.util.List;

import ar.edu.utn.frsf.isi.dam.reclamosonlinelab04.dao.ReclamoDaoHTTP;
import ar.edu.utn.frsf.isi.dam.reclamosonlinelab04.modelo.TipoReclamo;

public class FormReclamo extends AppCompatActivity {

    EditText frmReclamoTitulo;
    EditText frmReclamoDetalle;
    Spinner frmReclamoSpinner;
    Button btnGuardar;
    Button btnelegirLugar;
    Button btnCancelar;
    ReclamoDaoHTTP daoHTTP = new ReclamoDaoHTTP();
    List<TipoReclamo> tipoReclamos;
    ArrayAdapter adapterTiposReclamos;

    private GoogleMap mapa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_reclamo);

        btnGuardar = (Button) findViewById(R.id.frmReclamoGuardar);
        btnelegirLugar = (Button) findViewById(R.id.elegirLugar);
        btnCancelar = (Button) findViewById(R.id.frmReclamoCancelar);
        frmReclamoTitulo = (EditText) findViewById(R.id.frmReclamoTextReclamo);
        frmReclamoDetalle = (EditText) findViewById(R.id.frmReclamoTextDetReclamo);
        frmReclamoSpinner = (Spinner) findViewById(R.id.frmReclamoCmbTipo);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        tipoReclamos = daoHTTP.tiposReclamo();
        adapterTiposReclamos = new ArrayAdapter(FormReclamo.this, android.R.layout.simple_spinner_item, tipoReclamos);
        frmReclamoSpinner.setAdapter(adapterTiposReclamos);


        btnelegirLugar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Intent abrirMapa = new Intent(FormReclamo.this, MapsActivity.class);
                startActivity(abrirMapa);

            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultado = getIntent();
                resultado.putExtra("RESULTADO","Cancelado" );
                setResult(RESULT_CANCELED, resultado);
                finish();


            }
        });


    }
}
