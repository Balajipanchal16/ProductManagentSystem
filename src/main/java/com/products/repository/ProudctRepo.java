package com.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.products.Model.Product;

@Repository
public interface ProudctRepo extends JpaRepository<Product, Long> {

}
