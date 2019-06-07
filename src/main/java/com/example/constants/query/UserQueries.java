package com.example.constants.query;

public class UserQueries {

    public static final String ADD_USER_QUERY = "INSERT INTO achievement_counter.users (id, name, password, dateOfCreation, teamId) " +
            "VALUES ((:id),(:name),(),?,?)";
    public static final String GET_USER_BY_ID_QUERY = "SELECT * FROM USERS WHERE ID = ?";
    public static final String GET_ALL_USERS_QUERY = "SELECT * FROM USERS";
    public static final String TEST = "INSERT INTO achievement_counter.users (id, name, password, dateOfCreation, teamId) " +
            "VALUES (2, 2, 2, '2019-06-07', 1)";
}