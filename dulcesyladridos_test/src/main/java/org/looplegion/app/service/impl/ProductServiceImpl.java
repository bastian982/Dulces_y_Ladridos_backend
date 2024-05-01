package org.looplegion.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.looplegion.app.entity.Product;
import org.looplegion.app.entity.ProductCategory;
import org.looplegion.app.repository.ProductRepository;
import org.looplegion.app.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{
	
	ProductRepository productRepository;
	
	//Constructor
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public Product getProductById(Long id) {
		Optional<Product> productOptional = productRepository.findById(id);
		Product existingProduct;
		
		if(productOptional.isPresent()) {
			existingProduct = productOptional.get();
			return existingProduct;
		}else {
			throw new IllegalStateException("User does not exist with id " + id);
		}
	}
	
	@Override
	public Product createProduct(Product product) {
		
		product.setId(null);
		
		if(productRepository.existsByDogoName(product.getDogoName())) {
			throw new IllegalStateException("Product already exists with that dogo name" +product.getDogoName());
		}
		
		return productRepository.save(product);
	}

	@Override
	public Product getProductByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getProductByDogoName(String dogoName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getAllByCategory(ProductCategory productCategory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product updateProduct(Product product, Long id) {
		// TODO Auto-generated method stub
		Product existingProduct = getProductById(id);
		existingProduct.setName(product.getName());
		existingProduct.setDogoName(product.getDogoName());
		existingProduct.setDescription(product.getDescription());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setQuantity(product.getQuantity());
		existingProduct.setImageUrl(product.getImageUrl());
		existingProduct.setProductcategory(product.getProductcategory());
		return productRepository.save(existingProduct);
	}

	@Override
	public void deleteProduct(Long id) {
		Product existingProduct = getProductById(id);
		productRepository.delete(existingProduct);
		
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}


}