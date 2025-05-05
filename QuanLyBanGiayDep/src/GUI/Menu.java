
package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import untils.CatchEvent;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;

public class Menu extends javax.swing.JFrame {
    private static final int ADMIN = 4;
    private static final int QUAN_LY = 3;
    private static final int NHAN_VIEN_KHO = 2;
    private static final int NHAN_VIEN_BAN_HANG = 1;
    private static final Color COLOR_BACKGROUND = new Color(240,240,240);
    private static final Color COLOR_MENU = new Color(61, 81, 179);
    private static final Color COLOR_HEADER = Color.decode("#FFC107");
   // private static final Color COLOR_ITEM = Color.decode("#FFFFFF");

    public Menu() {
    	getContentPane().setBackground(new Color(240, 240, 240));
    	setBackground(new Color(240, 240, 240));
        initComponents();
        int check = Login.check;
        this.setLocationRelativeTo(null);
        CatchEvent catchEvent = new CatchEvent(pn_view);
        ArrayList<Danhmuc> menu = new ArrayList<Danhmuc>();
        menu = initMenu(check);
        catchEvent.setMenu(menu);
        lbl_chao.setText("Xin chào " + Login.username);
        pn_view.removeAll();
        pn_view.setLayout(new BorderLayout());
        pn_view.add(new PanelTrangChu());
        pn_view.validate();
        pn_view.repaint();
        this.setResizable(false);
        // Thiết lập màu nền chung
        pn_all.setBackground(COLOR_BACKGROUND);
        pn_view.setBackground(COLOR_BACKGROUND);

        // Panel menu bên trái
        pn_menu.setBackground(COLOR_MENU);
       // pn_inmenu.setBackground(COLOR_MENU.darker());

        // Thanh tiêu đề trên cùng
        pn_exit.setBackground(COLOR_MENU.darker());
        pn_tieude.setBackground(COLOR_HEADER);

        // Các mục trong menu (dùng cùng một màu item)
   /*    pn_trangchu.setBackground(COLOR_ITEM);
        pn_product.setBackground(COLOR_ITEM);
        pn_dxn.setBackground(COLOR_ITEM);
        pn_ddxn.setBackground(COLOR_ITEM);
        pn_pn.setBackground(COLOR_ITEM);
        pn_hd.setBackground(COLOR_ITEM);
        pn_nv.setBackground(COLOR_ITEM);
        pn_ncc.setBackground(COLOR_ITEM);
        pn_loaisanpham.setBackground(COLOR_ITEM);
        pn_nsx.setBackground(COLOR_ITEM);
        pn_qlnv_admin.setBackground(COLOR_ITEM);
        pn_tkcn.setBackground(COLOR_ITEM);
        pn_tkl.setBackground(COLOR_ITEM);
        pn_tksp.setBackground(COLOR_ITEM);
        pn_tkspx.setBackground(COLOR_ITEM); */
    }

    public ArrayList<Danhmuc> initMenu(int n) {
        ArrayList<Danhmuc> menu = new ArrayList<>();
        switch (n) {
            case QUAN_LY:
                menu.add(new Danhmuc("trangchu", pn_trangchu, lb_trangchu));
                menu.add(new Danhmuc("taikhoancanhan", pn_tkcn, lb_tkcn));
                menu.add(new Danhmuc("employees", pn_nv, lb_nv));
                menu.add(new Danhmuc("thongkeluong", pn_tkl, lb_tkl));
                menu.add(new Danhmuc("duyetdonxinnghi", pn_ddxn, lb_ddxn));
                pn_tksp.setVisible(false);
                pn_tkspx.setVisible(false);
                btn_chamCong.setVisible(false);
                btn_xemLuong.setVisible(false);
                pn_qlnv_admin.setVisible(false);
                pn_product.setVisible(false);
                pn_pn.setVisible(false);
                pn_hd.setVisible(false);
                pn_nsx.setVisible(false);
                pn_loaisanpham.setVisible(false);
                pn_ncc.setVisible(false);
                pn_dxn.setVisible(false);
                break;
            case NHAN_VIEN_BAN_HANG:
                menu.add(new Danhmuc("trangchu", pn_trangchu, lb_trangchu));
                menu.add(new Danhmuc("taikhoancanhan", pn_tkcn, lb_tkcn));
                menu.add(new Danhmuc("bill", pn_hd, lb_hd));
                menu.add(new Danhmuc("thongkesanphamdaxuat", pn_tkspx, lb_tkspx));
                menu.add(new Danhmuc("donxinnghi", pn_dxn, lb_dxn));
                pn_tkl.setVisible(false);
                pn_tksp.setVisible(false);
                pn_qlnv_admin.setVisible(false);
                pn_nv.setVisible(false);
                pn_pn.setVisible(false);
                pn_product.setVisible(false);
                pn_nsx.setVisible(false);
                pn_loaisanpham.setVisible(false);
                pn_ncc.setVisible(false);
                pn_ddxn.setVisible(false);
                break;
            case ADMIN:
                menu.add(new Danhmuc("trangchu", pn_trangchu, lb_trangchu));
                menu.add(new Danhmuc("nhanvien_all", pn_qlnv_admin, lb_qlnv_admin));
                menu.add(new Danhmuc("book", pn_product, lb_product));
                menu.add(new Danhmuc("nsx", pn_nsx, lb_nsx));
                menu.add(new Danhmuc("ncc", pn_ncc, lb_ncc));
                menu.add(new Danhmuc("loaisanpham", pn_loaisanpham, lb_loaisanpham));
                btn_xemLuong.setVisible(false);
                pn_tkspx.setVisible(false);
                pn_tkl.setVisible(false);
                pn_tkcn.setVisible(false);
                btn_chamCong.setVisible(false);
                pn_nv.setVisible(false);
                pn_pn.setVisible(false);
                pn_hd.setVisible(false);
                pn_nsx.setVisible(false);
                pn_tksp.setVisible(false);
                pn_dxn.setVisible(false);
                pn_ddxn.setVisible(false);
                break;
            case NHAN_VIEN_KHO:
                menu.add(new Danhmuc("trangchu", pn_trangchu, lb_trangchu));
                menu.add(new Danhmuc("taikhoancanhan", pn_tkcn, lb_tkcn));
                menu.add(new Danhmuc("donxinnghi", pn_dxn, lb_dxn));
                menu.add(new Danhmuc("book", pn_product, lb_product));
                menu.add(new Danhmuc("nsx", pn_nsx, lb_nsx));
                menu.add(new Danhmuc("ncc", pn_ncc, lb_ncc));
                menu.add(new Danhmuc("loaisanpham", pn_loaisanpham, lb_loaisanpham));
                menu.add(new Danhmuc("qlphieunhap", pn_pn, lb_pn));
                menu.add(new Danhmuc("thongkesanpham", pn_tksp, lb_tksp));
                pn_qlnv_admin.setVisible(false);
                pn_tkspx.setVisible(false);
                pn_tkl.setVisible(false);
                pn_nv.setVisible(false);
                pn_hd.setVisible(false);
                pn_ddxn.setVisible(false);
                break;
            default:
                break;
        }
        return menu;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_all = new javax.swing.JPanel();
        pn_menu = new javax.swing.JPanel();
        pn_inmenu = new javax.swing.JPanel();
        pn_tieude = new javax.swing.JPanel();
        lb_tieude = new javax.swing.JLabel();
        pn_product = new javax.swing.JPanel();
        lb_product = new javax.swing.JLabel();

        pn_dxn = new javax.swing.JPanel();
        lb_dxn = new javax.swing.JLabel();
        pn_ddxn = new javax.swing.JPanel();
        lb_ddxn = new javax.swing.JLabel();

        pn_nv = new javax.swing.JPanel();
        lb_nv = new javax.swing.JLabel();
        pn_pn = new javax.swing.JPanel();
        lb_pn = new javax.swing.JLabel();
        pn_hd = new javax.swing.JPanel();
        lb_hd = new javax.swing.JLabel();
        pn_trangchu = new javax.swing.JPanel();
        lb_trangchu = new javax.swing.JLabel();
        pn_ncc = new javax.swing.JPanel();
        lb_ncc = new javax.swing.JLabel();
        pn_loaisanpham = new javax.swing.JPanel();
        lb_loaisanpham = new javax.swing.JLabel();
        pn_nsx = new javax.swing.JPanel();
        lb_nsx = new javax.swing.JLabel();
        pn_qlnv_admin = new javax.swing.JPanel();
        lb_qlnv_admin = new javax.swing.JLabel();
        pn_tkcn = new javax.swing.JPanel();
        lb_tkcn = new javax.swing.JLabel();
        pn_tkl = new javax.swing.JPanel();
        lb_tkl = new javax.swing.JLabel();
        pn_tksp = new javax.swing.JPanel();
        lb_tksp = new javax.swing.JLabel();
        pn_tkspx = new javax.swing.JPanel();
        lb_tkspx = new javax.swing.JLabel();
        pn_view = new javax.swing.JPanel();
        pn_exit = new javax.swing.JPanel();
        lb_exit = new javax.swing.JLabel();
        lbl_chao = new javax.swing.JLabel();
        btn_doiMK = new javax.swing.JButton();
        btn_doiMK.setForeground(new Color(0, 0, 0));
        btn_doiMK.setBackground(new Color(240, 240, 240));
        btn_chamCong = new javax.swing.JButton();
        btn_chamCong.setForeground(new Color(0, 0, 0));
        btn_chamCong.setBackground(new Color(240, 240, 240));
        btn_xemLuong = new javax.swing.JButton();
        btn_xemLuong.setForeground(new Color(0, 0, 0));
        btn_xemLuong.setBackground(new Color(240, 240, 240));
        btn_logout = new javax.swing.JButton();
        btn_logout.setFont(new java.awt.Font("Tahoma", 1, 11)); // Chữ in đậm
        btn_logout.setText("Đăng xuất");
        btn_logout.setBackground(new java.awt.Color(255, 102, 102)); // Màu đỏ
        btn_logout.setForeground(new java.awt.Color(255, 255, 255)); // Chữ trắng
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setModalExclusionType(null);
        setUndecorated(true);

        pn_all.setBackground(new Color(240, 240, 240));

        pn_menu.setBackground(new Color(1, 50, 67));

        pn_inmenu.setBackground(new Color(1, 50, 67));

        pn_tieude.setBackground(new Color(1, 50, 67));

        lb_tieude.setBackground(new java.awt.Color(61,81,179));
        lb_tieude.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lb_tieude.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_tieude.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/house.png"))); // NOI18N
        lb_tieude.setText("Cửa hàng bán giày dép");
        lb_tieude.setHorizontalAlignment(SwingConstants.LEFT);


        javax.swing.GroupLayout pn_tieudeLayout = new javax.swing.GroupLayout(pn_tieude);
        pn_tieudeLayout.setHorizontalGroup(
        	pn_tieudeLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(pn_tieudeLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lb_tieude, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_tieudeLayout.setVerticalGroup(
        	pn_tieudeLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, pn_tieudeLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lb_tieude, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
        );
        pn_tieude.setLayout(pn_tieudeLayout);

        pn_product.setBackground(new Color(1, 50, 67));
        pn_product.setPreferredSize(new java.awt.Dimension(246, 60));

        lb_product.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        lb_product.setForeground(new java.awt.Color(255, 255, 255));
        lb_product.setText("Quản lý sản phẩm");
        lb_product.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_productMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pn_productLayout = new javax.swing.GroupLayout(pn_product);
        pn_product.setLayout(pn_productLayout);
        pn_productLayout.setHorizontalGroup(
                pn_productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pn_productLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lb_product)
                                .addContainerGap(199, Short.MAX_VALUE)));
        pn_productLayout.setVerticalGroup(
                pn_productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lb_product, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE));

        // Don Xin nghi
        pn_dxn.setBackground(new Color(1, 50, 67));
        pn_dxn.setPreferredSize(new java.awt.Dimension(246, 60));

        lb_dxn.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        lb_dxn.setForeground(new java.awt.Color(255, 255, 255));
        lb_dxn.setText("Đơn xin nghỉ");
       /* lb_dxn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                // Sự kiện khi nhấn vào label, bạn có thể để xử lý tại đây hoặc để CatchEvent xử
                // lý
                pn_view.removeAll();
                pn_view.setLayout(new java.awt.BorderLayout());
                // Giả sử Login.maNV chứa mã nhân viên hiện hành
                pn_view.add(new PanelDonXinNghi(Login.maNV));
                pn_view.validate();
                pn_view.repaint();
            }
        });*/

        javax.swing.GroupLayout pn_dxnLayout = new javax.swing.GroupLayout(pn_dxn);
        pn_dxn.setLayout(pn_dxnLayout);
        pn_dxnLayout.setHorizontalGroup(
                pn_dxnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pn_dxnLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lb_dxn, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                                .addGap(83, 83, 83)));
        pn_dxnLayout.setVerticalGroup(
                pn_dxnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lb_dxn, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE));

        // Duyệt Đơn Xin Nghỉ
        pn_ddxn.setBackground(new Color(1, 50, 67));
        pn_ddxn.setPreferredSize(new java.awt.Dimension(246, 60));

        lb_ddxn.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        lb_ddxn.setForeground(new java.awt.Color(255, 255, 255));
        lb_ddxn.setText("Duyệt Đơn Xin Nghỉ");
      /*  lb_ddxn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                // Khi nhấn, load PanelDuyetDonXinNghi (giống phần DonXinNghi)
                pn_view.removeAll();
                pn_view.setLayout(new BorderLayout());
                pn_view.add(new PanelDuyetDonXinNghi(), BorderLayout.CENTER);
                pn_view.validate();
                pn_view.repaint();
            }
        });*/

        javax.swing.GroupLayout pn_ddxnLayout = new javax.swing.GroupLayout(pn_ddxn);
        pn_ddxn.setLayout(pn_ddxnLayout);
        pn_ddxnLayout.setHorizontalGroup(
                pn_ddxnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pn_ddxnLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lb_ddxn, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                                .addGap(83, 83, 83)));
        pn_ddxnLayout.setVerticalGroup(
                pn_ddxnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lb_ddxn, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE));

        pn_nv.setBackground(new Color(1, 50, 67));
        pn_nv.setPreferredSize(new java.awt.Dimension(246, 60));

        lb_nv.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        lb_nv.setForeground(new java.awt.Color(255, 255, 255));
        lb_nv.setText("Quản lý nhân viên");

        javax.swing.GroupLayout pn_nvLayout = new javax.swing.GroupLayout(pn_nv);
        pn_nv.setLayout(pn_nvLayout);
        pn_nvLayout.setHorizontalGroup(
                pn_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pn_nvLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lb_nv, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                                .addGap(83, 83, 83)));
        pn_nvLayout.setVerticalGroup(
                pn_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lb_nv, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE));

        pn_pn.setBackground(new Color(1, 50, 67));
        pn_pn.setPreferredSize(new java.awt.Dimension(246, 60));

        lb_pn.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        lb_pn.setForeground(new java.awt.Color(255, 255, 255));
        lb_pn.setText("Quản lý phiếu nhập");

        javax.swing.GroupLayout pn_pnLayout = new javax.swing.GroupLayout(pn_pn);
        pn_pn.setLayout(pn_pnLayout);
        pn_pnLayout.setHorizontalGroup(
                pn_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pn_pnLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lb_pn, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                                .addGap(83, 83, 83)));
        pn_pnLayout.setVerticalGroup(
                pn_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lb_pn, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE));

        pn_hd.setBackground(new Color(1, 50, 67));
        pn_hd.setPreferredSize(new java.awt.Dimension(246, 60));

        lb_hd.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        lb_hd.setForeground(new java.awt.Color(255, 255, 255));
        lb_hd.setText("Quản lý phiếu xuất");

        javax.swing.GroupLayout pn_hdLayout = new javax.swing.GroupLayout(pn_hd);
        pn_hd.setLayout(pn_hdLayout);
        pn_hdLayout.setHorizontalGroup(
                pn_hdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pn_hdLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lb_hd, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        pn_hdLayout.setVerticalGroup(
                pn_hdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lb_hd, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE));

        pn_trangchu.setBackground(new Color(1, 50, 67));
        pn_trangchu.setPreferredSize(new java.awt.Dimension(246, 60));

        lb_trangchu.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        lb_trangchu.setForeground(new java.awt.Color(255, 255, 255));
        lb_trangchu.setText("Trang chủ");

        javax.swing.GroupLayout pn_trangchuLayout = new javax.swing.GroupLayout(pn_trangchu);
        pn_trangchu.setLayout(pn_trangchuLayout);
        pn_trangchuLayout.setHorizontalGroup(
                pn_trangchuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pn_trangchuLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lb_trangchu)
                                .addContainerGap(260, Short.MAX_VALUE)));
        pn_trangchuLayout.setVerticalGroup(
                pn_trangchuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lb_trangchu, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE));

        pn_ncc.setBackground(new Color(1, 50, 67));
        pn_ncc.setPreferredSize(new java.awt.Dimension(246, 60));

        lb_ncc.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        lb_ncc.setForeground(new java.awt.Color(255, 255, 255));
        lb_ncc.setText("Nhà cung cấp");

        javax.swing.GroupLayout pn_nccLayout = new javax.swing.GroupLayout(pn_ncc);
        pn_ncc.setLayout(pn_nccLayout);
        pn_nccLayout.setHorizontalGroup(
                pn_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pn_nccLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lb_ncc)
                                .addContainerGap(232, Short.MAX_VALUE)));
        pn_nccLayout.setVerticalGroup(
                pn_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lb_ncc, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE));

        pn_loaisanpham.setBackground(new Color(1, 50, 67));
        pn_loaisanpham.setPreferredSize(new java.awt.Dimension(246, 60));

        lb_loaisanpham.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        lb_loaisanpham.setForeground(new java.awt.Color(255, 255, 255));
        lb_loaisanpham.setText("Loại sản phẩm");

        javax.swing.GroupLayout pn_loaisanphamLayout = new javax.swing.GroupLayout(pn_loaisanpham);
        pn_loaisanpham.setLayout(pn_loaisanphamLayout);
        pn_loaisanphamLayout.setHorizontalGroup(
                pn_loaisanphamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pn_loaisanphamLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lb_loaisanpham)
                                .addContainerGap(226, Short.MAX_VALUE)));
        pn_loaisanphamLayout.setVerticalGroup(
                pn_loaisanphamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lb_loaisanpham, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE));

        pn_nsx.setBackground(new Color(1, 50, 67));
        pn_nsx.setPreferredSize(new java.awt.Dimension(246, 60));

        lb_nsx.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        lb_nsx.setForeground(new java.awt.Color(255, 255, 255));
        lb_nsx.setText("Nhà sản xuất");

        javax.swing.GroupLayout pn_nsxLayout = new javax.swing.GroupLayout(pn_nsx);
        pn_nsx.setLayout(pn_nsxLayout);
        pn_nsxLayout.setHorizontalGroup(
                pn_nsxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pn_nsxLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lb_nsx)
                                .addContainerGap(237, Short.MAX_VALUE)));
        pn_nsxLayout.setVerticalGroup(
                pn_nsxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lb_nsx, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE));

        pn_qlnv_admin.setBackground(new Color(1, 50, 67));
        pn_qlnv_admin.setPreferredSize(new java.awt.Dimension(246, 60));

        lb_qlnv_admin.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        lb_qlnv_admin.setForeground(new java.awt.Color(255, 255, 255));
        lb_qlnv_admin.setText("Quản lý nhân viên - Admin");

        javax.swing.GroupLayout pn_qlnv_adminLayout = new javax.swing.GroupLayout(pn_qlnv_admin);
        pn_qlnv_admin.setLayout(pn_qlnv_adminLayout);
        pn_qlnv_adminLayout.setHorizontalGroup(
                pn_qlnv_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pn_qlnv_adminLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lb_qlnv_admin)
                                .addContainerGap(134, Short.MAX_VALUE)));
        pn_qlnv_adminLayout.setVerticalGroup(
                pn_qlnv_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lb_qlnv_admin, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE));

        pn_tkcn.setBackground(new Color(1, 50, 67));
        pn_tkcn.setPreferredSize(new java.awt.Dimension(246, 60));

        lb_tkcn.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        lb_tkcn.setForeground(new java.awt.Color(255, 255, 255));
        lb_tkcn.setText("Tài Khoản Cá Nhân");

        javax.swing.GroupLayout pn_tkcnLayout = new javax.swing.GroupLayout(pn_tkcn);
        pn_tkcn.setLayout(pn_tkcnLayout);
        pn_tkcnLayout.setHorizontalGroup(
                pn_tkcnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pn_tkcnLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lb_tkcn)
                                .addContainerGap(189, Short.MAX_VALUE)));
        pn_tkcnLayout.setVerticalGroup(
                pn_tkcnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lb_tkcn, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE));

        pn_tkl.setBackground(new Color(1, 50, 67));
        pn_tkl.setPreferredSize(new java.awt.Dimension(246, 60));

        lb_tkl.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        lb_tkl.setForeground(new java.awt.Color(255, 255, 255));
        lb_tkl.setText("Thống kê lương nhân sự");

        javax.swing.GroupLayout pn_tklLayout = new javax.swing.GroupLayout(pn_tkl);
        pn_tkl.setLayout(pn_tklLayout);
        pn_tklLayout.setHorizontalGroup(
                pn_tklLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pn_tklLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lb_tkl)
                                .addContainerGap(144, Short.MAX_VALUE)));
        pn_tklLayout.setVerticalGroup(
                pn_tklLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lb_tkl, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE));

        pn_tksp.setBackground(new Color(1, 50, 67));
        pn_tksp.setPreferredSize(new java.awt.Dimension(246, 60));

        lb_tksp.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        lb_tksp.setForeground(new java.awt.Color(255, 255, 255));
        lb_tksp.setText("Thống kê sản phẩm nhập");

        javax.swing.GroupLayout pn_tkspLayout = new javax.swing.GroupLayout(pn_tksp);
        pn_tksp.setLayout(pn_tkspLayout);
        pn_tkspLayout.setHorizontalGroup(
                pn_tkspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pn_tkspLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lb_tksp)
                                .addContainerGap(142, Short.MAX_VALUE)));
        pn_tkspLayout.setVerticalGroup(
                pn_tkspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lb_tksp, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE));

        pn_tkspx.setBackground(new Color(1, 50, 67));
        pn_tkspx.setPreferredSize(new java.awt.Dimension(246, 60));

        lb_tkspx.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        lb_tkspx.setForeground(new java.awt.Color(255, 255, 255));
        lb_tkspx.setText("Thống kê sản phẩm xuất");

        javax.swing.GroupLayout pn_tkspxLayout = new javax.swing.GroupLayout(pn_tkspx);
        pn_tkspx.setLayout(pn_tkspxLayout);
        pn_tkspxLayout.setHorizontalGroup(
                pn_tkspxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pn_tkspxLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lb_tkspx)
                                .addContainerGap(147, Short.MAX_VALUE)));
        pn_tkspxLayout.setVerticalGroup(
                pn_tkspxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lb_tkspx, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE));

        javax.swing.GroupLayout pn_inmenuLayout = new javax.swing.GroupLayout(pn_inmenu);
        pn_inmenu.setLayout(pn_inmenuLayout);
        pn_inmenuLayout.setHorizontalGroup(
                pn_inmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pn_tieude, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pn_trangchu, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                        .addComponent(pn_pn, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                        .addComponent(pn_hd, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                        .addComponent(pn_nv, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                        .addComponent(pn_product, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                        .addComponent(pn_dxn, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)          
                        .addComponent(pn_ddxn, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)   
                        .addComponent(pn_ncc, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                        .addComponent(pn_loaisanpham, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                        .addComponent(pn_nsx, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                        .addComponent(pn_qlnv_admin, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                        .addComponent(pn_tkcn, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                        .addComponent(pn_tkl, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                        .addComponent(pn_tksp, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                        .addComponent(pn_tkspx, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE));
        pn_inmenuLayout.setVerticalGroup(
                pn_inmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pn_inmenuLayout.createSequentialGroup()
                                .addComponent(pn_tieude, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(pn_trangchu, javax.swing.GroupLayout.PREFERRED_SIZE, 48,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pn_product, javax.swing.GroupLayout.PREFERRED_SIZE, 48,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pn_dxn, javax.swing.GroupLayout.PREFERRED_SIZE, 48,
                                        javax.swing.GroupLayout.PREFERRED_SIZE) // Thêm vào đây
                                .addGap(18, 18, 18)
                                .addComponent(pn_ddxn, javax.swing.GroupLayout.PREFERRED_SIZE, 48,
                                        javax.swing.GroupLayout.PREFERRED_SIZE) // Thêm vào đây
                                .addGap(18, 18, 18)
                                .addComponent(pn_pn, javax.swing.GroupLayout.PREFERRED_SIZE, 48,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pn_hd, javax.swing.GroupLayout.PREFERRED_SIZE, 48,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pn_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 48,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pn_tkcn, javax.swing.GroupLayout.PREFERRED_SIZE, 48,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pn_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 48,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pn_loaisanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 48,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pn_nsx, javax.swing.GroupLayout.PREFERRED_SIZE, 48,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pn_qlnv_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 48,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pn_tkl, javax.swing.GroupLayout.PREFERRED_SIZE, 48,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pn_tksp, javax.swing.GroupLayout.PREFERRED_SIZE, 48,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pn_tkspx, javax.swing.GroupLayout.PREFERRED_SIZE, 48,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 190, Short.MAX_VALUE)));
        
        
        pn_inmenu.setLayout(new BoxLayout(pn_inmenu, BoxLayout.Y_AXIS));

        javax.swing.GroupLayout pn_menuLayout = new javax.swing.GroupLayout(pn_menu);
        pn_menu.setLayout(pn_menuLayout);
        pn_menuLayout.setHorizontalGroup(
                pn_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pn_inmenu, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        pn_menuLayout.setVerticalGroup(
                pn_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pn_inmenu, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE));

        pn_view.setBackground(new Color(240, 240, 240));

        javax.swing.GroupLayout pn_viewLayout = new javax.swing.GroupLayout(pn_view);
        pn_view.setLayout(pn_viewLayout);
        pn_viewLayout.setHorizontalGroup(
                pn_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE));
        pn_viewLayout.setVerticalGroup(
                pn_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE));

        pn_exit.setBackground(new Color(0, 0, 0));

        lb_exit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/exit1.png"))); // NOI18N
        lb_exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_exitMouseClicked(evt);
            }
        });

        lbl_chao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_chao.setForeground(new java.awt.Color(255, 255, 255));
        lbl_chao.setText("Xin chào");

        btn_doiMK.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_doiMK.setText("Đổi mật khẩu");
        btn_doiMK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_doiMKMouseClicked(evt);
            }
        });
        btn_doiMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_doiMKActionPerformed(evt);
            }
        });

        btn_chamCong.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_chamCong.setText("Chấm công");
        btn_chamCong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_chamCongMouseClicked(evt);
            }
        });
        btn_chamCong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_chamCongActionPerformed(evt);
            }
        });

        btn_xemLuong.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_xemLuong.setText("Xem lương");
        btn_xemLuong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_xemLuongMouseClicked(evt);
            }
        });
        btn_xemLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xemLuongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_exitLayout = new javax.swing.GroupLayout(pn_exit);
        pn_exit.setLayout(pn_exitLayout);
        pn_exitLayout.setHorizontalGroup(
                pn_exitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_exitLayout.createSequentialGroup()
                                .addGap(0, 414, Short.MAX_VALUE)
                                .addComponent(lbl_chao, javax.swing.GroupLayout.PREFERRED_SIZE, 128,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(btn_doiMK)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_chamCong)
                                .addGap(12, 12, 12)
                                .addComponent(btn_xemLuong)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lb_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 44,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)));
        pn_exitLayout.setVerticalGroup(
                pn_exitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pn_exitLayout.createSequentialGroup()
                                .addGroup(pn_exitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_exitLayout
                                                .createSequentialGroup()
                                                .addContainerGap(36, Short.MAX_VALUE)
                                                .addGroup(pn_exitLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btn_doiMK)
                                                        .addComponent(lbl_chao, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btn_chamCong)
                                                        .addComponent(btn_xemLuong)))
                                        .addGroup(pn_exitLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(lb_exit, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap()));

        javax.swing.GroupLayout pn_allLayout = new javax.swing.GroupLayout(pn_all);
        pn_all.setLayout(pn_allLayout);
        pn_allLayout.setHorizontalGroup(
                pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pn_allLayout.createSequentialGroup()
                                .addComponent(pn_menu, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(pn_exit, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(pn_allLayout.createSequentialGroup()
                                                .addComponent(pn_view, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addContainerGap()))));
        pn_allLayout.setVerticalGroup(
                pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pn_allLayout.createSequentialGroup()
                                .addComponent(pn_exit, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pn_view, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                        .addComponent(pn_menu, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(pn_all, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(pn_all, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)));

        getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lb_exitMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lb_exitMouseClicked
        System.exit(0);
    }// GEN-LAST:event_lb_exitMouseClicked

    private void btn_doiMKMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btn_doiMKMouseClicked
        pn_view.removeAll();
        pn_view.setLayout(new BorderLayout());
        pn_view.add(new PanelDoiPass());
        pn_view.validate();
        pn_view.repaint();
    }// GEN-LAST:event_btn_doiMKMouseClicked

    private void btn_doiMKActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_doiMKActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btn_doiMKActionPerformed

    private void btn_chamCongMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btn_chamCongMouseClicked
        // TODO add your handling code here:
    }// GEN-LAST:event_btn_chamCongMouseClicked

    private void btn_chamCongActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_chamCongActionPerformed
        pn_view.removeAll();
        pn_view.setLayout(new BorderLayout());
        pn_view.add(new PanelChamCong());
        pn_view.validate();
        pn_view.repaint();
    }// GEN-LAST:event_btn_chamCongActionPerformed

    private void btn_xemLuongMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btn_xemLuongMouseClicked
        // TODO add your handling code here:
    }// GEN-LAST:event_btn_xemLuongMouseClicked

    private void btn_xemLuongActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_xemLuongActionPerformed
        pn_view.removeAll();
        pn_view.setLayout(new BorderLayout());
        pn_view.add(new PanelNhanVienXemLuong());
        pn_view.validate();
        pn_view.repaint();
    }// GEN-LAST:event_btn_xemLuongActionPerformed

    private void lb_productMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lb_productMouseClicked
        // pn_view.removeAll();
        // pn_view.setLayout(new BorderLayout());
        // pn_view.add(new PanelSanPham());
        // pn_view.validate();
        // pn_view.repaint();
    }// GEN-LAST:event_lb_productMouseClicked

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn đăng xuất?", "Xác nhận",
                JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            this.dispose(); // Đóng cửa sổ Menu hiện tại
            new Login().setVisible(true); // Mở lại giao diện đăng nhập
        }
    }

    public static void main(String args[]) {
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>
        // </editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_chamCong;
    private javax.swing.JButton btn_doiMK;
    private javax.swing.JButton btn_xemLuong;
    private javax.swing.JLabel lb_exit;
    private javax.swing.JLabel lb_hd;
    private javax.swing.JLabel lb_loaisanpham;
    private javax.swing.JLabel lb_ncc;
    private javax.swing.JLabel lb_nsx;
    private javax.swing.JLabel lb_nv;
    private javax.swing.JLabel lb_pn;
    private javax.swing.JLabel lb_product;
    private javax.swing.JLabel lb_qlnv_admin;
    private javax.swing.JLabel lb_tieude;
    private javax.swing.JLabel lb_tkcn;
    private javax.swing.JLabel lb_tkl;
    private javax.swing.JLabel lb_tksp;
    private javax.swing.JLabel lb_tkspx;
    private javax.swing.JLabel lb_dxn;
    private javax.swing.JLabel lb_ddxn;
    private javax.swing.JLabel lb_trangchu;
    private javax.swing.JLabel lbl_chao;
    private javax.swing.JPanel pn_all;
    private javax.swing.JPanel pn_exit;
    private javax.swing.JPanel pn_hd;
    private javax.swing.JPanel pn_inmenu;
    private javax.swing.JPanel pn_loaisanpham;
    private javax.swing.JPanel pn_menu;
    private javax.swing.JPanel pn_ncc;
    private javax.swing.JPanel pn_nsx;
    private javax.swing.JPanel pn_nv;
    private javax.swing.JPanel pn_pn;
    private javax.swing.JPanel pn_product;
    private javax.swing.JPanel pn_qlnv_admin;
    private javax.swing.JPanel pn_tieude;
    private javax.swing.JPanel pn_tkcn;
    private javax.swing.JPanel pn_tkl;
    private javax.swing.JPanel pn_tksp;
    private javax.swing.JPanel pn_tkspx;
    private javax.swing.JPanel pn_trangchu;
    private javax.swing.JPanel pn_view;
    private javax.swing.JPanel pn_dxn;
    private javax.swing.JPanel pn_ddxn;
    private javax.swing.JButton btn_logout;
    // End of variables declaration//GEN-END:variables

}
