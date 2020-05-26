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

/**
 *
 * @author STU-03
 */
public class ProductDAO {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private ArrayList<ProductDTO> list;

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
}
