package com.ohgiraffers.recipeapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cooking_steps")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CookingStep {  // 조리단계 테이블

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    private String description;
    private int stepNumber;
}
