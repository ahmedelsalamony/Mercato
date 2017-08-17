package com.example.ahmedsalamony.mercato.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ahmedsalamony.mercato.R;
import com.example.ahmedsalamony.mercato.fragments.HomeScreen;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Ahmed Salamony on 8/16/2017.
 */

public class ImageAdapter extends BaseAdapter {

    private List<Integer> dataList;
    private List<String> txtList;
    Context context;

    public ImageAdapter(Context context,List<Integer> dataList,List<String> txtList){
        this.context=context;
        this.dataList=dataList;
        this.txtList=txtList;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int i) {
        return dataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View grid;
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = new View(context);
            grid = inflater.inflate(R.layout.row_grid, null);
            TextView textView = (TextView) grid.findViewById(R.id.grid_text);
            ImageView imageView = (ImageView)grid.findViewById(R.id.grid_image);
           /* Picasso.with(context)
                    .load(dataList.get(position).toString())
                    .placeholder(R.drawable.whitebg)
                    .into(imageView);*/
            imageView.setImageResource(dataList.get(position));
            if (position==0){
            imageView.setBackgroundColor(ContextCompat.getColor(context, R.color.colorWhite));}
            else if (position==1){
                imageView.setBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimary));
            }
           else if (position==2){
                imageView.setBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimary));}
            else if (position==3){
                imageView.setBackgroundColor(ContextCompat.getColor(context, R.color.colorWhite));
            }
            else if (position==4){
                imageView.setBackgroundColor(ContextCompat.getColor(context, R.color.colorWhite));}
            else if (position==5){
                imageView.setBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimary));
            }
            textView.setText(txtList.get(position));


        } else {
            grid = (View) convertView;
        }

        return grid;
    }
}
