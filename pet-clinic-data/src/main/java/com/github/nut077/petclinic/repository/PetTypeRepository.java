package com.github.nut077.petclinic.repository;

import com.github.nut077.petclinic.entity.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
