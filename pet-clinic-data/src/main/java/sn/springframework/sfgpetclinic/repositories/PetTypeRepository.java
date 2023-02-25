package sn.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import sn.springframework.sfgpetclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
