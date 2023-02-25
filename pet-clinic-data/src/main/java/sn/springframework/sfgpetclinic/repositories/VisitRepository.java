package sn.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import sn.springframework.sfgpetclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
