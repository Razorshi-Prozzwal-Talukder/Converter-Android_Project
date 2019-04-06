package com.example.user.converterapplication;

import java.text.NumberFormat;

class Length_Conversion {
    //constant variable for unit comparision and conversion
    //the base unit reference will be 1 meter
    final double meters = 1;
    final double centimeters = 100;
    final double kilometers = 0.001;
    final double inches = 39.37;
    final double feet = 3.281;
    final double miles = 0.0006214;
    final double millimeters = 1000;
    final double yards = 1.093613;

    //variables for for input and output
    private double beginning_qty;
    private double ending_qty;
    private String beginning_unit_type;
    private String ending_unit_type;

    //constructor
    public Length_Conversion(){
        beginning_qty = 0;
        ending_qty = 0;
        beginning_unit_type = "";
        ending_unit_type = "";
    }

    public double getBeginning_qty(){
        return beginning_qty;
    }

    public void setBeginning_qty(double beginning_qty){
        this.beginning_qty = beginning_qty;
    }

    public double getEnding_qty(){
        return ending_qty;
    }


    public String getBeginning_unit_type() {
        return beginning_unit_type;
    }

    public void setBeginning_unit_type(String beginning_unit_type) {
        this.beginning_unit_type = beginning_unit_type;
    }

    public String getEnding_unit_type() {
        return ending_unit_type;
    }

    public void setEnding_unit_type(String ending_unit_type) {
        this.ending_unit_type = ending_unit_type;
    }

    public void setEnding_qty(double ending_qty){
        this.ending_qty = ending_qty;
    }

    public double getUnitTypeConstant(String unit_type){
        if(unit_type == "Meters"){return meters;}
        if(unit_type == "Centimeters"){return centimeters;}
        if(unit_type == "Kilometers"){return kilometers;}
        if(unit_type == "Inches"){return inches;}
        if(unit_type == "Feet"){return feet;}
        if(unit_type == "Miles"){return miles;}
        if(unit_type == "Milimeters"){return millimeters;}
        if(unit_type == "Yards"){return yards;}

        return 0;
    }

    public double calculateEnding_qty(){

        //declare and initialize variable
        double beginning_qty = getBeginning_qty();
        double ending_qty = getEnding_qty();
        double beginning_unit_type = getUnitTypeConstant(getBeginning_unit_type());
        double ending_unit_type = getUnitTypeConstant(getEnding_unit_type());

        //convert to meters
        ending_qty = meters/beginning_unit_type;

        //convert from meters
        ending_qty = ending_qty * ending_unit_type;

        //multiply by initial quantity to get final quantity
        ending_qty = ending_qty * beginning_qty;

        return  ending_qty;
    }

    public String toString(){
        //create a number format object
        NumberFormat nf = NumberFormat.getNumberInstance();

        if(ending_unit_type.equals("Inches") || ending_unit_type.equals("Feet")
                    ||ending_unit_type.equals("Yards")){
            nf.setMaximumFractionDigits(2);
        }

        else {
            //format the maximum significant figures to four places
            nf.setMaximumFractionDigits(4);
        }

        return nf.format(getEnding_qty()) + " " + getEnding_unit_type();
    }

}
