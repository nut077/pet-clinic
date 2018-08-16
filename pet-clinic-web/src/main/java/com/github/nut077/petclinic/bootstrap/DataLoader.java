package com.github.nut077.petclinic.bootstrap;

import com.github.nut077.petclinic.entity.Owner;
import com.github.nut077.petclinic.entity.Pet;
import com.github.nut077.petclinic.entity.PetType;
import com.github.nut077.petclinic.entity.Vet;
import com.github.nut077.petclinic.service.OwnerService;
import com.github.nut077.petclinic.service.PetTypeService;
import com.github.nut077.petclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) {
        PetType dog = new PetType();
        dog.setName("dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType saveCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("OwnerFirstName1");
        owner1.setLastName("OwnerLastName1");
        owner1.setAddress("237");
        owner1.setCity("Kanchanaburi");
        owner1.setTelephone("084-3344312");

        Pet fanta = new Pet();
        fanta.setName("Fanta");
        fanta.setPetType(saveDogPetType);
        fanta.setOwner(owner1);
        fanta.setBirthDate(LocalDate.now());
        owner1.getPets().add(fanta);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("OwnerFirstName2");
        owner2.setLastName("OwnerLastName2");
        owner2.setAddress("93");
        owner2.setCity("Bangkok");
        owner2.setTelephone("086-5411215");

        Pet fat = new Pet();
        fat.setName("Fat");
        fat.setPetType(saveCatPetType);
        fat.setOwner(owner2);
        fat.setBirthDate(LocalDate.now());
        owner2.getPets().add(fat);

        ownerService.save(owner2);
        System.out.println("Load Owner");

        Vet vet1 = new Vet();
        vet1.setFirstName("VetFirstName1");
        vet1.setLastName("VetLastName1");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("VetFirstName2");
        vet2.setLastName("VetLastName2");
        vetService.save(vet2);
        System.out.println("Load Vet");
    }
}
