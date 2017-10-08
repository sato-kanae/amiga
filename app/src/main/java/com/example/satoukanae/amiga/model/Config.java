package com.example.satoukanae.amiga.model;

/**
 * Created by satoukanae on 2017/10/08.
 */

import java.util.List;
import java.util.ArrayList;

public class Config{
    private static Config config = new Config();
    public List<User> users;

    private Config() {
        this.users = new ArrayList<User>();
    }

    public static Config getInstance(){
        return config;
    }

}