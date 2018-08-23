package com.github.nut077.petclinic.service.jpa.impl;

import com.github.nut077.petclinic.entity.Owner;
import com.github.nut077.petclinic.repository.OwnerRepository;
import com.github.nut077.petclinic.service.jpa.OwnerServiceJpa;
import com.github.nut077.petclinic.util.MessageErrorFindById;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class OwnerServiceJpaImpl implements OwnerServiceJpa {

    private OwnerRepository ownerRepository;

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public List<Owner> findAll() {
        return ownerRepository.findAll();
    }

    @Override
    public Owner findById(Long id) {
        Optional<Owner> owner = ownerRepository.findById(id);
        if (owner.isPresent()) {
            return owner.get();
        }
        MessageErrorFindById.print("Owner", id);
        return null;
    }

    @Override
    public Owner save(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public void delete(Owner owner) {
        ownerRepository.delete(owner);
    }

    @Override
    public void deleteById(Long id) {
        ownerRepository.deleteById(id);
    }
}
