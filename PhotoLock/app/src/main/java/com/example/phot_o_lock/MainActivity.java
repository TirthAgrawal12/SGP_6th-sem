package com.example.phot_o_lock;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Handler handler;
    RelativeLayout mylayot;
    AnimationDrawable animationDrawable;


    // intent is used to call background services
    Intent mServiceIntent;
    // NotificationService is for background service class


    @Override
    protected void
    onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        splashScreen();


//        update_pass.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//                AlertDialog.Builder builder = new AlertDialog.Builder(cn);
//                builder.setTitle("Enter Password");
//
//                // Set up the input
//                final EditText input = new EditText(cn);
//                // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
//                input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
//                builder.setView(input);
//
//                // Set up the buttons
//                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        m_Text = input.getText().toString();
//
//                        if(m_Text.isEmpty()){
//
//                            Toast.makeText(MainActivity.this,   "password can't be empty", Toast.LENGTH_LONG).show();
//                        }
//                        else{
//
//                            int zz = db.deleteData(m_Text);
//                            db.insertData(m_Text);
//
//                            Toast.makeText(MainActivity.this,   "password updated successfully "  , Toast.LENGTH_LONG).show();
//                            startActivity(new Intent(MainActivity.this,MainActivity.class));
//                            finish();
//
//                        }
//
//
//
//
//
//
//                    }
//                });
//                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.cancel();
//                    }
//                });
//
//                builder.show();
//
//
//
//
//            }
//        });


    }

    public void splashScreen(){

        setContentView(R.layout.activity_splash_screen);

        mylayot = (RelativeLayout)findViewById(R.id.myLayout);
        animationDrawable = (AnimationDrawable)mylayot.getBackground();
        animationDrawable.setEnterFadeDuration(700);
        animationDrawable.setExitFadeDuration(700);
        animationDrawable.start();

        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(),Main2Activity.class));
                finish();
            }
        },3000);

    }

}
