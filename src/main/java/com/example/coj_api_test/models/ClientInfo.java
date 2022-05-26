package com.example.coj_api_test.models;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class ClientInfo {

    @Column(name = "Clientinfo_prefixname")
    private String prefixName;
    @Column(name = "Clientinfo_firstname")
    private String firstname;
    @Column(name = "Clientinfo_lastname")
    private String lastname;
    @Column(name = "Clientinfo_dateofbirth")
    private String dateofbirth;
    @Column(name = "Clientinfo_nationality")
    private String nationality;
    @Column(name = "Clientinfo_ethnicity")
    private String ethnicity;

    public String getPrefixName() {
        return prefixName;
    }

    public void setPrefixName(String prefixName) {
        this.prefixName = prefixName;
    }

    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String firstName) {
        this.firstname = firstName;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastName) {
        this.lastname = lastName;
    }

    public String getDateOfBirth() {
        return dateofbirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateofbirth = dateOfBirth;
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
}
