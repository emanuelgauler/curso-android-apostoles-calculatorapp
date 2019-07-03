package com.kurupi.calculatorapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStructure;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Calculadora calculadora = new Calculadora();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button
                boton_sumar_valores         = findViewById(R.id.recurso_boton_sumar),
                boton_restar_valores        = findViewById(R.id.recurso_boton_restar),
                boton_multiplicar_valores   = findViewById(R.id.recurso_boton_multiplicar),
                boton_dividir_valores       = findViewById(R.id.recurso_boton_dividir);

        boton_sumar_valores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    validar_las_entradas();
                    sumar_valores_de_las_entradas();
                    reestablecer_entradas();
                } catch (IllegalArgumentException ex) {
                    notificar(ex.getMessage());
                }
            }
        });

        boton_restar_valores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    validar_las_entradas();
                    restar_valores_de_las_entradas();
                    reestablecer_entradas();
                } catch (IllegalArgumentException ex) {
                    notificar(ex.getMessage());
                }
            }
        });

        boton_multiplicar_valores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    validar_las_entradas();
                    multiplicar_valores_de_las_entradas();
                    reestablecer_entradas();
                } catch (IllegalArgumentException ex) {
                    notificar(ex.getMessage());
                }
            }
        });

        boton_dividir_valores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    validar_las_entradas();
                    dividir_los_valores_de_las_entradas();
                    reestablecer_entradas();
                } catch (IllegalArgumentException ex) {
                    notificar(ex.getMessage());
                }
            }
        });
    }

    private void validar_las_entradas() {
        if (las_entradas_no_son_validas())
            throw new IllegalArgumentException("Las entradas no deben estar vacías");
    }

    private void dividir_los_valores_de_las_entradas() {
        try {
            cambiar_resultado(calculadora.dividir(primer_operando(), segundo_operando()));
        } catch (Calculadora.ErrorDivisionPorCero ex) {
            notificar(ex.getMessage());
        }
    }

    private void multiplicar_valores_de_las_entradas() {
        cambiar_resultado(calculadora.multiplicar(primer_operando(), segundo_operando()));
    }

    private void restar_valores_de_las_entradas() {
        cambiar_resultado(calculadora.restar(primer_operando(), segundo_operando()));
    }

    private void notificar(String mensaje) {
        Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_SHORT).show();
    }

    private boolean las_entradas_no_son_validas() {
        return entrada_del_primer_operando().getText().toString().trim().length() == 0
                || entrada_del_segundo_operando().getText().toString().trim().length() == 0;
    }

    private void reestablecer_entradas() {
        entrada_del_primer_operando().setText("");
        entrada_del_primer_operando().requestFocus();
        entrada_del_segundo_operando().setText("");
    }

    private void sumar_valores_de_las_entradas() {
        cambiar_resultado(calculadora.sumar(primer_operando(), segundo_operando()));
    }

    private void cambiar_resultado(double resultado) {
        vista_resultado().setText(String.valueOf(resultado));
    }

    private TextView vista_resultado() {
        return findViewById(R.id.recurso_vista_resultado);
    }

    private double segundo_operando() {
        return Double.valueOf(entrada_del_segundo_operando().getText().toString());
    }

    private EditText entrada_del_segundo_operando() {
        return findViewById(R.id.recurso_para_segundo_operando);
    }

    private double primer_operando() {
        return Double.valueOf(entrada_del_primer_operando().getText().toString());
    }

    private EditText entrada_del_primer_operando() {
        return findViewById(R.id.recurso_para_primer_operando);
    }
}
