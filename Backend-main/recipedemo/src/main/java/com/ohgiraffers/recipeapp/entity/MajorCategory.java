package com.ohgiraffers.recipeapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "major_categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MajorCategory {    // 식재료 대분류 테이블

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}

