package com.ohgiraffers.recipeapp.service;

import com.ohgiraffers.recipeapp.entity.Ingredient;
import com.ohgiraffers.recipeapp.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public List<Ingredient> findAllIngredients() {
        return ingredientRepository.findAll();
    }

    public Optional<Ingredient> findIngredientById(Long id) {
        return ingredientRepository.findById(id);
    }

    public Ingredient saveIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    public Ingredient updateIngredient(Long id, Ingredient updatedIngredient) {
        return ingredientRepository.findById(id)
                .map(ingredient -> {
                    ingredient.setName(updatedIngredient.getName());
                    ingredient.setCategory(updatedIngredient.getCategory());
                    return ingredientRepository.save(ingredient);
                })
                .orElseThrow(() -> new RuntimeException("Ingredient not found"));
    }

    public void deleteIngredient(Long id) {
        ingredientRepository.deleteById(id);
    }
}
