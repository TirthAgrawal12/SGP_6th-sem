package com.example.phot_o_lock;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main_3x3 extends AppCompatActivity {

    ImageButton view00,view01,view02,view10,view11,view12,view20,view21,view22;
    TextView show;
    String ids="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_3x3);



        view00 = findViewById(R.id.view00);
        view01 = findViewById(R.id.view01);
        view02 = findViewById(R.id.view02);
        view10 = findViewById(R.id.view10);
        view11 = findViewById(R.id.view11);
        view12 = findViewById(R.id.view12);
        view20 = findViewById(R.id.view20);
        view21 = findViewById(R.id.view21);
        view22 = findViewById(R.id.view22);

        ArrayList<ImageButton> imgView = new ArrayList<>();

        imgView.add(view00);
        imgView.add(view01);
        imgView.add(view02);
        imgView.add(view10);
        imgView.add(view11);
        imgView.add(view12);
        imgView.add(view20);
        imgView.add(view21);
        imgView.add(view22);


        Log.i("TAG ID : ",""+R.id.view00);
        Intent i = getIntent();
        String path = i.getStringExtra("Final_Path");

        for (int j=0;j<imgView.size();j++){

            String image = ""+j+".png";
            try {
                File f=new File(path, image);
                Bitmap b = BitmapFactory.decodeStream(new FileInputStream(f));
                imgView.get(j).setImageBitmap(b);
            }catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }


        }



    }

    public void onClick(View view){
        switch (view.getId()){

            case R.id.view00:
                ids = "view00";
                Log.i("TAG : ",ids);
                break;
            case R.id.view01:
                ids = "view01";
                Log.i("TAG : ",ids);
                break;
            case R.id.view02:
                ids = "view02";
                Log.i("TAG : ",ids);
                break;
            case R.id.view10:
                ids = "view10";
                Log.i("TAG : ",ids);
                break;
            case R.id.view11:
                ids = "view11";
                Log.i("TAG : ",ids);
                break;
            case R.id.view12:
                ids = "view12";
                Log.i("TAG : ",ids);
                break;
            case R.id.view20:
                ids = "view20";
                Log.i("TAG : ",ids);
                break;
            case R.id.view21:
                ids = "view21";
                Log.i("TAG : ",ids);
                break;
            case R.id.view22:
                ids = "view22";
                Log.i("TAG : ",ids);
                break;
            default:
                //ids = ids+"view00";
                Log.i("TAG : ",ids);
                break;


        }


    }


}