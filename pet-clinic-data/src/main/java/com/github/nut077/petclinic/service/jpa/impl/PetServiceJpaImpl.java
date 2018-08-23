package com.github.nut077.petclinic.service.jpa.impl;

import com.github.nut077.petclinic.entity.Pet;
import com.github.nut077.petclinic.repository.PetRepository;
import com.github.nut077.petclinic.service.jpa.PetServiceJpa;
import com.github.nut077.petclinic.util.MessageErrorFindById;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PetServiceJpaImpl implements PetServiceJpa {

    private PetRepository petRepository;

    @Override
    public List<Pet> findAll() {
        return petRepository.findAll();
    }

    @Override
    public Pet findById(Long id) {
        Optional<Pet> pet = petRepository.findById(id);
        if (pet.isPresent()) {
            return pet.get();
        }
        MessageErrorFindById.print("Pet", id);
        return null;
    }

    @Override
    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public void delete(Pet pet) {
        petRepository.delete(pet);
    }

    @Override
    public void deleteById(Long id) {
        petRepository.deleteById(id);
    }
}
