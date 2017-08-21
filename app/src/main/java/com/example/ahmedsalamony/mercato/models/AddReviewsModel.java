package com.example.ahmedsalamony.mercato.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Ahmed Salamony on 8/21/2017.
 */

public class AddReviewsModel implements Parcelable {

    int api_status,id;
    String api_message;
    int  drinks;
    int food;
    int services;
    int employees;
    int cleanness;
    int user_id;
    String notes;

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

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

    public int getDrinks() {
        return drinks;
    }

    public void setDrinks(int drinks) {
        this.drinks = drinks;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getServices() {
        return services;
    }

    public void setServices(int services) {
        this.services = services;
    }

    public int getEmployees() {
        return employees;
    }

    public void setEmployees(int employees) {
        this.employees = employees;
    }

    public int getCleanness() {
        return cleanness;
    }

    public void setCleanness(int cleanness) {
        this.cleanness = cleanness;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public AddReviewsModel(int user_id,int drinks,int food,int services,int employees,int cleanness,String notes) {
        this.notes = notes;
        this.user_id = user_id;
        this.cleanness = cleanness;
        this.employees = employees;
        this.services = services;
        this.food = food;
        this.drinks = drinks;
    }

    public AddReviewsModel(String title){

    }

    protected AddReviewsModel(Parcel in) {
        this.api_status=in.readInt();
        this.api_message=in.readString();
        this.id=in.readInt();
    }

    public static final Creator<AddReviewsModel> CREATOR = new Creator<AddReviewsModel>() {
        @Override
        public AddReviewsModel createFromParcel(Parcel in) {
            return new AddReviewsModel(in);
        }

        @Override
        public AddReviewsModel[] newArray(int size) {
            return new AddReviewsModel[size];
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
