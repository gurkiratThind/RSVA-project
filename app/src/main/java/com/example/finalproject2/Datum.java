
package com.example.finalproject2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("sp_id")
    @Expose
    private Integer spId;
    @SerializedName("sp_name")
    @Expose
    private String spName;
    @SerializedName("sp_image")
    @Expose
    private SpImage spImage;

    public Integer getSpId() {
        return spId;
    }

    public void setSpId(Integer spId) {
        this.spId = spId;
    }

    public String getSpName() {
        return spName;
    }

    public void setSpName(String spName) {
        this.spName = spName;
    }

    public SpImage getSpImage() {
        return spImage;
    }

    public void setSpImage(SpImage spImage) {
        this.spImage = spImage;
    }

}
