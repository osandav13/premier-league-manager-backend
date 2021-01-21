package com.osanda.premier.league.model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Match data Stored in these objects serializable
 * implemented to save objects in a file
 */
public class Match implements Serializable {
    private String firstClubName;
    private String secondClubName;
    private String matchName;
    private int goalsByFirstClub;
    private int goalsBySecondClub;
    private LocalDate matchDate;
    private String winner;
    private String score;


    /**
     * use to make a new match object
     * @param firstClubName club name of one of the team
     * @param secondClubName club name of one of the team
     * @param matchDate date of the match
     */
    public Match(String firstClubName, String secondClubName, LocalDate matchDate){
        this.firstClubName = firstClubName;
        this.secondClubName = secondClubName;
        this.matchName = firstClubName + " Vs " + secondClubName;
        this.matchDate = matchDate;
    }

    public String getFirstClubName() {
        return firstClubName;
    }

    public void setFirstClubName(String firstClubName) {
        this.firstClubName = firstClubName;
    }

    public String getSecondClubName() {
        return secondClubName;
    }

    public void setSecondClubName(String secondClubName) {
        this.secondClubName = secondClubName;
    }

    public String getMatchName() {
        return matchName;
    }

    public void setScore(String score){this.score = score;}

    public String getScore() {
        return score;
    }

    public int getGoalsByFirstClub() {
        return goalsByFirstClub;
    }

    public void setGoalsByFirstClub(int goalsByFirstClub) {
        this.goalsByFirstClub = goalsByFirstClub;
    }

    public int getGoalsBySecondClub() {
        return goalsBySecondClub;
    }

    public void setGoalsBySecondClub(int getGoalsBySecondClub) {
        this.goalsBySecondClub = getGoalsBySecondClub;
    }

    public LocalDate getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(LocalDate matchDate) {
        this.matchDate = matchDate;
    }

    public String getWinner() {
        return winner;
    }

    /**
     * winner is club name is set according to the goal number
     * if the goal numbers are same winner is set as Draw
     */
    public void setWinner() {
        if (this.goalsByFirstClub > this.goalsBySecondClub){winner = firstClubName;}
        else if(this.goalsBySecondClub > this.goalsByFirstClub){ winner = secondClubName;}
        else{winner = "Draw";}
    }

}

