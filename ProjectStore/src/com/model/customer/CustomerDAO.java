/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.customer;

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
public class CustomerDAO {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public static final int OK = 1;
    public static final int NO = 0;

    public int idCheck(String customerId) throws SQLException {
        try {
            con = DBUtil.getConnection();

            String sql = "select count(*) from customer where customer_id = ?";
            ps = con.prepareStatement(sql);

            ps.setString(1, customerId);
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

    public ArrayList<CustomerDTO> selectAll() throws SQLException {
        try {
            con = DBUtil.getConnection();

            String sql = "select * from customer order by customer_name";
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();
            ArrayList<CustomerDTO> list = new ArrayList<>();
            while (rs.next()) {
                CustomerDTO dto = new CustomerDTO();
                dto.setId(rs.getString(1));
                dto.setName(rs.getString(2));
                dto.setPh(rs.getString(3));
                dto.setBirthday(rs.getTimestamp(4));
                dto.setGender(rs.getString(5));
                dto.setZipcode(rs.getString(6));
                dto.setAddress1(rs.getString(7));
                dto.setAddress2(rs.getString(8));

                list.add(dto);
            }
            return list;
        } finally {
            DBUtil.dbclose(rs, ps, con);
        }
    }

    public ArrayList<CustomerDTO> selectByName(String name) throws SQLException {
        try {
            con = DBUtil.getConnection();

            String sql = "select * from customer where customer_name like '%' || ? || '%' order by customer_name";
            ps = con.prepareStatement(sql);

            ps.setString(1, name);

            rs = ps.executeQuery();
            ArrayList<CustomerDTO> list = new ArrayList<>();
            while (rs.next()) {
                CustomerDTO dto = new CustomerDTO();
                dto.setId(rs.getString(1));
                dto.setName(rs.getString(2));
                dto.setPh(rs.getString(3));
                dto.setBirthday(rs.getTimestamp(4));
                dto.setGender(rs.getString(5));
                dto.setZipcode(rs.getString(6));
                dto.setAddress1(rs.getString(7));
                dto.setAddress2(rs.getString(8));

                list.add(dto);
            }
            return list;
        } finally {
            DBUtil.dbclose(rs, ps, con);
        }
    }

    public CustomerDTO selectById(String userId) throws SQLException {
        try {
            con = DBUtil.getConnection();

            String sql = "select * from customer where CUSTOMER_ID = ?";
            ps = con.prepareStatement(sql);

            ps.setString(1, userId);

            rs = ps.executeQuery();

            CustomerDTO dto = new CustomerDTO();
            if (rs.next()) {
                dto.setId(rs.getString(1));
                dto.setName(rs.getString(2));
                dto.setPh(rs.getString(3));
                dto.setBirthday(rs.getTimestamp(4));
                dto.setGender(rs.getString(5));
                dto.setZipcode(rs.getString(6));
                dto.setAddress1(rs.getString(7));
                dto.setAddress2(rs.getString(8));

            }
            return dto;
        } finally {
            DBUtil.dbclose(rs, ps, con);
        }
    }

    public int update(CustomerDTO dto) throws SQLException {
        try {
            con = DBUtil.getConnection();

            String sql = "update customer\n"
                    + "set zipcode= ?, address1=?, address2=?, customer_ph = ?\n"
                    + "where customer_id = ?";
            ps = con.prepareStatement(sql);

            ps.setString(1, dto.getZipcode());
            ps.setString(2, dto.getAddress1());
            ps.setString(3, dto.getAddress2());
            ps.setString(4, dto.getPh());
            ps.setString(5, dto.getId());

            int n = ps.executeUpdate();
            System.out.println("n=" + n + ", dto=" + dto);
            return n;
        } finally {
            DBUtil.dbclose(ps, con);
        }
    }

    public int insert(CustomerDTO dto) throws SQLException {
        try {
            con = DBUtil.getConnection();

            String sql = "INSERT into customer\n"
                    + "VALUES (?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);

            ps.setString(6, dto.getZipcode());
            ps.setString(7, dto.getAddress1());
            ps.setString(8, dto.getAddress2());
            ps.setString(3, dto.getPh());
            ps.setString(1, dto.getId());
            ps.setString(2, dto.getName());
            ps.setTimestamp(4, dto.getBirthday());
            ps.setString(5, dto.getGender());

            int n = ps.executeUpdate();
            System.out.println("n=" + n + ", dto=" + dto);
            return n;
        } finally {
            DBUtil.dbclose(ps, con);
        }
    }

    public int delete(String customerId) throws SQLException {
        try {
            con = DBUtil.getConnection();

            String sql = "DELETE FROM customer WHERE customer_id = ?";
            ps = con.prepareStatement(sql);

            ps.setString(1, customerId);

            int n = ps.executeUpdate();
            System.out.println("n=" + n + ", customerId=" + customerId);
            return n;
        } finally {
            DBUtil.dbclose(ps, con);
        }
    }

}
