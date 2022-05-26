package com.example.coj_api_test.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class Address{

    @Column(name = "Address_buildingnumber",insertable = false,updatable = false)
    private String buildingnumber;
    @Column(name = "Address_village",insertable = false,updatable = false)
    private String village;
    @Column(name = "Address_moo",insertable = false,updatable = false)
    private String moo;
    @Column(name = "Address_soi",insertable = false,updatable = false)
    private String soi;
    @Column(name = "Address_road",insertable = false,updatable = false)
    private String road;
    @Column(name = "Address_subdistrict",insertable = false,updatable = false)
    private String subdistrict;
    @Column(name = "Address_district",insertable = false,updatable = false)
    private String district;
    @Column(name = "Address_province",insertable = false,updatable = false)
    private String province;
    @Column(name = "Address_zipcode",insertable = false,updatable = false)
    private String zipcode;
    @Column(name = "Address_country",insertable = false,updatable = false)
    private String country;

    public String getBuildingnumber() {
        return buildingnumber;
    }

    public void setBuildingnumber(String buildingnumber) {
        this.buildingnumber = buildingnumber;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getMoo() {
        return moo;
    }

    public void setMoo(String moo) {
        this.moo = moo;
    }

    public String getSoi() {
        return soi;
    }

    public void setSoi(String soi) {
        this.soi = soi;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getSubdistrict() {
        return subdistrict;
    }

    public void setSubdistrict(String subdistrict) {
        this.subdistrict = subdistrict;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

