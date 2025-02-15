/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author MyPC
 */
public class LuongThangDTO {

    private String MaNv;
    private BigDecimal tongluong;
    private String chucVu;
    private Date datetime;

    public LuongThangDTO() {}
       
    public LuongThangDTO(String MaNv, BigDecimal tongluong, String chucVu, Date datetime) {
        this.MaNv = MaNv;
        this.tongluong = tongluong;
        this.chucVu = chucVu;
        this.datetime = datetime;
    }

    // Getters
    public String getMaNv() {
        return MaNv;
    }

    public BigDecimal getTongLuong() {
        return tongluong;
    }

    public String getChucVu() {
        return chucVu;
    }

    public Date getDatetime() {
        return datetime;
    }

    // Setters
    public void setMaNv(String MaNv) {
        this.MaNv = MaNv;
    }

    public void setTongLuong(BigDecimal tongluong) {
        this.tongluong = tongluong;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
}

