/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.account;

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

    public static final int OK = 1;
    public static final int NO = 0;

    public ArrayList<AccDTO> selectAll() throws SQLException {
        try {
            con = DBUtil.getConnection();

            String sql = "select * from account order by account_name";
            ps = con.prepareCall(sql);

            rs = ps.executeQuery();

            ArrayList<AccDTO> list = new ArrayList<>();
            while (rs.next()) {
                AccDTO dto = new AccDTO();
                dto.setAddress2(rs.getString("address2"));
                dto.setAccName(rs.getString("account_name"));
                dto.setRepName(rs.getString("rep_name"));
                dto.setAddress1(rs.getString("address1"));
                dto.setCode(rs.getString("ACCOUNT_CODE"));
                dto.setItemCode(rs.getString(8));
                dto.setZipcode(rs.getString(5));
                dto.setHp(rs.getString(4));

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

            String sql = "select * from account where account_name like '%' || ? || '%' order by account_name";
            ps = con.prepareCall(sql);

            ps.setString(1, name);

            rs = ps.executeQuery();

            ArrayList<AccDTO> list = new ArrayList<>();
            while (rs.next()) {
                AccDTO dto = new AccDTO();
                dto.setZipcode(rs.getString(5));
                dto.setAccName(rs.getString("account_name"));
                dto.setRepName(rs.getString("rep_name"));
                dto.setAddress1(rs.getString("address1"));
                dto.setCode(rs.getString("ACCOUNT_CODE"));
                dto.setAddress2(rs.getString(7));
                dto.setItemCode(rs.getString(8));
                dto.setHp(rs.getString(4));

                list.add(dto);
            }

            return list;
        } finally {
            DBUtil.dbclose(rs, ps, con);
        }
    }

    public int delete(String accCode) throws SQLException {
        try {
            con = DBUtil.getConnection();

            String sql = "DELETE FROM ACCOUNT WHERE ACCOUNT_CODE = ?";
            ps = con.prepareStatement(sql);

            ps.setString(1, accCode);

            int n = ps.executeUpdate();
            System.out.println("n=" + n + ", name=" + accCode);
            return n;
        } finally {
            DBUtil.dbclose(ps, con);
        }
    }

    public int idCheck(String accCode) throws SQLException {
        try {
            con = DBUtil.getConnection();

            String sql = "select count(*) from ACCOUNT where ACCOUNT_CODE = ?";
            ps = con.prepareCall(sql);

            ps.setString(1, accCode);
            rs = ps.executeQuery();

            int n = 0;
            if (rs.next()) {
                n = rs.getInt(1);
            }

            if (n > 0) {
                return OK;
            }
            return NO;
        } finally {
            DBUtil.dbclose(rs, ps, con);
        }
    }

    public int update(AccDTO dto) throws SQLException {
        try {
            con = DBUtil.getConnection();

            String sql = "update account\n"
                    + "set REP_NAME=?, ACCOUNT_HP = ?, ZIPCODE=?, ADDRESS1 = ?, ADDRESS2 = ?, ITEM_CODE = ?\n"
                    + "where account_code = ?";
            ps = con.prepareStatement(sql);

            ps.setString(1, dto.getRepName());
            ps.setString(2, dto.getHp());
            ps.setString(3, dto.getZipcode());
            ps.setString(4, dto.getAddress1());
            ps.setString(5, dto.getAddress2());
            ps.setString(6, dto.getItemCode());
            ps.setString(7, dto.getCode());

            int n = ps.executeUpdate();
            System.out.println("n=" + n + ", dto=" + dto);
            return n;
        } finally {
            DBUtil.dbclose(ps, con);
        }
    }

    public int insert(AccDTO dto) throws SQLException {
        try {
            con = DBUtil.getConnection();

            String sql = "INSERT into account\n"
                    + "VALUES(?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            
            ps.setString(1, dto.getCode());
            ps.setString(2, dto.getAccName());
            ps.setString(3, dto.getRepName());
            ps.setString(4, dto.getHp());
            ps.setString(5, dto.getZipcode());
            ps.setString(6, dto.getAddress1());
            ps.setString(7, dto.getAddress2());
            ps.setString(8, dto.getItemCode());

            int n = ps.executeUpdate();
            System.out.println("n=" + n + ", dto=" + dto);
            return n;
        } finally {
            DBUtil.dbclose(ps, con);
        }
    }

    public AccDTO selectByCode(String accCode) throws SQLException {
        try {
            con = DBUtil.getConnection();

            String sql = "select * from customer where CUSTOMER_ID = ?";
            ps = con.prepareCall(sql);

            ps.setString(1, accCode);

            rs = ps.executeQuery();

            AccDTO dto = new AccDTO();
            if (rs.next()) {
                dto.setAddress2(rs.getString("address2"));
                dto.setAccName(rs.getString("account_name"));
                dto.setRepName(rs.getString("rep_name"));
                dto.setAddress1(rs.getString("address1"));
                dto.setCode(rs.getString("ACCOUNT_CODE"));
                dto.setItemCode(rs.getString(8));
                dto.setZipcode(rs.getString(5));
                dto.setHp(rs.getString(4));

            }
            return dto;
        } finally {
            DBUtil.dbclose(rs, ps, con);
        }
    }

}
