package guru.springframework.sfgpetclinic.services.map;

import static org.junit.jupiter.api.Assertions.*;

import guru.springframework.sfgpetclinic.model.Owner;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OwnerMapServiceTest {

  OwnerMapService ownerMapService;
  final Long ownerId = 1L;
  final String lastName = "John";

  @BeforeEach
  void setUp() {
    ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
    ownerMapService.save(Owner.builder().id(ownerId).lastName(lastName).build());
  }

  @Test
  void findAll() {
    Set<Owner> ownerSet = ownerMapService.findAll();
    assertEquals(ownerId, ownerSet.size());
  }

  @Test
  void findById() {
    Owner owner = ownerMapService.findById(ownerId);
    assertEquals(ownerId, owner.getId());
  }

  @Test
  void saveExistingId() {
    long id = 2L;
    Owner owner2 = Owner.builder().id(id).build();
    Owner savedOwner = ownerMapService.save(owner2);
    assertEquals(id, savedOwner.getId());
  }

  @Test
  void saveNoId() {
    Owner savedOwner = ownerMapService.save(Owner.builder().build());
    assertNotNull(savedOwner);
    assertNotNull(savedOwner.getId());
  }

  @Test
  void delete() {
    ownerMapService.delete(ownerMapService.findById(ownerId));
    assertEquals(0, ownerMapService.findAll().size());
  }

  @Test
  void deleteById() {
    ownerMapService.deleteById(ownerId);
    assertEquals(0, ownerMapService.findAll().size());
  }

  @Test
  void findByLastName() {
    Owner owner4 = ownerMapService.findByLastName(lastName);
    assertNotNull(owner4);
    assertEquals(ownerId, owner4.getId());
  }

  @Test
  void findByLastNameNotFound() {
    Owner owner4 = ownerMapService.findByLastName("socket");
    assertNull(owner4);
  }
}