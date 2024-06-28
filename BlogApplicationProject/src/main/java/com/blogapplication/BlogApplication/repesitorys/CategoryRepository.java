package com.blogapplication.BlogApplication.repesitorys;

import com.blogapplication.BlogApplication.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

}
