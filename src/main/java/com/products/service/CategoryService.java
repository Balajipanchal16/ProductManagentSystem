package com.products.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.products.Model.Category;
import com.products.repository.CategoryRepo;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;
	
	public List<Category> getAllCategories()
	{
		return categoryRepo.findAll();
	}
	
	public Category createCategory(Category category)
	{
		return categoryRepo.save(category);
	}
	
	public Category getCategoryById(Long id)
	{
		return categoryRepo.findById(id).orElse(null);
	}
	
	public Category updateCategory(Category category)
	{
		return categoryRepo.save(category);
	}
	
	public void deleteCategoryById(Long id)
	{
		 categoryRepo.deleteById(id);
	}
	
	public List<Category> getAllCategories(int pageNo, int pageSize)
	{
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		Page<Category> categoryPage = categoryRepo.findAll(pageable);
		return categoryPage.getContent();
	}
}

