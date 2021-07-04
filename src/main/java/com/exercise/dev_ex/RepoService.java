package com.exercise.dev_ex;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class RepoService implements Serializable {

    private static final String path_bash = "C:/Program Files/Git/git-bash.exe";
    private static final String path_file_output_git_bash ="../../logs/";

    private static final String git_log = "git log";
    private static final String git_clone= "git clone";
    //String git_url;// = "https://github.com/enoch3712/Scalping_Fx.git";
    private static final String path_repository = "cd files/repos";
    private static final String path_logs = "files/logs/";

    public RepoService(){

    }

    public void addRepo(){
        System.out.println("Insert Repository URL: ");
        try{
            Scanner in = new Scanner(System.in);
            String url = in.nextLine();
            String[] split = url.split("/|\\.");
            String repo_name = split[split.length-2];

            cloneRepo(url);
            logCommits(repo_name);

            //Repo repo = deserialize(repo_name);

            return;

        }
        catch (Exception e){
            e.printStackTrace();
            return;
        }

    }

    public void deserialize(String repo_name) throws FileNotFoundException {
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        List<Commit> commits = new LinkedList<Commit>();
        List<String> teste = new ArrayList<>() ;
        int i = 0;
        Scanner in = new Scanner(new FileReader(path_logs + repo_name + ".txt"));

        while(in.hasNext()){
            teste.add(in.nextLine())  ;
        }
        System.out.println();
        return ;
    }

    private void cloneRepo(String git_url) throws IOException, InterruptedException {

        String clone_command =  path_repository + " && " + git_clone +" "+ git_url;

        System.out.println(clone_command);

        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command(path_bash, "-c", clone_command);

        Process process = processBuilder.start();

        int exitVal = process.waitFor();
        if (exitVal == 0) {
            System.out.println(" Repo cloned successfully");
        } else {
            System.out.println(" Repo cloned unsuccessfully");
        }
    }

    private void logCommits(String repo_name) throws InterruptedException, IOException {

        String command = path_repository+ "/" + repo_name + " && " + git_log + " > " + path_file_output_git_bash + repo_name + ".txt";

        System.out.println(command);

        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command(path_bash, "-c", command);


        Process process = processBuilder.start();

        int exitVal = process.waitFor();
        if (exitVal == 0) {
            System.out.println(" Commits logged successfully");
        } else {
            System.out.println(" Commits logged unsuccessfully");
        }
    }

}
