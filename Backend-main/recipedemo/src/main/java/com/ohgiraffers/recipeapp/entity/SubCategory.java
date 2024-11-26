package com.ohgiraffers.recipeapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "sub_categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 소분류 ID

    @ManyToOne
    @JoinColumn(name = "major_category_id", nullable = false)
    private MajorCategory majorCategory; // 대분류와 연관 관계

    @Column(nullable = false)
    private String name; // 소분류 이름
}

