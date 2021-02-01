package com.osanda.premier.league.controller;

import com.osanda.premier.league.model.FootballClub;
import com.osanda.premier.league.service.PremierLeagueManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
}
