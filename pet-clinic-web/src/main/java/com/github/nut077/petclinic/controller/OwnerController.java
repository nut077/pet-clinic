package com.github.nut077.petclinic.controller;

import com.github.nut077.petclinic.service.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OwnerController {

    private OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping("/owners")
    public String ownerList(Model model) {
        model.addAttribute("owners", ownerService.findAll());
        return "owners/index";
    }
}
