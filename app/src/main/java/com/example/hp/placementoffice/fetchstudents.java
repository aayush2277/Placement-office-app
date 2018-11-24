package com.example.hp.placementoffice;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class fetchstudents extends AppCompatActivity {
    String msg="";
    private static String url="https://aayushgupta226670.000webhostapp.com/jsonstudents.php";
    ListView l1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetchstudents);

        l1=(ListView)findViewById(R.id.l1);
        myasync obj1=new myasync();
        obj1.execute(url);
    }
    class myasync extends AsyncTask<String,Void,String>
    {

        @Override
        protected String doInBackground(String... strings) {
            String serverURL=strings[0];
            InputStream is=null;
            String result=null;

            try{
            HttpClient httpClient=new DefaultHttpClient();
            HttpPost httpPost=new HttpPost(serverURL);

            HttpResponse response=httpClient.execute(httpPost);
            HttpEntity entity=response.getEntity();

            is=entity.getContent();

            BufferedReader reader=new BufferedReader(new InputStreamReader(is,"UTF-8"));
            StringBuilder sb=new StringBuilder();

            String line=null;
            while((line=reader.readLine())!=null)
            {
                sb.append(line+"\n");
            }
            result=sb.toString();
        }
            catch (Exception e)
        {

        }
return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            ArrayList<csstudent> ldata=new ArrayList<csstudent>();
            try {
                String msg = "";

                JSONObject obj=new JSONObject(s);
                JSONArray ja = obj.optJSONArray("students");
                for (int i = 0; i < ja.length(); i++)
                {
                    obj=ja.getJSONObject(i);
                    csstudent obj1=new csstudent();
                    obj1.setRoll(obj.getInt("roll"));
                    obj1.setFname(obj.getString("name"));
                    obj1.setLname(obj.getString("fname"));
                    obj1.setEmail(obj.getString("email"));
                    obj1.setContact(obj.getString("contact"));
                    ldata.add(obj1);

                }

            }

            catch (Exception e)
            {

            }
studadapter adp=new studadapter(R.layout.activity_studlayout,fetchstudents.this,ldata);
l1.setAdapter(adp);



        }
    }
}
