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
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;

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
        tittle.setBackground(new Color(255, 255, 255));
        lblTitleTC.setFont(new Font("Tahoma", Font.BOLD, 28)); // NOI18N
        lblTitleTC.setIcon(new ImageIcon(getClass().getResource("/image/house.png")));
        lblTitleTC.setText("Trang chủ");
        lblTitleTC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        javax.swing.GroupLayout tittleLayout = new javax.swing.GroupLayout(tittle);
        tittleLayout.setHorizontalGroup(
        	tittleLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, tittleLayout.createSequentialGroup()
        			.addGap(133)
        			.addComponent(lblTitleTC, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
        			.addGap(145))
        );
        tittleLayout.setVerticalGroup(
        	tittleLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(tittleLayout.createSequentialGroup()
        			.addComponent(lblTitleTC, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(11, Short.MAX_VALUE))
        );
        tittle.setLayout(tittleLayout);

        // Khung slideshow thay cho pn_show cũ
        pn_slideshow = new JPanel();
        pn_slideshow.setBackground(new Color(240, 240, 240));
        pn_slideshow.setLayout(new BorderLayout());
        lb_slideshow = new JLabel();
        lb_slideshow.setBackground(new Color(240, 240, 240));
        lb_slideshow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        // Bạn có thể thiết lập kích thước hoặc biên giới cho lb_slideshow nếu cần
        lb_slideshow.setPreferredSize(new Dimension(800, 400));
        pn_slideshow.add(lb_slideshow, BorderLayout.NORTH);

        // Bố trí toàn bộ panel chính
        pn_all.setBackground(new Color(240, 240, 240));
        javax.swing.GroupLayout pn_allLayout = new javax.swing.GroupLayout(pn_all);
        pn_allLayout.setHorizontalGroup(
        	pn_allLayout.createParallelGroup(Alignment.TRAILING)
        		.addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        		.addComponent(pn_slideshow, GroupLayout.DEFAULT_SIZE, 960, Short.MAX_VALUE)
        		.addGroup(Alignment.LEADING, pn_allLayout.createSequentialGroup()
        			.addGap(206)
        			.addComponent(tittle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addGap(251))
        );
        pn_allLayout.setVerticalGroup(
        	pn_allLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(pn_allLayout.createSequentialGroup()
        			.addGap(6)
        			.addComponent(tittle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(pn_slideshow, GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE))
        );
        pn_all.setLayout(pn_allLayout);

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
        // Hiển thị ảnh đầu tiên ngay khi mở
        java.net.URL imgURL = getClass().getResource(imagePaths[currentImageIndex]);
        if (imgURL != null) {
            lb_slideshow.setIcon(new ImageIcon(imgURL));
        }

        // Sau đó khởi động timer để chuyển ảnh
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
