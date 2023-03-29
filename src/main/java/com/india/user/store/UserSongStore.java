package com.india.user.store;

import com.india.user.store.dao.Song;
import com.india.user.store.dao.User;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class UserSongStore {

    public static void printPlayList(List<Song> s){
        System.out.println("*************");
        for(int i = 0; i < s.size(); i++){
            System.out.println(s.get(i).toString());
        }
        System.out.println("*************");

    }
    public static void main(String[] args) {

       try{
           Song s1 = new Song(1,"Song1");
           Song s2 = new Song(2,"Song2");
           Song s3 = new Song(3,"Song3");
           Song s4 = new Song(4,"Song4");
           Song s5 = new Song(5,"Song5");

           User user1 = new User(1001,"Harry","Harry6@gmail.com");

           user1.addSongsToPlayList(new LinkedList<>(Arrays.asList(s1,s2,s3)));
           printPlayList(user1.getPlayList());

           user1.playSongFromPlayList(s1);
           printPlayList(user1.getPlayList());

           user1.playSongFromPlayList(s5);
           printPlayList(user1.getPlayList());

           user1.addSongsToPlayList(s2);
           printPlayList(user1.getPlayList());

       } catch (Exception e) {
          e.printStackTrace();
          System.exit(1);
       }


    }
}
