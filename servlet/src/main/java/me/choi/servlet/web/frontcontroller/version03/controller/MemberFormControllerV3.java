package me.choi.servlet.web.frontcontroller.version03.controller;

import me.choi.servlet.web.frontcontroller.ModelView;
import me.choi.servlet.web.frontcontroller.version03.ControllerV3;

import java.util.Map;

/**
 * Project : servlet
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 9:33 오후
 */
public class MemberFormControllerV3 implements ControllerV3 {

    @Override
    public ModelView process(final Map<String, String> paramMap) {
        return new ModelView("new-form");
    }
}
