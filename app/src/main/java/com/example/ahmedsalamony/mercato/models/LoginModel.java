package com.example.ahmedsalamony.mercato.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ahmed Salamony on 8/14/2017.
 */

public class LoginModel implements Parcelable {

    String password,email;
    Boolean success;
    @SerializedName("data")
    DataModel data;
    String error;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public DataModel getData() {
        return data;
    }

    public void setData(DataModel data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public LoginModel(String email, String password){
        this.email=email;
        this.password=password;
    }

    protected LoginModel(Parcel in) {
        this.success = in.readByte() != 0;
        this.data = in.readParcelable(LoginModel.DataModel.class.getClassLoader());
        this.error=in.readString();
    }

    public static final Creator<LoginModel> CREATOR = new Creator<LoginModel>() {

        @Override
        public LoginModel createFromParcel(Parcel in) {
            return new LoginModel(in);
        }

        @Override
        public LoginModel[] newArray(int size) {
            return new LoginModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (this.success ? 1 : 0));
        dest.writeParcelable(this.data, flags);
    }

    public static class DataModel implements Parcelable{

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
}
