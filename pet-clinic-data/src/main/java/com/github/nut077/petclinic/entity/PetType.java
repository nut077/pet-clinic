package com.github.nut077.petclinic.entity;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@NoArgsConstructor
@Entity
public class PetType extends NameEntity {
    @Builder
    public PetType(Long id, String name) {
        super(id, name);
    }
}
