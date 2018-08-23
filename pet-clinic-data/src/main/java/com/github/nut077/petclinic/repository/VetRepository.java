package com.github.nut077.petclinic.repository;

import com.github.nut077.petclinic.entity.Vet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VetRepository extends JpaRepository<Vet, Long> {
}
