package org.looplegion.app.service;

import java.util.List;

import org.looplegion.app.entity.Product;
import org.looplegion.app.entity.ProductCategory;

public interface ProductService {
	
	
	Product getProductById(Long id);
	Product getProductByName(String name);
	Product createProduct(Product product);
	Product getProductByDogoName(String dogoName );
	List<Product> getAllProducts();
//	List<Product> getAllByProductCategory(ProductCategory productCategory);
	
	Product updateProduct(Product product, Long id);
	void deleteProduct(Long id);
}
