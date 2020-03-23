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

public class Main_6x6 extends AppCompatActivity {

    ImageButton view00,view01,view02,view03,view04,view05,view10,view11,view12,view13,view14,view15,
            view20,view21,view22,view23,view24,view25,view30,view31,view32,view33,view34,view35,
            view40,view41,view42,view43,view44,view45,view50,view51,view52,view53,view54,view55;
    String ids="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.matrix_6x6);



        view00 = findViewById(R.id.view00);
        view01 = findViewById(R.id.view01);
        view02 = findViewById(R.id.view02);
        view03 = findViewById(R.id.view03);
        view04 = findViewById(R.id.view04);
        view05 = findViewById(R.id.view05);

        view10 = findViewById(R.id.view10);
        view11 = findViewById(R.id.view11);
        view12 = findViewById(R.id.view12);
        view13 = findViewById(R.id.view13);
        view14 = findViewById(R.id.view14);
        view15 = findViewById(R.id.view15);


        view20 = findViewById(R.id.view20);
        view21 = findViewById(R.id.view21);
        view22 = findViewById(R.id.view22);
        view23 = findViewById(R.id.view23);
        view24 = findViewById(R.id.view24);
        view25 = findViewById(R.id.view25);

        view30 = findViewById(R.id.view30);
        view31 = findViewById(R.id.view31);
        view32 = findViewById(R.id.view32);
        view33 = findViewById(R.id.view33);
        view34 = findViewById(R.id.view34);
        view35 = findViewById(R.id.view35);

        view40 = findViewById(R.id.view40);
        view41 = findViewById(R.id.view41);
        view42 = findViewById(R.id.view42);
        view43 = findViewById(R.id.view43);
        view44 = findViewById(R.id.view44);
        view45 = findViewById(R.id.view45);

        view50 = findViewById(R.id.view50);
        view51 = findViewById(R.id.view51);
        view52 = findViewById(R.id.view52);
        view53 = findViewById(R.id.view53);
        view54 = findViewById(R.id.view54);
        view55 = findViewById(R.id.view55);

        ArrayList<ImageButton> imgView = new ArrayList<>();

        imgView.add(view00);
        imgView.add(view01);
        imgView.add(view02);
        imgView.add(view03);
        imgView.add(view04);
        imgView.add(view05);

        imgView.add(view10);
        imgView.add(view11);
        imgView.add(view12);
        imgView.add(view13);
        imgView.add(view14);
        imgView.add(view15);

        imgView.add(view20);
        imgView.add(view21);
        imgView.add(view22);
        imgView.add(view23);
        imgView.add(view24);
        imgView.add(view25);

        imgView.add(view30);
        imgView.add(view31);
        imgView.add(view32);
        imgView.add(view33);
        imgView.add(view34);
        imgView.add(view35);

        imgView.add(view40);
        imgView.add(view41);
        imgView.add(view42);
        imgView.add(view43);
        imgView.add(view44);
        imgView.add(view45);

        imgView.add(view50);
        imgView.add(view51);
        imgView.add(view52);
        imgView.add(view53);
        imgView.add(view54);
        imgView.add(view55);



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
            case R.id.view04:
                ids = ids+"view04";
                Log.i("TAG : ",ids);
                break;
            case R.id.view05:
                ids = ids+"view05";
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
            case R.id.view14:
                ids = ids+"view14";
                Log.i("TAG : ",ids);
                break;
            case R.id.view15:
                ids = ids+"view15";
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
            case R.id.view24:
                ids = ids+"view24";
                Log.i("TAG : ",ids);
                break;
            case R.id.view25:
                ids = ids+"view25";
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
            case R.id.view34:
                ids = ids+"view34";
                Log.i("TAG : ",ids);
                break;
            case R.id.view35:
                ids = ids+"view35";
                Log.i("TAG : ",ids);
                break;
            case R.id.view40:
                ids = ids+"view40";
                Log.i("TAG : ",ids);
                break;
            case R.id.view41:
                ids = ids+"view41";
                Log.i("TAG : ",ids);
                break;
            case R.id.view42:
                ids = ids+"view42";
                Log.i("TAG : ",ids);
                break;
            case R.id.view43:
                ids = ids+"view43";
                Log.i("TAG : ",ids);
                break;
            case R.id.view44:
                ids = ids+"view44";
                Log.i("TAG : ",ids);
                break;
            case R.id.view45:
                ids = ids+"view45";
                Log.i("TAG : ",ids);
                break;
            case R.id.view50:
                ids = ids+"view50";
                Log.i("TAG : ",ids);
                break;
            case R.id.view51:
                ids = ids+"view51";
                Log.i("TAG : ",ids);
                break;
            case R.id.view52:
                ids = ids+"view52";
                Log.i("TAG : ",ids);
                break;
            case R.id.view53:
                ids = ids+"view53";
                Log.i("TAG : ",ids);
                break;
            case R.id.view54:
                ids = ids+"view54";
                Log.i("TAG : ",ids);
                break;
            case R.id.view55:
                ids = ids+"view55";
                Log.i("TAG : ",ids);
                break;
            default:
//                ids = "default";
                Log.i("TAG : ",ids);
                break;


        }


    }


}
