package com.example;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class LoginDAO {
    public static boolean validate(String username,String password){
        try(Connection con = DBUtil.getConnection()){
            String sql = "select * from users where username=? AND password=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            return rs.next();


        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
