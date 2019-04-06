package com.example.user.converterapplication;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Number extends AppCompatActivity {

    EditText number;
    Button convert;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);

        //Text sajay dewa
        TextView headText = findViewById(R.id.headtxtId12);
        Typeface typeface1 = Typeface.createFromAsset(getAssets(),"croissant sandwich-bold.ttf");
        headText.setPaintFlags(headText.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        headText.setTypeface(typeface1);

        //Text sajay dewa
        TextView headText2 = findViewById(R.id.headtxtId22);
        Typeface typeface2 = Typeface.createFromAsset(getAssets(),"croissant sandwich-bold.ttf");
        headText2.setTypeface(typeface2);

        number = findViewById(R.id.numberId);
        convert = findViewById(R.id.convertBtnId);
        result = findViewById(R.id.resultViewId);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int dec = Integer.parseInt(number.getText().toString());
                String bin = Integer.toBinaryString(dec);
                String oct = Integer.toOctalString(dec);
                String hex = Integer.toHexString(dec);

                result.setText("DEC: "+dec+ "\n\n"+
                        "BIN: "+bin+ "\n\n"+
                        "OCT: "+oct+ "\n\n"+
                        "HEX: "+hex+ "\n\n");
            }
        });
    }
}
