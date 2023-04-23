package com.example.tp_1_apps_moviles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tp_1_apps_moviles.models.Pregunta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JuegoActivity extends AppCompatActivity {

    Button btnComenzarJuego;


    TextView textViewName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        btnComenzarJuego = findViewById(R.id.btnComenzarJuego);
        textViewName = findViewById(R.id.textViewName);
        Intent recibido = getIntent();
        String nombre = recibido.getStringExtra("nombre");
        textViewName.setText(nombre);
        btnComenzarJuego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pantallaDePreguntas = new Intent(JuegoActivity.this, PreguntasActivity.class);
                pantallaDePreguntas.putExtra("nombre", nombre);

                startActivity(pantallaDePreguntas);
            }
        });
    }
}