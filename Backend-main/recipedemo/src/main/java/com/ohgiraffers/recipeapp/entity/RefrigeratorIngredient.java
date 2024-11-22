package com.ohgiraffers.recipeapp.entity;

import com.ohgiraffers.recipeapp.enums.IngredientStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "refrigerator_ingredients")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RefrigeratorIngredient {   // 냉장고 식재료 테이블

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private String quantity;

    @Enumerated(EnumType.STRING)
    private IngredientStatus status; // 미사용, 사용중, 소진

    private LocalDate expirationDate;
}
