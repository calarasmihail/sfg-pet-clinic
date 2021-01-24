package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
import java.time.LocalDate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

  private final OwnerService ownerService;
  private final VetService vetService;
  private final PetTypeService petTypeService;

  public DataLoader(OwnerService ownerService,
      VetService vetService, PetTypeService petTypeService) {
    this.ownerService = ownerService;
    this.vetService = vetService;
    this.petTypeService = petTypeService;
  }

  @Override
  public void run(String... args) throws Exception {

    PetType dog = new PetType();
    dog.setName("Dog");
    PetType savedDogPetType = petTypeService.save(dog);

    PetType cat = new PetType();
    cat.setName("Cat");
    PetType savedCatPetType = petTypeService.save(cat);

    Owner owner1 = new Owner();
    owner1.setFirstName("Josh");
    owner1.setLastName("Remember");
    owner1.setAddress("Strada Columna 4");
    owner1.setCity("Chisinau");
    owner1.setTelephone("069337788");

    Pet mikesPet = new Pet();
    mikesPet.setPetType(savedDogPetType);
    mikesPet.setOwner(owner1);
    mikesPet.setBirthDate(LocalDate.now());
    mikesPet.setName("Joe");
    owner1.getPets().add(mikesPet);


    ownerService.save(owner1);

    Owner owner2 = new Owner();
    owner2.setFirstName("Michael");
    owner2.setLastName("Frost");
    owner2.setAddress("Strada Armeneasca 4");
    owner2.setCity("Chisinau");
    owner2.setTelephone("069446699");

    Pet michaelsCat = new Pet();
    michaelsCat.setName("Kitty");
    michaelsCat.setOwner(owner2);
    michaelsCat.setBirthDate(LocalDate.now());
    michaelsCat.setPetType(savedCatPetType);
    owner2.getPets().add(michaelsCat);

    ownerService.save(owner2);

    System.out.println("Loaded Owners...");

    Vet vet1 = new Vet();
    vet1.setFirstName("Ion");
    vet1.setLastName("Voltaire");
    vetService.save(vet1);

    Vet vet2 = new Vet();
    vet2.setFirstName("Jack");
    vet2.setLastName("Dream");
    vetService.save(vet2);

    System.out.println("Loaded Vets...");

  }
}
