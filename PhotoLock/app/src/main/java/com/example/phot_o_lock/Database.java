package com.example.phot_o_lock;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.Toast;
import java.io.ByteArrayOutputStream;


public class Database extends SQLiteOpenHelper {

    private Context context;
    private static int count = 0;
    private static String DATABASE_NAME = "mydb.db";
    private static int DATABASE_VERSION = 1;

    Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try {

            String createTableQuery = "create table myTable (imageName TEXT" + ",image BLOB" + ",Password TEXT" + ",matrixSize INT)";
            db.execSQL(createTableQuery);
            Toast.makeText(context,"Table created successfully...",Toast.LENGTH_LONG).show();

        }catch (Exception e){
            Toast.makeText(context,"ERROR : "+e.getMessage(),Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public Bitmap fetchImage(){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Bitmap retrivedImage = null;
        Cursor cursor = sqLiteDatabase.rawQuery("select * from myTable where imageName = ?",new String[]{"password"});
        if (cursor.moveToNext()){
            byte[] imageFromDatabase = cursor.getBlob(1);
            retrivedImage = BitmapFactory.decodeByteArray(imageFromDatabase,0,imageFromDatabase.length);
        }
        cursor.close();
        sqLiteDatabase.close();
        return retrivedImage;
    }

    void storeImage(ModelClass objModelClass) {

        if (count == 0) {
            try {

                count++;
                SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
                Bitmap imageToStoreBitmap = objModelClass.getImage();

                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                imageToStoreBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);

                byte[] imageInBytes = byteArrayOutputStream.toByteArray();
                ContentValues contentValues = new ContentValues();
                contentValues.put("imageName", objModelClass.getImageName());
                contentValues.put("image", imageInBytes);
                contentValues.put("matrixSize",objModelClass.getMatrixSize());

                long checkIfQueryRuns = sqLiteDatabase.insert("myTable", null, contentValues);
                if (checkIfQueryRuns != -1) {
                    Toast.makeText(context, "Image inserted into table ...", Toast.LENGTH_LONG).show();
                    sqLiteDatabase.close();
                } else {
                    Toast.makeText(context, "Failed to add data into table ...", Toast.LENGTH_LONG).show();
                }

                sqLiteDatabase.close();
            } catch (Exception e) {
                Toast.makeText(context, "ERROR : " + e.getMessage(), Toast.LENGTH_LONG).show();
            }

        }
    }

    void setPassword(String pass){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Password",pass);
        sqLiteDatabase.update("myTable",contentValues,"imageName = ?",new String[]{"password"});
        Toast.makeText(context,"Password updated...",Toast.LENGTH_LONG).show();
        sqLiteDatabase.close();

    }

    String getPassword(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT Password from myTable",null);
        String pas ="";
        if (cursor.moveToFirst()){
            pas = cursor.getString(cursor.getColumnIndex("Password"));
        }
        cursor.close();
        sqLiteDatabase.close();
        return pas;
    }

}