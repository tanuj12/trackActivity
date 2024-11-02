package com.trackApplication.TrackApplication.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
public class RootController {
    
    @RequestMapping("/")
    public String rootPage() {
        return "Hellow";
    }
    
}
