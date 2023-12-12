package org.example.mvc.view;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ModelAndView {
    private String view;

    private Map<String,Object> map = new HashMap<>();
    public ModelAndView(String viewName) {
        this.view = viewName;
    }

    public Map<String,Object> getModel() {
        return Collections.unmodifiableMap(map);
    }

    public String getViewName() {
        return view;
    }
}
