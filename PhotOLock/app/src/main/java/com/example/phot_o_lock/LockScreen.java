package com.example.phot_o_lock;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LockScreen extends AppCompatActivity {



    Button btn;
    EditText t1;
    TextView status;
    String password;
    static int count = 0;

    String v1 , v2;
    public LockScreen(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();
        v1 = extras.getString("name");
        v2 = extras.getString("pack");



            switch (Model.getMatrixSize()) {

                case 3:
                    Log.i("MATRIX_SIZE : ", "" + Model.getMatrixSize());
                    Intent intent3x3 = new Intent(LockScreen.this, LockScreen3x3.class);
                    intent3x3.putExtra("name", v1);
                    intent3x3.putExtra("pack", v2);
                    startActivity(intent3x3);

//                        finish();
                        break;

                case 4:
                    Log.i("MATRIX_SIZE : ", "" + Model.getMatrixSize());
                    Intent intent4x4 = new Intent(LockScreen.this, LockScreen4x4.class);
                    intent4x4.putExtra("name", v1);
                    intent4x4.putExtra("pack", v2);
                    startActivity(intent4x4);

                    break;
                case 5:
                    Log.i("MATRIX_SIZE : ", "" + Model.getMatrixSize());
                    Intent intent5x5 = new Intent(LockScreen.this, LockScreen5x5.class);
                    intent5x5.putExtra("name", v1);
                    intent5x5.putExtra("pack", v2);
                    startActivity(intent5x5);

                    break;
                case 6:
                    Log.i("MATRIX_SIZE : ", "" + Model.getMatrixSize());
                    Intent intent6x6 = new Intent(LockScreen.this, LockScreen6x6.class);
                    intent6x6.putExtra("name", v1);
                    intent6x6.putExtra("pack", v2);
                    startActivity(intent6x6);

                    break;
                default:
                    setContentView(R.layout.activity_lock_screen);
                    //setContentView(R.layout.activity_main_3x3);
                    break;

            }

//        btn = (Button)findViewById(R.id.unlock_btn);
//        t1 = (EditText)findViewById(R.id.unlock_pass);
//        status = (TextView)findViewById(R.id.App_name);
//

        // v1 and v2 get data from background services
//        if (extras != null) {
//
//            //The key argument here must match that used in the other activity
//        }


    }



}
