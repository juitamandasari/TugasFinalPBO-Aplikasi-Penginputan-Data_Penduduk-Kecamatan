/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package penduduk.DAO;


import java.sql.Connection;
//import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import penduduk.DAOImplement.Implement_Penduduk;
import penduduk.Koneksi.Koneksi_Db_Penduduk;
import penduduk.Model.Model_Penduduk;
/**
 *
 * @author ASUS
 */
public class DAO_penduduk implements Implement_Penduduk{
    Connection connection;
    final String insert = "INSERT INTO tb_datapenduduk (nik, nama_lengkap, tempat_lahir, tanggal_lahir, jenis_kelamin, alamat, rt_rw, kel_desa, agama, status, pekerjaan, gol_darah) VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";
    final String update = "UPDATE tb_datapenduduk set nama_lengkap=?, tempat_lahir=?, tanggal_lahir=?, jenis_kelamin=?, alamat=?, rt_rw=?, kel_desa=?, agama=?, status=?, pekerjaan=?, gol_darah=? WHERE nik=?;";
    final String delete = "DELETE FROM tb_datapenduduk WHERE nik=?;";
    final String select = "SELECT * FROM tb_datapenduduk;";
    final String carinama = "SELECT * FROM tb_datapenduduk WHERE nama_lengkap like ?";
    
    public DAO_penduduk(){
        connection = (Connection) Koneksi_Db_Penduduk.connection();
    }

    @Override
    public void insert(Model_Penduduk b) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert);
            statement.setString(1, b.getNik());
            statement.setString(2, b.getNama_lengkap());
            statement.setString(3, b.getTempat_lahir());
            statement.setString(4, b.getTanggal_lahir());
            statement.setString(5, b.getJenis_kelamin());
            statement.setString(6, b.getAlamat());
            statement.setString(7, b.getRt_rw());
            statement.setString(8, b.getKel_desa());
            statement.setString(9, b.getAgama());
            statement.setString(10, b.getStatus());
            statement.setString(11, b.getPekerjaan());
            statement.setString(12, b.getGol_darah());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(Model_Penduduk b) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(update);
            
            statement.setString(1, b.getNama_lengkap());
            statement.setString(2, b.getTempat_lahir());
            statement.setString(3, b.getTanggal_lahir());
            statement.setString(4, b.getJenis_kelamin());
            statement.setString(5, b.getAlamat());
            statement.setString(6, b.getRt_rw());
            statement.setString(7, b.getKel_desa());
            statement.setString(8, b.getAgama());
            statement.setString(9, b.getStatus());
            statement.setString(10, b.getPekerjaan());
            statement.setString(11, b.getGol_darah());
            statement.setString(12, b.getNik());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(String nik) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            statement.setString(1, nik);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    

    @Override
    public List<Model_Penduduk> getALL() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        List<Model_Penduduk> lb = null;
        try{
            lb = new ArrayList<Model_Penduduk>();
           Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()){
                Model_Penduduk b = new Model_Penduduk();
                b.setNik(rs.getString("nik"));
                b.setNama_lengkap(rs.getString("nama_lengkap"));
                b.setTempat_lahir(rs.getString("tempat_lahir"));
                b.setTanggal_lahir(rs.getString("tanggal_lahir"));
                b.setJenis_kelamin(rs.getString("jenis_kelamin"));
                b.setAlamat(rs.getString("alamat"));
                b.setRt_rw(rs.getString("rt_rw"));
                b.setKel_desa(rs.getString("kel_desa"));
                b.setAgama(rs.getString("agama"));
                b.setStatus(rs.getString("status"));
                b.setPekerjaan(rs.getString("pekerjaan"));
                b.setGol_darah(rs.getString("gol_darah"));
                lb.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_penduduk.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return lb;
    }

    @Override
    public List<Model_Penduduk> getCariNama(String nama_lengkap) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        List<Model_Penduduk> lb = null;
        try{
            lb = new ArrayList<Model_Penduduk>();
            PreparedStatement st = connection.prepareStatement(carinama);
            st.setString(1, "%" + nama_lengkap + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                Model_Penduduk b = new Model_Penduduk();
                b.setNik(rs.getString("nik"));
                b.setNama_lengkap(rs.getString("nama_lengkap"));
                b.setTempat_lahir(rs.getString("tempat_lahir"));
                b.setTanggal_lahir(rs.getString("tanggal_lahir"));
                b.setJenis_kelamin(rs.getString("jenis_kelamin"));
                b.setAlamat(rs.getString("alamat"));
                b.setRt_rw(rs.getString("rt_rw"));
                b.setKel_desa(rs.getString("kel_desa"));
                b.setAgama(rs.getString("agama"));
                b.setStatus(rs.getString("status"));
                b.setPekerjaan(rs.getString("pekerjaan"));
                b.setGol_darah(rs.getString("gol_darah"));
                lb.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_penduduk.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return lb;
    }

  
}
