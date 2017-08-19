package com.example.ahmedsalamony.mercato.tools;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;

import com.example.ahmedsalamony.mercato.R;
import com.example.ahmedsalamony.mercato.dialog.DialogManager;
import com.example.ahmedsalamony.mercato.models.LoginModel;
import com.example.ahmedsalamony.mercato.models.MenuModel;
import com.example.ahmedsalamony.mercato.models.ProductsCategoriesModel;
import com.example.ahmedsalamony.mercato.models.RegisterModel;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Ahmed Salamony on 8/14/2017.
 */

public class APIManager {

    public static final String URL_BASE = "http://mercatocoffee.com/api/";


    public static final String URL_Login = URL_BASE + "login";
    public static final String URL_Register = URL_BASE + "register";
    public static final String URL_OurMenu = URL_BASE + "our_menu";
    public static final String URL_products_category = URL_BASE + "products_category";
    public static final String Authorization = "X-Authorization-token";

    public interface APIsInterface {

        @Headers({"X-Authorization-token: 12b20fa6cca0ee113dc92d16f6be3029"})
        @POST(URL_Login)
        Call<LoginModel> Login_user(@Body LoginModel body );

        @Headers({"X-Authorization-token: 12b20fa6cca0ee113dc92d16f6be3029"})
        @POST(URL_Register)
        Call<RegisterModel> register_user(@Body RegisterModel body );

        @Headers({"X-Authorization-token: 12b20fa6cca0ee113dc92d16f6be3029"})
        @GET(URL_Register)
        Call<MenuModel> our_menu();

        @Headers({"X-Authorization-token: 12b20fa6cca0ee113dc92d16f6be3029"})
        @GET(URL_products_category)
        Call<ProductsCategoriesModel> products_category();



    }



    public static void LoginUser(Context context, String email, String password, final ResponseListener responseListener) {
        LoginModel x = new LoginModel(email, password);
        Call call = RetrofitManager.getAPIBuilder(URL_BASE).Login_user(x);
        boolean showLoadingDialog = true;
        performNormalRequest(context, call, showLoadingDialog, responseListener);

    }

    public static void registerUser(Context context,String name,String email,String password,String date,String phone_number,final ResponseListener responseListener){
        RegisterModel x=new RegisterModel(name,email,password,date,phone_number);
        Call call=RetrofitManager.getAPIBuilder(URL_BASE).register_user(x);
        boolean showLoadingDialog=true;
        performNormalRequest(context,call,showLoadingDialog,responseListener);
    }

    public static void getOurMenu(Context context, final ResponseListener responseListener){
        Call call=RetrofitManager.getAPIBuilder(URL_BASE).our_menu();
        boolean showLoadingDialog=true;
        performNormalRequest(context,call,showLoadingDialog,responseListener);
    }


    private static ProgressDialog showLoadingDialog(Context context, final Call call) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage(context.getString(R.string.msg_loading));
        progressDialog.setIndeterminate(true);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
        progressDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                try {
                    call.cancel();
                } catch (Exception e) {
                }
            }
        });
        return progressDialog;
    }

    private static void closeLoadingDialog(ProgressDialog progressDialog) {
        try {
            progressDialog.dismiss();
        } catch (Exception e) {
        }
    }

    public interface ResponseListener<M> {
        void done(M dataModel);

        void failed(boolean fromConnection);
    }

    private static void performNormalRequest(final Context context, final Call call, final boolean showLoading, final ResponseListener responseListener) {
        Log.e("URL", call.request().url().toString());
        if (call.request().body() != null)
            Log.e("onSuccess", new Gson().toJson(call.request().body()));

        ProgressDialog progressDialog = null;
        if (showLoading) {
            progressDialog = showLoadingDialog(context, call);
        }
        final ProgressDialog tempProgressDialog = progressDialog;
        call.enqueue(new RetrofitManager.APICallBack() {
            @Override
            public void onSuccess(Object data) {
                String response = new Gson().toJson(data);
                Log.e("Result", response);
                if (showLoading) closeLoadingDialog(tempProgressDialog);
                try {
//                    JSONObject responseJsonObject=new JSONObject(response);
//                    int isResultHasData=responseJsonObject.getInt(TAG_IS_RESULT_HAS_DATA);
//                    if(isResultHasData>0){
                    responseListener.done(data);
//                    }else{
//                        Toast.makeText(context, context.getString(R.string.msg_couldnt_perform_operation), Toast.LENGTH_SHORT).show();
//                    }
                } catch (Exception e1) {
                    try {
                        responseListener.done(data);
                    } catch (Exception e) {
                    }
                }
            }

            @Override
            public void onFailed(boolean fromConnection) {
                Log.e("onFailed", fromConnection + "");
                if (showLoading) closeLoadingDialog(tempProgressDialog);
                String msg;
                if (fromConnection) msg = context.getString(R.string.msg_check_connection);
                else msg = context.getString(R.string.msg_check_server);
                if (context instanceof Activity) {
                    if (context != null) {
                        DialogManager.showConfirmDialog((Activity) context, msg, context.getString(R.string.label_retry),
                                context.getString(R.string.label_cancel), new DialogManager.Confirm() {
                            @Override
                            public void ok() {
                                performNormalRequest(context, call.clone(), showLoading, responseListener);
                            }
                        }, new DialogManager.Confirm() {
                            @Override
                            public void ok() {
//                                if(call.request().url().toString().equals(URL_BASE+URL_GET_SALON_DATA) && context instanceof SalonDetailsActivity){
//                                    ((Activity)context).finish();
//                                }
                            }
                        });
                    }
                } else DialogManager.showToast(context, msg);
                responseListener.failed(fromConnection);
            }
        });
    }
}
