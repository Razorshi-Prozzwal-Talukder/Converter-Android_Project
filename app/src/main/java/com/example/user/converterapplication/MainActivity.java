package com.example.user.converterapplication;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView temperatureConvert, moneyConvert, numberConvert, scaleConvert, formula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //define cards
        temperatureConvert = findViewById(R.id.temperatureConvertId);
        moneyConvert = findViewById(R.id.moneyConvertId);
        numberConvert = findViewById(R.id.numberConvertId);
        scaleConvert = findViewById(R.id.scaleConvertId);
        formula = findViewById(R.id.formulaId);

        //Add Click listener
        temperatureConvert.setOnClickListener(this);
        moneyConvert.setOnClickListener(this);
        numberConvert.setOnClickListener(this);
        scaleConvert.setOnClickListener(this);
        formula.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        Intent i;
        switch (view.getId()){
            case R.id.temperatureConvertId : i= new Intent(this,Temperature.class);startActivity(i);break;
            case R.id.moneyConvertId : i= new Intent(this,Money.class);startActivity(i);break;
            case R.id.numberConvertId : i= new Intent(this,Number.class);startActivity(i);break;
            case R.id.scaleConvertId : i= new Intent(this,Scale.class);startActivity(i);break;
            case R.id.formulaId : i= new Intent(this,Formula.class);startActivity(i);break;
            default:break;
        }

    }
}
