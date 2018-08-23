package com.github.nut077.petclinic.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageErrorFindById {
    public static void print(String name, Long id) {
        log.info("Find " + name + " by id : '" + id + "' -->> is null");
    }
}
