package me.choi.servlet.web.frontcontroller;

import java.util.HashMap;
import java.util.Map;

/**
 * Project : servlet
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 11:00 오후
 */
public class ModelView {
    private final String viewName;
    private Map<String, Object> model = new HashMap<>();

    public ModelView(final String viewName) {
        this.viewName = viewName;
    }

    public String getViewName() {
        return viewName;
    }

    public Map<String, Object> getModel() {
        return model;
    }

    public void setModel(Map<String, Object> model) {
        this.model = model;
    }
}
