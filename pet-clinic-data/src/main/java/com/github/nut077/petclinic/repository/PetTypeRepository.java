package com.github.nut077.petclinic.repository;

import com.github.nut077.petclinic.entity.PetType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetTypeRepository extends JpaRepository<PetType, Long> {
}
