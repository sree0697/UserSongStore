package com.india.user.store.test;

import com.india.user.store.dao.Song;
import com.india.user.store.dao.User;
import com.india.user.store.exception.PlayListFull;
import org.testng.annotations.Test;

public class PlayListTest {

    @Test
    public void testScenario1() throws PlayListFull {
        User user1 = new User(1,"Tom");
        System.out.println("Start test case ");
        user1.addSongsToPlayList(new Song(1,"Song1"));
        System.out.println(user1.getPlayList().size());

    }


}
