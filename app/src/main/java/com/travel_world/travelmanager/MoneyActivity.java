package com.travel_world.travelmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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

    //TextView tvJ1,tvJ2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money);

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

                    int index1 = str1.indexOf("日圓 (JPY)");
                    int index2 = str1.indexOf("本行現金賣出", index1);
                    int index3 = str1.indexOf("0.266", index2);
                    Log.d("NET", "index1:" + index1 + "index2:" + index2 + "index3:" + index3);
                    String data1 = str1.substring(index2 + 56, index2 + 61);

                    Log.d("NET", data1);


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
    }
}