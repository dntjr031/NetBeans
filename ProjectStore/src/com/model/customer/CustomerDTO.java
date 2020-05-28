/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.customer;

import java.sql.Timestamp;

/**
 *
 * @author STU-03
 */
public class CustomerDTO {

    private String id;
    private String name;
    private String ph;
    private Timestamp birthday;
    private String gender;
    private String zipcode;
    private String address1;
    private String address2;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPh() {
        return ph;
    }

    public Timestamp getBirthday() {
        return birthday;
    }

    public String getGender() {
        return gender;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" + "id=" + id + ", name=" + name + ", ph=" + ph + ", birthday=" + birthday + ", gender=" + gender + ", zipcode=" + zipcode + ", address1=" + address1 + ", address2=" + address2 + '}';
    }

}
