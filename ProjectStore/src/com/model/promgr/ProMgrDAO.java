/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.promgr;

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
public class ProMgrDAO {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public int insert(ProMgrDTO dtoMgr) throws SQLException {
        try {
            con = DBUtil.getConnection();

            String sql = "INSERT INTO product_mgr(P_MGR_NO, PCODE, PRICE, QUANTITY, TOTAL_PRICE, ACCOUNT_CODE)\n"
                    + "VALUES (MGR_SEQ.nextval,?,?,?,?,?)";
            ps = con.prepareCall(sql);

            ps.setString(1, dtoMgr.getPcode());
            ps.setInt(2, dtoMgr.getPrice());
            ps.setInt(3, dtoMgr.getQuantity());
            ps.setInt(4, dtoMgr.getTotalPrice());
            ps.setString(5, dtoMgr.getAccCode());

            int n = ps.executeUpdate();
            System.out.println("n=" + n + ", dto=" + dtoMgr);

            return n;

        } finally {

        }
    }

    public ArrayList<ProMgrDTO> searchAll() throws SQLException {
        try {
            con = DBUtil.getConnection();

            String sql = "select * from PRODUCT_MGR order by TRADING_DAY desc";
            ps = con.prepareCall(sql);

            rs = ps.executeQuery();
            ArrayList<ProMgrDTO> list = new ArrayList<>();
            while (rs.next()) {
                ProMgrDTO dto = new ProMgrDTO();
                dto.setNo(rs.getInt(1));
                dto.setPcode(rs.getString(2));
                dto.setPrice(rs.getInt(3));
                dto.setQuantity(rs.getInt(4));
                dto.setTotalPrice(rs.getInt(5));
                dto.setAccCode(rs.getString(6));
                dto.setTradingDay(rs.getTimestamp(7));

                list.add(dto);
            }
            return list;
        } finally {
            DBUtil.dbclose(rs, ps, con);
        }
    }

    public ArrayList<ProMgrDTO> searchByCode(String accCode) throws SQLException {
        try {
            con = DBUtil.getConnection();

            String sql = "select * from PRODUCT_MGR where ACCOUNT_CODE = ? ";
            ps = con.prepareStatement(sql);
            
            ps.setString(1, accCode);

            rs = ps.executeQuery();
            ArrayList<ProMgrDTO> list = new ArrayList<>();
            while (rs.next()) {
                ProMgrDTO dto = new ProMgrDTO();
                dto.setNo(rs.getInt(1));
                dto.setPcode(rs.getString(2));
                dto.setPrice(rs.getInt(3));
                dto.setQuantity(rs.getInt(4));
                dto.setTotalPrice(rs.getInt(5));
                dto.setAccCode(rs.getString(6));
                dto.setTradingDay(rs.getTimestamp(7));

                list.add(dto);
            }
            return list;
        } finally {
            DBUtil.dbclose(rs, ps, con);
        }
    }

}
