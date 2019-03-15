package com.savsh.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ByeController {

    @GetMapping("/bye")
    public String getBey() {
        return "bey";
    }

    @GetMapping("/bye-bey")
    public String getByeBye() {
        return "bye bye";
    }

}
