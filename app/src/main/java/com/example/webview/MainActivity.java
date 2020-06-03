package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

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
        AsyncTask stringStringStringAsyncTask = new AsyncTask<String, String, String>() {

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
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.start();
    }
}
