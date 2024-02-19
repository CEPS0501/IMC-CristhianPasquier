package com.example.imc_cristhianpasquier;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;
public class MainActivity extends AppCompatActivity {
    EditText txtNombre, txtPeso, txtEstatura;
    Button btnCalcular;
    TextView lblResultado;

    @SuppressLint("WrongViewCast")
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre = findViewById(R.id.txt_Nombre);
        txtPeso = findViewById(R.id.txt_Peso);
        txtEstatura = findViewById(R.id.txt_Estatura);
        btnCalcular = findViewById(R.id.btnCalcular);
        lblResultado = findViewById(R.id.lbl_Resultado);


        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String nombre = txtNombre.getText().toString();
                double peso = Double.parseDouble(txtPeso.getText().toString());
                double altura = Double.parseDouble(txtEstatura.getText().toString());
                double alturaalcuadrado  = Math.pow(altura, 2);

                double imc = peso / (alturaalcuadrado) ;
                String resultado;

                if (imc < 18.5) {
                    resultado = "tiene un Peso Bajo";
                }
                else if (imc >= 18.5 && imc < 24.9) {
                    resultado = "tiene un Peso Ideal";
                }
                else if (imc >= 25 && imc < 29.9) {
                    resultado = "tiene Sobrepeso";
                }
                else {
                    resultado = "Esta en Obesidad";
                }

                lblResultado.setText("Bienvenido " + nombre + " al calculo de IMC, su peso en Kg es de " + String.format("%.2f", imc) + " su estatura en Metros es de "+altura+" por lo que su resultado en este calculo de IMC es que usted " + resultado + ".");

            }
        });
    }


}