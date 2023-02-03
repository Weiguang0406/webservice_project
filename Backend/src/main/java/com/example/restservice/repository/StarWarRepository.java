package com.example.restservice.repository;

import com.example.restservice.adapter.StarWarAdapter;
import com.example.restservice.model.StarwarChar;
import com.example.restservice.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StarWarRepository {

    @Autowired
    JdbcTemplate swjdbcTemplate;
@Autowired
private StarWarAdapter starWarAdapter;
    public List<StarwarChar> getStarWarCharFromDb(){
        return swjdbcTemplate.query("SELECT name,height,mass,hair_color,skin_color,eye_color,birth_year,gender,homeworld FROM StarwarChar",new StarWarRowMapper());
    }
//    public void addStarWarChar(StarwarChar starwarChar){
//        String  name = starwarChar.getName();
//        int height=starwarChar.getHeight();
//        int mass =starwarChar.getMass();
//        var hairColor=starwarChar.getHairColor();
//        var skinColor =starwarChar.getSkinColor();
//        var eyeColor=starwarChar.getEyeColor();
//        var birthYear=starwarChar.getBirthYear();
//        var gender = starwarChar.getGender();
//        var homeworld=starwarChar.getHomeworld();
//
//        String sql = "INSERT INTO starwarcharactor (name,height,mass,hair_color,skin_color,eye_color,birth_year,gender,homeworld) values (?,?,?,?,?,?,?,?,?)";
//        swjdbcTemplate.update(sql,name,height,mass,hairColor,skinColor,eyeColor,birthYear,gender,homeworld);
//    }


        public void addStarWarChar(int charid){
        String  name = starWarAdapter.getStarWarChar(charid).getName();
        int height=starWarAdapter.getStarWarChar(charid).getHeight();
        int mass =starWarAdapter.getStarWarChar(charid).getMass();
        var hairColor=starWarAdapter.getStarWarChar(charid).getHairColor();
        var skinColor =starWarAdapter.getStarWarChar(charid).getSkinColor();
        var eyeColor=starWarAdapter.getStarWarChar(charid).getEyeColor();
        var birthYear=starWarAdapter.getStarWarChar(charid).getBirthYear();
        var gender = starWarAdapter.getStarWarChar(charid).getGender();
        var homeworld=starWarAdapter.getStarWarChar(charid).getHomeworld();

        String sql = "INSERT INTO StarwarChar (name,height,mass,hair_color,skin_color,eye_color,birth_year,gender,homeworld) values (?,?,?,?,?,?,?,?,?)";
        swjdbcTemplate.update(sql,name,height,mass,hairColor,skinColor,eyeColor,birthYear,gender,homeworld);
    }


}
