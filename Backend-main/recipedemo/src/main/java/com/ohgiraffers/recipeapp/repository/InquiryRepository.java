package com.ohgiraffers.recipeapp.repository;

import com.ohgiraffers.recipeapp.entity.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InquiryRepository extends JpaRepository<Inquiry, Long> {
    // 특정 회원의 문의사항 찾기
    List<Inquiry> findByMemberId(Long memberId);
}
