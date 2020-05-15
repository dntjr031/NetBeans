/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swingapp.member.model;

import com.swingapp.db.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author STU-03
 */
public class MemberDAO {
    //로그인 처리시 
    public static final int LOGIN_OK=1; //로그인 성공
    public static final int  PWD_DISAGREE=2; //비밀번호 불일치
    public static final int USERID_NONE=3; //아이디가 존재하지 않음
    
    // 아이디 중복확인시
    public static final int USABLE=1; //사용가능
    public static final int UNUSABLE=2; //사용불가
    
    
    public int loginCheck(String userid, String pwd) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            con = DBUtil.getConnection();
            
            String sql = "select pwd from member where userid = ?";
            ps = con.prepareCall(sql);
            
            ps.setString(1, userid);
            
            rs = ps.executeQuery();
            
            int result = 0;
            
            if(rs.next()){
                String dbPwd = rs.getString(1);
                
                if(pwd.equals(dbPwd)){
                    result =  LOGIN_OK;
                }else{
                    result =  PWD_DISAGREE;
                }
            }else{
                result =  USERID_NONE;
            }
            System.out.println("로그인 체크 결과, result=" + result + ", 매개변수 userid="+userid + ", pwd=" + pwd);
            return result;
        } finally {
            DBUtil.dbclose(rs, ps, con);
        }
    }
    public int insertMember(MemberDTO dto) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        
        try {
            con = DBUtil.getConnection();
            
            String sql = "insert into member values(member_seq.nextval,?,?,?,\n" +
                        "?,?,?,?,?,default)";
            ps = con.prepareStatement(sql);
            
            ps.setString(1, dto.getUserid());
            ps.setString(2, dto.getName());
            ps.setString(3, dto.getPwd());
            ps.setString(4, dto.getEmail());
            ps.setString(5, dto.getHp());
            ps.setString(6, dto.getZipcode());
            ps.setString(7, dto.getAddress1());
            ps.setString(8, dto.getAddress2());
            
            int cnt = ps.executeUpdate();
            
            System.out.println("회원가입 결과 cnt=" + cnt + ", 매개변수 dto =" + dto);
            return cnt;
        } finally {
            DBUtil.dbclose(ps, con);
        }
    }
    
    public int duplicateId(String userid) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            con = DBUtil.getConnection();
            
            String sql = "select count(no) from member where userid = ?";
            ps = con.prepareCall(sql);
            
            ps.setString(1, userid);
            rs = ps.executeQuery();
            int result = 0;
            if(rs.next()){
                int count = rs.getInt(1);
                
                if(count >0){
                    result = UNUSABLE;
                }else{
                    result = USABLE;
                }
                
            }
            System.out.println("아이디 중복확인 결과, result=" + result + ", 매개변수 userId=" + userid);
            return result;
        }finally{
            DBUtil.dbclose(ps, con);
        }
    
    }
}
