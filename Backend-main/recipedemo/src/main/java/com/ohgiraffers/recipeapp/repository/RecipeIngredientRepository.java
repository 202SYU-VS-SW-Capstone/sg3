package com.ohgiraffers.recipeapp.repository;

import com.ohgiraffers.recipeapp.entity.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, Long> {
    // 특정 레시피에 사용된 모든 재료 가져오기
    List<RecipeIngredient> findByRecipeId(Long recipeId);

    // 특정 재료가 사용된 모든 레시피 가져오기
    List<RecipeIngredient> findByIngredientId(Long ingredientId);
}
