package com.travel_world.travelmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import com.travel_world.travelmanager.TravelData;       //check thomas wang 20180117

public class JinActivity extends AppCompatActivity {
    WebView wv3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jin);

        wv3 = (WebView) findViewById(R.id.WebView3);
        wv3.setWebChromeClient(new WebChromeClient());
        wv3.getSettings().setJavaScriptEnabled(true);
        wv3.loadUrl("https://www.boca.gov.tw/cp-87-2121-7a5da-1.html");
    }


    public void clickhelp1(View v){
        wv3.loadUrl("https://www.boca.gov.tw/sp-foof-countrylp-02-1.html");
    }

    public void clickhelp2(View v){
        wv3.loadUrl("https://www.boca.gov.tw/cp-87-2121-7a5da-1.html");
    }

}
