package sn.springframework.sfgpetclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sn.springframework.sfgpetclinic.model.Owner;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetServiceMap(), new PetTypeServiceMap());
        ownerServiceMap.save(Owner.builder().id(1L).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerServiceMap.findAll();
        assertEquals(1, ownerSet.size());
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(1L);
        assertEquals(1L, owner.getId());
    }

    @Test
    void save() {
        Owner owner2 = Owner.builder().id(2L).build();
        Owner savedOwner = ownerServiceMap.save(owner2);
        assertEquals(2L, savedOwner.getId());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(1L));
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(1L);
    }

    @Test
    void findByLastName() {
        Owner owner = ownerServiceMap.findByLastName("Smith");

        assertNull(owner);
    }
}