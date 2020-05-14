/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swingapp.product.model;

import com.swingapp.db.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author STU-03
 */
public class ProductDAO {
    
    public ArrayList<ProductDTO> selectAll() throws SQLException{
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            
            ArrayList<ProductDTO> list = new ArrayList<>();
            
        try {
            //1, 2
            con = DBUtil.getConnection();
            //3
            String sql = "select * from product order by no desc";
            ps = con.prepareStatement(sql);
            
            //4
            rs = ps.executeQuery();
            while(rs.next()){
                int no = rs.getInt(1);
                String pdName = rs.getString(2);
                int price = rs.getInt(3);
                String desc = rs.getString(4);
                Timestamp regdate = rs.getTimestamp(5);
                
                ProductDTO dto = new ProductDTO(no, pdName, price, desc,regdate);
                
                list.add(dto);
            }
            return list;
        } finally{
            DBUtil.dbclose(rs, ps, con);
        }
        
    }
    
    public int insertPd(ProductDTO dto) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        
        try {
            //1,2
            con = DBUtil.getConnection();
            //3
            String sql = "insert into product(no, productname, price, description)\n" +
                        "values(product_seq.nextval, ?, ?, ?)";
            ps = con.prepareCall(sql);
            
            ps.setString(1, dto.getProductName());
            ps.setInt(2, dto.getPrice());
            ps.setString(3, dto.getDescription());
            //4
            int cnt = ps.executeUpdate();
            System.out.println("상품 입력 결과, cnt=" + cnt + ", 매개변수 dto=" + dto);
            
            return cnt;
        }finally {
            DBUtil.dbclose(ps, con);
        }
    }
}
