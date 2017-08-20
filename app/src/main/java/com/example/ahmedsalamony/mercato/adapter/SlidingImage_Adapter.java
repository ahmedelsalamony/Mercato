package com.example.ahmedsalamony.mercato.adapter;


import android.app.Activity;
import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.ahmedsalamony.mercato.R;
import com.example.ahmedsalamony.mercato.activity.Menu;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import uk.co.senab.photoview.PhotoViewAttacher;

import static java.security.AccessController.getContext;

/**
 * Created by Ahmed Salamony on 6/21/2017.
 */

public class SlidingImage_Adapter extends PagerAdapter {

    private List<String> IMAGES = new ArrayList<String>();
    private LayoutInflater inflater;
    private Context context;
    PhotoViewAttacher mAttacher;


    public SlidingImage_Adapter(Context context, List<String> IMAGES) {
        this.context = context;
        this.IMAGES=IMAGES;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
    @Override
    public int getCount() {
        return IMAGES.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View imageLayout = inflater.inflate(R.layout.slidingimages_layout, view, false);
        assert imageLayout != null;
        final ImageView imageView = (ImageView ) imageLayout
                .findViewById(R.id.image);
        //.resize(Menu.width,Menu.height)
        Picasso.with(context).load(IMAGES.get(position)).into(imageView);
        // Attach a PhotoViewAttacher, which takes care of all of the zooming functionality.
        mAttacher = new PhotoViewAttacher(imageView);
        view.addView(imageLayout, 0);
        return imageLayout;
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }

}
