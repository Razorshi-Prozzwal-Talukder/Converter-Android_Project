package com.example.user.converterapplication;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Scale extends AppCompatActivity {

    Spinner cvrtfrmspin, cvrttospin;

    Button convertbtn;

    //this array is for the spinner items (the unit type for selection)
    //it is also arranged in alphabetical order

    String[] unitTypes = {"Centimeters", "Feet", "Inches", "Kilometers", "Meters", "Miles",
                            "Milimeters", "Yards"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale);

        //Text sajay dewa
        TextView headText = findViewById(R.id.headtxtId13);
        Typeface typeface1 = Typeface.createFromAsset(getAssets(),"croissant sandwich-bold.ttf");
        headText.setPaintFlags(headText.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        headText.setTypeface(typeface1);

        //Text sajay dewa
        TextView headText2 = findViewById(R.id.headtxtId23);
        Typeface typeface2 = Typeface.createFromAsset(getAssets(),"croissant sandwich-bold.ttf");
        headText2.setTypeface(typeface2);

        //set spinner variable to the corresponding spinner components
        cvrtfrmspin = findViewById(R.id.cvrtfrmspinId);
        cvrttospin = findViewById(R.id.cvrttospinId);

        //setUp addapter for the layout of spinner
        //connect spinner array with items
        //simple spinner too small so i connect with list item 1

        ArrayAdapter<String> spinnerAdapter =  new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                                                unitTypes);

        //now set adapter to spinner
        cvrtfrmspin.setAdapter(spinnerAdapter);
        cvrttospin.setAdapter(spinnerAdapter);

        convertbtn = findViewById(R.id.cvrtbtnId);

        convertbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double beginning_qty, ending_qty;
                String beginning_unit_type, ending_unit_type;

                    //declare components
                EditText qtyEditText = findViewById(R.id.cvrtfrmtextId);
                TextView resultoutputTextView = findViewById(R.id.resultId);

                //create object for length conversion
                Length_Conversion lengthConverter = new Length_Conversion();

                //check the qty field that entered
                if(!qtyEditText.getText().toString().equals(""))
                {
                    //get input user data from field

                    beginning_qty = Double.parseDouble(qtyEditText.getText().toString());
                    beginning_unit_type = cvrtfrmspin.getSelectedItem().toString();
                    ending_unit_type = cvrttospin.getSelectedItem().toString();


                    //input data into object

                    lengthConverter.setBeginning_qty(beginning_qty);
                    lengthConverter.setBeginning_unit_type(beginning_unit_type);
                    lengthConverter.setEnding_unit_type(ending_unit_type);

                    //calculate the conversion result
                    ending_qty = lengthConverter.calculateEnding_qty();
                    lengthConverter.setEnding_qty(ending_qty);

                    //output the conversion result to console
                    resultoutputTextView.setText(lengthConverter.toString());
                }
                else
                {
                    //create a tost sms to enter quantity
                    Context context = getApplicationContext();
                    CharSequence text = "Enter Quantity";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }


            }
        });
    }

}
