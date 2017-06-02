package org.accion.repository;

import org.accion.entity.Vendor;
import org.springframework.data.repository.CrudRepository;

public interface VendorRepository extends CrudRepository<Vendor,Integer> {
  public Vendor findByName(String name);
}
