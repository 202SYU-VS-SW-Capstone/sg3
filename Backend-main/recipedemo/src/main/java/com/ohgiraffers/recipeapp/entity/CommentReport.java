package com.ohgiraffers.recipeapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "comment_reports")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentReport {    // 댓글 신고 테이블

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "reporter_member_id")
    private Member reporter;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

    private String reportTitle;
    private String reportContent;
    private LocalDate reportedAt;
}

