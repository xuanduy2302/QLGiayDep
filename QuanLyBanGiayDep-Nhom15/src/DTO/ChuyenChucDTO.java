/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author MyPC
 */
public class ChuyenChucDTO {
    private String ngayChuyenChuc;
    private String chucvu;
    private String heSoLuong;
    
    public ChuyenChucDTO(String ngayChuyenChuc, String chucvu, String heSoLuong) {
        this.ngayChuyenChuc = ngayChuyenChuc;
        this.chucvu = chucvu;
        this.heSoLuong = heSoLuong;
    }

    public String getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(String heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public String getNgayChuyenChuc() {
        return ngayChuyenChuc;
    }

    public void setNgayChuyenChuc(String ngayChuyenChuc) {
        this.ngayChuyenChuc = ngayChuyenChuc;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }
    
}
