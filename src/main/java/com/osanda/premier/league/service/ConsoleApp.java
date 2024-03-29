package com.osanda.premier.league.service;

import com.osanda.premier.league.PremierLeagueApplication;
import com.osanda.premier.league.model.FootballClub;
import com.osanda.premier.league.model.Match;


import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.*;

/**
 * This class represent the console application of the the Premier league
 * @author Osanda Ginige w1761754
 */
public class ConsoleApp {
    // PremierLeagueManger object is created to use thought the application
    private static final PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
    private static boolean isGUILunched = false;

    /**
     * data is taken from the console and FootballClub object is created
     * and relevant premierLeagueManger method
     */
    private static void insertFootballClubInfo() {
        Scanner getClubDetails = new Scanner(System.in);
        System.out.println("-------- Enter Club details ---------");
        System.out.print("Enter ClubName : ");
        String clubName = getClubDetails.nextLine();
        System.out.print("Enter Club location : ");
        String location = getClubDetails.nextLine();
        FootballClub club = new FootballClub(clubName, location);
        premierLeagueManager.createFootballClub(club);
    }

    /** club name is taken from the console to delete the that club
     * from the leagueTeams List
     */
    private static void insertDeleteClubInfo(){
        Scanner deleteClubDetails = new Scanner(System.in);
        System.out.print("Enter ClubName : ");
        String clubName = deleteClubDetails.nextLine();
        premierLeagueManager.deleteClub(clubName);
    }

    /**
     * club name is taken as a input to display the details of the club
     */
    private static void insertSelectedClubInfo(){
        Scanner selectedClub = new Scanner(System.in);
        System.out.print("Enter the club name : ");
        String clubName = selectedClub.nextLine();
        premierLeagueManager.displayStatistics(clubName);
    }

    /** String is entered to validate to the pattern used in this application
     *
     * @param dateToValidate String is passed to validate to a pattern
     * @return boolean is return according to validity of the date String
     */
    private static boolean dateValidator(String dateToValidate){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("uuuu/M/d");
        try{
            LocalDate.parse(dateToValidate,format.withResolverStyle(ResolverStyle.STRICT));
            return true;
        }catch (DateTimeParseException exception){
            System.out.println("You have entered a wrong date format");
            return false;
        }
    }

    /**
     * premierLeagueManger method is called to display the the league table
     */
    private static void displayLeagueTable(){
        premierLeagueManager.displayLeagueTable();
    }

    /**
     * Necessary inputs are taken about the match and added
     * and relevant premierLeagueManger method is called to add the details
     */
    private static void insertMatchDetails(){
        boolean isDateCorrect;
        String matchDate;

        Scanner matchDetails = new Scanner(System.in);
        System.out.print("Enter the first Club name : ");
        String firstClubName = matchDetails.nextLine();
        System.out.print("Enter the number of goals scored : ");
        String firstClubGoals = matchDetails.nextLine();
        System.out.print("Enter the second club name : ");
        String secondClubName = matchDetails.nextLine();
        System.out.print("Enter the number of goals scored : ");
        String secondClubGoals = matchDetails.nextLine();
        do {
            System.out.print("Enter the date(yyyy/mm/dd) : ");
            matchDate = matchDetails.nextLine();
            // * date validator is called here
            isDateCorrect = dateValidator(matchDate);
        }while (!isDateCorrect);

        DateTimeFormatter format = DateTimeFormatter.ofPattern("uuuu/M/d");
        LocalDate date = LocalDate.parse(matchDate,format);
        Match match = new Match(firstClubName,secondClubName,date);
        match.setGoalsByFirstClub(Integer.parseInt(firstClubGoals));
        match.setGoalsBySecondClub(Integer.parseInt(secondClubGoals));
        match.setScore(firstClubGoals + " - " + secondClubGoals);
        premierLeagueManager.addMatchDetails(match);

    }

    /**
     * premierLeagueManger method called and
     * all the errors related to writing to file are handed
     * parent exception and child exceptions are handle differently
     * provide meaningful error message to user
     */
    private static void saveToFile(){
        try{
            premierLeagueManager.saveToFile();
        }catch (FileNotFoundException exception) {
            System.out.println("File not found ");
        }catch (IOException exception){
            System.out.println("Cannot find the file");
        }
    }

    /**
     * premierLeagueManger method called and
     * all the errors related to reading from file are handed
     * parent exception and child exceptions are handle differently
     * provide meaningful error message to user
     */
    private static void loadFromFile(){
        try{
            premierLeagueManager.retrieveFromFile();
        }catch (FileNotFoundException exception) {
            System.out.println("File not found");
        }catch(ClassNotFoundException exception){
            System.out.println("Class of retrieving object is not available");
        }catch (IOException exception){
            System.out.println("Cannot find the file");
        }
    }

    /**
     * Spring boot application start method is called and
     * GUI execution start here
     */
    private static void launchGui(String[]args){
        if (!isGUILunched){
            PremierLeagueApplication.startGui(args);
        }else {
            System.out.println("GUI is already lunched");
        }
    }

    /**
     * execution starts here
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to continue from previously closed state");
        System.out.println("Enter your choice(yes/no):");
        String userChoice = scanner.nextLine().toLowerCase();
        if (userChoice.equals("yes")){
            loadFromFile();
        }

        while (true){
            System.out.println("Enter A to add a Football to Primer league");
            System.out.println("Enter D to remove a Football from primer league");
            System.out.println("Enter F to display statics about a Football club in Primer league");
            System.out.println("Enter L to display Primer league table");
            System.out.println("Enter M to add match details");
            System.out.println("Enter S to save the data");
            System.out.println("Enter R to retrieve the data");
            System.out.println("Enter G to load the gui");
            System.out.println("Enter Q to quit");
            System.out.print("Enter your selection : ");
            String userInput = scanner.next().toLowerCase();
            switch(userInput){
                case "a":
                    insertFootballClubInfo();
                    break;
                case "d":
                    insertDeleteClubInfo();
                    break;
                case "f":
                    insertSelectedClubInfo();
                    break;
                case "l":
                    displayLeagueTable();
                    break;
                case "m":
                    insertMatchDetails();
                    break;
                case "s":
                    saveToFile();
                    break;
                case "r":
                    loadFromFile();
                    break;
                case "g":
                    launchGui(args);
                    break;
                case "q":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Your input is not correct");
                    break;
            }
        }
    }
}