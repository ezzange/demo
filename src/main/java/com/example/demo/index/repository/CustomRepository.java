package com.example.demo.index.repository;

import com.example.demo.index.entity.Entity;


public interface CustomRepository {
    Entity findHomeById(Long id);
    Entity saveHome(Entity home);
}
