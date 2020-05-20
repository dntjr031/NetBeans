/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectstore.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author STU-03
 */
public class DBUtil {

    private static String url = "jdbc:oracle:thin:@localhost:1521:xe";

    private static String user = "STORE", password = "123";

    //static 초기화 블럭
    static {
        //1. 드라이버 로딩
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("드라이버 로딩 성공!");

        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로딩 실패!");
            e.printStackTrace();
        }

    }

    public static Connection getConnection(String url, String user, String password) throws SQLException {
        //2. connection 객체 생성, db연결
        Connection con = DriverManager.getConnection(url, user, password);
        System.out.println("db연결 여부 con=" + con);
        return con;
    }

    public static Connection getConnection(String user, String password) throws SQLException {
        return getConnection(DBUtil.url, user, password);
    }

    public static Connection getConnection() throws SQLException {
        return getConnection(DBUtil.url, DBUtil.user, DBUtil.password);
    }

    public static void dbclose(PreparedStatement ps, Connection con) throws SQLException {
        if (ps != null) {
            ps.close();
        }
        if (con != null) {
            con.close();
        }
    }

    public static void dbclose(ResultSet rs, PreparedStatement ps, Connection con) throws SQLException {
        if (rs != null) {
            rs.close();
        }
        dbclose(ps, con);
    }
}
