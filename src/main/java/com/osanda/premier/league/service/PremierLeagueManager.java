package com.osanda.premier.league.service;

import com.osanda.premier.league.model.LeagueManager;
import com.osanda.premier.league.model.FootballClub;
import com.osanda.premier.league.model.Match;
import com.osanda.premier.league.model.SportsClub;

import java.time.LocalDate;
import java.util.*;
import java.io.*;

/**
 *  All the application logic is in this class
 *  league manager interface is implemented
 * @author Osanda Ginige w1761754
 */
public class PremierLeagueManager implements LeagueManager {
    // all the FootBallClub objects are stored in leagueTeams
    // acts as the main data structure
    private static List<FootballClub> leagueTeams = new ArrayList<>();
    // all the Match objects are stored in matchHistory
    // acts as the main data structure
    private static List<Match> matchHistory = new ArrayList<>();

    public List<FootballClub> getLeagueTeams() {
        return leagueTeams;
    }

    public List<Match> getMatchHistory() {
        return matchHistory;
    }

    @Override
    public void createFootballClub(FootballClub club) {
        leagueTeams.add(club);
        System.out.println(club.getClubName() + " in" + club.getLocation() + " was added to the Premier League");
    }

    /**
     * Removes a football club instance from the leagueTeams List
     * If the removal is successful name of the club will be displayed
     *
     * @param clubName name of the football club element to be removed
     */
    @Override
    public void deleteClub(String clubName){
        for (SportsClub club : leagueTeams){
            if (club.getClubName().equals(clubName)){
                leagueTeams.remove(club);
                System.out.println(club.getClubName() + " has been removed from Premier league");
                return;
            }
        }
        System.out.printf("Football club named %s not in Premier League\n",clubName);
    }

    /**
     * Display statistics about football club from the LeagueTeams List
     * If the provided club is a element of leagueTeams message will be displayed
     *
     * @param clubName name of the club element to display the information
     */
    @Override
    public void displayStatistics(String clubName) {
        for (FootballClub club : leagueTeams){
            if (club.getClubName().equals(clubName)){
                System.out.println("Club name :- " + club.getClubName());
                System.out.println("Club location :- " + club.getLocation());
                System.out.println("Wins :- " + club.getNumberOfWins());
                System.out.println("Defeats :- " + club.getNumberOfDefeats());
                System.out.println("Draws :- " + club.getNumberOfDraws());
                System.out.println("Points :- " + club.getNumberOfPoints());
                System.out.println("Goals scored :- " + club.getNumberOfGoalsScored());
                System.out.println("Goals received :- " + club.getNumberOfGoalsReceived());
                System.out.println("Matches played :- " + club.getNumberOfMatchesPlayed());
                return;
            }
        }
        System.out.printf("%s is not a Premier league club\n",clubName);
    }

    @Override
    public void displayLeagueTable() {

    }

    @Override
    public void addMatchDetails(Match match) {

    }

    @Override
    public void saveToFile() throws FileNotFoundException, IOException {

    }

    @Override
    public void retrieveFromFile() throws IOException, FileNotFoundException, EOFException, ClassNotFoundException {

    }
}
