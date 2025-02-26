
package DTO;

public class SanPhamDTO {
    private String maSP, maNSX, maLoai, tenSP;
    private int soLuong;
    private double donGia;
    private boolean trangThai;

    public SanPhamDTO() {}

    public SanPhamDTO(String maSP, String maNSX, String maLoai, String tenSP, double donGia, int soLuong, boolean trangThai) {
        this.maSP = maSP;
        this.maNSX = maNSX;
        this.maLoai = maLoai;
        this.tenSP = tenSP;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.trangThai = trangThai;
    }
    
     public boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    
    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getMaNSX() {
        return maNSX;
    }

    public void setMaNSX(String maNSX) {
        this.maNSX = maNSX;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

}
