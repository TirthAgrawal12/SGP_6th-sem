package com.example.phot_o_lock;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;

//public class Database extends SQLiteDatabase{
//
//
//
//    public void insert(byte byteArray[]){
//
////        byte[] byteArray = convertIntoBytes(bitmap);
//        String temp = "";
//
//        for (int i=0;i<byteArray.length;i++){
//            temp = temp + byteArray[i];
//        }
//
//        Log.i("BYTE ARRAY : ",""+temp);
//        try {
//
//            SQLiteDatabase db;
//            db = openOrCreateDatabase("Phot-o-Lock", MODE_PRIVATE, null);
//            db.execSQL("CREATE TABLE IF NOT EXISTS details(Photo BLOB);");
//            db.execSQL("INSERT INTO details VALUES('" + temp + "')");
//
//            Log.i("MSG : ", "Success");
//
//        }catch (Exception e){
//            Log.i("ERROR : ",e.getMessage());
//        }
//
//    }
//
//}

public class Database extends SQLiteOpenHelper {

    Context context;
    private static String DATABASE_NAME = "mydb.db";
    private static int DATABASE_VERSION = 1;
    private static String createTableQuery = "create table myTable (imageName TEXT" + ",image BLOB)";
    private ByteArrayOutputStream byteArrayOutputStream;
    private byte[] imageInBytes;

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try {

            db.execSQL(createTableQuery);
            Toast.makeText(context,"Table created successfully...",Toast.LENGTH_LONG).show();

        }catch (Exception e){
            Toast.makeText(context,"ERROR : "+e.getMessage(),Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public void storeImage(ModelClass objModelClass){

        try {

            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
            Bitmap imageToStoreBitmap = objModelClass.getImage();

            byteArrayOutputStream = new ByteArrayOutputStream();
            imageToStoreBitmap.compress(Bitmap.CompressFormat.PNG,100,byteArrayOutputStream);

            imageInBytes = byteArrayOutputStream.toByteArray();
            ContentValues contentValues = new ContentValues();
            contentValues.put("imageName",objModelClass.getImageName());
            contentValues.put("image",imageInBytes);

            long checkIfQueryRuns = sqLiteDatabase.insert("myTable",null,contentValues);
            if (checkIfQueryRuns != -1){
                Toast.makeText(context,"Data inserted into table ...",Toast.LENGTH_LONG).show();
                sqLiteDatabase.close();
            }
            else {
                Toast.makeText(context,"Failed to add data into table ...",Toast.LENGTH_LONG).show();
            }

        }catch (Exception e){
            Toast.makeText(context,"ERROR : "+e.getMessage(),Toast.LENGTH_LONG).show();
        }

    }

}