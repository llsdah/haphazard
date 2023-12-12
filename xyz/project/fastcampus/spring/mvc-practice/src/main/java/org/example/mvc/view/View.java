package org.example.mvc.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

public interface View {
    void rander(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception;
}
