/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.account;

import com.model.item.ItemDTO;
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
public class AccDAO {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public ArrayList<AccDTO> selectAll() throws SQLException {
        try {
            con = DBUtil.getConnection();
            
            String sql = "select account_name, rep_name, address1, ACCOUNT_CODE from account order by account_name";
            ps = con.prepareCall(sql);
            
            rs = ps.executeQuery();
            
            ArrayList<AccDTO> list = new ArrayList<>();
            while(rs.next()){
                AccDTO dto = new AccDTO();
                dto.setAccName(rs.getString(1));
                dto.setRepName(rs.getString(2));
                dto.setAddress1(rs.getString(3));
                dto.setCode(rs.getString(4));
                
                list.add(dto);
            }
            
            return list;
        } finally {
            DBUtil.dbclose(rs, ps, con);
        }
    }

    public ArrayList<AccDTO> selectByName(String name) throws SQLException {
        try {
            con = DBUtil.getConnection();
            
            String sql = "select account_name, rep_name, address1, ACCOUNT_CODE from account where account_name like '%' || ? || '%' order by account_name";
            ps = con.prepareCall(sql);
            
            ps.setString(1, name);
            
            rs = ps.executeQuery();
            
            ArrayList<AccDTO> list = new ArrayList<>();
            while(rs.next()){
                AccDTO dto = new AccDTO();
                dto.setAccName(rs.getString(1));
                dto.setRepName(rs.getString(2));
                dto.setAddress1(rs.getString(3));
                dto.setCode(rs.getString(4));
                
                list.add(dto);
            }
            
            return list;
        } finally {
            DBUtil.dbclose(rs, ps, con);
        }
    }

}
