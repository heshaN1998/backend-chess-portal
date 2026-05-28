package com.checkmate_portal.chessclub.dtos;

import com.checkmate_portal.chessclub.enums.Level;
import jakarta.validation.constraints.*;

public class PlayerRequestDTO {
    @NotBlank(message = "name is required")
    @Size(min = 2,max = 30,message = "name must be 2-30 letters")
    private String name;
    @NotBlank(message = "country is required")
    private String country;
    @NotNull(message = "age must required")
    @Min(value = 4,message = "Age must be at least 4")
    @Max(value = 60,message = "Age must be less than 60")
    private Integer age;
    private Integer fideRating;
    @NotNull(message = "required experienced years")
    private Integer experienceYears;
    @NotNull(message ="BEGGINER|INTERMEDIATE|EXPERT")
    private Level level;

    public PlayerRequestDTO(){

    }
    public PlayerRequestDTO(String name,String country,Integer age,Integer fideRating,Integer experienceYears,Level level){
        this.name=name;
        this.country=country;
        this.age=age;
        this.fideRating=fideRating;
        this.experienceYears=experienceYears;
        this.level=level;
    }

    public String getName() {
        return name;
    }
    public String getCountry() {
        return country;
    }
    public Integer getAge() {
        return age;
    }
    public Integer getFideRating() {
        return fideRating;
    }
    public Integer getExperienceYears() {
        return experienceYears;
    }
    public Level getLevel() {
        return level;
    }


    public void setName(String name) {
        this.name = name;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public void setFideRating(Integer fideRating) {
        this.fideRating = fideRating;
    }
    public void setExperienceYears(Integer experienceYears) {
        this.experienceYears = experienceYears;
    }
    public void setLevel(Level level) {
        this.level = level;
    }
}
