package com.github.nut077.petclinic.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
public class Vet extends Person {
    private Set<Speciality> specialities = new LinkedHashSet<>();
}
