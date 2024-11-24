package com.ohgiraffers.recipeapp.service;

import com.ohgiraffers.recipeapp.entity.Recipe;
import com.ohgiraffers.recipeapp.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    // RecipeRepository를 생성자로 주입
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    /**
     * 모든 레시피 조회
     *
     * @return List<Recipe> - 모든 레시피 목록
     * @description 데이터베이스에 저장된 모든 레시피를 반환합니다.
     */
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    /**
     * ID로 특정 레시피 조회
     *
     * @param id 레시피 ID
     * @return Recipe - 조회된 레시피 데이터
     * @description 주어진 ID를 기준으로 레시피를 조회합니다. 존재하지 않을 경우 예외를 발생시킵니다.
     */
    public Recipe getRecipeById(Long id) {
        return recipeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Recipe not found with id: " + id));
    }

    /**
     * 새로운 레시피 저장
     *
     * @param recipe 저장할 레시피 데이터
     * @return Recipe - 저장된 레시피 데이터
     * @description 전달받은 데이터를 기반으로 새로운 레시피를 저장합니다.
     */
    public Recipe saveRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    /**
     * 특정 레시피 수정
     *
     * @param id 수정할 레시피 ID
     * @param updatedRecipe 수정할 레시피 데이터
     * @return Recipe - 수정된 레시피 데이터
     * @description 주어진 ID의 레시피를 전달받은 데이터로 수정합니다. 존재하지 않을 경우 예외를 발생시킵니다.
     */
    public Recipe updateRecipe(Long id, Recipe updatedRecipe) {
        Recipe existingRecipe = recipeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Recipe not found with id: " + id));
        existingRecipe.setTitle(updatedRecipe.getTitle());
        existingRecipe.setDescription(updatedRecipe.getDescription());
        existingRecipe.setCookingTime(updatedRecipe.getCookingTime());
        existingRecipe.setServings(updatedRecipe.getServings());
        return recipeRepository.save(existingRecipe);
    }

    /**
     * 특정 레시피 삭제
     *
     * @param id 삭제할 레시피 ID
     * @description 주어진 ID의 레시피를 삭제합니다. 존재하지 않을 경우 예외를 발생시킵니다.
     */
    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }

    /**
     * 제목으로 레시피 검색
     *
     * @param title 검색할 제목 키워드
     * @return List<Recipe> - 제목 키워드를 포함하는 레시피 목록
     * @description 제목 키워드를 포함하는 모든 레시피를 반환합니다.
     */
    public List<Recipe> searchRecipesByTitle(String title) {
        return recipeRepository.findByTitleContainingIgnoreCase(title);
    }

    /**
     * 조회수 기준으로 인기 레시피 조회
     *
     * @return List<Recipe> - 조회수 순으로 정렬된 레시피 목록
     * @description 조회수가 높은 순서대로 모든 레시피를 반환합니다.
     */
    public List<Recipe> getPopularRecipes() {
        return recipeRepository.findAllByOrderByViewsDesc();
    }
}
