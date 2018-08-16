package com.github.nut077.petclinic.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Visit extends BaseEntity {
    private LocalDate date;
    private String description;
    private Pet pet;
}
