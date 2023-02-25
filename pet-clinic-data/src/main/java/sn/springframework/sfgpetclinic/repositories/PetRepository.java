package sn.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import sn.springframework.sfgpetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
