package com.example.hp.placementoffice;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class univacces extends AppCompatActivity {
    String msg = "";
    EditText e1, e2;
    String user, p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_univacces);
        e1 = (EditText) findViewById(R.id.t1);
        e2 = (EditText) findViewById(R.id.t2);
    }
    public void test2(View v)
    {

        myasync obj1 = new myasync();
        obj1.execute(e1.getText().toString(), e2.getText().toString());
    }
    class myasync extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            String user, p;
            user = strings[0];
            p = strings[1];

            String serverURL = "https://aayushgupta226670.000webhostapp.com/loginuniv.php";
            InputStream is = null;
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair("t1", user));
            nameValuePairs.add(new BasicNameValuePair("t2", p));
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
            String a = s.trim();
            if (a.equalsIgnoreCase("success")) {
                Intent i = new Intent(univacces.this, MainActivity.class);
                startActivity(i);
            } else {
                Toast.makeText(univacces.this, "Invalid Username or Password", Toast.LENGTH_LONG).show();
            }


            super.onPostExecute(s);


        }
    }
}
