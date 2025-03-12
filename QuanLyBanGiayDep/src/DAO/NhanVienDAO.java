
package DAO;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import DTO.ChuyenChucDTO;
import DTO.LuongThangDTO;
import DTO.NhanVienDTO;
import untils.MyDataAccess;

public class NhanVienDAO {
    MyDataAccess my = new MyDataAccess("localhost","root","","qlst");
    public NhanVienDAO(){}
    
    public ArrayList<NhanVienDTO> docNv() throws Exception{
        ArrayList<NhanVienDTO> list=new ArrayList<NhanVienDTO>();
        try {
            String qry="SELECT * FROM nhanvien WHERE ChucVu LIKE '%Nhân viên%'";
            ResultSet rs = my.executeQuery(qry);
            while(rs.next()){
             NhanVienDTO nv=new NhanVienDTO();
             nv.setMaNV(rs.getString(1));
             nv.setHoNV(rs.getString(2));
             nv.setTenNV(rs.getString(3));
             nv.setDiaChiNV(rs.getString(4));
             nv.setChucVuNV(rs.getString(5));
             nv.setTrangThai(rs.getBoolean(6));
             list.add(nv);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Lỗi đọc Database");}
        finally{    
            my.close();
        }
        return list;
    }
    
    public void chamCong(String MaNv) {
        try {
            String qry = "INSERT IGNORE INTO chamCongNgay (MaNv, datetime) VALUES ('" + MaNv + "', CURDATE())";
            my.executeUpdate(qry);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public ArrayList<NhanVienDTO> docNvAll() throws Exception{
        ArrayList<NhanVienDTO> list=new ArrayList<NhanVienDTO>();
        try {
            String qry="SELECT * FROM nhanvien WHERE ChucVu LIKE '%Nhân viên%' or ChucVu='Quản lý'";
            ResultSet rs = my.executeQuery(qry);
            while(rs.next()){
             NhanVienDTO nv=new NhanVienDTO();
             nv.setMaNV(rs.getString(1));
             nv.setHoNV(rs.getString(2));
             nv.setTenNV(rs.getString(3));
             nv.setDiaChiNV(rs.getString(4));
             nv.setChucVuNV(rs.getString(5));
             nv.setTrangThai(rs.getBoolean(6));
             list.add(nv);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Lỗi đọc Database");}
        finally{    
            my.close();
        }
        return list;
    }
    
    public ArrayList<NhanVienDTO> docTaiKhoan() throws Exception{
        ArrayList<NhanVienDTO> list=new ArrayList<NhanVienDTO>();
        try {
            String qry="SELECT * FROM nhanvien where TrangThai !=0";
            ResultSet rs = my.executeQuery(qry);
            while(rs.next()){
             NhanVienDTO nv=new NhanVienDTO();
             nv.setMaNV(rs.getString(1));
             nv.setHoNV(rs.getString(2));
             nv.setTenNV(rs.getString(3));
             nv.setDiaChiNV(rs.getString(4));
             nv.setChucVuNV(rs.getString(5));
             nv.setTrangThai(rs.getBoolean(6));
             list.add(nv);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Lỗi đọc Database");}
        finally{    
            my.close();
        }
        
        return list;
    }
    
    public NhanVienDTO getNhanVienById(String MaNV) throws Exception {
        NhanVienDTO result = null;
        try {
            String qry = "SELECT * FROM nhanvien WHERE MaNv = '" + MaNV + "'";
            ResultSet rs = my.executeQuery(qry);
            if (rs.next()) {
                NhanVienDTO nv = new NhanVienDTO();
                nv.setMaNV(rs.getString(1));
                nv.setHoNV(rs.getString(2));
                nv.setTenNV(rs.getString(3));
                nv.setDiaChiNV(rs.getString(4));
                nv.setChucVuNV(rs.getString(5));
                nv.setTrangThai(rs.getBoolean(6));
                result = nv;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Lỗi đọc Database");
        } finally {    
            my.close();
        }
        return result;
    }
    
    public NhanVienDTO doiTrangThai(String MaNV) throws Exception {
        NhanVienDTO result = null;
        try {
            System.out.println("mã nv: " + MaNV);
            String qry = "UPDATE nhanvien SET TrangThai = NOT TrangThai WHERE MaNV = '" + MaNV + "'";
            my.executeUpdate(qry);
            result = getNhanVienById(MaNV);
            System.out.print("trạng thái :" + result.getTrangThai() );
        } catch (Exception ex) {
            System.out.print(ex);
        } finally {    
            my.close();
        }
        return result;
    }



    
    public boolean isValidtoAdd(NhanVienDTO nv){
       try{
           ArrayList<NhanVienDTO> arr = docNv();
           for (int i = 0; i < arr.size(); i++) {
               if(arr.get(i).getMaNV().equals(nv.getMaNV())){
                JOptionPane.showMessageDialog(null,"Mã nhân viên đã tồn tại");
                return false;}
               else return true;}
        }catch(Exception e){
            return true;
        }
    return true;        
    }
    
    public int themNv(NhanVienDTO nv){
        if(isValidtoAdd(nv)){
        int res = 0;
        try{
                String qry = "insert into nhanvien values(";
                qry = qry +"'"+nv.getMaNV()+"'";
                qry = qry +",'"+nv.getHoNV()+"'";
                qry = qry +",'"+nv.getTenNV()+"'";
                qry = qry+",'"+nv.getDiaChiNV()+"'";
                qry = qry+",'"+nv.getChucVuNV()+"'";
                qry = qry+","+nv.getTrangThai()+")";
                res = my.executeUpdate(qry);
                
                insertOrUpdateChuyenChuc(nv.getMaNV(),nv.getChucVuNV());
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Lỗi thêm nhân viên Database");
            }
        return res;
        }
        return 0;
    }
    public int suaNv(NhanVienDTO nv){
        int res = 0;
        try{
            String qry = "UPDATE nhanvien " +
             "SET HoNv = '" + nv.getHoNV() + "', " +
             "    TenNv = '" + nv.getTenNV() + "', " +
             "    DiaChiNv = '" + nv.getDiaChiNV() + "', " +
             "    ChucVu = '" + nv.getChucVuNV() + "' " +
             "WHERE MaNv = '" + nv.getMaNV() + "'";
           
            res = my.executeUpdate(qry);
            insertOrUpdateChuyenChuc(nv.getMaNV(),nv.getChucVuNV());            
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Lỗi sửa nhân viên Database");
        }
        return res;
    }

    public List<LocalDate> getAttendanceDates(String maNv, int year, int month) {
        List<LocalDate> attendanceDates = new ArrayList<>();
        try {
            String qry = "SELECT datetime FROM chamCongNgay WHERE MaNv = '" + maNv + "' AND YEAR(datetime) = " + year + " AND MONTH(datetime) = " + month;
            ResultSet rs = my.executeQuery(qry);

            while (rs.next()) {
                attendanceDates.add(rs.getDate("datetime").toLocalDate());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return attendanceDates;
    }

    public ChuyenChucDTO chucVuThangTruocDo(String MaNv, String date) {     
        ChuyenChucDTO change = null;
        try{           
//            String qry = "SELECT ch.chucVu, bcv.hesoluong " +
//             "FROM chuyenchuc ch " +
//             "INNER JOIN chucVu bcv ON ch.chucVu = bcv.chucVu " +
//             "WHERE ch.datetime < '" + date + "' " +
//             "AND ch.MaNv = '" + MaNv + "' " +
//             "ORDER BY ch.datetime DESC " +
//             "LIMIT 1";

            String qry = "SELECT chucVu, hesoluong " +
             "FROM (" +
             "  (SELECT ch.chucVu, ch.manv, bcv.hesoluong " +
             "   FROM chuyenchuc ch " +
             "   INNER JOIN chucVu bcv ON ch.chucVu = bcv.chucVu " +
             "   WHERE ch.manv = '" + MaNv + "' AND ch.datetime < '" + date + "' " +
             "   ORDER BY ch.datetime DESC " +
             "   LIMIT 1) " +
             "  UNION ALL " +
             "  (SELECT ch.chucVu, ch.manv, bcv.hesoluong " +
             "   FROM chuyenchuc ch " +
             "   INNER JOIN chucVu bcv ON ch.chucVu = bcv.chucVu " +
             "   WHERE ch.manv = '" + MaNv + "' AND ch.datetime >= '" + date + "' " +
             "   ORDER BY ch.datetime DESC " +
             "   LIMIT 1) " +
             ") AS subquery " +
             "ORDER BY CASE WHEN chucVu IS NULL THEN 1 ELSE 0 END, chucVu " +
             "LIMIT 1";

            
            ResultSet rs = my.executeQuery(qry);
            
            if (rs.next()) {
                String chucVu = rs.getString("chucVu");
                String heSoLuong = rs.getString("heSoLuong");
                
               change = new ChuyenChucDTO(null, chucVu, heSoLuong);            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return change;
    }    
    
    public List<ChuyenChucDTO> chuyenChucTrongThang(String MaNv, String firstDate, String lastDate){
        List<ChuyenChucDTO> bangChuyenChuc = new ArrayList<>();
        try {
            
            String qry = "SELECT DISTINCT " +
             "LPAD(DAY(ch.datetime), 2, '0') AS ngayChuyenChuc, " +
             "ch.chucVu AS chucVu, " +
             "bcv.hesoluong AS hesoluong " +
             "FROM chamcongngay cc " +
             "INNER JOIN chuyenChuc ch ON cc.MaNv = ch.MaNv " +
             "INNER JOIN chucVu bcv ON ch.chucVu = bcv.chucVu " +
             "WHERE ch.datetime BETWEEN '" + firstDate + "' AND '" + lastDate + "' " +  
             "AND cc.MaNv = '" + MaNv + "'";

            
            ResultSet rs = my.executeQuery(qry);

           while (rs.next()) {
                String ngayChuyenChuc = rs.getString("ngayChuyenChuc");
                String chucVu = rs.getString("chucVu");
                String heSoLuong = rs.getString("heSoLuong");

                ChuyenChucDTO change = new ChuyenChucDTO(ngayChuyenChuc, chucVu, heSoLuong);
                bangChuyenChuc.add(change);            
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
            
        return bangChuyenChuc;
    }
    
    public void insertOrUpdateChuyenChuc(String maNv, String chucVu) {
        LocalDate today = LocalDate.now();            
        String datetime = today.format(java.time.format.DateTimeFormatter.ISO_LOCAL_DATE);
        int count = kiemTraDuLieu(maNv, datetime);

        if (count == 0) { 
            try{
                String qry = "INSERT INTO chuyenchuc (MaNv, chucVu, datetime) VALUES ('" + maNv + "', '" + chucVu + "', '" + datetime + "')";
                my.executeUpdate(qry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else { 
            String qry = "UPDATE chuyenchuc SET chucVu = '" + chucVu + "' WHERE MaNv = '" + maNv + "' AND datetime = '" + datetime + "'";
            try{
                my.executeUpdate(qry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public int kiemTraDuLieu(String maNv, String datetime) {
        int count = 0;
        try{
            String qry = "SELECT COUNT(*) FROM chuyenchuc WHERE MaNv = '" +maNv 
                    + "' AND YEAR(datetime) = YEAR('" + datetime + "') AND MONTH(datetime) = MONTH('" + datetime + "')";
            ResultSet rs = my.executeQuery(qry);
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
    
    public boolean recordExists(String maNv, String datetime) {
        try {
            ResultSet rs = my.executeQuery("SELECT * FROM luongthang WHERE MaNv = '" + maNv 
                + "' AND YEAR(datetime) = YEAR('" + datetime + "') AND MONTH(datetime) = MONTH('" + datetime + "')");
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void insertRecord(String maNv, double tongLuong, String chucVu, String datetime) {
        try {
            String qry = "INSERT INTO luongthang(MaNv, tongluong, chucVu, datetime) VALUES ('" 
                + maNv + "', " + tongLuong + ", '" + chucVu + "', '" + datetime + "')";
            my.executeUpdate(qry);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateRecord(String maNv, double tongLuong, String chucVu, String datetime) {
        try {
            String qry = "UPDATE luongthang SET tongluong=" + tongLuong + ", chucVu='" + chucVu 
                + "' WHERE MaNv = '" + maNv + "' AND YEAR(datetime) = YEAR('" + datetime 
                + "') AND MONTH(datetime) = MONTH('" + datetime + "')";
            my.executeUpdate(qry);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<LuongThangDTO> getAllLuongThang() {
        List<LuongThangDTO> luongThangList = new ArrayList<>();
        try {
            ResultSet rs = my.executeQuery("SELECT * FROM luongthang");

            while (rs.next()) {
                LuongThangDTO lt = new LuongThangDTO();
                lt.setMaNv(rs.getString("MaNv"));
                lt.setTongLuong(rs.getBigDecimal("tongluong"));
                lt.setChucVu(rs.getString("chucVu"));
                lt.setDatetime(rs.getDate("datetime"));
                luongThangList.add(lt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return luongThangList;
    }
    
    public List<LuongThangDTO> getLuongThangByID(String maNv) {
        List<LuongThangDTO> luongThangList = new ArrayList<>();
        try {
            ResultSet rs = my.executeQuery("SELECT * FROM luongthang WHERE MaNv='" + maNv + "'");

            while (rs.next()) {
                LuongThangDTO lt = new LuongThangDTO();
                lt.setMaNv(rs.getString("MaNv"));
                lt.setTongLuong(rs.getBigDecimal("tongluong"));
                lt.setChucVu(rs.getString("chucVu"));
                lt.setDatetime(rs.getDate("datetime"));
                
                luongThangList.add(lt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return luongThangList;
    }
    
    public List<Integer> getThangLamViecTrongNam(String maNv, int year) {
        List<Integer> months = new ArrayList<>();
        try {
            String qry = "SELECT DISTINCT EXTRACT(MONTH FROM datetime) AS Month FROM chamcongngay WHERE MaNv = '" + maNv + "' AND EXTRACT(YEAR FROM datetime) = " + year + " ORDER BY Month";
            ResultSet rs = my.executeQuery(qry);
            while (rs.next()) {
                months.add(rs.getInt("Month"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return months;
    }
    
    public List<Integer> tongLuongTrongThang(int year){
        List<Integer> monthlyTotals = new ArrayList<>();

        try{
            String qry = "SELECT COALESCE(SUM(tongluong), 0) AS total " +
                "FROM (SELECT 1 AS month_number UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 " +
                "UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL " +
                "SELECT 9 UNION ALL SELECT 10 UNION ALL SELECT 11 UNION ALL SELECT 12) AS months " +
                "LEFT JOIN luongthang ON EXTRACT(MONTH FROM datetime) = month_number " +
                "AND EXTRACT(YEAR FROM datetime) = " + year + " " +
                "GROUP BY month_number " +
                "ORDER BY month_number";
            
            ResultSet rs = my.executeQuery(qry);
            while (rs.next()) {
                int total = rs.getInt("total");
                monthlyTotals.add(total);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return monthlyTotals;
    }
    
    public ResultSet soSanhLuongNam() {
        try {
            String qry = "SELECT YEAR(datetime) AS Year, SUM(tongluong) AS TotalSalary FROM luongthang GROUP BY YEAR(datetime)";
            ResultSet rs = my.executeQuery(qry);
            return rs;
        } catch (Exception e) {
            System.out.println("NhanVienDAO: soSanhLuongNam " + e.getMessage());
            return null;
        }
    }
    public String getMaNVByUsername(String maNV) {
        String maNV1 = "";
        try {
            String qry = "SELECT maNV FROM nhanvien WHERE maNV = '" + maNV1 + "'";
            ResultSet rs = my.executeQuery(qry);
            if (rs.next()) {
                maNV1 = rs.getString("maNV");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                my.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        return maNV1;
    }

    
}
