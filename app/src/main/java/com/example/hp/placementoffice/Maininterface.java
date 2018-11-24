package com.example.hp.placementoffice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Maininterface extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maininterface);

    }
    public void test1(View v)
    {
        Intent i=new Intent(this,studcomp.class);
        startActivity(i);
    }
    public void test2(View v)
    {
        Intent i=new Intent(this,MapsActivity.class);
        startActivity(i);
    }
    public void visit(View v)
    {
        Intent i=new Intent(this,website.class);
        startActivity(i);
    }
}
