package com.example.cricketapiretrofit.Interface;

import com.example.cricketapiretrofit.Model.Profile;
import com.example.cricketapiretrofit.Model.ProfileModel;
import com.google.gson.JsonObject;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ProfileableInterface {

    @FormUrlEncoded
    @POST("api/myprofile.php")
    Call<ProfileModel> getProfiles(@Field("user_id") String userID);


    @POST("api/withdraw_info.php")
    @FormUrlEncoded
    Call<JsonObject> getWithdrawInfo(@Field("member_id") String userID);
}
