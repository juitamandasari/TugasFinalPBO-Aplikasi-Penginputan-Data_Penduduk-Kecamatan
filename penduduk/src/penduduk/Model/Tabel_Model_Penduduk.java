/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package penduduk.Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author ASUS
 */
public class Tabel_Model_Penduduk extends AbstractTableModel{
    
    List<Model_Penduduk> list_penduduk;
    
    public Tabel_Model_Penduduk(List<Model_Penduduk> list_penduduk){
        this.list_penduduk = list_penduduk;
    }

    @Override
    public int getRowCount() {
        return list_penduduk.size();
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getColumnCount() {
        return 12; 
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public String getColumnName(int column) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        switch (column){
            case 0:
                return "NIK";
            case 1:
                return "NAMA LENGKAP";
            case 2:
                return "TEMPAT LAHIR";
            case 3:
                return "TANGGAL LAHIR";
            case 4:
                return "JENIS KELAMIN";
            case 5:
                return "ALAMAT";
            case 6:
                return "RT/RW";
            case 7:
                return "KEL/DESA";
            case 8:
                return "AGAMA";
            case 9:
                return "STATUS";
            case 10:
                return "PEKERJAAN";
            case 11:
                return "GOL_DARAH";
            default:
                return null;  
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        switch (column){
            case 0:
                return list_penduduk.get(row).getNik();
            case 1:
                return list_penduduk.get(row).getNama_lengkap();
            case 2:
                return list_penduduk.get(row).getTempat_lahir();
            case 3:
                return list_penduduk.get(row).getTanggal_lahir();
            case 4:
                return list_penduduk.get(row).getJenis_kelamin();
            case 5:
                return list_penduduk.get(row).getAlamat();
            case 6:
                return list_penduduk.get(row).getRt_rw();
            case 7:
                return list_penduduk.get(row).getKel_desa();
            case 8:
                return list_penduduk.get(row).getAgama();
            case 9:
                return list_penduduk.get(row).getStatus();
            case 10:
                return list_penduduk.get(row).getPekerjaan();
            case 11:
                return list_penduduk.get(row).getGol_darah();
            default:
                return null;  
        }
    }
}
