package com.github.nut077.petclinic.repository;

import com.github.nut077.petclinic.entity.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialityRepository extends JpaRepository<Speciality, Long> {
}
