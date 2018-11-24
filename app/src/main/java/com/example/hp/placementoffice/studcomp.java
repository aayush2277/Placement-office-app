package com.example.hp.placementoffice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class studcomp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studcomp);
    }
    public void test1(View v)
    {
        Intent i=new Intent(this,visitstud.class);
        startActivity(i);
    }
    public void visit(View v)
    {
        Intent i=new Intent(this,univacces.class);
        startActivity(i);
    }
    public void test2(View v)
    {
        Intent i=new Intent(this,visitcomp.class);
        startActivity(i);
    }

}
