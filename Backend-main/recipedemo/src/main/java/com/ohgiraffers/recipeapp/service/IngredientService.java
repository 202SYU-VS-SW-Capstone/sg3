package com.ohgiraffers.recipeapp.service;

import com.ohgiraffers.recipeapp.entity.Ingredient;
import com.ohgiraffers.recipeapp.repository.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    // Repository를 생성자로 주입
    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    /**
     * 모든 재료 조회
     *
     * @return List<Ingredient> - 데이터베이스에 저장된 모든 재료 목록
     */
    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    /**
     * ID로 특정 재료 조회
     *
     * @param id 재료 ID
     * @return Ingredient - 조회된 재료 데이터
     * @throws IllegalArgumentException - 해당 ID의 재료가 없을 경우 예외 발생
     */
    public Ingredient getIngredientById(Long id) {
        return ingredientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ingredient not found with id: " + id));
    }

    /**
     * 새로운 재료 저장
     *
     * @param ingredient 저장할 재료 데이터
     * @return Ingredient - 저장된 재료 데이터
     */
    public Ingredient saveIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    /**
     * 특정 재료 수정
     *
     * @param id 수정할 재료 ID
     * @param updatedIngredient 수정할 재료 데이터
     * @return Ingredient - 수정된 재료 데이터
     */
    public Ingredient updateIngredient(Long id, Ingredient updatedIngredient) {
        Ingredient existingIngredient = ingredientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ingredient not found with id: " + id));
        existingIngredient.setName(updatedIngredient.getName());
        existingIngredient.setSubCategory(updatedIngredient.getSubCategory());
        return ingredientRepository.save(existingIngredient);
    }

    /**
     * 특정 재료 삭제
     *
     * @param id 삭제할 재료 ID
     */
    public void deleteIngredient(Long id) {
        ingredientRepository.deleteById(id);
    }

    /**
     * 소분류 ID로 재료 검색
     *
     * @param subCategoryId 소분류 ID
     * @return List<Ingredient> - 해당 소분류에 속하는 재료 목록
     */
    public List<Ingredient> getIngredientsBySubCategory(Long subCategoryId) {
        return ingredientRepository.findBySubCategoryId(subCategoryId);
    }

    /**
     * 대분류 ID로 재료 검색
     *
     * @param majorCategoryId 대분류 ID
     * @return List<Ingredient> - 해당 대분류에 속하는 재료 목록
     */
    public List<Ingredient> getIngredientsByMajorCategory(Long majorCategoryId) {
        return ingredientRepository.findBySubCategoryMajorCategoryId(majorCategoryId);
    }

    /**
     * 재료 이름으로 검색
     *
     * @param name 검색할 재료 이름
     * @return List<Ingredient> - 해당 이름을 포함하는 재료 목록
     */
    public List<Ingredient> searchIngredientsByName(String name) {
        return ingredientRepository.findByNameContainingIgnoreCase(name);
    }
}
