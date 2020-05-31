package com.example.phot_o_lock;

import android.graphics.drawable.Drawable;

import java.io.File;

public class Model {

    private String name;
    Drawable icon;
    int locked;
    String packageName;
    public static File path;
    private static int matrixSize;


    public Model(){}

    public Model(String name, Drawable icon, int locked, String packageName){
        this.name = name;
        this.locked = locked;
        this.packageName = packageName;
        this.icon = icon;
    }

    public Model(String name, Drawable icon, int locked, String packageName, File path){
        this.name = name;
        this.locked = locked;
        this.packageName = packageName;
        this.icon = icon;
        this.path = path;
    }

    public static File getPath(){ return path;}

    public static void setPath(File path){ Model.path = path;}

    public String getName(){ return  name; }

    public void setName(String name){ this.name = name; }

    public Drawable getIcon(){ return icon; }

    public void setIcon(Drawable icon){ this.icon = icon; }

    public String getPackageName(){ return  packageName; }

    public void setPackageName(String packageName){ this.packageName = packageName; }

    public int getLocked(){ return locked; }

    public void setLocked(int locked){ this.locked = locked; }

    public static int getMatrixSize(){
        return matrixSize;
    }

    public static void setMatrixSize(int matrixSize){ Model.matrixSize = matrixSize; }


}
