package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PanelTrangChu extends javax.swing.JPanel {

    // Các thành phần ban đầu (mẫu tiêu đề, v.v.)
    private JPanel pn_all;
    private JPanel tittle;
    private JLabel lblTitleTC;
    private javax.swing.JSeparator jSeparator1;
    // Thay thế pn_show cũ bằng pn_slideshow
    private JPanel pn_slideshow;
    private JLabel lb_slideshow;
    
    // Timer để slideshow tự động chuyển ảnh
    private Timer timer;
    private int currentImageIndex = 0;
    // Mảng chứa đường dẫn đến các hình ảnh (đảm bảo các file hình tồn tại trong folder /image)
    private String[] imagePaths = {"/image/welcome.jpg", "/image/banner giay.jpg", "/image/banner dep.jpg"};

    public PanelTrangChu() {
    	this.setPreferredSize(new java.awt.Dimension(960, 740));
        initComponents();
        startSlideshow();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        pn_all = new JPanel();
        tittle = new JPanel();
        lblTitleTC = new JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        
        // Cấu hình tiêu đề
        tittle.setBackground(new Color(238, 241, 245));
        lblTitleTC.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTitleTC.setIcon(new ImageIcon(getClass().getResource("/image/house.png")));
        lblTitleTC.setText("Trang chủ");
        lblTitleTC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        javax.swing.GroupLayout tittleLayout = new javax.swing.GroupLayout(tittle);
        tittle.setLayout(tittleLayout);
        tittleLayout.setHorizontalGroup(
            tittleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tittleLayout.createSequentialGroup()
                .addContainerGap(162, Short.MAX_VALUE)
                .addComponent(lblTitleTC, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(142, 142, 142))
        );
        tittleLayout.setVerticalGroup(
            tittleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tittleLayout.createSequentialGroup()
                .addComponent(lblTitleTC, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        // Khung slideshow thay cho pn_show cũ
        pn_slideshow = new JPanel();
        pn_slideshow.setBackground(new Color(204, 255, 204));
        pn_slideshow.setLayout(new BorderLayout());
        lb_slideshow = new JLabel();
        lb_slideshow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        // Bạn có thể thiết lập kích thước hoặc biên giới cho lb_slideshow nếu cần
        lb_slideshow.setPreferredSize(new Dimension(800, 400));
        pn_slideshow.add(lb_slideshow, BorderLayout.CENTER);

        // Bố trí toàn bộ panel chính
        pn_all.setBackground(new Color(204, 255, 204));
        javax.swing.GroupLayout pn_allLayout = new javax.swing.GroupLayout(pn_all);
        pn_all.setLayout(pn_allLayout);
        pn_allLayout.setHorizontalGroup(
            pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(pn_slideshow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_allLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tittle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(280, 280, 280))
        );
        pn_allLayout.setVerticalGroup(
            pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_allLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(tittle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_slideshow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_all, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_all, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }

    private void startSlideshow() {
        // Khởi tạo Timer để chuyển ảnh sau mỗi 1,5 giây (1500 ms)
        timer = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentImageIndex = (currentImageIndex + 1) % imagePaths.length;
                java.net.URL imgURL = getClass().getResource(imagePaths[currentImageIndex]);
                if (imgURL != null) {
                    lb_slideshow.setIcon(new ImageIcon(imgURL));
                } else {
                    lb_slideshow.setText("Không tìm thấy ảnh: " + imagePaths[currentImageIndex]);
                }
            }
        });
        timer.start();
    }
}
