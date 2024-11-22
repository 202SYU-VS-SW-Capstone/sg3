package com.ohgiraffers.recipeapp.repository;

import com.ohgiraffers.recipeapp.entity.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BannerRepository extends JpaRepository<Banner, Long> {
    // 특정 회원의 배너 가져오기
    List<Banner> findByMemberId(Long memberId);
}
