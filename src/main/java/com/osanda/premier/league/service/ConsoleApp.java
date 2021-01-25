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
}