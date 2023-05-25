/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package penduduk.Controller;

import javax.swing.JOptionPane;
import penduduk.DAO.DAO_penduduk;
import penduduk.DAOImplement.Implement_Penduduk;
import penduduk.Model.Model_Penduduk;
import penduduk.Model.Tabel_Model_Penduduk;
import penduduk.View.View_Penduduk;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class Controller_Penduduk {
    
    View_Penduduk frame_penduduk;
    Implement_Penduduk implement_penduduk;
    List<Model_Penduduk>  list_penduduk;
    
    public Controller_Penduduk(View_Penduduk frame_penduduk){
        this.frame_penduduk = frame_penduduk;
        implement_penduduk = new DAO_penduduk();
        list_penduduk = implement_penduduk.getALL();
    }
    
    //Tombol Reset
    public void reset(){
        frame_penduduk.getTxtnik().setText("");
        frame_penduduk.getTxtnama_lengkap().setText("");
        frame_penduduk.getTxttempatLahir().setText("");
        frame_penduduk.getTxttglLahir().setText("");
        frame_penduduk.getTxtjk().setSelectedItem("- Pilih -");
        frame_penduduk.getTxtalamat().setText("");
        frame_penduduk.getTxtrtRw().setText("");
        frame_penduduk.getTxtkelDesa().setText("");
        frame_penduduk.getTxtagama().setSelectedItem("- Pilih -");
        frame_penduduk.getTxtstatus().setSelectedItem("");
        frame_penduduk.getTxtpekerjaan().setText("");
        frame_penduduk.getTxtgol().setSelectedItem("- Pilih -");
    }
    
    //Tampil Data
    public void IsiTable(){
        list_penduduk = implement_penduduk.getALL();
        Tabel_Model_Penduduk tmb = new Tabel_Model_Penduduk(list_penduduk);
        frame_penduduk.getTabelData().setModel(tmb);
    }
    
    //Menampilkan Data Ke Form Ketika Data DI Klik
    public void isiField(int row){
        frame_penduduk.getTxtnik().setText (list_penduduk.get(row).getNik().toString());
        frame_penduduk.getTxtnama_lengkap().setText(list_penduduk.get(row).getNama_lengkap());
        frame_penduduk.getTxttempatLahir().setText(list_penduduk.get(row).getTempat_lahir());
        frame_penduduk.getTxttglLahir().setText(list_penduduk.get(row).getTanggal_lahir());
        frame_penduduk.getTxtjk().setSelectedItem(list_penduduk.get(row).getJenis_kelamin());
        frame_penduduk.getTxtalamat().setText(list_penduduk.get(row).getAlamat());
        frame_penduduk.getTxtrtRw().setText(list_penduduk.get(row).getRt_rw());
        frame_penduduk.getTxtkelDesa().setText(list_penduduk.get(row).getKel_desa());
        frame_penduduk.getTxtagama().setSelectedItem(list_penduduk.get(row).getAgama());
        frame_penduduk.getTxtstatus().setSelectedItem(list_penduduk.get(row).getStatus());
        frame_penduduk.getTxtpekerjaan().setText(list_penduduk.get(row).getPekerjaan());
        frame_penduduk.getTxtgol().setSelectedItem(list_penduduk.get(row).getGol_darah());
    }
    
    //Insert Data Dari Form Ke Database
    public void insert(){
        if( !frame_penduduk.getTxtnik().getText().trim().isEmpty()& 
            !frame_penduduk.getTxtnama_lengkap().getText().trim().isEmpty()& 
            !frame_penduduk.getTxttempatLahir().getText().trim().isEmpty()& 
            !frame_penduduk.getTxttglLahir().getText().trim().isEmpty()& 
            !frame_penduduk.getTxtalamat().getText().trim().isEmpty()&             
            !frame_penduduk.getTxtrtRw().getText().trim().isEmpty()& 
            !frame_penduduk.getTxtkelDesa().getText().trim().isEmpty()&                
            !frame_penduduk.getTxtpekerjaan().getText().trim().isEmpty()){
            
            Model_Penduduk b = new Model_Penduduk();
            
            b.setNik(frame_penduduk.getTxtnik().getText());
            b.setNama_lengkap(frame_penduduk.getTxtnama_lengkap().getText());
            b.setTempat_lahir(frame_penduduk.getTxttempatLahir().getText());
            b.setTanggal_lahir(frame_penduduk.getTxttglLahir().getText());
            b.setJenis_kelamin(frame_penduduk.getTxtjk().getSelectedItem().toString());
            b.setAlamat(frame_penduduk.getTxtalamat().getText());
            b.setRt_rw(frame_penduduk.getTxtrtRw().getText());
            b.setKel_desa(frame_penduduk.getTxtkelDesa().getText());
            b.setAgama(frame_penduduk.getTxtagama().getSelectedItem().toString());
            b.setStatus(frame_penduduk.getTxtstatus().getSelectedItem().toString());
            b.setPekerjaan(frame_penduduk.getTxtpekerjaan().getText());
            b.setGol_darah(frame_penduduk.getTxtgol().getSelectedItem().toString());
            
            implement_penduduk.insert(b);
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Simpan");
        } else {
            JOptionPane.showMessageDialog(frame_penduduk, "Data Tidak Boleh Kosong");
        }
    }
    
    //Update Data Dari Tabel Ke Database
    public void update(){
        if(!frame_penduduk.getTxtnik().getText().trim().isEmpty()){
            Model_Penduduk b = new Model_Penduduk();

            b.setNama_lengkap(frame_penduduk.getTxtnama_lengkap().getText());
            b.setTempat_lahir(frame_penduduk.getTxttempatLahir().getText());
            b.setTanggal_lahir(frame_penduduk.getTxttglLahir().getText());
            b.setJenis_kelamin( frame_penduduk.getTxtjk().getSelectedItem().toString());
            b.setAlamat(frame_penduduk.getTxtalamat().getText());
            b.setRt_rw(frame_penduduk.getTxtrtRw().getText());
            b.setKel_desa(frame_penduduk.getTxtkelDesa().getText());
            b.setAgama(frame_penduduk.getTxtagama().getSelectedItem().toString());
            b.setStatus(frame_penduduk.getTxtstatus().getSelectedItem().toString());
            b.setPekerjaan(frame_penduduk.getTxtpekerjaan().getText());
            b.setGol_darah(frame_penduduk.getTxtgol().getSelectedItem().toString());
            b.setNik(frame_penduduk.getTxtnik().getText());
            
            implement_penduduk.update(b);
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Update");
        } else {
            JOptionPane.showMessageDialog(frame_penduduk, "Silahkan Pilih Data Yang Akan Di Update");
        }
    }
    
    //Hapus Data Pada Tabel
    public void delete() {
    String nik = frame_penduduk.getTxtnik().getText().trim();
    if (!nik.isEmpty()) {
        implement_penduduk.delete(nik);
        JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
    } else {
        JOptionPane.showMessageDialog(frame_penduduk, "Silakan Pilih Data yang Akan Dihapus");
    }
}

    
    //Cari Data
    public void isiTableCariNama(){
        list_penduduk = implement_penduduk.getCariNama(frame_penduduk.getTxtcariData().getText());
        Tabel_Model_Penduduk tmb = new Tabel_Model_Penduduk(list_penduduk);
        frame_penduduk.getTabelData().setModel(tmb);
    }
    
    public void carinama(){
        if(!frame_penduduk.getTxtcariData().getText().trim().isEmpty()){
            implement_penduduk.getCariNama(frame_penduduk.getTxtcariData().getText());
            isiTableCariNama();
        } else {
            JOptionPane.showMessageDialog(frame_penduduk, "Silahkan Pilih Data !!!");
        }
    }

}