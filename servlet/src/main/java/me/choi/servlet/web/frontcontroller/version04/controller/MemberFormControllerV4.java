package me.choi.servlet.web.frontcontroller.version04.controller;

import me.choi.servlet.web.frontcontroller.version04.ControllerV4;

import java.util.Map;

/**
 * Project : servlet
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 9:33 오후
 */
public class MemberFormControllerV4 implements ControllerV4 {

    @Override
    public String process(final Map<String, String> paramMap, final Map<String, Object> model) {
        return "new-form";
    }
}
