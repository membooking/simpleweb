package com.enet.io.lppage.webapp.model;

public class VstResponse {
    /*
        serialnumber of vst device
     */
    private String serialnumber;
    private String patientid;
    private String fullname;
    /*
        reqid is the ID will be included in the response
     */
    private String reqid;
    /*
        vitalsign is one of BL,SP,TE
     */
    private String vitalsign;
    private String value;
    private String time;

    public VstResponse() {
    }

    public VstResponse(VstRequest v) {
        setSerialnumber(v.getSerialnumber());
        setPatientid(v.getPatientid());
        setFullname(v.getFullname());
        setReqid(v.getReqid());
        setVitalsign(v.getVitalsign());
        setTime(v.getTime());
    }

    public String getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
    }

    public String getPatientid() {
        return patientid;
    }

    public void setPatientid(String patientid) {
        this.patientid = patientid;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getReqid() {
        return reqid;
    }

    public void setReqid(String reqid) {
        this.reqid = reqid;
    }

    public String getVitalsign() {
        return vitalsign;
    }

    public void setVitalsign(String vitalsign) {
        this.vitalsign = vitalsign;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
