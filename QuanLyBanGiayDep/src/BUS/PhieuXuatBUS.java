package BUS;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.JOptionPane;

import DAO.PhieuXuatDAO;
import DTO.PhieuXuatDTO;

public class PhieuXuatBUS {
    public static ArrayList<PhieuXuatDTO> list;
    
    public PhieuXuatBUS() {}
    
    public ArrayList<PhieuXuatDTO> docPX() {
        PhieuXuatDAO data = new PhieuXuatDAO();
        try {
                list = new ArrayList<PhieuXuatDTO>();
                list = data.docPX();
        } catch (Exception e) {
            e.printStackTrace();}
        return list;
    }

    public int themPX(PhieuXuatDTO px) {
        PhieuXuatDAO data = new PhieuXuatDAO();
        int check = data.themPX(px);
        if (check == 1) {
            list.add(px);}
        return check;
    }

    public int suaPX(PhieuXuatDTO px, int i) {
        PhieuXuatDAO data = new PhieuXuatDAO();
        int check = data.suaPX(px);
        if (check == 1) {
            list.set(i, px);
        }
        return check;
    }

    public ArrayList<PhieuXuatDTO> timKiemPX(String key, String query) {
        ArrayList<PhieuXuatDTO> temp = new ArrayList<>();
        PhieuXuatDAO data = new PhieuXuatDAO();
        try {
            ArrayList<PhieuXuatDTO> px = data.docPX();
            if (key.equals("Mã phiếu xuất")) {
                for (int i = 0; i < px.size(); i++) {
                    if (px.get(i).getMaPX().toLowerCase().equals(query)) {
                        temp.add(px.get(i));}
                }
                return temp;
            }
            if (key.equals("Mã nhân viên")) {
                for (int i = 0; i < px.size(); i++) {
                    if (px.get(i).getMaNV().toLowerCase().equals(query)) {
                        temp.add(px.get(i));}
                }
                return temp;
            }
//            if (key.equals("Mã khách hàng")) {
//                for (int i = 0; i < hd.size(); i++) {
//                    if (hd.get(i).getMaKH().toLowerCase().equals(query)) {
//                        temp.add(hd.get(i));}
//                }
//                return temp;
//            }
//            if (key.equals("Mã khuyến mãi")) {
//                for (int i = 0; i < hd.size(); i++) {
//                    if (hd.get(i).getMaKM().toLowerCase().equals(query)) {
//                        temp.add(hd.get(i));}
//                }
//                return temp;
//            }
        } catch (Exception e) {
            e.printStackTrace();}
        return null;
    }
    public ArrayList<PhieuXuatDTO> timkiemPXnc(String key, String value1, String value2)  {
        ArrayList<PhieuXuatDTO> temp = new ArrayList<>();
        PhieuXuatDAO data = new PhieuXuatDAO();
        try {
            ArrayList<PhieuXuatDTO> hd = data.docPX();
            if (key.equals("Tổng tiền")) {
                for (int i = 0; i<hd.size(); i++){
                    if ((Double.parseDouble(value2)>=hd.get(i).getTongtien() && value1.equals(""))
                            || (Double.parseDouble(value1) <= hd.get(i).getTongtien() && Double.parseDouble(value2) >= hd.get(i).getTongtien())
                            || (Double.parseDouble(value1)<=hd.get(i).getTongtien() && value2.equals(""))){
                    temp.add(hd.get(i));}
                }
            }
//            if (key.equals("Tiền giảm giá")) {
//                for (int i = 0; i < hd.size(); i++) {
//                if ((Double.parseDouble(value2)>=hd.get(i).getTienGiamGia()&& value1.equals(""))
//                        || (Double.parseDouble(value1) <= hd.get(i).getTienGiamGia()&& Double.parseDouble(value2) >= hd.get(i).getTienGiamGia())
//                        || (Double.parseDouble(value1)<=hd.get(i).getTienGiamGia()&& value2.equals(""))){
//                        temp.add(hd.get(i));}
//                    }
//                return temp;
//           }
        }catch (Exception e){
            e.printStackTrace();}
        return temp;
    }
    public Date FormatofDate(String str) throws ParseException{
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(true);
        Date date = format.parse(str);
        return date;
    }    
    public ArrayList<PhieuXuatDTO> timtheoNgay(String from,String to){
        ArrayList<PhieuXuatDTO> arr = new ArrayList<PhieuXuatDTO>();
        try{
            for(PhieuXuatDTO px: docPX()){
                if(FormatofDate(px.getNgayXuat()).compareTo(FormatofDate(from))>= 0 
                        && FormatofDate(px.getNgayXuat()).compareTo(FormatofDate(to))<=0)
                    arr.add(px);
            }
        }catch(Exception e){
            e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Không thể tìm được ngày");}
        return arr;
    }
    public Vector loadcb_nv(){
        PhieuXuatDAO data= new PhieuXuatDAO();
        Vector cbMa= data.docManv();
        return cbMa;
    }
//    public Vector loadcb_kh(){
//        PhieuXuatDAO data= new PhieuXuatDAO();
//        Vector cbMa= data.docMakh();
//        return cbMa;
//    }
//    public Vector loadcb_km(){
//        PhieuXuatDAO data= new PhieuXuatDAO();
//        Vector cbMa= data.docMakm();
//        return cbMa;
//    }
    
   public double getTongtienfromPX(String mapx){
        PhieuXuatDAO data = new PhieuXuatDAO();
        double tongtien = data.getTongtienfromPX(mapx);
        return tongtien;     
    }
//   public int changeThanhtien_afterdec(String mahd,double thanhtien){
//        PhieuXuatDAO data = new PhieuXuatDAO();
//        int check = data.changeThanhtien_afterdec(mahd,thanhtien);
//        return check;    
//   }
//   public double getTienGGHdfromHD(String mahd){
//        PhieuXuatDAO data = new PhieuXuatDAO();
//        double tiengiamgia1 = data.getTienGGHdfromHD(mahd);
//        return tiengiamgia1;      
//   }
//   public int changeMaKM(PhieuXuatDTO hd){
//        PhieuXuatDAO data = new PhieuXuatDAO();
//        int check = data.changeMaKM(hd);
//        return check;    
//   }
//   public int changeTienGGHd_afterdone(String mahd,double tongtiengiam){
//        PhieuXuatDAO data = new PhieuXuatDAO();
//        int check = data.changeTienGGHd_afterdone(mahd,tongtiengiam);
//        return check;    
//   }
    public int changeTongtienPXfromCT(String mahd,double tongtien){
        PhieuXuatDAO data = new PhieuXuatDAO();
        int check = data.changeTongtienPXfromCT(mahd,tongtien);
        return check;     
    }   
//    public String getMaKmfromHD(String mahd){
//        PhieuXuatDAO data = new PhieuXuatDAO();
//        String makm = data.getMaKmfromHD(mahd);
//        return makm;
//    }
    
}
