package com.travel_world.travelmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Toast;

public class JapanWeb1Activity extends AppCompatActivity {
    WebView wv;
//    String str2[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_japan_web1);

        wv = (WebView) findViewById(R.id.WebView);
      wv.setWebChromeClient(new WebChromeClient());
       wv.getSettings().setJavaScriptEnabled(true);
/*
        if(requestCode==456)
        {
            wv.loadUrl("http://www.jreast.co.jp/tc/");
        }
        else if(requestCode==789)
        {
            wv.loadUrl("https://www.westjr.co.jp/global/tc/");
        }
        else
*/
/*
        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            if(requestCode==456)
            {
                wv.loadUrl("http://www.jreast.co.jp/tc/");
            }
            else if(requestCode==789)
            {
                wv.loadUrl("https://www.westjr.co.jp/global/tc/");
            }
            else
                wv.loadUrl("http://www.welcome2japan.tw/");
        };
*/


    }

/*
        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            str2 = new String[] {"1", "2", "3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18"};
            if(requestCode==456222)
            {      //  wv.setWebChromeClient(new WebChromeClient());
                //wv.getSettings().setJavaScriptEnabled(true);
             //   if (resultCode == RESULT_OK)
                {
                    wv.setWebChromeClient(new WebChromeClient());
                    wv.getSettings().setJavaScriptEnabled(true);
                    wv.loadUrl("http://www.jreast.co.jp/tc/");
                    Toast.makeText(JapanWeb1Activity.this, str2[0], Toast.LENGTH_SHORT).show();     //for test 20180129
                }
            }
            else if(requestCode==78922)
            {    //    wv.setWebChromeClient(new WebChromeClient());
                //wv.getSettings().setJavaScriptEnabled(true);
            //    if (resultCode == RESULT_OK)
                {
                    Toast.makeText(JapanWeb1Activity.this, str2[1], Toast.LENGTH_SHORT).show();     //for test 20180129
                    wv.setWebChromeClient(new WebChromeClient());
                    wv.getSettings().setJavaScriptEnabled(true);

                    wv.loadUrl("https://www.westjr.co.jp/global/tc/");
                }
            }
            else {
                //wv.setWebChromeClient(new WebChromeClient());
                //wv.getSettings().setJavaScriptEnabled(true);
            //    if (resultCode == RESULT_OK)
                {
                    Toast.makeText(JapanWeb1Activity.this, str2[2], Toast.LENGTH_SHORT).show();     //for test 20180129

                    wv.setWebChromeClient(new WebChromeClient());
                    wv.getSettings().setJavaScriptEnabled(true);
                    wv.loadUrl("http://www.welcome2japan.tw/");
                }
            }
        };
*/



    public void clickagoda(View v){
        wv.loadUrl("https://www.agoda.com/");
    }

    public void clickhotels(View v){
        wv.loadUrl("https://www.hotels.com/");
    }

    public void clickbooking(View v){
        wv.loadUrl("https://www.booking.com/");
    }

    public void clickJalan(View v){
        wv.loadUrl("https://www.jalan.net/tn/japan_hotels_ryokan/");
    }

    public void clicktripadvisor(View v){
        wv.loadUrl("https://www.tripadvisor.com.tw/");
    }

    public void clickbackbag(View v){
        wv.loadUrl("https://www.backpackers.com.tw/forum/");
    }

    public void clickjapanican(View v){
        wv.loadUrl("https://www.japanican.com/tw/");
    }

    public void clickcombined(View v){
        wv.loadUrl("https://www.hotelscombined.com.tw/");
    }

    public void clickikyu(View v){

        wv.loadUrl("https://www.ikyu.com/sd/lkIndex.aspx");
    }

}



