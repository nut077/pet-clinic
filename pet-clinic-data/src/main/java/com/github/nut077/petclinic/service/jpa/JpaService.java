package com.github.nut077.petclinic.service.jpa;

import java.util.List;

public interface JpaService<T, ID> {
    List<T> findAll();
    T findById(ID id);
    T save(T object);
    void delete(T object);
    void deleteById(ID id);
}
