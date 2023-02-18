package sn.springframework.sfgpetclinic.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sn.springframework.sfgpetclinic.model.Owner;
import sn.springframework.sfgpetclinic.model.Vet;
import sn.springframework.sfgpetclinic.services.OwnerService;
import sn.springframework.sfgpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("Samba");
        owner1.setLastName("Ngom");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Mamadou");
        owner2.setLastName("Sow");

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
