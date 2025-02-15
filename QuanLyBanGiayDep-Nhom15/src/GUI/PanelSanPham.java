package GUI;

import static untils.CheckData.checkNumber;

import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import BUS.LoaiSanPhamBUS;
import BUS.NhaCungCapBUS;
import BUS.NhaSanXuatBUS;
import BUS.SanPhamBUS;
import DTO.LoaiSanPhamDTO;
import DTO.NhaSanXuatDTO;
import DTO.SanPhamDTO;

public class PanelSanPham extends javax.swing.JPanel {

    public static Object data[] = {"", "", ""};
    DefaultTableModel model = new DefaultTableModel();
    ArrayList<SanPhamDTO> tempsearch = new ArrayList<>();
    ArrayList<SanPhamDTO> arr = new ArrayList<>();
    SanPhamBUS bus = new SanPhamBUS();
    NhaCungCapBUS nccBus = new NhaCungCapBUS();
    LoaiSanPhamBUS lspBus = new LoaiSanPhamBUS();
    NhaSanXuatBUS nsxBus = new NhaSanXuatBUS();

    public PanelSanPham() {
        initComponents();
        initData();
        load();
    }

    private void initData() {
        txt_ms.setEnabled(false);
        txt_tg.setEnabled(false);
        txt_ml.setEnabled(false);
        txt_ts.setEnabled(false);
        txt_dg.setEnabled(false);
        txt_sl.setEnabled(false);
        bt_backs.setVisible(false);
                   
        ArrayList<NhaSanXuatDTO> list2 = nsxBus.docNSX();
        for (NhaSanXuatDTO nsx : list2) {
            jComboBox_nsx.addItem(nsx.getMaNSX());  // Assuming NhaCungCapDTO has a suitable toString() method
        }
            
        ArrayList<LoaiSanPhamDTO> list4 = lspBus.docTl();
        for (LoaiSanPhamDTO lsp : list4) {
            jComboBox_lsp.addItem(lsp.getMaLoai());  // Assuming NhaCungCapDTO has a suitable toString() method
        }
    }

    public SanPhamDTO getText() {
        SanPhamDTO s = new SanPhamDTO();
        s.setMaSP(txt_ms.getText().trim());
        s.setMaNSX(txt_tg.getText().trim());
        s.setMaLoai(txt_ml.getText().trim());
        s.setTenSP(txt_ts.getText().trim());
        s.setDonGia(Double.parseDouble(txt_dg.getText().trim()));
        s.setSoLuong(Integer.parseInt(txt_sl.getText().trim()));
        s.setTrangThai(true);
        return s;
    }

    public void load() {
        SanPhamBUS bus = new SanPhamBUS();
        try {
            bus.docSanPham();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi kết nối đến Database.");
            return;
        }
        Vector header = new Vector();
        header.add("Mã sản phẩm");
        header.add("Mã nhà sản xuất");
        header.add("Mã loại");
        header.add("Tên sản phẩm");
        header.add("Đơn giá");
        header.add("Số lượng");
        header.add("Trạng thái");
        model = new DefaultTableModel(header, 0) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        showOnTable(bus.list);
    }

    public Vector setVector(SanPhamDTO s) {
        Vector head = new Vector();
        head.add(s.getMaSP());
        head.add(s.getMaNSX());
        head.add(s.getMaLoai());
        head.add(s.getTenSP());
        head.add(s.getDonGia() + "");
        head.add(s.getSoLuong() + "");
        head.add(s.getTrangThai() + "");
        return head;
    }

    public void showOnTable(ArrayList<SanPhamDTO> list) {
        model.setRowCount(0);
        for (SanPhamDTO s : list) {
            Vector data = setVector(s);
            model.addRow(data);
        }
        tb_SanPham.setModel(model);
    }

    public void setModelValue(SanPhamDTO s, int i) {
        model.setValueAt(s.getMaSP(), i, 0);
        model.setValueAt(s.getMaNSX(), i, 1);
        model.setValueAt(s.getMaLoai(), i, 2);
        model.setValueAt(s.getTenSP(), i, 3);
        model.setValueAt(s.getDonGia(), i, 4);
        model.setValueAt(s.getSoLuong(), i, 5);
        model.setValueAt(s.getTrangThai(), i, 6);
        tb_SanPham.setModel(model);
    }

    public void auto_increaseMaSanPham() {
        String i = null;
        int a;
        String b = "00";
        String c = "0";
        if (bus.docSanPham().size() <= 0) {
            a = 0;
          
        } else {
            SanPhamDTO s = bus.docSanPham().get(bus.docSanPham().size() - 1);
            a = Integer.parseInt(s.getMaSP().substring(7, 10));
        }
        a++;
        if(a<10){ i="SANPHAM"+b+a; }
        if(10<=a && a<=99) {  i ="SANPHAM"+c+a; }
        if(a>100){  i="SANPHAM"+a; }
        txt_ms.setText(i);
    }

    public static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pn_tts = new javax.swing.JPanel();
        lb_ms = new javax.swing.JLabel();
        txt_ms = new javax.swing.JTextField();
        lb_ts = new javax.swing.JLabel();
        txt_ts = new javax.swing.JTextField();
        lb_ml = new javax.swing.JLabel();
        txt_ml = new javax.swing.JTextField();
        lb_tg = new javax.swing.JLabel();
        txt_tg = new javax.swing.JTextField();
        lb_dg = new javax.swing.JLabel();
        txt_dg = new javax.swing.JTextField();
        lb_sl = new javax.swing.JLabel();
        txt_sl = new javax.swing.JTextField();
        jComboBox_lsp = new javax.swing.JComboBox<>();
        jComboBox_nsx = new javax.swing.JComboBox<>();
        pn_dos = new javax.swing.JPanel();
        bt_adds = new javax.swing.JButton();
        bt_activeHidden = new javax.swing.JButton();
        bt_changes = new javax.swing.JButton();
        bt_resets1 = new javax.swing.JButton();
        pn_finds = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        txt_find = new javax.swing.JTextField();
        bt_find = new javax.swing.JButton();
        bt_backs = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_SanPham = new javax.swing.JTable(){
            public boolean isCellEditable ( int row, int col)
            {
                return false;
            }
        };

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        pn_tts.setBackground(new java.awt.Color(255, 255, 255));
        pn_tts.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(255, 102, 102))); // NOI18N

        lb_ms.setText("Mã sản phẩm:");

        lb_ts.setText("Tên sản phẩm:");

        lb_ml.setText("Mã loại:");

        lb_tg.setText("Mã nhà sản xuất");

        lb_dg.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lb_dg.setText("Đơn giá:");

        txt_dg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_dgKeyReleased(evt);
            }
        });

        lb_sl.setText("Số lượng:");

        txt_sl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_slKeyReleased(evt);
            }
        });

        jComboBox_lsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_lspActionPerformed(evt);
            }
        });

        jComboBox_nsx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_nsxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_ttsLayout = new javax.swing.GroupLayout(pn_tts);
        pn_tts.setLayout(pn_ttsLayout);
        pn_ttsLayout.setHorizontalGroup(
            pn_ttsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ttsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_ttsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_ts)
                    .addComponent(lb_ms))
                .addGap(18, 18, 18)
                .addGroup(pn_ttsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_ms, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(txt_ts))
                .addGap(112, 112, 112)
                .addGroup(pn_ttsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_tg)
                    .addComponent(lb_ml))
                .addGap(26, 26, 26)
                .addGroup(pn_ttsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_ml)
                    .addComponent(txt_tg))
                .addGap(17, 17, 17)
                .addGroup(pn_ttsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pn_ttsLayout.createSequentialGroup()
                        .addComponent(jComboBox_nsx, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(lb_sl))
                    .addGroup(pn_ttsLayout.createSequentialGroup()
                        .addComponent(jComboBox_lsp, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lb_dg)))
                .addGap(18, 18, 18)
                .addGroup(pn_ttsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_sl, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_dg, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pn_ttsLayout.setVerticalGroup(
            pn_ttsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ttsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_ttsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_ms)
                    .addComponent(txt_ms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_tg)
                    .addComponent(txt_tg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_sl)
                    .addComponent(txt_sl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_nsx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pn_ttsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_ts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_ts)
                    .addComponent(lb_dg)
                    .addComponent(txt_dg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_ml)
                    .addComponent(txt_ml, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_lsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pn_dos.setBackground(new java.awt.Color(255, 255, 204));
        pn_dos.setBorder(javax.swing.BorderFactory.createTitledBorder("Thực hiện"));

        bt_adds.setBackground(new java.awt.Color(204, 204, 204));
        bt_adds.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_adds.setText("Thêm");
        bt_adds.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_addsActionPerformed(evt);
            }
        });

        bt_activeHidden.setBackground(new java.awt.Color(204, 204, 204));
        bt_activeHidden.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_activeHidden.setText("Kích Hoạt/Vô hiệu hóa");
        bt_activeHidden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_activeHiddenActionPerformed(evt);
            }
        });

        bt_changes.setBackground(new java.awt.Color(204, 204, 204));
        bt_changes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_changes.setText("Sửa");
        bt_changes.setMaximumSize(new java.awt.Dimension(65, 23));
        bt_changes.setMinimumSize(new java.awt.Dimension(65, 23));
        bt_changes.setPreferredSize(new java.awt.Dimension(65, 23));
        bt_changes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_changesActionPerformed(evt);
            }
        });

        bt_resets1.setBackground(new java.awt.Color(204, 204, 204));
        bt_resets1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_resets1.setText("Reset");
        bt_resets1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_resets1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_dosLayout = new javax.swing.GroupLayout(pn_dos);
        pn_dos.setLayout(pn_dosLayout);
        pn_dosLayout.setHorizontalGroup(
            pn_dosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_dosLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(pn_dosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bt_adds, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_changes, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(106, 106, 106)
                .addGroup(pn_dosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_resets1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_activeHidden, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );
        pn_dosLayout.setVerticalGroup(
            pn_dosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_dosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_dosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_adds, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_resets1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pn_dosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_changes, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_activeHidden, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pn_finds.setBackground(new java.awt.Color(204, 255, 204));
        pn_finds.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

        jComboBox1.setBackground(new java.awt.Color(255, 255, 204));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã sản phẩm", "Tên sản phẩm", "Mã loại", "Mã NCC", "Mã nsx" }));

        bt_find.setBackground(new java.awt.Color(204, 204, 204));
        bt_find.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_find.setText("Tìm kiếm");
        bt_find.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_findActionPerformed(evt);
            }
        });

        bt_backs.setBackground(new java.awt.Color(204, 204, 204));
        bt_backs.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_backs.setText("Trở về");
        bt_backs.setMaximumSize(new java.awt.Dimension(65, 23));
        bt_backs.setMinimumSize(new java.awt.Dimension(65, 23));
        bt_backs.setPreferredSize(new java.awt.Dimension(65, 23));
        bt_backs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_backsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_findsLayout = new javax.swing.GroupLayout(pn_finds);
        pn_finds.setLayout(pn_findsLayout);
        pn_findsLayout.setHorizontalGroup(
            pn_findsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_findsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_findsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_findsLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_find, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pn_findsLayout.createSequentialGroup()
                        .addComponent(bt_find, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(bt_backs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(28, 28, 28))
        );
        pn_findsLayout.setVerticalGroup(
            pn_findsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_findsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_findsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_find, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(pn_findsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_find, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_backs, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Sản Phẩm"));

        tb_SanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tb_SanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_SanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_SanPham);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pn_tts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pn_dos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pn_finds, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(pn_tts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pn_dos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn_finds, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 322, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bt_activeHiddenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_activeHiddenActionPerformed
       if (bt_activeHidden.getText().equals("Kích Hoạt/Vô hiệu hóa")) {
            bt_activeHidden.setText("Xác nhận");
    }
    else {
            //xác nhận
            int i = tb_SanPham.getSelectedRow();
            String trangThai = (String) tb_SanPham.getModel().getValueAt(i, 0);
                if (trangThai.equals("true")) {
                    trangThai = "Vô hiệu hóa";
                } else {
                    trangThai = "Kích hoạt";
                }

            
            if(i>=0){
                try {
                    int k = JOptionPane.showConfirmDialog(null, "Xác nhận " + trangThai, "Xác nhận", JOptionPane.YES_NO_CANCEL_OPTION);
                    if (k==1)
                    {
                        // no
                        initData();
                        return;
                    }
                    if (k==2)
                    {
                        //cancel
                        bt_activeHiddenActionPerformed(evt);
                        return;
                    }
                    
                    SanPhamDTO sp = bus.doiTrangThai(tb_SanPham.getModel().getValueAt(i, 0).toString());
                    if(sp != null){
                        setModelValue(sp,i);
                        bt_activeHidden.setText("Kích Hoạt/Vô hiệu hóa");
                        JOptionPane.showMessageDialog(null, trangThai + " thành công");
                    }
                } catch (Exception ex) {
                    Logger.getLogger(PanelSanPham.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, trangThai + " thất bại");                    
            }
        }
    }//GEN-LAST:event_bt_activeHiddenActionPerformed

    private void bt_changesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_changesActionPerformed
        if (bt_changes.getText().equals("Sửa")) {
            txt_ms.setEnabled(false);
            txt_ts.setEnabled(true);
            txt_dg.setEnabled(true);
            txt_sl.setEnabled(true);
           
            bt_changes.setText("Xác nhận");
        } else {
            if (txt_ms.getText().length() != 0 && txt_ts.getText().length() != 0
                    && txt_tg.getText().length() != 0 && txt_ml.getText().length() != 0 && txt_dg.getText().length() != 0 
                    && txt_sl.getText().length() != 0) {
                bt_changes.setText("Sửa");
                int i = tb_SanPham.getSelectedRow();
                if (i >= 0) {
                    int k = JOptionPane.showConfirmDialog(null, "Xác nhận sửa", "Xác nhận", JOptionPane.YES_NO_CANCEL_OPTION);
                    if (k == 1) {
                        initData();
                        return;
                    }
                    if (k == 2) {
                        bt_changesActionPerformed(evt);
                        return;
                    }
                    SanPhamDTO s = getText();
                    int check = bus.suaSanPham(s, i);
                    if (check == 1) {
                        setModelValue(s, i);
                        JOptionPane.showMessageDialog(null, "Sửa thành công");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Sửa thất bại");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Bạn cần nhập đầy đủ thông tin vào bảng");
            }
        }

    }//GEN-LAST:event_bt_changesActionPerformed

    private void bt_findActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_findActionPerformed
        String[] header = {"Mã sản phẩm", "Mã nhà sản xuất", "Mã NCC", "Mã loại", "Tên sản phẩm", "HSD", "Đơn giá", "Số lượng"};
        DefaultTableModel modelsearch = new DefaultTableModel(header, 0);
        ArrayList<SanPhamDTO> s;
        s = bus.timkiemSanPham(String.valueOf(jComboBox1.getSelectedItem()), txt_find.getText().toLowerCase().trim());
        if (s.size() != 0) {
            for (int i = 0; i < s.size(); i++) {
                Object[] row = {s.get(i).getMaSP(), s.get(i).getMaNSX(), s.get(i).getMaLoai(), s.get(i).getTenSP(), s.get(i).getDonGia(), s.get(i).getSoLuong()
                };
                modelsearch.addRow(row);
            }
            tempsearch.addAll(arr);
            arr.clear();
            arr.addAll(s);

            tb_SanPham.setModel(modelsearch);
            bt_backs.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Không có kết quả phù hợp!");
        }
    }//GEN-LAST:event_bt_findActionPerformed

    private void tb_SanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_SanPhamMouseClicked
        int i = tb_SanPham.getSelectedRow();
        if (i >= 0) {
            txt_ms.setText(tb_SanPham.getModel().getValueAt(i, 0).toString());
            txt_tg.setText(tb_SanPham.getModel().getValueAt(i, 1).toString());
            txt_ml.setText(tb_SanPham.getModel().getValueAt(i, 2).toString());
            txt_ts.setText(tb_SanPham.getModel().getValueAt(i, 3).toString());
            txt_dg.setText(tb_SanPham.getModel().getValueAt(i, 4).toString());
            txt_sl.setText(tb_SanPham.getModel().getValueAt(i, 5).toString());
        }
    }//GEN-LAST:event_tb_SanPhamMouseClicked

    private void bt_addsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_addsActionPerformed
        if (bt_adds.getText().equals("Thêm")) {
            txt_ms.setEnabled(true);
            txt_ms.setEditable(false);
            txt_ts.setEnabled(true);
            txt_dg.setEnabled(true);
            txt_sl.setEnabled(true);
    
            bt_adds.setText("Xác nhận");
            txt_tg.setText("");
            txt_ml.setText("");
            txt_ts.setText("");
            txt_dg.setText("0");
            txt_sl.setText("0");
                      
            txt_tg.setEnabled(true);
            txt_tg.setEditable(false);
            
            txt_ml.setEnabled(true);
            txt_ml.setEditable(false);

            
            
            
        } else {
            if (txt_ms.getText().length() != 0 && txt_ts.getText().length() != 0
                    && txt_tg.getText().length() != 0 && txt_ml.getText().length() != 0 &&
                    txt_dg.getText().length() != 0 && txt_sl.getText().length() != 0) {
                bt_adds.setText("Thêm");
                int k = JOptionPane.showConfirmDialog(null, "Xác nhận thêm", "Xác nhận", JOptionPane.YES_NO_CANCEL_OPTION);
                if (k == 1) {
                    initData();
                    return;
                }
                if (k == 2) {
                    bt_addsActionPerformed(evt);
                    return;
                }
                SanPhamDTO s = getText();
                Vector head = setVector(s);
                int check = bus.themSanPham(s);
                if (check == 1) {
                    model.addRow(head);
                    tb_SanPham.setModel(model);
                    JOptionPane.showMessageDialog(null, "Thêm thành công");
                } else {
                    JOptionPane.showMessageDialog(null, "Mã đã tồn tại. Thêm thất bại");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Bạn cần nhập đầy đủ thông tin vào bảng");
            }
        }
        auto_increaseMaSanPham();
    }//GEN-LAST:event_bt_addsActionPerformed

    private void bt_backsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_backsActionPerformed
        arr.clear();
        arr.addAll(tempsearch);
        tempsearch.clear();
        tb_SanPham.setModel(model);
        bt_backs.setVisible(false);
    }//GEN-LAST:event_bt_backsActionPerformed

    private void txt_slKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_slKeyReleased
        if (!checkNumber(txt_sl.getText())) {
            JOptionPane.showMessageDialog(null, "Vui lòng chỉ nhập số");
        }
    }//GEN-LAST:event_txt_slKeyReleased

    private void txt_dgKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dgKeyReleased
        if (!isDouble(txt_dg.getText())) {
            JOptionPane.showMessageDialog(null, "Đơn giá phải là số");
        }
    }//GEN-LAST:event_txt_dgKeyReleased

    private void jComboBox_lspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_lspActionPerformed

        String selectedTextLSP = (String) jComboBox_lsp.getSelectedItem();
        txt_ml.setText(selectedTextLSP);
    }//GEN-LAST:event_jComboBox_lspActionPerformed

    private void jComboBox_nsxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_nsxActionPerformed
         String selectedTextNSX = (String) jComboBox_nsx.getSelectedItem();
        txt_tg.setText(selectedTextNSX);
    }//GEN-LAST:event_jComboBox_nsxActionPerformed

    private void bt_resets1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_resets1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_resets1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_activeHidden;
    private javax.swing.JButton bt_adds;
    private javax.swing.JButton bt_backs;
    private javax.swing.JButton bt_changes;
    private javax.swing.JButton bt_find;
    private javax.swing.JButton bt_resets1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox_lsp;
    private javax.swing.JComboBox<String> jComboBox_nsx;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_dg;
    private javax.swing.JLabel lb_ml;
    private javax.swing.JLabel lb_ms;
    private javax.swing.JLabel lb_sl;
    private javax.swing.JLabel lb_tg;
    private javax.swing.JLabel lb_ts;
    private javax.swing.JPanel pn_dos;
    private javax.swing.JPanel pn_finds;
    private javax.swing.JPanel pn_tts;
    private javax.swing.JTable tb_SanPham;
    private javax.swing.JTextField txt_dg;
    private javax.swing.JTextField txt_find;
    private javax.swing.JTextField txt_ml;
    private javax.swing.JTextField txt_ms;
    private javax.swing.JTextField txt_sl;
    public javax.swing.JTextField txt_tg;
    private javax.swing.JTextField txt_ts;
    // End of variables declaration//GEN-END:variables

}
