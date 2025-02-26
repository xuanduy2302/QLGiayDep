
package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.ResultSet;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import BUS.LoginBUS;
import BUS.NhanVienBUS;
import BUS.SanPhamBUS;

public class PanelThongKeSanPham extends javax.swing.JPanel {
    
        LoginBUS bus = new LoginBUS();
        SanPhamBUS spbus = new SanPhamBUS();
        NhanVienBUS nvbus = new NhanVienBUS();

        public String username = Login.username;
        JFreeChart chart, amountChart, quantityChart;
        int year;
        int month;
        boolean bienChot = true;
        
    public PanelThongKeSanPham() {
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
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jComboBox_month = new javax.swing.JComboBox<>();
        panel_tkl = new javax.swing.JPanel();
        panel_chart = new javax.swing.JPanel();
        btn_intk = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jComboBox_year1 = new javax.swing.JComboBox<>();

        panelforall.setBackground(new java.awt.Color(238, 241, 245));

        tittle2.setBackground(new java.awt.Color(255, 255, 0));

        lblTitleTC2.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        lblTitleTC2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitleTC2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/user.png"))); // NOI18N
        lblTitleTC2.setText("Thống kê sản phẩm");

        javax.swing.GroupLayout tittle2Layout = new javax.swing.GroupLayout(tittle2);
        tittle2.setLayout(tittle2Layout);
        tittle2Layout.setHorizontalGroup(
            tittle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tittle2Layout.createSequentialGroup()
                .addGap(319, 319, 319)
                .addComponent(lblTitleTC2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(265, 265, 265))
        );
        tittle2Layout.setVerticalGroup(
            tittle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tittle2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitleTC2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Năm");

        jButton1.setBackground(new java.awt.Color(255, 204, 102));
        jButton1.setText("Thống kê theo tháng");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox_month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        panel_tkl.setBackground(new java.awt.Color(255, 0, 204));

        javax.swing.GroupLayout panel_chartLayout = new javax.swing.GroupLayout(panel_chart);
        panel_chart.setLayout(panel_chartLayout);
        panel_chartLayout.setHorizontalGroup(
            panel_chartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 727, Short.MAX_VALUE)
        );
        panel_chartLayout.setVerticalGroup(
            panel_chartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_tklLayout = new javax.swing.GroupLayout(panel_tkl);
        panel_tkl.setLayout(panel_tklLayout);
        panel_tklLayout.setHorizontalGroup(
            panel_tklLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_tklLayout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(panel_chart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        panel_tklLayout.setVerticalGroup(
            panel_tklLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_tklLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panel_chart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        btn_intk.setBackground(new java.awt.Color(255, 204, 102));
        btn_intk.setText("In thống kê sản phẩm");
        btn_intk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_intkActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 204, 102));
        jButton2.setText("Thống kê theo Năm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Tháng");

        jComboBox_year1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2023", "2024", "2025" }));

        javax.swing.GroupLayout pn_doLayout = new javax.swing.GroupLayout(pn_do);
        pn_do.setLayout(pn_doLayout);
        pn_doLayout.setHorizontalGroup(
            pn_doLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_doLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(pn_doLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pn_doLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(9, 9, 9)
                        .addComponent(jComboBox_month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox_year1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(34, 34, 34)
                        .addComponent(btn_intk, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panel_tkl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71))
        );
        pn_doLayout.setVerticalGroup(
            pn_doLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_doLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(pn_doLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_month, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_intk, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_year1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(panel_tkl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(652, Short.MAX_VALUE))
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
        String selectedYear = jComboBox_year1.getSelectedItem().toString();
        String selectedMonth = jComboBox_month.getSelectedItem().toString();
        year = Integer.parseInt(selectedYear);
        month =  Integer.parseInt(selectedMonth);
        
        DefaultCategoryDataset quantityDataset = new DefaultCategoryDataset();
        DefaultCategoryDataset amountDataset = new DefaultCategoryDataset();
        ResultSet rs = spbus.thongKeSanPhamTheoThang(year, month);

        try {
            while (rs.next()) {
                String maSP = rs.getString("MaSP");
                int totalQuantity = rs.getInt("TotalQuantity");
                double totalAmount = rs.getDouble("TotalAmount");

                quantityDataset.addValue(totalQuantity, "Quantity", maSP);
                amountDataset.addValue(totalAmount, "Amount", maSP);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        quantityChart = ChartFactory.createBarChart(
                "Quantity Chart",
                "Product",
                "Quantity",
                quantityDataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        NumberAxis quantityAxis = (NumberAxis) quantityChart.getCategoryPlot().getRangeAxis();
        quantityAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        amountChart = ChartFactory.createBarChart(
                "Amount Chart",
                "Product",
                "Amount",
                amountDataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        JPanel tempPanel = new JPanel();
        tempPanel.setLayout(new BoxLayout(tempPanel, BoxLayout.X_AXIS));

        ChartPanel quantityPanel = new ChartPanel(quantityChart);
        quantityPanel.setPreferredSize(new java.awt.Dimension(450, 400));
        ChartPanel amountPanel = new ChartPanel(amountChart);
        amountPanel.setPreferredSize(new java.awt.Dimension(450, 400));

        tempPanel.add(quantityPanel);
        tempPanel.add(amountPanel);
        
        

        panel_chart.setLayout(new BoxLayout(panel_chart, BoxLayout.X_AXIS));
        panel_chart.add(tempPanel);
        panel_chart.removeAll();
        panel_chart.add(tempPanel);
        panel_chart.revalidate();
        panel_chart.repaint();
        
        panel_tkl.setLayout(new BorderLayout());
        panel_tkl.removeAll();
        panel_tkl.add(panel_chart);
        panel_tkl.revalidate();
        panel_tkl.repaint();
        panel_tkl.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_intkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_intkActionPerformed
       try {
        String filePath;
        if (bienChot) {
            filePath = "./Xuatfile/ThongKeSanPham tháng " + month + " năm " + year + "-quantity.png";
            String filePath2 = "./Xuatfile/ThongKeSanPham tháng " + month + " năm " + year + "-amount.png";

            // Create the directory if it doesn't exist
            File directory = new File(filePath).getParentFile();
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Save the charts as PNGs
            ChartUtilities.saveChartAsPNG(new File(filePath), amountChart, 450, 400);
            ChartUtilities.saveChartAsPNG(new File(filePath2), quantityChart, 450, 400);

            // Combine the two PNG images
            combineTwoPNGImages(filePath, filePath2, "./Xuatfile/ThongKeSanPham tháng " + month + " năm " + year + ".png");

            JOptionPane.showMessageDialog(null, "In thống kê thành công!");
            bienChot = true;
        } else {
            filePath = "./Xuatfile/ThongKeSanPhamCacNam.png";

            // Create the directory if it doesn't exist
            File directory = new File(filePath).getParentFile();
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Save the chart as a PNG
            ChartUtilities.saveChartAsPNG(new File(filePath), chart, 920, panel_chart.getHeight() + 120);
            JOptionPane.showMessageDialog(null, "In thống kê thành công!");
            bienChot = true;
        }
    } catch (Exception e) {
        System.out.println("export error " + e.getMessage());
        JOptionPane.showMessageDialog(null, "In thống kê thất bại!");
    }
    }//GEN-LAST:event_btn_intkActionPerformed
private void combineTwoPNGImages(String imagePath1, String imagePath2, String outputPath) {
    try {
        // Load the two images
        BufferedImage image1 = ImageIO.read(new File(imagePath1));
        BufferedImage image2 = ImageIO.read(new File(imagePath2));

        // Get the dimensions of the two images
        int width1 = image1.getWidth();
        int height1 = image1.getHeight();
        int width2 = image2.getWidth();
        int height2 = image2.getHeight();

        // Determine the dimensions of the combined image
        int combinedWidth = width1 + width2;
        int combinedHeight = Math.max(height1, height2);

        // Create a new image with the combined dimensions
        BufferedImage combinedImage = new BufferedImage(combinedWidth, combinedHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = combinedImage.createGraphics();

        // Draw the two images onto the new image
        g2d.drawImage(image1, 0, 0, null);
        g2d.drawImage(image2, width1, 0, null);

        // Save the combined image
        File outputFile = new File(outputPath);
        ImageIO.write(combinedImage, "png", outputFile);

        System.out.println("Combined images successfully!");

        // Delete the individual image files
        File file1 = new File(imagePath1);
        File file2 = new File(imagePath2);
        if (file1.delete()) {
            System.out.println("Deleted " + imagePath1);
        } else {
            System.out.println("Failed to delete " + imagePath1);
        }
        if (file2.delete()) {
            System.out.println("Deleted " + imagePath2);
        } else {
            System.out.println("Failed to delete " + imagePath2);
        }
    } catch (Exception e) {
        System.out.println("Error combining images: " + e.getMessage());
    }
}
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        bienChot = false;

        String selectedYear = jComboBox_year1.getSelectedItem().toString();
        String selectedMonth = jComboBox_month.getSelectedItem().toString();
        year = Integer.parseInt(selectedYear);
        month =  Integer.parseInt(selectedMonth);
                
        ResultSet rs = spbus.thongKeSanPhamTheoNam();

    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    try {
        while (rs.next()) {
            String monthYear = rs.getInt("Month") + "/" + rs.getInt("Year");
            dataset.addValue(rs.getDouble("ThanhTienCTPn"), rs.getString("MaSP"), monthYear);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    chart = ChartFactory.createBarChart(
        "Thống kê san pham theo năm", "Date", "ThanhTienCTPn",
        dataset,
        PlotOrientation.VERTICAL,
        true, true, false);
        
        makeChart(0.04);
    }//GEN-LAST:event_jButton2ActionPerformed
    
    public void makeChart(double itemMargin) {
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryMargin(0.5);
        
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setMaxBarWidth(1);
        renderer.setItemMargin(itemMargin);
        
        ChartPanel chartPanel = new ChartPanel(chart);
        
       
        Dimension preferredSize = new Dimension(920, 500);
        chartPanel.setPreferredSize(preferredSize);
        panel_chart.setLayout(new BorderLayout());
        panel_chart.removeAll();
        panel_chart.add(chartPanel, BorderLayout.CENTER);
        panel_chart.revalidate();
        panel_chart.repaint();
        
        panel_tkl.setLayout(new BorderLayout());
        panel_tkl.removeAll();
        panel_tkl.add(panel_chart);
        panel_tkl.revalidate();
        panel_tkl.repaint();
        panel_tkl.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_intk;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox_month;
    private javax.swing.JComboBox<String> jComboBox_year1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblTitleTC2;
    private javax.swing.JPanel panel_chart;
    private javax.swing.JPanel panel_tkl;
    private javax.swing.JPanel panelforall;
    private javax.swing.JPanel pn_do;
    private javax.swing.JPanel pn_show1;
    private javax.swing.JPanel tittle2;
    // End of variables declaration//GEN-END:variables
}
