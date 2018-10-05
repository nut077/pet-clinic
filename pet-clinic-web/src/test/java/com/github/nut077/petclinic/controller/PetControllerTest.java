package com.github.nut077.petclinic.controller;

import com.github.nut077.petclinic.entity.Owner;
import com.github.nut077.petclinic.entity.Pet;
import com.github.nut077.petclinic.entity.PetType;
import com.github.nut077.petclinic.service.jpa.OwnerJpaService;
import com.github.nut077.petclinic.service.jpa.PetJpaService;
import com.github.nut077.petclinic.service.jpa.PetTypeJpaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class PetControllerTest {

    @Mock
    PetJpaService petJpaService;
    @Mock
    PetTypeJpaService petTypeJpaService;
    @Mock
    OwnerJpaService ownerJpaService;

    @InjectMocks
    PetController petController;

    private MockMvc mockMvc;
    private Owner owner;
    private List<PetType> petTypes;
    private Long id = 1L;

    @BeforeEach
    void setUp() {
        owner = Owner.builder().id(id).build();
        petTypes = new ArrayList<>();
        petTypes.add(PetType.builder().id(1L).name("Dog").build());
        petTypes.add(PetType.builder().id(2L).name("Cat").build());

        mockMvc = MockMvcBuilders.standaloneSetup(petController).build();
    }

    @Test
    void initCreationForm() throws Exception {
        when(ownerJpaService.findById(anyLong())).thenReturn(owner);
        when(petTypeJpaService.findAll()).thenReturn(petTypes);

        mockMvc.perform(get("/owners/" + id + "/pets/new"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("owner"))
                .andExpect(model().attributeExists("pet"))
                .andExpect(view().name("pets/createOrUpdatePetForm"));
    }

    @Test
    void processCreationForm() throws Exception {
        when(ownerJpaService.findById(anyLong())).thenReturn(owner);
        when(petTypeJpaService.findAll()).thenReturn(petTypes);

        mockMvc.perform(post("/owners/" + id + "/pets/new"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/" + id));

        verify(petJpaService).save(any());
    }

    @Test
    void initUpdateForm() throws Exception {
        when(ownerJpaService.findById(anyLong())).thenReturn(owner);
        when(petTypeJpaService.findAll()).thenReturn(petTypes);
        when(petJpaService.findById(anyLong())).thenReturn(Pet.builder().id(id).build());

        mockMvc.perform(get("/owners/" + id + "/pets/" + id + "/edit"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("owner"))
                .andExpect(model().attributeExists("pet"))
                .andExpect(view().name("pets/createOrUpdatePetForm"));
    }

    @Test
    void processUpdateForm() throws Exception {
        when(ownerJpaService.findById(anyLong())).thenReturn(owner);
        when(petTypeJpaService.findAll()).thenReturn(petTypes);

        mockMvc.perform(post("/owners/" + id + "/pets/" + id + "/edit"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/" + id));
    }
}