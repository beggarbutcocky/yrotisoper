package com.bovt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by beerman on 12.03.2017.
 */
@Controller
public class Index {

    @RequestMapping("/home")
    public String index(){
        return "home";
    }
}
