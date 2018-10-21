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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


/**
 *
 * @author Dell
 */
public class themtu {
    public  static String InsertDetail(String word, String detail)throws ClassNotFoundException, SQLException
    {
          Connection con = connectWithData();
          String sql= "insert into dictionary(word,detail) values(?,?)";
          String check = findDetailFromDataBase(word);
          if(!check.equals("")){
              return "false";
          }
          try
          {
               PreparedStatement pstm = con.prepareStatement(sql);
               pstm.setString(1,word);
               pstm.setString(2,detail);
               int kt=pstm.executeUpdate();
                 pstm.close();
                 con.close();
                 return "true";
          }
           catch (Exception e){
            System.out.println(e);
        }
    return null;
    }
}
