
package GUI;

import java.awt.Color;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import BUS.DonXinNghiBUS;
import BUS.LoginBUS;
import BUS.NhanVienBUS;

public class PanelChamCong extends javax.swing.JPanel {
    
        LoginBUS bus = new LoginBUS();
        public String username = Login.username;
        
    public PanelChamCong() {
        initComponents();
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
        jLabel5 = new javax.swing.JLabel();
        jComboBox_month = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        panel_chamCong = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jComboBox_year = new javax.swing.JComboBox<>();

        panelforall.setBackground(new java.awt.Color(238, 241, 245));

        tittle2.setBackground(new java.awt.Color(255, 255, 0));

        lblTitleTC2.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        lblTitleTC2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitleTC2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/user.png"))); // NOI18N
        lblTitleTC2.setText("Chấm Công");

        javax.swing.GroupLayout tittle2Layout = new javax.swing.GroupLayout(tittle2);
        tittle2.setLayout(tittle2Layout);
        tittle2Layout.setHorizontalGroup(
            tittle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tittle2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitleTC2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(382, 382, 382))
        );
        tittle2Layout.setVerticalGroup(
            tittle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tittle2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitleTC2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Tháng");

        jComboBox_month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Năm");

        panel_chamCong.setBackground(new java.awt.Color(255, 255, 255));
        panel_chamCong.setBorder(javax.swing.BorderFactory.createTitledBorder("Chấm công tháng"));
        panel_chamCong.setLayout(new javax.swing.BoxLayout(panel_chamCong, javax.swing.BoxLayout.LINE_AXIS));

        jButton1.setBackground(new java.awt.Color(255, 204, 102));
        jButton1.setText("Kiểm tra chấm công");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox_year.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2023", "2024", "2025" }));

        javax.swing.GroupLayout pn_doLayout = new javax.swing.GroupLayout(pn_do);
        pn_do.setLayout(pn_doLayout);
        pn_doLayout.setHorizontalGroup(
            pn_doLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_doLayout.createSequentialGroup()
                .addGroup(pn_doLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_doLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jComboBox_month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(153, 153, 153)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pn_doLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(panel_chamCong, javax.swing.GroupLayout.PREFERRED_SIZE, 889, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        pn_doLayout.setVerticalGroup(
            pn_doLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_doLayout.createSequentialGroup()
                .addGroup(pn_doLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_doLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(pn_doLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox_month, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox_year, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_doLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_chamCong, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(18, 473, Short.MAX_VALUE)
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
                .addComponent(pn_show1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelforall, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelforall, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String selectedYear = jComboBox_year.getSelectedItem().toString();
        String selectedMonth = jComboBox_month.getSelectedItem().toString();
        
        int month = Integer.parseInt(selectedMonth);
        int year = Integer.parseInt(selectedYear);
        
        YearMonth yearMonth = YearMonth.of(year, month);
        
        // Lấy danh sách các ngày chấm công từ NhanVienBUS
        NhanVienBUS bus = new NhanVienBUS();
        List<LocalDate> attendanceDates = bus.getAttendanceDates(username, year, month);
        
        // Lấy danh sách các ngày nghỉ đã duyệt từ DonXinNghiBUS
        DonXinNghiBUS donBUS = new DonXinNghiBUS();
        ArrayList<String> approvedLeaveDates = donBUS.getApprovedLeaveDates(Login.maNV);
        
        // Tạo panel chứa các checkbox cho mỗi ngày
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        for (int day = 1; day <= yearMonth.lengthOfMonth(); day++) {
            LocalDate date = yearMonth.atDay(day);
            JCheckBox checkBox = new JCheckBox(date.toString());
            
            // Nếu ngày này nằm trong danh sách chấm công, đánh dấu và đặt màu chữ xanh lá
            if (attendanceDates.contains(date)) {
                checkBox.setSelected(true);
                checkBox.setForeground(Color.GREEN);
            }
            
            // Nếu ngày này nằm trong danh sách ngày nghỉ đã duyệt, override với chữ màu đỏ
            if (approvedLeaveDates.contains(date.toString())) {
                checkBox.setSelected(true);
                checkBox.setForeground(Color.RED);
                checkBox.setToolTipText("Ngày nghỉ đã duyệt");
                checkBox.setEnabled(false);
            } else {
                checkBox.setEnabled(false);
            }
            
            panel.add(checkBox);
        }
        
        JScrollPane scrollPane = new JScrollPane(panel);
        panel_chamCong.removeAll();
        panel_chamCong.add(scrollPane);
        panel_chamCong.revalidate();
        panel_chamCong.repaint();
        panel_chamCong.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox_month;
    private javax.swing.JComboBox<String> jComboBox_year;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblTitleTC2;
    private javax.swing.JPanel panel_chamCong;
    private javax.swing.JPanel panelforall;
    private javax.swing.JPanel pn_do;
    private javax.swing.JPanel pn_show1;
    private javax.swing.JPanel tittle2;
    // End of variables declaration//GEN-END:variables
}
