package com.example.ahmedsalamony.mercato.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ahmed on 8/19/2017.
 */

public class ProductsCategoriesModel implements Parcelable {

    int api_status;
    String api_message;
    @SerializedName("data")
    LoginModel.DataModel data;

    public int getApi_status() {
        return api_status;
    }

    public void setApi_status(int api_status) {
        this.api_status = api_status;
    }

    public String getApi_message() {
        return api_message;
    }

    public void setApi_message(String api_message) {
        this.api_message = api_message;
    }

    public LoginModel.DataModel getData() {
        return data;
    }

    public void setData(LoginModel.DataModel data) {
        this.data = data;
    }

    protected ProductsCategoriesModel(Parcel in) {
        this.api_status = in.readInt();
        this.api_message=in.readString();
        this.data = in.readParcelable(LoginModel.DataModel.class.getClassLoader());

    }

    public static final Creator<ProductsCategoriesModel> CREATOR = new Creator<ProductsCategoriesModel>() {
        @Override
        public ProductsCategoriesModel createFromParcel(Parcel in) {
            return new ProductsCategoriesModel(in);
        }

        @Override
        public ProductsCategoriesModel[] newArray(int size) {
            return new ProductsCategoriesModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.api_status);
        dest.writeString(this.api_message);
        dest.writeParcelable(this.data, flags);
    }
    public static class DataModel implements Parcelable{

        int id;
        String name,slug;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public DataModel(int id, String slug, String name) {
            this.id = id;
            this.slug = slug;
            this.name = name;
        }

        protected DataModel(Parcel in) {
            this.id=in.readInt();
            this.name=in.readString();
            this.slug=in.readString();
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
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.id);
            dest.writeString(this.name);
            dest.writeString(this.slug);
        }
    }
}
