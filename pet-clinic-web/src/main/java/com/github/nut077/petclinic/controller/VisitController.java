package com.github.nut077.petclinic.controller;

import com.github.nut077.petclinic.entity.Pet;
import com.github.nut077.petclinic.entity.Visit;
import com.github.nut077.petclinic.service.jpa.PetJpaService;
import com.github.nut077.petclinic.service.jpa.VisitJpaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@AllArgsConstructor
@Controller
public class VisitController {
    private final VisitJpaService visitJpaService;
    private final PetJpaService petJpaService;
    private static final String VIEWS_VISIT_CREATE_OR_UPDATE_FORM = "pets/createOrUpdateVisitForm";

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @ModelAttribute("visit")
    public Visit loadPetWithVisit(@PathVariable Long petId, Map<String, Object> model) {
        Pet pet = petJpaService.findById(petId);
        Visit visit = Visit.builder().pet(pet).build();
        pet.getVisits().add(visit);
        model.put("pet", pet);
        return visit;
    }

    @GetMapping("/owners/{ownerId}/pets/{petId}/visits/new")
    public String initNewVisitForm(@PathVariable Long petId, Map<String, Object> model) {
        return VIEWS_VISIT_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/owners/{ownerId}/pets/{petId}/visit/new")
    public String processNewVisitForm(@Valid Visit visit, BindingResult result) {
        if (result.hasErrors()) {
            return VIEWS_VISIT_CREATE_OR_UPDATE_FORM;
        } else {
            visitJpaService.save(visit);
            return "redirect:/owners/{ownerId}";
        }
    }
}
