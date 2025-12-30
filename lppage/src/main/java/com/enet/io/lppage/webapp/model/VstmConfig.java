package com.enet.io.lppage.webapp.model;

public class VstmConfig {
    private String apisite_code;
    private String mq_url;
    private String mq_port;
    private String mq_user;
    private String mq_pass;
    private String mq_clientid;
    private String grant_type;
    private String vstm_endpoint;
    private String vstm_access_token;
    private String vstm_expire_time;
    private String his_endpoint;
    private String his_access_token;
    private String his_expire_time;

    public String getMq_url() {
        return mq_url;
    }

    public void setMq_url(String mq_url) {
        this.mq_url = mq_url;
    }

    public String getMq_port() {
        return mq_port;
    }

    public void setMq_port(String mq_port) {
        this.mq_port = mq_port;
    }

    public String getMq_user() {
        return mq_user;
    }

    public void setMq_user(String mq_user) {
        this.mq_user = mq_user;
    }

    public String getMq_pass() {
        return mq_pass;
    }

    public void setMq_pass(String mq_pass) {
        this.mq_pass = mq_pass;
    }

    public String getMq_clientid() {
        return mq_clientid;
    }

    public void setMq_clientid(String mq_clientid) {
        this.mq_clientid = mq_clientid;
    }

    public String getVstm_endpoint() {
        return vstm_endpoint;
    }

    public void setVstm_endpoint(String vstm_endpoint) {
        this.vstm_endpoint = vstm_endpoint;
    }

    public String getVstm_access_token() {
        return vstm_access_token;
    }

    public void setVstm_access_token(String vstm_access_token) {
        this.vstm_access_token = vstm_access_token;
    }

    public String getVstm_expire_time() {
        return vstm_expire_time;
    }

    public void setVstm_expire_time(String vstm_expire_time) {
        this.vstm_expire_time = vstm_expire_time;
    }

    public String getHis_endpoint() {
        return his_endpoint;
    }

    public void setHis_endpoint(String his_endpoint) {
        this.his_endpoint = his_endpoint;
    }

    public String getHis_access_token() {
        return his_access_token;
    }

    public void setHis_access_token(String his_access_token) {
        this.his_access_token = his_access_token;
    }

    public String getHis_expire_time() {
        return his_expire_time;
    }

    public void setHis_expire_time(String his_expire_time) {
        this.his_expire_time = his_expire_time;
    }

    public String getGrant_type() {
        return grant_type;
    }

    public void setGrant_type(String grant_type) {
        this.grant_type = grant_type;
    }

    public String getApisite_code() {
        return apisite_code;
    }

    public void setApisite_code(String apisite_code) {
        this.apisite_code = apisite_code;
    }
}
