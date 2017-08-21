package com.example.ahmedsalamony.mercato.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.ahmedsalamony.mercato.R;
import com.example.ahmedsalamony.mercato.adapter.RecyclerAdapter;
import com.example.ahmedsalamony.mercato.models.AddReviewsModel;
import com.example.ahmedsalamony.mercato.models.ProductsCategoriesModel;
import com.example.ahmedsalamony.mercato.models.RegisterModel;
import com.example.ahmedsalamony.mercato.tools.APIManager;
import com.example.ahmedsalamony.mercato.ui.LoadingManager;
import com.example.ahmedsalamony.mercato.viewholder.AddReviewHolder;
import com.example.ahmedsalamony.mercato.viewholder.CategoriesHolder;

import java.util.ArrayList;
import java.util.List;

public class Reviews extends AppCompatActivity {
    private RecyclerView recyclerView;
    EditText et_comment;
    Button btn_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews);


        List<AddReviewsModel> data=new ArrayList<>();
        data.add(0,new AddReviewsModel("Drinks"));
        data.add(1,new AddReviewsModel("Meals"));
        data.add(2,new AddReviewsModel("Service"));
        data.add(3,new AddReviewsModel("Cleanliess"));
        data.add(4,new AddReviewsModel("Team Work"));

        recyclerView = (RecyclerView)findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        adddata(data);
        et_comment=(EditText)findViewById(R.id.comment);
        btn_submit=(Button)findViewById(R.id.btn_submit);

    }

    public void adddata(final List<AddReviewsModel> data) {
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(data, R.layout.row_add_review, AddReviewHolder.class,
                new RecyclerAdapter.AdapterInterface<AddReviewsModel, AddReviewHolder>() {
                    @Override
                    public void fillData(final AddReviewsModel dataModel, final AddReviewHolder viewHolder)
                    {

                        viewHolder.getTv_dept().setText((CharSequence) data.get(0));

                    }});
        recyclerView.setAdapter(recyclerAdapter);
    }
}
