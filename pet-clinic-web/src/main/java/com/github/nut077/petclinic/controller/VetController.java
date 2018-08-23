package com.github.nut077.petclinic.controller;

import com.github.nut077.petclinic.service.jpa.VetJpaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor
@Controller
public class VetController {

    private VetJpaService vetJpaService;

    @GetMapping("/vets")
    public String vetList(Model model) {
        model.addAttribute("vets", vetJpaService.findAll());
        return "vets/index";
    }
}
