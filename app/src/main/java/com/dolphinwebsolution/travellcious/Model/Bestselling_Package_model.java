package com.dolphinwebsolution.travellcious.Model;

/**
 * Created by ap6 on 5/9/18.
 */

public class Bestselling_Package_model {
    String package_title,description,duration,budget,best_time_to_visit,night,
            category_id,location_id,features,Category_Name,Location_Name,package_images,id;


    public String getPackage_title() {
        return package_title;
    }

    public void setPackage_title(String package_title) {
        this.package_title = package_title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getBest_time_to_visit() {
        return best_time_to_visit;
    }

    public void setBest_time_to_visit(String best_time_to_visit) {
        this.best_time_to_visit = best_time_to_visit;
    }

    public String getNight() {
        return night;
    }

    public void setNight(String night) {
        this.night = night;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getLocation_id() {
        return location_id;
    }

    public void setLocation_id(String location_id) {
        this.location_id = location_id;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getCategory_Name() {
        return Category_Name;
    }

    public void setCategory_Name(String category_Name) {
        Category_Name = category_Name;
    }

    public String getLocation_Name() {
        return Location_Name;
    }

    public void setLocation_Name(String location_Name) {
        Location_Name = location_Name;
    }

    public String getPackage_images() {
        return package_images;
    }

    public void setPackage_images(String package_images) {
        this.package_images = package_images;
    }

    public Bestselling_Package_model(String package_title, String description,
                                     String duration, String budget,
                                     String best_time_to_visit,
                                     String night, String category_id,
                                     String location_id,
                                     String features, String category_Name,
                                     String location_Name,
                                     String package_images,String id) {
        this.package_title = package_title;
        this.description = description;
        this.duration = duration;
        this.budget = budget;
        this.best_time_to_visit = best_time_to_visit;
        this.night = night;
        this.category_id = category_id;
        this.location_id = location_id;
        this.features = features;
        Category_Name = category_Name;
        Location_Name = location_Name;
        this.package_images = package_images;
        this.id = id;
    }
}
