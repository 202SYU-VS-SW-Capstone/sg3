package com.ohgiraffers.recipeapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ingredients")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 재료 ID

    @ManyToOne
    @JoinColumn(name = "sub_category_id", nullable = false)
    private SubCategory subCategory; // 소분류와 연결

    @Column(nullable = false)
    private String name; // 재료 이름

    @ManyToOne
    @JoinColumn(name = "ingredient_image_id", nullable = true)
    private IngredientImage ingredientImage; // 재료 이미지와 연결
}
