package com.example.tp_1_apps_moviles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public EditText edtName;
    public Button btnComenzar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtName = findViewById(R.id.edtName);
        btnComenzar = findViewById(R.id.btnComenzar);

        btnComenzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( edtName.getText().length() > 0) {
                    String nombre = edtName.getText().toString();
                    Intent launchSecondActivity = new Intent(MainActivity.this, JuegoActivity.class);
                    launchSecondActivity.putExtra("nombre", nombre);
                    startActivity(launchSecondActivity);
                }
            }
        });
    }
}