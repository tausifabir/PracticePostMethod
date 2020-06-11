
package com.example.cricketapiretrofit.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Profile {

    @SerializedName("SL")
    @Expose
    private String sL;
    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("Details")
    @Expose
    private String details;

    public String getSL() {
        return sL;
    }

    public void setSL(String sL) {
        this.sL = sL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

}
