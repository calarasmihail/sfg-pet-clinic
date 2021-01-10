package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.BaseEntity;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

  protected Map<Long, T> map = new HashMap<>();

  Set<T> findAll() {                         // findAll() is just going to return back a new
                                             // HashSet of the values.
    return new HashSet<>(map.values());
  }

  // We also have findById which is going to return back the Type. That's going to take in the Id
  // and here we just do map.get(id):

  T findById(ID id) {
    return map.get(id);     // We return here back that object out of the map.
  }

  T save(T object) {        // I'm just saying object there because we really don't
                                   // know what's coming in because of the generics. Now we can
                                   // say map.put():

                                   // Now, because we don't know the specific, we're going to
                                   // have to
                                   // override this a little bit. What we ca do is
                                   // T save(ID id, T object) instead of initial T save(T object)
    if (object != null) {
      if (object.getId() == null) {
        object.setId(getNextId());
      }
      map.put(object.getId(), object);
    } else {
      throw new RuntimeException("Object cannot be null");
    }
    return object;
  }

  // The, we also did a delete:

  void deleteById(ID id) {
    map.remove(id);
  }

  // Delete by object:

  void delete(T object) {
    map.entrySet().removeIf(entry -> entry.getValue().equals(object)); // Get that all in one
                                                                       // statement.
  }

  private Long getNextId() {

    Long nextId = null;

    try {
      nextId =  Collections.max(map.keySet()) + 1;  // get max of that
    } catch (NoSuchElementException e) {
      nextId = 1L;
    }

    return nextId;
  }

}
