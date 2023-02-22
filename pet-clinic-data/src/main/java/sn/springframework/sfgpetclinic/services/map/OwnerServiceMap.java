package sn.springframework.sfgpetclinic.services.map;

import org.springframework.stereotype.Service;
import sn.springframework.sfgpetclinic.model.Owner;
import sn.springframework.sfgpetclinic.model.Pet;
import sn.springframework.sfgpetclinic.services.OwnerService;

import java.util.Set;

@Service
public class OwnerServiceMap  extends AbstractMapService<Owner, Long>  implements OwnerService {

    private final PetServiceMap petServiceMap;
    private final PetTypeServiceMap petTypeServiceMap;

    public OwnerServiceMap(PetServiceMap petServiceMap, PetTypeServiceMap petTypeServiceMap) {
        this.petServiceMap = petServiceMap;
        this.petTypeServiceMap = petTypeServiceMap;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        if(object != null){
            if(object.getPets() != null){
                object.getPets().forEach(pet -> {
                    if(pet.getPetType() != null){
                        if(pet.getPetType().getId() == null){
                            pet.setPetType(petTypeServiceMap.save(pet.getPetType()));
                        }
                    }else{
                        throw new RuntimeException("Pet Type is required");
                    }

                    if(pet.getId() == null){
                        Pet savedPet = petServiceMap.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(object);
        }else{
            return null;
        }
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
