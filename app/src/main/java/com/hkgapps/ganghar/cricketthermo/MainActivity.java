package com.hkgapps.ganghar.cricketthermo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {


    ImageView ivThermo;
    Button btnCalculate;
    EditText etChirp;
    TextView tvDescription;
    TextView tvResult;
    CheckBox cbFahrenheit;

    DecimalFormat formatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        btnCalculate = findViewById(R.id.btnCalculate);
        etChirp = findViewById(R.id.etChirp);
        tvDescription = findViewById(R.id.tvDescription);
        tvResult = findViewById(R.id.tvResult);
        cbFahrenheit = findViewById(R.id.cbFahrenheit);
        ivThermo = findViewById(R.id.ivThermo);

        tvResult.setVisibility(View.GONE);
        formatter = new DecimalFormat("#0.00");

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResult.setVisibility(View.GONE);

                if (etChirp.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter a value in the field", Toast.LENGTH_SHORT).show();
                } else {
                    String strChirp = etChirp.getText().toString().trim();
                    etChirp.getText().clear();
                    int iChirp = Integer.parseInt(strChirp);
                    double dResult;
                    String strResult;

                    if (cbFahrenheit.isChecked()) {
                        dResult = iChirp + 40.0;
                        strResult = "Temperature (in Fahrenheit): <b><i>" + formatter.format(dResult) + " deg F</i></b>";
                    } else {
                        dResult = (iChirp / 3.0) + 4;
                        strResult = "Temperature (in Celsius): <b><i>" + formatter.format(dResult) + " deg C</i></b>";
                    }

                    tvResult.setText(Html.fromHtml(strResult));
                    tvResult.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
