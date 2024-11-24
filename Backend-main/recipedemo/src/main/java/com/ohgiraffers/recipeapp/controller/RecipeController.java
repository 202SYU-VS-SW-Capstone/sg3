package com.ohgiraffers.recipeapp.controller;

import com.ohgiraffers.recipeapp.entity.Recipe;
import com.ohgiraffers.recipeapp.service.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipes") // 기본 API 경로 설정
public class RecipeController {

    private final RecipeService recipeService;

    // RecipeService를 생성자로 주입
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    /**
     * 모든 레시피 조회
     *
     * @return ResponseEntity<List<Recipe>> - 모든 레시피 목록과 HTTP 상태 코드
     * @HTTPMethod GET
     * @URL /api/recipes
     * @description 저장된 모든 레시피를 조회합니다.
     */
    @GetMapping
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        return ResponseEntity.ok(recipeService.getAllRecipes());
    }

    /**
     * 특정 ID의 레시피 조회
     *
     * @param id 레시피 ID (Path Variable)
     * @return ResponseEntity<Recipe> - 특정 레시피 데이터와 HTTP 상태 코드
     * @HTTPMethod GET
     * @URL /api/recipes/{id}
     * @description 주어진 ID를 기준으로 레시피를 조회합니다.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable Long id) {
        Recipe recipe = recipeService.getRecipeById(id);
        return ResponseEntity.ok(recipe);
    }

    /**
     * 새로운 레시피 생성
     *
     * @param recipe 생성할 레시피 데이터 (Request Body)
     * @return ResponseEntity<Recipe> - 생성된 레시피 데이터와 HTTP 상태 코드
     * @HTTPMethod POST
     * @URL /api/recipes
     * @description 새로운 레시피 데이터를 생성합니다.
     */
    @PostMapping
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {
        Recipe savedRecipe = recipeService.saveRecipe(recipe);
        return ResponseEntity.status(201).body(savedRecipe); // 201 Created
    }

    /**
     * 특정 ID의 레시피 수정
     *
     * @param id 수정할 레시피 ID (Path Variable)
     * @param updatedRecipe 수정할 레시피 데이터 (Request Body)
     * @return ResponseEntity<Recipe> - 수정된 레시피 데이터와 HTTP 상태 코드
     * @HTTPMethod PUT
     * @URL /api/recipes/{id}
     * @description 주어진 ID의 레시피를 수정합니다.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Recipe> updateRecipe(
            @PathVariable Long id,
            @RequestBody Recipe updatedRecipe
    ) {
        Recipe recipe = recipeService.updateRecipe(id, updatedRecipe);
        return ResponseEntity.ok(recipe); // 200 OK
    }

    /**
     * 특정 ID의 레시피 삭제
     *
     * @param id 삭제할 레시피 ID (Path Variable)
     * @return ResponseEntity<Void> - 본문 없이 HTTP 상태 코드만 반환
     * @HTTPMethod DELETE
     * @URL /api/recipes/{id}
     * @description 주어진 ID의 레시피를 삭제합니다.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable Long id) {
        recipeService.deleteRecipe(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }

    /**
     * 제목으로 레시피 검색
     *
     * @param title 검색할 제목 키워드 (Query Parameter)
     * @return ResponseEntity<List<Recipe>> - 제목 키워드를 포함하는 레시피 목록과 HTTP 상태 코드
     * @HTTPMethod GET
     * @URL /api/recipes/search?title={title}
     * @description 제목 키워드를 포함하는 레시피를 검색합니다.
     */
    @GetMapping("/search")
    public ResponseEntity<List<Recipe>> searchRecipesByTitle(@RequestParam String title) {
        List<Recipe> recipes = recipeService.searchRecipesByTitle(title);
        return ResponseEntity.ok(recipes);
    }

    /**
     * 조회수 기준으로 인기 레시피 조회
     *
     * @return ResponseEntity<List<Recipe>> - 조회수 순으로 정렬된 레시피 목록과 HTTP 상태 코드
     * @HTTPMethod GET
     * @URL /api/recipes/popular
     * @description 조회수가 높은 순으로 레시피를 반환합니다.
     */
    @GetMapping("/popular")
    public ResponseEntity<List<Recipe>> getPopularRecipes() {
        List<Recipe> recipes = recipeService.getPopularRecipes();
        return ResponseEntity.ok(recipes);
    }
}

