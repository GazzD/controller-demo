package com.ironhack.controllerdemo.repository;

import com.ironhack.controllerdemo.enums.Category;
import com.ironhack.controllerdemo.enums.Department;
import com.ironhack.controllerdemo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    public List<Product> findByCategoryAndDepartment(Category category, Department department);
    public List<Product> findByDepartment(Department department);
}
