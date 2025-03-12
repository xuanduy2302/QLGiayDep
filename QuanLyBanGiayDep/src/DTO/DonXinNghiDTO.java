package DTO;


public class DonXinNghiDTO {
    private String maDon;
    private String maNV;
    private String lyDo;
    private String ngayNghi;
    private String ngayNopDon;
    private String ngayDuyet;
    private Status trangThai;
    
    public enum Status{
    	ChuaXuLy, DaDuyet, TuChoi
    }
    
    public DonXinNghiDTO() {}
    
    public DonXinNghiDTO(String maDon, String maNV, String lyDo, String ngayNghi, String ngayNopDon, String ngayDuyet,Status trangThai) {
        this.maDon = maDon;
        this.maNV = maNV;
        this.lyDo = lyDo;
        this.ngayNghi = ngayNghi;
        this.ngayNopDon = ngayNopDon;
        this.ngayDuyet = ngayDuyet;
        this.trangThai = trangThai;
    }
    
    public String getMaDon() {
    	return maDon;
    }
    
    public void setMaDon(String maDon) {
    	this.maDon= maDon;
    }
    
    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

  
    public String getNgayNopDon() {
        return ngayNopDon;
    }

    public void setNgayNopDon(String ngayNopDon) {
        this.ngayNopDon = ngayNopDon;
    }
    
    public String getNgayNghi() {
        return ngayNghi;
    }

    public void setNgayNghi(String ngayNghi) {
        this.ngayNghi = ngayNghi;
    }
    
    public String getNgayDuyet() {
        return ngayDuyet;
    }

    public void setNgayDuyet(String ngayDuyet) {
        this.ngayDuyet = ngayDuyet;
    }
    
    public Status getTrangThai() {
        return trangThai;
    }
    
    public void setTrangThai(Status trangThai) {
        this.trangThai = trangThai;
    }

}
