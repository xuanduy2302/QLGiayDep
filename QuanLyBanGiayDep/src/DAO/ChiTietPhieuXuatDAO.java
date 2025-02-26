 
package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;

import DTO.ChiTietPhieuXuatDTO;
import untils.MyDataAccess;

public class ChiTietPhieuXuatDAO {
    MyDataAccess my = new MyDataAccess("localhost","root","", "qlst");
    
    public ChiTietPhieuXuatDAO(){}
   
    public ArrayList<ChiTietPhieuXuatDTO> docCTPX() throws Exception{
        ArrayList<ChiTietPhieuXuatDTO> list = new ArrayList<ChiTietPhieuXuatDTO>();
        try {
            String qry = "select * from ctpx";
            ResultSet rs = my.executeQuery(qry);
            while (rs.next()){
                ChiTietPhieuXuatDTO ct = new ChiTietPhieuXuatDTO();
                ct.setMaPX(rs.getString(1));
                ct.setMaSP(rs.getString(2));
                ct.setDonGia(rs.getDouble(3));
                ct.setSoLuong(rs.getInt(4));
                ct.setThanhTien(rs.getDouble(5));
                list.add(ct);
            }
        } catch (Exception e){
            System.out.println("Chi tiết phiếu xuất: doc CTPX " + e.getMessage());
            //JOptionPane.showMessageDialog(null, "Lỗi đọc DataBase cthd");
        }
        finally{
            my.close();
        }   
                return list;
        }
    public boolean isValidtoAdd(ChiTietPhieuXuatDTO ctpx) throws Exception{
        ArrayList<ChiTietPhieuXuatDTO> arr = docCTPX();
        try{
            for (int i=0; i<arr.size(); i++){
                if (arr.get(i).getMaPX().equals(ctpx.getMaPX()) && arr.get(i).getMaSP().equals(ctpx.getMaSP())){
                    JOptionPane.showMessageDialog(null, "Chi tiết phiếu xuất này đã tồn tại!!!");
                    return false;}
                else return true;}
        } catch(Exception e){
            System.out.println("chi tiết phiếu xuất dao: isvaild to add " + e.getMessage());
            return false;}
        return true;
    }
    public int themCTPX(ChiTietPhieuXuatDTO ctpx) throws Exception{
        int res = 0;
        if (isValidtoAdd(ctpx)){
        try {
            String qry = "INSERT INTO ctpx VALUES(";
            qry = qry +"'"+ctpx.getMaPX()+"'";
            qry = qry +",'"+ctpx.getMaSP()+"'";
            qry = qry +",'"+ctpx.getDonGia()+"'";
            qry = qry +",'"+ctpx.getSoLuong()+"'";
            qry = qry +",'"+ctpx.getThanhTien()+"')";
            res = my.executeUpdate(qry);}
        catch(Exception e){
            System.out.println("chi tiết phiếu xuất dao: thêm CTPX " + e.getMessage());
            //JOptionPane.showMessageDialog(null, "Lỗi khi thêm chi tiết hóa đơn");
        }
            return res;
        }
        return res;
    }
   public int SuaCTPX(ChiTietPhieuXuatDTO ctpx){
        int res = 0;
        try{
            String qry ="UPDATE ctpx SET ";
            qry = qry + "DonGiaCTPX='"+ctpx.getDonGia()+"',";
            qry = qry + "SoLuong='"+ctpx.getSoLuong()+"',";
            qry = qry + "ThanhTienCTPX='"+ctpx.getThanhTien()+"'"; // Removed extra single quote
            qry = qry +" WHERE MaPx='"+ctpx.getMaPX()+"' AND MaSP='"+ctpx.getMaSP()+"'";
            res = my.executeUpdate(qry);}
        catch(Exception e){
            System.out.println("chi tiết phiếu xuất dao: sua CTPX " + e.getMessage());
            //JOptionPane.showMessageDialog(null, "Lỗi khi sửa chi tiết hóa đơn!!!");
        }
        return res;
    }

    public Vector docMapx(){
        String qry="select * from phieuxuat";
        Vector cbMa= new Vector();
        try {
            ResultSet rs = my.executeQuery(qry);
            while(rs.next()){
                cbMa.add(rs.getString(1));}
        } catch (Exception e) {
            System.out.println("chi tiết phiếu xuất dao: đọc mã px " + e.getMessage());
            //e.printStackTrace();
        }
        return cbMa;
    }
    public Vector docMaSP(){
        String qry="select * from sanpham";
        Vector cbMa= new Vector();
        try {
            ResultSet rs = my.executeQuery(qry);
            while(rs.next()){
                cbMa.add(rs.getString(1));}
        } catch (Exception e) {
            System.out.println("chi tiết phiếu xuất dao: isvaild to add " + e.getMessage());
        }
        return cbMa;
    }         
    public int getSLct(String mapx,String MaSP){
       int soluongct = 0;
       try{
           String qry = "select * from ctpx where MaPx='"+mapx+"' and MaSP='"+MaSP+"'";
           ResultSet rs = my.executeQuery(qry);
           while(rs.next()){
               soluongct = rs.getInt("SoLuong");
           }
       }catch(Exception e){
           System.out.println("chi tiết phiếu xuất dao: getSLCT " + e.getMessage());
       }    return soluongct;
    }   // lấy số lượng trong chi tiết hóa đơn
//    public double getgiamgiaCTKM(String MaSP,String makm){
//       double giamgiact = 0;
//       try{
//           String qry = "select * from ctkm where MaSP='"+MaSP+"' and MaKm ='"+makm+"'";
//           ResultSet rs = my.executeQuery(qry);
//           while(rs.next()){
//               giamgiact = rs.getDouble("PhanTramGGCT");
//           }
//       }catch(Exception e){
//           JOptionPane.showMessageDialog(null, "Lỗi lấy phần trăm KM cthd");
//       }       
//       return giamgiact;
//   }   // lấy phần trăm giảm giá của chi tiết khuyến mãi
    
   public double getTongtienfromCTPX(String mapx){
       double tongtien = 0;
       try{
           String qry = "select sum(ThanhTienCTPX) as TongTien from ctpx where MaPx='"+mapx+"'";
           ResultSet rs = my.executeQuery(qry);
           while(rs.next()){
               tongtien = rs.getDouble("TongTien");
           }
       }catch(Exception e){
           System.out.println("chi tiết phiếu xuất dao: getTongTienFromCTPX " + e.getMessage());
       }       
       return tongtien;
   }    // lấy tổng thành tiền cthd làm tổng tiền hóa đơn
   
  
}
