/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package penduduk.DAOImplement;

import java.util.List;
import penduduk.Model.Model_Penduduk;

/**
 *
 * @author ASUS
 */
public interface Implement_Penduduk {
    
    public void insert(Model_Penduduk b);
    
    public void update(Model_Penduduk b);
    
    public void delete(String nik);
    
    public List<Model_Penduduk> getALL();
    
  
    public List<Model_Penduduk> getCariNama(String nama_lengkap);
    
    
}
