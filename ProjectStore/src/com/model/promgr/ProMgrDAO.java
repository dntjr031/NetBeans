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

}
