package com.example.restservice.service;

import com.example.restservice.model.StarwarChar;

import java.util.List;

public interface IntStarWarService {
    StarwarChar getStarWarChar(int charid);
    void addStarWarChar(int charid);
    List<StarwarChar> getStarWarCharFromDb();

}
