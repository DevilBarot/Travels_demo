package com.dolphinwebsolution.travellcious.Model;

/**
 * Created by ap6 on 27/8/18.
 */

public class Destionation_model {
    String id;
    String category_id;
    String location_id;
    String package_title;
    String description;
    String budget;
    String best_time_to_visit;
    String features;
    String isActive;
    String include_hotels;
    String Location_Name,package_images;
    String UpdatedAt;
    String Category_Name;
    public String getPackage_images() {
        return package_images;
    }

    public void setPackage_images(String package_images) {
        this.package_images = package_images;
    }

    public Destionation_model(String id, String category_id,
                              String location_id, String package_title,
                              String description, String budget,
                              String best_time_to_visit, String features,
                              String isActive,
                              String Location_Name, String updatedAt, String category_Name, String package_images) {
        this.id = id;
        this.category_id = category_id;
        this.location_id = location_id;
        this.package_title = package_title;
        this.description = description;
        this.budget = budget;
        this.best_time_to_visit = best_time_to_visit;
        this.features = features;
        this.isActive = isActive;
        this.Location_Name = Location_Name;
        this.UpdatedAt = updatedAt;
        this.Category_Name = category_Name;
        this.package_images = package_images;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getPackage_title() {
        return package_title;
    }

    public void setPackage_title(String package_title) {
        this.package_title = package_title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getInclude_hotels() {
        return include_hotels;
    }

    public void setInclude_hotels(String include_hotels) {
        this.include_hotels = include_hotels;
    }

    public String getLocation_Name() {
        return Location_Name;
    }

    public void setLocation_Name(String location_Name) {
        Location_Name = location_Name;
    }

    public String getUpdatedAt() {
        return UpdatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        UpdatedAt = updatedAt;
    }

    public String getCategory_Name() {
        return Category_Name;
    }

    public void setCategory_Name(String category_Name) {
        Category_Name = category_Name;
    }


}
