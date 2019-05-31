package com.example.firebasedatabaseapp;

public class Student {

    String stdId;
    String stdUsername;
    String stdPassword;
    String stdState;

    public Student(){}


    public Student(String stdId, String stdUsername, String stdPassword, String stdState) {
        this.stdId = stdId;
        this.stdUsername = stdUsername;
        this.stdPassword = stdPassword;
        this.stdState = stdState;
    }

    public String getStdId() {
        return stdId;
    }

    public void setStdId(String stdId) {
        this.stdId = stdId;
    }

    public String getStdUsername() {
        return stdUsername;
    }

    public void setStdUsername(String stdUsername) {
        this.stdUsername = stdUsername;
    }

    public String getStdPassword() {
        return stdPassword;
    }

    public void setStdPassword(String stdPassword) {
        this.stdPassword = stdPassword;
    }

    public String getStdState() {
        return stdState;
    }

    public void setStdState(String stdState) {
        this.stdState = stdState;
    }
}
