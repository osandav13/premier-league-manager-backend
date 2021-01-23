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

    @Override
    public void deleteClub(String clubName) {

    }

    @Override
    public void displayStatistics(String clubName) {

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
