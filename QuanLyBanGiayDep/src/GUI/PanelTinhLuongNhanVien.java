
package GUI;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import BUS.NhanVienBUS;
import DTO.LuongThangDTO;
import DTO.NhanVienDTO;
import java.awt.Color;

public class PanelTinhLuongNhanVien extends javax.swing.JPanel {
    DefaultTableModel model = new DefaultTableModel();
    NhanVienBUS bus = new NhanVienBUS();
    ArrayList<LuongThangDTO> arr = new ArrayList<LuongThangDTO>();  
    List<String> maNhanVienList;
    
    public PanelTinhLuongNhanVien() {
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
                
     
            LuongThangDTO lt = new LuongThangDTO();
            lt.setMaNv(arr.get(tb_nv.getSelectedRow()).getMaNv());
            lt.setChucVu(arr.get(tb_nv.getSelectedRow()).getChucVu());
            lt.setTongLuong(arr.get(tb_nv.getSelectedRow()).getTongLuong());
            lt.setDatetime(arr.get(tb_nv.getSelectedRow()).getDatetime());
            
            }catch (Exception e) {
            }
        }
        });
    }    
    private void initData(){
        txt_manv.setEditable(false);
        txt_tl.setEditable(false);
        txt_chucvu.setEditable(false);
        txt_datetime.setEditable(false);        
              
        maNhanVienList = bus.getMaNhanVien();

        for (String maNv : maNhanVienList) {
            jComboBox1.addItem(maNv);
        }    
    }

    public LuongThangDTO getText() {
        LuongThangDTO lt = new LuongThangDTO();
        lt.setMaNv(txt_manv.getText().trim());
        lt.setChucVu(txt_chucvu.getText().trim());
        try {
            lt.setTongLuong(new BigDecimal(txt_tl.getText().trim()));

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = formatter.parse(txt_datetime.getText().trim());
            lt.setDatetime(date);       
        }
        catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format.");
        } catch (ParseException e) {
            System.out.println("Error: Invalid date format. Please use the format yyyy-MM-dd.");
        }
        
        return lt;
    }
    
    private void load(){
        NhanVienBUS bus = new NhanVienBUS();       
        try{
           bus.getAllLuongThang();
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Lỗi kết nối đến Database.");
           return;
       }
       Vector header = new Vector();
        header.add("Mã nhân viên");
        header.add("Chức vụ");
        header.add("Tông lương");
        header.add("Ngày");
        
            model = new DefaultTableModel(header,0){
            public boolean isCellEditable(int row, int column)
                {
                  return false;
        }
       };	
       showOnTable(bus.luongThangList);
    }
    private Vector setVector(LuongThangDTO lt){
        Vector row = new Vector();
        row.add(lt.getMaNv());
        row.add(lt.getChucVu());
        row.add(lt.getTongLuong());
        row.add(lt.getDatetime());

        return row;
    }    
    private void showOnTable(ArrayList<LuongThangDTO> list){
        model.setRowCount(0);
        for(LuongThangDTO lt:list){
           Vector data = setVector(lt);
           model.addRow(data);
       }
       tb_nv.setModel(model);
    }
    
    private void setModelValue(LuongThangDTO lt, int i){
        model.setValueAt(lt.getMaNv(),i,0);
        model.setValueAt(lt.getChucVu(),i,1);
        model.setValueAt(lt.getTongLuong(),i,2);
        model.setValueAt(lt.getDatetime(),i,3);

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
        txt_manv.setText(i);
    } 
   public void reset(){
        txt_manv.setText("");
        txt_tl.setText("");
        txt_chucvu.setText("");
        txt_datetime.setText("");
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        pn_ttnv = new javax.swing.JPanel();
        lb_nv = new javax.swing.JLabel();
        txt_manv = new javax.swing.JTextField();
        lb_honv = new javax.swing.JLabel();
        txt_chucvu = new javax.swing.JTextField();
        lb_datetime = new javax.swing.JLabel();
        txt_datetime = new javax.swing.JTextField();
        lb_tennv = new javax.swing.JLabel();
        txt_tl = new javax.swing.JTextField();
        pn_donv = new javax.swing.JPanel();
        bt_addnv = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        bt_tinhLuong = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
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

        pn_ttnv.setBackground(new java.awt.Color(255, 255, 255));
        pn_ttnv.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin nhân viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), java.awt.Color.black)); // NOI18N

        lb_nv.setText("Mã nhân viên:");

        lb_honv.setText("Chức vụ");

        lb_datetime.setText("Datetime");

        lb_tennv.setText("Tỗng lương");

        javax.swing.GroupLayout pn_ttnvLayout = new javax.swing.GroupLayout(pn_ttnv);
        pn_ttnv.setLayout(pn_ttnvLayout);
        pn_ttnvLayout.setHorizontalGroup(
            pn_ttnvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ttnvLayout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(pn_ttnvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_honv)
                    .addComponent(lb_nv))
                .addGap(18, 18, 18)
                .addGroup(pn_ttnvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_manv, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(txt_chucvu))
                .addGap(18, 18, 18)
                .addGroup(pn_ttnvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_ttnvLayout.createSequentialGroup()
                        .addComponent(lb_tennv)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_tl, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pn_ttnvLayout.createSequentialGroup()
                        .addComponent(lb_datetime)
                        .addGap(19, 19, 19)
                        .addComponent(txt_datetime, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(153, 153, 153))
        );
        pn_ttnvLayout.setVerticalGroup(
            pn_ttnvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ttnvLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_ttnvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_nv)
                    .addComponent(txt_manv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_tennv)
                    .addComponent(txt_tl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pn_ttnvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_honv)
                    .addComponent(txt_chucvu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_datetime)
                    .addComponent(txt_datetime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pn_donv.setBackground(new Color(255, 255, 255));
        pn_donv.setBorder(javax.swing.BorderFactory.createTitledBorder("Thực hiện"));

        bt_addnv.setBackground(new Color(255, 204, 102));
        bt_addnv.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_addnv.setText("Tính Lương Tất Cả Nhân Viên");
        bt_addnv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_addnvActionPerformed(evt);
            }
        });

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        bt_tinhLuong.setBackground(new Color(255, 204, 102));
        bt_tinhLuong.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_tinhLuong.setText("Tính Lương");
        bt_tinhLuong.setMaximumSize(new java.awt.Dimension(65, 23));
        bt_tinhLuong.setMinimumSize(new java.awt.Dimension(65, 23));
        bt_tinhLuong.setPreferredSize(new java.awt.Dimension(65, 23));
        bt_tinhLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_tinhLuongActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Tính Lương Cụ Thễ");

        javax.swing.GroupLayout pn_donvLayout = new javax.swing.GroupLayout(pn_donv);
        pn_donv.setLayout(pn_donvLayout);
        pn_donvLayout.setHorizontalGroup(
            pn_donvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_donvLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(bt_addnv, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(246, 246, 246)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(bt_tinhLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        pn_donvLayout.setVerticalGroup(
            pn_donvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_donvLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_donvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_addnv, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(bt_tinhLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13))
        );

        pn_findnv.setBackground(new Color(240, 240, 240));
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
        lb_findnv.setText("Tìm kiếm:");

        javax.swing.GroupLayout pn_findnvLayout = new javax.swing.GroupLayout(pn_findnv);
        pn_findnv.setLayout(pn_findnvLayout);
        pn_findnvLayout.setHorizontalGroup(
            pn_findnvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_findnvLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(pn_donv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(pn_ttnv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pn_findnv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                .addGap(218, 218, 218))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_findnvKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_findnvKeyReleased
        String query = txt_findnv.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        tb_nv.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }//GEN-LAST:event_txt_findnvKeyReleased

    private void bt_addnvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_addnvActionPerformed
        maNhanVienList = bus.getMaNhanVien();

        for (String maNv : maNhanVienList) {        
            LocalDate today = LocalDate.now(); // Get the current date
            String currentMonth = Integer.toString(today.getMonthValue()); // Get the month as an integer (1-12)
            String currentYear = Integer.toString(today.getYear()); // Get the year

            String luongThang = bus.tinhLuongThang(maNv, currentMonth, currentYear);

            String str = luongThang;
            str = str.replace(".", "");
            double num = Double.parseDouble(str);

            NhanVienDTO nv = bus.getNhanVienById(maNv);

            bus.insertOrUpdateLuongThang(maNv, num, nv.getChucVuNV(), today.toString());

            showOnTable((ArrayList<LuongThangDTO>) bus.getAllLuongThang());
           // System.out.println("selectedID: " + maNv + "- month: " + currentMonth + "- year :" + currentYear + "Lương: " + luongThang);
            }       
    }//GEN-LAST:event_bt_addnvActionPerformed

    private void tb_nvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_nvMouseClicked
        int i = tb_nv.getSelectedRow();
        if(i>=0){
            txt_manv.setText(tb_nv.getModel().getValueAt(i, 0).toString());
            txt_tl.setText(tb_nv.getModel().getValueAt(i, 1).toString());
            txt_chucvu.setText(tb_nv.getModel().getValueAt(i, 2).toString());
            txt_datetime.setText(tb_nv.getModel().getValueAt(i, 3).toString());
        }
    }//GEN-LAST:event_tb_nvMouseClicked

    private void txt_findnvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_findnvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_findnvActionPerformed

    private void bt_tinhLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_tinhLuongActionPerformed
        String idNhanVien = (String) jComboBox1.getSelectedItem();
        
        LocalDate today = LocalDate.now(); // Get the current date
        String currentMonth = Integer.toString(today.getMonthValue()); // Get the month as an integer (1-12)
        String currentYear = Integer.toString(today.getYear()); // Get the year
        
        String luongThang = bus.tinhLuongThang(idNhanVien, currentMonth, currentYear);
        
        String str = luongThang;
        str = str.replace(".", "");
        double num = Double.parseDouble(str);

        NhanVienDTO nv = bus.getNhanVienById(idNhanVien);
        
        bus.insertOrUpdateLuongThang(idNhanVien, num, nv.getChucVuNV(), today.toString());
        
        showOnTable((ArrayList<LuongThangDTO>) bus.getAllLuongThang());
        System.out.println("selectedID: " + idNhanVien + "- month: " + currentMonth + "- year :" + currentYear + "Lương: " + luongThang);
        
    }//GEN-LAST:event_bt_tinhLuongActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_addnv;
    private javax.swing.JButton bt_tinhLuong;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_datetime;
    private javax.swing.JLabel lb_findnv;
    private javax.swing.JLabel lb_honv;
    private javax.swing.JLabel lb_nv;
    private javax.swing.JLabel lb_tennv;
    private javax.swing.JPanel pn_donv;
    private javax.swing.JPanel pn_findnv;
    private javax.swing.JPanel pn_ttnv;
    private javax.swing.JTable tb_nv;
    private javax.swing.JTextField txt_chucvu;
    private javax.swing.JTextField txt_datetime;
    private javax.swing.JTextField txt_findnv;
    private javax.swing.JTextField txt_manv;
    private javax.swing.JTextField txt_tl;
    // End of variables declaration//GEN-END:variables
}
