package com.example.constants.query;

public class TeamQueries {

    public static final String ADD_TEAM_QUERY = "INSERT INTO achievement_counter.teams (name) VALUES (:name)";
    public static final String GET_TEAM_BY_ID_QUERY = "SELECT * FROM teams WHERE ID = ?";
    public static final String GET_ALL_TEAMS_QUERY = "SELECT * FROM teams";
    public static final String UPDATE_TEAM_QUERY = "UPDATE teams SET name = :name WHERE id = :id";
}
