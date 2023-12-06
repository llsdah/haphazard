package org.example;

import java.sql.ResultSet;

public interface RawMapper {
    Object mapper(ResultSet resultSet) throws Exception;
}
