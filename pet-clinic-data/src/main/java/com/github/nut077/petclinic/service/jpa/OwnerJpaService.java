package com.github.nut077.petclinic.service.jpa;

import com.github.nut077.petclinic.entity.Owner;

import java.util.List;

public interface OwnerJpaService extends JpaService<Owner, Long> {
    Owner findByLastName(String lastName);
    List<Owner> findAllByLastNameLike(String lastName);
}
