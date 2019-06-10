package com.example.constants.query;

public class AchievementQueries {

    public static final String ADD_ACHIEVEMENT_QUERY = "INSERT INTO ACHIEVEMENTS (name, description, date_created, date_updated, points, user_id) " +
            "VALUES (:name,:description,:date_created,:date_updated, :points, :user_id)";
    public static final String GET_ACHIEVEMENT_BY_ID_QUERY = "SELECT * FROM ACHIEVEMENTS WHERE ID = ?";
    public static final String GET_ALL_ACHIEVEMENTS_QUERY = "SELECT * FROM ACHIEVEMENTS";
    public static final String UPDATE_ACHIEVEMENT_QUERY = "UPDATE ACHIEVEMENTS SET name = :name, description = :description, " +
            "date_created = :date_created, date_updated = :date_updated, points = :points, user_id = :userId WHERE id = :id";
}
