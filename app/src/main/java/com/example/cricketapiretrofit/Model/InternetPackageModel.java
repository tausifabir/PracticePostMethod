
package com.example.cricketapiretrofit.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InternetPackageModel {

    @SerializedName("error")
    @Expose
    private Integer error;
    @SerializedName("error_report")
    @Expose
    private String errorReport;
    @SerializedName("report")
    @Expose
    private List<InternetPakageListModel> report = null;

    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }

    public String getErrorReport() {
        return errorReport;
    }

    public void setErrorReport(String errorReport) {
        this.errorReport = errorReport;
    }

    public List<InternetPakageListModel> getReport() {
        return report;
    }

    public void setReport(List<InternetPakageListModel> report) {
        this.report = report;
    }

}
