package com.example.phot_o_lock;

import android.graphics.Bitmap;

class ModelClass {

    private String imageName;
    private Bitmap image;
    private int matrixSize;

    ModelClass(String imageName, Bitmap image, int matrixSize){
        this.image = image;
        this.imageName = imageName;
        this.matrixSize = matrixSize;
    }

    String getImageName(){
        return imageName;
    }

    Bitmap getImage(){
        return image;
    }

    int getMatrixSize(){
        return matrixSize;
    }

}
