package com.ohgiraffers.recipeapp.repository;

import com.ohgiraffers.recipeapp.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}

