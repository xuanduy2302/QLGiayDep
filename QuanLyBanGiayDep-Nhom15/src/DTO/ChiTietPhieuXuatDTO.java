
package DTO;

public class ChiTietPhieuXuatDTO {
    private String maPX, maSP;
    private double donGia, thanhTien;
    private int soLuong;
     public ChiTietPhieuXuatDTO(){}

    public ChiTietPhieuXuatDTO(String maPX, String maSP, double donGia, double thanhTien, int soLuong) {
        this.maPX = maPX;
        this.maSP = maSP;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
        this.soLuong = soLuong;
    }

    public String getMaPX() {
        return maPX;
    }

    public void setMaPX(String maPX) {
        this.maPX = maPX;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }


    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

}
