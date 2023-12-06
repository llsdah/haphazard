package org.example;

import java.sql.*;

public class UserDao {

    public void create(User user) throws SQLException {
        JDBCTemplete jdbcTemplete = new JDBCTemplete();
        String sql = "INSERT INTO USERS VALUES (?, ?, ?, ?)";

        jdbcTemplete.executeUpdate(user, sql, pstat -> {
            pstat.setString(1,user.getUserId());
            pstat.setString(2,user.getPassword());
            pstat.setString(3,user.getName());
            pstat.setString(4,user.getEmail());
        });

    }

    public User findByUserIs(String userId) throws Exception {
        JDBCTemplete jdbcTemplete = new JDBCTemplete();
        String sql = "SELECT userId, password, name, email FROM USERS WHERE userId = ?";

        return (User) jdbcTemplete.executeQuery(userId, sql,
                pstat -> pstat.setString(1, userId),
                resultSet -> new User(resultSet.getString("userId")
                        ,resultSet.getString("password")
                        ,resultSet.getString("name")
                        ,resultSet.getString("email")
                ));

    }
}
