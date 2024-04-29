package org.looplegion.app.repository;

import org.looplegion.app.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository <Product, Long>{

}
