package com.ohgiraffers.recipeapp.controller;

import com.ohgiraffers.recipeapp.entity.Recipe;
import com.ohgiraffers.recipeapp.service.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipes") // API 기본 경로 설정
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    /**
     * 모든 레시피 조회
     * @return ResponseEntity<List<Recipe>> - 레시피 목록과 HTTP 상태 코드
     */
    @GetMapping
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        List<Recipe> recipes = recipeService.getAllRecipes();
        return ResponseEntity.ok(recipes); // 200 OK와 함께 데이터 반환
    }

    /**
     * 특정 ID의 레시피 조회
     * @param id 레시피 ID
     * @return ResponseEntity<Recipe> - 레시피 데이터와 HTTP 상태 코드
     */
    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable Long id) {
        Recipe recipe = recipeService.getRecipeById(id);
        return ResponseEntity.ok(recipe); // 200 OK와 함께 데이터 반환
    }

    /**
     * 새로운 레시피 생성
     * @param recipe 생성할 레시피 데이터 (Request Body)
     * @return ResponseEntity<Recipe> - 생성된 레시피와 HTTP 상태 코드
     */
    @PostMapping
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {
        Recipe savedRecipe = recipeService.saveRecipe(recipe);
        return ResponseEntity.status(201).body(savedRecipe); // 201 Created와 함께 생성된 데이터 반환
    }

    /**
     * 특정 ID의 레시피 수정
     * @param id 수정할 레시피 ID
     * @param updatedRecipe 수정할 레시피 데이터 (Request Body)
     * @return ResponseEntity<Recipe> - 수정된 레시피와 HTTP 상태 코드
     */
    @PutMapping("/{id}")
    public ResponseEntity<Recipe> updateRecipe(
            @PathVariable Long id,
            @RequestBody Recipe updatedRecipe
    ) {
        Recipe recipe = recipeService.updateRecipe(id, updatedRecipe);
        return ResponseEntity.ok(recipe); // 200 OK와 함께 업데이트된 데이터 반환
    }

    /**
     * 특정 ID의 레시피 삭제
     * @param id 삭제할 레시피 ID
     * @return ResponseEntity<Void> - HTTP 상태 코드만 반환
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable Long id) {
        recipeService.deleteRecipe(id);
        return ResponseEntity.noContent().build(); // 204 No Content 반환
    }
}
