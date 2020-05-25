/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.seller;

import com.projectstore.db.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author STU-03
 */
public class SellerDAO {
    public static final int LOGIN_OK = 1;
    public static final int LOGIN_NOID = 2;
    public static final int LOGIN_NOPWD = 3;
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    
   public int login(String id, String pwd) throws SQLException{
       con = DBUtil.getConnection();
       String sql = "select seller_pwd from seller where seller_id=?";
       ps = con.prepareStatement(sql);
       ps.setString(1, id);
       rs = ps.executeQuery();
       if(rs.next()){
           String get = rs.getString(1);
           if(get.equals(pwd)){
               System.out.println("로그인 성공, id=" + id + ", pwd=" + pwd);
               return LOGIN_OK;
           }else{
               System.out.println("비번틀림, id=" + id + ", pwd=" + pwd);
               return LOGIN_NOPWD;
           }
       }
       System.out.println("아이디 없음, id=" + id + ", pwd=" + pwd);
       return LOGIN_NOID;
   }
}
