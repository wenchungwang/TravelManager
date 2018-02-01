package com.travel_world.travelmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class FoodActivity extends AppCompatActivity {
    WebView wv4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        wv4 = (WebView) findViewById(R.id.WebView4);
        wv4.setWebChromeClient(new WebChromeClient());
        wv4.getSettings().setJavaScriptEnabled(true);
        wv4.loadUrl("http://www.letsgojp.com/");
    }

    public void clicktabelog(View v){
        wv4.loadUrl("https://tabelog.com/tw/");
    }

    public void clickletsgojp(View v){
        wv4.loadUrl("http://www.letsgojp.com/");
    }

    public void clickfood(View v){
        wv4.loadUrl("https://www.sakehero.com/2016-05-24-743/");
    }
}
