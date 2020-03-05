package com.example.phot_o_lock;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;


public class SplitImage{

   // int chunkNumbers = 9;
    ArrayList<Bitmap> chunkedImages;

    public ArrayList<Bitmap> splitImage(ImageView image, int chunkNumbers) {

        //For the number of rows and columns of the grid to be displayed
        int rows,cols;

        //For height and width of the small image chunks
        int chunkHeight,chunkWidth;

        //To store all the small image chunks in bitmap format in this list
        chunkedImages = new ArrayList<Bitmap>(chunkNumbers);

        //Getting the scaled bitmap of the source image
        BitmapDrawable drawable = (BitmapDrawable) image.getDrawable();
        Bitmap bitmap = drawable.getBitmap();


        /*ByteArrayOutputStream stream = new ByteArrayOutputStream();
    bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);*/

    Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), true);
        Log.i("Height : ",""+bitmap.getHeight());
        Log.i("Width : ",""+bitmap.getWidth());

        rows = cols = (int) Math.sqrt(chunkNumbers);
        chunkHeight = bitmap.getHeight()/rows;
        chunkWidth = bitmap.getWidth()/cols;
    /*chunkHeight = 300/rows;
    chunkWidth = 300/cols;*/

        //xCoord and yCoord are the pixel positions of the image chunks
        int yCoord = 0;
        for(int x=0; x<rows; x++){
            int xCoord = 0;
            for(int y=0; y<cols; y++){
                chunkedImages.add(Bitmap.createBitmap(scaledBitmap, xCoord, yCoord, chunkWidth, chunkHeight));
                xCoord += chunkWidth;
            }
            yCoord += chunkHeight;
        }


        return chunkedImages;
     //   return mergeImage(chunkedImages);

    }

    Bitmap mergeImage(ArrayList<Bitmap> imageChunks) {

        Collections.shuffle(imageChunks);

        //Get the width and height of the smaller chunks
        int chunkWidth = imageChunks.get(0).getWidth();
        int chunkHeight = imageChunks.get(0).getHeight();

        //create a bitmap of a size which can hold the complete image after merging
        Bitmap bitmap = Bitmap.createBitmap(chunkWidth * 5, chunkHeight * 5,  Bitmap.Config.ARGB_4444);

        //create a canvas for drawing all those small images
        Canvas canvas = new Canvas(bitmap);
        int count = 0;
        for(int rows = 0; rows < 5; rows++){
            for(int cols = 0; cols < 5; cols++){
                canvas.drawBitmap(imageChunks.get(count), chunkWidth * cols, chunkHeight * rows, null);
                count++;
            }
        }


        return bitmap;
    }
}







