package com.jk.hw5;

import android.content.Context;

public class Dragon {


    private String Color;
    private String Magic;

    public Dragon(String color, String magic) {
        setColor(color);
        setMagic(magic);
    }

    public Dragon (Context ctx) {
        this.Color = null;
        this.Magic = null;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        this.Color = color;
    }

    public void setMagic(String magic) {
        this.Magic = magic;
    }

    public String getMagic() {
        return Magic;
    }


    public int magicLevel (String magic) {
        int response = 0;

        if (magic.equals("fire")){
            response = response + 4;
        }

        if (magic.equals("lightning")) {
            response = response + 1;
        }

        if (magic.equals("water")){
            response = response + 3;
        }

        return response;
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


