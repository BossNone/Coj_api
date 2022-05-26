package com.example.coj_api_test.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "registrationsession")
public class RegistrationSession {

    @Id
    @Column(name = "_id")
    private String id;
    @Column(name = "token")
    private String token;
    @Column(name = "status")
    private String status;
    @Column(name = "password")
    private String password;
    @Column(name = "idcard")
    private String idcard;
    @Column(name = "typeofuser")
    private String typeofuser;
    @Embedded
    private ClientInfo clientinfo;
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
    @Column(name = "otpreference")
    private String otpreference;
    @Column(name = "otprequestedtime")
    private String otprequestedtime;
    @Column(name = "revoked")
    private boolean revoked;
    @Column(name = "createddate")
    private String createddate;
    @Column(name = "idcardphotobase64")
    private String idcardphotobase64;
    @Column(name = "kyctype")
    private String kyctype;
    @Column(name = "isnewuser")
    private boolean isnewuser;
    @Column(name = "tokenexistingsystem")
    private String tokenexistingsystem;

    public RegistrationSession() {
    }

    public RegistrationSession(String id, String token, String status, String password, String idcard, String typeofuser, ClientInfo clientinfo, Address address, String mobilenumber, String telephone, String email, String fax, String otpreference, String otprequestedtime, boolean revoked, String createddate, String idcardphotobase64, String kyctype, boolean isnewuser, String tokenexistingsystem) {
        this.id = id;
        this.token = token;
        this.status = status;
        this.password = password;
        this.idcard = idcard;
        this.typeofuser = typeofuser;
        this.clientinfo = clientinfo;
        this.address = address;
        this.mobilenumber = mobilenumber;
        this.telephone = telephone;
        this.email = email;
        this.fax = fax;
        this.otpreference = otpreference;
        this.otprequestedtime = otprequestedtime;
        this.revoked = revoked;
        this.createddate = createddate;
        this.idcardphotobase64 = idcardphotobase64;
        this.kyctype = kyctype;
        this.isnewuser = isnewuser;
        this.tokenexistingsystem = tokenexistingsystem;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getTypeofuser() {
        return typeofuser;
    }

    public void setTypeofuser(String typeofuser) {
        this.typeofuser = typeofuser;
    }

    public ClientInfo getClientinfo() {
        return clientinfo;
    }

    public void setClientinfo(ClientInfo clientinfo) {
        this.clientinfo = clientinfo;
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

    public String getOtpreference() {
        return otpreference;
    }

    public void setOtpreference(String otpreference) {
        this.otpreference = otpreference;
    }

    public String getOtprequestedtime() {
        return otprequestedtime;
    }

    public void setOtprequestedtime(String otprequestedtime) {
        this.otprequestedtime = otprequestedtime;
    }

    public boolean isRevoked() {
        return revoked;
    }

    public void setRevoked(boolean revoked) {
        this.revoked = revoked;
    }

    public String getCreateddate() {
        return createddate;
    }

    public void setCreateddate(String createddate) {
        this.createddate = createddate;
    }

    public String getIdcardphotobase64() {
        return idcardphotobase64;
    }

    public void setIdcardphotobase64(String idcardphotobase64) {
        this.idcardphotobase64 = idcardphotobase64;
    }

    public String getKyctype() {
        return kyctype;
    }

    public void setKyctype(String kyctype) {
        this.kyctype = kyctype;
    }

    public boolean isIsnewuser() {
        return isnewuser;
    }

    public void setIsnewuser(boolean isnewuser) {
        this.isnewuser = isnewuser;
    }

    public String getTokenexistingsystem() {
        return tokenexistingsystem;
    }

    public void setTokenexistingsystem(String tokenexistingsystem) {
        this.tokenexistingsystem = tokenexistingsystem;
    }
}

