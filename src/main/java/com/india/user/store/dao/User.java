package com.india.user.store.dao;

import com.india.user.store.exception.PlayListEmpty;
import com.india.user.store.exception.PlayListFull;
import com.india.user.store.exception.SongNotFound;
import java.util.LinkedList;
import java.util.List;

import org.testng.Reporter;

public class User {

    private int userID;
    private String userName;
    private String userEmail;
    private List<Song> playList;
    String capacity1 = System.getenv("INITIAL_CAPACITY");
    private int capacity = Integer.parseInt(capacity1);

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public List<Song> getPlayList() {
        return playList;
    }

    public User(int userID, String userName) {
        this.userID = userID;
        this.userName = userName;
        this.playList = new LinkedList<>();
    }

    public User(int userID, String userName, String userEmail) {
        this.userID = userID;
        this.userName = userName;
        this.userEmail = userEmail;
        this.playList = new LinkedList<>();
    }

    public void addSongsToPlayList(Song s) throws PlayListFull {
        if (s == null) {
            throw new NullPointerException();
        } else {
            if (this.playList.size() < capacity) {
                this.playList.add(s);
                Reporter.log("Song has been added to Playlist " + s.getSongName());

            } else {
                String msg = " Play List is already full. Cannot add new Songs";
                Reporter.log(msg);
                throw new PlayListFull(msg);
            }
        }
    }

    public void addSongsToPlayList(List<Song> songs) throws PlayListFull {
        if (songs == null) {
            Reporter.log("Song List should not be Null. Please provide valid List ");
            throw new NullPointerException();
        } else {
            for (Song s : songs) {
                if (this.playList.size() < capacity) {
                    this.playList.add(s);
                    System.out.println("Song has been added to Playlist " + s.getSongName());
                } else {
                    String msg = " Play List is already full. Cannot add more Songs";
                    Reporter.log(msg);
                    throw new PlayListFull(msg);
                }
            }
        }
    }

    public void deleteSongFromPlayList(Song s) throws PlayListEmpty, SongNotFound , Exception{
        if(!this.playList.isEmpty()){
            if(this.playList.contains(s)){

                Reporter.log("Song has been removed from PlayList ! " +s.getSongName());
                this.playList.remove(s);
            }
            else{
                throw new SongNotFound("Oops ! Current Song is not under your playList ");
            }
        }else{
            throw new PlayListEmpty("Sorry ! Looks like your play List is empty. Please add songs ");
        }
    }

    public void deleteSongFromPlayList(int idx) throws PlayListEmpty, SongNotFound , Exception{
        if(!this.playList.isEmpty()){
            if(this.playList.size() >= idx){
                Reporter.log("Removing song from play List! " +this.playList.get(idx).getSongName());
                this.playList.remove(idx);
                }
            else{
                throw new SongNotFound("Oops ! Current Song is not under your playList ");
            }
        }else{
            throw new PlayListEmpty("Sorry ! Looks like your play List is empty. Please add songs ");
        }
    }

    public void playSongFromPlayList(Song s) throws Exception {
        if(playList.contains(s)){
              this.deleteSongFromPlayList(s);
        }else{
            this.playList.remove(0);
        }
        this.addSongsToPlayList(s);
    }
}
