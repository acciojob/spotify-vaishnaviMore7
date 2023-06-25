package com.driver;

public class Song {
    private String title;
    private int length;
    private int likes;
    private String mobile;
    private String albumName;

    public Song(String title,String mobile){
        this.title=title;
        this.mobile=mobile;

    }
    public Song(String title, String albumName, int length) {
        this .title=title;
        this.albumName=albumName;
        this.length=length;
    }

}
