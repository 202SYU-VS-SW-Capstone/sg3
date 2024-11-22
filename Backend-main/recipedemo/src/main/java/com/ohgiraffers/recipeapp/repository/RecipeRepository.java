package com.ohgiraffers.recipeapp.repository;

import com.ohgiraffers.recipeapp.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    // 제목으로 레시피 검색
    List<Recipe> findByTitleContainingIgnoreCase(String title);

    // 조회수가 높은 순서로 레시피 정렬
    List<Recipe> findAllByOrderByViewsDesc();
}


