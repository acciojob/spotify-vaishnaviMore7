package com.driver;

import java.util.Date;

public class Album {
    private static String title;

    public static String getArtistname() {
        return Artistname;
    }


    private static String Artistname;
    private Date releaseDate;

    public Album(String title,String Artistname){
           this.title=title;
           this.Artistname=Artistname;
    }


    public static String getTitle() {
        return title;
    }


}
