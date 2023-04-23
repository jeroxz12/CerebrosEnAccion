package com.example.tp_1_apps_moviles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tp_1_apps_moviles.models.Pregunta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PreguntasActivity extends AppCompatActivity {

    TextView nombreJugador;
    TextView txtPregunta;
    Button btnEnviarRespuesta;

    RadioButton opcion1,opcion2, opcion3, opcion4;
    Integer index = 0;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas);

        nombreJugador = findViewById(R.id.nombreJugador);
        txtPregunta = findViewById(R.id.txtPregunta);
        btnEnviarRespuesta = findViewById(R.id.btnEnviarRespuesta);
        opcion1 = findViewById(R.id.opcion1);
        opcion2 = findViewById(R.id.opcion2);
        opcion3 = findViewById(R.id.opcion3);
        opcion4 = findViewById(R.id.opcion4);

        setPregunta(preguntas.get(index));
        btnEnviarRespuesta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(radioButtonSeleccionado());
                Toast.makeText(getApplicationContext(),radioButtonSeleccionado(), Toast.LENGTH_SHORT).show();

                index++;
                setPregunta(preguntas.get(index));
            }
        });
        Intent recibido = getIntent();
        String nombre = recibido.getStringExtra("nombre");
        nombreJugador.setText(nombre);
    }

    public void setPregunta(Pregunta pregunta){
        limpiarCheckboxes();
        txtPregunta.setText(pregunta.getPregunta());
        cambiarRespuestasPor(pregunta);
    }

    public String radioButtonSeleccionado() {
        RadioButton [] botones = new RadioButton[]{opcion1, opcion2, opcion3, opcion4};
        for (int i = 0; i < botones.length; i++) {
            if(botones[i].isChecked()){
                return "Seleccionaste: " + botones[i].getText();
            }
        }
        return "No seleccionaste";
    }
    public void limpiarCheckboxes(){
        RadioButton [] botones = new RadioButton[]{opcion1, opcion2, opcion3, opcion4};
        for (int i = 0; i < botones.length; i++) {
            botones[i].setChecked(false);
        }
    }
    public void cambiarRespuestasPor(Pregunta pregunta) {
        opcion1.setText(pregunta.getRespuestas()[0]);
        opcion2.setText(pregunta.getRespuestas()[1]);
        opcion3.setText(pregunta.getRespuestas()[2]);
        opcion4.setText(pregunta.getRespuestas()[3]);

    }
}