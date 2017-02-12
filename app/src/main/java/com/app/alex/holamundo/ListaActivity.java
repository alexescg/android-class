package com.app.alex.holamundo;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListaActivity extends AppCompatActivity {

    //modelo
    List<Persona> contactos = new ArrayList<>();

    ListView listViewContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        listViewContactos = (ListView) findViewById(R.id.listViewContactos);
        listViewContactos.setAdapter(new MyAdapter());
        listViewContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getBaseContext(), ContactanosActivity.class);
                i.putExtra("nombre", contactos.get(position).nombre);
                startActivity(i);
            }
        });

    }

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return contactos.size();
        }

        @Override
        public Object getItem(int position) {
            return contactos.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            Persona persona = contactos.get(position);
            if (position % 2 == 0) {
                convertView = getLayoutInflater().inflate(R.layout.celda, null);
            } else {
                convertView = getLayoutInflater().inflate(R.layout.celda2, null);
                convertView.setBackgroundColor(Color.GRAY);
            }
            TextView textViewNombre = (TextView) findViewById(R.id.textViewCeldaNombre);
            TextView textViewCelular = (TextView) findViewById(R.id.textViewCeldaCelular);
            textViewNombre.setText(persona.nombre);
            textViewCelular.setText(persona.celular);

            return convertView;
        }
    }
}
