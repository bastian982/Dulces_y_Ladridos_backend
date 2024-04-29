package org.looplegion.app.service;

import java.util.List;

import org.looplegion.app.entity.Product;
import org.looplegion.app.entity.ProductCategory;

public interface ProductService {
	
	Product getProductById(Long id);
	Product getProductByName(String name);
	Product getProductByDogoName(String dogoName );
	List<Product> getAllByCategory(ProductCategory productCategory);
	
	Product updateProduct(Product product, Long id);
	void deleteProduct(Long id);
}
