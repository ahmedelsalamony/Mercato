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
import com.example.ahmedsalamony.mercato.adapter.StaticReviewAdapter;
import com.example.ahmedsalamony.mercato.models.AddReviewsModel;
import com.example.ahmedsalamony.mercato.models.ProductsCategoriesModel;
import com.example.ahmedsalamony.mercato.models.RegisterModel;
import com.example.ahmedsalamony.mercato.models.StaticReviewModel;
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
    private List<StaticReviewModel> reviewList = new ArrayList<>();
    private StaticReviewAdapter mAdapter;

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

        mAdapter = new StaticReviewAdapter(reviewList);
        recyclerView = (RecyclerView)findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        recyclerView.setAdapter(mAdapter);
        prepareMovieData();
        et_comment=(EditText)findViewById(R.id.comment);
        btn_submit=(Button)findViewById(R.id.btn_submit);

    }

    private void prepareMovieData() {
        StaticReviewModel movie = new StaticReviewModel("Drinks");
        reviewList.add(movie);

        movie = new StaticReviewModel("Meals");
        reviewList.add(movie);

        movie = new StaticReviewModel("Service");
        reviewList.add(movie);

        movie = new StaticReviewModel("Cleanliess");
        reviewList.add(movie);

        movie = new StaticReviewModel( " Team Work ");
        reviewList.add(movie);

        mAdapter.notifyDataSetChanged();
    }
}
