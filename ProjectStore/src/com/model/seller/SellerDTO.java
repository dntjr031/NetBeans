/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.seller;

import java.sql.Timestamp;

/**
 *
 * @author STU-03
 */
public class SellerDTO {
    private String seller_id;
    private String seller_pwd;
    private String seller_name;
    private String seller_hp;
    private String seller_jumin;
    private String seller_gender;
    private String zipcode;
    private String address1;
    private String address2;
    private Timestamp hiredate;

    public String getSeller_id() {
        return seller_id;
    }

    public String getSeller_pwd() {
        return seller_pwd;
    }

    public String getSeller_name() {
        return seller_name;
    }

    public String getSeller_hp() {
        return seller_hp;
    }

    public String getSeller_jumin() {
        return seller_jumin;
    }

    public String getSeller_gender() {
        return seller_gender;
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

    public Timestamp getHiredate() {
        return hiredate;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id;
    }

    public void setSeller_pwd(String seller_pwd) {
        this.seller_pwd = seller_pwd;
    }

    public void setSeller_name(String seller_name) {
        this.seller_name = seller_name;
    }

    public void setSeller_hp(String seller_hp) {
        this.seller_hp = seller_hp;
    }

    public void setSeller_jumin(String seller_jumin) {
        this.seller_jumin = seller_jumin;
    }

    public void setSeller_gender(String seller_gender) {
        this.seller_gender = seller_gender;
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

    public void setHiredate(Timestamp hiredate) {
        this.hiredate = hiredate;
    }

    @Override
    public String toString() {
        return "SellerDTO{" + "seller_id=" + seller_id + ", seller_pwd=" + seller_pwd + ", seller_name=" + seller_name + ", seller_hp=" + seller_hp + ", seller_jumin=" + seller_jumin + ", seller_gender=" + seller_gender + ", zipcode=" + zipcode + ", address1=" + address1 + ", address2=" + address2 + ", hiredate=" + hiredate + '}';
    }
    
}
