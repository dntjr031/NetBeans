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
import java.util.ArrayList;

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

    public int login(String id, String pwd) throws SQLException {
        try {
            con = DBUtil.getConnection();
            String sql = "select seller_pwd from seller where seller_id=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                String get = rs.getString(1);
                if (get.equals(pwd)) {
                    System.out.println("로그인 성공, id=" + id + ", pwd=" + pwd);
                    return LOGIN_OK;
                } else {
                    System.out.println("비번틀림, id=" + id + ", pwd=" + pwd);
                    return LOGIN_NOPWD;
                }
            }
            System.out.println("아이디 없음, id=" + id + ", pwd=" + pwd);
            return LOGIN_NOID;
        } finally {
            DBUtil.dbclose(rs, ps, con);
        }
    }

    public int login(String id) throws SQLException {
        try {
            con = DBUtil.getConnection();
            String sql = "select seller_pwd from seller where seller_id=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                String get = rs.getString(1);
                return LOGIN_NOPWD;
            }
            System.out.println("아이디 없음, id=" + id);
            return LOGIN_NOID;
        } finally {
            DBUtil.dbclose(rs, ps, con);
        }
    }

    public SellerDTO selectById(String selId) throws SQLException {
        try {
            con = DBUtil.getConnection();

            String sql = "select * from SELLER where SELLER_ID = ?";
            ps = con.prepareStatement(sql);

            ps.setString(1, selId);

            rs = ps.executeQuery();

            SellerDTO dto = new SellerDTO();
            if (rs.next()) {
                dto.setSeller_id(rs.getString(1));
                dto.setSeller_pwd(rs.getString(2));
                dto.setSeller_name(rs.getString(3));
                dto.setSeller_hp(rs.getString(4));
                dto.setSeller_jumin(rs.getString(5));
                dto.setSeller_gender(rs.getString(6));
                dto.setZipcode(rs.getString(7));
                dto.setAddress1(rs.getString(8));
                dto.setAddress2(rs.getString(9));
                dto.setHiredate(rs.getTimestamp(10));

            }
            return dto;
        } finally {
            DBUtil.dbclose(rs, ps, con);
        }
    }

    public int update(SellerDTO dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int insert(SellerDTO dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<SellerDTO> selectAll() throws SQLException {
        try {
            con = DBUtil.getConnection();

            String sql = "select * from SELLER order by SELLER_NAME";
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            ArrayList<SellerDTO> list = new ArrayList<>();

            while (rs.next()) {
                SellerDTO dto = new SellerDTO();

                dto.setSeller_id(rs.getString(1));
                dto.setSeller_pwd(rs.getString(2));
                dto.setSeller_name(rs.getString(3));
                dto.setSeller_hp(rs.getString(4));
                dto.setSeller_jumin(rs.getString(5));
                dto.setSeller_gender(rs.getString(6));
                dto.setZipcode(rs.getString(7));
                dto.setAddress1(rs.getString(8));
                dto.setAddress2(rs.getString(9));
                dto.setHiredate(rs.getTimestamp(10));

                list.add(dto);

            }

            return list;
        } finally {
            DBUtil.dbclose(rs, ps, con);
        }
    }

    public ArrayList<SellerDTO> selectByName(String name) throws SQLException {
        try {
            con = DBUtil.getConnection();

            String sql = "select * from SELLER where SELLER_NAME like '%' || ? || '%' order by SELLER_NAME";
            ps = con.prepareStatement(sql);

            ps.setString(1, name);

            rs = ps.executeQuery();
            ArrayList<SellerDTO> list = new ArrayList<>();
            while (rs.next()) {
                SellerDTO dto = new SellerDTO();

                dto.setSeller_id(rs.getString(1));
                dto.setSeller_pwd(rs.getString(2));
                dto.setSeller_name(rs.getString(3));
                dto.setSeller_hp(rs.getString(4));
                dto.setSeller_jumin(rs.getString(5));
                dto.setSeller_gender(rs.getString(5));
                dto.setZipcode(rs.getString(6));
                dto.setAddress1(rs.getString(7));
                dto.setAddress2(rs.getString(8));
                dto.setHiredate(rs.getTimestamp(4));

                list.add(dto);
            }
            return list;
        } finally {
            DBUtil.dbclose(rs, ps, con);
        }

    }

    public int delete(String selId) throws SQLException {
        try {
            con = DBUtil.getConnection();

            String sql = "DELETE FROM SELLER WHERE SELLER_ID = ?";
            ps = con.prepareStatement(sql);

            ps.setString(1, selId);

            int n = ps.executeUpdate();
            System.out.println("n=" + n + ", selId=" + selId);
            return n;
        } finally {
            DBUtil.dbclose(ps, con);
        }
    }

}
