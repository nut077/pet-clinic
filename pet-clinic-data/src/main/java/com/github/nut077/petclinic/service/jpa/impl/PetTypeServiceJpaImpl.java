package com.github.nut077.petclinic.service.jpa.impl;

import com.github.nut077.petclinic.entity.PetType;
import com.github.nut077.petclinic.repository.PetTypeRepository;
import com.github.nut077.petclinic.service.jpa.PetTypeServiceJpa;
import com.github.nut077.petclinic.util.MessageErrorFindById;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PetTypeServiceJpaImpl implements PetTypeServiceJpa {

    private PetTypeRepository petTypeRepository;

    @Override
    public List<PetType> findAll() {
        return petTypeRepository.findAll();
    }

    @Override
    public PetType findById(Long id) {
        Optional<PetType> petType = petTypeRepository.findById(id);
        if (petType.isPresent()) {
            return petType.get();
        }
        MessageErrorFindById.print("PetType", id);
        return null;
    }

    @Override
    public PetType save(PetType petType) {
        return petTypeRepository.save(petType);
    }

    @Override
    public void delete(PetType petType) {
        petTypeRepository.delete(petType);
    }

    @Override
    public void deleteById(Long id) {
        petTypeRepository.deleteById(id);
    }
}
