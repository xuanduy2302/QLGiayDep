
package BUS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import DAO.LoginDAO;
import DAO.NhanVienDAO;
import DTO.LoginDTO;
import DTO.NhanVienDTO;

public class LoginBUS {
    public static ArrayList<LoginDTO> list;
    public static ArrayList<NhanVienDTO> listnv;     
    public LoginBUS(){}
    public ArrayList<LoginDTO> docLogin(){
        LoginDAO data = new LoginDAO();
        try{
            list = new ArrayList<LoginDTO>();
            list = data.docLogin();}
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    
    public String docChucvu(String manv){
        LoginDAO data = new LoginDAO();
        try{
            listnv = new ArrayList<NhanVienDTO>();
            listnv = data.docChucvu(manv);
        }catch(Exception e){
            e.printStackTrace();
        }
        return listnv.get(0).getChucVuNV();
    }
    
    public boolean kiemTraTrangThai(String manv) {
        NhanVienDAO data = new NhanVienDAO();
        NhanVienDTO nhanVien = new NhanVienDTO();
        try {
            nhanVien = data.getNhanVienById(manv);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return nhanVien.getTrangThai();
    }


    public boolean kiemtradangnhap(String manv,String password){
    for(LoginDTO lg : docLogin()){
        if(lg.getMaNV().trim().toLowerCase().equals(manv.trim().toLowerCase()) && kiemTraTrangThai(manv)){
            if(lg.getPassWord().trim().toLowerCase().equals(password.trim().toLowerCase()))
                    return true;
            }
        }
        return false;
    }
    
    public int kiemtraquanly(String MaNV){
        NhanVienBUS buslg = new NhanVienBUS();
        ArrayList<NhanVienDTO> list = buslg.docTaiKhoan();

        // Create a map for roles and their return values
        Map<String, Integer> roleMap = new HashMap<>();
        roleMap.put("admin", 4);
        roleMap.put("quản lý", 3);
        roleMap.put("nhân viên kho", 2);
        roleMap.put("nhân viên bán hàng", 1);

        for (NhanVienDTO nv : list){
            if (nv.getMaNV().equalsIgnoreCase(MaNV)) {
                String chucVu = nv.getChucVuNV().toLowerCase();
                // Check if the role exists in the map
                if (roleMap.containsKey(chucVu)) {
                    return roleMap.get(chucVu);
                }
            }
        }
        return 0;
    }

    

    public int doiMK(String MaNV, String Pass)
    {
        LoginDAO data = new LoginDAO();
        int check = data.doiMK(MaNV, Pass);
        return check;
    }
    public String getMK(String MaNV) throws Exception
    {
        ArrayList<LoginDTO> list = new ArrayList<>();
        LoginDAO data = new LoginDAO();
        list = data.docLogin();
        for (LoginDTO lg : list)
        {
            if (lg.getMaNV().toLowerCase().trim().equals(MaNV.toLowerCase().trim()))
            {
                return lg.getPassWord();
            }
        }
        return "0";
    }
    
    public boolean kiemTraMK(String MaNV, String Pass) throws Exception
    {
       String mk = getMK(MaNV);
       if (mk.toLowerCase().trim().equals(Pass.toLowerCase().trim()))
           return true;
       return false;     
    }
    
     public void themLogin(String MaNV) {
        LoginDAO data = new LoginDAO();
        data.themLogin(MaNV);
    }
}
