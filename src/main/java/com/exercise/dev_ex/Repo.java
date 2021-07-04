package com.exercise.dev_ex;

import java.util.List;

public class Repo {
    public String name;
    public String uri;
    public List<Commit> commits;


    public Repo(String name, String uri, List<Commit> commits){
        this.name = name;
        this.uri = uri;
        this.commits = commits;
    }
}
