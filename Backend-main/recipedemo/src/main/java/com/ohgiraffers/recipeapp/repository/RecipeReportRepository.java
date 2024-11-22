package com.ohgiraffers.recipeapp.repository;

import com.ohgiraffers.recipeapp.entity.RecipeReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeReportRepository extends JpaRepository<RecipeReport, Long> {
    // 특정 레시피의 신고 내역 가져오기
    List<RecipeReport> findByRecipeId(Long recipeId);
}
