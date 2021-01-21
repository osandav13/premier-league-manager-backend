package com.osanda.premier.league.model;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;

/**  this interface provide base implementation for PremierLeagueManager
 * @author Osanda Ginige w1761754
 */
public interface LeagueManager {
    void createFootballClub(FootballClub club);
    void deleteClub(String clubName);
    void displayStatistics(String clubName);
    void displayLeagueTable();
    void addMatchDetails(Match match);
    void saveToFile() throws FileNotFoundException, IOException;
    void retrieveFromFile() throws IOException, FileNotFoundException, EOFException, ClassNotFoundException;
}
