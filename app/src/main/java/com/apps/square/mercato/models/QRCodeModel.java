package com.apps.square.mercato.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ahmed Salamony on 8/27/2017.
 */

public class QRCodeModel implements Parcelable {
    int api_status,code;
    String api_message;
    @SerializedName("user_data")
    QRCodeModel.DataModel data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataModel getData() {
        return data;
    }

    public void setData(DataModel data) {
        this.data = data;
    }

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

    protected QRCodeModel(Parcel in) {
        this.api_status = in.readInt();
        this.api_message=in.readString();
        this.data = in.readParcelable(LoginModel.DataModel.class.getClassLoader());
    }

    public static final Creator<QRCodeModel> CREATOR = new Creator<QRCodeModel>() {
        @Override
        public QRCodeModel createFromParcel(Parcel in) {
            return new QRCodeModel(in);
        }

        @Override
        public QRCodeModel[] newArray(int size) {
            return new QRCodeModel[size];
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

    public static class DataModel implements Parcelable {
        int id;
        String name,email,photo,birthday,phone_number,points;


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

        public String getPoints() {
            return points;
        }

        public void setPoints(String points) {
            this.points = points;
        }

        protected DataModel(Parcel in) {
            this.id = in.readInt();
            this.name=in.readString();
            this.email=in.readString();
            this.photo=in.readString();
            this.birthday=in.readString();
            this.phone_number=in.readString();
            this.points=in.readString();
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
            parcel.writeInt(this.id);
            parcel.writeString(this.name);
            parcel.writeString(this.email);
            parcel.writeString(this.photo);
            parcel.writeString(this.birthday);
            parcel.writeString(this.phone_number);
            parcel.writeString(this.points);
        }
    }
}
