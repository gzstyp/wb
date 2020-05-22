package com.fwtai.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class WebController{

    @GetMapping(value = {"index","/","page"})
    public ModelAndView page(){
        return new ModelAndView("websocket");
    }
}