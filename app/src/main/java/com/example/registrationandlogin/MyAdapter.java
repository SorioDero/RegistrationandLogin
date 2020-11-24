package com.example.registrationandlogin;

import android.content.ContentValues;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import org.w3c.dom.Text;

public class MyAdapter extends ArrayAdapter {

    private int [] food = new int[] {};
    private String [] prices = new String[]{};
    private String [] names = new String[] {};

    public MyAdapter(@NonNull Context context, int resource, int [] food, String[] names, String[] prices) {
        super(context, resource);
        this.food = food;
        this.names = names;
        this.prices = prices;
    }

    public int getCount() {
        return names.length;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View v;
        LayoutInflater inflater =(LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.griditem, null);
        TextView textView = (TextView) v.findViewById(R.id.textView4);
        TextView priceView = (TextView) v.findViewById(R.id.textView5);
        ImageView imageView = (ImageView) v.findViewById(R.id.imageView2);
        textView.setText(names[position]);
        imageView.setImageResource(food[position]);
        priceView.setText(prices[position]);
        return v;
    }
}
