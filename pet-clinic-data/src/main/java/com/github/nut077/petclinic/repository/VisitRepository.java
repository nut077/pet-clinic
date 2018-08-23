package com.github.nut077.petclinic.repository;

import com.github.nut077.petclinic.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepository extends JpaRepository<Visit, Long> {
}
