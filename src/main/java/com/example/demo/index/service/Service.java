package com.example.demo.index.service;

import com.example.demo.index.entity.Entity;
import com.example.demo.index.repository.CustomRepository;
import lombok.RequiredArgsConstructor;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class Service {

    private final CustomRepository CustomHomeRepo;

    //content값을 받아 엔티티에 저장
    public Entity createHome(String content) {
        Entity home = Entity.builder()
                .content(content)
                .build();
        return CustomHomeRepo.saveHome(home);
    }
    //id값을 찾아온다.
    public Entity findHome(Long id) {
        return CustomHomeRepo.findHomeById(id);
    }



}
