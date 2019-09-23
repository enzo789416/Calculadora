package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Main3Activity extends AppCompatActivity {
    EditText ed1, ed2;
    RadioGroup rg;
    Button limpar;
    double n1, n2, result=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ed1 = findViewById(R.id.editTextRadioNum1);
        ed2 = findViewById(R.id.editTextRadioNum2);
        rg = findViewById(R.id.radioGroup);
        rg.setOnCheckedChangeListener(opcoes);
        limpar = findViewById(R.id.limparButton);
        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LimparValores();
            }
        });
    }

    RadioGroup.OnCheckedChangeListener opcoes = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if(verificado()){
                n1 = Double.parseDouble(ed1.getText().toString());
                n2 = Double.parseDouble(ed2.getText().toString());
                switch (checkedId){
                    case R.id.radioButtonSomar:
                        result = n1+n2;
                        MostrarValorPorSnackBar(result);
                        break;
                    case R.id.radioButtonSubtrair:
                        result = n1-n2;
                        MostrarValorPorSnackBar(result);
                        break;
                    case R.id.radioButtonMultiplicar:
                        result = n1*n2;
                        MostrarValorPorSnackBar(result);
                        break;
                    case R.id.radioButtonDividir:
                        if (n2 == 0) {
                            ed2.setError("nao se pode dividir numero por zero");
                            break;
                        }
                        result = n1/n2;
                        MostrarValorPorSnackBar(result);
                        break;
                }
            }
        }
    };


    private boolean verificado() {
        boolean retorno = true;
        if (ed1.getText().toString().length() == 0){
            ed1.setError("Campo Esta vazio ");
            retorno = false;
        }
        if(ed2.getText().toString().length() == 0){
            ed2.setError("Campo esta vazio");
            retorno = false;
        }
        return retorno;
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
        ed1.setText("");
        ed2.setText("");
    }
}
