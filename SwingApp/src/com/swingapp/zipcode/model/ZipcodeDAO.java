/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swingapp.zipcode.model;

import com.swingapp.db.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Wooseok
 */
public class ZipcodeDAO {
    
    public ArrayList<ZipcodeDTO> selectByDong(String dong) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        ArrayList<ZipcodeDTO> list = new ArrayList<>();
        try{
            con = DBUtil.getConnection();
            
            String sql = "select * from zipcode where dong like '%' || ? || '%' "
                    + "order by zipcode";
            ps = con.prepareCall(sql);
            
            ps.setString(1, dong);
            
            rs = ps.executeQuery();
            while(rs.next()){
                ZipcodeDTO dto = new ZipcodeDTO();
                dto.setDong(rs.getString("dong"));
                dto.setEndbunji(rs.getString("endbunji"));
                dto.setGugun(rs.getString("gugun"));
                dto.setSeq(rs.getInt("seq"));
                dto.setSido(rs.getString("sido"));
                dto.setStartbunji(rs.getString("startbunji"));
                dto.setZipcode(rs.getString("zipcode"));
                
                list.add(dto);
            }
            System.out.println("검색결과 list.size()="+list.size() + ", 매개변수 dong=" + dong);
            return list;
        }finally{
            DBUtil.dbclose(rs, ps, con);
        }
    }
}
