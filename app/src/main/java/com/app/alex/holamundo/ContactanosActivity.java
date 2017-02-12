package com.app.alex.holamundo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ContactanosActivity extends AppCompatActivity {

    TextView textViewNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactanos);

        textViewNombre = (TextView) findViewById(R.id.textViewNombre);
        String nombre = getIntent().getStringExtra("nombre");
        textViewNombre.setText(nombre);

    }
}
