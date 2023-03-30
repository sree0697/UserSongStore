package com.india.user.store;

import com.india.user.store.dao.ManagerUserSession;
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
           
    	   ManagerUserSession session = new ManagerUserSession();
    	   session.processUserSongPairs();    	   
    	   
    	   for(String users : session.userSongs.keySet()) {
    		   
    		   System.out.print(session.userSongs.get(users).getUserName());
    		   
    	   }

       } catch (Exception e) {
          e.printStackTrace();
          System.exit(1);
       }


    }
}
