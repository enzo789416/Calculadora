package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity {
    TextView resultado;

    Button voltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        resultado = findViewById(R.id.resultadoField);
        voltar = findViewById(R.id.voltarButton);

        Intent intent_ = getIntent();
        resultado.setText(intent_.getStringExtra("resultado"));

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main4Activity.this, Main2Activity.class);
                startActivity(intent);
            }
        });
    }
}
