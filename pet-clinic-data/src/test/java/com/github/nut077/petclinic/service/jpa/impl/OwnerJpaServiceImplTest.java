package com.github.nut077.petclinic.service.jpa.impl;

import com.github.nut077.petclinic.entity.Owner;
import com.github.nut077.petclinic.repository.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerJpaServiceImplTest {

    @Mock
    private OwnerRepository ownerRepository;

    @InjectMocks
    private OwnerJpaServiceImpl service;

    private Long id = 1L;
    private String lastName = "Freedom";
    private Owner ownerReturn;

    @BeforeEach
    void setUp() {
        ownerReturn = Owner.builder().id(id).lastName(lastName).build();
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(ownerReturn);
        Owner owner = service.findByLastName(lastName);
        assertEquals(lastName, owner.getLastName());
        verify(ownerRepository).findByLastName(anyString());
    }

    @Test
    void findAll() {
        List<Owner> ownersReturn = new ArrayList<>();
        ownersReturn.add(Owner.builder().id(id).build());
        ownersReturn.add(Owner.builder().id(id).build());

        when(ownerRepository.findAll()).thenReturn(ownersReturn);

        List<Owner> owners = service.findAll();
        assertNotNull(owners);
        assertEquals(2, owners.size());

        verify(ownerRepository).findAll();
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.ofNullable(ownerReturn));
        Owner owner = service.findById(id);
        assertNotNull(owner);
        assertEquals(id, owner.getId());
        verify(ownerRepository).findById(anyLong());
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        Owner owner = service.findById(id);
        assertNull(owner);
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(id).build();
        when(ownerRepository.save(any())).thenReturn(ownerReturn);
        Owner owner = service.save(ownerToSave);
        assertNotNull(owner);
        assertEquals(id, owner.getId());
        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        service.delete(ownerReturn);
        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(id);
        verify(ownerRepository).deleteById(anyLong());
    }
}