package com.example.tp_1_apps_moviles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tp_1_apps_moviles.models.Pregunta;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResultadoActivity extends AppCompatActivity {

    List<Pregunta> preguntas = new ArrayList<>(Arrays.asList(
            new Pregunta("¿Cuál es la suma de los primeros 20 números pares?",
                    new String[]{"420", "440", "400", "380"},0),
            new Pregunta("¿Cuántos grados tiene un ángulo llano?",
                    new String[]{"90 grados", "180 grados", "270 grados", "360 grados"},
                    1),
            new Pregunta("Si un círculo tiene un radio de 8 cm, ¿cuál es su diámetro?",
                    new String[]{"4 cm", "8 cm", "16 cm", "32 cm"},
                    2),
            new Pregunta("¿En una cancha de basquet hay 6 filas de asientos y cada fila tiene 8 asientos. ¿Cuántos asientos hay en la cancha en total?",
                    new String[]{"42 asientos", "36 asientos", "54 asientos", "48 asientos"},
                    3),
            new Pregunta("Si un triángulo tiene dos ángulos que miden 60 grados cada uno, ¿cuánto mide el tercer ángulo?",
                    new String[]{"120°", "30°", "60°", "90°"},
                    2),
            new Pregunta("¿Cuál es el valor de x en la ecuación 2x + 5 = 15?",
                    new String[]{"15", "10", "5", "20"},
                    2),
            new Pregunta("¿Cuál es el resultado de la siguiente expresión: (5 + 3) x 2 / 4 - 1?",
                    new String[]{"2", "3", "4", "5"},
                    1),
            new Pregunta("¿Cuántos divisores tiene el número 120?",
                    new String[]{"12", "16", "24", "32"},1
            ),
            new Pregunta("¿Cuál es el resultado de la siguiente operación? (4 + 2) x 3 ÷ 2",
                    new String[]{"6", "8", "12", "9"},
                    3),
            new Pregunta("Si un parque tiene 5 bancas y cada banca puede sentar a 3 personas, ¿cuántas personas pueden sentarse en el parque?",
                    new String[]{"10 personas", "12 personas", "15 personas", "18 personas"},
                    2)
    ));
    ArrayList<String> respuestas;
    Integer puntos = 0;
    TextView tvPregunta;
    TextView respuestaUsuario;
    TextView respuestaCorrecta, textView6;

    ListView listaResultado;
    Button btnResetearJuego ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        Intent recibido = getIntent();
        respuestas = recibido.getStringArrayListExtra("respuestas");
        puntos =  recibido.getIntExtra("puntos",0);
        listaResultado = findViewById(R.id.listaResultado);
        tvPregunta = findViewById(R.id.tvPregunta);
        textView6 = findViewById(R.id.textView6);
        btnResetearJuego = findViewById(R.id.btnResetearJuego);
        if (puntos >= 25) {
            textView6.setText("Felicidades, pasaste el juego, tus puntos fueron: " + puntos);
        } else {
            textView6.setText("Lo siento, no pasaste el juego, tus puntos fueron: " + puntos);
        }
        respuestaCorrecta = findViewById(R.id.respuestaCorrecta);
        respuestaUsuario = findViewById(R.id.respuestaUsuario);
        String [] arrayPreguntas = new String[10];
        for (int i = 0; i < preguntas.size(); i++) {
            arrayPreguntas[i] =preguntas.get(i).getPregunta();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayPreguntas);
        listaResultado.setAdapter(adapter);
        listaResultado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int indexRespuestaCorrecta = preguntas.get(i).getIndiceRespuestaCorrecta();
                tvPregunta.setText(preguntas.get(i).getPregunta());
                respuestaCorrecta.setText("Respuesta Correcta: " +preguntas.get(i).getRespuestas()[indexRespuestaCorrecta]);
                respuestaUsuario.setText("Tu respuesta: " +respuestas.get(i));
            }
        });
        btnResetearJuego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ResultadoActivity.this, MainActivity.class);
                finish();
                startActivity(i);
                            }
        });
    }



}