package com.apps.square.mercato.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.apps.square.mercato.R;
import com.apps.square.mercato.models.AddReviewsModel;
import com.apps.square.mercato.tools.APIManager;
import com.iarcuschin.simpleratingbar.SimpleRatingBar;

public class Reviews extends AppCompatActivity {
    EditText et_comment;
    Button btn_submit;
    SimpleRatingBar ratingBar_d,ratingBar_m,ratingBar_s,ratingBar_c,ratingBar_t;
    int drink_rate_result,meals_rate_result,service_rate_result,clean_rate_result,team_rate_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews);
        et_comment=(EditText)findViewById(R.id.comment);
        btn_submit=(Button)findViewById(R.id.btn_submit);
        ratingBar_d=(SimpleRatingBar)findViewById(R.id.rating_drinks);
        ratingBar_m=(SimpleRatingBar)findViewById(R.id.rating_meals);
        ratingBar_s=(SimpleRatingBar)findViewById(R.id.rating_service);
        ratingBar_c=(SimpleRatingBar)findViewById(R.id.rating_clean);
        ratingBar_t=(SimpleRatingBar)findViewById(R.id.rating_team);

        drink_rate_result=(int)ratingBar_d.getRating();
        meals_rate_result=(int)ratingBar_m.getRating();
        service_rate_result=(int)ratingBar_s.getRating();
        clean_rate_result=(int)ratingBar_c.getRating();
        team_rate_result=(int)ratingBar_t.getRating();

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                APIManager.addReview(Reviews.this,drink_rate_result,meals_rate_result,service_rate_result,clean_rate_result,team_rate_result
                        ,et_comment.getText().toString(),11, new APIManager.ResponseListener<AddReviewsModel>() {
                            @Override
                            public void done(AddReviewsModel dataModel) {
                                if (dataModel.getApi_status()==1 && dataModel.getCode()==0){
                                    Toast.makeText(Reviews.this, " done ", Toast.LENGTH_SHORT).show();
                                }else if (dataModel.getApi_status()==1 && dataModel.getCode()==9000){
                                    Toast.makeText(Reviews.this,"Attention! You can review us just once per day", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void failed(boolean fromConnection) {
                            }
                        });
            }
        });



    }

}
