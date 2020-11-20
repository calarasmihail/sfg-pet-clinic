package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.CrudService;
import java.util.Set;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements CrudService<Owner, Long> {

  @Override
  public Set<Owner> findAll() {   // Method 'findAll()' recurses infinitely, and can only end by
                                  // throwing an exception (because of this keyword). To fix,
                                  // use super keyword, instead of this keyword. Change everywhere.
    /*return this.findAll();*/
    return super.findAll();
  }

  @Override
  public Owner findById(Long id) {
    /*return this.findById(id);*/
    return super.findById(id);
  }

  @Override
  public Owner save(Owner object) {
    /*return this.save(object);*/
    return super.save(object.getId(), object);
  }

  @Override
  public void delete(Owner object) {
    /*this.delete(object);*/
    super.delete(object);
  }

  @Override
  public void deleteById(Long id) {
    /*this.deleteById(id);*/
    super.deleteById(id);
  }
}
