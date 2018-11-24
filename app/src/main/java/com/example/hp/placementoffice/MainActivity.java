package com.example.hp.placementoffice;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void add1(View v)
    {
       Intent i=new Intent(this,addstudents.class);
       startActivity(i);
    }
    public void add2(View v)
    {
        Intent i=new Intent(this,addcompanies.class);
        startActivity(i);
    }
    public void del1(View v)
    {
        Intent i=new Intent(this,delstud.class);
        startActivity(i);
    }
    public void del2(View v)
    {
        Intent i=new Intent(this,delcompany.class);
        startActivity(i);
    }
    public void upd2(View v)
    {
        Intent i=new Intent(this,updcompany.class);
        startActivity(i);
    }
    public void upd1(View v)
    {
        Intent i=new Intent(this,updstud.class);
        startActivity(i);
    }
    public void fetch(View v)
    {
        Intent i=new Intent(this,fetchstudents.class);
        startActivity(i);
    }
    public void test3(View v)
    {

        Intent i=new Intent(this,fetchcompanies.class);
        startActivity(i);
    }
    public void test4(View v)
    {
        Intent i=new Intent(this,eligiblestud.class);
        startActivity(i);
    }
}
