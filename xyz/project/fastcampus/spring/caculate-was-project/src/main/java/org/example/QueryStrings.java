package org.example;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueryStrings {
    private final List<QueryString> queryStrings = new ArrayList<>();

    public QueryStrings(String queryStringLine) {
        String[] queryStringTokens = queryStringLine.split("&");
        Arrays.stream(queryStringTokens)
                .forEach(queryString -> {
                    String[] values = queryString.split("=");
                    if(values.length !=2){
                        throw new IllegalArgumentException("잘못된 QueryString을 가진 문자열 입니다. ");
                    }

                    queryStrings.add(new QueryString(values[0], values[1]));
                });
    }
}
