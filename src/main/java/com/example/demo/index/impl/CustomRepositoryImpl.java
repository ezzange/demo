package com.example.demo.index.impl;

import com.example.demo.index.entity.Entity;
import com.example.demo.index.repository.CustomRepository;
import com.example.demo.index.repository.JpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CustomRepositoryImpl implements CustomRepository {

    private final JpaRepository jpaHomeRepo;
    @Override
    public Entity findHomeById(Long id) {
        return jpaHomeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not Found"));
    }
    @Override
    public Entity saveHome(Entity home) {
        return jpaHomeRepo.save(home);
    }
}
