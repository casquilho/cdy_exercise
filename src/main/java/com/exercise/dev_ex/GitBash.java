package com.exercise.dev_ex;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class GitBash {


        public static final String path_bash = "C:/Program Files/Git/git-bash.exe";

        // Create a file Output.txt where git-bash prints the results
        public static final String path_file_output_git_bash =
                "C:/Users/Casquilho/Desktop/Output.txt";

        public static void main(String[] args) {
            // Path to your repository
            String path_repository = "cd D:/Programas/GoogleDrive/Trabalhos/Personal Projects/clones/tmp/teste";
            // Git command you want to run
            String git_command = "git log";

            String command = path_repository + " && " + git_command + " > " + path_file_output_git_bash;

            runCommand(command);
        }

        public static void runCommand(String command) {
            try {
                ProcessBuilder processBuilder = new ProcessBuilder();


                processBuilder.command(path_bash, "-c", command);


                Process process = processBuilder.start();
                System.out.println(process.getOutputStream().toString());

                int exitVal = process.waitFor();
                if (exitVal == 0) {
                    System.out.println(" --- Command run successfully");
                    System.out.println(" --- Output = " /*+ readFileTxt()*/);


                } else {
                    System.out.println(" --- Command run unsuccessfully");
                }
            } catch (InterruptedException | IOException e) {
                System.out.println(" --- Interruption in RunCommand: " + e);
                // Restore interrupted state
                Thread.currentThread().interrupt();
            }
        }

        public static String readFileTxt() {
            String data = null;
            try {
                File myObj = new File(path_file_output_git_bash);
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    data = myReader.nextLine();
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println(" --- An error occurred");
                e.printStackTrace();
            }
            return data;
        }

}
