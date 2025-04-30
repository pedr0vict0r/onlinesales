package br.edu.xpe.onlinesales.service;

import br.edu.xpe.onlinesales.model.Product;
import br.edu.xpe.onlinesales.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

	private final ProductRepository productRepository;

	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	public List<Product> findAllProducts() {
		return productRepository.findAll();
	}

	public Product findProductById(Long id) {
		return productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Product not found"));
	}

	public List<Product> findProductByName(String name) {
		return productRepository.findByName(name);
	}

	public Product updateProduct(Long id, Product updatedProduct) {
		return productRepository.findById(id).map(existingProduct -> {
			existingProduct.setName(updatedProduct.getName());
			existingProduct.setDescription(updatedProduct.getDescription());
			existingProduct.setPrice(updatedProduct.getPrice());
			return productRepository.save(existingProduct);
		}).orElseThrow(() -> new RuntimeException("Product not found"));
	}

	public boolean deleteProduct(Long id) {
		return productRepository.findById(id).map(product -> {
			productRepository.delete(product);
			return true;
		}).orElse(false);
	}

	public long countProducts() {
		return productRepository.count();
	}

}
