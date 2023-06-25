package com.driver;
public class Artist {
    private static String name;
    private static int likes;
    public Artist(String name){
        this.name = name;
        this.likes = 0;
    }

    public static String getName() {
        return name;
    }

}
