package com.exercise.dev_ex;

public class Commit {
    public String sha;
    public String message;
    public String date; //"EEE, MMM d HH:mm:ss yyyy Z"
    public String author;

    public Commit(String sha, String message, String date, String author){
        this.sha = sha;
        this.message = message;
        this.date = date;
        this.author = author;
    }
}
