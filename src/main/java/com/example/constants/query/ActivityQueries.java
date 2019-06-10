package com.example.constants.query;

public class ActivityQueries {

    public static final String ADD_ACTIVITY_QUERY = "INSERT INTO activity (name) VALUES (:name)";
    public static final String GET_ACTIVITY_BY_ID_QUERY = "SELECT * FROM activity WHERE ID = ?";
    public static final String GET_ALL_ACTIVITIES_QUERY = "SELECT * FROM activity";
    public static final String UPDATE_ACTIVITY_QUERY = "UPDATE activity SET name = :name WHERE id = :id";
}
