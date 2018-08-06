package com.github.nut077.petclinic.bootstrap;

import com.github.nut077.petclinic.entity.Owner;
import com.github.nut077.petclinic.entity.Vet;
import com.github.nut077.petclinic.service.OwnerService;
import com.github.nut077.petclinic.service.VetService;
import com.github.nut077.petclinic.service.map.OwnerServiceMap;
import com.github.nut077.petclinic.service.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("OwnerFirstName1");
        owner1.setLastName("OwnerLastName1");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("OwnerFirstName2");
        owner2.setLastName("OwnerLastName2");
        ownerService.save(owner2);
        System.out.println("Load Owner");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("VetFirstName1");
        vet1.setLastName("VetLastName1");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("VetFirstName2");
        vet2.setLastName("VetLastName2");
        vetService.save(vet2);
        System.out.println("Load Vet");
    }
}
