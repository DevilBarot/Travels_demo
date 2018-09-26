package com.dolphinwebsolution.travellcious.Model;

/**
 * Created by ap6 on 9/8/18.
 */

public class Sub_cat_model {
   // String icon,image,name;
    String Category_Name,Location_id,Location_title,isActive,Starting_budget,location_image;

    public Sub_cat_model(String category_Name, String location_id, String location_title,
                         String isActive, String starting_budget, String location_image) {
        Category_Name = category_Name;
        Location_id = location_id;
        Location_title = location_title;
        this.isActive = isActive;
        Starting_budget = starting_budget;
        this.location_image = location_image;
    }

    public String getCategory_Name() {

        return Category_Name;
    }

    public void setCategory_Name(String category_Name) {
        Category_Name = category_Name;
    }

    public String getLocation_id() {
        return Location_id;
    }

    public void setLocation_id(String location_id) {
        Location_id = location_id;
    }

    public String getLocation_title() {
        return Location_title;
    }

    public void setLocation_title(String location_title) {
        Location_title = location_title;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getStarting_budget() {
        return Starting_budget;
    }

    public void setStarting_budget(String starting_budget) {
        Starting_budget = starting_budget;
    }

    public String getLocation_image() {
        return location_image;
    }

    public void setLocation_image(String location_image) {
        this.location_image = location_image;
    }
}
