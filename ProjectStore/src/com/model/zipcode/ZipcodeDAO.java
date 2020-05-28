/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.zipcode;

import com.projectstore.db.DBUtil;
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
            
            String sql = "select * from zipcode where DONG like '%' || ? || '%' "
                    + "order by START_BUNJI";
            ps = con.prepareCall(sql);
            
            ps.setString(1, dong);
            
            rs = ps.executeQuery();
            while(rs.next()){
                ZipcodeDTO dto = new ZipcodeDTO();
                dto.setDong(rs.getString(5));
                dto.setEndbunji(rs.getString(7));
                dto.setGugun(rs.getString(4));
                dto.setSeq(rs.getInt(1));
                dto.setSido(rs.getString(3));
                dto.setStartbunji(rs.getString(6));
                dto.setZipcode(rs.getString(2));
                
                list.add(dto);
            }
            System.out.println("검색결과 list.size()="+list.size() + ", 매개변수 dong=" + dong);
            return list;
        }finally{
            DBUtil.dbclose(rs, ps, con);
        }
    }
}
