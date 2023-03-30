package com.india.user.store.test;

import com.india.user.store.UserSongStore;
import com.india.user.store.dao.Song;
import com.india.user.store.dao.User;
import com.india.user.store.exception.PlayListEmpty;
import com.india.user.store.exception.PlayListFull;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PlayListTest {
         
	 Song s1 = new Song(1,"Song1");
     Song s2 = new Song(2,"Song2");
     Song s3 = new Song(3,"Song3");
     Song s4 = new Song(4,"Song4");
     Song s5 = new Song(5,"Song5");
     
     User usera = new User(1001,"Harry","Harry6@gmail.com");
     User user2 = new User(1002,"John","john@gmail.com");
     User user3 = new User(10023,"Bob","bob29@gmail.com");
     
    @Test(priority = 1)
    public void testScenario1() throws PlayListFull {
           System.out.println( usera.getPlayList().size());
           usera.addSongsToPlayList(new LinkedList<>(Arrays.asList(s1,s2,s3)));
            Assert.assertEquals(usera.getPlayList().size(),3);
    }
    
    @Test(priority = 2)
    public void testScenario2() throws Exception {
    	   
    	   List<Song> expectedList = new LinkedList<Song>(Arrays.asList(s2,s3,s1));
    	   
           usera.playSongFromPlayList(s1);
           Assert.assertEquals(usera.getPlayList(), expectedList);

    }
    
    @Test(priority = 3)
    public void testScenario3() throws Exception {
    	
    	 List<Song> expectedList = new LinkedList<Song>(Arrays.asList(s3,s1,s4));
  	   
         usera.playSongFromPlayList(s4);
         Assert.assertEquals(usera.getPlayList(), expectedList);
    	
    }

    @Test(priority = 4)
    public void testScenario4() throws PlayListFull {
    	
    	
    	Assert.assertThrows(PlayListFull.class,() -> usera.addSongsToPlayList(s2));
    		
    }
    
    @Test(priority = 5)
    public void testScenario5() {
    	
    	List<Song> nullList = null;
    	Assert.assertThrows(NullPointerException.class , () -> user2.addSongsToPlayList(nullList));   	
    }
    
    @Test(priority = 6)
    public void testScenario6() {
    	
    	Assert.assertThrows(PlayListEmpty.class , () -> user3.deleteSongFromPlayList(s1));
    }
    
    @Test(priority = 7)
    public void testScenario7() throws Exception {
    	
     List<Song> expectedList = new LinkedList<Song>(Arrays.asList(s4,s5));
    	   	   
    	user3.playSongFromPlayList(s4);
    	user3.playSongFromPlayList(s5);
    	
    	Assert.assertEquals(user3.getPlayList(), expectedList);
    	
    }
}
