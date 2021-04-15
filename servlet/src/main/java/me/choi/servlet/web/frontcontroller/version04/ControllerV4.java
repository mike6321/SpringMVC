package me.choi.servlet.web.frontcontroller.version04;

import java.util.Map;

/**
 * Project : servlet
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 11:12 오후
 */
public interface ControllerV4 {

    /**
     *
     * @param paramMap
     * @param model
     * @return viewName
     */
    String process(final Map<String, String> paramMap, final Map<String, Object> model);
}
