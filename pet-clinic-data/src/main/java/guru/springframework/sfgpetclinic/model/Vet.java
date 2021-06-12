package guru.springframework.sfgpetclinic.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vets")
public class Vet extends Person {

  // FetchType EAGER - What this means is, by default anything that's a many to many relationship,
  // is going to be lazily initialized. When we set it to eager, that means that JPA is
  // going to try to load everything all at once. By lazy initialization, which is the default,
  // it doesn't load until it it's asked for so you'll get back of that entity and the specialties
  // would be null if we did not do this. So now, we're going to set up a join table here.
  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "vet_specialties",
      joinColumns = @JoinColumn(name = "vet_id"),
      inverseJoinColumns = @JoinColumn(name = "speciality_id"))
  private Set<Speciality> specialities = new HashSet<>();

  public Set<Speciality> getSpecialities() {
    return specialities;
  }

  public void setSpecialities(
      Set<Speciality> specialities) {
    this.specialities = specialities;
  }
}
