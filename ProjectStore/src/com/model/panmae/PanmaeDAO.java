/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.panmae;

import com.projectstore.db.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author STU-03
 */
public class PanmaeDAO {
    
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public int insertPanmae(PanmaeDTO dto) throws SQLException {
        try{
            con = DBUtil.getConnection();
            
            String sql = "INSERT INTO panmae(PANMAE_NO,CUSTOMER_ID,PCODE,PANMAE_QUANTITY,PRICE,SELLER_ID)\n" +
                                            "VALUES(PANMAE_SEQ.nextval,?,?,?,?,?)";
            ps = con.prepareCall(sql);
            
            ps.setString(1, dto.getCustomerId());
            ps.setString(2, dto.getPcode());
            ps.setInt(3, dto.getQuantity());
            ps.setInt(4, dto.getPrice());
            ps.setString(5, dto.getSellerId());
            
            int n = ps.executeUpdate();
            System.out.println("n="+ n + ", dto=" + dto);
            
            return n;
        }finally{
            DBUtil.dbclose(ps, con);
        }
    }

    public ArrayList<PanmaeDTO> searchAll() {
        try{
            con = DBUtil.getConnection();
            
            String sql = "select * from panmae ORDER BY panmae_date desc";
            ps = con.prepareCall(sql);
            
            rs = ps.executeQuery();
            ArrayList<PanmaeDTO> list = new ArrayList<>();
            while(rs.next()){
                PanmaeDTO dto = new PanmaeDTO();
                dto.setNo(rs.getInt(1));
                dto.setCustomerId(rs.getString(2));
                dto.setPcode(rs.getString(3));
                dto.setQuantity(rs.getInt(4));
                dto.setPrice(rs.getInt(5));
                dto.setSellerId(rs.getString(6));
                dto.setDate(rs.getTimestamp(7));
                
                list.add(dto);
            }
            
            return list;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try {
                DBUtil.dbclose(rs, ps, con);
            } catch (SQLException ex) {
                Logger.getLogger(PanmaeDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
}
