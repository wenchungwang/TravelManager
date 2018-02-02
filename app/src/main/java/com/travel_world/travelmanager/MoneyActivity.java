package com.travel_world.travelmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.xml.parsers.ParserConfigurationException;

public class MoneyActivity extends AppCompatActivity {
    //   ListView lv;
    //    ArrayAdapter<String> adapter;
//    MyAdapter adapter;
//    MyHandler dataHandler;

    TextView tvJ1,tvJ2,tvJ3,tvJ4,tvd1,tvd2;
    String data2,data3,data4,data5;
    EditText ed66,ed77;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money);
        tvJ1 = findViewById(R.id.textView41);
        tvJ2 = findViewById(R.id.textView40);
        tvJ3 = findViewById(R.id.textView42);
        tvJ4 = findViewById(R.id.textView44);
        tvd1 = findViewById(R.id.textView11);
        tvd2 = findViewById(R.id.textView26);

        ed66 = (EditText) findViewById(R.id.editText6);
        ed77 = (EditText) findViewById(R.id.editText7);

    }
   // String.valueOf
    //thoams 20180201
    public void clickJT(View v){
        int TWmoney = Integer.valueOf(ed66.getText().toString());
        int sum = 0;
//        sum = TWmoney * 2;
//        tvd1.setText(sum);


    }

    public void clickTJ(View v){
        int Jpmoney = Integer.valueOf(ed77.getText().toString());
        int sum = 0;
//        sum = Jpmoney * 2;
//        tvd2.setText(sum);
    }

    public void clickGetMoney(View v) {

        new Thread() {
            @Override
            public void run() {
                super.run();
                String str_url = "http://rate.bot.com.tw/xrt?Lang=zh-TW";
//                String str_url = "https://www.mobile01.com/rss/news.xml";
                URL url = null;

                try {
                    url = new URL(str_url);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.connect();
                    InputStream inputStream = conn.getInputStream();
                    InputStreamReader isr = new InputStreamReader(inputStream);
                    BufferedReader br = new BufferedReader(isr);

                    StringBuilder sb = new StringBuilder();
                    String str;


                    while ((str = br.readLine()) != null) {
                        sb.append(str);
                    }
/*
                    String str1 = sb.toString();
                    Log.d("NET", str1);
                    final MyHandler dataHandler = new MyHandler();
                    SAXParserFactory spf = SAXParserFactory.newInstance();
                    SAXParser sp = spf.newSAXParser();
                    XMLReader xr = sp.getXMLReader();
                    xr.setContentHandler(dataHandler);
                    xr.parse(new InputSource(new StringReader(str1)));
*/

                    String str1 = sb.toString();
                    Log.d("NET", str1);

/*
                    int index1 = str1.indexOf("日圓 (JPY)");
                    int index2 = str1.indexOf("本行現金賣出", index1);
                    int index3 = str1.indexOf("0.266", index2);
                    Log.d("NET", "index1:" + index1 + "index2:" + index2 + "index3:" + index3);

                    String data1 = str1.substring(index2 + 56, index2 + 61);        //本行現金賣出
                    String data6 = str1.substring(index2 + 42, index2 + 47);        //本行現金買入
                    String data7 = str1.substring(index2 + 63, index2 + 68);        //本行即期買入
                    String data8 = str1.substring(index2 + 72, index2 + 77);        //本行即期賣出
*/


                    int index1 = str1.indexOf("日圓 (JPY)");
                    int index2 = str1.indexOf("本行現金買入", index1);
                    int index3 = str1.indexOf("</td>", index2);
                    int index4 = str1.indexOf("本行現金賣出", index3);
                    int index5 = str1.indexOf("</td>", index4);
                    int index6 = str1.indexOf("本行即期買入", index5);
                    int index7 = str1.indexOf("</td>", index6);
                    int index8 = str1.indexOf("本行即期賣出", index7);
                    int index9 = str1.indexOf("</td>", index8);

//                    int index2 = str1.indexOf("本行現金賣出", index1);
//                    int index3 = str1.indexOf("0.266", index2);
//                    Log.d("NET", "index1:" + index1 + "index2:" + index2 + "index3:" + index3);


                    String data6 = str1.substring(index3 -6, index3 );        //本行現金買入
                    String data1 = str1.substring(index5 -6, index5 );        //本行現金賣出
                    String data7 = str1.substring(index7 -6, index7 );        //本行即期買入
                    String data8 = str1.substring(index9 -6, index9 );        //本行即期賣出


                    Log.d("NET", data1);
                    Log.d("NET", data6);
                    Log.d("NET", data7);
                    Log.d("NET", data8);

                    data2=data1;
                    data3=data6;
                    data4=data7;
                    data5=data8;
 //                   tvJ1.setText(String.format("%.02f", data1));
 //                  tvJ1.setText(String.valueOf(data1));


                    br.close();
                    isr.close();
                    inputStream.close();

                } catch (MalformedURLException e1) {
                    e1.printStackTrace();
                } catch (ProtocolException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

 /*
 runOnUiThread(new Runnable() {
@Override
public void run() {
adapter = new ArrayAdapter<String>(MoneyActivity.this,
android.R.layout.simple_list_item_1, dataHandler.titles);
lv.setAdapter(adapter);
}
});
*/
                //             });
/*  check;;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (ProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (SAXException e) {
                    e.printStackTrace();
                } catch (ParserConfigurationException e) {
                    e.printStackTrace();
                }
*/
/*
 } catch (MalformedURLException e) {
 e.printStackTrace();
 } catch (ProtocolException e) {
 e.printStackTrace();
 } catch (IOException e) {
 e.printStackTrace();
 }
 */


            }

        }.start();
       tvJ1.setText(data4);
       tvJ2.setText(data5);
       tvJ3.setText(data3);
       tvJ4.setText(data2);
    }
}