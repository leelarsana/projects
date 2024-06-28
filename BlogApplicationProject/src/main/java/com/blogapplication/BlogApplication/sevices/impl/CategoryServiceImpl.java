package com.blogapplication.BlogApplication.sevices.impl;

import com.blogapplication.BlogApplication.entities.Category;
import com.blogapplication.BlogApplication.exceptions.ResourceNotFoundException;
import com.blogapplication.BlogApplication.payloads.CategoryDto;
import com.blogapplication.BlogApplication.repesitorys.CategoryRepository;
import com.blogapplication.BlogApplication.sevices.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CategoryServiceImpl implements CategoryService
{
@Autowired
private CategoryRepository categoryRepository;
@Autowired
private ModelMapper modelMapper;
@Override
public CategoryDto createCategory(CategoryDto categoryDto) {
    Category cat=this.modelMapper.map(categoryDto,Category.class);
    Category addedCat=this.categoryRepository.save(cat);
    return this.modelMapper.map(addedCat,CategoryDto.class);
}

@Override
public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
    Category cat=this.categoryRepository.findById(categoryId)
            .orElseThrow(() -> new ResourceNotFoundException("Category","Category Id",categoryId));
    cat.setCategoryTitle(categoryDto.getCategoryTitle());
    cat.setCategoryDescription(categoryDto.getCategoryDescription());

    Category updatedCat = this.categoryRepository.save(cat);
    return this.modelMapper.map(updatedCat,CategoryDto.class);
}

@Override
public void deleteCategory(Integer categoryId) {
    Category cat = this.categoryRepository.findById(categoryId)
            .orElseThrow(()-> new ResourceNotFoundException("Category","Category id",categoryId));
    this.categoryRepository.delete(cat);

}

@Override
public CategoryDto getCategory(Integer categoryId) {
    Category cat = this.categoryRepository.findById(categoryId)
            .orElseThrow(()-> new ResourceNotFoundException("Category","category id",categoryId));
    return this.modelMapper.map(cat,CategoryDto.class);
}

@Override
public List<CategoryDto> getCategories() {
    List<Category> categories=this.categoryRepository.findAll();
    List<CategoryDto> catDtos= categories.stream().map((cat)->this.modelMapper.map(cat,CategoryDto.class)).collect(Collectors.toList());
    return catDtos;
}
}