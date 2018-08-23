package com.github.nut077.petclinic.controller;

import com.github.nut077.petclinic.service.jpa.OwnerJpaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor
@Controller
public class OwnerController {

    private OwnerJpaService ownerJpaService;

    @GetMapping("/owners")
    public String ownerList(Model model) {
        model.addAttribute("owners", ownerJpaService.findAll());
        return "owners/index";
    }
}
