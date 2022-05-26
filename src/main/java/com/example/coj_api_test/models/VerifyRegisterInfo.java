package com.example.coj_api_test.models;

public class VerifyRegisterInfo {
    private long ekyc;
    private long physical;
    private long ndid;
    private long ddopa;
    private long failed;

    public VerifyRegisterInfo(long ekyc, long physical, long ndid, long ddopa, long failed) {
        this.ekyc = ekyc;
        this.physical = physical;
        this.ndid = ndid;
        this.ddopa = ddopa;
        this.failed = failed;
    }

    public long getekyc() {
        return ekyc;
    }

    public void setekyc(long ekyc) {
        this.ekyc = ekyc;
    }

    public long getPhysical() {
        return physical;
    }

    public void setPhysical(long physical) {
        this.physical = physical;
    }

    public long getNdid() {
        return ndid;
    }

    public void setNdid(long ndid) {
        this.ndid = ndid;
    }

    public long getDdopa() {
        return ddopa;
    }

    public void setDdopa(long ddopa) {
        this.ddopa = ddopa;
    }

    public long getFailed() {
        return failed;
    }

    public void setFailed(long failed) {
        this.failed = failed;
    }
}
