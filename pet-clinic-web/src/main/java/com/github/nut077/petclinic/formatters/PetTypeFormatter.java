package com.github.nut077.petclinic.formatters;

import com.github.nut077.petclinic.entity.PetType;
import com.github.nut077.petclinic.service.jpa.PetTypeJpaService;
import lombok.AllArgsConstructor;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

@AllArgsConstructor
@Component
public class PetTypeFormatter implements Formatter<PetType> {

    private final PetTypeJpaService petTypeJpaService;

    @Override
    public PetType parse(String text, Locale locale) throws ParseException {
        Collection<PetType> findPetTypes = petTypeJpaService.findAll();
        for (PetType petType : findPetTypes) {
            if (petType.getName().equals(text)) {
                return petType;
            }
        }
        throw new ParseException("type not found: " + text, 0);
    }

    @Override
    public String print(PetType petType, Locale locale) {
        return petType.getName();
    }
}
