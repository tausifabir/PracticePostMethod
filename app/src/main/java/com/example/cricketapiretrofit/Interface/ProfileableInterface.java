package com.example.cricketapiretrofit.Interface;

import com.example.cricketapiretrofit.Model.FundTransferReportDataModel;
import com.example.cricketapiretrofit.Model.InternetPackageModel;
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


    //get Fund transfer report list
    @POST("api/transfer_report.php")
    @FormUrlEncoded
    Call<FundTransferReportDataModel> getFundTransferReport(@Field("user_name") String userName,
                                                            @Field("password") String userPass,
                                                            @Field("category") String userCategory,
                                                            @Field("limit") String listLimit,
                                                            @Field("type") String reportType);

    @POST("api/load_package.php")
    @FormUrlEncoded
    Call<InternetPackageModel> getInternetPakage(@Field("user_id") String userId,
                                                 @Field("operator") String operator);

}
