package com.driver;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String title;
    private String mobile;
    private String length;

    List<String> songs;

    public Playlist(String title, String mobile, int length){
        this.title=title;
        this.mobile=mobile;


    }
    public Playlist(String title,String mobile,List<String> songs){
        this.title=title;
        this.mobile=mobile;
        songs=new ArrayList<>();
    }

    public Playlist(String title){
        this.title = title;
    }

    public Playlist(String mobile, String title) {
        this.title=title;
        this.mobile=mobile;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
