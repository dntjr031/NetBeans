/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.promgr;

import java.sql.Timestamp;

/**
 *
 * @author STU-03
 */
public class ProMgrDTO {

    private int no;
    private String pcode;
    private int price;
    private int quantity;
    private int totalPrice;
    private String accCode;
    private Timestamp tradingDay;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getAccCode() {
        return accCode;
    }

    public void setAccCode(String accCode) {
        this.accCode = accCode;
    }

    public Timestamp getTradingDay() {
        return tradingDay;
    }

    public void setTradingDay(Timestamp tradingDay) {
        this.tradingDay = tradingDay;
    }

    @Override
    public String toString() {
        return "ProMgrDTO{" + "no=" + no + ", pcode=" + pcode + ", price=" + price + ", quantity=" + quantity + ", totalPrice=" + totalPrice + ", accCode=" + accCode + ", tradingDay=" + tradingDay + '}';
    }

}
