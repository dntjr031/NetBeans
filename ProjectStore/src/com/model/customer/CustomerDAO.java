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
            ps = con.prepareCall(sql);

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

}
