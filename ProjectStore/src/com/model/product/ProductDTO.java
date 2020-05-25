/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.product;

/**
 *
 * @author STU-03
 */
public class ProductDTO {
    
    private String pcode;
    private String pname;
    private String item_code;
    private int price;
    private int stock;

    public String getPcode() {
        return pcode;
    }

    public String getPname() {
        return pname;
    }

    public String getItem_code() {
        return item_code;
    }

    public int getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public void setItem_code(String item_code) {
        this.item_code = item_code;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "ProductDTO{" + "pcode=" + pcode + ", pname=" + pname + ", item_code=" + item_code + ", price=" + price + ", stock=" + stock + '}';
    }
    
    
    
}
