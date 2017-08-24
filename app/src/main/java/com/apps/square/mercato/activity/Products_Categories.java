package com.apps.square.mercato.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.apps.square.mercato.R;
import com.apps.square.mercato.adapter.RecyclerAdapter;
import com.apps.square.mercato.fragments.fragment_menu;
import com.apps.square.mercato.models.ProductsCategoriesModel;
import com.apps.square.mercato.viewholder.CategoriesHolder;

import java.util.ArrayList;
import java.util.List;

public class Products_Categories extends AppCompatActivity {
    private RecyclerView recyclerView;
    public static View head;
    public static TextView texthead;
    private Class currentFragmentClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products__categories);

        List<ProductsCategoriesModel.DataModel> data=new ArrayList<>();
        data.add(0,new ProductsCategoriesModel.DataModel(1,R.drawable.menu_pic01,"hot drinks"));
        data.add(1,new ProductsCategoriesModel.DataModel(2,R.drawable.menu_pic03,"cold drinks"));
        data.add(2,new ProductsCategoriesModel.DataModel(3,R.drawable.menu_pic02,"meals"));
        data.add(3,new ProductsCategoriesModel.DataModel(4,R.drawable.menu_pic01,"snacks"));
        data.add(4,new ProductsCategoriesModel.DataModel(5,R.drawable.menu_pic02,"desert"));



        recyclerView = (RecyclerView)findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        adddata(data);

        head=findViewById(R.id.menu);
        texthead=(TextView)findViewById(R.id.headtext);
        head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFragment(new fragment_menu());
            }
        });
    }

    private void openFragment(Fragment fragment) {
        if (currentFragmentClass != fragment.getClass()) {
            currentFragmentClass = fragment.getClass();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.activity_products__categories, fragment)
                    .commit();
        }
    }



    public void adddata(final List<ProductsCategoriesModel.DataModel> data) {
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(data, R.layout.row_categories, CategoriesHolder.class,
                new RecyclerAdapter.AdapterInterface<ProductsCategoriesModel.DataModel, CategoriesHolder>() {
                    @Override
                    public void fillData(final ProductsCategoriesModel.DataModel dataModel, final CategoriesHolder viewHolder)
                    {

                        viewHolder.getCategory_name().setText(dataModel.getName());
                        viewHolder.getCategory_img().setBackgroundResource(dataModel.getSlug());

                    }});
        recyclerView.setAdapter(recyclerAdapter);
    }

}
