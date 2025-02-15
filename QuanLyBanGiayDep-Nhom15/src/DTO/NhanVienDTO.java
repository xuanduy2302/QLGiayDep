
package DTO;

public class NhanVienDTO {
    private String maNV, hoNV, tenNV, diaChiNV, chucVuNV;
    public boolean trangThai;
    
    public NhanVienDTO() {}
    
    public NhanVienDTO(String maNV, String hoNV, String tenNV, String ngaySinhNV, String diaChiNV, String chucVuNV,boolean trangThai) {
        this.maNV = maNV;
        this.hoNV = hoNV;
        this.tenNV = tenNV;
        this.diaChiNV = diaChiNV;
        this.chucVuNV = chucVuNV;
        this.trangThai = trangThai;
    }
    
    public boolean getTrangThai() {
        return trangThai;
    }
    
    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoNV() {
        return hoNV;
    }

    public void setHoNV(String hoNV) {
        this.hoNV = hoNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getDiaChiNV() {
        return diaChiNV;
    }

    public void setDiaChiNV(String diaChiNV) {
        this.diaChiNV = diaChiNV;
    }

    public String getChucVuNV() {
        return chucVuNV;
    }

    public void setChucVuNV(String chucVuNV) {
        this.chucVuNV = chucVuNV;
    }
    
}

