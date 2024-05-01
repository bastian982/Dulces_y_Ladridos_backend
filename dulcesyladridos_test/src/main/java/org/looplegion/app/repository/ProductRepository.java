package org.looplegion.app.repository;

import java.util.Optional;

import org.looplegion.app.entity.Product;
import org.looplegion.app.entity.ProductCategory;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository <Product, Long>{
	
	Optional<Product> findByDogoName(String dogoName);//SELECT * FROM users WHERE dogo_name = ?dogoName;
	Iterable<Product> getAllByProductCategory(ProductCategory productCategory);//SELECT * FROM users WHERE fk_category_id = ?productCategory;
	boolean existsByDogoName(String dogoName);

}
