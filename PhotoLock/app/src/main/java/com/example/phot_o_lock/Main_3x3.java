package com.example.phot_o_lock;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main_3x3 extends AppCompatActivity {


    int count = 0;
    String ids="";

//    Intent i = getIntent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_3x3);


        final Context context = this;
        ImageButton view00,view01,view02,view10,view11,view12,view20,view21,view22;
        Button setLock;
        String path;

        ArrayList<ImageButton> imgView = new ArrayList<>();

        view00 = findViewById(R.id.view00);
        view01 = findViewById(R.id.view01);
        view02 = findViewById(R.id.view02);
        view10 = findViewById(R.id.view10);
        view11 = findViewById(R.id.view11);
        view12 = findViewById(R.id.view12);
        view20 = findViewById(R.id.view20);
        view21 = findViewById(R.id.view21);
        view22 = findViewById(R.id.view22);


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

        path = Model.getPath().getAbsolutePath();

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

    public void onClick3(View view){

        switch (view.getId()){

            case R.id.view00:
                ids = ids+"view00";
                Log.i("TAG : ",ids);
                count++;
                break;
            case R.id.view01:
                ids = ids+"view01";
                Log.i("TAG : ",ids);
                count++;
                break;
            case R.id.view02:
                ids = ids+"view02";
                Log.i("TAG : ",ids);
                count++;
                break;
            case R.id.view10:
                ids = ids+"view10";
                Log.i("TAG : ",ids);
                count++;
                break;
            case R.id.view11:
                ids = ids+"view11";
                Log.i("TAG : ",ids);
                count++;
                break;
            case R.id.view12:
                ids = ids+"view12";
                Log.i("TAG : ",ids);
                count++;
                break;
            case R.id.view20:
                ids = ids+"view20";
                Log.i("TAG : ",ids);
                count++;
                break;
            case R.id.view21:
                ids = ids+"view21";
                Log.i("TAG : ",ids);
                count++;
                break;
            case R.id.view22:
                ids = ids+"view22";
                Log.i("TAG : ",ids);
                count++;
                break;
            default:
                //ids = ids+"view00";
                Log.i("TAG : ",ids);
                break;

        }
        if (count == 4){
            Password_Database database = new Password_Database(this);
            database.insertData(ids,null);

            startActivity(new Intent(Main_3x3.this,lockapp_activity.class));

        }


    }


}
