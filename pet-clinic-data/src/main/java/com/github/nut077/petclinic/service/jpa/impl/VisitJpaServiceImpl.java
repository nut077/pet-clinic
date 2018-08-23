package com.github.nut077.petclinic.service.jpa.impl;

import com.github.nut077.petclinic.entity.Visit;
import com.github.nut077.petclinic.repository.VisitRepository;
import com.github.nut077.petclinic.service.jpa.VisitJpaService;
import com.github.nut077.petclinic.util.MessageErrorFindById;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class VisitJpaServiceImpl implements VisitJpaService {

    private VisitRepository visitRepository;

    @Override
    public List<Visit> findAll() {
        return visitRepository.findAll();
    }

    @Override
    public Visit findById(Long id) {
        Optional<Visit> visit = visitRepository.findById(id);
        if (visit.isPresent()) {
            return visit.get();
        }
        MessageErrorFindById.print("Visit", id);
        return null;
    }

    @Override
    public Visit save(Visit visit) {
        return visitRepository.save(visit);
    }

    @Override
    public void delete(Visit visit) {
        visitRepository.delete(visit);
    }

    @Override
    public void deleteById(Long id) {
        visitRepository.deleteById(id);
    }
}
