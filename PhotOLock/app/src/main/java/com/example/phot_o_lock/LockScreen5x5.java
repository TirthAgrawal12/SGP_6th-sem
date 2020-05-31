package com.example.phot_o_lock;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class LockScreen5x5 extends AppCompatActivity {

    int count = 0;
    Context mContext;
    static String pass = "";
    String v1,v2;
    static int activity = 0;
    ImageButton view00,view01,view02,view03,view04,view10,view11,view12,view13,view14,view20,view21,
            view22,view23,view24,view30,view31,view32,view33,view34,view40,view41,view42,view43,
            view44;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lock_screen5x5);


        Bundle extras = getIntent().getExtras();
        v1 = extras.getString("name");
        v2 = extras.getString("pack");
        String path;


        mContext = this;
        view00 = findViewById(R.id.view00);
        view01 = findViewById(R.id.view01);
        view02 = findViewById(R.id.view02);
        view03 = findViewById(R.id.view03);
        view04 = findViewById(R.id.view04);

        view10 = findViewById(R.id.view10);
        view11 = findViewById(R.id.view11);
        view12 = findViewById(R.id.view12);
        view13 = findViewById(R.id.view13);
        view14 = findViewById(R.id.view14);


        view20 = findViewById(R.id.view20);
        view21 = findViewById(R.id.view21);
        view22 = findViewById(R.id.view22);
        view23 = findViewById(R.id.view23);
        view24 = findViewById(R.id.view24);

        view30 = findViewById(R.id.view30);
        view31 = findViewById(R.id.view31);
        view32 = findViewById(R.id.view32);
        view33 = findViewById(R.id.view33);
        view34 = findViewById(R.id.view34);

        view40 = findViewById(R.id.view40);
        view41 = findViewById(R.id.view41);
        view42 = findViewById(R.id.view42);
        view43 = findViewById(R.id.view43);
        view44 = findViewById(R.id.view44);

        ArrayList<ImageButton> imgView = new ArrayList<>();

        imgView.add(view00);
        imgView.add(view01);
        imgView.add(view02);
        imgView.add(view03);
        imgView.add(view04);

        imgView.add(view10);
        imgView.add(view11);
        imgView.add(view12);
        imgView.add(view13);
        imgView.add(view14);

        imgView.add(view20);
        imgView.add(view21);
        imgView.add(view22);
        imgView.add(view23);
        imgView.add(view24);

        imgView.add(view30);
        imgView.add(view31);
        imgView.add(view32);
        imgView.add(view33);
        imgView.add(view34);

        imgView.add(view40);
        imgView.add(view41);
        imgView.add(view42);
        imgView.add(view43);
        imgView.add(view44);


        Password_Database db = new Password_Database(LockScreen5x5.this);
        ArrayList<String> temp = new ArrayList<String>();
        Cursor res = db.getAllData();

        while (res.moveToNext()){

            temp.add(res.getString(1));
        }

        path = temp.get(0);

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
    public void onClick5(View view){


        switch (view.getId()){

            case R.id.view00:
                pass = pass+"view00";
                Log.i("TAG : ",pass);
                count++;
                break;
            case R.id.view01:
                pass = pass+"view01";
                Log.i("TAG : ",pass);
                count++;
                break;
            case R.id.view02:
                pass = pass+"view02";
                Log.i("TAG : ",pass);
                count++;
                break;
            case R.id.view03:
                pass = pass+"view03";
                Log.i("TAG : ",pass);
                count++;
                break;
            case R.id.view04:
                pass = pass+"view04";
                Log.i("TAG : ",pass);
                count++;
                break;
            case R.id.view10:
                pass = pass+"view10";
                Log.i("TAG : ",pass);
                count++;
                break;
            case R.id.view11:
                pass = pass+"view11";
                Log.i("TAG : ",pass);
                count++;
                break;
            case R.id.view12:
                pass = pass+"view12";
                Log.i("TAG : ",pass);
                count++;
                break;
            case R.id.view13:
                pass = pass+"view13";
                Log.i("TAG : ",pass);
                count++;
                break;
            case R.id.view14:
                pass = pass+"view14";
                Log.i("TAG : ",pass);
                count++;
                break;
            case R.id.view20:
                pass = pass+"view20";
                Log.i("TAG : ",pass);
                count++;
                break;
            case R.id.view21:
                pass = pass+"view21";
                Log.i("TAG : ",pass);
                count++;
                break;
            case R.id.view22:
                pass = pass+"view22";
                Log.i("TAG : ",pass);
                count++;
                break;
            case R.id.view23:
                pass = pass+"view23";
                Log.i("TAG : ",pass);
                count++;
                break;
            case R.id.view24:
                pass = pass+"view24";
                Log.i("TAG : ",pass);
                count++;
                break;
            case R.id.view30:
                pass = pass+"view30";
                Log.i("TAG : ",pass);
                count++;
                break;
            case R.id.view31:
                pass = pass+"view31";
                Log.i("TAG : ",pass);
                count++;
                break;
            case R.id.view32:
                pass = pass+"view32";
                Log.i("TAG : ",pass);
                count++;
                break;
            case R.id.view33:
                pass = pass+"view33";
                Log.i("TAG : ",pass);
                count++;
                break;
            case R.id.view34:
                pass = pass+"view34";
                Log.i("TAG : ",pass);
                count++;
                break;
            case R.id.view40:
                pass = pass+"view40";
                Log.i("TAG : ",pass);
                count++;
                break;
            case R.id.view41:
                pass = pass+"view41";
                Log.i("TAG : ",pass);
                count++;
                break;
            case R.id.view42:
                pass = pass+"view42";
                Log.i("TAG : ",pass);
                count++;
                break;
            case R.id.view43:
                pass = pass+"view43";
                Log.i("TAG : ",pass);
                count++;
                break;
            case R.id.view44:
                pass = pass+"view44";
                Log.i("TAG : ",pass);
                count++;
                break;
            default:
                //pass = pass+"default";
                Log.i("TAG : ","KUCH NAHI HO RAHA HAI...");
                break;


        }
        if (count == 4){
//            Bundle extras = getIntent().getExtras();
//            v1 = extras.getString("name");
//            v2 = extras.getString("pack");
            if (v1.equals(pass)) {

                pass = "";
                count = 0;
                activity = 1;
                Toast.makeText(LockScreen5x5.this,   "Password Correct" , Toast.LENGTH_LONG).show();

                Intent launchIntent = getPackageManager().getLaunchIntentForPackage(v2);
                launchIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                finish();

                mContext.startActivity(launchIntent);


            }
            else{
                pass = "";
                count = 0;
                Toast.makeText(LockScreen5x5.this,   "wrong password", Toast.LENGTH_LONG).show();

                activity = 0;
                Log.i("EMPTY : .....",pass);
//                t1.setText("");
            }

        }


    }

}
