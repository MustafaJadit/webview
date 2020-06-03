package com.example.webview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.PermissionChecker;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    public static final String code = "322";
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView webView = findViewById(R.id.mwebview);
        webView.loadUrl("https://shinjuku-musasino.net/");
        webView.getSettings().setJavaScriptEnabled(true);
        Handler handler = new Handler();
        handler.postDelayed(() -> {

        }, 200);


        // webview Unrealted code, haha
        twoWaysOfTaskDelaying();
    }

    private void twoWaysOfTaskDelaying() {
        AsyncTask<String, String, String> stringStringStringAsyncTask = new AsyncTask<String, String, String>() {

            @Override
            protected String doInBackground(String... strings) {
                return null;
            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
            }

            @Override
            protected void onProgressUpdate(String... values) {
                super.onProgressUpdate(values);
            }
        };

        stringStringStringAsyncTask.execute("d");


        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(300);
                intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:5107594509"));


                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    startActivity(intent);
                } else {
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, Integer.parseInt(code));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.start();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        int index = 0;
        while (permissions.length > index
        ) {
            if (permissions[index].equals(Manifest.permission.CALL_PHONE) && requestCode == Integer.parseInt(code) && grantResults[index] == PackageManager.PERMISSION_GRANTED) {
                startActivity(intent);
            }
            index++;
        }
    }
}
