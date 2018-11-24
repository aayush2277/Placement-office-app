package com.example.hp.placementoffice;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

public class eligiblestud extends AppCompatActivity {
    String msg="";
    private static String url="https://aayushgupta226670.000webhostapp.com/jsoneligiblestud.php";
    EditText e1;
    String cname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eligiblestud);
        e1=(EditText)findViewById(R.id.t1);
    }
public void show(View v)
{
        myasync obj1=new myasync();
    obj1.execute(e1.getText().toString());
}

    class myasync extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            cname=strings[0];
            String serverURL = "https://aayushgupta226670.000webhostapp.com/jsoneligiblestud.php";
            InputStream is = null;
            List<NameValuePair> nameValuePairs=new ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair("t1",cname));



            String result = null;

            try {
                HttpClient httpClient = new DefaultHttpClient();
                HttpPost httpPost = new HttpPost(serverURL);
                httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                HttpResponse response = httpClient.execute(httpPost);
                HttpEntity entity = response.getEntity();

                is = entity.getContent();

                BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                StringBuilder sb = new StringBuilder();

                String line = null;
                while ((line = reader.readLine()) != null) {
                    sb.append(line + "\n");
                }
                result = sb.toString();
            } catch (Exception e) {

            }
            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            ListView l1;
            ArrayList<csstudent> ldata = new ArrayList<csstudent>();
            l1 = (ListView) findViewById(R.id.l1);
            try {
                String msg = "";

                JSONObject obj = new JSONObject(s);
                JSONArray ja = obj.optJSONArray("students");
                for (int i = 0; i < ja.length(); i++) {
                    obj = ja.getJSONObject(i);
                    csstudent obj1 = new csstudent();
                    obj1.setRoll(obj.getInt("roll"));
                    obj1.setFname(obj.getString("name"));
                    obj1.setLname(obj.getString("fname"));
                    obj1.setEmail(obj.getString("email"));
                    obj1.setContact(obj.getString("contact"));
                    ldata.add(obj1);

                }

            } catch (Exception e) {

            }
            studadapter adp = new studadapter(R.layout.activity_studlayout, eligiblestud.this, ldata);
            l1.setAdapter(adp);


            super.onPostExecute(s);
        }
    }
}