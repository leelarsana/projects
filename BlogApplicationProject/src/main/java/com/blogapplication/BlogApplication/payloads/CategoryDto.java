package com.blogapplication.BlogApplication.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

    private Integer categoryId;

    @NotBlank
    @Size(min = 4,message = "minimum size of category must be 4")
    private String categoryTitle;

    @NotBlank
    @Size(min = 5,message = "minimum size of category must be 5")
    private String categoryDescription;
}
