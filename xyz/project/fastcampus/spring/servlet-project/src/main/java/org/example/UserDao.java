package org.example;

import java.sql.*;

public class UserDao {

    public void create(User user) throws SQLException{
        Connection con = null;
        PreparedStatement pstat = null;

        try{
            con = getConnection();
            String sql = "INSERT INTO USERS VALUES (?, ?, ?, ?)";
            pstat = con.prepareStatement(sql);
            pstat.setString(1,user.getUserId());
            pstat.setString(2,user.getPassword());
            pstat.setString(3,user.getName());
            pstat.setString(4,user.getEmail());
            pstat.executeUpdate();

        } finally {
            if(pstat != null){
                pstat.close();
            }
            if(con != null){
                con.close();
            }
        }

    }

    private Connection getConnection() {
        String url = "jdbc:h2:mem://localhost/~/jdbc-practice;MODE=MySQL;DB_CLOSE_DELAY=-1";
        String id = "sa";
        String password = "";

        try {
            Class.forName("org.h2.Driver");
            return DriverManager.getConnection(url, id, password);
        } catch (Exception exception){
            return null;
        }

    }

    public User findByUserIs(String wizard) throws Exception{
        Connection con = null;
        PreparedStatement pstat = null;
        ResultSet resultSet = null;
        try {
            con = getConnection();
            String sql = "SELECT userId, password, name, email FROM USERS WHERE userId = ?";
            pstat = con.prepareStatement(sql);
            pstat.setString(1,wizard);

            resultSet =  pstat.executeQuery();
            User user = null;
            if(resultSet.next()){
                user = new User(resultSet.getString("userId")
                ,resultSet.getString("password")
                ,resultSet.getString("name")
                ,resultSet.getString("email")
                );

            }

            return user;
        } finally {
            if(resultSet != null){
                resultSet.close();
            }
            if(pstat != null){
                pstat.close();
            }
            if(con != null){
                con.close();
            }
        }
    }
}
