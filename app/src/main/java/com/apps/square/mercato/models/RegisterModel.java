package com.apps.square.mercato.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Ahmed Salamony on 8/14/2017.
 */

public class RegisterModel implements Parcelable {
    int api_status,id;
    String api_message;

    String  name,email,password,birthday,phone_number;

    public int getApi_status() {
        return api_status;
    }

    public void setApi_status(int api_status) {
        this.api_status = api_status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApi_message() {
        return api_message;
    }

    public void setApi_message(String api_message) {
        this.api_message = api_message;
    }

    public RegisterModel(String name,String email,String password,String birthday,String phone_number){
        this.name=name;
        this.email=email;
        this.password=password;
        this.birthday=birthday;
        this.phone_number=phone_number;
    }
    protected RegisterModel(Parcel in) {
        this.api_status=in.readInt();
        this.api_message=in.readString();
        this.id=in.readInt();
    }

    public static final Creator<RegisterModel> CREATOR = new Creator<RegisterModel>() {
        @Override
        public RegisterModel createFromParcel(Parcel in) {
            return new RegisterModel(in);
        }

        @Override
        public RegisterModel[] newArray(int size) {
            return new RegisterModel[size];
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
        dest.writeInt(this.id);
    }
}
