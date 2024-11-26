package com.ohgiraffers.recipeapp.controller;

import com.ohgiraffers.recipeapp.entity.Ingredient;
import com.ohgiraffers.recipeapp.service.IngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    /**
     * 모든 재료 조회
     *
     * @return ResponseEntity<List<Ingredient>> - 모든 재료 목록과 HTTP 상태 코드
     */
    @GetMapping
    public ResponseEntity<List<Ingredient>> getAllIngredients() {
        return ResponseEntity.ok(ingredientService.getAllIngredients());
    }

    /**
     * ID로 특정 재료 조회
     *
     * @param id 재료 ID (Path Variable)
     * @return ResponseEntity<Ingredient> - 조회된 재료 데이터와 HTTP 상태 코드
     */
    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> getIngredientById(@PathVariable Long id) {
        Ingredient ingredient = ingredientService.getIngredientById(id);
        return ResponseEntity.ok(ingredient);
    }

    /**
     * 새로운 재료 추가
     *
     * @param ingredient 저장할 재료 데이터 (Request Body)
     * @return ResponseEntity<Ingredient> - 저장된 재료 데이터와 HTTP 상태 코드
     */
    @PostMapping
    public ResponseEntity<Ingredient> createIngredient(@RequestBody Ingredient ingredient) {
        Ingredient savedIngredient = ingredientService.saveIngredient(ingredient);
        return ResponseEntity.status(201).body(savedIngredient); // 201 Created
    }

    /**
     * 특정 재료 수정
     *
     * @param id 수정할 재료 ID (Path Variable)
     * @param updatedIngredient 수정할 재료 데이터 (Request Body)
     * @return ResponseEntity<Ingredient> - 수정된 재료 데이터와 HTTP 상태 코드
     */
    @PutMapping("/{id}")
    public ResponseEntity<Ingredient> updateIngredient(
            @PathVariable Long id,
            @RequestBody Ingredient updatedIngredient
    ) {
        Ingredient ingredient = ingredientService.updateIngredient(id, updatedIngredient);
        return ResponseEntity.ok(ingredient); // 200 OK
    }

    /**
     * 특정 재료 삭제
     *
     * @param id 삭제할 재료 ID (Path Variable)
     * @return ResponseEntity<Void> - 본문 없이 HTTP 상태 코드만 반환
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngredient(@PathVariable Long id) {
        ingredientService.deleteIngredient(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }

    /**
     * 소분류 ID로 재료 검색
     *
     * @param subCategoryId 소분류 ID (Query Parameter)
     * @return ResponseEntity<List<Ingredient>> - 해당 소분류에 속하는 재료 목록과 HTTP 상태 코드
     */
    @GetMapping("/subcategory")
    public ResponseEntity<List<Ingredient>> getIngredientsBySubCategory(@RequestParam Long subCategoryId) {
        List<Ingredient> ingredients = ingredientService.getIngredientsBySubCategory(subCategoryId);
        return ResponseEntity.ok(ingredients);
    }

    /**
     * 대분류 ID로 재료 검색
     *
     * @param majorCategoryId 대분류 ID (Query Parameter)
     * @return ResponseEntity<List<Ingredient>> - 해당 대분류에 속하는 재료 목록과 HTTP 상태 코드
     */
    @GetMapping("/majorcategory")
    public ResponseEntity<List<Ingredient>> getIngredientsByMajorCategory(@RequestParam Long majorCategoryId) {
        List<Ingredient> ingredients = ingredientService.getIngredientsByMajorCategory(majorCategoryId);
        return ResponseEntity.ok(ingredients);
    }

    /**
     * 재료 이름으로 검색
     *
     * @param name 검색할 재료 이름 (Query Parameter)
     * @return ResponseEntity<List<Ingredient>> - 해당 이름을 포함하는 재료 목록과 HTTP 상태 코드
     */
    @GetMapping("/search")
    public ResponseEntity<List<Ingredient>> searchIngredientsByName(@RequestParam String name) {
        List<Ingredient> ingredients = ingredientService.searchIngredientsByName(name);
        return ResponseEntity.ok(ingredients);
    }
}
