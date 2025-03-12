package BUS;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import DAO.DonXinNghiDAO;
import DTO.DonXinNghiDTO;

public class DonXinNghiBUS {
    public static ArrayList<DonXinNghiDTO> list;

    public DonXinNghiBUS() {
        list = new ArrayList<>();
    }

    // Đọc danh sách tất cả các đơn xin nghỉ từ database
    public ArrayList<DonXinNghiDTO> docDonXinNghi() {
        DonXinNghiDAO data = new DonXinNghiDAO();
        try {
            list = data.docDonXinNghi();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // Lấy thông tin đơn xin nghỉ theo mã đơn
    public DonXinNghiDTO getDonXinNghiById(String maDon) {
        DonXinNghiDAO data = new DonXinNghiDAO();
        DonXinNghiDTO don = null;
        try {
            don = data.getDonXinNghiById(maDon);
        } catch (Exception ex) {
            Logger.getLogger(DonXinNghiBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return don;
    }

    // Thêm mới một đơn xin nghỉ
    public int themDonXinNghi(DonXinNghiDTO don) {
        DonXinNghiDAO data = new DonXinNghiDAO();
        int check = data.themDonXinNghi(don);
        if (check == 1) {
            list.add(don);
        }
        return check;
    }

    // Sửa thông tin đơn xin nghỉ (có thể cập nhật toàn bộ đơn)
    public int suaDonXinNghi(DonXinNghiDTO don, int index) {
        DonXinNghiDAO data = new DonXinNghiDAO();
        int check = data.suaDonXinNghi(don);
        if (check == 1 && index >= 0 && index < list.size()) {
            list.set(index, don);
        }
        return check;
    }
    
    // Phiên bản sửa không cần biết index trong danh sách
    public int suaDonXinNghi(DonXinNghiDTO don) {
        DonXinNghiDAO data = new DonXinNghiDAO();
        return data.suaDonXinNghi(don);
    }

    // Xóa đơn xin nghỉ theo mã đơn
    public int xoaDonXinNghi(String maDon) {
        DonXinNghiDAO data = new DonXinNghiDAO();
        int check = data.xoaDonXinNghi(maDon);
        if (check == 1) {
            // Xóa khỏi danh sách nếu tồn tại
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getMaDon().equals(maDon)) {
                    list.remove(i);
                    break;
                }
            }
        }
        return check;
    }
    
    // Duyệt đơn xin nghỉ: cập nhật trạng thái thành DaDuyet và lưu ngày duyệt
    public int duyetDonXinNghi(String maDon, String ngayDuyet) {
        DonXinNghiDAO data = new DonXinNghiDAO();
        int check = data.duyetDonXinNghi(maDon, ngayDuyet);
        if (check == 1) {
            for (DonXinNghiDTO don : list) {
                if (don.getMaDon().equals(maDon)) {
                    don.setNgayDuyet(ngayDuyet);
                    don.setTrangThai(DonXinNghiDTO.Status.DaDuyet);
                    break;
                }
            }
        }
        return check;
    }
    
    // Từ chối đơn xin nghỉ: cập nhật trạng thái thành TuChoi và lưu ngày duyệt
    public int tuChoiDonXinNghi(String maDon, String ngayDuyet) {
        DonXinNghiDAO data = new DonXinNghiDAO();
        int check = data.tuChoiDonXinNghi(maDon, ngayDuyet);
        if (check == 1) {
            for (DonXinNghiDTO don : list) {
                if (don.getMaDon().equals(maDon)) {
                    don.setNgayDuyet(ngayDuyet);
                    don.setTrangThai(DonXinNghiDTO.Status.TuChoi);
                    break;
                }
            }
        }
        return check;
    }
    
    public ArrayList<String> getApprovedLeaveDates(String maNV) {
        DonXinNghiDAO dao = new DonXinNghiDAO();
        return dao.getApprovedLeaveDates(maNV);
    }

}
