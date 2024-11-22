package com.ohgiraffers.recipeapp.repository;

import com.ohgiraffers.recipeapp.entity.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    // 특정 회원의 모든 즐겨찾기 가져오기
    List<Bookmark> findByMemberId(Long memberId);
}

