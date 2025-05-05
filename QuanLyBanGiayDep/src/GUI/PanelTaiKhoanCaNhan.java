
package GUI;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JOptionPane;

import BUS.LoginBUS;
import BUS.NhanVienBUS;
import DTO.NhanVienDTO;
import java.awt.Font;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;

public class PanelTaiKhoanCaNhan extends javax.swing.JPanel {
    
        LoginBUS bus = new LoginBUS();
        NhanVienBUS nvbus = new NhanVienBUS();
        String username = Login.username;
        NhanVienDTO nv = new NhanVienDTO();
        int btnState = 0;
        
    public PanelTaiKhoanCaNhan() {
        initComponents();
        getNhanVienById();
        txt_id.setText(nv.getMaNV());
        txt_ho.setText(nv.getHoNV());
        txt_ten.setText(nv.getTenNV());
        txt_diachi.setText(nv.getDiaChiNV());
    }
    
    private void getNhanVienById() {
        nv = nvbus.getNhanVienById(username);
    }
    
    
    public boolean kiemtratrung(String pass1, String pass2)
    {
        return pass1.equals(pass2);
    }
    public boolean kiemtramkc(String username, String pass) throws Exception
    {
        return bus.kiemTraMK(username, pass);
    }    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelforall = new javax.swing.JPanel();
        tittle2 = new javax.swing.JPanel();
        lblTitleTC2 = new javax.swing.JLabel();
        pn_show1 = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        pn_do = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_xn = new javax.swing.JButton();
        btn_xn.setBackground(new Color(76, 175, 80));
        btn_huy = new javax.swing.JButton();
        btn_huy.setBackground(new Color(244, 67, 54));
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        txt_diachi = new javax.swing.JTextField();
        txt_ho = new javax.swing.JTextField();
        txt_ten = new javax.swing.JTextField();

        panelforall.setBackground(new java.awt.Color(238, 241, 245));

        tittle2.setBackground(new Color(0, 128, 192));

        lblTitleTC2.setFont(new Font("Tahoma", Font.BOLD, 28)); // NOI18N
        lblTitleTC2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitleTC2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/user.png"))); // NOI18N
        lblTitleTC2.setText("Tài khoản Của Tôi");

        javax.swing.GroupLayout tittle2Layout = new javax.swing.GroupLayout(tittle2);
        tittle2Layout.setHorizontalGroup(
        	tittle2Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(tittle2Layout.createSequentialGroup()
        			.addGap(328)
        			.addComponent(lblTitleTC2, GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
        			.addGap(51))
        );
        tittle2Layout.setVerticalGroup(
        	tittle2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(tittle2Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblTitleTC2, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(19, Short.MAX_VALUE))
        );
        tittle2.setLayout(tittle2Layout);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 19)); // NOI18N
        jLabel2.setText("Tài Khoản");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 19)); // NOI18N
        jLabel4.setText("Họ");

        btn_xn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_xn.setText("Cập Nhật");
        btn_xn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_xnMouseClicked(evt);
            }
        });
        btn_xn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xnActionPerformed(evt);
            }
        });

        btn_huy.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_huy.setText("Hủy");
        btn_huy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_huyMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 19)); // NOI18N
        jLabel5.setText("Địa Chỉ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 19)); // NOI18N
        jLabel6.setText("Tên");

        txt_id.setEditable(false);
        txt_id.setBackground(new java.awt.Color(204, 204, 204));

        txt_diachi.setEditable(false);
        txt_diachi.setBackground(new java.awt.Color(204, 204, 204));

        txt_ho.setEditable(false);
        txt_ho.setBackground(new java.awt.Color(204, 204, 204));

        txt_ten.setEditable(false);
        txt_ten.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout pn_doLayout = new javax.swing.GroupLayout(pn_do);
        pn_do.setLayout(pn_doLayout);
        pn_doLayout.setHorizontalGroup(
            pn_doLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_doLayout.createSequentialGroup()
                .addGroup(pn_doLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_doLayout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(pn_doLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addGroup(pn_doLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_diachi, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_ho, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pn_doLayout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(btn_xn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(241, 241, 241)
                        .addComponent(btn_huy, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(283, Short.MAX_VALUE))
        );
        pn_doLayout.setVerticalGroup(
            pn_doLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_doLayout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addGroup(pn_doLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(pn_doLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ho, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(pn_doLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(pn_doLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_diachi, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addGroup(pn_doLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_xn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_huy, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout pn_show1Layout = new javax.swing.GroupLayout(pn_show1);
        pn_show1.setLayout(pn_show1Layout);
        pn_show1Layout.setHorizontalGroup(
            pn_show1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(pn_do, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pn_show1Layout.setVerticalGroup(
            pn_show1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_show1Layout.createSequentialGroup()
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_do, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105))
        );

        javax.swing.GroupLayout panelforallLayout = new javax.swing.GroupLayout(panelforall);
        panelforall.setLayout(panelforallLayout);
        panelforallLayout.setHorizontalGroup(
            panelforallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_show1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tittle2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelforallLayout.setVerticalGroup(
            panelforallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelforallLayout.createSequentialGroup()
                .addComponent(tittle2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_show1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelforall, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelforall, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_huyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_huyMouseClicked
        int i = JOptionPane.showConfirmDialog(null, "Xác nhận", "Xác nhận thoát?", JOptionPane.YES_NO_OPTION);
        if (i==0) new Menu().setVisible(true);
    }//GEN-LAST:event_btn_huyMouseClicked

    private void btn_xnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xnActionPerformed
            switch (btnState) {
                case 0:
                    // First press: make the fields editable
                    txt_ten.setEditable(true);
                    txt_ten.setBackground(Color.WHITE);
                    txt_diachi.setEditable(true);
                    txt_diachi.setBackground(Color.WHITE);
                    txt_ho.setEditable(true);
                    txt_ho.setBackground(Color.WHITE);
                    // Increment the state
                    btnState++; break;
                case 1:
                    // Second press: show a confirmation dialog
                    int confirm = JOptionPane.showConfirmDialog(null, "Xác nhận cập nhật thông tin?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        getNhanVienById();
                    nv.setTenNV(txt_ten.getText());
                    nv.setDiaChiNV(txt_diachi.getText());
                    nv.setHoNV(txt_ho.getText());
                    int result = nvbus.suaNv2(nv);
                    if (result == 1) {
                        JOptionPane.showMessageDialog(null, "Cập nhật thành công");
                    } else {
                        JOptionPane.showMessageDialog(null, "Cập nhật thất bại");
                    }          
                    
                    panelforall.removeAll();
                    panelforall.setLayout(new BorderLayout());
                    panelforall.add(new PanelTaiKhoanCaNhan());
                    panelforall.validate();
                    panelforall.repaint();
                    // Reset the state
                    btnState = 0;
                    break;
                    }
                default:
                    break;
            }
    }//GEN-LAST:event_btn_xnActionPerformed

    private void btn_xnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_xnMouseClicked
        //        if (!txt_id.equals("") && !txt_password.equals("") && !txt_diachi.equals(""))
        //        {
            //            try {
                //                if (kiemtramkc(username, txt_id.getText()))
                //                {
                    //                    if (kiemtratrung(txt_password.getText(), txt_diachi.getText()))
                    //                    {
                        //                        bus.doiMK(username, txt_password.getText());
                        //                        panelforall.removeAll();
                        //                        panelforall.setLayout(new BorderLayout());
                        //                        panelforall.add(new PanelTrangChu());
                        //                        panelforall.validate();
                        //                        panelforall.repaint();
                        //                        JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công");
                        //                    } else JOptionPane.showMessageDialog(null, "Mật khẩu mới và nhập lại chưa trùng khớp");
                    //                } else JOptionPane.showMessageDialog(null, "Nhập sai mật khẩu cũ");
                //            } catch (Exception ex) {
                //                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                //            }
            //        } else JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
    }//GEN-LAST:event_btn_xnMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_huy;
    private javax.swing.JButton btn_xn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblTitleTC2;
    private javax.swing.JPanel panelforall;
    private javax.swing.JPanel pn_do;
    private javax.swing.JPanel pn_show1;
    private javax.swing.JPanel tittle2;
    private javax.swing.JTextField txt_diachi;
    private javax.swing.JTextField txt_ho;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_ten;
    // End of variables declaration//GEN-END:variables
}
