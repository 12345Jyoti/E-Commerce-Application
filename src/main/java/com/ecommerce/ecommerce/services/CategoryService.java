package com.ecommerce.ecommerce.services;


import com.ecommerce.ecommerce.entites.Category;
import com.ecommerce.ecommerce.payloads.CategoryDTO;
import com.ecommerce.ecommerce.payloads.CategoryResponse;

public interface CategoryService {

	CategoryDTO createCategory(Category category);

	CategoryResponse getCategories(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

	CategoryDTO updateCategory(Category category, Long categoryId);

	String deleteCategory(Long categoryId);
}
