
package DAO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;

import  DTO.PhieuXuatDTO;
import untils.MyDataAccess;
public class PhieuXuatDAO {
    MyDataAccess my = new MyDataAccess("localhost","root","", "qlst");
    public PhieuXuatDAO(){}
    public ArrayList<PhieuXuatDTO> docPX() throws Exception{
        ArrayList<PhieuXuatDTO> list = new ArrayList<PhieuXuatDTO>();
        try{
            String qry = "select * from phieuxuat";
            ResultSet rs = my.executeQuery(qry); 
            while (rs.next()){
                PhieuXuatDTO hd = new PhieuXuatDTO();
                hd.setMaPX(rs.getString(1));
                hd.setMaNV(rs.getString(2));                
//                hd.setMaKH(rs.getString(3));
//                hd.setMaKM(rs.getString(4));
                hd.setNgayXuat(rs.getString(3));
                hd.setTongtien(rs.getDouble(4));
//                hd.setTienGiamGia(rs.getDouble(7));
//                hd.setThanhTien(rs.getDouble(8));
                list.add(hd);}
            }
        catch(Exception e){
                System.out.println("phieuxuatDAO: docPX " + e.getMessage());
               //JOptionPane.showMessageDialog(null, "Lỗi đọc Database!!!");
        }
        finally{
            my.close();}
            return list;
    }
    
    public boolean kiemtratrung(PhieuXuatDTO hd){
       try{
           ArrayList<PhieuXuatDTO> arr = docPX();
           for (int i = 0; i < arr.size(); i++) {
               if(arr.get(i).getMaPX().equals(hd.getMaPX())){
                JOptionPane.showMessageDialog(null,"Mã phiếu xuất đã tồn tại");
                return false;
               }
               else return true;
           }
        }catch(Exception e){
            return true;
        }
    return true;        
    }    
    
    public int themPX(PhieuXuatDTO hd){
        if (kiemtratrung(hd)){
            int res = 0;
            try {
                String qry = "INSERT INTO phieuxuat VALUES(";
                qry = qry + "'"+hd.getMaPX()+"'";
                qry = qry + ",'"+hd.getMaNV()+"'";
//                qry = qry + ",'"+hd.getMaKH()+"'";
//                qry = qry + ",'"+hd.getMaKM()+"'";
                qry = qry + ",'"+hd.getNgayXuat()+"'";
                qry = qry +",'"+hd.getTongtien()+"')";
//                qry = qry +",'"+hd.getTienGiamGia()+"'";
//                qry = qry + ",'"+hd.getThanhTien()+"')";
                res = my.executeUpdate(qry);
            }catch(Exception e){
                System.out.println("phieuxuatDAO: themPX " + e.getMessage());
               // JOptionPane.showMessageDialog(null,"Lỗi thêm hóa đơn vào Database");
            }
        return res;
        }
        return 0;
    }
    
    public int suaPX(PhieuXuatDTO hd){
        int res = 0;
        try{
            String qry = "UPDATE phieuxuat SET ";
                    qry = qry + "MaNv='"+hd.getMaNV()+"',";            
                    //qry = qry + "MaKh='"+hd.getMaKH()+"',";
                    //qry = qry + "MaKm='"+hd.getMaKM()+"',";
                    qry = qry + "NgayXuat='"+hd.getNgayXuat()+"',";
                    qry = qry + "TongTien='"+hd.getTongtien()+"'"; // Removed the trailing comma here               
                    //qry = qry + "TienGGHd='"+hd.getTienGiamGia()+"',";
                    //qry = qry + "ThanhTienHd='"+hd.getThanhTien()+"'";
                    qry = qry + " WHERE MaPx='"+hd.getMaPX()+"'";
                    res = my.executeUpdate(qry);

                res = my.executeUpdate(qry);} 
        catch(Exception e){
            System.out.println("phieuxuatDAO: suaPX " + e.getMessage());
            //JOptionPane.showMessageDialog(null, "Lỗi khi sửa hóa đơn trong DataBase!!!");
        }
            return res;
    }

   public Vector docManv(){
        String qry="select * from nhanvien";
        Vector cbMa= new Vector();
        try {
            ResultSet rs = my.executeQuery(qry);
            while(rs.next()){
                cbMa.add(rs.getString(1));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cbMa;
    }
   
//   public Vector docMakh(){
//        String qry="select * from khachhang";
//        Vector cbMa= new Vector();
//        try {
//            ResultSet rs = my.executeQuery(qry);
//            while(rs.next()){
//                cbMa.add(rs.getString(1));
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return cbMa;
//    }    
   
//   public Vector docMakm(){
//        String qry="select * from khuyenmai";
//        Vector cbMa= new Vector();
//        try {
//            ResultSet rs = my.executeQuery(qry);
//            while(rs.next()){
//                cbMa.add(rs.getString(1));
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return cbMa;
//    }     
      
   public double getTongtienfromPX(String mapx){
       double tongtien = 0;
       try{
           String qry = "select * from phieuxuat where MaPx='"+mapx+"'";
           ResultSet rs = my.executeQuery(qry);
           while(rs.next()){
               tongtien = rs.getDouble("TongTien");
           }
       }catch(Exception e){
           System.out.println("phieuxuatDAO: tongtienPX " + e.getMessage());
          // JOptionPane.showMessageDialog(null, "Lỗi lấy tổng tiền của phiếu xuất");
       }       
       return tongtien;       
   }    // lấy tổng tiền của hóa đơn
   
//   public int changeThanhtien_afterdec(String mahd,double thanhtien){
//       int res = 0;
//       try{
//           String qry = "update hoadon set ThanhTienHd='"+thanhtien+"' where MaHd='"+mahd+"'";
//           res = my.executeUpdate(qry);
//       }catch(Exception e){
//           JOptionPane.showMessageDialog(null, "Lỗi sửa thành tiền sau khi giảm của hóa đơn");
//       }       
//       return res;
//   }    // sửa thành tiền sau khi giảm
//
//   public int changeTienGGHd_afterdone(String mahd,double tongtiengiam){
//       int res = 0;
//       try{
//           String qry = "update hoadon set TienGGHd='"+tongtiengiam+"' where MaHd='"+mahd+"'";
//           res = my.executeUpdate(qry);
//       }catch(Exception e){
//           JOptionPane.showMessageDialog(null, "Lỗi sửa thành tiền sau khi giảm của hóa đơn");
//       }       
//       return res;
//   }    // sửa tổng tiền giảm giá cuối cùng của hóa đơn sau khi tác động từ cthd  
//   
    public int changeTongtienPXfromCT(String mapx,double tongtien){
       int res = 0;
       try{
           String qry =  "update phieuxuat set TongTien='"+tongtien+ "' where MaPx='"+mapx+"'";
           res = my.executeUpdate(qry);
       }catch(Exception e){
           System.out.println("phieuxuatDAO: changeTongTienPx " + e.getMessage());
           JOptionPane.showMessageDialog(null, "Lỗi sửa tổng tiền của phiếu xuất");
       }       
       return res;
   }//sửa tổng tiền hóa đơn khi tác động cthd
   
//   public double getTienGGHdfromHD(String mahd){
//       double tiengghd = 0;
//       try{
//           String qry = "select * from hoadon where MaHd='"+mahd+"'";
//           ResultSet rs = my.executeQuery(qry);
//           while(rs.next()){
//               tiengghd = rs.getDouble("TienGGHd");
//           }
//       }catch(Exception e){
//           JOptionPane.showMessageDialog(null, "Lỗi lấy tổng tiền giảm của hóa đơn");}       
//       return tiengghd;
//   }    //lấy tổng tiền giảm trong hóa đơn
//
//   public int changeMaKM(PhieuXuatDTO hd){
//       int res = 0;
//       try{
//           String qry = "update hoadon set MaKm='"+hd.getMaKM()+"' where MaHd='"+hd.getMaHD()+"'";
//           res = my.executeUpdate(qry);
//       }catch(Exception e){
//           JOptionPane.showMessageDialog(null, "Lỗi sửa mã khuyến mãi");
//       }       
//       return res;       
//   }    //sửa mã khuyến mãi
//   
//   public String getMaKmfromHD(String mahd){
//       String makm = null;
//       try{
//           String qry = "select * from hoadon where hoadon.MaHd = '"+mahd+"'";
//           ResultSet rs = my.executeQuery(qry);
//           while(rs.next()){
//               makm = rs.getString("MaKm");
//           }
//       }catch(Exception e){
//           JOptionPane.showMessageDialog(null, "Lỗi lấy mã khuyến mãi của hóa đơn");}       
//       return makm;
//   }    // lấy mã khuyến mãi của hóa đơn   
//   
}
