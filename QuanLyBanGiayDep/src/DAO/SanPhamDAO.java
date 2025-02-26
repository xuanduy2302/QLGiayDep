
package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DTO.SanPhamDTO;
import untils.MyDataAccess;

public class SanPhamDAO {
    MyDataAccess my = new MyDataAccess("localhost","root","","qlst");
    public SanPhamDAO(){}
    public ArrayList<SanPhamDTO> docSanPham() throws Exception{
        ArrayList<SanPhamDTO> list = new ArrayList<SanPhamDTO>();
        try{
                String qry = "select * from sanpham order by substr(MaSP,7,6)*1 ";
                ResultSet rs = my.executeQuery(qry);
                while(rs.next()){
                    SanPhamDTO s = new SanPhamDTO();
                    s.setMaSP(rs.getString(1));
                    s.setMaNSX(rs.getString(2));
                    s.setMaLoai(rs.getString(3));
                    s.setTenSP(rs.getString(4));
                    s.setDonGia(rs.getDouble(5));
                    s.setSoLuong(rs.getInt(6));      
                    s.setTrangThai(rs.getBoolean(7));                   
                    list.add(s);
                }
        }catch(Exception e){
            System.out.println("SanphamDAO docSanPham " + e.getMessage());
        }
        finally{
            my.close();
        }
        return list;
    }    
    
    public boolean isValidtoAdd(SanPhamDTO s){
       try{
           ArrayList<SanPhamDTO> arr = docSanPham();
           for (int i = 0; i < arr.size(); i++) {
               if(arr.get(i).getMaSP().equals(s.getMaSP())){
                JOptionPane.showMessageDialog(null,"Mã sản phẩm đã tồn tại");
                return false;}
               else return true;}
        }catch(Exception e){
            System.out.println("SanphamDAO isvaildtoadd " + e.getMessage());
            return true;
        }
    return true;        
    }
    
    public int themSanPham(SanPhamDTO s){
        if(isValidtoAdd(s)){
        int res = 0;
        try{
                String qry = "insert into sanpham values(";
                qry = qry +"'"+s.getMaSP()+"'";
                qry = qry +",'"+s.getMaNSX()+"'";
                qry = qry+",'"+s.getMaLoai()+"'";
                qry = qry+",'"+s.getTenSP()+"'";
                qry = qry+","+s.getDonGia();
                qry = qry+","+s.getSoLuong();    
                qry = qry+","+s.getTrangThai()+")";                
                res = my.executeUpdate(qry);
            }catch(Exception e){
                System.out.println("SanphamDAO themSanPham " + e.getMessage());
            }
        return res;
        }
        return 0;
    }
    public int suaSanPham(SanPhamDTO s){
        int res = 0;
        try{
            String qry = "update sanpham set ";
            qry = qry + "TenSP='"+s.getTenSP()+"',";            
            qry = qry + "DonGia="+s.getDonGia()+",";
            qry = qry + "SoLuong='"+s.getSoLuong()+"'";          
            qry = qry +" where MaSP ='"+s.getMaSP()+"' and MaNSX ='"+s.getMaNSX()+"'"
                      +" and MaLoai ='"+s.getMaLoai()+"'";
            res = my.executeUpdate(qry);
        }catch(Exception e){
            System.out.println("SanphamDAO suaSanPham " + e.getMessage());
        }
        return res;
    }
    
    public SanPhamDTO getSanPhamById(String MaSP) throws Exception {
        SanPhamDTO result = null;
        try {
            String qry = "SELECT * FROM sanpham WHERE MaSP = '" + MaSP + "'";
            ResultSet rs = my.executeQuery(qry);
            if (rs.next()) {
                SanPhamDTO sp = new SanPhamDTO();
                sp.setMaSP(rs.getString(1));
                sp.setMaNSX(rs.getString(2));
                sp.setMaLoai(rs.getString(3));
                sp.setTenSP(rs.getString(4));
                sp.setDonGia(rs.getDouble(5));
                sp.setSoLuong(rs.getInt(6));
                sp.setTrangThai(rs.getBoolean(7));
                result = sp;
            }
        } catch (Exception ex) {
            System.out.println("SanphamDAO getSanphambyID " + ex.getMessage());
        } finally {    
            my.close();
        }
        return result;
    }
    
    public SanPhamDTO doiTrangThai(String MaSP) throws Exception {
        SanPhamDTO result = null;
        try {
            System.out.println("mã sp: " + MaSP);
            String qry = "UPDATE sanpham SET TrangThai = NOT TrangThai WHERE MaSP = '" + MaSP + "'";
            my.executeUpdate(qry);
            result = getSanPhamById(MaSP);
            System.out.print("trạng thái :" + result.getTrangThai() );
        } catch (Exception ex) {
            System.out.print(ex);
        } finally {    
            my.close();
        }
        return result;
    }
    
    public ResultSet thongKeSanPhamTheoThang(int year, int month) {
        ResultSet rs = null;
        try {
            String qry = "SELECT YEAR(NgayNhap) AS Year, MONTH(NgayNhap) AS Month,"
                    + " MaSP, SUM(SoLuong) AS TotalQuantity, SUM(ThanhTienCTPn) AS TotalAmount "
                    + "FROM ctpn JOIN phieunhap ON ctpn.MaPn = phieunhap.MaPn WHERE YEAR(NgayNhap) = " + year + 
                    " AND MONTH(NgayNhap) = " + month + " GROUP BY Year, Month, MaSP ORDER BY TotalAmount DESC";
            rs = my.executeQuery(qry);
            return rs;
        } catch (Exception ex) {
            System.out.println("DAO Thống kê sp theo tháng " + ex.getMessage());
        }
        return rs;
    }
    
    public ResultSet thongKeSanPhamTheoNam() {
        ResultSet rs = null;

        try{
            String qry = "SELECT YEAR(NgayNhap) AS Year, MONTH(NgayNhap) AS Month, MaSP,"
                    + " SoLuong, ThanhTienCTPn FROM ctpn JOIN phieunhap ON "
                    + "ctpn.MaPn = phieunhap.MaPn ORDER BY Year DESC";
            rs = my.executeQuery(qry);
        } catch (Exception ex) {
            System.out.println("DAO Thống kê sp theo năm " + ex.getMessage());
        }
        return rs;
    }
    
    public ResultSet thongKeSanPhamXuatTheoThang(int year, int month) {
        ResultSet rs = null;
        try {

            String qry = "SELECT YEAR(NgayXuat) AS Year, MONTH(NgayXuat) AS Month, MaSP,"
                    + " SUM(SoLuong) AS TotalQuantity, SUM(ThanhTienCTPX) AS TotalAmount"
                    + " FROM ctpx JOIN phieuxuat ON ctpx.MaPx = phieuxuat.MaPx WHERE "
                    + "YEAR(NgayXuat) = " + year + " AND MONTH(NgayXuat) = " + month + " GROUP BY Year, Month, MaSP";
            rs = my.executeQuery(qry);
            return rs;
        } catch (Exception ex) {
            System.out.println("DAO Thống kê sp xuất theo tháng " + ex.getMessage());
        }
        return rs;
    }
    
    public ResultSet thongKeSanPhamXuatTheoNam() {
        ResultSet rs = null;

        try{
            String qry = "SELECT YEAR(NgayXuat) AS Year, MONTH(NgayXuat) AS Month, MaSP,"
                    + " SoLuong, ThanhTienCTPX FROM ctpx JOIN phieuxuat ON "
                    + "ctpx.MaPx = phieuxuat.MaPx ORDER BY Year DESC";
            rs = my.executeQuery(qry);
        } catch (Exception ex) {
            System.out.println("DAO Thống kê sp xuất theo năm " + ex.getMessage());
        }
        return rs;
    }
    
    public ResultSet thongKeSanPhamXuatTheoQuy(int year, int quarter) {
        ResultSet rs = null;
        try {

            String qry = "SELECT YEAR(NgayXuat) AS Year, QUARTER(NgayXuat) AS Quarter, MONTH(NgayXuat) AS Month,"
                        + " MaSP, SoLuong , ThanhTienCTPX "
                        + " FROM ctpx JOIN phieuxuat ON ctpx.MaPx = phieuxuat.MaPx"
                        + " WHERE YEAR(NgayXuat) = " + year + " AND QUARTER(NgayXuat) = " + quarter
                        + " GROUP BY Year, Quarter, Month, MaSP ORDER BY Year DESC, Month DESC";


            rs = my.executeQuery(qry);
            return rs;
        } catch (Exception ex) {
            System.out.println("DAO Thống kê sp xuất theo quý " + ex.getMessage());
        }
        return rs;
    }

}
