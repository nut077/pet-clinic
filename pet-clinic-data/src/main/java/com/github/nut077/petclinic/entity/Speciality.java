package com.github.nut077.petclinic.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class Speciality extends BaseEntity {
    private String description;
}
