/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static connect.connectSQLite.connectWithData;
import static controller.controllerDictionary.findDetailFromDataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class suatu {
    public static String editDetail(String word, String detail)throws ClassNotFoundException, SQLException{
        word = word.toLowerCase();
        Connection con = connectWithData();
        String sql = "update dictionary set detail = ? where word = ?";
        String check = "select word from dictionary where word = ?";
        try {
            assert con != null;
            PreparedStatement pstm = con.prepareStatement(check);
            pstm.setString(1, word);
            ResultSet rs = pstm.executeQuery();
            String abc = "";
            while (rs.next()) {
                abc = rs.getString("word");
            }
            if(abc.equals("")){
                System.out.println("Từ này chưa có trong database");
                return "false";
            }
            pstm = con.prepareStatement(sql);
            pstm.setString(1, detail);
            pstm.setString(2, word);
            pstm.executeUpdate();
            return "true";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "true";
    }
    
}
