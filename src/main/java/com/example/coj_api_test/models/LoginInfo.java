package com.example.coj_api_test.models;


import java.util.ArrayList;
import java.util.List;

public class LoginInfo {
    private List<QrCode> qrCodeArray;
    private List<User> userArray;
    private List<Failed> failedArray;

    public LoginInfo(List<QrCode> qrCodeArray, List<User> userArray, List<Failed> failedArray) {
        this.qrCodeArray = qrCodeArray;
        this.userArray = userArray;
        this.failedArray = failedArray;
    }

    public List<QrCode> getQrCodeArray() {
        return qrCodeArray;
    }

    public void setQrCodeArray(List<QrCode> qrCodeArray) {
        this.qrCodeArray = qrCodeArray;
    }

    public List<User> getUserArray() {
        return userArray;
    }

    public void setUserArray(List<User> userArray) {
        this.userArray = userArray;
    }

    public List<Failed> getFailedArray() {
        return failedArray;
    }

    public void setFailedArray(List<Failed> failedArray) {
        this.failedArray = failedArray;
    }
}
