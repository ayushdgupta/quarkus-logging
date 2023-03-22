package com.guptaji.entity;

import java.util.List;

public class BankEntity {

    private int id;
    private String name;
    private String ifsc;
    private String city;
    private List<String> allowedAccount;

    public BankEntity(int id, String name, String IFSC, String city, List<String> allowedAccount) {
        this.id = id;
        this.name = name;
        this.ifsc = IFSC;
        this.city = city;
        this.allowedAccount = allowedAccount;
    }

    public BankEntity() {
        // default constructor
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIFSC() {
        return ifsc;
    }

    public void setIFSC(String IFSC) {
        this.ifsc = IFSC;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<String> getAllowedAccount() {
        return allowedAccount;
    }

    public void setAllowedAccount(List<String> allowedAccount) {
        this.allowedAccount = allowedAccount;
    }

    @Override
    public String toString() {
        return "BankEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", IFSC='" + ifsc + '\'' +
                ", city='" + city + '\'' +
                ", allowedAccount=" + allowedAccount +
                '}';
    }
}
