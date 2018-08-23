package com.github.nut077.petclinic.service.jpa.impl;

import com.github.nut077.petclinic.entity.Speciality;
import com.github.nut077.petclinic.repository.SpecialityRepository;
import com.github.nut077.petclinic.service.jpa.SpecialityServiceJpa;
import com.github.nut077.petclinic.util.MessageErrorFindById;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class SpecialityServiceJpaImpl implements SpecialityServiceJpa {

    private SpecialityRepository specialityRepository;

    @Override
    public List<Speciality> findAll() {
        return specialityRepository.findAll();
    }

    @Override
    public Speciality findById(Long id) {
        Optional<Speciality> speciality = specialityRepository.findById(id);
        if (speciality.isPresent()) {
            return speciality.get();
        }
        MessageErrorFindById.print("Speciality", id);
        return null;
    }

    @Override
    public Speciality save(Speciality speciality) {
        return specialityRepository.save(speciality);
    }

    @Override
    public void delete(Speciality speciality) {
        specialityRepository.delete(speciality);
    }

    @Override
    public void deleteById(Long id) {
        specialityRepository.deleteById(id);
    }
}
