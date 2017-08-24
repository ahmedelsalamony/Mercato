package com.apps.square.mercato.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Ahmed Salamony on 8/24/2017.
 */

public class MyWalletModel  implements Parcelable {
    int api_status;
    String api_message;
    @SerializedName("data")
    MyWalletModel.DataModel data;
    @SerializedName("redeemed_cards")
    List<MyWalletModel.RedeemCards> cards;


    public DataModel getData() {
        return data;
    }

    public void setData(DataModel data) {
        this.data = data;
    }

    public String getApi_message() {
        return api_message;
    }

    public void setApi_message(String api_message) {
        this.api_message = api_message;
    }

    public int getApi_status() {
        return api_status;
    }

    public void setApi_status(int api_status) {
        this.api_status = api_status;
    }

    public List<RedeemCards> getCards() {
        return cards;
    }

    public void setCards(List<RedeemCards> cards) {
        this.cards = cards;
    }

    protected MyWalletModel(Parcel in) {
        api_status = in.readInt();
        api_message = in.readString();
        this.data = in.readParcelable(LoginModel.DataModel.class.getClassLoader());
        cards = in.createTypedArrayList(MyWalletModel.RedeemCards.CREATOR);
    }

    public static final Creator<MyWalletModel> CREATOR = new Creator<MyWalletModel>() {
        @Override
        public MyWalletModel createFromParcel(Parcel in) {
            return new MyWalletModel(in);
        }

        @Override
        public MyWalletModel[] newArray(int size) {
            return new MyWalletModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(api_status);
        parcel.writeString(api_message);
        parcel.writeParcelable(this.data, flags);
        parcel.writeTypedList(cards);
    }

    public static class DataModel implements Parcelable{
        int id,points;
        String phone_number;

        protected DataModel(Parcel in) {
        }

        public static final Creator<DataModel> CREATOR = new Creator<DataModel>() {
            @Override
            public DataModel createFromParcel(Parcel in) {
                return new DataModel(in);
            }

            @Override
            public DataModel[] newArray(int size) {
                return new DataModel[size];
            }
        };

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
        }
    }

    public static class RedeemCards implements Parcelable{



        String qr_code,value,qr_path,expire_date;
        int point_id;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getExpire_date() {
            return expire_date;
        }

        public void setExpire_date(String expire_date) {
            this.expire_date = expire_date;
        }

        public RedeemCards(String expire_date, String value) {
            this.expire_date = expire_date;
            this.value = value;
        }

        protected RedeemCards(Parcel in) {
            qr_code=in.readString();
            value=in.readString();
            qr_path=in.readString();
            expire_date=in.readString();
            point_id=in.readInt();
        }

        public static final Creator<RedeemCards> CREATOR = new Creator<RedeemCards>() {
            @Override
            public RedeemCards createFromParcel(Parcel in) {
                return new RedeemCards(in);
            }

            @Override
            public RedeemCards[] newArray(int size) {
                return new RedeemCards[size];
            }
        };

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(qr_code);
            parcel.writeString(value);
            parcel.writeString(qr_path);
            parcel.writeString(expire_date);
            parcel.writeInt(point_id);
        }
    }
}
