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
        
    public ArrayList<ProductDTO> searchAll() throws SQLException{
        con = DBUtil.getConnection();
        String sql = "select * from PRODUCT_MGR order by P_MGR_NO";
        ps = con.prepareCall(sql);
        rs = ps.executeQuery();
        list = new ArrayList<>();
        
        while(rs.next()){
            ProductDTO dto = new ProductDTO();
            dto.setpCode(rs.getString(2));
            dto.setpName(rs.getString(9));
            dto.setPrice(rs.getInt(3));
            dto.setStock(rs.getInt(8));
            list.add(dto);
        }
        System.out.println("size="+list.size());
        return list;
    }

    public ProductDTO selectBycode(String str) throws SQLException {
        con = DBUtil.getConnection();
        String sql = "select * from PRODUCT_MGR where PRODUCT_CODE=?";
        ps = con.prepareCall(sql);
        ps.setString(1, str);
        
        rs = ps.executeQuery();
        
        ProductDTO dto = new ProductDTO();
        if(rs.next()){
            dto.setpCode(rs.getString(2));
            dto.setpName(rs.getString(9));
            dto.setPrice(rs.getInt(3));
            dto.setStock(rs.getInt(8));
        }
        System.out.println("dto="+dto + ", 매개변수 str=" + str);
        return dto;
    }
}
