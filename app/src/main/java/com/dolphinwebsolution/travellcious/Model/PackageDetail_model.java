package com.dolphinwebsolution.travellcious.Model;

/**
 * Created by ap6 on 30/8/18.
 */

public class PackageDetail_model {
    String PackageId;
    String Category_id;
    String Category_name;
    String Location_id;
    String package_title;
    String Package_Description;
    String budget;
    String best_time_to_visit;
    String features;
    String Package_isActive;
    String package_image;
    String Hotel_id;
    String Hotel_title;
    String Hotel_description;
    String Hotel_rooms_type;
    String Meals;
    String address;
    String Inclusions;
    String Exclusions;
    String Hotel_images;
    String CHECK_IN;

    public String getCHECK_IN() {
        return CHECK_IN;
    }

    public void setCHECK_IN(String CHECK_IN) {
        this.CHECK_IN = CHECK_IN;
    }

    public String getCHECK_OUT() {
        return CHECK_OUT;
    }

    public void setCHECK_OUT(String CHECK_OUT) {
        this.CHECK_OUT = CHECK_OUT;
    }

    String CHECK_OUT;

    public PackageDetail_model(String packageId, String category_id,
                               String category_name, String location_id,
                               String package_title, String package_Description,
                               String budget, String best_time_to_visit,
                               String features, String package_isActive,
                               String package_image, String hotel_id,
                               String hotel_title, String hotel_description,
                               String hotel_rooms_type, String meals, String address,
                               String inclusions, String exclusions, String hotel_images,
                               String CHECK_IN, String CHECK_OUT) {
        this.PackageId = packageId;
        this.Category_id = category_id;
        this.Category_name = category_name;
        this.Location_id = location_id;
        this.package_title = package_title;
        this.Package_Description = package_Description;
        this.budget = budget;
        this.best_time_to_visit = best_time_to_visit;
        this.features = features;
        this.Package_isActive = package_isActive;
        this.package_image = package_image;
        this.Hotel_id = hotel_id;
        this.Hotel_title = hotel_title;
        this.Hotel_description = hotel_description;
        this.Hotel_rooms_type = hotel_rooms_type;
        this.Meals = meals;
        this.address = address;
        this.Inclusions = inclusions;
        this.Exclusions = exclusions;
        this.Hotel_images = hotel_images;
        this.CHECK_IN = CHECK_IN;
        this.CHECK_OUT = CHECK_OUT;
    }

    public String getHotel_images() {

        return Hotel_images;
    }

    public void setHotel_images(String hotel_images) {
        Hotel_images = hotel_images;
    }


    public String getPackageId() {
        return PackageId;
    }

    public void setPackageId(String packageId) {
        PackageId = packageId;
    }

    public String getCategory_id() {
        return Category_id;
    }

    public void setCategory_id(String category_id) {
        Category_id = category_id;
    }

    public String getCategory_name() {
        return Category_name;
    }

    public void setCategory_name(String category_name) {
        Category_name = category_name;
    }

    public String getLocation_id() {
        return Location_id;
    }

    public void setLocation_id(String location_id) {
        Location_id = location_id;
    }

    public String getPackage_title() {
        return package_title;
    }

    public void setPackage_title(String package_title) {
        this.package_title = package_title;
    }

    public String getPackage_Description() {
        return Package_Description;
    }

    public void setPackage_Description(String package_Description) {
        Package_Description = package_Description;
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

    public String getPackage_isActive() {
        return Package_isActive;
    }

    public void setPackage_isActive(String package_isActive) {
        Package_isActive = package_isActive;
    }

    public String getPackage_image() {
        return package_image;
    }

    public void setPackage_image(String package_image) {
        this.package_image = package_image;
    }

    public String getHotel_id() {
        return Hotel_id;
    }

    public void setHotel_id(String hotel_id) {
        Hotel_id = hotel_id;
    }

    public String getHotel_title() {
        return Hotel_title;
    }

    public void setHotel_title(String hotel_title) {
        Hotel_title = hotel_title;
    }

    public String getHotel_description() {
        return Hotel_description;
    }

    public void setHotel_description(String hotel_description) {
        Hotel_description = hotel_description;
    }

    public String getHotel_rooms_type() {
        return Hotel_rooms_type;
    }

    public void setHotel_rooms_type(String hotel_rooms_type) {
        Hotel_rooms_type = hotel_rooms_type;
    }

    public String getMeals() {
        return Meals;
    }

    public void setMeals(String meals) {
        Meals = meals;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getInclusions() {
        return Inclusions;
    }

    public void setInclusions(String inclusions) {
        Inclusions = inclusions;
    }

    public String getExclusions() {
        return Exclusions;
    }

    public void setExclusions(String exclusions) {
        Exclusions = exclusions;
    }


}




