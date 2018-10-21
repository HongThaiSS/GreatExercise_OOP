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

/**
 *
 * @author Dell
 */
public class xoatu {
     public  static String DeleteDetail(String word )throws ClassNotFoundException, SQLException
    {
          Connection con = connectWithData();
          String sql="delete from dictionary where word=?";
          String check = findDetailFromDataBase(word);
          if(!check.equals("")){
              return "false";
          }
          try
          {
               PreparedStatement pstm = con.prepareStatement(sql);
               pstm.setString(1,word);
               int kt=pstm.executeUpdate();
              
                 pstm.close();
                 con.close();
          }
           catch (SQLException e){
            System.out.println(e);
        }    
          return null;
    }
     
    
}
