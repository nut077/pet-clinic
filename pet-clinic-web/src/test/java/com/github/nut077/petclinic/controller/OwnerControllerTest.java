package com.github.nut077.petclinic.controller;

import com.github.nut077.petclinic.entity.Owner;
import com.github.nut077.petclinic.service.jpa.OwnerJpaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @Mock
    private OwnerJpaService service;

    @InjectMocks
    private OwnerController controller;

    private MockMvc mockMvc;

    private List<Owner> owners;


    @BeforeEach
    void setUp() {
        owners = new ArrayList<>();
        owners.add(Owner.builder().id(1L).build());
        owners.add(Owner.builder().id(2L).build());
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void ownerList() throws Exception {
        when(service.findAll()).thenReturn(owners);
        mockMvc.perform(get("/owners"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"))
                .andExpect(model().attributeExists("owners"))
                .andExpect(model().attribute("owners", hasSize(2)))
                .andReturn();

        verifyZeroInteractions(service);
    }

    @Test
    void showOwner() throws Exception {
        Long id = 1L;
        Owner owner = Owner.builder().id(id).build();
        when(service.findById(id)).thenReturn(owner);
        mockMvc.perform(get("/owners/" + id))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownerDetails"))
                .andExpect(model().attributeExists("owner"))
                .andReturn();
    }
}