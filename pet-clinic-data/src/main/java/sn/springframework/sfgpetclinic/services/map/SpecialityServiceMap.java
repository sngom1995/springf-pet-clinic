package sn.springframework.sfgpetclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sn.springframework.sfgpetclinic.model.Owner;
import sn.springframework.sfgpetclinic.model.Speciality;
import sn.springframework.sfgpetclinic.services.SpecialityService;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class SpecialityServiceMap extends AbstractMapService<Speciality, Long> implements SpecialityService {
    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Speciality object) {
        super.delete(object);
    }

    @Override
    public Speciality save(Speciality object) {
        return super.save(object);

    }

    @Override
    public Speciality findById(Long id) {
         super.findById(id);
        return null;
    }
}
