package com.lsr.formulario;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    DatePicker calendario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Almacenamos la vista para su posterior uso */
        EditText inputFecha = (EditText) findViewById(R.id.editFecha);
        inputFecha.setOnClickListener(this);


        Button btnNext          = (Button) findViewById(R.id.btnSiguiente);
        EditText editNombre     = (EditText) findViewById(R.id.editNombre);
        EditText editFecha      = (EditText) findViewById(R.id.editFecha);
        EditText editTelefono   = (EditText) findViewById(R.id.editTelefono);
        EditText editEmail      = (EditText) findViewById(R.id.editEmail);
        EditText editDescripcion = (EditText) findViewById(R.id.editDescripcion);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ConfirmarDatos.class);

                intent.putExtra(getResources().getString(R.string.key_nombre), editNombre.getText().toString());
                intent.putExtra(getResources().getString(R.string.key_fecha), editFecha.getText().toString());
                intent.putExtra(getResources().getString(R.string.key_telefono), editTelefono.getText().toString());
                intent.putExtra(getResources().getString(R.string.key_email), editEmail.getText().toString());
                intent.putExtra(getResources().getString(R.string.key_descripcion), editDescripcion.getText().toString());

                startActivity(intent);
            }
        });
    }

    public void onClick(View view) {
        //Determinamos qué elemento ha sido pulsado
        switch (view.getId()) {
            case R.id.editFecha:
                //Mostrar el datePicker
                showDatePickerDialog((EditText) view);
                break;
        }
    }
    public void showDatePickerDialog(EditText v) {
        // Para crear una instancia de nuestro datePicker pasándole el EditText debemos usar el método
        // estático que definimos como "newInstance" en lugar de usar el constructor por defecto
        DialogFragment newFragment = DatePickerFragment.newInstance(v);
        // Mostrar el datePicker
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
}