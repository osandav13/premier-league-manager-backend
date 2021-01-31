package com.osanda.premier.league;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring boot server initiation and angular compilation handled
 * @author Osanda Ginige w1761754
 */
@SpringBootApplication
public class PremierLeagueApplication {
    /**
     * start spring boot tomcat server and angular application served and opened
     */
    public static void startGui(String[] args) {
        SpringApplication.run(PremierLeagueApplication.class, args);
        try{
            String dir = System.getProperty("user.dir");
            String filepath= dir.replace("\\","\\\\");
            String newDir = "cd "+filepath+"\\\\src\\\\main\\\\resources\\\\frontend\\\\premierLeagueApp & ng serve --open";
            ProcessBuilder pb = new ProcessBuilder();
            pb.command("cmd.exe","/c",newDir);
            Process process = pb.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
