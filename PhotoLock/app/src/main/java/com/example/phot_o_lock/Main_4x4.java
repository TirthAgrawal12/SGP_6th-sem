package com.example.phot_o_lock;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main_4x4 extends AppCompatActivity {

    ImageButton view00,view01,view02,view03,view10,view11,view12,view13,view20,view21,view22,view23,view30,view31,view32,view33;
    String ids="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.matrix_4x4);



        view00 = findViewById(R.id.view00);
        view01 = findViewById(R.id.view01);
        view02 = findViewById(R.id.view02);
        view03 = findViewById(R.id.view03);

        view10 = findViewById(R.id.view10);
        view11 = findViewById(R.id.view11);
        view12 = findViewById(R.id.view12);
        view13 = findViewById(R.id.view13);

        view20 = findViewById(R.id.view20);
        view21 = findViewById(R.id.view21);
        view22 = findViewById(R.id.view22);
        view23 = findViewById(R.id.view23);

        view30 = findViewById(R.id.view30);
        view31 = findViewById(R.id.view31);
        view32 = findViewById(R.id.view32);
        view33 = findViewById(R.id.view33);

        ArrayList<ImageButton> imgView = new ArrayList<>();

        imgView.add(view00);
        imgView.add(view01);
        imgView.add(view02);
        imgView.add(view03);

        imgView.add(view10);
        imgView.add(view11);
        imgView.add(view12);
        imgView.add(view13);

        imgView.add(view20);
        imgView.add(view21);
        imgView.add(view22);
        imgView.add(view23);

        imgView.add(view30);
        imgView.add(view31);
        imgView.add(view32);
        imgView.add(view33);


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
                ids = ids+"view00";
                Log.i("TAG : ",ids);
                break;
            case R.id.view01:
                ids = ids+"view01";
                Log.i("TAG : ",ids);
                break;
            case R.id.view02:
                ids = ids+"view02";
                Log.i("TAG : ",ids);
                break;
            case R.id.view03:
                ids = ids+"view03";
                Log.i("TAG : ",ids);
                break;
            case R.id.view10:
                ids = ids+"view10";
                Log.i("TAG : ",ids);
                break;
            case R.id.view11:
                ids = ids+"view11";
                Log.i("TAG : ",ids);
                break;
            case R.id.view12:
                ids = ids+"view12";
                Log.i("TAG : ",ids);
                break;
            case R.id.view13:
                ids = ids+"view13";
                Log.i("TAG : ",ids);
                break;
            case R.id.view20:
                ids = ids+"view20";
                Log.i("TAG : ",ids);
                break;
            case R.id.view21:
                ids = ids+"view21";
                Log.i("TAG : ",ids);
                break;
            case R.id.view22:
                ids = ids+"view22";
                Log.i("TAG : ",ids);
                break;
            case R.id.view23:
                ids = ids+"view23";
                Log.i("TAG : ",ids);
                break;
            case R.id.view30:
                ids = ids+"view30";
                Log.i("TAG : ",ids);
                break;
            case R.id.view31:
                ids = ids+"view31";
                Log.i("TAG : ",ids);
                break;
            case R.id.view32:
                ids = ids+"view32";
                Log.i("TAG : ",ids);
                break;
            case R.id.view33:
                ids = ids+"view33";
                Log.i("TAG : ",ids);
                break;
            default:
                //ids = "default";
                Log.i("TAG : ",ids);
                break;


        }


    }


}
