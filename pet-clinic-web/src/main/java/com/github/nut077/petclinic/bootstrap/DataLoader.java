package com.github.nut077.petclinic.bootstrap;

import com.github.nut077.petclinic.entity.*;
import com.github.nut077.petclinic.service.OwnerService;
import com.github.nut077.petclinic.service.PetTypeService;
import com.github.nut077.petclinic.service.SpecialityService;
import com.github.nut077.petclinic.service.VetService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@AllArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    @Override
    public void run(String... args) {
        if (petTypeService.findAll().size() == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("George");
        owner1.setLastName("Franklin");
        owner1.setAddress("237");
        owner1.setCity("Kanchanaburi");
        owner1.setTelephone("084-3344312");

        Pet fanta = new Pet();
        fanta.setName("Fanta");
        fanta.setPetType(savedDogPetType);
        fanta.setOwner(owner1);
        fanta.setBirthDate(LocalDate.now());
        owner1.getPets().add(fanta);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Betty");
        owner2.setLastName("Davis");
        owner2.setAddress("93");
        owner2.setCity("Bangkok");
        owner2.setTelephone("086-5411215");

        Pet leo = new Pet();
        leo.setName("Leo");
        leo.setPetType(savedCatPetType);
        leo.setOwner(owner2);
        leo.setBirthDate(LocalDate.now());
        owner2.getPets().add(leo);

        ownerService.save(owner2);
        System.out.println("Load Owner");

        Vet vet1 = new Vet();
        vet1.setFirstName("James");
        vet1.setLastName("Carter");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Helen");
        vet2.setLastName("Leary");
        vet2.getSpecialities().add(savedSurgery);
        vetService.save(vet2);

        Vet vet3 = new Vet();
        vet3.setFirstName("Linda");
        vet3.setLastName("Douglas");
        vet3.getSpecialities().add(savedDentistry);
        vetService.save(vet3);

        System.out.println("Load Vet");
    }
}
