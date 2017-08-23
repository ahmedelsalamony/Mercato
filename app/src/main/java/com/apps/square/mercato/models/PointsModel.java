package com.apps.square.mercato.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Ahmed Salamony on 8/20/2017.
 */

public class PointsModel implements Parcelable{

    int api_status;
    String api_message;
    @SerializedName("data")
    List<PointsModel.DataModel> data;

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

    public List<DataModel> getData() {
        return data;
    }

    public void setData(List<DataModel> data) {
        this.data = data;
    }

    protected PointsModel(Parcel in) {
        api_status = in.readInt();
        api_message = in.readString();
        data = in.createTypedArrayList(PointsModel.DataModel.CREATOR);
    }

    public static final Creator<PointsModel> CREATOR = new Creator<PointsModel>() {
        @Override
        public PointsModel createFromParcel(Parcel in) {
            return new PointsModel(in);
        }

        @Override
        public PointsModel[] newArray(int size) {
            return new PointsModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(api_status);
        parcel.writeString(api_message);
        parcel.writeTypedList(data);
    }
    public static class DataModel implements Parcelable{

        int id,points;
        String description;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getPoints() {
            return points;
        }

        public void setPoints(int points) {
            this.points = points;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        protected DataModel(Parcel in) {
            id = in.readInt();
            points=in.readInt();
            description = in.readString();

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
            parcel.writeInt(id);
            parcel.writeInt(points);
            parcel.writeString(description);
        }
    }

}
