package com.travel_world.travelmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import com.travel_world.travelmanager.TravelData;       //check thomas wang 20180117

public class JtrafficActivity extends AppCompatActivity {
 //   int i =0;
 WebView wv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jtraffic);
        wv2 = (WebView) findViewById(R.id.WebView2);
            wv2.setWebChromeClient(new WebChromeClient());
            wv2.getSettings().setJavaScriptEnabled(true);
   //     wv2.loadUrl("http://www.jreast.co.jp/tc/");
    }

    public void clickJtraffic1(View v){
        //     i =1;
        //   Intent it = new Intent(Main0Activity.this, JapanWeb1Activity.class);


       wv2.loadUrl("http://www.jreast.co.jp/tc/");          //JR東日本旅客鐵路株式會社

 //       Intent it = new Intent(JtrafficActivity.this, JapanWeb1Activity.class);
        // startActivity(it);
 //       startActivityForResult(it,456);
    }

    public void clickJtraffic2(View v){
    //    i = 2;
    //    Intent it = new Intent(Main0Activity.this, JapanWeb1Activity.class);
        wv2.loadUrl("https://www.westjr.co.jp/global/tc/");             //JR西日本旅客鐵路株式會社
//        Intent it = new Intent(JtrafficActivity.this, JapanWeb1Activity.class);
    //   startActivity(it);
//        startActivityForResult(it,789);
    }

    public void clickJtraffic3(View v){
        wv2.loadUrl("https://www.nippon.com/hk/features/h00077/");      //日本新幹線路線圖
   //     Intent it = new Intent(JtrafficActivity.this, JapanWeb1Activity.class);

  //      Intent it = new Intent(JapanInformationActivity.this, JapanWeb1Activity.class);
  //      startActivity(it);
  //      startActivityForResult(it,101);
    }

    public void clickJtraffic4(View v){
        wv2.loadUrl("https://www.tabi-o-ji.com/go/");       //新幹線時刻表查詢

 //            Intent it = new Intent(JtrafficActivity.this, JapanWeb1Activity.class);

  //      Intent it = new Intent(JapanInformationActivity.this, JapanWeb1Activity.class);
  //      startActivity(it);
  //      startActivityForResult(it,111);
    }

    public void clickJtraffic5(View v){
        //      Intent it = new Intent(Main0Activity.this, JapanWeb1Activity.class);
        wv2.loadUrl("http://www.welcome2japan.tw/");       //日本觀光局      /*

  //      Intent it = new Intent(JtrafficActivity.this, JapanWeb1Activity.class);
  //      startActivity(it);
  //      startActivityForResult(it,121);

    }

    public void clickJtraffic6(View v){
        wv2.loadUrl("https://www.jrkyushu.co.jp/chinese/");      //JR九州鐵路
    }

    public void clickJtraffic7(View v){

        wv2.loadUrl("http://www2.jrhokkaido.co.jp/global/chinese/index.html");       //JR北海道鐵路
    }
    public void clickJtraffic8(View v){
        wv2.loadUrl("https://www.yui-rail.co.jp/tc/");       //沖繩
    }

    public void clickJtraffic9(View v){

        wv2.loadUrl("https://www.jorudan.co.jp/");      //東京地鐵
//        wv2.loadUrl("tp://www.tokyometro.jp/");      //東京地鐵
    }


}
