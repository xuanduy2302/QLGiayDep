
package BUS;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import DAO.NhanVienDAO;
import DTO.ChuyenChucDTO;
import DTO.LuongThangDTO;
import DTO.NhanVienDTO;
import untils.CurrencyUtil;

public class NhanVienBUS {
    public static ArrayList<NhanVienDTO> list;   
    public static ArrayList<LuongThangDTO> luongThangList;
    private static final int LUONG_CO_BAN = 1500000;
    public NhanVienBUS(){}
    
    public void chamCong(String MaNv) {
        NhanVienDAO data = new NhanVienDAO();        
        try{
            data.chamCong(MaNv);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public ArrayList<NhanVienDTO> docNv(){
        NhanVienDAO data = new NhanVienDAO();
        try{
            list = new ArrayList<NhanVienDTO>();
            list = data.docNv();
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<NhanVienDTO> docNvActive() {
        NhanVienDAO data = new NhanVienDAO();
        try {
            list = new ArrayList<>();
            ArrayList<NhanVienDTO> allEmployees = data.docNv();
            for (NhanVienDTO employee : allEmployees) {
                if (employee.getTrangThai()) {
                    list.add(employee);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    
    public List<String> getMaNhanVien() { 
         ArrayList<NhanVienDTO> activeEmployees = docNvActive();

        List<String> maNhanVienList = new ArrayList<>();
        for (NhanVienDTO employee : activeEmployees) {
            maNhanVienList.add(employee.getMaNV());
        }
        
        return maNhanVienList;
  }
    
    public ArrayList<NhanVienDTO> docNvAll(){
        NhanVienDAO data = new NhanVienDAO();
        try{
            list = new ArrayList<NhanVienDTO>();
            list = data.docNvAll();
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<NhanVienDTO> docTaiKhoan(){
        NhanVienDAO data = new NhanVienDAO();
        try{
            list = new ArrayList<>();
            list = data.docTaiKhoan();
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    
    public NhanVienDTO doiTrangThai(String MaNV) throws Exception {
       NhanVienDAO data = new NhanVienDAO();
       NhanVienDTO nv = data.doiTrangThai(MaNV);
       return nv;
    }
    
    public NhanVienDTO getNhanVienById(String MaNV) {
       NhanVienDAO data = new NhanVienDAO();
       NhanVienDTO nv = new NhanVienDTO();
        try {
            nv = data.getNhanVienById(MaNV);
        } catch (Exception ex) {
            Logger.getLogger(NhanVienBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nv;

    }
    
    public int themNv(NhanVienDTO nv){
        NhanVienDAO data = new NhanVienDAO();
        LoginBUS loginBUS = new LoginBUS();
        int check = data.themNv(nv);
        if(check==1)
            list.add(nv);
            loginBUS.themLogin(nv.getMaNV());     
        return check;
    }
    
    
    public int suaNv(NhanVienDTO nv,int i){
        NhanVienDAO data = new NhanVienDAO();
        int check = data.suaNv(nv);
        if(check ==1)
            list.set(i,nv);
        return check;
    }    
    
    public int suaNv2(NhanVienDTO nv){
        NhanVienDAO data = new NhanVienDAO();
        return data.suaNv(nv);
    }  
    
    public List<LocalDate> getAttendanceDates(String maNv, int year, int month) {
        NhanVienDAO data = new NhanVienDAO();
        return data.getAttendanceDates(maNv, year, month);
    }
    
    public List<ChuyenChucDTO> chuyenChucTrongThang(String MaNv, String firstDate, String lastDate){
        NhanVienDAO data = new NhanVienDAO();
        return data.chuyenChucTrongThang(MaNv, firstDate, lastDate);
    }
    
    public ChuyenChucDTO chucVuThangTruocDo(String MaNv, String date){
        NhanVienDAO data = new NhanVienDAO();
        return data.chucVuThangTruocDo(MaNv,date);
    }
    
    public List<ChuyenChucDTO> getChucVuTrongThang(String MaNv, List<LocalDate> chamCongTrongThang, ChuyenChucDTO chucTruocDo){
        String ngayDauTien = chamCongTrongThang.get(0).toString();
        String ngayCuoiCung = chamCongTrongThang.get(chamCongTrongThang.size() - 1).toString();
        List<ChuyenChucDTO> viTriDoiTrongThang = chuyenChucTrongThang(MaNv, ngayDauTien, ngayCuoiCung);
        
        return Stream.concat(
                Stream.of(new ChuyenChucDTO("1", chucTruocDo.getChucvu(), chucTruocDo.getHeSoLuong())),
                Stream.concat(viTriDoiTrongThang.stream(), 
                Stream.of(new ChuyenChucDTO(Integer.toString(chamCongTrongThang.size()), null, null)))
        ).collect(Collectors.toList());
    }
    
     public String tinhToanTongLuong(List<ChuyenChucDTO> chucVuTrongThang) {
        double tongLuong = 0;
        for (int i = 1; i < chucVuTrongThang.size(); i++) {
            ChuyenChucDTO hienTai = chucVuTrongThang.get(i);
            ChuyenChucDTO quaKhu = chucVuTrongThang.get(i - 1);

            int ngayHienTai = Integer.parseInt(hienTai.getNgayChuyenChuc());
            int ngayQuaKhu = Integer.parseInt(quaKhu.getNgayChuyenChuc());

            if(ngayHienTai < ngayQuaKhu) {
                ngayHienTai = ngayQuaKhu;
            }

            int ngay = ngayHienTai - ngayQuaKhu;
            
            
            if (ngay == 0) {
                ngay = 1;
            }
  
            System.out.println("NVBus - Date 0 in test luong: " + hienTai.getNgayChuyenChuc());
            tongLuong += ngay * Double.parseDouble(quaKhu.getHeSoLuong());
        }
        
        tongLuong = Math.round(tongLuong * 100.0 * LUONG_CO_BAN) / 100.0;
        
        return CurrencyUtil.formatNumber(tongLuong);
        
    }
    
    public String tinhLuongThang(String MaNv,String month, String year) {
        ChuyenChucDTO chucTruocDo = chucVuThangTruocDo(MaNv, year + "-" + month + "-00");
        
        List<LocalDate> chamCongTrongThang = getAttendanceDates(MaNv, Integer.parseInt(year), Integer.parseInt(month));
        
        if (chamCongTrongThang.isEmpty()) {
                return "0";
            }
        
        List<ChuyenChucDTO> chucVuTrongThang = getChucVuTrongThang(MaNv, chamCongTrongThang, chucTruocDo);
        System.out.println("Tính lương tháng: " + month + " năm: " + year);
        System.out.println("Dữ liệu chấm công: " + chamCongTrongThang);

       // inChucVuThayDoi(chucVuTrongThang, MaNv);
        
        return tinhToanTongLuong(chucVuTrongThang);        
    }
    
    private void inChucVuThayDoi(List<ChuyenChucDTO> positionChanges, String employeeId) {
        if (positionChanges.size() == 2) {
            System.out.println("No position changes found for employee " + employeeId);
        } else {
            System.out.println("Employee Position Changes for " + employeeId + ":\n");
            for (ChuyenChucDTO change : positionChanges) {
                System.out.println("  - Date: " + change.getNgayChuyenChuc() + ", Position: " + change.getChucvu() + ",Hệ số lương: " + change.getHeSoLuong());
            }
        }
    }
    
    public void insertOrUpdateLuongThang(String maNv, double tongLuong, String chucVu, String datetime) {
        NhanVienDAO data = new NhanVienDAO();
        if (data.recordExists(maNv, datetime)) {
        	System.out.println("Ngày lương: " + datetime);
            data.updateRecord(maNv, tongLuong, chucVu, datetime);
        } else {
        	System.out.println("Ngày lương: " + datetime);
            data.insertRecord(maNv, tongLuong, chucVu, datetime);
        }
    }
    
    public List<LuongThangDTO> getAllLuongThang() {
        NhanVienDAO data = new NhanVienDAO();
        try{
            luongThangList = (ArrayList<LuongThangDTO>) data.getAllLuongThang();
        }catch(Exception e){
            e.printStackTrace();
        }
        return luongThangList;
    }
    
    public List<LuongThangDTO> getLuongThangByID(String maNv) {
        NhanVienDAO data = new NhanVienDAO();
        try{
            luongThangList = (ArrayList<LuongThangDTO>) data.getLuongThangByID(maNv);
        }catch(Exception e){
            e.printStackTrace();
        }
        return luongThangList;
    }
    
    public List<Integer> getThangLamViecTrongNam(String maNv, int year) {
        NhanVienDAO data = new NhanVienDAO();
        return data.getThangLamViecTrongNam(maNv, year);
    }
    
    public List<Integer> tongLuongTrongThang(int year) {
        try {
            NhanVienDAO data = new NhanVienDAO();
            return data.tongLuongTrongThang(year);
        } catch (Exception e) {
            System.out.println("NhanVienBus: tongLuongTrongThang " + e.getMessage());
            return null;
        }
    }
    
    public ResultSet soSanhLuongNam() {
        NhanVienDAO data = new NhanVienDAO();
        return data.soSanhLuongNam();
    }
    public String getMaNVByUsername(String maNV) {
    	return maNV;
    }


}
