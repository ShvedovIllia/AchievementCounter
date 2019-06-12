package com.example.constants.query;

public class UserQueries {

    public static final String ADD_USER_QUERY = "INSERT INTO users (name, password, dateOfCreation, teamId) " +
            "VALUES (:name,:password,:dateOfCreation,:teamId)";
    public static final String GET_USER_BY_ID_QUERY = "SELECT * FROM USERS WHERE ID = ?";
    public static final String GET_ALL_USERS_QUERY = "SELECT * FROM USERS";
    public static final String UPDATE_USER_QUERY = "UPDATE users SET name = :name, password = :password, teamId = :teamId WHERE id = :id";
}