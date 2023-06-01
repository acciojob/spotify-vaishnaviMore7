package com.driver;

import java.util.List;

public class Artist {
    private static String name;
    private static int likes;

    public Artist(){

    }

    public Artist(String name){
        this.name = name;
        this.likes = 0;
    }

    public static String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
