package com.india.user.store.dao;

public class Song {

    private int songID;
    private String songName;
    private double songDuration;
    private String artist;
    private String album;

    public int getSongID() {
        return songID;
    }

    public Song(int songID, String songName) {
        this.songID = songID;
        this.songName = songName;
    }

    public Song(int songID, String songName, double songDuration, String artist, String album) {
        this.songID = songID;
        this.songName = songName;
        this.songDuration = songDuration;
        this.artist = artist;
        this.album = album;
    }

    public void setSongID(int songID) {
        this.songID = songID;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public double getSongDuration() {
        return songDuration;
    }

    public void setSongDuration(double songDuration) {
        this.songDuration = songDuration;
    }

    public String getArtist() {
        return artist;
    }

    @Override
    public String toString() {
        return "Song{" +
                "songID=" + songID +
                ", songName='" + songName + '\'' +
                '}';
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }
}
