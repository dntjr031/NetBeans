/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.product;

import com.projectstore.db.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author STU-03
 */
public class ProductDAO {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private ArrayList<ProductDTO> list;

    public static final boolean INSERT = true;
    public static final boolean UPDATE = false;

    public ArrayList<ProductDTO> searchAll() throws SQLException {
        try {
            con = DBUtil.getConnection();
            String sql = "select * from PRODUCT order by PCODE";
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            list = new ArrayList<>();

            while (rs.next()) {
                ProductDTO dto = new ProductDTO();
                dto.setPcode(rs.getString(1));
                dto.setPname(rs.getString(2));
                dto.setItem_code(rs.getString(3));
                dto.setPrice(rs.getInt(4));
                dto.setStock(rs.getInt(5));
                list.add(dto);
            }
            System.out.println("size=" + list.size());
            return list;
        } finally {
            DBUtil.dbclose(rs, ps, con);
        }
    }

    public ArrayList<ProductDTO> selectBycode(String str) throws SQLException {
        try {
            con = DBUtil.getConnection();
            String sql = "select * from PRODUCT where PCODE like '%' || ? || '%'";
            ps = con.prepareCall(sql);
            ps.setString(1, str);

            rs = ps.executeQuery();

            list = new ArrayList<>();
            if (rs.next()) {
                ProductDTO dto = new ProductDTO();
                dto.setPcode(rs.getString(1));
                dto.setPname(rs.getString(2));
                dto.setItem_code(rs.getString(3));
                dto.setPrice(rs.getInt(4));
                dto.setStock(rs.getInt(5));
                list.add(dto);
            }
            System.out.println("list=" + list.size() + ", 매개변수 str=" + str);
            return list;
        } finally {
            DBUtil.dbclose(rs, ps, con);
        }
    }

    public ArrayList<ProductDTO> selectByPrice(int price1, int price2) throws SQLException {
        try {
            con = DBUtil.getConnection();
            String sql = "select * from product where price between ? and ? order by pname";
            ps = con.prepareCall(sql);
            ps.setInt(1, price1);
            ps.setInt(2, price2);

            rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                ProductDTO dto = new ProductDTO();
                dto.setPcode(rs.getString(1));
                dto.setPname(rs.getString(2));
                dto.setItem_code(rs.getString(3));
                dto.setPrice(rs.getInt(4));
                dto.setStock(rs.getInt(5));

                list.add(dto);
            }
            System.out.println("list size=" + list.size());
            return list;
        } finally {
            DBUtil.dbclose(rs, ps, con);
        }
    }

    public ArrayList<ProductDTO> selectByName(String val1) throws SQLException {
        try {
            con = DBUtil.getConnection();
            String sql = "select * from product where pname like '%' || ? || '%' order by pname";
            ps = con.prepareCall(sql);
            ps.setString(1, val1);

            rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                ProductDTO dto = new ProductDTO();
                dto.setPcode(rs.getString(1));
                dto.setPname(rs.getString(2));
                dto.setItem_code(rs.getString(3));
                dto.setPrice(rs.getInt(4));
                dto.setStock(rs.getInt(5));

                list.add(dto);
            }
            System.out.println("list size=" + list.size());
            return list;
        } finally {
            DBUtil.dbclose(rs, ps, con);
        }
    }

    public int panmae(String pcode) {
        int n = 0;
        try {
            con = DBUtil.getConnection();

            String sql = "UPDATE PRODUCT\n"
                    + "SET stock = stock - 1\n"
                    + "where pcode = ?";
            ps = con.prepareCall(sql);

            ps.setString(1, pcode);

            n = ps.executeUpdate();
            System.out.println("처리된 행 n = " + n + ", 매개변수 pcode = " + pcode);

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                DBUtil.dbclose(ps, con);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return n;
        }
    }

    public boolean codeCheck(String pcode) throws SQLException {
        boolean check = false;
        try {
            con = DBUtil.getConnection();

            String sql = "select count(*) from product where pcode = ?";
            ps = con.prepareCall(sql);

            ps.setString(1, pcode);
            rs = ps.executeQuery();
            if (rs.next()) {
                int n = rs.getInt(1);

                if (n > 0) {
                    check = UPDATE;
                } else {
                    check = INSERT;
                }
            } else {
                check = INSERT;
            }

            return check;
        } finally {
            DBUtil.dbclose(rs, ps, con);
        }
    }

    public int insert(ProductDTO dtoPro) throws SQLException {
        try {
            con = DBUtil.getConnection();

            String sql = "INSERT INTO product\n"
                    + "VALUES (?,?,?,?,?)";
            ps = con.prepareCall(sql);

            ps.setString(1, dtoPro.getPcode());
            ps.setString(1, dtoPro.getPname());
            ps.setString(1, dtoPro.getItem_code());
            ps.setInt(1, dtoPro.getPrice());
            ps.setInt(1, dtoPro.getStock());

            int n = ps.executeUpdate();
            System.out.println("n=" + n + ", dto=" + dtoPro);
            return n;
        } finally {
            DBUtil.dbclose(ps, con);
        }
    }

    public int stockUpdate(ProductDTO dtoPro) throws SQLException {
        try {
            con = DBUtil.getConnection();

            String sql = "UPDATE product\n"
                    + "set stock = stock + ?\n"
                    + "where pcode = ?";
            ps = con.prepareCall(sql);
            
            ps.setInt(1, dtoPro.getStock());
            ps.setString(2, dtoPro.getPcode());
            
            int n = ps.executeUpdate();
            System.out.println("n="+ n + ", dto=" + dtoPro);
            
            return n;

        } finally {

        }
    }
}
