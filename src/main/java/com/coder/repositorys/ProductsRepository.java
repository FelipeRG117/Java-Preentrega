package com.coder.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coder.models.Products;


public interface ProductsRepository extends JpaRepository<Products,Long> {

}
