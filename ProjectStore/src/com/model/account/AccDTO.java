/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.account;


/**
 *
 * @author STU-03
 */
public class AccDTO {

    private String code;
    private String accName;
    private String repName;
    private String hp;
    private String zipcode;
    private String address1;
    private String address2;
    private String itemCode;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public String getRepName() {
        return repName;
    }

    public void setRepName(String repName) {
        this.repName = repName;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    @Override
    public String toString() {
        return "AccDTO{" + "code=" + code + ", accName=" + accName + ", repName=" + repName + ", hp=" + hp + ", zipcode=" + zipcode + ", address1=" + address1 + ", address2=" + address2 + ", itemCode=" + itemCode + '}';
    }

}
