package sn.springframework.sfgpetclinic.bootstrap;

import org.hibernate.annotations.Comment;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sn.springframework.sfgpetclinic.model.Owner;
import sn.springframework.sfgpetclinic.model.Vet;
import sn.springframework.sfgpetclinic.services.OwnerService;
import sn.springframework.sfgpetclinic.services.VetService;
import sn.springframework.sfgpetclinic.services.map.OwnerServiceMap;
import sn.springframework.sfgpetclinic.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Samba");
        owner1.setLastName("Ngom");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Mamadou");
        owner2.setLastName("Sow");

        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Alassane");
        vet1.setLastName("Diouf");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Mamadou");
        vet2.setLastName("Sow");

        vetService.save(vet2);


    }
}
