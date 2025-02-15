
package BUS;

import java.util.ArrayList;
import java.util.Vector;

import DAO.ChiTietPhieuXuatDAO;
import DTO.ChiTietPhieuXuatDTO;

public class ChiTietPhieuXuatBUS {
    
    public static ArrayList<ChiTietPhieuXuatDTO> listctpx;
    
    public ChiTietPhieuXuatBUS(){}
    
    public ArrayList<ChiTietPhieuXuatDTO> docCTPX(){
        ChiTietPhieuXuatDAO data = new ChiTietPhieuXuatDAO();
        try{
                listctpx = new ArrayList<>();
                listctpx = data.docCTPX(); 
        }catch (Exception e){
            e.printStackTrace();}
        return listctpx;
    }
    
    public int themCTPX(ChiTietPhieuXuatDTO ct) throws Exception{
        ChiTietPhieuXuatDAO data = new ChiTietPhieuXuatDAO();
        int check  = data.themCTPX(ct);
        if (check == 1 ) listctpx.add(ct);
        return check;
    }
    public int suaCTPX(ChiTietPhieuXuatDTO ct, int i){
        ChiTietPhieuXuatDAO data = new ChiTietPhieuXuatDAO();
        int check = data.SuaCTPX(ct);
        if (check == 1) listctpx.set(i, ct);
        return check;        
    }
    public Vector loadcb_hd(){
        ChiTietPhieuXuatDAO data = new ChiTietPhieuXuatDAO();
        Vector cbMa= data.docMapx();
        return cbMa;
    }
    public Vector loadcb_sanpham(){
        ChiTietPhieuXuatDAO data = new ChiTietPhieuXuatDAO();
        Vector cbMa= data.docMaSP();
        return cbMa;
    }
    public ArrayList<ChiTietPhieuXuatDTO> timKiemCTPX(String key, String query) {
        ArrayList<ChiTietPhieuXuatDTO> temp = new ArrayList<>();
        ChiTietPhieuXuatDAO data = new ChiTietPhieuXuatDAO();
        try {
            ArrayList<ChiTietPhieuXuatDTO> hd = data.docCTPX();
            if (key.equals("Mã phiếu xuất")) {
                for (int i = 0; i < hd.size(); i++) {
                    if (hd.get(i).getMaPX().toLowerCase().equals(query)) {
                        temp.add(hd.get(i));}
                }
                return temp;
            }
            if (key.equals("Mã sản phẩm")) {
                for (int i = 0; i < hd.size(); i++) {
                    if (hd.get(i).getMaSP().toLowerCase().equals(query)) {
                        temp.add(hd.get(i));}
                }
                return temp;
            }
        } catch (Exception e) {
            e.printStackTrace();}
        return null;
    }
    public ArrayList<ChiTietPhieuXuatDTO> timkiemCTPXnc(String key, String value1, String value2)  {
        ArrayList<ChiTietPhieuXuatDTO> temp = new ArrayList<>();
        ChiTietPhieuXuatDAO data = new ChiTietPhieuXuatDAO();
        try {
            ArrayList<ChiTietPhieuXuatDTO> hd = data.docCTPX();
            if (key.equals("Đơn giá")) {
                for (int i = 0; i<hd.size(); i++){
                    if ((Double.parseDouble(value2)>=hd.get(i).getDonGia()&& value1.equals(""))
                            || (Double.parseDouble(value1) <= hd.get(i).getDonGia()&& Double.parseDouble(value2) >= hd.get(i).getDonGia())
                            || (Double.parseDouble(value1)<=hd.get(i).getDonGia()&& value2.equals(""))){
                    temp.add(hd.get(i));}
                }
            }
            if (key.equals("Thành tiền")) {
                for (int i = 0; i < hd.size(); i++) {
                if ((Double.parseDouble(value2)>=hd.get(i).getThanhTien()&& value1.equals(""))
                        || (Double.parseDouble(value1) <= hd.get(i).getThanhTien()&& Double.parseDouble(value2) >= hd.get(i).getThanhTien())
                        || (Double.parseDouble(value1)<=hd.get(i).getThanhTien()&& value2.equals(""))){
                        temp.add(hd.get(i));}
                    }
                return temp;
           }
        }catch (Exception e){
            e.printStackTrace();}
        return temp;
    }
    public int getSLct(String mapx,String MaSP) {
        ChiTietPhieuXuatDAO data = new ChiTietPhieuXuatDAO();
        int check = data.getSLct(mapx,MaSP);
        return check;
    }
//    public double getgiamgiaCTKM(String MaSP,String makm){
//        ChiTietPhieuXuatDAO data = new ChiTietPhieuXuatDAO();
//        double check = data.getgiamgiaCTKM(MaSP,makm);
//        return check;
//    }
//   public double getTienGGHdfromCTHD(String mahd){
//        ChiTietPhieuXuatDAO data = new ChiTietPhieuXuatDAO();
//        double tiengiamgia2 = data.getTienGGHdfromCTHD(mahd);
//        return tiengiamgia2;   
//   }
    public double getTongtienfromCTPX(String mapx){
        ChiTietPhieuXuatDAO data = new ChiTietPhieuXuatDAO();
        double tongtien = data.getTongtienfromCTPX(mapx);
        return tongtien;
    }   
}
