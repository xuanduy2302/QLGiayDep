 
package GUI;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import BUS.NhaSanXuatBUS;
import DTO.NhaSanXuatDTO;

public class PanelNhaSanXuat extends javax.swing.JPanel {
    public static String matacgia;
    DefaultTableModel model = new DefaultTableModel();
    ArrayList<NhaSanXuatDTO> arr = new ArrayList<NhaSanXuatDTO>();
    ArrayList<NhaSanXuatDTO> tempsearch = new ArrayList<NhaSanXuatDTO>();
    NhaSanXuatBUS bus = new NhaSanXuatBUS();
    NhaSanXuatDTO tg = new NhaSanXuatDTO();    
    
    public PanelNhaSanXuat() {
    	this.setPreferredSize(new java.awt.Dimension(960, 740));
        initComponents();
        initData();
        initEvent();
        load();
        model = (DefaultTableModel)tb_tg.getModel();
    }
    private void initEvent() {
        tb_tg.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        public void valueChanged(ListSelectionEvent event) {
            try {
            tg.setMaNSX(arr.get(tb_tg.getSelectedRow()).getMaNSX());
            tg.setTenNSX(arr.get(tb_tg.getSelectedRow()).getTenNSX());
            tg.setSdtNSX(arr.get(tb_tg.getSelectedRow()).getSdtNSX());            
            tg.setDcNSX(arr.get(tb_tg.getSelectedRow()).getDcNSX());            
            }catch (Exception e) {
            }
         
        }
        });
    }
    private void initData(){
        txt_nsx.setEnabled(false);
        txt_tennsx.setEnabled(false);
        txt_sdtnsx.setEnabled(false);
        txt_dcnsx.setEnabled(false);
        bt_backnsx.setVisible(false);
    }
    public NhaSanXuatDTO getText(){
        NhaSanXuatDTO tg = new NhaSanXuatDTO();
        tg.setMaNSX(txt_nsx.getText().trim());
        tg.setTenNSX(txt_tennsx.getText().trim());
        tg.setSdtNSX(txt_sdtnsx.getText().trim());
        tg.setDcNSX(txt_dcnsx.getText().trim());
        return tg;
    }
    private void load(){
       NhaSanXuatBUS bus = new NhaSanXuatBUS();
       try{
           bus.docNSX();
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Lỗi kết nối đến Database.");
           return;
       }
       Vector header = new Vector();
        header.add("Mã nhà sản xuất");
        header.add("Tên");
        header.add("Số điện thoại");
        header.add("Địa chỉ");
       model = new DefaultTableModel(header,0){
            public boolean isCellEditable(int row, int column)
                {
                  return false;
                }
       };	
       showOnTable(bus.list);
    }
    private Vector setVector(NhaSanXuatDTO tg){
            Vector head = new Vector();
            head.add(tg.getMaNSX());
            head.add(tg.getTenNSX());
            head.add(tg.getSdtNSX());
            head.add(tg.getDcNSX());
            return head;
    }    
    private void showOnTable(ArrayList<NhaSanXuatDTO> list){
        model.setRowCount(0);
        for(NhaSanXuatDTO tg:list){
           Vector data = setVector(tg);
           model.addRow(data);
       }
       tb_tg.setModel(model);
    }
    private void setModelValue(NhaSanXuatDTO tg, int i){
        model.setValueAt(tg.getMaNSX(),i,0);
        model.setValueAt(tg.getTenNSX(),i,1);
        model.setValueAt(tg.getSdtNSX(),i,2);
        model.setValueAt(tg.getDcNSX(),i,3);     
        tb_tg.setModel(model);            
    }
    public void auto_increaseMaNSX() {
        int a = 0; // Mặc định nếu chưa có NSX nào
        ArrayList<NhaSanXuatDTO> dsNSX = bus.docNSX(); // Lấy danh sách NSX đã được sắp xếp

        System.out.println("Danh sách NSX: " + dsNSX.size());

        if (!dsNSX.isEmpty()) { 
            NhaSanXuatDTO tg = dsNSX.get(dsNSX.size() - 1); // Lấy mã NSX cuối cùng
            System.out.println("Mã NSX cuối: " + tg.getMaNSX());
            a = Integer.parseInt(tg.getMaNSX().substring(3)); // Lấy phần số sau "NSX"
        }

        a++; // Tăng mã lên 1
        String i = "NSX" + a; // Tạo mã mới
        txt_nsx.setText(i);
        System.out.println("Mã NSX mới: " + i);
    }


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        pn_tt1 = new javax.swing.JPanel();
        lb_nsx = new javax.swing.JLabel();
        txt_nsx = new javax.swing.JTextField();
        lb_ten1 = new javax.swing.JLabel();
        txt_tennsx = new javax.swing.JTextField();
        lb_dc1 = new javax.swing.JLabel();
        txt_dcnsx = new javax.swing.JTextField();
        lb_sdt1 = new javax.swing.JLabel();
        txt_sdtnsx = new javax.swing.JTextField();
        pn_donsx = new javax.swing.JPanel();
        bt_addnsx = new javax.swing.JButton();
        bt_resetnsx = new javax.swing.JButton();
        bt_changensx = new javax.swing.JButton();
        pn_findnsx = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        txt_find = new javax.swing.JTextField();
        bt_find = new javax.swing.JButton();
        bt_backnsx = new javax.swing.JButton();
        panel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_tg = new javax.swing.JTable(){
            public boolean isCellEditable ( int row, int col)
            {
                return false;
            }
        };

        jPanel6.setBackground(new java.awt.Color(204, 204, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(945, 617));

        pn_tt1.setBackground(new java.awt.Color(255, 255, 255));
        pn_tt1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin nhà sản xuất", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(255, 102, 102))); // NOI18N

        lb_nsx.setText("Mã nhà sản xuất:");

        lb_ten1.setText("Tên nhà sản xuất:");

        lb_dc1.setText("Địa chỉ:");

        lb_sdt1.setText("Điện thoại:");

        javax.swing.GroupLayout pn_tt1Layout = new javax.swing.GroupLayout(pn_tt1);
        pn_tt1.setLayout(pn_tt1Layout);
        pn_tt1Layout.setHorizontalGroup(
            pn_tt1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_tt1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_tt1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_ten1)
                    .addComponent(lb_nsx))
                .addGap(18, 18, 18)
                .addGroup(pn_tt1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_nsx, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(txt_tennsx))
                .addGap(33, 33, 33)
                .addGroup(pn_tt1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_tt1Layout.createSequentialGroup()
                        .addComponent(lb_dc1)
                        .addGap(18, 18, 18)
                        .addComponent(txt_dcnsx))
                    .addGroup(pn_tt1Layout.createSequentialGroup()
                        .addComponent(lb_sdt1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_sdtnsx)))
                .addContainerGap())
        );
        pn_tt1Layout.setVerticalGroup(
            pn_tt1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_tt1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(pn_tt1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_nsx)
                    .addComponent(txt_nsx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_sdt1)
                    .addComponent(txt_sdtnsx))
                .addGap(18, 18, 18)
                .addGroup(pn_tt1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_ten1)
                    .addComponent(txt_tennsx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_dc1)
                    .addComponent(txt_dcnsx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pn_donsx.setBackground(new java.awt.Color(255, 255, 204));
        pn_donsx.setBorder(javax.swing.BorderFactory.createTitledBorder("Thực hiện"));

        bt_addnsx.setBackground(new java.awt.Color(204, 204, 204));
        bt_addnsx.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_addnsx.setText("Thêm");
        bt_addnsx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_addnsxActionPerformed(evt);
            }
        });

        bt_resetnsx.setBackground(new java.awt.Color(204, 204, 204));
        bt_resetnsx.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_resetnsx.setText("Reset");
        bt_resetnsx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_resetnsxActionPerformed(evt);
            }
        });

        bt_changensx.setBackground(new java.awt.Color(204, 204, 204));
        bt_changensx.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_changensx.setText("Sửa");
        bt_changensx.setMaximumSize(new java.awt.Dimension(65, 23));
        bt_changensx.setMinimumSize(new java.awt.Dimension(65, 23));
        bt_changensx.setPreferredSize(new java.awt.Dimension(65, 23));
        bt_changensx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_changensxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_donsxLayout = new javax.swing.GroupLayout(pn_donsx);
        pn_donsx.setLayout(pn_donsxLayout);
        pn_donsxLayout.setHorizontalGroup(
            pn_donsxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_donsxLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bt_addnsx, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(bt_changensx, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addComponent(bt_resetnsx, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(171, 171, 171))
        );
        pn_donsxLayout.setVerticalGroup(
            pn_donsxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_donsxLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_donsxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_resetnsx, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_addnsx, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_changensx, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pn_findnsx.setBackground(new java.awt.Color(204, 255, 204));
        pn_findnsx.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

        jComboBox1.setBackground(new java.awt.Color(255, 255, 204));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã nhà sản xuất", "Tên nhà sản xuất", " " }));

        bt_find.setBackground(new java.awt.Color(204, 204, 204));
        bt_find.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_find.setText("Tìm kiếm");
        bt_find.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_findActionPerformed(evt);
            }
        });

        bt_backnsx.setBackground(new java.awt.Color(204, 204, 204));
        bt_backnsx.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_backnsx.setText("Trở về");
        bt_backnsx.setMaximumSize(new java.awt.Dimension(65, 23));
        bt_backnsx.setMinimumSize(new java.awt.Dimension(65, 23));
        bt_backnsx.setPreferredSize(new java.awt.Dimension(65, 23));
        bt_backnsx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_backnsxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_findnsxLayout = new javax.swing.GroupLayout(pn_findnsx);
        pn_findnsx.setLayout(pn_findnsxLayout);
        pn_findnsxLayout.setHorizontalGroup(
            pn_findnsxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_findnsxLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_findnsxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_findnsxLayout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(bt_backnsx, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(bt_find, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_findnsxLayout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addComponent(txt_find, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pn_findnsxLayout.setVerticalGroup(
            pn_findnsxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_findnsxLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(bt_backnsx, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pn_findnsxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(txt_find))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_find, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tb_tg.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tb_tg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_tgMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_tg);

        javax.swing.GroupLayout panel9Layout = new javax.swing.GroupLayout(panel9);
        panel9.setLayout(panel9Layout);
        panel9Layout.setHorizontalGroup(
            panel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        panel9Layout.setVerticalGroup(
            panel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pn_donsx, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pn_tt1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pn_findnsx, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(pn_tt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(pn_donsx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pn_findnsx, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 966, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bt_findActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_findActionPerformed
        String[] header = {"Mã nhà sản xuất", "Tên", "Số điện thoại", "Địa chỉ"};
        DefaultTableModel modelsearch = new DefaultTableModel(header, 0);
        ArrayList<NhaSanXuatDTO> s;
            s = bus.timkiemNSX(String.valueOf(jComboBox1.getSelectedItem()), txt_find.getText().toLowerCase().trim());
        if (s.size() != 0) {
            for (int i = 0; i < s.size(); i++) {
                Object[] row = {s.get(i).getMaNSX(), s.get(i).getTenNSX(), s.get(i).getSdtNSX(), s.get(i).getDcNSX()
                };
                modelsearch.addRow(row);
            }
            tempsearch.addAll(arr);
            arr.clear();
            arr.addAll(s);

            tb_tg.setModel(modelsearch);
            bt_backnsx.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Không có kết quả phù hợp!");
        }
    }//GEN-LAST:event_bt_findActionPerformed

    private void bt_changensxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_changensxActionPerformed
    if (bt_changensx.getText().toString().equals("Sửa")) {
            txt_tennsx.setEnabled(true);
            txt_sdtnsx.setEnabled(true);
            txt_dcnsx.setEnabled(true);
            bt_changensx.setText("Xác nhận");}
    else {
        if (txt_nsx.getText().length() != 0 
                    && txt_tennsx.getText().length() != 0 && txt_sdtnsx.getText().length() != 0
                    && txt_dcnsx.getText().length() != 0 ) {
                bt_changensx.setText("Sửa");    
            int i = tb_tg.getSelectedRow();
            if(i>=0){
            int k = JOptionPane.showConfirmDialog(null, "Xác nhận sửa", "Xác nhận", JOptionPane.YES_NO_CANCEL_OPTION);
            if (k==1)
            {
                initData();
                return;
            }
            if (k==2)
            {
                bt_changensxActionPerformed(evt);
                return;
            }                
                NhaSanXuatDTO tg = getText();
                int check = bus.suaNSX(tg,i);
                if(check == 1){
                    setModelValue(tg,i);
                    JOptionPane.showMessageDialog(null, "Sửa thành công");}
                }else{
                    JOptionPane.showMessageDialog(null, "Sửa thất bại");}                    
                }else{
                JOptionPane.showMessageDialog(null, "Bạn cần nhập đầy đủ thông tin vào bảng");}
            }
    
    }//GEN-LAST:event_bt_changensxActionPerformed

    private void bt_resetnsxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_resetnsxActionPerformed
            txt_nsx.setText("");
            txt_tennsx.setText("");
            txt_sdtnsx.setText("");
            txt_dcnsx.setText("");
    }//GEN-LAST:event_bt_resetnsxActionPerformed

    private void tb_tgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_tgMouseClicked
        int i = tb_tg.getSelectedRow();
        if(i>=0){
            txt_nsx.setText(tb_tg.getModel().getValueAt(i, 0).toString());
            txt_tennsx.setText(tb_tg.getModel().getValueAt(i, 1).toString());
            txt_sdtnsx.setText(tb_tg.getModel().getValueAt(i, 2).toString());
            txt_dcnsx.setText(tb_tg.getModel().getValueAt(i, 3).toString());            
        }
    }//GEN-LAST:event_tb_tgMouseClicked

    private void bt_backnsxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_backnsxActionPerformed
        arr.clear();
        arr.addAll(tempsearch);
        tempsearch.clear();
        tb_tg.setModel(model);
        bt_backnsx.setVisible(false);
    }//GEN-LAST:event_bt_backnsxActionPerformed

    public void reset(){
        txt_nsx.setText("");
        txt_tennsx.setText("");
        txt_sdtnsx.setText("");
        txt_dcnsx.setText("");
    //    cb_cv.setSelectedItem("");       
    }
    private void bt_addnsxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_addnsxActionPerformed
    	if (bt_addnsx.getText().equals("Thêm")) {
    	    reset(); // Xóa dữ liệu cũ
    	    auto_increaseMaNSX(); // Tạo mã NSX mới
    	    txt_nsx.setEnabled(true);
    	    txt_nsx.setEditable(false);
    	    txt_tennsx.setEnabled(true);
    	    txt_sdtnsx.setEnabled(true);
    	    txt_dcnsx.setEnabled(true);
    	    bt_addnsx.setText("Xác nhận");
    	}

        else {
            if (txt_nsx.getText().length() != 0 
                    && txt_tennsx.getText().length() != 0 && txt_sdtnsx.getText().length() != 0
                    && txt_dcnsx.getText().length() != 0 ) {
                    bt_addnsx.setText("Thêm");
            int k = JOptionPane.showConfirmDialog(null, "Xác nhận thêm", "Xác nhận", JOptionPane.YES_NO_CANCEL_OPTION);
            if (k==1)
            {
                initData();
                return;
            }
            if (k==2)
            {
                bt_addnsxActionPerformed(evt);
                return;
            }                   
                NhaSanXuatDTO s = getText();
                Vector head = setVector(s);
                int check = bus.themNSX(s);
                if(check == 1){
                    model.addRow(head);
                    tb_tg.setModel(model);
                    JOptionPane.showMessageDialog(null, "Thêm thành công");
                }else{
                    JOptionPane.showMessageDialog(null, "Mã đã tồn tại. Thêm thất bại");}                    
                }else{
                JOptionPane.showMessageDialog(null, "Bạn cần nhập đầy đủ thông tin vào bảng");}
            }
    auto_increaseMaNSX();
    }//GEN-LAST:event_bt_addnsxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_addnsx;
    private javax.swing.JButton bt_backnsx;
    private javax.swing.JButton bt_changensx;
    private javax.swing.JButton bt_find;
    private javax.swing.JButton bt_resetnsx;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_dc1;
    private javax.swing.JLabel lb_nsx;
    private javax.swing.JLabel lb_sdt1;
    private javax.swing.JLabel lb_ten1;
    private javax.swing.JPanel panel9;
    private javax.swing.JPanel pn_donsx;
    private javax.swing.JPanel pn_findnsx;
    private javax.swing.JPanel pn_tt1;
    private javax.swing.JTable tb_tg;
    private javax.swing.JTextField txt_dcnsx;
    private javax.swing.JTextField txt_find;
    private javax.swing.JTextField txt_nsx;
    private javax.swing.JTextField txt_sdtnsx;
    private javax.swing.JTextField txt_tennsx;
    // End of variables declaration//GEN-END:variables
}
