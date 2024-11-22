package com.ohgiraffers.recipeapp.repository;

import com.ohgiraffers.recipeapp.entity.MajorCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MajorCategoryRepository extends JpaRepository<MajorCategory, Long> {
    // 이름으로 대분류 찾기
    MajorCategory findByName(String name);
}
