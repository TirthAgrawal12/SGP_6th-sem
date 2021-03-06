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

public class LockScreen3x3 extends AppCompatActivity {

    int count = 0;
    Context mContext;
    static String pass = "";
    String v1,v2;
    static int activity = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lock_screen3x3);


        Bundle extras = getIntent().getExtras();
        v1 = extras.getString("name");
        v2 = extras.getString("pack");

        mContext = this;
        ImageButton view00,view01,view02,view10,view11,view12,view20,view21,view22;
//        Button setLock;
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

//        Log.i("TAG ID : ",""+R.id.view00);

        Password_Database db = new Password_Database(LockScreen3x3.this);
        ArrayList<String> temp = new ArrayList<String>();
        Cursor res = db.getAllData();
        while (res.moveToNext()){

            temp.add(res.getString(1));
        }
        for (int i=0;i<temp.size();i++){

//            Log.i("PATH : ........",temp.get(i));
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
    public void onClick3(View view){

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
            default:
                //pass = pass+"view00";
                Log.i("DEFAULT : ",pass);
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
                Toast.makeText(LockScreen3x3.this,   "Password Correct" , Toast.LENGTH_LONG).show();

                Intent launchIntent = getPackageManager().getLaunchIntentForPackage(v2);
                launchIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                finish();

                mContext.startActivity(launchIntent);


            }
            else{
                pass = "";
                count = 0;
                Toast.makeText(LockScreen3x3.this,   "wrong password", Toast.LENGTH_LONG).show();

                activity = 0;
                Log.i("EMPTY : .....",pass);
//                t1.setText("");
            }

        }


    }

}
