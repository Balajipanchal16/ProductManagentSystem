package com.products.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.products.Model.Product;
import com.products.repository.ProudctRepo;



@Service
public class ProductService {

	@Autowired
	private ProudctRepo productRepo;
	
	public List<Product> getAllProducts()
	{
		return productRepo.findAll();
	}
	
	public Product getProductById(Long id)
	{
		return productRepo.findById(id).orElse(null);
	}
	
	public Product createProduct(Product product)
	{
		return productRepo.save(product);
	}
	
	public Product updateProduct(Product product)
	{
		return productRepo.save(product);
	}
	
	public void deleteProductById(Long id)
	{
		productRepo.deleteById(id);
	}
	
	public List<Product> getAllProducts(int pageNo, int pageSize)
	{
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		Page<Product> productPage = productRepo.findAll(pageable);
		return productPage.getContent();
	}
	
}
