package com.osanda.premier.league.controller;

import com.osanda.premier.league.model.FootballClub;
import com.osanda.premier.league.model.Match;
import com.osanda.premier.league.service.PremierLeagueManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * REST API endpoints are defined
 * @author Osanda Ginige w1761754
 */
@RestController
public class PremierLeagueController {
    PremierLeagueManager premierLeagueManager = new PremierLeagueManager();

    /**
     * GET request to /api/leagueTable are served
     *
     * @return List of FootballClub JASON objects are returned
     */
    @CrossOrigin
    @GetMapping("/api/leagueTable")
    public List<FootballClub> getLeague() {
        return premierLeagueManager.getLeagueTeams();
    }

    /**
     * GET request to /api/matchHistory are served
     * depending on the parameter response differ
     * @param date a request String date is passed
     * @return List of Match JASON objects are returned
     */
    @CrossOrigin
    @GetMapping("/api/matchHistory")
    public List<Match> getMatchHistory(@RequestParam(required = false) String date){
        if (date==null){
            return premierLeagueManager.getMatchHistory();
        }else {
            List<Match> matches = new ArrayList<>();
            for (Match match:premierLeagueManager.getMatchHistory()){
                if (match.getMatchDate().toString().contains(date)){
                    matches.add(match);
                }
            }
            return matches;
        }

    }
}
