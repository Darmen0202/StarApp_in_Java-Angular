package com.example.stars.controllers;

import com.example.stars.dto.AstronomerDTO;
import com.example.stars.models.Astronomers;
import com.example.stars.service.AstronomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/astronomers")
public class AstronomerController {

    private final AstronomerService astronomerService;
    private final ModelMapper modelMapper;

    @Autowired
    public AstronomerController(AstronomerService astronomerService, ModelMapper modelMapper) {
        this.astronomerService = astronomerService;
        this.modelMapper = modelMapper;
    }

    @GetMapping()
    public  ResponseEntity<String> view(){
        return ResponseEntity.ok("This is a astronomers page");
    }

    @PostMapping("/add")
    public ResponseEntity<String> addAstronomer(@RequestBody AstronomerDTO astronomerDTO){
        astronomerService.addNew(convertToAstronomer(astronomerDTO));
        return ResponseEntity.ok("Добавление нового открывателя прошло успешно");
    }

    private Astronomers convertToAstronomer(AstronomerDTO astronomerDTO){
        return  modelMapper.map(astronomerDTO, Astronomers.class);
    }
}
