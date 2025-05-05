package GUI;

import java.awt.BorderLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import BUS.ChiTietPhieuXuatBUS;
import BUS.PhieuXuatBUS;
import DTO.ChiTietPhieuXuatDTO;
import DTO.PhieuXuatDTO;
import java.awt.Color;

public class PanelPhieuXuat extends javax.swing.JPanel {
    DefaultTableModel model1 = new DefaultTableModel();
    DefaultTableModel model2 = new DefaultTableModel();
    ArrayList<PhieuXuatDTO> tempsearch = new ArrayList<PhieuXuatDTO>();
    ArrayList<PhieuXuatDTO> arr = new ArrayList<PhieuXuatDTO>();
    PhieuXuatBUS bus = new PhieuXuatBUS();
    ChiTietPhieuXuatBUS bus1 = new ChiTietPhieuXuatBUS();
    SimpleDateFormat formatofDate;
    public static String maHDafterclick;

    public PanelPhieuXuat() {
        initComponents();
        model1 = (DefaultTableModel) tb_HoaDon.getModel();
        model2 = (DefaultTableModel) tb_cthd.getModel();        
        formatofDate = new SimpleDateFormat("yyyy-MM-dd");         
        initData();
        load();
        loadCTPX(null);
        loadinCbox();     
        btn_Back.setVisible(false);
    }
    private void initData() {
        txt_mhd.setEnabled(false);
        cb_nv.setEnabled(false);
        date_ngay.setEnabled(false);
        txt_tongtien.setEnabled(false);
        btn_Back.setVisible(false);
        pn_fromto.setVisible(false);
    }
    public void load() {
        PhieuXuatBUS pxbus = new PhieuXuatBUS();
        try{
            pxbus.docPX();
        } catch (Exception e){
            System.out.println("GUI load px: " + e.getMessage());
            return;}
        Vector header;
        header = new Vector();
        header.add("Mã phiếu xuất");
        header.add("Mã nhân viên");
        header.add("Ngày xuất");
        header.add("Tổng tiền");
        model1 = new DefaultTableModel(header, 0){
            public boolean isCellEditTable(int row, int column){
                return false;}
        };
        showOnTablePX(pxbus.list);
    }
    public void showOnTablePX(ArrayList<PhieuXuatDTO> list) {
        model1.setRowCount(0);
        for (PhieuXuatDTO px : list){
            Vector data = setVectorPX(px);
            model1.addRow(data);
        }
        tb_HoaDon.setModel(model1);
    }
    public Vector setVectorPX(PhieuXuatDTO px) {
        Vector temp = new Vector();
        temp.add(px.getMaPX());
        temp.add(px.getMaNV());
        temp.add(px.getNgayXuat());
        temp.add(px.getTongtien());        
        return temp;

    }
    public PhieuXuatDTO getText(){
        PhieuXuatDTO temp = new PhieuXuatDTO();
        temp.setMaPX(txt_mhd.getText().trim());
        temp.setMaNV((String)cb_nv.getSelectedItem());        
        temp.setNgayXuat(new SimpleDateFormat("yyyy-MM-dd").format(date_ngay.getDate()));
        temp.setTongtien(Double.parseDouble(txt_tongtien.getText().trim()));               
        return temp; 
    }
    public void setModelValueHD(PhieuXuatDTO px, int i){
        model1.setValueAt(px.getMaPX(), i, 0);
        model1.setValueAt(px.getMaNV(), i, 1);
        model1.setValueAt(px.getNgayXuat(), i, 2);
        model1.setValueAt(px.getTongtien(), i, 3);
        tb_HoaDon.setModel(model1);
    }
    public void loadCTPX(String MaPX) {
        ChiTietPhieuXuatBUS bus1 = new ChiTietPhieuXuatBUS();
        try {
            bus1.docCTPX();
        } catch (Exception e){
            System.out.println("PhieuXuat panel: loadCTPX " + e.getMessage());
            //JOptionPane.showMessageDialog(null, "Lỗi đọc CTHD từ DataBase!!!");
            return;
        }
        Vector header = new Vector();
        header.add("Mã phiếu xuất");
        header.add("Mã sản phẩm");
        header.add("Đơn giá chi tiết");
        header.add("Số lượng");
        header.add("Thành tiền");
        model2 = new DefaultTableModel(header,0){
            public boolean isCellEditable(int row, int column)
                {
                  return false;
                }
       };
        showOnTableCTPX(bus1.listctpx,MaPX);
    }
    
    private void showOnTableCTPX(ArrayList<ChiTietPhieuXuatDTO> list, String MaPX) {
        model2.setRowCount(0);
        for (ChiTietPhieuXuatDTO ct : list){
          if (ct.getMaPX().equals(MaPX)||MaPX == null){
            Vector data = setVectorCT(ct);
            model2.addRow(data);}
        }
        tb_cthd.setModel(model2);
    }
    private Vector setVectorCT(ChiTietPhieuXuatDTO ct) {
        Vector row = new Vector();
        row.add(ct.getMaPX());
        row.add(ct.getMaSP());
        row.add(ct.getDonGia());        
        row.add(ct.getSoLuong());
        row.add(ct.getThanhTien());
        return row;
    }
    public void loadinCbox(){
        Vector cbMaNv=  bus.loadcb_nv();
        this.cb_nv.setModel(new DefaultComboBoxModel<>(cbMaNv));
//        Vector cbMaKh=  bus.loadcb_kh();
//        this.cb_kh.setModel(new DefaultComboBoxModel<>(cbMaKh));        
//        Vector cbMaKm = bus.loadcb_km();
//        this.cb_km.setModel(new DefaultComboBoxModel<>(cbMaKm));
    }
//    public void auto_increaseMaPx(){
//        String i = null;
//        PhieuXuatDTO hd= bus.docPX().get(bus.docPX().size()-1);
//        String b="00";
//        String c="0";
//        int a= Integer.parseInt(hd.getMaPX().substring(2,5));
//        a++;
//        if(a<10){ i="PX"+b+a; }
//        if(10<=a && a<=99) {  i ="PX"+c+a; }
//        if(a>100){  i="PX"+a; }
//        txt_mhd.setText(i);
//    }  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_all = new javax.swing.JPanel();
        pn_tthd = new javax.swing.JPanel();
        lb_mhd = new javax.swing.JLabel();
        txt_mhd = new javax.swing.JTextField();
        lb_nv = new javax.swing.JLabel();
        cb_nv = new javax.swing.JComboBox<>();
        ngay_xuat = new javax.swing.JLabel();
        date_ngay = new com.toedter.calendar.JDateChooser();
        lb_tongtien = new javax.swing.JLabel();
        txt_tongtien = new javax.swing.JTextField();
        pn_cthd = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_cthd = new javax.swing.JTable(){
            public boolean isCellEditable ( int row, int col)
            {
                return false;
            }
        };
        pn_find = new javax.swing.JPanel();
        cb_TimKiem = new javax.swing.JComboBox<>();
        txt_TimKiem = new javax.swing.JTextField();
        btn_TimKiem = new javax.swing.JButton();
        pn_tknc = new javax.swing.JPanel();
        cb_tknc = new javax.swing.JComboBox<>();
        txt_tknc1 = new javax.swing.JTextField();
        txt_tknc2 = new javax.swing.JTextField();
        btn_tknc = new javax.swing.JButton();
        btn_Back = new javax.swing.JButton();
        pn_fromto = new javax.swing.JPanel();
        date_from = new com.toedter.calendar.JDateChooser();
        date_to = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pn_hd = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_HoaDon = new javax.swing.JTable(){
            public boolean isCellEditable ( int row, int col)
            {
                return false;
            }
        };
        jPanel1 = new javax.swing.JPanel();
        btn_themHD = new javax.swing.JButton();
        btn_suaHD = new javax.swing.JButton();
        btn_resetHD = new javax.swing.JButton();

        pn_all.setBackground(new Color(240, 240, 240));
        pn_all.setPreferredSize(new java.awt.Dimension(931, 680));

        pn_tthd.setBackground(new java.awt.Color(255, 255, 255));
        pn_tthd.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin phiếu xuất", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), java.awt.Color.black)); // NOI18N

        lb_mhd.setText("Mã hóa đơn:");

        lb_nv.setText("Mã nhân viên:");

        cb_nv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        ngay_xuat.setText("Ngày xuất:");

        date_ngay.setDateFormatString("yyyy-MM-dd");

        lb_tongtien.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lb_tongtien.setText("Tổng tiền:");

        javax.swing.GroupLayout pn_tthdLayout = new javax.swing.GroupLayout(pn_tthd);
        pn_tthd.setLayout(pn_tthdLayout);
        pn_tthdLayout.setHorizontalGroup(
            pn_tthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_tthdLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_tthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_nv)
                    .addComponent(lb_mhd)
                    .addComponent(lb_tongtien))
                .addGroup(pn_tthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_tthdLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(txt_mhd))
                    .addGroup(pn_tthdLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pn_tthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_tongtien)
                            .addComponent(cb_nv, 0, 92, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ngay_xuat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(date_ngay, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pn_tthdLayout.setVerticalGroup(
            pn_tthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_tthdLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_tthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_mhd)
                    .addComponent(txt_mhd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pn_tthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_tthdLayout.createSequentialGroup()
                        .addGroup(pn_tthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_nv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_nv)
                            .addComponent(ngay_xuat))
                        .addGap(15, 15, 15)
                        .addGroup(pn_tthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_tongtien)
                            .addComponent(txt_tongtien)))
                    .addComponent(date_ngay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(109, Short.MAX_VALUE))
        );

        pn_cthd.setBackground(new java.awt.Color(255, 255, 255));
        pn_cthd.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi tiết", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), java.awt.Color.black)); // NOI18N

        tb_cthd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tb_cthd);

        javax.swing.GroupLayout pn_cthdLayout = new javax.swing.GroupLayout(pn_cthd);
        pn_cthd.setLayout(pn_cthdLayout);
        pn_cthdLayout.setHorizontalGroup(
            pn_cthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        pn_cthdLayout.setVerticalGroup(
            pn_cthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        pn_find.setBackground(new java.awt.Color(255, 255, 255));
        pn_find.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

        cb_TimKiem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cb_TimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã phiếu xuất", "Mã nhân viên" }));

        btn_TimKiem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_TimKiem.setText("Tìm kiếm");
        btn_TimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_TimKiemMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pn_findLayout = new javax.swing.GroupLayout(pn_find);
        pn_find.setLayout(pn_findLayout);
        pn_findLayout.setHorizontalGroup(
            pn_findLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_findLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cb_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_TimKiem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_TimKiem)
                .addContainerGap())
        );
        pn_findLayout.setVerticalGroup(
            pn_findLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_findLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(cb_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txt_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pn_tknc.setBackground(new Color(255, 255, 255));
        pn_tknc.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm nâng cao"));

        cb_tknc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cb_tknc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tổng tiền", "Ngày" }));
        cb_tknc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_tkncActionPerformed(evt);
            }
        });

        btn_tknc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_tknc.setText("Tìm kiếm");
        btn_tknc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tkncActionPerformed(evt);
            }
        });

        btn_Back.setBackground(new java.awt.Color(204, 204, 204));
        btn_Back.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_Back.setText("Back");
        btn_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BackActionPerformed(evt);
            }
        });

        pn_fromto.setBackground(new Color(240, 240, 240));

        date_from.setDateFormatString("yyyy-MM-dd");

        date_to.setDateFormatString("yyyy-MM-dd");

        jLabel1.setText("Từ:");

        jLabel2.setText("đến:");

        javax.swing.GroupLayout pn_fromtoLayout = new javax.swing.GroupLayout(pn_fromto);
        pn_fromto.setLayout(pn_fromtoLayout);
        pn_fromtoLayout.setHorizontalGroup(
            pn_fromtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_fromtoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(date_from, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(7, 7, 7)
                .addComponent(date_to, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                .addContainerGap())
        );
        pn_fromtoLayout.setVerticalGroup(
            pn_fromtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_fromtoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pn_fromtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date_to, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date_from, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pn_tkncLayout = new javax.swing.GroupLayout(pn_tknc);
        pn_tknc.setLayout(pn_tkncLayout);
        pn_tkncLayout.setHorizontalGroup(
            pn_tkncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_tkncLayout.createSequentialGroup()
                .addGroup(pn_tkncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_tkncLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cb_tknc, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txt_tknc1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_tknc2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pn_fromto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_tkncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_tknc, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
                .addContainerGap())
        );
        pn_tkncLayout.setVerticalGroup(
            pn_tkncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_tkncLayout.createSequentialGroup()
                .addGroup(pn_tkncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_tknc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tknc2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_tknc))
                .addGroup(pn_tkncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_tkncLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(pn_fromto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pn_tkncLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btn_tknc)))
                .addContainerGap())
        );

        pn_hd.setBackground(new java.awt.Color(255, 255, 255));
        pn_hd.setBorder(javax.swing.BorderFactory.createTitledBorder("Phiếu xuất"));

        tb_HoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tb_HoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_HoaDonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tb_HoaDonMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tb_HoaDon);

        javax.swing.GroupLayout pn_hdLayout = new javax.swing.GroupLayout(pn_hd);
        pn_hd.setLayout(pn_hdLayout);
        pn_hdLayout.setHorizontalGroup(
            pn_hdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        pn_hdLayout.setVerticalGroup(
            pn_hdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_hdLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBackground(new Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Thực hiện"));

        btn_themHD.setBackground(new Color(76, 175, 80));
        btn_themHD.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_themHD.setText("Thêm");
        btn_themHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themHDActionPerformed(evt);
            }
        });

        btn_suaHD.setBackground(new Color(255, 193, 7));
        btn_suaHD.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_suaHD.setText("Sửa");
        btn_suaHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaHDActionPerformed(evt);
            }
        });

        btn_resetHD.setBackground(new Color(66, 165, 245));
        btn_resetHD.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_resetHD.setText("Reset");
        btn_resetHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_resetHDMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_themHD, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_resetHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btn_suaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_themHD, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_resetHD, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_suaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout pn_allLayout = new javax.swing.GroupLayout(pn_all);
        pn_all.setLayout(pn_allLayout);
        pn_allLayout.setHorizontalGroup(
            pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_allLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_hd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pn_allLayout.createSequentialGroup()
                        .addGroup(pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pn_tthd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pn_tknc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pn_find, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pn_cthd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pn_allLayout.setVerticalGroup(
            pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_allLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pn_tthd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_allLayout.createSequentialGroup()
                        .addComponent(pn_cthd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pn_find, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn_tknc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_hd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_all, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pn_all, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_TimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_TimKiemMouseClicked
        String[] header = {"Mã phiếu xuất", "Mã nhân viên", "Ngày xuất", "Tổng tiền"};
        DefaultTableModel modelsearch = new DefaultTableModel(header , 0);
        ArrayList<PhieuXuatDTO> hd;
        hd = bus.timKiemPX(String.valueOf(cb_TimKiem.getSelectedItem()), txt_TimKiem.getText().toLowerCase());
        if (!hd.isEmpty()){
            for (int i = 0; i < hd.size(); i++){
                Object[] row = {hd.get(i).getMaPX(), hd.get(i).getMaNV(), hd.get(i).getNgayXuat(), hd.get(i).getTongtien()};
                modelsearch.addRow(row);
            }
            tempsearch.addAll(arr);
            tb_HoaDon.setModel(modelsearch);
            btn_Back.setVisible(true);}
        else {
            JOptionPane.showMessageDialog(null, "Không có kết quả phù hợp");}
    }//GEN-LAST:event_btn_TimKiemMouseClicked

    private void btn_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BackActionPerformed
        load();
        reset();
        btn_Back.setVisible(false);
    }//GEN-LAST:event_btn_BackActionPerformed

    private void tb_HoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_HoaDonMouseClicked
        int i = tb_HoaDon.getSelectedRow();
        if (i >= 0){   
            txt_mhd.setText(tb_HoaDon.getModel().getValueAt(i, 0).toString());
            cb_nv.setSelectedItem(tb_HoaDon.getModel().getValueAt(i,1).toString());
            try {
                date_ngay.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(tb_HoaDon.getModel().getValueAt(i, 2)+""));
            } catch (ParseException ex) {
                Logger.getLogger(PanelPhieuXuat.class.getName()).log(Level.SEVERE, null, ex);
            }
            txt_tongtien.setText(tb_HoaDon.getModel().getValueAt(i, 3).toString());
//            txt_tonggg.setText(tb_HoaDon.getModel().getValueAt(i, 6).toString());
//            txt_ttien.setText(tb_HoaDon.getModel().getValueAt(i, 7).toString());
            loadCTPX(txt_mhd.getText());
        }
    }//GEN-LAST:event_tb_HoaDonMouseClicked

    private void btn_themHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themHDActionPerformed
    if (btn_themHD.getText().equals("Thêm")){
        txt_mhd.setEnabled(true);
        cb_nv.setEnabled(false);
        date_ngay.setEnabled(true);
        txt_tongtien.setEnabled(true);
        txt_tongtien.setEditable(false);            
        btn_themHD.setText("Xác nhận");
        txt_mhd.setText("");
        cb_nv.setSelectedItem(Login.username);
        date_ngay.setDate(null);

        txt_tongtien.setText("0");}
    else {
        if (txt_mhd.getText().length()!= 0 && txt_tongtien.getText().length()!= 0){
            btn_themHD.setText("Thêm");
            int k = JOptionPane.showConfirmDialog(null, "Xác nhận thêm", "Xác nhận", JOptionPane.YES_NO_CANCEL_OPTION);
            if (k==1)
            {
                initData();
                return;
            }
            if (k==2)
            {
                btn_themHDActionPerformed(evt);
                return;
            }
            PhieuXuatDTO hd = getText();
            Vector head = setVectorPX(hd);
            int check = bus.themPX(hd);
            if (check == 1) {   
                model1.addRow(head);
                tb_HoaDon.setModel(model1);
                JOptionPane.showMessageDialog(null, "Thêm thành công");
            } else { JOptionPane.showMessageDialog(null, "Mã đã tồn tại");}
            } else { JOptionPane.showMessageDialog(null, "Bạn cần nhập đầy đủ thông tin");}
        }           
    auto_increaseMaPx();
    }//GEN-LAST:event_btn_themHDActionPerformed

    private void btn_suaHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaHDActionPerformed
        if (btn_suaHD.getText().equals("Sửa")){
           // cb_kh.setEnabled(true);
            cb_nv.setEnabled(false);
            date_ngay.setEnabled(true);
//            cb_km.setEnabled(true);
//            txt_ttien.setEnabled(true);
//            txt_tonggg.setEnabled(true);
            txt_tongtien.setEnabled(true);
//            txt_ttien.setEditable(false);
//            txt_tonggg.setEditable(false);
            txt_tongtien.setEditable(false);
            cb_nv.setSelectedItem(Login.username);                
            btn_suaHD.setText("Xác nhận");}
        else{
        if (
//                cb_kh.getSelectedItem()!=null && cb_km.getSelectedItem()!=null && 
                cb_nv.getSelectedItem()!=null && date_ngay.getDate()!=null){
                btn_suaHD.setText("Sửa");
                int i = tb_HoaDon.getSelectedRow();
                if (i>=0){
                    int k =JOptionPane.showConfirmDialog(null, "Xác nhận sửa", "Xác nhận", JOptionPane.YES_NO_CANCEL_OPTION);
                    if (k==1)
                    {
                        initData();
                        return;
                    }
                    if (k==2)
                    {
                        btn_suaHDActionPerformed(evt);
                        return;
                    }
                    PhieuXuatDTO hd = getText();
                    int check = bus.suaPX(hd, i);
                    if (check == 1) {
                        setModelValueHD(hd, i);
                        JOptionPane.showMessageDialog(null, "Sửa thành công!!!");}
                    else{
                        JOptionPane.showMessageDialog(null, "Sửa thất bại!!!");}
                }else{
                        JOptionPane.showMessageDialog(null, "Bạn cần nhập đầy đủ!!!");}
            }
        }
    }//GEN-LAST:event_btn_suaHDActionPerformed

    private void btn_resetHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_resetHDMouseClicked
        reset();
    }//GEN-LAST:event_btn_resetHDMouseClicked

    private void cb_tkncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_tkncActionPerformed
        if(cb_tknc.getSelectedIndex()==0 || cb_tknc.getSelectedIndex()== 1){
            pn_fromto.setVisible(false);
            txt_tknc1.setEnabled(true);
            txt_tknc2.setEnabled(true);            
        }
        if(cb_tknc.getSelectedIndex()== 2){
            pn_fromto.setVisible(true);
            txt_tknc1.setEnabled(false);
            txt_tknc2.setEnabled(false);
        }        
    }//GEN-LAST:event_cb_tkncActionPerformed

    private void btn_tkncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tkncActionPerformed
   if(cb_tknc.getSelectedIndex()==0 || cb_tknc.getSelectedIndex()== 1){
      searchnangcao(String.valueOf(cb_tknc.getSelectedItem()) , txt_tknc1.getText().toLowerCase(), txt_tknc2.getText().toLowerCase()); }
   if(cb_tknc.getSelectedIndex()==2){
       try {
            searchngay(new SimpleDateFormat("yyyy-MM-dd").format(date_from.getDate()),new SimpleDateFormat("yyyy-MM-dd").format(date_to.getDate()));
           } catch (Exception ex) {
                  Logger.getLogger(PanelPhieuXuat.class.getName()).log(Level.SEVERE, null, ex); }
       } else{ JOptionPane.showMessageDialog(null, "Không có kết quả phù hợp");}
    }//GEN-LAST:event_btn_tkncActionPerformed

    private void tb_HoaDonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_HoaDonMousePressed
        if(evt.getClickCount()==2 && tb_HoaDon.getSelectedRow()!=-1){
        maHDafterclick = txt_mhd.getText();
        this.removeAll();
        this.setLayout(new BorderLayout());
        this.add(new PanelChiTietPhieuXuat(maHDafterclick));
        this.validate();
        this.repaint();}
    }//GEN-LAST:event_tb_HoaDonMousePressed
public void auto_increaseMaPx(){
        String i = null;
    List<PhieuXuatDTO> pxList = bus.docPX();
    if (pxList.isEmpty()) {
        // This is the first PhieuXuatDTO, so we set the MaPX to "PX001"
        i = "PX001";
    } else {
        PhieuXuatDTO px = pxList.get(pxList.size() - 1);
        int a = Integer.parseInt(px.getMaPX().substring(2, 5));
        a++;
        if (a < 10) {
            i = "PX00" + a;
        } else if (a <= 99) {
            i = "PX0" + a;
        } else {
            i = "PX" + a;
        }
    }
    txt_mhd.setText(i);
    }//
    public void searchngay(String from ,String to)throws Exception{
        model1.setRowCount(0);
        for(PhieuXuatDTO hd: bus.timtheoNgay(from,to)){
            model1.addRow(new Object[]{
            hd.getMaPX(),hd.getMaNV(),hd.getNgayXuat(),hd.getTongtien()
            });
        }
        tempsearch.addAll(arr);
        btn_Back.setVisible(true);
      
    }
    public void searchnangcao(String key,String from,String to){
        for(PhieuXuatDTO hd:bus.timkiemPXnc(key,from,to)){
            model1.addRow(new Object[]{
                 hd.getMaPX(),hd.getMaNV(),hd.getNgayXuat(),hd.getTongtien()
            });
            tempsearch.addAll(arr);
            btn_Back.setVisible(true);
           }
    }
    public void reset(){
        txt_mhd.setText("");
        cb_nv.setSelectedItem("");
        date_ngay.setDate(null);
        txt_tknc1.setText("");
        txt_tknc2.setText("");
        txt_TimKiem.setText("");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Back;
    private javax.swing.JButton btn_TimKiem;
    private javax.swing.JButton btn_resetHD;
    private javax.swing.JButton btn_suaHD;
    private javax.swing.JButton btn_themHD;
    private javax.swing.JButton btn_tknc;
    private javax.swing.JComboBox<String> cb_TimKiem;
    private javax.swing.JComboBox<String> cb_nv;
    private javax.swing.JComboBox<String> cb_tknc;
    private com.toedter.calendar.JDateChooser date_from;
    private com.toedter.calendar.JDateChooser date_ngay;
    private com.toedter.calendar.JDateChooser date_to;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lb_mhd;
    private javax.swing.JLabel lb_nv;
    private javax.swing.JLabel lb_tongtien;
    private javax.swing.JLabel ngay_xuat;
    private javax.swing.JPanel pn_all;
    private javax.swing.JPanel pn_cthd;
    private javax.swing.JPanel pn_find;
    private javax.swing.JPanel pn_fromto;
    private javax.swing.JPanel pn_hd;
    private javax.swing.JPanel pn_tknc;
    private javax.swing.JPanel pn_tthd;
    private javax.swing.JTable tb_HoaDon;
    private javax.swing.JTable tb_cthd;
    private javax.swing.JTextField txt_TimKiem;
    private javax.swing.JTextField txt_mhd;
    private javax.swing.JTextField txt_tknc1;
    private javax.swing.JTextField txt_tknc2;
    private javax.swing.JTextField txt_tongtien;
    // End of variables declaration//GEN-END:variables
}
