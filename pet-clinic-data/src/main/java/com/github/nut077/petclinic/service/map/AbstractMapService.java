package com.github.nut077.petclinic.service.map;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService<T, ID> {
    Map<ID, T> map = new LinkedHashMap<>();

    Set<T> findAll() {
        return new LinkedHashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(ID id, T object) {
        map.put(id, object);
        return object;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T object) {
        map.entrySet().removeIf(obj -> obj.getValue().equals(object));
    }
}
