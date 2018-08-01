package com.github.nut077.petclinic.service;

import com.github.nut077.petclinic.entity.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
