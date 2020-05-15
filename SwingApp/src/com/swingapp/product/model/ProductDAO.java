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
import java.util.Vector;

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
    
    /**
     * 
     * @param no
     * @return
     * @throws SQLException 
     */
    public ProductDTO selectByNo(int no) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ProductDTO dto = new ProductDTO();
        
        try{
        //1,2
            con = DBUtil.getConnection();
        //3
            String sql = "select * from product where no = ?";
            ps = con.prepareCall(sql);
            ps.setInt(1, no);
            
        //4
            rs = ps.executeQuery();
            if(rs.next()){
                String pdName = rs.getString("productname");
                int price = rs.getInt("price");
                
                dto.setNo(no);
                dto.setPrice(price);
                dto.setProductName(pdName);
                dto.setRegDate(rs.getTimestamp("regdate"));
                dto.setDescription(rs.getString("description"));
            }
            System.out.println("번호로 조회 결과, dto=" + dto
                + ", 매개변수 no=" + no);
            return dto;
            
        }finally{
            DBUtil.dbclose(rs, ps, con);
        }
        
    }
    
    public int editProduct(ProductDTO dto) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            //1,2
            con = DBUtil.getConnection();
            //3
            String sql = "update product\n" +
                    "set PRODUCTNAME= ?, PRICE=?, DESCRIPTION=?\n" +
                    "where no = ?";
            ps = con.prepareStatement(sql);
            
            ps.setString(1, dto.getProductName());
            ps.setInt(2, dto.getPrice());
            ps.setString(3, dto.getDescription());
            ps.setInt(4, dto.getNo());
            
            //4
            int cnt = ps.executeUpdate();
            System.out.println("상품 수정 결과 매개변수 dto=" + dto + ", 반환 cnt=" + cnt);
            
            return cnt;
        }finally{
            DBUtil.dbclose(ps, con);
        }
    }
    
    public Vector<String> selectPdName() throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            con = DBUtil.getConnection();
            
            String sql = "select distinct PRODUCTNAME from product";
            ps = con.prepareCall(sql);
            
            rs = ps.executeQuery();
            Vector<String> list = new Vector<>();
            while(rs.next()){
                String pdName = rs.getString(1);
                
                list.add(pdName);
            }
            System.out.println("상품명 검색 결과, list.size=" + list.size());
            
            return list;
        }finally{
            DBUtil.dbclose(rs, ps, con);
        }
    }
    
    public ArrayList<ProductDTO> selectByPrice(int price1, int price2) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        ArrayList<ProductDTO> list = new ArrayList<>();
        try {
            //1.2
            con = DBUtil.getConnection();
            
            String sql = "select * from product where price between ? and ?";
            ps = con.prepareCall(sql);
            
            ps.setInt(1, price1);
            ps.setInt(2, price2);
            //3
            rs = ps.executeQuery();
            while (rs.next()) {
                ProductDTO dto = new ProductDTO();
                dto.setDescription(rs.getString("description"));
                dto.setNo(rs.getInt(1));
                dto.setPrice(rs.getInt("price"));
                dto.setProductName(rs.getString("productname"));
                dto.setRegDate(rs.getTimestamp(5));
                
                list.add(dto);
                
            }
            System.out.println("조회 완료 price1=" + price1 + ", price2=" + price2 +""
                    + ", 반환 list=" + list);
            return list;
        } finally {
            DBUtil.dbclose(rs, ps, con);
        }
    }
}
