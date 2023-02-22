package sn.springframework.sfgpetclinic.services.map;

import org.springframework.stereotype.Service;
import sn.springframework.sfgpetclinic.model.Speciality;
import sn.springframework.sfgpetclinic.model.Vet;
import sn.springframework.sfgpetclinic.services.VetService;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
        private final SpecialityServiceMap specialityService;

    public VetServiceMap(SpecialityServiceMap specialityService) {
        this.specialityService = specialityService;
    }

    @Override
        public Set<Vet> findAll() {
            return super.findAll();
        }

        @Override
        public Vet findById(Long id) {
            return super.findById(id);
        }

        @Override
        public Vet save(Vet object) {

            if (object.getSpecialities().size() > 0) {
                object.getSpecialities().forEach(speciality -> {
                    if (speciality.getId() == null) {
                        Speciality savedSpeciality = specialityService.save(speciality);
                        speciality.setId(savedSpeciality.getId());
                    }
                });
            }
            return super.save(object);
        }

        @Override
        public void delete(Vet object) {
            super.delete(object);
        }

        @Override
        public void deleteById(Long id) {
            super.deleteById(id);
        }
}
