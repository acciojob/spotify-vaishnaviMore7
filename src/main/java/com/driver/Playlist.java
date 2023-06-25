package com.driver;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String title;
    private String mobile;
    private String length;

    List<String> songs;
    public Playlist(String title,String mobile)  {
        this.title=title;
        this.mobile=mobile;
    }


    public Playlist(String title, String mobile, String length){
        this.title=title;
        this.mobile=mobile;
        this.length=length;

    }
    public Playlist(String title,String mobile,List<String> songs){
        this.title=title;
        this.mobile=mobile;
        songs=new ArrayList<>();
    }
    public String getTitle() {
        return title;
    }

}
