package com.dolphinwebsolution.travellcious.Model;

public class sliderimage_model {

    String imageurl,packege_id;


    public sliderimage_model(String imageurl,String packege_id) {
        this.imageurl = imageurl;
        this.packege_id = packege_id;
    }

    public String getPackege_id() {
        return packege_id;
    }

    public void setPackege_id(String packege_id) {
        this.packege_id = packege_id;
    }



    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
}
