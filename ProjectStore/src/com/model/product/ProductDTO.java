/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.product;

import java.sql.Timestamp;

/**
 *
 * @author STU-03
 */
public class ProductDTO {
    private int pNo;
    private String pCode;
    private int price;
    private int quantity;
    private int total;
    private String account_code;
    private Timestamp trading_day;
    private int stock;
    private String pName;
    private String item_code;

    public int getpNo() {
        return pNo;
    }

    public String getpCode() {
        return pCode;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getTotal() {
        return total;
    }

    public String getAccount_code() {
        return account_code;
    }

    public Timestamp getTrading_day() {
        return trading_day;
    }

    public int getStock() {
        return stock;
    }

    public String getpName() {
        return pName;
    }

    public String getItem_code() {
        return item_code;
    }

    public void setpNo(int pNo) {
        this.pNo = pNo;
    }

    public void setpCode(String pCode) {
        this.pCode = pCode;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setAccount_code(String account_code) {
        this.account_code = account_code;
    }

    public void setTrading_day(Timestamp trading_day) {
        this.trading_day = trading_day;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public void setItem_code(String item_code) {
        this.item_code = item_code;
    }

    @Override
    public String toString() {
        return "ProductDTO{" + "pNo=" + pNo + ", pCode=" + pCode + ", price=" + price + ", quantity=" + quantity + ", total=" + total + ", account_code=" + account_code + ", trading_day=" + trading_day + ", stock=" + stock + ", pName=" + pName + ", item_code=" + item_code + '}';
    }
    
}
