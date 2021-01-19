package com.osanda.premier.league.model;

import java.io.Serializable;
import java.util.Objects;

/** implements Comparable interface to compare football objects
 * implements serializable to save objects and retrieve objects
 * @author Osanda Ginige w1761754
 */
public class FootballClub extends SportsClub implements Comparable<FootballClub>,Serializable{
    private int numberOfWins;
    private int numberOfDraws;
    private int numberOfDefeats;
    private int numberOfGoalsScored;
    private int numberOfGoalsReceived;
    private int numberOfPoints;
    private int numberOfMatchesPlayed;


    public FootballClub(String clubName, String location){
        super(clubName,location);
    }

    public void setNumberOfWins(int wins){
        this.numberOfWins += wins;
    }

    public void setNumberOfDefeats(int defeats){
        this.numberOfDefeats += defeats;
    }

    public void setNumberOfGoalsScored(int goalsScored){
        this.numberOfGoalsScored += goalsScored;
    }

    public void setNumberOfGoalsReceived(int goalsReceived){
        this.numberOfGoalsReceived += goalsReceived;
    }

    public void setNumberOfPoints(int points){
        this.numberOfPoints += points;
    }

    public void setNumberOfMatchesPlayed(int MatchesPlayed){
        this.numberOfMatchesPlayed += MatchesPlayed;
    }

    public void setNumberOfDraws(int draws){
        this.numberOfDraws += draws;
    }

    public int getNumberOfWins(){
        return numberOfWins;
    }

    public int getNumberOfDraws() {
        return numberOfDraws;
    }

    public int getNumberOfDefeats() {
        return numberOfDefeats;
    }

    public int getNumberOfGoalsScored() {
        return numberOfGoalsScored;
    }

    public int getNumberOfGoalsReceived() {
        return numberOfGoalsReceived;
    }

    public int getNumberOfPoints() {
        return numberOfPoints;
    }

    public int getNumberOfMatchesPlayed() {
        return numberOfMatchesPlayed;
    }

    @Override
    public String toString() {
        return "FootballClub { " + "numberOfWins = " + numberOfWins  + ", numberOfDraws = " +numberOfDraws +
                ", numberOfDefeats = " + numberOfDefeats + ", numberOfGoalsScored = " +  numberOfGoalsScored +
                ", numberOfGoalsReceived = " + numberOfGoalsReceived + ", numberOfPoints = " + numberOfPoints +
                ", numberOfMatchesPlayed = " + numberOfMatchesPlayed + " }";
    }

    @Override
    public int compareTo(FootballClub club) {
        if (club.getNumberOfPoints() - this.getNumberOfPoints() == 0){
            int currentClubGoalDifference = this.getNumberOfGoalsScored() - this.getNumberOfGoalsReceived();
            int clubGoalDifference = club.getNumberOfGoalsScored() - club.getNumberOfGoalsReceived();
            return  currentClubGoalDifference - clubGoalDifference;
        }
        return club.getNumberOfPoints() - this.getNumberOfPoints();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {return true;}
        if (object == null || getClass() != object.getClass()) {return false;}
        if (object instanceof FootballClub){
            FootballClub footballClub = (FootballClub) object;
            return Objects.equals(getClubName(), footballClub.getClubName());
        }
        return false;
    }

}