package com.ohgiraffers.recipeapp.repository;

import com.ohgiraffers.recipeapp.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {
    // 특정 회원의 공지사항 찾기
    List<Notice> findByMemberId(Long memberId);
}
