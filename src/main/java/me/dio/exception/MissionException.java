package me.dio.exception;

public class MissionException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public MissionException(String message){
        super(message);
    }
}
