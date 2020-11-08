package com.lsr.formulario;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {
    private EditText editNombreC;
    private EditText editFechaC;
    private EditText editTelefonoC;
    private EditText editEmailC;
    private EditText editDetalleC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);
        Bundle parametros    = getIntent().getExtras();

        // para recuperar los datos cachados
        String nombre     = parametros.getString(getResources().getString(R.string.key_nombre));
        String fecha      = parametros.getString(getResources().getString(R.string.key_fecha));
        String telefono   = parametros.getString(getResources().getString(R.string.key_telefono));
        String email      = parametros.getString(getResources().getString(R.string.key_email));
        String detalle    = parametros.getString(getResources().getString(R.string.key_descripcion));

        // para poder manipular los editNombre, etc.
        editNombreC    = (EditText) findViewById(R.id.editNombreC);
        editFechaC     = (EditText) findViewById(R.id.editFechaC);
        editTelefonoC  = (EditText) findViewById(R.id.editTelefonoC);
        editEmailC     = (EditText) findViewById(R.id.editEmailC);
        editDetalleC   = (EditText) findViewById(R.id.editDescripcionC);

        //Mostramos los datos en los views
        editNombreC.setText(nombre);
        editFechaC.setText(fecha);
        editTelefonoC.setText(telefono);
        editEmailC.setText(email);
        editDetalleC.setText(detalle);

        // cambiando de pantalla
        Button btnEdit      = (Button) findViewById(R.id.btnEditar);


        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intentR = new Intent(ConfirmarDatos.this, MainActivity.class);
                //intentR.putExtra(getResources().getString(R.string.key_nombreP), editNom.getText().toString());
                    finish();
                //startActivity(intentR);
            }
        });

    }
}