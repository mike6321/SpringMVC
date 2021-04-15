package me.choi.servlet.web.frontcontroller.version03;

import me.choi.servlet.web.frontcontroller.ModelView;

import java.util.Map;

/**
 * Project : servlet
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 9:31 오후
 */
public interface ControllerV3 {

    ModelView process(final Map<String, String> paramMap);

}
