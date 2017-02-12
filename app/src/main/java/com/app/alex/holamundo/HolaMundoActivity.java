package com.app.alex.holamundo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HolaMundoActivity extends AppCompatActivity {

    EditText inputText;
    TextView outputText;

    public static Persona persona;

    Button hiButton;
    Button contactanosButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hola_mundo);
        inputText = (EditText) findViewById(R.id.editText);
        outputText = (TextView) findViewById(R.id.textView);
        hiButton = (Button) findViewById(R.id.button);
        persona = new Persona("Alex", "614-250-65-72");

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outputText.setText("Hola " + inputText.getText());
            }
        };
        hiButton.setOnClickListener(onClickListener);

    }

    public void saludar(View view) {
        outputText.setText("Hola " + inputText.getText());
    }

    public void call(View view) {
        Intent i = new Intent(getBaseContext(), ContactanosActivity.class);
        i.putExtra("nombre", "Alex");
        i.putExtra("edad", 22);
        startActivity(i);
    }

}
