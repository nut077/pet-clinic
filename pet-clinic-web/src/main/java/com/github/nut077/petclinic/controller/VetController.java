package com.github.nut077.petclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VetController {

    @GetMapping("/vets")
    public String index() {
        return "vets/index";
    }
}
