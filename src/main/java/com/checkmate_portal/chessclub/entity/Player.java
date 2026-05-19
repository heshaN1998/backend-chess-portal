package com.checkmate_portal.chessclub.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;
    private Integer age;
    private Integer fideRating;
    private Integer experienceYears;
    private String level;

    public Player() {
    }

    public Player(Long id, String name, String country, Integer age, Integer fideRating, Integer experienceYears, String level) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.age = age;
        this.fideRating = fideRating;
        this.experienceYears = experienceYears;
        this.level = level;
    }

    public Long getId() {
        return id;
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

    public String getLevel() {
        return level;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setLevel(String level) {
        this.level = level;
    }
}





