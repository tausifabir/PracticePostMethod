package com.example.cricketapiretrofit.SharedPreferenceClass;

import android.content.Context;
import android.content.SharedPreferences;

public class Userpreferences {

    public static final String PREFERENCE_NAME = "User Authenticaion";
    public static final String USER_EMAIL = "email";
    public static final String USER_PASS = "password";
    private SharedPreferences sharedpreferences;
    private SharedPreferences.Editor editor;
    private Context context;

    public Userpreferences(Context context) {
        this.context = context;
        this.sharedpreferences = context.getSharedPreferences (PREFERENCE_NAME,Context.MODE_PRIVATE);
        editor = sharedpreferences.edit();

    }

    public void saveUser(String email,String pass){
        editor.putString(USER_EMAIL,email);
        editor.putString(USER_PASS,pass);
        editor.commit();
    }

    public   String getUserEmail(){
        return sharedpreferences.getString(USER_EMAIL,"Invailed");

    }


    public String getUserPass(){
        return  sharedpreferences.getString(USER_PASS,"Invaild");
    }
}
