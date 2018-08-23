package com.github.nut077.petclinic.service.jpa.impl;

import com.github.nut077.petclinic.entity.Vet;
import com.github.nut077.petclinic.repository.VetRepository;
import com.github.nut077.petclinic.service.jpa.VetJpaService;
import com.github.nut077.petclinic.util.MessageErrorFindById;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class VetJpaServiceImpl implements VetJpaService {

    private VetRepository vetRepository;

    @Override
    public List<Vet> findAll() {
        return vetRepository.findAll();
    }

    @Override
    public Vet findById(Long id) {
        Optional<Vet> vet = vetRepository.findById(id);
        if (vet.isPresent()) {
            return vet.get();
        }
        MessageErrorFindById.print("Vet", id);
        return null;
    }

    @Override
    public Vet save(Vet vet) {
        return vetRepository.save(vet);
    }

    @Override
    public void delete(Vet vet) {
        vetRepository.delete(vet);
    }

    @Override
    public void deleteById(Long id) {
        vetRepository.deleteById(id);
    }
}
