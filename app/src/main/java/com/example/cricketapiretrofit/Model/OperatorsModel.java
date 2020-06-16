package com.example.cricketapiretrofit.Model;

public class OperatorsModel {

    private int imageID;
    private String operatorName;
    private String operatorId;

    public OperatorsModel(int imageID, String operatorName, String operatorId)
    {
        this.imageID = imageID;
        this.operatorName = operatorName;
        this.operatorId = operatorId;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

}
