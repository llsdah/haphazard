package org.example;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface PreparedStatementSetter {
    public void setter(PreparedStatement pstat) throws SQLException;
}
