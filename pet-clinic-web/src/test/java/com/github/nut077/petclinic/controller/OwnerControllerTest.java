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
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @Mock
    private OwnerJpaService service;

    @InjectMocks
    private OwnerController controller;

    private MockMvc mockMvc;

    private List<Owner> owners;
    private Long id = 1L;

    @BeforeEach
    void setUp() {
        owners = new ArrayList<>();
        owners.add(Owner.builder().id(1L).build());
        owners.add(Owner.builder().id(2L).build());
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void findOwners() throws Exception {
        mockMvc.perform(get("/owners/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/findOwners"))
                .andExpect(model().attributeExists("owner"));

        verifyZeroInteractions(service);
    }

    @Test
    void showOwner() throws Exception {
        Owner owner = Owner.builder().id(id).build();
        when(service.findById(id)).thenReturn(owner);
        mockMvc.perform(get("/owners/" + id))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownerDetails"))
                .andExpect(model().attributeExists("owner"))
                .andReturn();
    }

    @Test
    void processFindFormReturnOne() throws Exception {
        when(service.findAllByLastNameLike(anyString())).thenReturn(Collections.singletonList(Owner.builder().id(id).build()));
        mockMvc.perform(get("/owners"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/" + id));
    }

    @Test
    void displayOwner() throws Exception {
        when(service.findById(anyLong())).thenReturn(Owner.builder().id(id).build());
        mockMvc.perform(get("/owners/" + id))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownerDetails"))
                .andExpect(model().attributeExists("owner"))
                .andExpect(model().attribute("owner", hasProperty("id", is(id))));
    }

    @Test
    void initCreationForm() throws Exception {
        mockMvc.perform(get("/owners/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/createOrUpdateOwnerForm"))
                .andExpect(model().attributeExists("owner"));
        verifyZeroInteractions(service);
    }

    @Test
    void processCreationForm() throws Exception {
        when(service.save(any())).thenReturn(Owner.builder().id(id).build());
        mockMvc.perform(post("/owners/new"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/" + id))
                .andExpect(model().attributeExists("owner"));
        verify(service).save(any());
    }

    @Test
    void initUpdateOwnerForm() throws Exception {
        when(service.findById(anyLong())).thenReturn(Owner.builder().id(id).build());
        mockMvc.perform(get("/owners/" + id + "/edit"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/createOrUpdateOwnerForm"))
                .andExpect(model().attributeExists("owner"));
        verifyZeroInteractions(service);
    }

    @Test
    void processUpdateOwnerForm() throws Exception {
        when(service.save(any())).thenReturn(Owner.builder().id(id).build());
        mockMvc.perform(post("/owners/" + id + "/edit"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/" + id))
                .andExpect(model().attributeExists("owner"));
        verify(service).save(any());
    }
}