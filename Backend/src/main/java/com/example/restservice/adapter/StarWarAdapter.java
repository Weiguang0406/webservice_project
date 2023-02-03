package com.example.restservice.adapter;

import com.example.restservice.model.StarwarChar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class StarWarAdapter {
    @Value("https://swapi.dev/api/people/")
    private String preurl;
    StarwarChar starwarChar;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    JdbcTemplate swjdbcTemplate1;

    public StarwarChar getStarWarChar(int charid){
       String url = preurl + charid +"/";
        StarWarDTO starWarDTO = restTemplate.getForObject(url,StarWarDTO.class);

        return StarwarChar.builder().
                name(starWarDTO.getName()).
                height(starWarDTO.getHeight()).
                mass(starWarDTO.getMass()).
                hairColor(starWarDTO.getHairColor()).
                skinColor(starWarDTO.getSkinColor()).
                eyeColor(starWarDTO.getEyeColor()).
                birthYear(starWarDTO.getBirthYear()).
                gender(starWarDTO.getGender()).
                homeworld(starWarDTO.getHomeworld()).build();


    }

//    public void addStarWarChar(StarwarChar starwarChar){
//        StarWarDTO starWarDTO = restTemplate.getForObject(url,StarWarDTO.class);
//        var  name = starWarDTO.getName();
//        int height=starWarDTO.getHeight();
//        int mass =starWarDTO.getMass();
//        var hairColor=starWarDTO.getHairColor();
//        var skinColor =starWarDTO.getSkinColor();
//        var eyeColor=starWarDTO.getEyeColor();
//        var birthYear=starWarDTO.getBirthYear();
//        var gender = starWarDTO.getGender();
//        var homeworld=starWarDTO.getHomeworld();
//
//        String sql = "INSERT INTO StarwarChar (name,height,mass,hair_color,skin_color,eye_color,birth_year,gender,homeworld) values (?,?,?,?,?,?,?,?)";
//        swjdbcTemplate1.update(sql,name,height,mass,hairColor,skinColor,eyeColor,birthYear,gender,homeworld);
//    }

}
