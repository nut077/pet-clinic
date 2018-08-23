package com.github.nut077.petclinic.repository;

import com.github.nut077.petclinic.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
    Owner findByLastName(String lastName);
}
