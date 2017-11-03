package com.uca.apps.isi.nct.models;

/**
 * Created by Deyrin Bonilla on 2/11/2017.
 */

public class AccessToken {

    private String id;
    private int ttl;
    private int userId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTtl() {
        return ttl;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
