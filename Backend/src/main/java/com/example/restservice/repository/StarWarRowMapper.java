package com.example.restservice.repository;

import com.example.restservice.model.StarwarChar;
import com.example.restservice.model.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StarWarRowMapper implements RowMapper<StarwarChar> {
    @Override
    public StarwarChar mapRow(ResultSet rs, int rowNum) throws SQLException {
        return StarwarChar.builder().name(rs.getString("name")).
                height(rs.getInt("height")).
                mass(rs.getInt("mass")).
                hairColor(rs.getString("hair_color")).
                skinColor(rs.getString("skin_color")).
                eyeColor(rs.getString("eye_color")).
                birthYear(rs.getString("birth_year")).
                gender(rs.getString("gender")).homeworld(rs.getString("homeworld")).build();
    }
}
