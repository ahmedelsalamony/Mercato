package com.example.ahmedsalamony.mercato.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ahmed Salamony on 8/14/2017.
 */

public class LoginModel implements Parcelable {


    String password,email;
    int api_status;
    String api_message;
    @SerializedName("data")
    DataModel data;

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

    public DataModel getData() {
        return data;
    }

    public void setData(DataModel data) {
        this.data = data;
    }


    public LoginModel(String email, String password){
        this.email=email;
        this.password=password;
    }

    protected LoginModel(Parcel in) {
        this.api_status = in.readInt();
        this.api_message=in.readString();
        this.data = in.readParcelable(LoginModel.DataModel.class.getClassLoader());
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
        dest.writeInt(this.api_status);
        dest.writeString(this.api_message);
        dest.writeParcelable(this.data, flags);
    }

    public static class DataModel implements Parcelable{

    /*{
        "api_status": 1,
            "api_message": "success",
            "data": {
        "id": 13,
                "name": "ahmedc",
                "email": "ahmedc@ahmedc.com",
                "photo": null,
                "birthday": "1982-12-22",
                "phone_number": "12345678",
                "points": 0
    }
    }*/

        String name,email,photo,birthday,phone_number;
        int points;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getPhone_number() {
            return phone_number;
        }

        public void setPhone_number(String phone_number) {
            this.phone_number = phone_number;
        }

        public int getPoints() {
            return points;
        }

        public void setPoints(int points) {
            this.points = points;
        }



        protected DataModel(Parcel in) {
            this.name=in.readString();
            this.email=in.readString();
            this.birthday=in.readString();
            this.phone_number=in.readString();
            this.photo=in.readString();
            this.points=in.readInt();
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
        public void writeToParcel(Parcel dest, int i) {
            dest.writeString(this.name);
            dest.writeString(this.email);
            dest.writeString(this.birthday);
            dest.writeString(this.phone_number);
            dest.writeString(this.photo);
            dest.writeInt(this.points);
        }
    }
}
