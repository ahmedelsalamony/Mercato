package com.apps.square.mercato.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.apps.square.mercato.R;

/**
 * Created by Ahmed Salamony on 8/23/2017.
 */

public class WalletHolder  extends RecyclerView.ViewHolder {
    TextView txt_redeem_points,txt_expired;

    public TextView getTxt_redeem_points() {
        return txt_redeem_points;
    }

    public void setTxt_redeem_points(TextView txt_redeem_points) {
        this.txt_redeem_points = txt_redeem_points;
    }

    public TextView getTxt_expired() {
        return txt_expired;
    }

    public void setTxt_expired(TextView txt_expired) {
        this.txt_expired = txt_expired;
    }

    public WalletHolder(View itemView) {
        super(itemView);
        txt_redeem_points=(TextView) itemView.findViewById(R.id.txt_redeem_points);
        txt_expired=(TextView) itemView.findViewById(R.id.txt_expired);
    }

}
