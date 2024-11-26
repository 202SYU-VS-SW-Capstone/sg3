package com.ohgiraffers.recipeapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "major_categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MajorCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 대분류 ID

    @Column(nullable = false)
    private String name; // 대분류 이름
}


