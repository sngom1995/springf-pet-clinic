package sn.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import sn.springframework.sfgpetclinic.model.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
