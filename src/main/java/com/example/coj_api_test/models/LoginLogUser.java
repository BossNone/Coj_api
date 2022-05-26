package com.example.coj_api_test.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "loginloguser")
public class LoginLogUser {

    @Id
    @Column(name = "_id")
    private String id;
    @Column(name = "userid")
    private String userid;
    @Column(name = "idcard")
    private String idcard;
    @Column(name = "systemname")
    private String systemname;
    @Column(name = "createdate")
    private String createddate;
    @Column(name = "status")
    private boolean status;
    @Column(name = "timestamp")
    private String timestamp;
    @Column(name = "logintype")
    private String logintype;

    public LoginLogUser() {
    }

    public LoginLogUser(String id, String userid, String idcard, String systemname, String createddate, boolean status, String timestamp, String logintype) {
        this.id = id;
        this.userid = userid;
        this.idcard = idcard;
        this.systemname = systemname;
        this.createddate = createddate;
        this.status = status;
        this.timestamp = timestamp;
        this.logintype = logintype;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getSystemname() {
        return systemname;
    }

    public void setSystemname(String systemname) {
        this.systemname = systemname;
    }

    public String getCreateddate() {
        return createddate;
    }

    public void setCreateddate(String createddate) {
        this.createddate = createddate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getLogintype() {
        return logintype;
    }

    public void setLogintype(String logintype) {
        this.logintype = logintype;
    }
}
