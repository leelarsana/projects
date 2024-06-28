package com.blogapplication.BlogApplication.sevices;

import com.blogapplication.BlogApplication.payloads.CategoryDto;
import jakarta.validation.constraints.Min;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

public interface CategoryService {

    //remember in interface we no need to give public in front of functions becouse in interface by default everything is public and abstract function

    //create
    CategoryDto createCategory(CategoryDto categoryDto);

    //update

    CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);

    //delete
    void deleteCategory(Integer categoryId);

    //get
    CategoryDto getCategory(Integer categoryId);

    //getAll
    List<CategoryDto> getCategories();
}
