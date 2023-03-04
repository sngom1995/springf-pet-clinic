package sn.springframework.sfgpetclinic.services;

import org.springframework.stereotype.Service;
import sn.springframework.sfgpetclinic.model.Vet;

import java.util.Set;

@Service
public interface VetService extends CrudService<Vet, Long> {

}
