package com.dolphinwebsolution.travellcious.Model;

/**
 * Created by ap6 on 8/8/18.
 */

public class Category_model {
    private String id,img_cat,txtcatnm;

    public Category_model(String id, String img_cat, String txtcatnm) {
        this.id = id;
        this.img_cat = img_cat;
        this.txtcatnm = txtcatnm;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImg_cat() {
        return img_cat;
    }

    public void setImg_cat(String img_cat) {
        this.img_cat = img_cat;
    }

    public String getTxtcatnm() {
        return txtcatnm;
    }

    public void setTxtcatnm(String txtcatnm) {
        this.txtcatnm = txtcatnm;
    }
}
