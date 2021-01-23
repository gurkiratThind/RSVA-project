
package com.example.finalproject2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datumlist
 {

    @SerializedName("mech_id")
    @Expose
    private Integer mechId;
    @SerializedName("mechname")
    @Expose
    private String mechname;
    @SerializedName("mechemail")
    @Expose
    private String mechemail;
    @SerializedName("opendays")
    @Expose
    private String opendays;
    @SerializedName("opentime")
    @Expose
    private String opentime;
    @SerializedName("closetime")
    @Expose
    private String closetime;
    @SerializedName("mechphoto")
    @Expose
    private Mechphoto mechphoto;
    @SerializedName("shopphoto")
    @Expose
    private Shopphoto shopphoto;
    @SerializedName("phoneno")
    @Expose
    private String phoneno;
    @SerializedName("shopname")
    @Expose
    private String shopname;
    @SerializedName("sp_id")
    @Expose
    private Integer spId;
    @SerializedName("lat")
    @Expose
    private Double lat;
    @SerializedName("long")
    @Expose
    private Double _long;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("shopaddress")
    @Expose
    private String shopaddress;
    @SerializedName("basic_rate")
    @Expose
    private Double basicRate;

    public Integer getMechId() {
        return mechId;
    }

    public void setMechId(Integer mechId) {
        this.mechId = mechId;
    }

    public String getMechname() {
        return mechname;
    }

    public void setMechname(String mechname) {
        this.mechname = mechname;
    }

    public String getMechemail() {
        return mechemail;
    }

    public void setMechemail(String mechemail) {
        this.mechemail = mechemail;
    }

    public String getOpendays() {
        return opendays;
    }

    public void setOpendays(String opendays) {
        this.opendays = opendays;
    }

    public String getOpentime() {
        return opentime;
    }

    public void setOpentime(String opentime) {
        this.opentime = opentime;
    }

    public String getClosetime() {
        return closetime;
    }

    public void setClosetime(String closetime) {
        this.closetime = closetime;
    }

    public Mechphoto getMechphoto() {
        return mechphoto;
    }

    public void setMechphoto(Mechphoto mechphoto) {
        this.mechphoto = mechphoto;
    }

    public Shopphoto getShopphoto() {
        return shopphoto;
    }

    public void setShopphoto(Shopphoto shopphoto) {
        this.shopphoto = shopphoto;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public Integer getSpId() {
        return spId;
    }

    public void setSpId(Integer spId) {
        this.spId = spId;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLong() {
        return _long;
    }

    public void setLong(Double _long) {
        this._long = _long;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getShopaddress() {
        return shopaddress;
    }

    public void setShopaddress(String shopaddress) {
        this.shopaddress = shopaddress;
    }

    public Double getBasicRate() {
        return basicRate;
    }

    public void setBasicRate(Double basicRate) {
        this.basicRate = basicRate;
    }

}
