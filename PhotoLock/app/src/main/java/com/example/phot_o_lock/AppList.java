package com.example.phot_o_lock;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AppList extends ListActivity {

    private PackageManager packageManager = null;
    private List<ApplicationInfo> appList = null;
    private AppAdapter listAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        packageManager = getPackageManager();

        new LoadApplications().execute();
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        ApplicationInfo app = appList.get(position);

        try {

            Intent intent = packageManager.getLaunchIntentForPackage(app.packageName);
            if (intent != null){
                startActivity(intent);
            }


        }catch (ActivityNotFoundException e){
            Toast.makeText(getApplicationContext(),""+e.getMessage(),Toast.LENGTH_LONG).show();
        } catch (Exception e){
            Toast.makeText(getApplicationContext(),""+e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    private List<ApplicationInfo> checkForLaunchIntent(List<ApplicationInfo> list){

        ArrayList<ApplicationInfo> appList = new ArrayList<ApplicationInfo>();

        for (ApplicationInfo info : list){

            try {

                if (packageManager.getLaunchIntentForPackage(info.packageName) != null){
                    appList.add(info);
                }

            }catch (Exception e){
                Toast.makeText(getApplicationContext(),""+e.getMessage(),Toast.LENGTH_LONG).show();
            }
        }
        return appList;
    }

    private class LoadApplications extends AsyncTask<Void, Void, Void>{

        private ProgressDialog progress = null;

        @Override
        protected Void doInBackground(Void... voids) {

            appList = checkForLaunchIntent(packageManager.getInstalledApplications(PackageManager.GET_META_DATA));
            listAdapter = new AppAdapter(AppList.this, R.layout.activity_app_list, appList);
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {

            setListAdapter(listAdapter);
            progress.dismiss();

            super.onPostExecute(result);
        }

        @Override
        protected void onPreExecute() {

            progress = ProgressDialog.show(AppList.this, null, "Loading Apps info ...");

            super.onPreExecute();
        }
    }

}
