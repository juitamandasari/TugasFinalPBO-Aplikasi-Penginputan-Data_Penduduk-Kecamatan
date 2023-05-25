
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package penduduk.Koneksi;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.SQLException;

/**
 *
 * @author VEBRI DEVELOPER
 */
public class Koneksi_Db_Penduduk {
    
    static Connection con;
    
    public static Connection connection(){
        
        if(con == null){
            MysqlDataSource data = new MysqlDataSource();
            data.setDatabaseName("db_datapenduduk");
            data.setUser("root");
            data.setPassword("");
            try{
                con = (Connection) data.getConnection();
            } catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        
        return con;
    }
}



//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import javax.swing.JOptionPane;
//
//public class Koneksi_Db_Penduduk {
//    private static Connection con;
//    
//    public static Connection connection() {
//        if (con == null) {
//            try {
//                String url = "jdbc:mysql://localhost:3306/db_datapenduduk";
//                String user = "root";
//                String password = "";
//                con = DriverManager.getConnection(url, user, password);
//                JOptionPane.showMessageDialog(null, "Koneksi Database Berhasil", "Informasi", JOptionPane.INFORMATION_MESSAGE);
//            } catch (SQLException ex) {
//                JOptionPane.showMessageDialog(null, "Koneksi Error", "Perhatian", JOptionPane.ERROR_MESSAGE);
//            }
//        }
//        return con;
//    }
//}

//======================================================================

//private static Connection con;
//    
//    public static Connection connection() {
//        if (con == null) {
//            try {
//                String url = "jdbc:mysql://localhost:3306/db_datapenduduk";
//                String user = "root";
//                String password = "";
//                con = DriverManager.getConnection(url, user, password);
//                JOptionPane.showMessageDialog(null, "Koneksi Database Berhasil", "Informasi", JOptionPane.INFORMATION_MESSAGE);
//            } catch (SQLException ex) {
//                JOptionPane.showMessageDialog(null, "Koneksi Error", "Perhatian", JOptionPane.ERROR_MESSAGE);
//            }
//        }
//        return con;
//    }



//------------------------------------------------
//package penduduk.Koneksi;

////import com.mysql.cj.jdbc.MysqlDataSource;
////import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
////import com.sun.jdi.connect.spi.Connection;
//import com.sun.jdi.connect.spi.Connection;
//import java.sql.SQLException;
////import java.sql.Connection;
//import java.sql.DriverManager;
//import javax.swing.JOptionPane;
//
///**
// *
// * @author ASUS
// */
//public class Koneksi_Db_Penduduk {
//    private static Connection con;
//    
//    public static Connection connection(){
////        if(con == null){
////         MysqlDataSource data = new MysqlDataSource();
////            data.setDatabaseName ("db_datapenduduk");
////            data.setUser("root");
////            data.setPassword("");
////            try{
////                con = (Connection) data.getConnection();
////            }catch (SQLException ex){
////                ex.printStackTrace();
////            }
////        }
//        if (con == null) {
//            try {
//                String url = "jdbc:mysql://localhost:3306/db_datapenduduk";
//                String user = "root";
//                String password = "";
//                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
//                con = (Connection) DriverManager.getConnection(url, user, password);
//                //con = DriverManager.getConnection(url, user, password);
//
//
//                JOptionPane.showMessageDialog(null, "Koneksi Database Berhasil", "Informasi", JOptionPane.INFORMATION_MESSAGE);
//            } catch (SQLException ex) {
//                JOptionPane.showMessageDialog(null, "Koneksi Error", "Perhatian", JOptionPane.ERROR_MESSAGE);
//            }
//        }
//        return con;
//    }
//}


