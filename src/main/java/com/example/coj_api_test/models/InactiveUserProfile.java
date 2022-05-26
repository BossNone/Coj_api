package com.example.coj_api_test.models;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Id;

public class InactiveUserProfile {

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "disableddate")
    private String disableddate;
    @Column(name = "userid")
    private String Userid;
    @Column(name = "idcard")
    private String idcard;
    @Column(name = "gender")
    private String gender;
    @Column(name = "prefix")
    private String prefix;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "prefixenglish")
    private String prefixenglish;
    @Column(name = "firstnameenglish")
    private String firstnameenglish;
    @Column(name = "lastnameenglish")
    private String lastnameenglish;
    @Column(name = "dateofbirth")
    private String dateofbirth;
    @Column(name = "occupation")
    private String occupation;
    @Column(name = "nationality")
    private String nationality;
    @Column(name = "ethnicity")
    private String ethnicity;
    @Embedded
    private Address address;
    @Column(name = "mobilenumber")
    private String mobilenumber;
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "email")
    private String email;
    @Column(name = "fax")
    private String fax;
    @Column(name = "photo")
    private String photo;
    @Column(name = "createddate")
    private String createddate;
    @Column(name = "active")
    private boolean active;
    @Column(name = "activedate")
    private String activedate;
    @Column(name = "pin")
    private String pin;

    InactiveUserProfile() {

    }

    public InactiveUserProfile(String id, String disableddate, String userid, String idcard, String gender, String prefix, String firstname, String lastname, String prefixenglish, String firstnameenglish, String lastnameenglish, String dateofbirth, String occupation, String nationality, String ethnicity, Address address, String mobilenumber, String telephone, String email, String fax, String photo, String createddate, boolean active, String activedate, String pin) {
        this.id = id;
        this.disableddate = disableddate;
        Userid = userid;
        this.idcard = idcard;
        this.gender = gender;
        this.prefix = prefix;
        this.firstname = firstname;
        this.lastname = lastname;
        this.prefixenglish = prefixenglish;
        this.firstnameenglish = firstnameenglish;
        this.lastnameenglish = lastnameenglish;
        this.dateofbirth = dateofbirth;
        this.occupation = occupation;
        this.nationality = nationality;
        this.ethnicity = ethnicity;
        this.address = address;
        this.mobilenumber = mobilenumber;
        this.telephone = telephone;
        this.email = email;
        this.fax = fax;
        this.photo = photo;
        this.createddate = createddate;
        this.active = active;
        this.activedate = activedate;
        this.pin = pin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisableddate() {
        return disableddate;
    }

    public void setDisableddate(String disableddate) {
        this.disableddate = disableddate;
    }

    public String getUserid() {
        return Userid;
    }

    public void setUserid(String userid) {
        Userid = userid;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPrefixenglish() {
        return prefixenglish;
    }

    public void setPrefixenglish(String prefixenglish) {
        this.prefixenglish = prefixenglish;
    }

    public String getFirstnameenglish() {
        return firstnameenglish;
    }

    public void setFirstnameenglish(String firstnameenglish) {
        this.firstnameenglish = firstnameenglish;
    }

    public String getLastnameenglish() {
        return lastnameenglish;
    }

    public void setLastnameenglish(String lastnameenglish) {
        this.lastnameenglish = lastnameenglish;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getCreateddate() {
        return createddate;
    }

    public void setCreateddate(String createddate) {
        this.createddate = createddate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getActivedate() {
        return activedate;
    }

    public void setActivedate(String activedate) {
        this.activedate = activedate;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
