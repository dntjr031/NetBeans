/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.item;

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
public class ItemDAO {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public ArrayList<ItemDTO> selectAll() throws SQLException {
        try {
            con = DBUtil.getConnection();

            String sql = "select * from item order by item_name";
            ps = con.prepareCall(sql);

            rs = ps.executeQuery();

            ArrayList<ItemDTO> list = new ArrayList<>();
            while (rs.next()) {
                ItemDTO dto = new ItemDTO();
                dto.setCode(rs.getString(1));
                dto.setName(rs.getString(2));
                dto.setRemark(rs.getString(3));

                list.add(dto);
            }

            return list;
        } finally {
            DBUtil.dbclose(rs, ps, con);
        }
    }

    public ItemDTO selectByName(String itemName) throws SQLException {
        try {
            con = DBUtil.getConnection();

            String sql = "select * from item where ITEM_NAME = ?";
            ps = con.prepareCall(sql);
            
            ps.setString(1, itemName);

            rs = ps.executeQuery();

            ItemDTO dto = new ItemDTO();
            if (rs.next()) {
                dto.setCode(rs.getString(1));
                dto.setName(rs.getString(2));
                dto.setRemark(rs.getString(3));

            }

            return dto;
        } finally {
            DBUtil.dbclose(rs, ps, con);
        }
    }

    public ItemDTO selectByCode(String itemCode) throws SQLException {
        try {
            con = DBUtil.getConnection();

            String sql = "select * from item where ITEM_CODE = ?";
            ps = con.prepareCall(sql);
            
            ps.setString(1, itemCode);

            rs = ps.executeQuery();

            ItemDTO dto = new ItemDTO();
            if (rs.next()) {
                dto.setCode(rs.getString(1));
                dto.setName(rs.getString(2));
                dto.setRemark(rs.getString(3));

            }

            return dto;
        } finally {
            DBUtil.dbclose(rs, ps, con);
        }
    }

    public int insert(ItemDTO dto) throws SQLException {
        try{
            con = DBUtil.getConnection();
            
            String sql = "insert into ITEM values(?,?,?)";
            ps = con.prepareStatement(sql);
            
            ps.setString(1, dto.getCode());
            ps.setString(2, dto.getName());
            ps.setString(3, dto.getRemark());
            
            int n = ps.executeUpdate();
            System.out.println("n=" + n + ", dto=" + dto);
            return n;
            
        }finally{
            DBUtil.dbclose(ps, con);
        }
    }

    public int codeCount(String code) throws SQLException {
        try {
            con = DBUtil.getConnection();

            String sql = "select count(*) from item where ITEM_CODE=?";
            ps = con.prepareCall(sql);
            ps.setString(1, code);
            
            rs = ps.executeQuery();

            int count = 0;
            if (rs.next()) {
                count = rs.getInt(1);

            }
            System.out.println("count="+count+", code="+code);
            return count;
        } finally {
            DBUtil.dbclose(rs, ps, con);
        }
    }

}
