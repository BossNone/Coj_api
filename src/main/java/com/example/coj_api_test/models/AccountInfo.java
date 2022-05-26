package com.example.coj_api_test.models;

public class AccountInfo {
    private long alluser;
    private long active;
    private long inactive;

    public AccountInfo(long alluser, long active, long inactive) {
        this.alluser = alluser;
        this.active = active;
        this.inactive = inactive;
    }

    public long getAlluser() {
        return alluser;
    }

    public void setAlluser(long alluser) {
        this.alluser = alluser;
    }

    public long getActive() {
        return active;
    }

    public void setActive(long active) {
        this.active = active;
    }

    public long getInactive() {
        return inactive;
    }

    public void setInactive(long inactive) {
        this.inactive = inactive;
    }
}
