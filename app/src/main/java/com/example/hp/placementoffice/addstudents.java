package com.example.hp.placementoffice;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.OutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

public class addstudents extends AppCompatActivity {
EditText e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11;
int r;
String n,f,e,c,a,tec,pass;
Double t,tw,g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addstudents);
        e1=(EditText)findViewById(R.id.t1);
        e2=(EditText)findViewById(R.id.t2);
        e3=(EditText)findViewById(R.id.t3);
        e4=(EditText)findViewById(R.id.t4);
        e5=(EditText)findViewById(R.id.t5);
        e6=(EditText)findViewById(R.id.t6);
        e7=(EditText)findViewById(R.id.t7);
        e8=(EditText)findViewById(R.id.t8);
        e9=(EditText)findViewById(R.id.t9);
        e10=(EditText)findViewById(R.id.t10);
        e11=(EditText)findViewById(R.id.t11);

    }
    public void insert(View v)
    {

myasync obj1=new myasync();
obj1.execute();
        Toast.makeText(this,"Insertion Successfull",Toast.LENGTH_LONG).show();

    }
class myasync extends AsyncTask<Void,Void,Void>
{

    @Override
    protected Void doInBackground(Void... voids) {
        r= Integer.parseInt(e1.getText().toString());
        n=e2.getText().toString();
        f=e3.getText().toString();
        e=e4.getText().toString();
        c=e5.getText().toString();
        a=e6.getText().toString();
        t=Double.parseDouble(e7.getText().toString());
        tw=Double.parseDouble(e8.getText().toString());
        g=Double.parseDouble(e9.getText().toString());
        tec=e10.getText().toString();
        pass=e11.getText().toString();
        senddata(addstudents.this,r,n,f,e,c,a,t,tw,g,tec,pass);


        return null;
    }
     void senddata(Context co,int r,String n,String f,String e,String c,String a,Double t,Double tw,Double g,String tec,String pass)
    {
        String url="https://aayushgupta226670.000webhostapp.com/RegisterStudent.php";
        Map<String,String > p=new HashMap<String ,String>();
        p.put("t1",r+"");
        p.put("t2",n);
        p.put("t3",f);
        p.put("t4",e);
        p.put("t5",c);
        p.put("t6",a);
        p.put("t7",t+"");
        p.put("t8",tw+"");
        p.put("t9",g+"");
        p.put("t10",tec);
        p.put("t11",pass);


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
            else
            {

            }


        }
        catch (Exception e2)
        {

        }
    }
}

}
