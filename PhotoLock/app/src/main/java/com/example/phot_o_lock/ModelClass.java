package com.example.phot_o_lock;

import android.graphics.Bitmap;

public class ModelClass {

    private String imageName;
    private Bitmap image;

    public ModelClass(String imageName, Bitmap image){
        this.image = image;
        this.imageName = imageName;
    }

    public String getImageName(){
        return imageName;
    }

    public Bitmap getImage(){
        return image;
    }

    public void setImageName(String imageName){
        this.imageName = imageName;

    }

    public void setImage(Bitmap image){
        this.image = image;
    }
}
