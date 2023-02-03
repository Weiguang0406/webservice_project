package com.example.restservice.service;

import com.example.restservice.adapter.StarWarAdapter;
import com.example.restservice.model.StarwarChar;
import com.example.restservice.repository.StarWarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StarWarService implements IntStarWarService {

    @Autowired
    private StarWarAdapter starWarAdapter;
    @Autowired
    private StarWarRepository starWarRepository;
    @Override
    public StarwarChar getStarWarChar(int charid) {
        return starWarAdapter.getStarWarChar(charid);
        }


    @Override
public List<StarwarChar> getStarWarCharFromDb(){
        return starWarRepository.getStarWarCharFromDb();
};
    @Override
    public void addStarWarChar(int charid) {
        starWarRepository.addStarWarChar(charid);
    }

    }
