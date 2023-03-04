package sn.springframework.sfgpetclinic.services.springdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sn.springframework.sfgpetclinic.model.Owner;
import sn.springframework.sfgpetclinic.repositories.OwnerRepository;
import sn.springframework.sfgpetclinic.repositories.PetRepository;
import sn.springframework.sfgpetclinic.repositories.PetTypeRepository;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetTypeRepository petTypeRepository;
    @Mock
    PetRepository petRepository;

    Owner returnOwner;
    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(1L).build();

    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerSDJpaService.findAll();
        ownerSet.add(Owner.builder().id(1L).build());
        ownerSet.add(Owner.builder().id(2L).build());
        when(ownerRepository.findAll()).thenReturn(ownerSet);
        Set<Owner> owners = ownerSDJpaService.findAll();
        assertEquals(2, owners.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(any())).thenReturn(java.util.Optional.of(returnOwner));
        Owner owner = ownerSDJpaService.findById(1L);
        assertNotNull(owner);
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(1L).build();
        when(ownerRepository.save(any())).thenReturn(returnOwner);
        Owner savedOwner = ownerSDJpaService.save(ownerToSave);
        assertNotNull(savedOwner);
        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        ownerSDJpaService.delete(returnOwner);
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        ownerSDJpaService.deleteById(1L);
        verify(ownerRepository).deleteById(any());
    }

    @Test
    void findByLastName() {
        Owner ownerBuilder = Owner.builder().id(2L).lastName("Smith").build();
        when(ownerRepository.findByLastName(any())).thenReturn(ownerBuilder);
        Owner owner = ownerSDJpaService.findByLastName("Smith");
        assertEquals("Smith", owner.getLastName());
        verify(ownerRepository).findByLastName(any());
    }
}