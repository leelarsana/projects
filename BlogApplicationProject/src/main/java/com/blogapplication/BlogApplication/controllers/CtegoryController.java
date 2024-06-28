package com.blogapplication.BlogApplication.controllers;

import com.blogapplication.BlogApplication.payloads.ApiResponse;
import com.blogapplication.BlogApplication.payloads.CategoryDto;
import com.blogapplication.BlogApplication.sevices.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CtegoryController {
    @Autowired
    private CategoryService categoryService;

    //create
    @PostMapping("/save")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
        CategoryDto createCategory=this.categoryService.createCategory(categoryDto);
        return new ResponseEntity<CategoryDto>(createCategory, HttpStatus.CREATED);
    }

    //update
    @PutMapping("/{catId}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable Integer catId ){
        CategoryDto updatedCategory=this.categoryService.updateCategory(categoryDto,catId);
        return new ResponseEntity<CategoryDto>(updatedCategory, HttpStatus.OK);
    }

    //delete

    @DeleteMapping("/{catId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer catId ){
        this.categoryService.deleteCategory(catId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("category is deleted successfully!!!",true), HttpStatus.OK);
    }

    //get

    @GetMapping("/{catId}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer catId ){
        CategoryDto categoryDto=this.categoryService.getCategory(catId);
        return new ResponseEntity<CategoryDto>(categoryDto,HttpStatus.OK);
            }
    //getAll
    @GetMapping("/getAll")
    public ResponseEntity<List<CategoryDto>> getCategory(){
        List<CategoryDto> categories = this.categoryService.getCategories();
        return ResponseEntity.ok(categories);
        }





}
