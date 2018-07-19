package com.example.rodolfo.mcda5550;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Date;

public class BMIResult {
    private double height = 1;
    private double weight = 1;

    public BMIResult(double height, double weight) {
        this.height = height;
        this.weight = weight;
        //this.dob = dob;

    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

 //   public  getDob() {
  //      return dob;
   // }

   // public void setDob(Date dob) {
   //     this.dob = dob;
   // }

    public double getResult()
    {
        return weight/(height*height);

    }

    public String toString()
    {
        return String.valueOf(getResult());
    }
}
