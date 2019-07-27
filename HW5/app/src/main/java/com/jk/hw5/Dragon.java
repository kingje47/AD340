package com.jk.hw5;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;



public class Dragon {


    private String Color;
    private Integer Magic = 0;

    public Dragon(String color, Integer magic) {
        setColor(color);
        setMagic(magic);
    }

    public Dragon (Context ctx) {
        this.Color = null;
        this.Magic = 0;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        this.Color = color;
    }

    public void setMagic(Integer magic) {
        this.Magic = magic;
    }

    public Integer getMagic() {
        return Magic;
    }

    public void resetMagic() { Magic = 0;}



    public Integer clicker (View view) {
        boolean checked = ((CheckBox)view).isChecked();

        switch (view.getId()) {
            case R.id.checkbox_fire:
                if (checked)
                    Magic = Magic + 4;
                break;
            case R.id.checkbox_lightning:
                if (checked)
                    Magic = Magic + 1;
                break;
            case R.id.checkbox_water:
                if (checked)
                    Magic = Magic + 3;
                break;
        }
        return Magic;
    }



    public int colorLevel (String color) {
        int response = 0;

        if (color.equals("red")){
            response = response + 3;
        }

        if (color.equals("blue")){
            response = response + 2;
        }

        if (color.equals("green")){
            response = response + 5;
        }

        return response;

    }

}


