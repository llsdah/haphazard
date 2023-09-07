package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class QueryStringsTest {

    @Test
    void create() {
        QueryStrings queryStrings = new QueryStrings("operand1=11&operator=*&operand2=1");
        assertThat(queryStrings).isNotNull();
    }
}
