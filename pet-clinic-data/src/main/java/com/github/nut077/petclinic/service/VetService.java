package com.github.nut077.petclinic.service;

import com.github.nut077.petclinic.entity.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Long id);
    Vet save(Vet pet);
    Set<Vet> findAll();
}
