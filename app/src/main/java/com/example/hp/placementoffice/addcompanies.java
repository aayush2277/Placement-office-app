package com.example.hp.placementoffice;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class addcompanies extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5,e6,e7,e8,e9;
    int i;
    String n,e,c,a,pass,action;
    Double t,tw,g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcompanies);
        e1=(EditText)findViewById(R.id.t1);
        e2=(EditText)findViewById(R.id.t2);
        e3=(EditText)findViewById(R.id.t3);
        e4=(EditText)findViewById(R.id.t4);
        e5=(EditText)findViewById(R.id.t5);
        e6=(EditText)findViewById(R.id.t6);
        e7=(EditText)findViewById(R.id.t7);
        e8=(EditText)findViewById(R.id.t8);
        e9=(EditText)findViewById(R.id.t9);
    }
    public void insert(View v)
    {
myasync obj1=new myasync();
obj1.execute();
        Toast.makeText(addcompanies.this,"Insertion completed",Toast.LENGTH_LONG).show();
    }
    class myasync extends AsyncTask<Void,Void,Void>
    {

        @Override
        protected Void doInBackground(Void... voids) {
            i=Integer.parseInt(e1.getText().toString());
            n=e2.getText().toString();
            e=e3.getText().toString();
            c=e4.getText().toString();
            a=e5.getText().toString();
            t=Double.parseDouble(e6.getText().toString());
            tw=Double.parseDouble(e7.getText().toString());
            g=Double.parseDouble(e8.getText().toString());
            pass=e9.getText().toString();
            senddata(addcompanies.this,i,n,e,c,a,t,tw,g,pass);
            return null;
        }
        void senddata(Context co, int i, String n, String e, String c, String a, Double t, Double tw, Double g, String pass)
        {
            String url="https://aayushgupta226670.000webhostapp.com/RegisterCompany.php";
            Map<String,String> p=new HashMap<String,String>();
            p.put("t1",i+"");
            p.put("t2",n);
            p.put("t3",e);
            p.put("t4",c);
            p.put("t5",a);
            p.put("t6",t+"");
            p.put("t7",tw+"");
            p.put("t8",g+"");
            p.put("t9",pass);



            URL u=null;
            try
            {
                u =new URL(url);
            }
            catch (Exception e1)
            {

            }
            StringBuilder sb=new StringBuilder();
            Iterator<Map.Entry<String,String >> it=p.entrySet().iterator();
            while (it.hasNext())
            {
                Map.Entry<String,String> m=it.next();
                sb.append(m.getKey()).append("=").append(m.getValue());
                if(it.hasNext())
                {
                    sb.append('&');
                }
            }
            String body=sb.toString();
            byte[] bytes=body.getBytes();
            try
            {
                HttpURLConnection uc=(HttpURLConnection)u.openConnection();
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
                else {

                }


            }
            catch (Exception e1)
            {

            }
        }
    }
}
