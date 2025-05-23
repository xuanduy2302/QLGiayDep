
package GUI;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import BUS.LoaiSanPhamBUS;
import DTO.LoaiSanPhamDTO;
import java.awt.Color;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;

public class PanelLoaiSanPham extends javax.swing.JPanel {
    public static String maloai;
    DefaultTableModel model = new DefaultTableModel();
    ArrayList<LoaiSanPhamDTO> arr = new ArrayList<LoaiSanPhamDTO>();
    ArrayList<LoaiSanPhamDTO> tempsearch = new ArrayList<LoaiSanPhamDTO>();
    LoaiSanPhamBUS bus = new LoaiSanPhamBUS();
    LoaiSanPhamDTO tl = new LoaiSanPhamDTO();
    public PanelLoaiSanPham() {
    	this.setPreferredSize(new java.awt.Dimension(960, 740));
        initComponents();
        initData();
        initEvent();
        model = (DefaultTableModel) tb_theloai.getModel();
        load();        
    }
    private void initEvent() {
        tb_theloai.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        public void valueChanged(ListSelectionEvent event) {
            try {
            tl.setMaLoai(arr.get(tb_theloai.getSelectedRow()).getMaLoai());
            tl.setTenLoai(arr.get(tb_theloai.getSelectedRow()).getTenLoai());          
            }catch (Exception e) {
            }
           
        }
        });
    }    
    private void initData(){
        txt_tl.setEnabled(false);
        txt_tl.setEnabled(false);
        bt_backl.setVisible(false);        
    }
    public LoaiSanPhamDTO getText(){
        LoaiSanPhamDTO tl = new LoaiSanPhamDTO();
        tl.setMaLoai(txt_ml.getText().trim());
        tl.setTenLoai(txt_tl.getText().trim());
        return tl;
    }
    private void load(){
       try{
           bus.docTl();
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Lỗi kết nối đến Database.");
           return;
       }
       Vector header = new Vector();
        header.add("Mã loại sản phẩm");
        header.add("Tên loại sản phẩm");
       model = new DefaultTableModel(header,0){
            public boolean isCellEditable(int row, int column)
                {
                  return false;
                }
       };	
       showOnTable(bus.list);
    }
    private Vector setVector(LoaiSanPhamDTO tl){
            Vector head = new Vector();
            head.add(tl.getMaLoai());
            head.add(tl.getTenLoai());
            return head;
    }    
    private void showOnTable(ArrayList<LoaiSanPhamDTO> list){
        model.setRowCount(0);
        for(LoaiSanPhamDTO tl:list){
           Vector data = setVector(tl);
           model.addRow(data);
       }
       tb_theloai.setModel(model);
    }
    private void setModelValue(LoaiSanPhamDTO tl, int i){
        model.setValueAt(tl.getMaLoai(),i,0);
        model.setValueAt(tl.getTenLoai(),i,1);  
        tb_theloai.setModel(model);            
    }
    public void auto_increaseMaLoai(){
        String i = null;
        int a;
        if(bus.docTl().size()<=0)
        {
            a=0;
        }else {
        LoaiSanPhamDTO tl= bus.docTl().get(bus.docTl().size()-1);
        a= Integer.parseInt(tl.getMaLoai().substring(4,6));
        }
        a++;
        i="LOAI"+a;
        txt_ml.setText(i);
    }   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel9 = new javax.swing.JPanel();
        pn_ttl = new javax.swing.JPanel();
        lb_ml = new javax.swing.JLabel();
        lb_ml.setFont(new Font("Tahoma", Font.PLAIN, 13));
        txt_ml = new javax.swing.JTextField();
        txt_ml.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lb_tl = new javax.swing.JLabel();
        lb_tl.setFont(new Font("Tahoma", Font.PLAIN, 13));
        txt_tl = new javax.swing.JTextField();
        txt_tl.setFont(new Font("Tahoma", Font.PLAIN, 13));
        pn_dol = new javax.swing.JPanel();
        bt_addl = new javax.swing.JButton();
        bt_resetl = new javax.swing.JButton();
        bt_changel = new javax.swing.JButton();
        bt_backl = new javax.swing.JButton();
        pn_findl = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        txt_findl = new javax.swing.JTextField();
        bt_findl = new javax.swing.JButton();
        panel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_theloai = new javax.swing.JTable(){
            public boolean isCellEditable ( int row, int col)
            {
                return false;
            }
        };

        jPanel9.setBackground(new Color(240, 240, 240));

        pn_ttl.setBackground(new java.awt.Color(255, 255, 255));
        pn_ttl.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thể loại sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12),  java.awt.Color.BLACK)); // NOI18N

        lb_ml.setText("Mã loại:");

        lb_tl.setText("Tên loại:");

        txt_tl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tlActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_ttlLayout = new javax.swing.GroupLayout(pn_ttl);
        pn_ttlLayout.setHorizontalGroup(
        	pn_ttlLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(pn_ttlLayout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(pn_ttlLayout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(lb_ml, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lb_tl, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(pn_ttlLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(txt_ml, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
        				.addComponent(txt_tl, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE))
        			.addContainerGap())
        );
        pn_ttlLayout.setVerticalGroup(
        	pn_ttlLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(pn_ttlLayout.createSequentialGroup()
        			.addGap(30)
        			.addGroup(pn_ttlLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txt_ml, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lb_ml, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
        			.addGap(36)
        			.addGroup(pn_ttlLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txt_tl, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lb_tl, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(70, Short.MAX_VALUE))
        );
        pn_ttl.setLayout(pn_ttlLayout);

        pn_dol.setBackground(new Color(255, 255, 255));
        pn_dol.setBorder(javax.swing.BorderFactory.createTitledBorder("Thực hiện"));

        bt_addl.setBackground(new Color(76, 175, 89));
        bt_addl.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_addl.setText("Thêm");
        bt_addl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_addlActionPerformed(evt);
            }
        });

        bt_resetl.setBackground(new Color(66, 165, 245));
        bt_resetl.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_resetl.setText("Đặt lại");
        bt_resetl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_resetlActionPerformed(evt);
            }
        });

        bt_changel.setBackground(new Color(255, 193, 7));
        bt_changel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_changel.setText("Sửa");
        bt_changel.setMaximumSize(new java.awt.Dimension(65, 23));
        bt_changel.setMinimumSize(new java.awt.Dimension(65, 23));
        bt_changel.setPreferredSize(new java.awt.Dimension(65, 23));
        bt_changel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_changelActionPerformed(evt);
            }
        });

        bt_backl.setBackground(new java.awt.Color(204, 204, 204));
        bt_backl.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_backl.setText("Trở về");
        bt_backl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_backlActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_dolLayout = new javax.swing.GroupLayout(pn_dol);
        pn_dolLayout.setHorizontalGroup(
        	pn_dolLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(pn_dolLayout.createSequentialGroup()
        			.addGroup(pn_dolLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(pn_dolLayout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(bt_addl, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(bt_changel, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
        					.addComponent(bt_resetl, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
        				.addGroup(pn_dolLayout.createSequentialGroup()
        					.addGap(40)
        					.addComponent(bt_backl, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap())
        );
        pn_dolLayout.setVerticalGroup(
        	pn_dolLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, pn_dolLayout.createSequentialGroup()
        			.addGap(42)
        			.addGroup(pn_dolLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(bt_addl, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
        				.addComponent(bt_resetl, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
        				.addComponent(bt_changel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
        			.addGap(36)
        			.addComponent(bt_backl, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(42, Short.MAX_VALUE))
        );
        pn_dol.setLayout(pn_dolLayout);

        pn_findl.setBackground(new Color(255, 255, 255));
        pn_findl.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

        jComboBox1.setBackground(new Color(240, 240, 240));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã loại", "Tên loại" }));

        bt_findl.setBackground(new java.awt.Color(204, 204, 204));
        bt_findl.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_findl.setText("Tìm kiếm");
        bt_findl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_findlActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_findlLayout = new javax.swing.GroupLayout(pn_findl);
        pn_findlLayout.setHorizontalGroup(
        	pn_findlLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(pn_findlLayout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(pn_findlLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(bt_findl, GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
        				.addGroup(Alignment.TRAILING, pn_findlLayout.createSequentialGroup()
        					.addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(txt_findl, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)))
        			.addContainerGap())
        );
        pn_findlLayout.setVerticalGroup(
        	pn_findlLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, pn_findlLayout.createSequentialGroup()
        			.addGap(30)
        			.addGroup(pn_findlLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
        				.addComponent(txt_findl, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
        			.addComponent(bt_findl, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
        			.addGap(31))
        );
        pn_findl.setLayout(pn_findlLayout);

        tb_theloai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tb_theloai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_theloaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_theloai);

        javax.swing.GroupLayout panel7Layout = new javax.swing.GroupLayout(panel7);
        panel7Layout.setHorizontalGroup(
        	panel7Layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
        );
        panel7Layout.setVerticalGroup(
        	panel7Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(panel7Layout.createSequentialGroup()
        			.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE)
        			.addContainerGap())
        );
        panel7.setLayout(panel7Layout);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9Layout.setHorizontalGroup(
        	jPanel9Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel9Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel9Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(pn_findl, GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
        				.addComponent(pn_dol, GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
        				.addComponent(pn_ttl, GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(panel7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
        	jPanel9Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel9Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel9Layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(panel7, GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
        				.addGroup(jPanel9Layout.createSequentialGroup()
        					.addComponent(pn_ttl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(pn_findl, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(pn_dol, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap())
        );
        jPanel9.setLayout(jPanel9Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bt_findlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_findlActionPerformed
        String[] header = {"Mã loại sản phẩm", "Tên loại sản phẩm"};
        DefaultTableModel modelsearch = new DefaultTableModel(header, 0);
        ArrayList<LoaiSanPhamDTO> tl;
            tl = bus.timkiemTl(String.valueOf(jComboBox1.getSelectedItem()), txt_findl.getText().toLowerCase().trim());
        if (tl.size() != 0) {
            for (int i = 0; i < tl.size(); i++) {
                Object[] row = {tl.get(i).getMaLoai(), tl.get(i).getTenLoai()};
                modelsearch.addRow(row);
            }
            tempsearch.addAll(arr);
            arr.clear();
            arr.addAll(tl);

            tb_theloai.setModel(modelsearch);
            bt_backl.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Không có kết quả phù hợp!");
        }
    }//GEN-LAST:event_bt_findlActionPerformed

    private void tb_theloaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_theloaiMouseClicked
        int i = tb_theloai.getSelectedRow();
        if(i>=0){
            txt_ml.setText(tb_theloai.getModel().getValueAt(i, 0).toString());
            txt_tl.setText(tb_theloai.getModel().getValueAt(i, 1).toString());          
        }
    }//GEN-LAST:event_tb_theloaiMouseClicked

    private void txt_tlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tlActionPerformed

    private void bt_backlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_backlActionPerformed
        arr.clear();
        arr.addAll(tempsearch);
        tempsearch.clear();
        tb_theloai.setModel(model);
        bt_backl.setVisible(false);
    }//GEN-LAST:event_bt_backlActionPerformed

    private void bt_changelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_changelActionPerformed
        if (bt_changel.getText().toString().equals("Sửa")) {
            txt_tl.setEnabled(true);
            bt_changel.setText("Xác nhận");}
        else {
            if (txt_ml.getText().length() != 0 && txt_tl.getText().length() != 0) {
                bt_changel.setText("Sửa");
                int i = tb_theloai.getSelectedRow();
                if(i>=0){
                    int k = JOptionPane.showConfirmDialog(null, "Xác nhận sửa", "Xác nhận", JOptionPane.YES_NO_CANCEL_OPTION);
                    if (k==1)
                    {
                        initData();
                        return;
                    }
                    if (k==2)
                    {
                        bt_changelActionPerformed(evt);
                        return;
                    }
                    LoaiSanPhamDTO tl = getText();
                    int check = bus.suaTl(tl,i);
                    if(check == 1){
                        setModelValue(tl,i);
                        JOptionPane.showMessageDialog(null, "Sửa thành công");}
                }else{
                    JOptionPane.showMessageDialog(null, "Sửa thất bại");}
            }else{
                JOptionPane.showMessageDialog(null, "Bạn cần nhập đầy đủ thông tin vào bảng");}
        }
    }//GEN-LAST:event_bt_changelActionPerformed

    private void bt_resetlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_resetlActionPerformed
        txt_ml.setText("");
        txt_tl.setText("");
    }//GEN-LAST:event_bt_resetlActionPerformed

    private void bt_addlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_addlActionPerformed
        if (bt_addl.getText().toString().equals("Thêm")) {
            txt_ml.setEnabled(true);
            txt_ml.setEditable(false);
            txt_tl.setEnabled(true);
            bt_addl.setText("Xác nhận");}
        else {
            if (txt_ml.getText().length() != 0 && txt_tl.getText().length() != 0 ) {
                bt_addl.setText("Thêm");
                int k = JOptionPane.showConfirmDialog(null, "Xác nhận thêm", "Xác nhận", JOptionPane.YES_NO_CANCEL_OPTION);
                if (k==1)
                {
                    initData();
                    return;
                }
                if (k==2)
                {
                    bt_addlActionPerformed(evt);
                    return;
                }
                LoaiSanPhamDTO lsp = getText();
                Vector head = setVector(lsp);
                int check = bus.themTl(lsp);
                if(check == 1){
                    model.addRow(head);
                    tb_theloai.setModel(model);
                    JOptionPane.showMessageDialog(null, "Thêm thành công");
                }else{
                    JOptionPane.showMessageDialog(null, "Mã đã tồn tại. Thêm thất bại");}
            }else{
                JOptionPane.showMessageDialog(null, "Bạn cần nhập đầy đủ thông tin vào bảng");}
        }
        auto_increaseMaLoai();
    }//GEN-LAST:event_bt_addlActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_addl;
    private javax.swing.JButton bt_backl;
    private javax.swing.JButton bt_changel;
    private javax.swing.JButton bt_findl;
    private javax.swing.JButton bt_resetl;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_ml;
    private javax.swing.JLabel lb_tl;
    private javax.swing.JPanel panel7;
    private javax.swing.JPanel pn_dol;
    private javax.swing.JPanel pn_findl;
    private javax.swing.JPanel pn_ttl;
    private javax.swing.JTable tb_theloai;
    private javax.swing.JTextField txt_findl;
    private javax.swing.JTextField txt_ml;
    private javax.swing.JTextField txt_tl;
    // End of variables declaration//GEN-END:variables
}
