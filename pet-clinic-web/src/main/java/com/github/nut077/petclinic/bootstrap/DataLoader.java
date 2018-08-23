package com.github.nut077.petclinic.bootstrap;

import com.github.nut077.petclinic.entity.*;
import com.github.nut077.petclinic.service.jpa.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@AllArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerJpaService ownerJpaService;
    private final VetJpaService vetJpaService;
    private final PetTypeJpaService petTypeJpaService;
    private final SpecialityJpaService specialityJpaService;
    private final VisitJpaService visitJpaService;

    @Override
    public void run(String... args) {
        if (petTypeJpaService.findAll().size() == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogPetType = petTypeJpaService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCatPetType = petTypeJpaService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("radiology");
        Speciality savedRadiology = specialityJpaService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("surgery");
        Speciality savedSurgery = specialityJpaService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        Speciality savedDentistry = specialityJpaService.save(dentistry);

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
        ownerJpaService.save(owner1);

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

        ownerJpaService.save(owner2);

        Visit visit = new Visit();
        visit.setDate(LocalDate.now());
        visit.setDescription("visit");
        visit.setPet(leo);
        visitJpaService.save(visit);

        System.out.println("Load Owner");

        Vet vet1 = new Vet();
        vet1.setFirstName("James");
        vet1.setLastName("Carter");
        vet1.getSpecialities().add(savedRadiology);
        vetJpaService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Helen");
        vet2.setLastName("Leary");
        vet2.getSpecialities().add(savedRadiology);
        vet2.getSpecialities().add(savedSurgery);
        vetJpaService.save(vet2);

        Vet vet3 = new Vet();
        vet3.setFirstName("Linda");
        vet3.setLastName("Douglas");
        vet3.getSpecialities().add(savedDentistry);
        vetJpaService.save(vet3);

        System.out.println("Load Vet");
    }
}
