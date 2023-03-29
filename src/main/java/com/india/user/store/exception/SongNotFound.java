package com.india.user.store.exception;

public class SongNotFound extends Exception{

    String message;

    public SongNotFound(String message){
        super(message);
    }
}
