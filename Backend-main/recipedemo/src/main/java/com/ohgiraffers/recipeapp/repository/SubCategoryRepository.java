package com.ohgiraffers.recipeapp.repository;

import com.ohgiraffers.recipeapp.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {
    // 대분류 ID로 소분류 찾기
    List<SubCategory> findByMajorCategoryId(Long majorCategoryId);
}
