package com.ohgiraffers.recipeapp.entity;

import com.ohgiraffers.recipeapp.enums.InquiryStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "inquiries")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Inquiry {  // 문의사항 테이블

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private String content;
    private LocalDate createdAt;

    @Enumerated(EnumType.STRING)
    private InquiryStatus status; // 답변 완료, 답변 미완료
}
