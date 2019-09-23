package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Main2Activity extends AppCompatActivity {
    Button btnSomar, btnSubtrair, btnDividir, btnMultiplicar, limpar;
    EditText texto1, texto2;
    TextView recuperarValor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        texto1 = findViewById(R.id.num1);
        texto2 = findViewById(R.id.num2);
        btnDividir = findViewById(R.id.buttondividir);
        btnMultiplicar = findViewById(R.id.buttonmultiplicar);
        btnSomar = findViewById(R.id.buttonsomar);
        btnSubtrair = findViewById(R.id.buttonsubtracao);
        recuperarValor = findViewById(R.id.recuperarValor);
        limpar = findViewById(R.id.limparButton);
        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LimparValores();
            }
        });
    }

    public void Somar(View v){
        if (texto1.getText().toString().length() == 0 ){
            texto1.setError("Campo Esta Vazio");
        }
        if(texto2.getText().toString().length() == 0) {
            texto2.setError("Campo Esta Vazio");
        }else{
            Double num1 = Double.valueOf(texto1.getText().toString());
            Double num2 = Double.valueOf(texto2.getText().toString());
            Double Resultado = num1 + num2;
            recuperarValor.setText(String.valueOf(Resultado));
        }
    }

    public void Diminuir(View v){
        if (texto1.getText().toString().length() == 0 ){
            texto1.setError("Campo Esta Vazio");
        }
        if(texto2.getText().toString().length() == 0) {
            texto2.setError("Campo Esta Vazio");
        }else {
            Double num1 = Double.valueOf(texto1.getText().toString());
            Double num2 = Double.valueOf(texto2.getText().toString());
            Double Resultado = num1 - num2;
            MostrarValorEmOutraActivity(Resultado);
        }
    }

    public void Multiplicar(View v){
        if (texto1.getText().toString().length() == 0 ){
            texto1.setError("Campo Esta Vazio");
        }
        if(texto2.getText().toString().length() == 0) {
            texto2.setError("Campo Esta Vazio");
        }else {
            Double num1 = Double.valueOf(texto1.getText().toString());
            Double num2 = Double.valueOf(texto2.getText().toString());
            Double Resultado = num1 * num2;
            MostrarValorPorSnackBar(Resultado);
        }
    }

    public void Dividir(View v){
        if (texto1.getText().toString().length() == 0 ){
            texto1.setError("Campo Esta Vazio");
        }
        else if (texto2.getText().toString().equalsIgnoreCase("0")) {
            texto2.setError("Nao se pode dividir um numero por zero");
        }
        else if(texto2.getText().toString().length() == 0) {
                texto2.setError("Campo Esta Vazio");
        }else {
            Double num1 = Double.valueOf(texto1.getText().toString());
            Double num2 = Double.valueOf(texto2.getText().toString());
            Double Resultado = num1 / num2;
            recuperarValor.setText(String.valueOf(Resultado));
        }
    }
    public void MostrarValorEmOutraActivity(double valor)
    {
        DecimalFormat formato = new DecimalFormat("#.##");
        formato.setRoundingMode(RoundingMode.FLOOR);
        Intent intent = new Intent(Main2Activity.this, Main4Activity.class);
        intent.putExtra("resultado", formato.format(valor));
        startActivity(intent);
    }

    public void MostrarValorPorSnackBar(double valor)
    {
        DecimalFormat formato = new DecimalFormat("#.##");
        formato.setRoundingMode(RoundingMode.FLOOR);
        Snackbar.make(findViewById(android.R.id.content), "Resultado: " + formato.format(valor), Snackbar.LENGTH_LONG)
                .setAction("Ok", null)
                .show();
    }
    public void LimparValores()
    {
        texto1.setText("");
        texto2.setText("");
        recuperarValor.setText("");
    }
}
