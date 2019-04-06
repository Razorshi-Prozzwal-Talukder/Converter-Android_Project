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

public class Money extends AppCompatActivity {

    String[] money_name;
    private Spinner spinner;
    private TextView rs1, rs2;
    private EditText takemoney;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money);

        //Text sajay dewa
        TextView headText = findViewById(R.id.headtxtId11);
        Typeface typeface1 = Typeface.createFromAsset(getAssets(),"croissant sandwich-bold.ttf");
        headText.setPaintFlags(headText.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        headText.setTypeface(typeface1);

        //Text sajay dewa
        TextView headText2 = findViewById(R.id.headtxtId21);
        Typeface typeface2 = Typeface.createFromAsset(getAssets(),"croissant sandwich-bold.ttf");
        headText2.setTypeface(typeface2);

         money_name = getResources().getStringArray(R.array.money_type);

         spinner = findViewById(R.id.moneyspinId);

         rs1 = findViewById(R.id.resultId1);
         rs2 = findViewById(R.id.resultId2);
         takemoney = findViewById(R.id.cvrtmoneyId);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(Money.this,R.layout.sample_view,
                R.id.sampleviewId, money_name);
        spinner.setAdapter(adapter);

        button = findViewById(R.id.cvrtbtnId);

        //Precession Error Control
        final DecimalFormat decimalFormat = new DecimalFormat("###,###.##");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //kun item select korlo
                String value = spinner.getSelectedItem().toString();

                if(value.equals("USD"))
                {
                    takemoney.setInputType(InputType.TYPE_CLASS_NUMBER);
                    //BDT
                    double a = Integer.parseInt(takemoney.getText().toString());
                    double result1 = a*84.15;
                    rs1.setText(String.valueOf(decimalFormat.format(result1))+" Taka");

                    //INR
                    double b = Integer.parseInt(takemoney.getText().toString());
                    double result2 = b*69.01;
                    rs2.setText(String.valueOf(decimalFormat.format(result2))+" Rupee");
                }

                else if(value.equals("BDT"))
                {
                    takemoney.setInputType(InputType.TYPE_CLASS_NUMBER);
                    //BDT
                    double a = Integer.parseInt(takemoney.getText().toString());
                    double result1 = a*0.012;
                    rs1.setText(String.valueOf(decimalFormat.format(result1))+" Dollar");

                    //INR
                    double b = Integer.parseInt(takemoney.getText().toString());
                    double result2 = b*0.82;
                    rs2.setText(String.valueOf(decimalFormat.format(result2))+" Rupee");
                }

                else if(value.equals("INR"))
                {
                    takemoney.setInputType(InputType.TYPE_CLASS_NUMBER);
                    //BDT
                    double a = Integer.parseInt(takemoney.getText().toString());
                    double result1 = a*0.014;
                    rs1.setText(String.valueOf(decimalFormat.format(result1))+" Dollar");

                    //INR
                    double b = Integer.parseInt(takemoney.getText().toString());
                    double result2 = b*1.22;
                    rs2.setText(String.valueOf(decimalFormat.format(result2))+" Taka");
                }
            }
        });

    }
}
