package com.example.stars.service;


import com.example.stars.mappers.StarMapper;
import com.example.stars.models.Stars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StarService {

    private final StarMapper starMapper;

    @Autowired
    public StarService(StarMapper starMapper) {
        this.starMapper = starMapper;
    }

    @Transactional
    public void addNew(Stars stars){
        starMapper.insert(stars);
    }

    @Transactional
    public void update(Stars stars, Long id){
        starMapper.update(stars, id);
    }

    @Transactional
    public void delete(Long id){
        starMapper.deleteStar(id);
    }

    @Transactional
    public String getColor(Long id){
        String color = String.valueOf(starMapper.getStarColor(id));
        return color;
    }

    @Transactional
    public List<Stars> getStarAll(){
        return starMapper.findAll();
    }
}
