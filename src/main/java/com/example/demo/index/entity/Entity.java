package com.example.demo.index.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@jakarta.persistence.Entity
@Table(name = "entity")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String content;
}
