package com.india.user.store.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ManagerUserSession {

	public HashMap<String, String[]> userSongsInput = new HashMap<String, String[]>();
	public HashMap<String, User> userSongs = new HashMap<String, User>();

	public HashMap<String, String[]> createUserSongPairs() {

		userSongsInput.put("userA", new String[] { "Song1", "Song2", "Song3" });
		userSongsInput.put("userB", new String[] { "Song5", "Song6", "Song7" });
		userSongsInput.put("userC", new String[] { "Song10", "Song16", "Song21" });

		return userSongsInput;

	}
	
		
	@Override
	public String toString() {
		return "ManagerUserSession [userSongs=" + userSongs + "]";
	}


	public void processUserSongPairs() {

		userSongsInput = createUserSongPairs();
		int cnt = 1;
		for (String s : userSongsInput.keySet()) {
			User u = new User(cnt, s);

			String[] songs = userSongsInput.get(s);
			List<Song> userPlaylist = new ArrayList<>();
			for (String song : songs) {
				Song s1 = new Song(cnt, song);
				userPlaylist.add(s1);
				cnt++;
			}

			this.userSongs.put(u.getUserName(), u);
			cnt++;

		}

		System.out.println(userSongs.toString());

	}

}
