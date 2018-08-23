package com.github.nut077.petclinic.repository;

import com.github.nut077.petclinic.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
}
