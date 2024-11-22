package com.ohgiraffers.recipeapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "sub_categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubCategory {  // 식재료 소분류 테이블

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "major_category_id")
    private MajorCategory majorCategory;

    private String name;
}

