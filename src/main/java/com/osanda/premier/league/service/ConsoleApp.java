package com.osanda.premier.league.service;

//import com.osanda.premier.league.PremierLeagueApplication;
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

}