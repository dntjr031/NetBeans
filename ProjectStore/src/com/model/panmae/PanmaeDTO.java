/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.panmae;

import java.sql.Timestamp;

/**
 *
 * @author STU-03
 */
public class PanmaeDTO {

    private int no;
    private String customerId;
    private String pcode;
    private int quantity;
    private int price;
    private String sellerId;
    private Timestamp date;

    public int getNo() {
        return no;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getPcode() {
        return pcode;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public String getSellerId() {
        return sellerId;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "PanmaeDTO{" + "no=" + no + ", customerId=" + customerId + ", pcode=" + pcode + ", quantity=" + quantity + ", price=" + price + ", sellerId=" + sellerId + ", date=" + date + '}';
    }

}
