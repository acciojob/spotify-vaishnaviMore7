package com.driver;

import java.util.*;

import org.springframework.stereotype.Repository;


@Repository
public class SpotifyRepository {
    public HashMap<Artist, List<Album>> artistAlbumMap;
    public HashMap<Album, List<Song>> albumSongMap;
    public HashMap<Playlist, List<Song>> playlistSongMap;
    public HashMap<Playlist, List<User>> playlistListenerMap;
    public HashMap<User, Playlist> creatorPlaylistMap;
    public HashMap<User, List<Playlist>> userPlaylistMap;
    public HashMap<Song, List<User>> songLikeMap;

    public List<User> users;
    public List<Song> songs;
    public List<Playlist> playlists;
    public List<Album> albums;
    public List<Artist> artists;

    public SpotifyRepository() {
        //To avoid hitting apis multiple times, initialize all the hashmaps here with some dummy data
        artistAlbumMap = new HashMap<>();
        albumSongMap = new HashMap<>();
        playlistSongMap = new HashMap<>();
        playlistListenerMap = new HashMap<>();
        creatorPlaylistMap = new HashMap<>();
        userPlaylistMap = new HashMap<>();
        songLikeMap = new HashMap<>();

        users = new ArrayList<>();
        songs = new ArrayList<>();
        playlists = new ArrayList<>();
        albums = new ArrayList<>();
        artists = new ArrayList<>();
    }

    public User createUser(String name, String mobile) {
        User user=new User(name,mobile);
        users.add(user);
        return user;
    }

    public Artist createArtist(String name) {
        artists.add(new Artist(name));
        return new Artist(name);
    }

    public Album createAlbum(String title, String artistName) {
        albums.add(new Album(title, artistName));
        return new Album(title, artistName);
    }

    public Song createSong(String title, String albumName, int length) throws Exception {
        if(Album.getTitle().equalsIgnoreCase(albumName)){
            throw new Exception("album not found");
        }
        songs.add(new Song(title,albumName, length));
        return new Song(title,albumName, length);
    }

    public Playlist createPlaylistOnLength(String mobile, String title, int length) throws Exception {
        playlists.add(new Playlist(mobile, title, String.valueOf(length)));
        return new Playlist(mobile, title, String.valueOf(length));


    }

    public Playlist createPlaylistOnName(String mobile, String title, List<String> songTitles) throws Exception {
        playlists.add(new Playlist(mobile, title, songTitles));
        return new Playlist(mobile, title, songTitles);

    }
    Playlist playlistName;
    public Playlist findPlaylist(String mobile, String playlistTitle) throws Exception {
        int count=0;
        playlistName=new Playlist(mobile,playlistTitle);
        for(int i=0;i< playlists.size();i++){
            if (playlists.contains(playlistName)){
                count=i;
            }
        }
        return playlists.get(count);
    }


    Song songLiked;
    HashMap<Song,Integer>LikedSong=new HashMap<>();
    int max=0;
    public Song likeSong(String mobile, String songTitle) throws Exception {
        for (Map.Entry<Song, List<User>> e : songLikeMap.entrySet()) {
            LikedSong.put(e.getKey(),e.getValue().size());
        }
        Song songLiked=new Song(mobile,songTitle);
        max=Collections.max(LikedSong.values());
        for (Map.Entry<Song, Integer> e : LikedSong.entrySet()) {
            if(e.getValue()==max){
                songLiked=e.getKey();
            }
        }
        return songLiked;
    }
    public String mostPopularArtist() {
        String artistName=null;
        if (songLiked.getTitle().equalsIgnoreCase(Album.getTitle())){
            artistName=Album.getArtistname();
        }

        return artistName;
    }


    public String mostPopularSong() {

        return songLiked.getTitle() ;
    }
}
