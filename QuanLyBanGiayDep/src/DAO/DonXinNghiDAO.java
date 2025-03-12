package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import DTO.DonXinNghiDTO;
import untils.MyDataAccess;

public class DonXinNghiDAO {
    // Khởi tạo kết nối tới database theo cấu hình tương tự như trong NhanVienDAO
    MyDataAccess my = new MyDataAccess("localhost","root","","qlst");
    
    public DonXinNghiDAO() {}

    // Đọc tất cả các đơn xin nghỉ
    public ArrayList<DonXinNghiDTO> docDonXinNghi() throws Exception {
        ArrayList<DonXinNghiDTO> list = new ArrayList<>();
        try {
            String qry = "SELECT * FROM donxinnghi";
            ResultSet rs = my.executeQuery(qry);
            while (rs.next()) {
                DonXinNghiDTO don = new DonXinNghiDTO();
                don.setMaDon(rs.getString("maDon"));
                don.setMaNV(rs.getString("maNV"));
                don.setLyDo(rs.getString("lyDo"));
                don.setNgayNghi(rs.getString("ngayNghi"));
                don.setNgayNopDon(rs.getString("ngayNopDon"));
                don.setNgayDuyet(rs.getString("ngayDuyet"));
                // Giả sử trường 'trangThai' được lưu dưới dạng chuỗi khớp với tên enum
                String statusStr = rs.getString("trangThai");
                don.setTrangThai(DonXinNghiDTO.Status.valueOf(statusStr));
                list.add(don);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi đọc Database");
        } finally {
            my.close();
        }
        return list;
    }

    // Lấy đơn xin nghỉ theo mã đơn
    public DonXinNghiDTO getDonXinNghiById(String maDon) throws Exception {
        DonXinNghiDTO don = null;
        try {
            String qry = "SELECT * FROM donxinnghi WHERE maDon = '" + maDon + "'";
            ResultSet rs = my.executeQuery(qry);
            if (rs.next()) {
                don = new DonXinNghiDTO();
                don.setMaDon(rs.getString("maDon"));
                don.setMaNV(rs.getString("maNV"));
                don.setLyDo(rs.getString("lyDo"));
                don.setNgayNghi(rs.getString("ngayNghi"));
                don.setNgayNopDon(rs.getString("ngayNopDon"));
                don.setNgayDuyet(rs.getString("ngayDuyet"));
                String statusStr = rs.getString("trangThai");
                don.setTrangThai(DonXinNghiDTO.Status.valueOf(statusStr));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi đọc Database");
        } finally {
            my.close();
        }
        return don;
    }

    // Thêm đơn xin nghỉ mới
    public int themDonXinNghi(DonXinNghiDTO don) {
        int res = 0;
        try {
            // Tự động tăng mã đơn nếu chưa có
            if (don.getMaDon() == null || don.getMaDon().trim().isEmpty()) {
                String qryMax = "SELECT MAX(maDon) as maxID FROM donxinnghi";
                ResultSet rs = my.executeQuery(qryMax);
                String newMaDon = "DXN001";
                if (rs.next()) {
                    String maxID = rs.getString("maxID");
                    if (maxID != null) {
                        // Giả sử mã đơn có định dạng "DXN" + số (ví dụ: DXN001)
                        int num = Integer.parseInt(maxID.substring(3));
                        num++;
                        newMaDon = "DXN" + String.format("%03d", num);
                    }
                }
                don.setMaDon(newMaDon);
            }
            
            // Tự động lấy mã nhân viên hiện tại nếu chưa có
            if (don.getMaNV() == null || don.getMaNV().trim().isEmpty()) {
                don.setMaNV(GUI.Login.maNV);
            }

            
            String qry = "INSERT INTO donxinnghi(maDon, maNV, lyDo, ngayNghi, ngayNopDon, ngayDuyet, trangThai) VALUES (";
            qry += "'" + don.getMaDon() + "',";
            qry += "'" + don.getMaNV() + "',";
            qry += "'" + don.getLyDo() + "',";
            qry += "'" + don.getNgayNghi() + "',";
            qry += "'" + don.getNgayNopDon() + "',";
            if(don.getNgayDuyet() == null || don.getNgayDuyet().trim().isEmpty()){
                qry += "NULL,";
            } else {
                qry += "'" + don.getNgayDuyet() + "',";
            }
            qry += "'" + don.getTrangThai().toString() + "')";

            
            
            res = my.executeUpdate(qry);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi thêm đơn xin nghỉ");
        } finally {
            try {
                my.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        return res;
    }


    // Sửa thông tin đơn xin nghỉ (có thể dùng cho cả việc cập nhật trạng thái)
    public int suaDonXinNghi(DonXinNghiDTO don) {
        int res = 0;
        try {
            String qry = "UPDATE donxinnghi SET ";
            qry += "maNV = '" + don.getMaNV() + "', ";
            qry += "lyDo = '" + don.getLyDo() + "', ";
            qry += "ngayNghi = '" + don.getNgayNghi() + "', ";
            qry += "ngayNopDon = '" + don.getNgayNopDon() + "', ";
            qry += "ngayDuyet = '" + don.getNgayDuyet() + "', ";
            qry += "trangThai = '" + don.getTrangThai().toString() + "' ";
            qry += "WHERE maDon = '" + don.getMaDon() + "'";
            res = my.executeUpdate(qry);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi sửa đơn xin nghỉ");
        } finally {
            try {
                my.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }

        return res;
    }

    // Xóa đơn xin nghỉ theo mã đơn
    public int xoaDonXinNghi(String maDon) {
        int res = 0;
        try {
            String qry = "DELETE FROM donxinnghi WHERE maDon = '" + maDon + "'";
            res = my.executeUpdate(qry);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi xóa đơn xin nghỉ");
        } finally {
            try {
                my.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }

        return res;
    }
    
    // Cập nhật đơn xin nghỉ sang trạng thái 'DaDuyet' (duyệt)
    public int duyetDonXinNghi(String maDon, String ngayDuyet) {
        int res = 0;
        try {
            String qry = "UPDATE donxinnghi SET ngayDuyet = '" + ngayDuyet + "', trangThai = '" + DonXinNghiDTO.Status.DaDuyet + "' WHERE maDon = '" + maDon + "'";
            res = my.executeUpdate(qry);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi duyệt đơn xin nghỉ");
        } finally {
            try {
                my.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }

        return res;
    }
    
    // Cập nhật đơn xin nghỉ sang trạng thái 'TuChoi' (từ chối)
    public int tuChoiDonXinNghi(String maDon, String ngayDuyet) {
        int res = 0;
        try {
            String qry = "UPDATE donxinnghi SET ngayDuyet = '" + ngayDuyet + "', trangThai = '" + DonXinNghiDTO.Status.TuChoi + "' WHERE maDon = '" + maDon + "'";
            res = my.executeUpdate(qry);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi từ chối đơn xin nghỉ");
        } finally {
            try {
                my.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }

        return res;
    }
    
    public ArrayList<String> getApprovedLeaveDates(String maNV) {
        ArrayList<String> list = new ArrayList<>();
        try {
            String qry = "SELECT ngayNghi FROM donxinnghi WHERE maNV = '" + maNV + "' AND trangThai = 'DaDuyet'";
            ResultSet rs = my.executeQuery(qry);
            while (rs.next()) {
                String ngayNghi = rs.getString("ngayNghi");
                list.add(ngayNghi);
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
        return list;
    }

}
