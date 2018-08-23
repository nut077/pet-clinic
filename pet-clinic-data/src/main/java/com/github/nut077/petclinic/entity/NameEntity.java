package com.github.nut077.petclinic.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public class NameEntity extends BaseEntity {
    private String name;
}
