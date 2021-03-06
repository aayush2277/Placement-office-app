package com.example.hp.placementoffice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class companyadapter extends BaseAdapter {
    int rlayout;
    Context c;
    ArrayList<cscompany> ldata;

    public companyadapter(int rlayout, Context c, ArrayList<cscompany> ldata) {
        this.rlayout = rlayout;
        this.c = c;
        this.ldata = ldata;
    }

    @Override
    public int getCount() {
        return ldata.size();
    }

    @Override
    public Object getItem(int i) {
        return ldata.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view= LayoutInflater.from(c).inflate(rlayout,null);
        TextView t1=(TextView)view.findViewById(R.id.t1);
        TextView t2=(TextView)view.findViewById(R.id.t2);
        TextView t3=(TextView)view.findViewById(R.id.t3);
        TextView t4=(TextView)view.findViewById(R.id.t4);
        TextView t5=(TextView)view.findViewById(R.id.t5);
        t1.setText("ID="+ldata.get(i).getId()+"");
        t2.setText("Company="+ldata.get(i).getCname());
        t3.setText(ldata.get(i).getEmail());
        t4.setText("Contact no.="+ldata.get(i).getContact());
        t5.setText("Address="+ldata.get(i).getAddress());
        return view;

    }
}
