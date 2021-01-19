package com.osanda.premier.league.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * parent class of FootballClub,SchoolFootballClub,UniversityFootballClub
 * implement serializable to save to file
 * @author Osanda Ginige w1761754
 */
public abstract class SportsClub implements Serializable {
    private String clubName;
    private String location;


    public SportsClub(String clubName, String location){
        this.clubName = clubName;
        this.location = location;

    }
    public void setClubName(String clubName){
        this.clubName = clubName;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public String getClubName(){
        return clubName;
    }

    public String getLocation(){
        return location;
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) {return true;}
        if (object == null || getClass() != object.getClass()) {return false;}
        if (object instanceof SportsClub){
            SportsClub sportsClub = (SportsClub) object;
            return Objects.equals(clubName, sportsClub.clubName) &&
                    Objects.equals(location, sportsClub.location);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(clubName, location);
    }
}
