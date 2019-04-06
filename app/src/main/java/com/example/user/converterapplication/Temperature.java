package com.example.user.converterapplication;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Temperature extends AppCompatActivity {

    String[] temperature_type;
    private Spinner spinner;
    private TextView rs1, rs2;
    private EditText taketemp;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        //Text sajay dewa
        TextView headText = findViewById(R.id.headtxtId1);
        Typeface typeface1 = Typeface.createFromAsset(getAssets(),"croissant sandwich-bold.ttf");
        headText.setPaintFlags(headText.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        headText.setTypeface(typeface1);

        //Text sajay dewa
        TextView headText2 = findViewById(R.id.headtxtId2);
        Typeface typeface2 = Typeface.createFromAsset(getAssets(),"croissant sandwich-bold.ttf");
        headText2.setTypeface(typeface2);

        temperature_type = getResources().getStringArray(R.array.temperature_type);

        spinner = findViewById(R.id.tempspinId);

        rs1 = findViewById(R.id.resultId1);
        rs2 = findViewById(R.id.resultId2);
        taketemp = findViewById(R.id.cvrttempId);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(Temperature.this,R.layout.sample_view,
                R.id.sampleviewId, temperature_type);
        spinner.setAdapter(adapter);

        button = findViewById(R.id.cvrtbtnId);

        //Precession Error Control
        final DecimalFormat decimalFormat = new DecimalFormat("###,###.##");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //kun item select korlo
                String value = spinner.getSelectedItem().toString();

                if(value.equals("CELSIUS"))
                {
                    taketemp.setInputType(InputType.TYPE_CLASS_NUMBER);
                    //F = (C * 9/5) + 32,
                    double a = Integer.parseInt(taketemp.getText().toString());
                    double result1 = (a*9/5)+32;
                    rs1.setText(String.valueOf(decimalFormat.format(result1))+" degrees Fahrenheit (°F)");

                    //K = C + 273.15
                    double b = Integer.parseInt(taketemp.getText().toString());
                    double result2 = b + 273.15;
                    rs2.setText(String.valueOf(decimalFormat.format(result2))+" kelvin (K)");
                }

                else if(value.equals("KELVIN"))
                {
                    taketemp.setInputType(InputType.TYPE_CLASS_NUMBER);
                    //C = K - 273.15,
                    double a = Integer.parseInt(taketemp.getText().toString());
                    double result1 = a - 273.15;
                    rs1.setText(String.valueOf(decimalFormat.format(result1))+" degrees Celsius (°C)");

                    //F = (K - 273.15) * 9/5 + 32
                    double b = Integer.parseInt(taketemp.getText().toString());
                    double result2 = (b-273.15) * 9/5 +32;
                    rs2.setText(String.valueOf(decimalFormat.format(result2))+" degrees Fahrenheit (°F)");
                }

                else if(value.equals("FAHRENHEIT"))
                {
                    taketemp.setInputType(InputType.TYPE_CLASS_NUMBER);
                    //C = (F - 32) * 5/9,
                    double a = Integer.parseInt(taketemp.getText().toString());
                    double result1 = (a-32) * 5/9;
                    rs1.setText(String.valueOf(decimalFormat.format(result1))+" degrees Celsius (°C)");

                    //K = (F - 32) * 5/9 + 273.15
                    double b = Integer.parseInt(taketemp.getText().toString());
                    double result2 = (b-32)*5/9 + 273.15;
                    rs2.setText(String.valueOf(decimalFormat.format(result2))+" kelvin (K)");
                }
            }
        });
    }
}
