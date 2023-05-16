package com.example.stars.service;

import com.example.stars.mappers.AstronomerMapper;
import com.example.stars.models.Astronomers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AstronomerService {

    private  final AstronomerMapper astronomerMapper;

    @Autowired
    public AstronomerService(AstronomerMapper astronomerMapper) {
        this.astronomerMapper = astronomerMapper;
    }

    @Transactional
    public void addNew(Astronomers astronomer){
        astronomerMapper.add(astronomer);
    }

    @Transactional
    public List<Astronomers> getAstronomers(){
        return astronomerMapper.findAll();
    }

}
