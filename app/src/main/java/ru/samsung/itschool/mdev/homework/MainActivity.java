package ru.samsung.itschool.mdev.homework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public EditText objectA, objectB, objectC;
    public TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // вызов кнопки
        Button run = findViewById(R.id.run);
        run.setOnClickListener(view -> {
            objectA = findViewById(R.id.a);
            objectB = findViewById(R.id.b);
            objectC = findViewById(R.id.c);

            res = findViewById(R.id.res);

            final double a = Double.parseDouble(String.valueOf(objectA.getText()));
            final double b = Double.parseDouble(String.valueOf(objectB.getText()));
            final double c = Double.parseDouble(String.valueOf(objectC.getText()));

            if (a == 0 && b == 0 && c == 0) {
                res.setText("any");

            } else {
                double D = b * b - 4 * a * c;
                if (D > 0) {
                    double x1, x2;
                    x1 = (-b - Math.sqrt(D)) / (2 * a);
                    x2 = (-b + Math.sqrt(D)) / (2 * a);
                    res.setText(x1 + " " + x2);
                } else if (D == 0) {
                    double x;
                    x = -b / (2 * a);
                    res.setText(String.valueOf(x));
                } else {
                    res.setText("none");
                }
            }
        });

        /* аналогия метода выше
        run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Код метода...
            }
        }); */
    }
}