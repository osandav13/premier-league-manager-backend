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

    /**
     *Display all the information about football club elements in leagueTeams List in a table
     */
    @Override
    public void displayLeagueTable() {
        Collections.sort(leagueTeams);
        String alignmentFormat = "| %-11s | %-15s | %-6s | %-4s | %-5s | %-7s | %-6s |\n";
        System.out.format("                             Primer League table                            \n");
        System.out.format("+--------------------------------------------------------------------------+\n");
        System.out.format("| Position    | Name            | Played | Wins | Draws | Defeats | Points |\n");
        System.out.format("+--------------------------------------------------------------------------+\n");

        for (int i=0;i<leagueTeams.size();i++){
            System.out.format(alignmentFormat,Integer.toString(i+1),leagueTeams.get(i).getClubName(),
                    leagueTeams.get(i).getNumberOfMatchesPlayed(),leagueTeams.get(i).getNumberOfWins(),
                    leagueTeams.get(i).getNumberOfDraws(),+leagueTeams.get(i).getNumberOfDefeats(),
                    leagueTeams.get(i).getNumberOfPoints());

        }
        System.out.format("+--------------------------------------------------------------------------+\n");
    }

    /**
     * updateStats method called to update update football club instances
     *
     * @param match Match instance to be added to matchHistory
     *              Match instance fields are used to
     */
    @Override
    public void addMatchDetails(Match match){
        match.setWinner();
        matchHistory.add(match);

        updateStats(match.getFirstClubName(),match.getWinner(),match.getGoalsByFirstClub(),match.getGoalsBySecondClub());
        updateStats(match.getSecondClubName(),match.getWinner(),match.getGoalsBySecondClub(),match.getGoalsByFirstClub());

    }

    /**
     * update filed of a single football club instance according to passed arguments
     *
     * @param clubName club name of football club instance to be updated
     * @param winner winning club name of the match
     * @param goalsScored number of goals scored by one of teams in match
     * @param goalsReceived number of goals received by one of teams in match
     */
    private void updateStats(String clubName,String winner,int goalsScored,int goalsReceived){
        for(FootballClub club : leagueTeams) {
            if (club.getClubName().equals(clubName)){
                if (club.getClubName().equals(winner)){
                    club.setNumberOfWins(1);
                    club.setNumberOfPoints(3);
                } else if (winner.equals("Draw")){
                    club.setNumberOfDraws(1);
                    club.setNumberOfPoints(1);
                } else {club.setNumberOfDefeats(1);}

                club.setNumberOfMatchesPlayed(1);
                club.setNumberOfGoalsScored(goalsScored);
                club.setNumberOfGoalsReceived(goalsReceived);
            }
        }
    }

    /** save all the Football objects inside the leagueTeams list to a file
     *
     * @throws IOException if the file is not available or permission issue
     * @throws FileNotFoundException if the file is not found in the directory
     */
    @Override
    public void saveToFile() throws IOException,FileNotFoundException{
        try(FileOutputStream fileOut = new FileOutputStream("club save file.ser");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)){
            for (FootballClub club : leagueTeams){
                objectOut.writeObject(club);
            }
        }
        try(FileOutputStream fileOut = new FileOutputStream("match save file.ser");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)){
            for(Match match:matchHistory){
                objectOut.writeObject(match);
            }
        }
        System.out.println("Data has been saved in club save file.ser and match save file.ser");
    }

    /** Read all the serialized objects from the files and add them
     *  to leagueTeam and matchHistory lists
     *
     * @throws IOException if the file is not available or permission issue
     * @throws FileNotFoundException if the file is not found in the directory
     * @throws EOFException if characters in a file has ended
     * @throws ClassNotFoundException if the matching class doesnt exist in for the serialized object
     */
    @Override
    public void retrieveFromFile() throws IOException, FileNotFoundException, EOFException, ClassNotFoundException {
        try(FileInputStream fileIn = new FileInputStream("club save file.ser");
            ObjectInputStream objectInput = new ObjectInputStream(fileIn)){
            if (leagueTeams.size()>0){leagueTeams.clear();}
            try{
                for (;;){
                    FootballClub club = (FootballClub) objectInput.readObject();
                    leagueTeams.add(club);
                }
            }catch (EOFException exception) {
                System.out.println("End of the file");
                System.out.println("all the data has been retrieved from the file");
            }
        }
        try(FileInputStream fileIn = new FileInputStream("match save file.ser");
            ObjectInputStream objectInput = new ObjectInputStream(fileIn)){
            if (matchHistory.size()>0){matchHistory.clear();}
            try{
                for (;;){
                    Match match = (Match) objectInput.readObject();
                    matchHistory.add(match);
                }
            }catch (EOFException exception) {
                System.out.println("End of the file");
                System.out.println("all the data has been retrieved from the file");
            }
        }
    }

    /** generate a random long number between a range
     *
     * @param min inner bound of the range
     * @param max outer bound of the range
     * @return
     */
    private long randomNumber(long min,long max){
        return (long)((Math.random() * (max - min))+min);
    }

    /** generate a random Match object between two teams that are in the
     * leagueTeams list used in the GUI
     *
     * @return Match object that has been generated with random values
     */
    public Match playAMatch(){
        Match match = null;
        int numberOfTeamsInLeague = leagueTeams.size();
        if (numberOfTeamsInLeague < 2){
            System.out.println("Add more teams to play a match");
        }else {
            FootballClub firstTeam;
            FootballClub secondTeam;
            do {
                firstTeam = leagueTeams.get((int) randomNumber(0, numberOfTeamsInLeague));
                secondTeam = leagueTeams.get((int) randomNumber(0, numberOfTeamsInLeague));
            } while (firstTeam.equals(secondTeam));
            int firstTeamScore = (int) randomNumber(0,6);
            int secondTeamScore = (int) randomNumber(0,6);
            LocalDate today = LocalDate.now();
            long startDateNumber = today.toEpochDay();
            long endDateNumber = today.toEpochDay()-30;
            long randomDateNumber = randomNumber(startDateNumber,endDateNumber);
            LocalDate matchDate = LocalDate.ofEpochDay(randomDateNumber);
            match = new Match(firstTeam.getClubName(),secondTeam.getClubName(),matchDate);
            match.setGoalsByFirstClub(firstTeamScore);
            match.setGoalsBySecondClub(secondTeamScore);
            match.setScore(firstTeamScore + " - " + secondTeamScore);
            addMatchDetails(match);
        }
        return match;
    }
}
