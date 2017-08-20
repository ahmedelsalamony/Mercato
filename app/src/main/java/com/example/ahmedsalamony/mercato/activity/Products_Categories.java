package com.example.ahmedsalamony.mercato.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.ahmedsalamony.mercato.R;
import com.example.ahmedsalamony.mercato.adapter.RecyclerAdapter;
import com.example.ahmedsalamony.mercato.models.PointsModel;
import com.example.ahmedsalamony.mercato.models.ProductsCategoriesModel;
import com.example.ahmedsalamony.mercato.tools.APIManager;
import com.example.ahmedsalamony.mercato.viewholder.CategoriesHolder;

import java.util.ArrayList;
import java.util.List;

public class Products_Categories extends AppCompatActivity {
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products__categories);

        List<ProductsCategoriesModel.DataModel> data=new ArrayList<>();
        data.add(0,new ProductsCategoriesModel.DataModel(1,"","hot drinks"));
        data.add(1,new ProductsCategoriesModel.DataModel(2,"","cold drinks"));
        data.add(2,new ProductsCategoriesModel.DataModel(3,"","meals"));
        data.add(3,new ProductsCategoriesModel.DataModel(4,"","snacks"));
        data.add(4,new ProductsCategoriesModel.DataModel(5,"","desert"));

        recyclerView = (RecyclerView)findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        adddata(data);
    }



    public void adddata(final List<ProductsCategoriesModel.DataModel> data) {
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(data, R.layout.row_categories, CategoriesHolder.class,
                new RecyclerAdapter.AdapterInterface<ProductsCategoriesModel.DataModel, CategoriesHolder>() {
                    @Override
                    public void fillData(final ProductsCategoriesModel.DataModel dataModel, final CategoriesHolder viewHolder)
                    {

                        viewHolder.getCategory_name().setText(dataModel.getName());

                    }});
        recyclerView.setAdapter(recyclerAdapter);
    }
}
