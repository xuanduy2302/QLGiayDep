
package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DTO.LoginDTO;
import DTO.NhanVienDTO;
import untils.MyDataAccess;

public class LoginDAO {
    MyDataAccess my = new MyDataAccess("localhost","root","","qlst");
    public LoginDAO(){}
    public ArrayList<LoginDTO> docLogin() throws Exception{
        ArrayList<LoginDTO> list = new ArrayList<LoginDTO>();
        try{
                String qry = "select * from login";
                ResultSet rs = my.executeQuery(qry);
                while(rs.next()){
                    LoginDTO lg = new LoginDTO();
                    lg.setMaNV(rs.getString(1));
                    lg.setPassWord(rs.getString(2));                 
                    list.add(lg);
                }
        }catch(Exception e){
            System.out.println("Login Dao: docLogin " + e.getMessage());
            JOptionPane.showMessageDialog(null,"Login Dao: docLogin " + e.getMessage());
        }
        finally{
            my.close();
        }
        return list;
    }
    public ArrayList<NhanVienDTO> docChucvu(String manv) throws Exception{
        ArrayList<NhanVienDTO> list = new ArrayList<NhanVienDTO>();
        try{
                String qry = 
                "select ChucVu from login,nhanvien where login.MaNv = nhanvien.MaNv and login.MaNv='"+manv+"'";
                ResultSet rs = my.executeQuery(qry);
                System.out.print(qry);
                while(rs.next()){
                    NhanVienDTO nv = new NhanVienDTO();
                    nv.setChucVuNV(rs.getString(5));
                    list.add(nv);
                }
        }catch(Exception e){
            System.out.println("Login Dao: docChucVu " + e.getMessage());
            JOptionPane.showMessageDialog(null,"Login Dao: docChucVu " + e.getMessage());
        }
        finally{
            my.close();
        }
        return list;
    }
    public int doiMK(String MaNV, String pass)
    {
        int res = 0;
        try { 
            String qry = "update login set Password='"+pass+"' where MaNv='"+MaNV+"'";
            res = my.executeUpdate(qry);
        } catch (Exception e)
        {
            System.out.println("Login Dao: doiMK " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Login Dao: doiMK " + e.getMessage());
        }
        return res;
    }
    
    public void themLogin(String MaNV)
    {
        int res = 0;
        try { 
            String qry = "INSERT INTO login(MaNv, Password) VALUES ('" + MaNV + "', '" + 111 + "')";
            res = my.executeUpdate(qry);
        } catch (Exception e)
        {
            System.out.println("Login Dao: themLogin " + e.getMessage());
            JOptionPane.showMessageDialog(null,"Login Dao: themLogin " + e.getMessage());
        }
    }
}
