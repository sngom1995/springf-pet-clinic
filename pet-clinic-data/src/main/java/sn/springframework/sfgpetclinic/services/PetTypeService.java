package sn.springframework.sfgpetclinic.services;

import org.springframework.stereotype.Service;
import sn.springframework.sfgpetclinic.model.PetType;


@Service
public interface PetTypeService extends CrudService<PetType, Long>{
}
