package ru.samsung.itschool.mdev.homework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

            final double a = Double.parseDouble(String.valueOf(InputA.getText()));
            final double b = Double.parseDouble(String.valueOf(InputB.getText()));
            final double c = Double.parseDouble(String.valueOf(InputC.getText()));

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