
package GUI;

import static com.itextpdf.io.font.PdfEncodings.IDENTITY_H;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.property.TextAlignment;

import BUS.NhanVienBUS;
import DTO.ChuyenChucDTO;
import DTO.LuongThangDTO;
import DTO.NhanVienDTO;
import untils.CurrencyUtil;
import untils.XemTinhLuongUtil;
import java.awt.Color;

public class PanelNhanVienXemLuong extends javax.swing.JPanel {
    DefaultTableModel model = new DefaultTableModel();
    NhanVienBUS bus = new NhanVienBUS();
    ArrayList<LuongThangDTO> arr = new ArrayList<>();  
    List<String> maNhanVienList;
    
    public PanelNhanVienXemLuong() {
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
            //lt.setMaNv(arr.get(tb_nv.getSelectedRow()).getMaNv());
            lt.setChucVu(arr.get(tb_nv.getSelectedRow()).getChucVu());
            lt.setTongLuong(arr.get(tb_nv.getSelectedRow()).getTongLuong());
            lt.setDatetime(arr.get(tb_nv.getSelectedRow()).getDatetime());
            
            }catch (Exception e) {
            }
        }
        });
    }    
    private void initData(){
        //txt_manv.setEditable(false);
        txt_tl.setEditable(false);
        txt_chucvu.setEditable(false);
        txt_datetime.setEditable(false);        
              
        maNhanVienList = bus.getMaNhanVien();

//        for (String maNv : maNhanVienList) {
//            jComboBox1.addItem(maNv);
//        }    
    }

    public LuongThangDTO getText() {
        LuongThangDTO lt = new LuongThangDTO();
        
        System.out.println("");
        lt.setMaNv(Login.username);
        lt.setChucVu(txt_chucvu.getText().trim());
        try {
            String dateStr = txt_datetime.getText().trim();
            if (dateStr.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập ngày hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = formatter.parse(dateStr);
            lt.setDatetime(date);   
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Lỗi: Định dạng ngày không hợp lệ! Vui lòng nhập theo yyyy-MM-dd.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        
        return lt;
    }
    
    private void load(){
        NhanVienBUS bus = new NhanVienBUS();       
        try{
            bus.getLuongThangByID(Login.username);
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Lỗi kết nối đến Database.");
           return;
       }
       Vector header = new Vector();
        //header.add("Mã nhân viên");
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
        //row.add(lt.getMaNv());
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
        //model.setValueAt(lt.getMaNv(),i,0);
        model.setValueAt(lt.getChucVu(),i,0);
        model.setValueAt(lt.getTongLuong(),i,1);
        model.setValueAt(lt.getDatetime(),i,2);

        tb_nv.setModel(model);            
    }

   public void reset(){
        //txt_manv.setText("");
        txt_tl.setText("");
        txt_chucvu.setText("");
        txt_datetime.setText("");
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        pn_ttnv = new javax.swing.JPanel();
        lb_chucvu = new javax.swing.JLabel();
        txt_chucvu = new javax.swing.JTextField();
        lb_datetime = new javax.swing.JLabel();
        txt_datetime = new javax.swing.JTextField();
        lb_tennv = new javax.swing.JLabel();
        txt_tl = new javax.swing.JTextField();
        pn_donv = new javax.swing.JPanel();
        bt_inLuongNam = new javax.swing.JButton();
        bt_inLuongThang = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        bt_inLuongNam2 = new javax.swing.JButton();
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

        lb_chucvu.setText("Chức vụ");

        lb_datetime.setText("Datetime");

        lb_tennv.setText("Tỗng lương");

        javax.swing.GroupLayout pn_ttnvLayout = new javax.swing.GroupLayout(pn_ttnv);
        pn_ttnv.setLayout(pn_ttnvLayout);
        pn_ttnvLayout.setHorizontalGroup(
            pn_ttnvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ttnvLayout.createSequentialGroup()
                .addContainerGap(103, Short.MAX_VALUE)
                .addGroup(pn_ttnvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_chucvu)
                    .addComponent(lb_tennv))
                .addGap(32, 32, 32)
                .addGroup(pn_ttnvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_tl, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                    .addComponent(txt_chucvu))
                .addGap(18, 18, 18)
                .addComponent(lb_datetime)
                .addGap(18, 18, 18)
                .addComponent(txt_datetime, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(192, 192, 192))
        );
        pn_ttnvLayout.setVerticalGroup(
            pn_ttnvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ttnvLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_ttnvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_tennv)
                    .addComponent(txt_tl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_datetime)
                    .addComponent(txt_datetime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pn_ttnvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_chucvu)
                    .addComponent(txt_chucvu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pn_donv.setBackground(new Color(255, 255, 255));
        pn_donv.setBorder(javax.swing.BorderFactory.createTitledBorder("Thực hiện"));

        bt_inLuongNam.setBackground(new Color(255, 204, 102));
        bt_inLuongNam.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_inLuongNam.setText("In Lương Theo Năm");
        bt_inLuongNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_inLuongNamActionPerformed(evt);
            }
        });

        bt_inLuongThang.setBackground(new Color(255, 204, 102));
        bt_inLuongThang.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_inLuongThang.setText("In Lương Theo Tháng");
        bt_inLuongThang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_inLuongThangActionPerformed(evt);
            }
        });

        jLabel2.setText("In Lương Theo Năm");

        bt_inLuongNam2.setBackground(new Color(128, 128, 192));
        bt_inLuongNam2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_inLuongNam2.setText("Xem Cách Tính Lương");
        bt_inLuongNam2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_inLuongNam2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_donvLayout = new javax.swing.GroupLayout(pn_donv);
        pn_donv.setLayout(pn_donvLayout);
        pn_donvLayout.setHorizontalGroup(
            pn_donvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_donvLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_inLuongNam, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(bt_inLuongNam2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_inLuongThang, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        pn_donvLayout.setVerticalGroup(
            pn_donvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_donvLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_donvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_donvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bt_inLuongNam, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bt_inLuongNam2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bt_inLuongThang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pn_donv, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(pn_ttnv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pn_findnv, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(15, 15, 15))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                .addGap(221, 221, 221))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_findnvKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_findnvKeyReleased
        String query = txt_findnv.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        tb_nv.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }//GEN-LAST:event_txt_findnvKeyReleased

    private void bt_inLuongNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_inLuongNamActionPerformed
    	LuongThangDTO lt = getText();
    	if (lt == null) {
    	    return; // Không tiếp tục nếu `getText()` gặp lỗi
    	}

    	NhanVienDTO nv = bus.getNhanVienById(Login.username);

    	double tongLuong = 0;
    	Date dateTemp = lt.getDatetime();
    	if (dateTemp == null) {
    	    JOptionPane.showMessageDialog(null, "Lỗi: Ngày không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
    	    return;
    	}

    	Calendar cal = Calendar.getInstance();
    	cal.setTime(dateTemp);



        int year = cal.get(Calendar.YEAR);        
        PdfWriter writer = null;
        
        try {
            writer = new PdfWriter("./Xuatfile/BangLuongNam" + year + ".pdf");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        PdfDocument pdfDoc = new PdfDocument(writer);
        pdfDoc.addNewPage();
        PdfFont font = null;
        try {
            font = PdfFontFactory.createFont("times.ttf", IDENTITY_H, true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        Document doc = new Document(pdfDoc);
        String tittle = "Bang Lương Năm " + year ;
        Paragraph title = new Paragraph(tittle);
        title.setFont(font);
        title.setFontSize(30);
        title.setTextAlignment(TextAlignment.CENTER);
        doc.add(title);

        // Insert date
        java.util.Date date=new java.util.Date();
        String timee = date.toString();
        Paragraph time = new Paragraph(timee);
        time.setTextAlignment(TextAlignment.RIGHT);
        doc.add(time);

        String TTL = "Thông Tin Nhân Viên";
        Paragraph luong = new Paragraph(TTL);
        luong.add("\nHọ Tên NV: " + nv.getHoNV() + " " + nv.getTenNV());
        luong.add("\nĐịa chi: " + nv.getDiaChiNV());
        luong.add("\n\n Thông Tin Lương Chi tiết");
        luong.setFont(font);
        
        
        float[] columnWidths = {1, 1, 1}; // adjust as needed
        
        Table table = new Table(columnWidths);
        table.setWidth(500);

        Paragraph datetimePara = new Paragraph("Datetime");
        datetimePara.setFont(font);
        table.addCell(new Cell().add(datetimePara));

        Paragraph chucvuPara = new Paragraph("Chức vụ");
        chucvuPara.setFont(font);
        table.addCell(new Cell().add(chucvuPara));

        Paragraph hesoluongPara = new Paragraph("Hệ số lương");
        hesoluongPara.setFont(font);
        table.addCell(new Cell().add(hesoluongPara));
        
        List<Integer> thangLamViecTrongNam = bus.getThangLamViecTrongNam(Login.username, year);

        for (int month : thangLamViecTrongNam) {
            Paragraph monthIdentifier = new Paragraph("Month: " + month);
            monthIdentifier.setFont(font);
            monthIdentifier.setFontSize(20); // Increase the font size
            monthIdentifier.setBold(); // Make the text bold
            monthIdentifier.setTextAlignment(TextAlignment.CENTER); // Center the text
            table.addCell(new Cell(1, 3).add(monthIdentifier)); // Span the cell across all 3 columns

            List<ChuyenChucDTO> chucVuTrongThang = taoBangChiTietLuong(year, month);

            String luongThang = bus.tinhToanTongLuong(chucVuTrongThang);
            luongThang = luongThang.replace(".", "");
            tongLuong += Double.parseDouble(luongThang);

            for (ChuyenChucDTO change : chucVuTrongThang) {
                String date2 = change.getNgayChuyenChuc();
                String position = change.getChucvu();
                String salary = change.getHeSoLuong();

                table.addCell(new Cell().add(new Paragraph(date2)));

                Paragraph a = new Paragraph(position);
                a.setFont(font);
                table.addCell(a);

                table.addCell(new Cell().add(new Paragraph(salary)));
            }
        }
 
        doc.add(luong);
        doc.add(table);
        Paragraph totalSalaryPara = new Paragraph("Total Salary: "+ CurrencyUtil.formatNumber(tongLuong));
        totalSalaryPara.setTextAlignment(TextAlignment.RIGHT);
        doc.add(totalSalaryPara);
        doc.close();
        JOptionPane.showMessageDialog(null, "Xuất Lương Năm Thành Công!");
    }//GEN-LAST:event_bt_inLuongNamActionPerformed

    private void tb_nvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_nvMouseClicked
        int i = tb_nv.getSelectedRow();
        if(i>=0){
            //txt_manv.setText(tb_nv.getModel().getValueAt(i, 0).toString());
            txt_tl.setText(tb_nv.getModel().getValueAt(i, 1).toString());
            txt_chucvu.setText(tb_nv.getModel().getValueAt(i, 0).toString());
            txt_datetime.setText(tb_nv.getModel().getValueAt(i, 2).toString());
            
        }
    }//GEN-LAST:event_tb_nvMouseClicked

    private void txt_findnvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_findnvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_findnvActionPerformed

    private void bt_inLuongThangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_inLuongThangActionPerformed
        LuongThangDTO lt = getText();
        NhanVienDTO nv = bus.getNhanVienById(Login.username);

        Date dateTemp = lt.getDatetime();

        Calendar cal = Calendar.getInstance();
        cal.setTime(dateTemp);

        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1; // Note: January is 0, February is 1, ...
        
        PdfWriter writer = null;
        
        try {
            writer = new PdfWriter("./Xuatfile/BangLuongThang" + month + "Nam" + year + ".pdf");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        PdfDocument pdfDoc = new PdfDocument(writer);
        pdfDoc.addNewPage();
        PdfFont font = null;
        try {
            font = PdfFontFactory.createFont("times.ttf", IDENTITY_H, true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        Document doc = new Document(pdfDoc);
        String tittle = "Bang Lương Tháng " + month + " Năm " + year ;
        Paragraph title = new Paragraph(tittle);
        title.setFont(font);
        title.setFontSize(30);
        title.setTextAlignment(TextAlignment.CENTER);
        doc.add(title);

        // Insert date
        java.util.Date date=new java.util.Date();
        String timee = date.toString();
        Paragraph time = new Paragraph(timee);
        time.setTextAlignment(TextAlignment.RIGHT);
        doc.add(time);

        String TTL = "Thông Tin Nhân Viên";
        Paragraph luong = new Paragraph(TTL);
        luong.add("\nHọ Tên NV: " + nv.getHoNV() + " " + nv.getTenNV());
        luong.add("\nĐịa chi: " + nv.getDiaChiNV());
        luong.add("\n\n Thông Tin Lương Chi tiết");
        luong.setFont(font);
        
        float[] columnWidths = {1, 1, 1}; // adjust as needed
        
        Table table = new Table(columnWidths);
        table.setWidth(500);

        Paragraph datetimePara = new Paragraph("Datetime");
        datetimePara.setFont(font);
        table.addCell(new Cell().add(datetimePara));

        Paragraph chucvuPara = new Paragraph("Chức vụ");
        chucvuPara.setFont(font);
        table.addCell(new Cell().add(chucvuPara));

        Paragraph hesoluongPara = new Paragraph("Hệ số lương");
        hesoluongPara.setFont(font);
        table.addCell(new Cell().add(hesoluongPara));
        
        List<ChuyenChucDTO> chucVuTrongThang = taoBangChiTietLuong(year, month);

        for (ChuyenChucDTO change : chucVuTrongThang) {
            String date2 = change.getNgayChuyenChuc();
            String position = change.getChucvu();
            String salary = change.getHeSoLuong();

            table.addCell(new Cell().add(new Paragraph(date2)));

            Paragraph a = new Paragraph(position);
            a.setFont(font);
            table.addCell(a);

            table.addCell(new Cell().add(new Paragraph(salary)));
        }
       
        doc.add(luong);
        doc.add(table);
        String tongLuong = bus.tinhToanTongLuong(chucVuTrongThang);
        Paragraph totalSalaryPara = new Paragraph("Total Salary: "+ tongLuong);
        totalSalaryPara.setTextAlignment(TextAlignment.RIGHT);
        doc.add(totalSalaryPara);
        doc.close();
        JOptionPane.showMessageDialog(null, "Xuất Lương Tháng Thành Công!");

    }//GEN-LAST:event_bt_inLuongThangActionPerformed

    private void bt_inLuongNam2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_inLuongNam2ActionPerformed
       // Create the custom message panel
        JPanel messagePanel = new JPanel(new BorderLayout());
        JTextArea messageTextArea = new JTextArea(XemTinhLuongUtil.XEM_TINH_LUONG);
        messageTextArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(messageTextArea); // Wrap the text area in a scroll pane

        messagePanel.add(scrollPane, BorderLayout.CENTER);

        JButton closeButton = new JButton("Close");
        messagePanel.add(closeButton, BorderLayout.SOUTH);

        // Set preferred size for the message panel
        messagePanel.setPreferredSize(new Dimension(400, 300));

        // Set preferred size for the close button
        closeButton.setPreferredSize(new Dimension(40, 30));

        // Create the dialog
        JDialog dialog = new JDialog();
        dialog.setTitle("Xem cách tính lương");
        dialog.setModal(true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.getContentPane().add(messagePanel);

        // Set action listener for the close button
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose(); // Close the dialog
            }
        });

        // Pack and set the size of the dialog
        dialog.pack();
        dialog.setSize(400, 300);

        // Show the dialog
        dialog.setVisible(true);
    
    }//GEN-LAST:event_bt_inLuongNam2ActionPerformed

    public List<ChuyenChucDTO> taoBangChiTietLuong(int year, int month) {
        //tạo table lương chi tiết trong tháng
        ChuyenChucDTO chucTruocDo = bus.chucVuThangTruocDo(Login.username, year + "-" + month + "-00");       
        List<LocalDate> chamCongTrongThang = bus.getAttendanceDates(Login.username, year, month);
        List<ChuyenChucDTO> chucVuTrongThang = bus.getChucVuTrongThang(Login.username, chamCongTrongThang, chucTruocDo);
        
        if (chucVuTrongThang.size() >= 2) {
            ChuyenChucDTO lastElement = chucVuTrongThang.get(chucVuTrongThang.size() - 1);
            ChuyenChucDTO secondLastElement = chucVuTrongThang.get(chucVuTrongThang.size() - 2);

            if (lastElement.getChucvu() == null) {
                lastElement.setChucvu(secondLastElement.getChucvu());
            }

            if (lastElement.getHeSoLuong()== null) {
                lastElement.setHeSoLuong(secondLastElement.getHeSoLuong());
            }

            // Repeat for other fields that might be null

            // Set the modified elements back into the list
            chucVuTrongThang.set(chucVuTrongThang.size() - 1, lastElement);
        }
            return chucVuTrongThang;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_inLuongNam;
    private javax.swing.JButton bt_inLuongNam2;
    private javax.swing.JButton bt_inLuongThang;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_chucvu;
    private javax.swing.JLabel lb_datetime;
    private javax.swing.JLabel lb_findnv;
    private javax.swing.JLabel lb_tennv;
    private javax.swing.JPanel pn_donv;
    private javax.swing.JPanel pn_findnv;
    private javax.swing.JPanel pn_ttnv;
    private javax.swing.JTable tb_nv;
    private javax.swing.JTextField txt_chucvu;
    private javax.swing.JTextField txt_datetime;
    private javax.swing.JTextField txt_findnv;
    private javax.swing.JTextField txt_tl;
    // End of variables declaration//GEN-END:variables
}
