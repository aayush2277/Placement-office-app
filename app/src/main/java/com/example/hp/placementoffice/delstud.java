package com.example.hp.placementoffice;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

import java.io.OutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

public class delstud extends AppCompatActivity {
EditText e1;
int r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delstud);
       e1=(EditText)findViewById(R.id.t1);

    }
public void delete(View v)
{
    myasync obj1=new myasync();
    obj1.execute();
}
class myasync extends AsyncTask<Void,Void,Void>
{

    @Override
    protected Void doInBackground(Void... voids) {
        r= Integer.parseInt(e1.getText().toString());
senddata(delstud.this,r);
        return null;
    }
    void senddata(Context co,int r)
    {
        String url = "https://aayushgupta226670.000webhostapp.com/Deletestudent.php";
        Map<String, String> p = new HashMap<String, String>();
        p.put("t1", r + "");


        URL u=null;
        try
        {
            u=new URL(url);
        }
        catch (Exception e2)
        {

        }
        StringBuilder sb=new StringBuilder();
        Iterator<Map.Entry<String,String>> it=p.entrySet().iterator();
        while (it.hasNext())
        {
            Map.Entry<String,String> m=it.next();
            sb.append(m.getKey()).append("=").append(m.getValue());
            if (it.hasNext())
            {
                sb.append('&');
            }
        }
        String body=sb.toString();
        byte[] bytes=body.getBytes();
        try {
            HttpsURLConnection uc=(HttpsURLConnection)u.openConnection();
            uc.setDoOutput(true);
            uc.setUseCaches(true);
            uc.setFixedLengthStreamingMode(bytes.length);
            uc.setRequestMethod("POST");
            uc.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
            OutputStream out=uc.getOutputStream();
            out.write(bytes);
            out.close();
            int status=uc.getResponseCode();
            if(status!=200)
            {

            }


        }
        catch (Exception e2)
        {

        }
    }
}
}
