package com.coder.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import com.coder.models.Product;

public interface ProductsRepository extends JpaRepository<Product,Long> {

}
