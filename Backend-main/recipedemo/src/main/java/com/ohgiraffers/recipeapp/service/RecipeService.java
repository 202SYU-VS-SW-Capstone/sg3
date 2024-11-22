package com.ohgiraffers.recipeapp.service;

import com.ohgiraffers.recipeapp.entity.Recipe;
import com.ohgiraffers.recipeapp.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    // 모든 레시피 조회
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    // ID로 특정 레시피 조회
    public Recipe getRecipeById(Long id) {
        return recipeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Recipe not found with id: " + id));
    }

    // 새로운 레시피 저장
    public Recipe saveRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    // 특정 레시피 수정
    public Recipe updateRecipe(Long id, Recipe updatedRecipe) {
        Recipe existingRecipe = recipeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Recipe not found with id: " + id));
        existingRecipe.setTitle(updatedRecipe.getTitle());
        existingRecipe.setDescription(updatedRecipe.getDescription());
        existingRecipe.setCookingTime(updatedRecipe.getCookingTime());
        existingRecipe.setServings(updatedRecipe.getServings());
        return recipeRepository.save(existingRecipe);
    }

    // 특정 레시피 삭제
    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }
}
