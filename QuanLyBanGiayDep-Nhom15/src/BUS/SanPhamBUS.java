
package BUS;

import java.sql.ResultSet;
import java.util.ArrayList;

import DAO.SanPhamDAO;
import DTO.SanPhamDTO;

public class SanPhamBUS {
    public static ArrayList<SanPhamDTO> list;  
    public SanPhamBUS(){}
    public ArrayList<SanPhamDTO> docSanPham(){
        SanPhamDAO data = new SanPhamDAO();
        try{
            list = new ArrayList<>();
            list = data.docSanPham();
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }   
    public int themSanPham(SanPhamDTO s){
        SanPhamDAO data = new SanPhamDAO();
        int check = data.themSanPham(s);
        if(check==1)
            list.add(s);
        return check;
    }
    public int suaSanPham(SanPhamDTO s,int i){
        SanPhamDAO data= new SanPhamDAO();
        int check = data.suaSanPham(s);
        if(check ==1)
            list.set(i,s);
        return check;
    }

    public static ArrayList<SanPhamDTO> timkiemSanPham(String key, String query) {
        ArrayList<SanPhamDTO> temp = new ArrayList<>();
        SanPhamDAO data = new SanPhamDAO();
        try{
        ArrayList<SanPhamDTO> s = data.docSanPham();
        if (key.equals("Mã sản phẩm")) {
            for (int i = 0; i < s.size(); i++) {
                if (s.get(i).getMaSP().toLowerCase().equals(query)) {
                    temp.add(s.get(i));
                }

            }
            return temp;
        }
        if (key.equals("Tên sản phẩm")) {
            for (int i = 0; i < s.size(); i++) {
                if (s.get(i).getTenSP().toLowerCase().equals(query)) {
                    temp.add(s.get(i));
                }

            }
            return temp;
        }
        if (key.equals("Mã nhà sản xuất")) {
            for (int i = 0; i < s.size(); i++) {
                if (s.get(i).getMaNSX().toLowerCase().equals(query)) {
                    temp.add(s.get(i));
                }

            }
            return temp;
        }
        if (key.equals("Mã loại")) {
            for (int i = 0; i < s.size(); i++) {
                if (s.get(i).getMaLoai().toLowerCase().equals(query)) {
                    temp.add(s.get(i));
                }

            }
            return temp;
        }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }   
    
    public String getTenSP(String MaSP) throws Exception{
        String ten = null;
        SanPhamDAO data = new SanPhamDAO();
        try{
        ArrayList<SanPhamDTO> s = data.docSanPham();
            for (int i = 0; i < s.size(); i++) {
                if (s.get(i).getMaSP().toLowerCase().equals(MaSP.toLowerCase())) {
                    ten=s.get(i).getTenSP();
                    return ten;}
            }
        } 
        catch (Exception e){ 
            e.printStackTrace(); 
        }
        
        return ten;
    } 
    
     public SanPhamDTO doiTrangThai(String MaSP) throws Exception {
         System.out.print("bus san pham " + MaSP);
       SanPhamDAO data = new SanPhamDAO();
       SanPhamDTO sp = data.doiTrangThai(MaSP);
       return sp;
    }
     
     public ResultSet thongKeSanPhamTheoThang(int year, int month) {
        SanPhamDAO data = new SanPhamDAO();
        return data.thongKeSanPhamTheoThang(year, month);
    }
                  
    public ResultSet thongKeSanPhamTheoNam() {
        SanPhamDAO data = new SanPhamDAO();
        return data.thongKeSanPhamTheoNam();
    }
    
    public ResultSet thongKeSanPhamXuatTheoThang(int year, int month) {
        SanPhamDAO data = new SanPhamDAO();
        return data.thongKeSanPhamXuatTheoThang(year, month);
    }
    
    public ResultSet thongKeSanPhamXuatTheoNam() {
        SanPhamDAO data = new SanPhamDAO();
        return data.thongKeSanPhamXuatTheoNam();
    }
    
    public ResultSet thongKeSanPhamXuatTheoQuy(int year, int quarter) {
        SanPhamDAO data = new SanPhamDAO();
        return data.thongKeSanPhamXuatTheoQuy(year, quarter);
    }
     
}
