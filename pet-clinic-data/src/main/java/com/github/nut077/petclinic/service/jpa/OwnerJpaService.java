package com.github.nut077.petclinic.service.jpa;

import com.github.nut077.petclinic.entity.Owner;

public interface OwnerJpaService extends JpaService<Owner, Long> {
    Owner findByLastName(String lastName);
}