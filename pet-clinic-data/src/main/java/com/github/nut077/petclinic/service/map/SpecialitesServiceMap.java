package com.github.nut077.petclinic.service.map;

import com.github.nut077.petclinic.entity.Speciality;
import com.github.nut077.petclinic.service.SpecialitesService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SpecialitesServiceMap extends AbstractMapService<Speciality, Long> implements SpecialitesService {
    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Speciality object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Speciality save(Speciality object) {
        return null;
    }

    @Override
    public Speciality findById(Long id) {
        return null;
    }
}
