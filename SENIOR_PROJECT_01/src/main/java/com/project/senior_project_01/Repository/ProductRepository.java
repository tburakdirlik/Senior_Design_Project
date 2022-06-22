package com.project.senior_project_01.Repository;

import org.springframework.stereotype.Repository;
import com.project.senior_project_01.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
