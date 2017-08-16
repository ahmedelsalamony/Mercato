package com.example.ahmedsalamony.mercato.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ahmed Salamony on 8/14/2017.
 */

public class RegisterModel implements Parcelable {
    String name,password,email,phone_number,birthday;
    Boolean success;
    @SerializedName("data")
    LoginModel.DataModel data;
    String error;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public LoginModel.DataModel getData() {
        return data;
    }

    public void setData(LoginModel.DataModel data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public RegisterModel(String name,String email, String password,String birthday,String phone_number){
        this.name=name;
        this.email=email;
        this.password=password;
        this.birthday=birthday;
        this.phone_number=phone_number;
    }

    protected RegisterModel(Parcel in) {
        this.success = in.readByte() != 0;
        this.data = in.readParcelable(LoginModel.DataModel.class.getClassLoader());
        this.error=in.readString();
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
        dest.writeByte((byte) (this.success ? 1 : 0));
        dest.writeParcelable(this.data, flags);
    }
}
