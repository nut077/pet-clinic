package com.github.nut077.petclinic.repository;

import com.github.nut077.petclinic.entity.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
