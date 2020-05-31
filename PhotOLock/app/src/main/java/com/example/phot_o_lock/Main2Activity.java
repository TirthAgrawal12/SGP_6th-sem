package com.example.phot_o_lock;

import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    Context context = this;
    Button setLock,changeLock;
    Context cn;

    Password_Database db = new Password_Database(this);
    List<String> pass = new ArrayList<>();
    String m_Text="";



    // intent is used to call background services
    Intent mServiceIntent;
    // NotificationService is for background service class
    private BackgroundServices mYourService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setLock = findViewById(R.id.setLock);
        changeLock = findViewById(R.id.changeLock);

        cn = this;

        Cursor res = db.getAllData();
        while (res.moveToNext()) {
            pass.add(res.getString(0));
        }

        setLock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Main2Activity.this, SetLock.class);
                startActivity(intent);
                //finish();

            }
        });

        changeLock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Main2Activity.this, SetLock.class);
                startActivity(intent);
//                Intent intent = new Intent(MainActivity.this, AppList.class);
//                startActivity(intent);
////                finish();

            }
        });


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



    // check your background services
    private boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                Log.i ("Service status", "Running");
                return true;
            }
        }
        Log.i ("Service status", "Not running");
        return false;
    }



    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onStart() {
        super.onStart();

        if(!isAccessGranted()){
            new AlertDialog.Builder(this)
                    .setTitle("USAGE_STATS Permission")
                    .setMessage("Allow USAGE_STATS Permission in Setting")
                    .setPositiveButton("Allow", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // action
                            startActivity(new Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS));
                        }
                    })
                    .setNegativeButton("Abort", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //
                        }
                    })
                    .show();
        }

        // run background services
        mYourService = new BackgroundServices();
        mServiceIntent = new Intent(this, mYourService.getClass());
        // services not running already
        // start services
        if (!isMyServiceRunning(mYourService.getClass())) {
            startService(mServiceIntent);
        }



    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private boolean isAccessGranted() {
        try {
            PackageManager packageManager = getPackageManager();
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(getPackageName(), 0);
            AppOpsManager appOpsManager = (AppOpsManager) getSystemService(Context.APP_OPS_SERVICE);
            int mode = 0;
            if (android.os.Build.VERSION.SDK_INT > android.os.Build.VERSION_CODES.KITKAT) {
                mode = appOpsManager.checkOpNoThrow(AppOpsManager.OPSTR_GET_USAGE_STATS,
                        applicationInfo.uid, applicationInfo.packageName);
            }
            return (mode == AppOpsManager.MODE_ALLOWED);

        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

}
