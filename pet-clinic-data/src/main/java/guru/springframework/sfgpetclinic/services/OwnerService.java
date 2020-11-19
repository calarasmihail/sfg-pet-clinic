package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

 /*Owner findById(Long id);*/                // findById(), save() and findAll() are implemented
                                             // already, so we can just delete them.

 /*Owner save(Owner owner);*/

 /*Set<Owner> findAll();*/

 Owner findByLastName(String lastName);

}
