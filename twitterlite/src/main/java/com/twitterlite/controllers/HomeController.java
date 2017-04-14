package com.twitterlite.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by GUILONG'S PC on 4/14/2017.
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String home(){
        return "home";
    }
}
