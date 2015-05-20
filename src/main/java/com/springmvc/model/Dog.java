package com.springmvc.model;

/**
 * Created by Administrator on 2015-5-19.
 */
public class Dog {

    public Dog(){}

    public Dog(String name, String species){
        this.name = name;
        this.species = species;
    }

    public Dog(int id, String name, String species){
        this.id = id;
        this.name = name;
        this.species = species;
    }

    private int id;

    private String name;

    private String species;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}
