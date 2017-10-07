package com.example.satoukanae.amiga.model;

/**
 * Created by tester0333 on 2017/10/07.
 */

public class User {
    private int timeIcon;
    private int faceIcon;
    private String name;

    public User(){

    }

    public User(int timeIcon, int faceIcon, String name){
        this.timeIcon = timeIcon;
        this.faceIcon = faceIcon;
        this.name = name;
    }

    public int getTimeIcon() {
        return timeIcon;
    }

    public void setTimeIcon(int timeIcon) {
        this.timeIcon = timeIcon;
    }

    public int getFaceIcon() {
        return faceIcon;
    }

    public void setFaceIcon(int faceIcon) {
        this.faceIcon = faceIcon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
