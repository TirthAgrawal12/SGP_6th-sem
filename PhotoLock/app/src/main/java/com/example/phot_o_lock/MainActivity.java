package com.example.phot_o_lock;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button setLock,changeLock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setLock = (Button)findViewById(R.id.setLock);
        changeLock = (Button)findViewById(R.id.changeLock);

        setLock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, SetLock.class);
                startActivity(intent);

            }
        });


    }
}
