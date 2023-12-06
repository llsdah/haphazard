package org.example;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 라이브러리 입니다.
 */
public class JDBCTemplete {

    public void executeUpdate(User user,String sql, PreparedStatementSetter pss) throws SQLException {
        Connection con = null;
        PreparedStatement pstat = null;

        try{
            con = ConnecionManager.getConnection();
            pstat = con.prepareStatement(sql);
            pss.setter(pstat);
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



    public Object executeQuery(String wizard, String sql, PreparedStatementSetter pss, RawMapper rm) throws Exception{
        Connection con = null;
        PreparedStatement pstat = null;
        ResultSet resultSet = null;
        try {
            con = ConnecionManager.getConnection();
            pstat = con.prepareStatement(sql);
            pss.setter(pstat);

            resultSet =  pstat.executeQuery();

            Object obj = null;
            if(resultSet.next()){
                return rm.mapper(resultSet);
            }
            return obj;
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
