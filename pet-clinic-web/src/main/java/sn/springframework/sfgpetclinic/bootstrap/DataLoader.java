package sn.springframework.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sn.springframework.sfgpetclinic.model.Owner;
import sn.springframework.sfgpetclinic.model.Pet;
import sn.springframework.sfgpetclinic.model.PetType;
import sn.springframework.sfgpetclinic.model.Vet;
import sn.springframework.sfgpetclinic.services.OwnerService;
import sn.springframework.sfgpetclinic.services.PetTypeService;
import sn.springframework.sfgpetclinic.services.VetService;

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
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(dog);

        Owner owner1 = new Owner();

        owner1.setFirstName("Samba");
        owner1.setLastName("Ngom");
        owner1.setAddress("Rue 2");
        owner1.setCity("AIBD");
        owner1.setTelephone("777775565");

        Pet sambaPet = new Pet();
        sambaPet.setPetType(savedDogPetType);
        sambaPet.setOwner(owner1);
        sambaPet.setBirthDate(LocalDate.now());
        sambaPet.setName("Rosco");
        owner1.getPets().add(sambaPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Mamadou");
        owner2.setLastName("Sow");
        owner2.setAddress("Rue 1");
        owner2.setCity("Dakar");
        owner2.setTelephone("777777777");

        Pet mamadouPet = new Pet();
        mamadouPet.setPetType(savedCatPetType);
        mamadouPet.setOwner(owner2);
        mamadouPet.setBirthDate(LocalDate.now());
        mamadouPet.setName("Risco");
        owner2.getPets().add(mamadouPet);

        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setFirstName("Alassane");
        vet1.setLastName("Diouf");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Mamadou");
        vet2.setLastName("Sow");

        vetService.save(vet2);


    }
}
