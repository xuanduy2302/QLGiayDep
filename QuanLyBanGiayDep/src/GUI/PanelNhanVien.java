
package GUI;

import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import BUS.NhanVienBUS;
import DTO.NhanVienDTO;
import java.awt.Color;

public class PanelNhanVien extends javax.swing.JPanel {
    DefaultTableModel model = new DefaultTableModel();
    NhanVienBUS bus = new NhanVienBUS();
    ArrayList<NhanVienDTO> arr = new ArrayList<NhanVienDTO>();    
    public PanelNhanVien() {
        initComponents();
        initData();
        initEvent();
        load();
        model = (DefaultTableModel) tb_nv.getModel();
    }
    private void initEvent() {
        tb_nv.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        public void valueChanged(ListSelectionEvent event) {
            try {
            NhanVienDTO nv = new NhanVienDTO();
            nv.setMaNV(arr.get(tb_nv.getSelectedRow()).getMaNV());
            nv.setHoNV(arr.get(tb_nv.getSelectedRow()).getHoNV());
            nv.setTenNV(arr.get(tb_nv.getSelectedRow()).getTenNV());
            nv.setDiaChiNV(arr.get(tb_nv.getSelectedRow()).getDiaChiNV());
            nv.setChucVuNV(arr.get(tb_nv.getSelectedRow()).getChucVuNV());
            }catch (Exception e) {
            }
        }
        });
    }    
    private void initData(){
        txt_nv.setEnabled(false);
        txt_tennv.setEnabled(false);
        txt_honv.setEnabled(false);
        txt_dcnv.setEnabled(false);
        cb_cv.setEnabled(false);
    }
    public NhanVienDTO getText(){
        NhanVienDTO nv = new NhanVienDTO();
        nv.setMaNV(txt_nv.getText().trim());
        nv.setHoNV(txt_honv.getText().trim());                    
        nv.setTenNV(txt_tennv.getText().trim());
        nv.setDiaChiNV(txt_dcnv.getText().trim());
        nv.setChucVuNV(cb_cv.getSelectedItem().toString());
        nv.setTrangThai(true);
        return nv;
    }
    private void load(){
        NhanVienBUS bus = new NhanVienBUS();       
        try{
           bus.docNv();
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Lỗi kết nối đến Database.");
           return;
       }
       Vector header = new Vector();
        header.add("Mã nhân viên");
        header.add("Họ nhân viên");
        header.add("Tên nhân viên");
        header.add("Địa chỉ");
        header.add("Chức vụ");
        header.add("Trạng thái");
            model = new DefaultTableModel(header,0){
            public boolean isCellEditable(int row, int column)
                {
                  return false;
                }
       };	
       showOnTable(bus.list);
    }
    private Vector setVector(NhanVienDTO nv){
        Vector row = new Vector();
        row.add(nv.getMaNV());
        row.add(nv.getHoNV());
        row.add(nv.getTenNV());
        row.add(nv.getDiaChiNV());
        row.add(nv.getChucVuNV());
        row.add(nv.getTrangThai());
        return row;
    }    
    private void showOnTable(ArrayList<NhanVienDTO> list){
        model.setRowCount(0);
        for(NhanVienDTO nv:list){
           Vector data = setVector(nv);
           model.addRow(data);
       }
       tb_nv.setModel(model);
    }
    private void setModelValue(NhanVienDTO nv, int i){
        model.setValueAt(nv.getMaNV(),i,0);
        model.setValueAt(nv.getHoNV(),i,1);
        model.setValueAt(nv.getTenNV(),i,2);
        model.setValueAt(nv.getDiaChiNV(),i,3);
        model.setValueAt(nv.getChucVuNV(),i,4);     
        model.setValueAt(nv.getTrangThai(), i ,5);
        tb_nv.setModel(model);            
    }
   public void auto_increaseMaNv(){
        String i = null;
        NhanVienDTO nv= bus.docNv().get(bus.docNv().size()-1);
        String b="00";
        String c="0";
        int a= Integer.parseInt(nv.getMaNV().substring(2,5));
        a++;
        if(a<10){ i="NV"+b+a; }
        if(10<=a && a<=99) {  i ="NV"+c+a; }
        if(a>100){  i="NV"+a; }
        txt_nv.setText(i);
    } 
   public void reset(){
        txt_nv.setText("");
        txt_tennv.setText("");
        txt_honv.setText("");
        txt_dcnv.setText("");
        cb_cv.setSelectedItem("");       
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        pn_ttnv = new javax.swing.JPanel();
        lb_nv = new javax.swing.JLabel();
        txt_nv = new javax.swing.JTextField();
        lb_honv = new javax.swing.JLabel();
        txt_honv = new javax.swing.JTextField();
        lb_dcnv = new javax.swing.JLabel();
        txt_dcnv = new javax.swing.JTextField();
        lb_cvunv = new javax.swing.JLabel();
        lb_tennv = new javax.swing.JLabel();
        txt_tennv = new javax.swing.JTextField();
        cb_cv = new javax.swing.JComboBox<>();
        pn_donv = new javax.swing.JPanel();
        bt_addnv = new javax.swing.JButton();
        bt_resetnv = new javax.swing.JButton();
        bt_change = new javax.swing.JButton();
        bt_change1 = new javax.swing.JButton();
        pn_findnv = new javax.swing.JPanel();
        txt_findnv = new javax.swing.JTextField();
        lb_findnv = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_nv = new javax.swing.JTable(){
            public boolean isCellEditable ( int row, int col)
            {
                return false;
            }
        };

        jPanel2.setBackground(new Color(240, 240, 240));
        jPanel2.setPreferredSize(new java.awt.Dimension(964, 637));

        pn_ttnv.setBackground(new java.awt.Color(255, 255, 255));
        pn_ttnv.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin nhân viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), java.awt.Color.black)); // NOI18N

        lb_nv.setText("Mã nhân viên:");

        lb_honv.setText("Họ nhân viên:");

        lb_dcnv.setText("Địa chỉ:");

        lb_cvunv.setText("Chức vụ:");

        lb_tennv.setText("Tên nhân viên:");

        cb_cv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhân viên bán hàng", "Nhân viên kho" }));
        cb_cv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_cvActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_ttnvLayout = new javax.swing.GroupLayout(pn_ttnv);
        pn_ttnv.setLayout(pn_ttnvLayout);
        pn_ttnvLayout.setHorizontalGroup(
            pn_ttnvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ttnvLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pn_ttnvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_honv)
                    .addComponent(lb_nv))
                .addGap(18, 18, 18)
                .addGroup(pn_ttnvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_nv, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(txt_honv))
                .addGap(18, 18, 18)
                .addGroup(pn_ttnvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_ttnvLayout.createSequentialGroup()
                        .addComponent(lb_tennv)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(pn_ttnvLayout.createSequentialGroup()
                        .addComponent(lb_dcnv)
                        .addGap(44, 44, 44)))
                .addGroup(pn_ttnvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_ttnvLayout.createSequentialGroup()
                        .addComponent(txt_tennv, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(lb_cvunv)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cb_cv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_dcnv))
                .addGap(59, 59, 59))
        );
        pn_ttnvLayout.setVerticalGroup(
            pn_ttnvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ttnvLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_ttnvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_nv)
                    .addComponent(txt_nv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_tennv)
                    .addComponent(txt_tennv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_cvunv)
                    .addComponent(cb_cv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pn_ttnvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_honv)
                    .addComponent(txt_honv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_dcnv)
                    .addComponent(txt_dcnv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pn_donv.setBackground(new Color(255, 255, 255));
        pn_donv.setBorder(javax.swing.BorderFactory.createTitledBorder("Thực hiện"));

        bt_addnv.setBackground(new Color(76, 175, 80));
        bt_addnv.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_addnv.setText("Thêm");
        bt_addnv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_addnvActionPerformed(evt);
            }
        });

        bt_resetnv.setBackground(new Color(66, 165, 245));
        bt_resetnv.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_resetnv.setText("Đặt lại");
        bt_resetnv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_resetnvActionPerformed(evt);
            }
        });

        bt_change.setBackground(new Color(255, 193, 7));
        bt_change.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_change.setText("Sửa");
        bt_change.setMaximumSize(new java.awt.Dimension(65, 23));
        bt_change.setMinimumSize(new java.awt.Dimension(65, 23));
        bt_change.setPreferredSize(new java.awt.Dimension(65, 23));
        bt_change.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_changeActionPerformed(evt);
            }
        });

        bt_change1.setBackground(new Color(244, 67, 54));
        bt_change1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_change1.setText("Kích hoạt/Vô hiệu hóa");
        bt_change1.setMaximumSize(new java.awt.Dimension(65, 23));
        bt_change1.setMinimumSize(new java.awt.Dimension(65, 23));
        bt_change1.setPreferredSize(new java.awt.Dimension(65, 23));
        bt_change1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_change1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_donvLayout = new javax.swing.GroupLayout(pn_donv);
        pn_donv.setLayout(pn_donvLayout);
        pn_donvLayout.setHorizontalGroup(
            pn_donvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_donvLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bt_addnv, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(bt_change, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(bt_change1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(bt_resetnv)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_donvLayout.setVerticalGroup(
            pn_donvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_donvLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_donvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(bt_resetnv, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pn_donvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bt_addnv, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bt_change, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bt_change1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pn_findnv.setBackground(new Color(255, 255, 255));
        pn_findnv.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

        txt_findnv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_findnvActionPerformed(evt);
            }
        });
        txt_findnv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_findnvKeyReleased(evt);
            }
        });

        lb_findnv.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lb_findnv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/find.png"))); // NOI18N
        lb_findnv.setText("Tìm kiếm:");

        javax.swing.GroupLayout pn_findnvLayout = new javax.swing.GroupLayout(pn_findnv);
        pn_findnv.setLayout(pn_findnvLayout);
        pn_findnvLayout.setHorizontalGroup(
            pn_findnvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_findnvLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lb_findnv)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_findnv, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );
        pn_findnvLayout.setVerticalGroup(
            pn_findnvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_findnvLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pn_findnvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_findnv, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_findnv))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tb_nv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tb_nv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_nvMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_nv);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(pn_donv, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(pn_ttnv, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pn_findnv, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pn_findnv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn_ttnv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_donv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                .addGap(218, 218, 218))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 963, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bt_resetnvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_resetnvActionPerformed
        reset();
    }//GEN-LAST:event_bt_resetnvActionPerformed

    private void bt_changeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_changeActionPerformed
//click vào nó getText sửa nó cho sửa r set thành xác nhận
        if (bt_change.getText().equals("Sửa")) {
            txt_tennv.setEnabled(true);
            txt_honv.setEnabled(true);
            txt_dcnv.setEnabled(true);
            cb_cv.setEnabled(true); 
            bt_change.setText("Xác nhận");
    }
    else {
            //xác nhận
        if (txt_nv.getText().length() != 0 && txt_tennv.getText().length() != 0
                && txt_honv.getText().length() != 0 && txt_dcnv.getText().length() != 0) {
                bt_change.setText("Sửa");    
            int i = tb_nv.getSelectedRow();
            if(i>=0){
            int k = JOptionPane.showConfirmDialog(null, "Xác nhận sửa", "Xác nhận", JOptionPane.YES_NO_CANCEL_OPTION);
            if (k==1)
            {
                // no
                initData();
                return;
            }
            if (k==2)
            {
                //cancel
                bt_changeActionPerformed(evt);
                return;
            }        
//            ok
                NhanVienDTO nv = getText();
                int check = bus.suaNv(nv,i);
                if(check == 1){
                   
                    setModelValue(nv,i);
                    JOptionPane.showMessageDialog(null, "Sửa thành công");}
                }else{
                    JOptionPane.showMessageDialog(null, "Sửa thất bại");}                    
                }else{
                JOptionPane.showMessageDialog(null, "Bạn cần nhập đầy đủ thông tin vào bảng");}
            }
    }//GEN-LAST:event_bt_changeActionPerformed

    private void txt_findnvKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_findnvKeyReleased
        String query = txt_findnv.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        tb_nv.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }//GEN-LAST:event_txt_findnvKeyReleased

    private void bt_addnvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_addnvActionPerformed
    	if (bt_addnv.getText().equals("Thêm")) {
    	    reset(); // Đặt lại các trường nhập liệu
    	    auto_increaseMaNv(); // Tạo mã nhân viên mới
    	    txt_nv.setEnabled(true);
    	    txt_nv.setEditable(false);
    	    txt_tennv.setEnabled(true);
    	    txt_honv.setEnabled(true);
    	    txt_dcnv.setEnabled(true);
    	    cb_cv.setEnabled(true);
    	    bt_addnv.setText("Xác nhận");
    	}
    else {
        if (txt_nv.getText().length() != 0 && txt_tennv.getText().length() != 0
            && txt_honv.getText().length() != 0 && txt_dcnv.getText().length() != 0) {
            bt_addnv.setText("Thêm");
            int k = JOptionPane.showConfirmDialog(null, "Xác nhận thêm", "Xác nhận", JOptionPane.YES_NO_CANCEL_OPTION);
            if (k==1)
            {
                initData();
                return;
            }
            if (k==2)
            {
                bt_addnvActionPerformed(evt);
                return;
            }            
            NhanVienDTO nv = getText();
            Vector head = setVector(nv);
            int check = bus.themNv(nv);
            if(check == 1){
               model.addRow(head);
               tb_nv.setModel(model);
               
               JOptionPane.showMessageDialog(null, "Thêm thành công");
            }else{  JOptionPane.showMessageDialog(null, "Mã đã tồn tại. Thêm thất bại");}                    
              }else{  JOptionPane.showMessageDialog(null, "Bạn cần nhập đầy đủ thông tin vào bảng");}
            }
     auto_increaseMaNv();
    }//GEN-LAST:event_bt_addnvActionPerformed

    private void tb_nvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_nvMouseClicked
        int i = tb_nv.getSelectedRow();
        if(i>=0){
            txt_nv.setText(tb_nv.getModel().getValueAt(i, 0).toString());
            txt_tennv.setText(tb_nv.getModel().getValueAt(i, 1).toString());
            txt_honv.setText(tb_nv.getModel().getValueAt(i, 2).toString());
            txt_dcnv.setText(tb_nv.getModel().getValueAt(i, 3).toString());
            cb_cv.setSelectedItem(tb_nv.getModel().getValueAt(i, 4).toString());
        }
    }//GEN-LAST:event_tb_nvMouseClicked

    private void txt_findnvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_findnvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_findnvActionPerformed

    private void cb_cvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_cvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_cvActionPerformed

    private void bt_change1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_change1ActionPerformed
           if (bt_change1.getText().equals("Kích hoạt/Vô hiệu hóa")) {
            bt_change1.setText("Xác nhận");
    }
    else {
            //xác nhận
            int i = tb_nv.getSelectedRow();
            String trangThai = (String) tb_nv.getModel().getValueAt(i, 0);
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
                        bt_change1ActionPerformed(evt);
                        return;
                    }
                    
                    NhanVienDTO nv = bus.doiTrangThai(tb_nv.getModel().getValueAt(i, 0).toString());
                    if(nv != null){
                        setModelValue(nv,i);
                        bt_change1.setText("Kích Hoạt/Vô hiệu hóa");
                        JOptionPane.showMessageDialog(null, trangThai + " thành công");}
                } catch (Exception ex) {
                    Logger.getLogger(PanelNhanVien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, trangThai + " thất bại");                    
            }
        }
    }//GEN-LAST:event_bt_change1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_addnv;
    private javax.swing.JButton bt_change;
    private javax.swing.JButton bt_change1;
    private javax.swing.JButton bt_resetnv;
    private javax.swing.JComboBox<String> cb_cv;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_cvunv;
    private javax.swing.JLabel lb_dcnv;
    private javax.swing.JLabel lb_findnv;
    private javax.swing.JLabel lb_honv;
    private javax.swing.JLabel lb_nv;
    private javax.swing.JLabel lb_tennv;
    private javax.swing.JPanel pn_donv;
    private javax.swing.JPanel pn_findnv;
    private javax.swing.JPanel pn_ttnv;
    private javax.swing.JTable tb_nv;
    private javax.swing.JTextField txt_dcnv;
    private javax.swing.JTextField txt_findnv;
    private javax.swing.JTextField txt_honv;
    private javax.swing.JTextField txt_nv;
    private javax.swing.JTextField txt_tennv;
    // End of variables declaration//GEN-END:variables
}
