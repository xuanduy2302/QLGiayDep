
package untils;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import GUI.Danhmuc;
import GUI.PanelLoaiSanPham;
import GUI.PanelNhaCungCap;
import GUI.PanelNhaSanXuat;
import GUI.PanelNhanVienAdmin;
import GUI.PanelQLNhanVien;
import GUI.PanelQLPhieuNhap;
import GUI.PanelQLPhieuXuat;
import GUI.PanelSanPham;
import GUI.PanelTaiKhoanCaNhan;
import GUI.PanelThongKeLuong;
import GUI.PanelThongKeSanPham;
import GUI.PanelThongKeSanPhamDaXuat;
//import GUI.PanelThongKe;
import GUI.PanelTrangChu;

public class CatchEvent {
    private final JPanel pnRoot;
    private ArrayList<Danhmuc> menu = null;

    public CatchEvent(JPanel pnRoot) {
        this.pnRoot = pnRoot;
    }

    public void setMenu(ArrayList<Danhmuc> menu) {
        this.menu = menu;
        for (Danhmuc danhmuc : menu) {
             danhmuc.getPnName().addMouseListener(new Events(danhmuc.getKindOfScreen(), danhmuc.getPnName(), danhmuc.getLbName()));
        }
    }
    class Events implements MouseListener {

        private JPanel pnNode;
        private String kind;
        private JPanel pnName;
        private JLabel lbName;

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                case "trangchu":
                    pnNode = new PanelTrangChu();
                    break;                
                case "book":
                    pnNode = new PanelSanPham();
                    break;
                case "employees":
                    pnNode = new PanelQLNhanVien();
                    break;               
                case "qlphieunhap":
                    pnNode = new PanelQLPhieuNhap();
                    break;
                case "bill":
                    pnNode = new PanelQLPhieuXuat();
                    break; 
                case "nsx":
                    pnNode = new PanelNhaSanXuat();
                    break;    
                case "ncc":
                    pnNode = new PanelNhaCungCap();
                    break;
                case "loaisanpham":
                    pnNode = new PanelLoaiSanPham();
                    break;
                case "nhanvien_all":
                    pnNode = new PanelNhanVienAdmin();
                    break;
                case "taikhoancanhan":
                    pnNode = new PanelTaiKhoanCaNhan();
                    break;
                case "thongkeluong":
                    pnNode = new PanelThongKeLuong();
                    break;
                case "thongkesanpham":
                    pnNode = new PanelThongKeSanPham();
                    break;
                case "thongkesanphamdaxuat":
                    pnNode = new PanelThongKeSanPhamDaXuat();
                    break;
                default:
                    break;
        }
            pnRoot.removeAll();
            pnRoot.setLayout(new BorderLayout());
            pnRoot.add(pnNode);
            pnRoot.validate();
            pnRoot.repaint();
            setBackgroudSeclect(kind);            
        }

        public Events(String kind, JPanel pnName, JLabel lbName) {
            this.kind = kind;
            this.pnName = pnName;
            this.lbName = lbName;
        }    

        @Override
        public void mousePressed(MouseEvent e) {
            pnName.setBackground(new Color(44,62,80));            
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
    
        }

        @Override
        public void mouseExited(MouseEvent e) {
        
        }
    }
    private void setBackgroudSeclect(String select){
       for(Danhmuc danhmuc : menu) {
           if(!danhmuc.getKindOfScreen().equalsIgnoreCase(select)) {
               danhmuc.getPnName().setBackground(new Color(1,50,67));
               danhmuc.getLbName().setBackground(new Color(1,50,67));
           } else {
               danhmuc.getLbName().setBackground(new Color(148,124,176));
               danhmuc.getPnName().setBackground(new Color(148,124,176));
           }
       }
    }
}
