/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.zipcode;

/**
 *
 * @author Wooseok
 */
public class ZipcodeDTO {
    private String zipcode;
    private String sido;
    private String gugun;
    private String dong;
    private String startbunji;
    private String endbunji;
    private int seq;

    public ZipcodeDTO() {
    }

    public ZipcodeDTO(String zipcode, String sido, String gugun, String dong, String startbunji, String endbunji, int seq) {
        this.zipcode = zipcode;
        this.sido = sido;
        this.gugun = gugun;
        this.dong = dong;
        this.startbunji = startbunji;
        this.endbunji = endbunji;
        this.seq = seq;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getSido() {
        return sido;
    }

    public String getGugun() {
        return gugun;
    }

    public String getDong() {
        return dong;
    }

    public String getStartbunji() {
        return startbunji;
    }

    public String getEndbunji() {
        return endbunji;
    }

    public int getSeq() {
        return seq;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public void setSido(String sido) {
        this.sido = sido;
    }

    public void setGugun(String gugun) {
        this.gugun = gugun;
    }

    public void setDong(String dong) {
        this.dong = dong;
    }

    public void setStartbunji(String startbunji) {
        this.startbunji = startbunji;
    }

    public void setEndbunji(String endbunji) {
        this.endbunji = endbunji;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    @Override
    public String toString() {
        return "ZipcodeDTO{" + "zipcode=" + zipcode + ", sido=" + sido + ", gugun=" + gugun + ", dong=" + dong + ", startbunji=" + startbunji + ", endbunji=" + endbunji + ", seq=" + seq + '}';
    }
   
   
}
