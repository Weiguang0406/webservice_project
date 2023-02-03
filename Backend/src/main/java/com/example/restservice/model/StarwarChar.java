package com.example.restservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StarwarChar {
    private String name;
    private int height;
    private  int mass;
//    @JsonProperty("hair_color")
    private String hairColor;
//    @JsonProperty("skin_color")
    private String skinColor;
//    @JsonProperty("eye_color")
    private String eyeColor;
//    @JsonProperty("birth_year")
    private String birthYear;
    private String gender;
    private String homeworld;

}
