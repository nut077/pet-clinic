package com.github.nut077.petclinic.repository;

import com.github.nut077.petclinic.entity.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
