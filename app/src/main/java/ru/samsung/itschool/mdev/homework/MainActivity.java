package ru.samsung.itschool.mdev.homework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public EditText InputA, InputB, InputC;
    public TextView ResOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button runCalculations = findViewById(R.id.run);
        runCalculations.setOnClickListener(view -> {
            InputA = findViewById(R.id.a);
            InputB = findViewById(R.id.b);
            InputC = findViewById(R.id.c);
            ResOutput = findViewById(R.id.res);

            double a;
            double b;
            double c;

            try {
                a = Double.parseDouble(String.valueOf(InputA.getText()));
            } catch (Exception e) {
                Toast.makeText(this, "Вы не ввели «a»", Toast.LENGTH_LONG).show();
                return;
            }

            try {
                b = Double.parseDouble(String.valueOf(InputB.getText()));
            } catch (Exception e) {
                Toast.makeText(this, "Вы не ввели «b»", Toast.LENGTH_LONG).show();
                return;
            }

            try {
                c = Double.parseDouble(String.valueOf(InputC.getText()));
            } catch (Exception e) {
                Toast.makeText(this, "Вы не ввели «c»", Toast.LENGTH_LONG).show();
                return;
            }

            if (a == 0 && b == 0 && c == 0) {
                ResOutput.setText("any");

            } else {
                double D = b * b - 4 * a * c;
                if (D > 0) {
                    double x1, x2;
                    x1 = (-b - Math.sqrt(D)) / (2 * a);
                    x2 = (-b + Math.sqrt(D)) / (2 * a);
                    ResOutput.setText(x1 + " " + x2);
                } else if (D == 0) {
                    double x;
                    x = -b / (2 * a);
                    ResOutput.setText(String.valueOf(x));
                } else {
                    ResOutput.setText("none");
                }
            }
        });
    }
}