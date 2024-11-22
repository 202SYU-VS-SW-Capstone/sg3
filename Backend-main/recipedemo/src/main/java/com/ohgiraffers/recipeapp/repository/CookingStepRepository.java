package com.ohgiraffers.recipeapp.repository;

import com.ohgiraffers.recipeapp.entity.CookingStep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CookingStepRepository extends JpaRepository<CookingStep, Long> {
    // 특정 레시피의 모든 조리 단계 가져오기
    List<CookingStep> findByRecipeId(Long recipeId);
}
