package com.osanda.premier.league.model;

/**
 * @author Osanda Ginige w1761754
 */
public class SchoolFootballClub extends SportsClub {
    private int numberOfDraws;
    private int numberOfWins;
    private int numberOfDefeats;
    private int numberOfGoalsScored;
    private int numberOfGoalsReceived;
    private int numberOfPoints;
    private int numberOfMatchesPlayed;

    public SchoolFootballClub(String clubName, String location){
        super(clubName,location);
    }

    public void setNumberOfDraws(int numberOfDraws) {
        this.numberOfDraws = numberOfDraws;
    }

    public void setNumberOfWins(int numberOfWins) {
        this.numberOfWins = numberOfWins;
    }

    public void setNumberOfDefeats(int numberOfDefeats) {
        this.numberOfDefeats = numberOfDefeats;
    }

    public void setNumberOfGoalsScored(int numberOfGoalsScored) {
        this.numberOfGoalsScored = numberOfGoalsScored;
    }

    public void setNumberOfGoalsReceived(int numberOfGoalsReceived) { this.numberOfGoalsReceived = numberOfGoalsReceived; }

    public void setNumberOfMatchesPlayed(int numberOfMatchesPlayed) { this.numberOfMatchesPlayed = numberOfMatchesPlayed; }

    public void setNumberOfPoints(int numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
    }

    public int getNumberOfWins() {
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

    public int getNumberOfMatchesPlayed() { return numberOfMatchesPlayed; }

    @Override
    public String toString() {
        return "UniversityFootballClub { " + "clubName = " + getClubName()  + ", NumberOfWins = " + numberOfWins +
                ", NumberOfDraws = " + numberOfDraws + ", NumberOfDefeats = " + numberOfDefeats +
                ", NumberOfGoalsScored = " + numberOfGoalsScored + ", numberOfGoalsReceived = " + numberOfGoalsReceived +
                ", NumberOfPoints = " + numberOfPoints + ", NumberOfMatchesPlayed = " + numberOfMatchesPlayed + " }";
    }

}

