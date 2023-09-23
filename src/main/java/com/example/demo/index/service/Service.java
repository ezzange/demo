package com.example.demo.index.service;

import com.example.demo.index.entity.Entity;
import com.example.demo.index.repository.CustomRepository;
import lombok.RequiredArgsConstructor;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class Service {
    //
    private final CustomRepository CustomHomeRepo;

    public Entity createHome(String content) {
        Entity home = Entity.builder()
                .content(content)
                .build();
        return CustomHomeRepo.saveHome(home);
    }

    public Entity findHome(Long id) {
        return CustomHomeRepo.findHomeById(id);
    }



}
