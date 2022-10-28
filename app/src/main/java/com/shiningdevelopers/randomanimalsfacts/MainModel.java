package com.shiningdevelopers.randomanimalsfacts;

public class MainModel {
String name,latin_name,animal_type,active_time,length_min,length_max,weight_min;
String weight_max,lifespan,habitat,diet,geo_range,image_link;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLatin_name() {
        return latin_name;
    }

    public void setLatin_name(String latin_name) {
        this.latin_name = latin_name;
    }

    public String getAnimal_type() {
        return animal_type;
    }

    public void setAnimal_type(String animal_type) {
        this.animal_type = animal_type;
    }

    public String getActive_time() {
        return active_time;
    }

    public void setActive_time(String active_time) {
        this.active_time = active_time;
    }

    public String getLength_min() {
        return length_min;
    }

    public void setLength_min(String length_min) {
        this.length_min = length_min;
    }

    public String getLength_max() {
        return length_max;
    }

    public void setLength_max(String length_max) {
        this.length_max = length_max;
    }

    public String getWeight_min() {
        return weight_min;
    }

    public void setWeight_min(String weight_min) {
        this.weight_min = weight_min;
    }

    public String getWeight_max() {
        return weight_max;
    }

    public void setWeight_max(String weight_max) {
        this.weight_max = weight_max;
    }

    public String getLifespan() {
        return lifespan;
    }

    public void setLifespan(String lifespan) {
        this.lifespan = lifespan;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    public String getGeo_range() {
        return geo_range;
    }

    public void setGeo_range(String geo_range) {
        this.geo_range = geo_range;
    }

    public String getImage_link() {
        return image_link;
    }

    public void setImage_link(String image_link) {
        this.image_link = image_link;
    }

    public MainModel(String name, String latin_name, String animal_type, String active_time, String length_min, String length_max, String weight_min, String weight_max, String lifespan, String habitat, String diet, String geo_range, String image_link) {
        this.name = name;
        this.latin_name = latin_name;
        this.animal_type = animal_type;
        this.active_time = active_time;
        this.length_min = length_min;
        this.length_max = length_max;
        this.weight_min = weight_min;
        this.weight_max = weight_max;
        this.lifespan = lifespan;
        this.habitat = habitat;
        this.diet = diet;
        this.geo_range = geo_range;
        this.image_link = image_link;
    }
}
