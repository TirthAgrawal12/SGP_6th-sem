package com.example.phot_o_lock;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;


public class SetLock extends AppCompatActivity {



    ArrayList<Bitmap> pics = new ArrayList<>();
    Button open_gallery,create_matrix;
    ImageView imageview;
    static int matrix_size = 3;
    static Bitmap bitmap;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_lock);




        create_matrix = findViewById(R.id.intent);
        open_gallery = findViewById(R.id.gallery);
        imageview = findViewById(R.id.imageview);

        open_gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent photoPickerIntent = new Intent();
                photoPickerIntent.setType("image/*");
                photoPickerIntent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(photoPickerIntent,"Select Picture"),1);


            }
        });

        create_matrix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

             /*   for (int i = 0;i<pics.size();i++) {
                    Bitmap resized = Bitmap.createScaledBitmap(pics.get(i), 1080, 2160, true);
                    pics.set(i,resized);
                }*/

                SplitImage si = new SplitImage();
                Log.i("SIZE : ",""+matrix_size);
                pics = si.splitImage(imageview,matrix_size*matrix_size);

                ContextWrapper cw = new ContextWrapper(getApplicationContext());
                // path to /data/data/yourapp/app_data/imageDir
                File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
                for (int i = 0;i<pics.size();i++) {

                    String s = "" + i + ".png";
                    File mypath = new File(directory, s);
                    try {

                        FileOutputStream fos;
                        fos = new FileOutputStream(mypath);
                        pics.get(i).compress(Bitmap.CompressFormat.PNG, 100, fos);
                        fos.close();
                        Toast.makeText(getBaseContext(), "File saved successfully!",
                                Toast.LENGTH_SHORT).show();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                if (matrix_size == 3){

                    Intent intent = new Intent(SetLock.this,Main_3x3.class);

                    String path = directory.getAbsolutePath();
                    intent.putExtra("Final_Path",path);
                    startActivity(intent);

                    Log.i("INFO : ",""+new Database(getApplicationContext()).getPassword());

                }
                else if(matrix_size == 4){

                    Intent intent = new Intent(SetLock.this,Main_4x4.class);

                    String path = directory.getAbsolutePath();
                    intent.putExtra("Final_Path",path);
                    startActivity(intent);

                }
                else if(matrix_size == 5){

                    Intent intent = new Intent(SetLock.this,Main_5x5.class);

                    String path = directory.getAbsolutePath();
                    intent.putExtra("Final_Path",path);
                    startActivity(intent);

                }
                else{

                    Intent intent = new Intent(SetLock.this,Main_6x6.class);

                    String path = directory.getAbsolutePath();
                    intent.putExtra("Final_Path",path);
                    startActivity(intent);

                }

                storeImageInDatabase();

//                Database database = new Database(getApplicationContext());
//                database.storeImage(new ModelClass("password",bitmap));
//

            }
        });



    }


    public int onRadioButtonClicked(View view){

        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()){
            case R.id.matrix_3x3:
                if (checked){
                    matrix_size = 3;

                }
                break;
            case R.id.matrix_4x4:
                if (checked){
                    matrix_size = 4;

                }
                break;
            case R.id.matrix_5x5:
                if (checked){
                    matrix_size = 5;

                }
                break;
            case R.id.matrix_6x6:
                if (checked){
                    matrix_size = 6;

                }
                break;
            default:
                matrix_size = 3;
                break;


        }
        return matrix_size;
    }

    public void storeImageInDatabase(){
        Database database = new Database(this);
        database.storeImage(new ModelClass("password",bitmap,matrix_size));
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK && requestCode == 1 && data != null && data.getData() != null){

            Uri uri = data.getData();

            try {

                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
//
//                ByteArrayOutputStream stream = new ByteArrayOutputStream();
//                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
//                //IMAGE CONVERTED TO BYTE ARRAY...
//                byte[] byteArray = stream.toByteArray();
//
//
//                Database database = new Database(this);
//                database.storeImage(new ModelClass("password",bitmap));
//
//                bitmap = database.fetchImage();
               // ModelClass modelClass = new ModelClass("Password",bitmap,matrix_size);

                imageview.setImageBitmap(bitmap);


            }catch (Exception e){
                e.printStackTrace();

            }
        }
    }

}



