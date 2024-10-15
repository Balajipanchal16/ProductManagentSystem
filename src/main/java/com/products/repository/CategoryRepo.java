package com.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.products.Model.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long>{

}
