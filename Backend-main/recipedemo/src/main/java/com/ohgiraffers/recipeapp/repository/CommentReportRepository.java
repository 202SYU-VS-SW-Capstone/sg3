package com.ohgiraffers.recipeapp.repository;

import com.ohgiraffers.recipeapp.entity.CommentReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentReportRepository extends JpaRepository<CommentReport, Long> {
    // 특정 댓글의 신고 내역 가져오기
    List<CommentReport> findByCommentId(Long commentId);
}
