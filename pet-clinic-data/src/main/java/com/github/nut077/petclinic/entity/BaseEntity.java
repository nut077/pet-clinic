package com.github.nut077.petclinic.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseEntity implements Serializable {
    private Long id;
}
