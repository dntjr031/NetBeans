/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swingapp.member.model;

import java.sql.Timestamp;

/**
 *
 * @author STU-03
 */
public class MemberDTO {

    private int no;
    private String userid;
    private String name;
    private String pwd;
    private String email;
    private String hp;
    private String zipcode;
    private String address1;
    private String address2;
    private Timestamp regdate;

    public int getNo() {
        return no;
    }

    public String getUserid() {
        return userid;
    }

    public String getName() {
        return name;
    }

    public String getPwd() {
        return pwd;
    }

    public String getEmail() {
        return email;
    }

    public String getHp() {
        return hp;
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

    public Timestamp getRegdate() {
        return regdate;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHp(String hp) {
        this.hp = hp;
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

    public void setRegdate(Timestamp regdate) {
        this.regdate = regdate;
    }

    @Override
    public String toString() {
        return "MemberDTO{" + "no=" + no + ", userid=" + userid + ", name=" + name + ", pwd=" + pwd + ", email=" + email + ", hp=" + hp + ", zipcode=" + zipcode + ", address1=" + address1 + ", address2=" + address2 + ", regdate=" + regdate + '}';
    }

    public MemberDTO() {
        super();
    }

    public MemberDTO(int no, String userid, String name, String pwd, String email, String hp, String zipcode, String address1, String address2, Timestamp regdate) {
        this.no = no;
        this.userid = userid;
        this.name = name;
        this.pwd = pwd;
        this.email = email;
        this.hp = hp;
        this.zipcode = zipcode;
        this.address1 = address1;
        this.address2 = address2;
        this.regdate = regdate;
    }

}
