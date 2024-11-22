package com.ohgiraffers.recipeapp.repository;

import com.ohgiraffers.recipeapp.entity.RefrigeratorIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RefrigeratorIngredientRepository extends JpaRepository<RefrigeratorIngredient, Long> {
    // 특정 회원의 재료 가져오기
    List<RefrigeratorIngredient> findByMemberId(Long memberId);
}
