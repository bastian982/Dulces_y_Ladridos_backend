package org.looplegion.app.controller;

import java.util.List;

import org.looplegion.app.entity.Product;
import org.looplegion.app.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/products")
public class ProductController {
	ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping
	ResponseEntity<List<Product>> getAllProducts(
			@RequestParam(name="active",
										required =false,
										defaultValue = "true") boolean active
					){
		return new ResponseEntity<List<Product>>( productService.getAllProducts( active ), HttpStatus.OK);
	}
	
	@GetMapping("{id}") // localhost:8080/api/v1/products/{id}
	ResponseEntity<Product> getProductById(@PathVariable("id") Long id ){
		return new ResponseEntity<Product>
		(productService.getProductById(id) ,HttpStatus.OK );
	}
	
	@PostMapping
	ResponseEntity<Product> createProduct(@RequestBody Product product ){
		Product createdProduct = productService.createProduct(product);
		
		return new ResponseEntity<Product>( createdProduct, HttpStatus.CREATED );		
	}
	
	@DeleteMapping("{id}")
	ResponseEntity<String> deleteProduct(@PathVariable("id") Long id ){
		productService.deleteProduct(id);
		return new ResponseEntity<String>("Product id " + id + " successfully deleted", HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	ResponseEntity<Product> updateProduct(
			@RequestBody Product product, 
			@PathVariable("id") Long id  
			){
		Product updatedProduct = productService.updateProduct(product, id);
		
		return new ResponseEntity<Product>( updatedProduct, HttpStatus.OK );		
	}
	
	
	
}
