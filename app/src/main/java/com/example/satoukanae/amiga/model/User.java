package com.example.satoukanae.amiga.model;

/**
 * Created by tester0333 on 2017/10/07.
 */

public class User {
    private int timeIcon;
    private int faceIcon;
    private String name;
    private String nickname;
    private String faculty;
    private String lang;
    private String highschool;
    private String hobby;
    private String like;
    private String club;
    private String life;


    public User(int timeIcon, int faceIcon, String name){
        this.timeIcon = timeIcon;
        this.faceIcon = faceIcon;
        this.name = name;
    }

    public User(int timeIcon, int FaceIcon,
         String name, String nickname, String faculty, String lang,
         String highschool, String hobby, String like,
         String club,
         String life){
        this.timeIcon = timeIcon;
        this.faceIcon = faceIcon;
        this.name =   name;
        this.nickname = nickname;
        this.faculty = faculty;
        this.lang = lang;
        this.highschool = highschool;
        this.hobby = hobby;
        this.like = like;
        this.club = club;
        this.life = life;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getHighschool() {
        return highschool;
    }

    public void setHighschool(String highschool) {
        this.highschool = highschool;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getLife() {
        return life;
    }

    public void setLife(String life) {
        this.life = life;
    }

    public String getNickname() {

        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public float compare(User user){
        float pfcl;
        float plng;
        float phs;

        if(this.faculty.equals(user.faculty)){
            pfcl = 1;
        }else{
            pfcl = 0;
        }
        if(this.lang.equals(user.lang)){
            plng = 1;
        }else{
            plng = 0;
        }
        if(this.highschool.equals(user.highschool)){
            phs = 1;
        }else{
            phs = 0;
        }

        return pfcl + plng + phs;
    }
}
