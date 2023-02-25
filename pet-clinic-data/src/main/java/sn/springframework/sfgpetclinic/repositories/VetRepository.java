package sn.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import sn.springframework.sfgpetclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
