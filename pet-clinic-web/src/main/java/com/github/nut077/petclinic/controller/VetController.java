package com.github.nut077.petclinic.controller;

import com.github.nut077.petclinic.service.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VetController {

    private VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @GetMapping("/vets")
    public String vetList(Model model) {
        model.addAttribute("vets", vetService.findAll());
        return "vets/index";
    }
}
