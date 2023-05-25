package com.example.stars.controllers;

import com.example.stars.dto.StarDTO;
import com.example.stars.models.Stars;
import com.example.stars.service.StarService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("stars")
public class StarController {

    private final StarService starService;
    private final ModelMapper modelMapper;

    @Autowired
    public StarController(StarService starService, ModelMapper modelMapper) {
        this.starService = starService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("")
    public ResponseEntity<String> getStars(){
        starService.getStarAll();
        return ResponseEntity.ok("");
    }

    @PostMapping("/addNew")
    public ResponseEntity<String> addStar(@RequestBody StarDTO starDTO){
        starService.addNew(convertToStar(starDTO));
        return ResponseEntity.ok("Новая звезда успешно добавлена");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable(name = "id") Long id,@RequestBody StarDTO starDTO){
        starService.update(convertToStar(starDTO), id);
        return  ResponseEntity.ok("Изменение прошло успешно");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable(name = "id") Long id){

        String color = starService.getColor(id);
        if (color!= null && color.equals("Жёлтый")) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Невозможно удалить желтую звезду.");
        } else {
            starService.delete(id);
        }

        return ResponseEntity.ok("Удаление звезды прошло успешно");
    }

    private Stars convertToStar(StarDTO starDTO){
        return modelMapper.map(starDTO, Stars.class);
    }
}
