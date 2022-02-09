package com.java.statemachine;

public class SMSNotification implements INotification{
    private String message;
    private String mobile;

    public SMSNotification() {

    }
    public SMSNotification(String message, String mobile) {
        this.message = message;
        this.mobile = mobile;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public boolean sendNotification() {
        // send sms to mobile number
        return false;
    }
}
