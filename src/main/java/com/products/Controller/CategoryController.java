package com.products.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.products.Model.Category;
import com.products.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public List<Category> getAllCategories(@RequestParam(defaultValue = "0")int pageNo,
										@RequestParam(defaultValue = "5") int pageSize)
	{
		return categoryService.getAllCategories(pageNo, pageSize);
	}
	
	@PostMapping
	public Category createCategory(@RequestBody Category cagtegory)
	{
		return categoryService.createCategory(cagtegory);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Category> updateCategory(@PathVariable Long id,@RequestBody Category category)
	{
		Category Existingcategory = categoryService.getCategoryById(id);
		if(Existingcategory != null)
		{
			category.setId(id);
			return ResponseEntity.ok(categoryService.updateCategory(category));
		}
		else
		{
			return ResponseEntity.notFound().build();
		}
			
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable Long id)
	{
	 Category category =	categoryService.getCategoryById(id);
	 if(category != null)
	 {
		 return ResponseEntity.ok(category);
	 }
	 else
	 {
		 return ResponseEntity.notFound().build();
	 }
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletCategory(@PathVariable Long id)
	{
		 Category existingCategory = categoryService.getCategoryById(id);
		 if(existingCategory != null)
		 {
			 categoryService.deleteCategoryById(id);
			 return ResponseEntity.noContent().build();
		 }
		 else
		 {
			 return ResponseEntity.notFound().build();
		 }
	}
	

	
	
	
}
