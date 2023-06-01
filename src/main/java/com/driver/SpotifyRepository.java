package com.driver;

import java.util.*;

import org.springframework.stereotype.Repository;
import com.driver.Playlist;

import static com.driver.Artist.getName;

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

    public SpotifyRepository(){
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
        users.add(new User(name,mobile));
        return new User(name,mobile);
    }

    public Artist createArtist(String name) {
        artists.add(new Artist(name));
        return new Artist(name);
    }

    public Album createAlbum(String title, String artistName) {
        albums.add(new Album(title,artistName));
        return new Album(title,artistName);
    }

    public Song createSong(String title, String albumName, int length) throws Exception{
        songs.add(new Song(albumName,length));
        return new Song(albumName,length);
    }

    public Playlist createPlaylistOnLength(String mobile, String title, int length) throws Exception {
        playlists.add(new Playlist(mobile,title,length));
        return new Playlist(mobile,title,length);


    }

    public Playlist createPlaylistOnName(String mobile, String title, List<String> songTitles) throws Exception {
        playlists.add(new Playlist(mobile,title,songTitles));
        return new Playlist(mobile,title,songTitles);

    }

    public Playlist findPlaylist(String mobile, String playlistTitle) throws Exception {
        playlists.contains(new Playlist(mobile,playlistTitle));
        return new Playlist(mobile,playlistTitle);

    }

    public Song likeSong(String mobile, String songTitle) throws Exception {
        songLikeMap.containsValue(new Song (songTitle,mobile));
        return new Song(songTitle,mobile);

    }

    public String mostPopularArtist() {
        if(Artist.getLikes()>artists.lastIndexOf(artists));
        return "artist"+ Artist.getName();
    }

    public String mostPopularSong() {
        songLikeMap.get(1);
        return "song ";
    }
}
