package com.example.android.nine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.security.SecureRandom;

public class MainActivity extends AppCompatActivity {

    private boolean clear = true;
//Read
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText num1 = (EditText) findViewById(R.id.edtNum1);
        final EditText num2 = (EditText) findViewById(R.id.edtNum2);
        final EditText num3 = (EditText) findViewById(R.id.edtNum3);

        final TextView txtBigerValue = (TextView) findViewById(R.id.txtBigerValue);
        final TextView txtRandomValue = (TextView) findViewById(R.id.txtRandomValue);

        Button btnBigerValue = (Button) findViewById(R.id.btnBigerValue);
        final Button btnRandomValue = (Button) findViewById(R.id.btnRandomValue);


        btnBigerValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final double value1 = Double.parseDouble(num1.getText().toString());
                final double value2 = Double.parseDouble(num2.getText().toString());
                final double value3 = Double.parseDouble(num3.getText().toString());

                double result = compare(value1, value2, value3);
                txtBigerValue.setText(result + "");

            }
        });

        btnRandomValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (clear) {

                    txtRandomValue.setText("");
                }

                clear = false;


                SecureRandom activate = new SecureRandom();

                String oldRandomValue = txtRandomValue.getText().toString();


                int display = 1 + activate.nextInt(5);

                txtRandomValue.setText(display + "");


                txtRandomValue.setText(display + oldRandomValue);

                if (txtRandomValue.length() > 9) {

                    btnRandomValue.setVisibility(View.INVISIBLE);

                }
            }
        });


    }

    public double compare(double value11, double value22, double value33) {

        double max = value11;

        if (value22 > max) {

            max = value22;
        }

        if (value33 > max) {

            max = value33;
        }

        return max;
    }
}
