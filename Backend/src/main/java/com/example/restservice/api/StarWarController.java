package com.example.restservice.api;

import com.example.restservice.model.StarwarChar;
import com.example.restservice.service.IntStarWarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/starwar")
public class StarWarController {
    @Autowired
    private IntStarWarService starWarService;

    @GetMapping("/people/{charid}")
    public ResponseEntity<StarwarChar> getStarWarChar(@PathVariable int charid){
        return new ResponseEntity<>(starWarService.getStarWarChar(charid), HttpStatus.OK);
    }
    @GetMapping("/db")
    public ResponseEntity<List<StarwarChar>> getStarWarCharFromDb(){
        return new ResponseEntity<>(starWarService.getStarWarCharFromDb(),HttpStatus.OK);
    }
    @PostMapping("/people/{charid}")
    public void addStarwarCharToDb(@PathVariable int charid){
        starWarService.addStarWarChar(charid);
    }
}
