package com.ohgiraffers.recipeapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ingredients")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ingredient {   // 식재료 테이블

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;  // 재료 이름 (예: 소고기 안심)

    @ManyToOne
    @JoinColumn(name = "sub_category_id") // 소분류와 연관
    private SubCategory subCategory;  // 재료의 소분류 (예: 소고기)
}


