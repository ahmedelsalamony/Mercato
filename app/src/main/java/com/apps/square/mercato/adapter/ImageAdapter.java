package com.apps.square.mercato.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.apps.square.mercato.R;

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
            TextView txt_points=(TextView)grid.findViewById(R.id.text_points);
            ImageView imageView = (ImageView)grid.findViewById(R.id.grid_image);
            LinearLayout container_grid=(LinearLayout)grid.findViewById(R.id.container_grid);

            textView.setText(txtList.get(position));

        } else {
            grid = (View) convertView;
        }
        return grid;
    }
}
