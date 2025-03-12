package GUI;

import BUS.DonXinNghiBUS;
import DTO.DonXinNghiDTO;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class PanelDonXinNghi extends JPanel {

    private String maNV; // Mã nhân viên hiện hành
    private DonXinNghiBUS donBUS = new DonXinNghiBUS();
    private JTable tbDonXinNghi;
    private DefaultTableModel model;
    private JButton btnTaoDon, btnRefresh;

    public PanelDonXinNghi(String maNV) {
        this.maNV = maNV;
        initComponents();
        loadData();
    }

    private void initComponents() {
        this.setLayout(new BorderLayout());
        // Tạo tiêu đề cho panel
        JLabel lblTitle = new JLabel("Đơn Xin Nghỉ Của Tôi", SwingConstants.CENTER);
        lblTitle.setFont(lblTitle.getFont().deriveFont(18f));
        this.add(lblTitle, BorderLayout.NORTH);

        // Bảng hiển thị đơn xin nghỉ
        model = new DefaultTableModel(new Object[]{"Mã Đơn", "Lý Do", "Ngày Nghỉ", "Ngày Nộp", "Ngày Duyệt", "Trạng Thái"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tbDonXinNghi = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tbDonXinNghi);
        scrollPane.setPreferredSize(new Dimension(600, 300));
        this.add(scrollPane, BorderLayout.CENTER);

        // Panel chứa các nút chức năng
        JPanel pnlButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        btnTaoDon = new JButton("Tạo đơn xin nghỉ");
        btnRefresh = new JButton("Refresh");
        pnlButtons.add(btnTaoDon);
        pnlButtons.add(btnRefresh);
        this.add(pnlButtons, BorderLayout.SOUTH);

        // Sự kiện cho nút tạo đơn
        btnTaoDon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateDonXinNghiForm form = new CreateDonXinNghiForm(null, true);
                form.setLocationRelativeTo(PanelDonXinNghi.this);
                form.setVisible(true);
                // Sau khi đóng form, làm mới bảng nếu có thêm đơn mới
                if (form.isSaved()) {
                    loadData();
                }
            }
        });

        // Sự kiện cho nút refresh
        btnRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadData();
            }
        });
    }

    // Load danh sách đơn của nhân viên hiện tại
    private void loadData() {
        model.setRowCount(0);
        ArrayList<DonXinNghiDTO> allDon = donBUS.docDonXinNghi();
        // Lọc theo mã nhân viên
        System.out.println("Panel maNV: " + maNV);
        for (DonXinNghiDTO don : allDon) {
            if (don.getMaNV().trim().equalsIgnoreCase(maNV.trim())) {
                model.addRow(new Object[]{
                    don.getMaDon(),
                    don.getLyDo(),
                    don.getNgayNghi(),
                    don.getNgayNopDon(),
                    don.getNgayDuyet(),
                    don.getTrangThai()
                });
            }
        }
    }

    // Form tạo đơn xin nghỉ (sử dụng JDialog)
    class CreateDonXinNghiForm extends JDialog {
        private JTextField txtLyDo, txtNgayNghi;
        private JButton btnSubmit, btnCancel;
        private boolean saved = false;

        public CreateDonXinNghiForm(java.awt.Frame parent, boolean modal) {
            super(parent, modal);
            setTitle("Tạo đơn xin nghỉ");
            initFormComponents();
            pack();
        }

        private void initFormComponents() {
            JPanel pnlMain = new JPanel(new BorderLayout(10, 10));
            pnlMain.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            // Panel nhập thông tin
            JPanel pnlInput = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
            pnlInput.add(new JLabel("Lý Do:"));
            txtLyDo = new JTextField(20);
            pnlInput.add(txtLyDo);
            pnlInput.add(new JLabel("Ngày Nghỉ (yyyy-mm-dd):"));
            txtNgayNghi = new JTextField(10);
            pnlInput.add(txtNgayNghi);
            pnlMain.add(pnlInput, BorderLayout.CENTER);

            // Panel nút
            JPanel pnlButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
            btnSubmit = new JButton("Submit");
            btnCancel = new JButton("Cancel");
            pnlButtons.add(btnSubmit);
            pnlButtons.add(btnCancel);
            pnlMain.add(pnlButtons, BorderLayout.SOUTH);

            add(pnlMain);

            // Sự kiện nút Submit
            btnSubmit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String lyDo = txtLyDo.getText().trim();
                    String ngayNghi = txtNgayNghi.getText().trim();
                    if (lyDo.isEmpty() || ngayNghi.isEmpty()) {
                        JOptionPane.showMessageDialog(CreateDonXinNghiForm.this, "Vui lòng nhập đầy đủ thông tin!");
                        return;
                    }
                    
                    // Kiểm tra định dạng ngày: yyyy-MM-dd
                    LocalDate ngayNghiDate;
                    try {
                        ngayNghiDate = LocalDate.parse(ngayNghi); // ISO_LOCAL_DATE mặc định là yyyy-MM-dd
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(CreateDonXinNghiForm.this, "Ngày nghỉ phải theo định dạng yyyy-mm-dd!");
                        return;
                    }
                    
                    // Kiểm tra ngày nghỉ phải sau ngày hiện tại 7 ngày
                    LocalDate minValidDate = LocalDate.now().plusDays(7);
                    if (!ngayNghiDate.isAfter(minValidDate.minusDays(1))) {  
                        // Có thể dùng isBefore() hoặc equals() tùy ý: ở đây yêu cầu phải sau 7 ngày
                        JOptionPane.showMessageDialog(CreateDonXinNghiForm.this, "Ngày nghỉ phải sau " + minValidDate.toString() + " (sau 7 ngày kể từ hôm nay)!");
                        return;
                    }
                    
                    // Mã đơn để rỗng, DAO sẽ tự sinh mã
                    String maDon = "";
                    // Lấy mã nhân viên từ Login (đã gán chính xác sau đăng nhập)
                    String maNV = GUI.Login.maNV;
                    // Ngày nộp đơn: ngày hiện tại
                    String ngayNopDon = LocalDate.now().toString();
                    // Ngày duyệt: để trống
                    String ngayDuyet = "";
                    // Trạng thái mặc định: ChuaXuLy
                    DonXinNghiDTO.Status trangThai = DonXinNghiDTO.Status.ChuaXuLy;
                    
                    DonXinNghiDTO don = new DonXinNghiDTO(maDon, maNV, lyDo, ngayNghi, ngayNopDon, ngayDuyet, trangThai);
                    int res = donBUS.themDonXinNghi(don);
                    if (res == 1) {
                        JOptionPane.showMessageDialog(CreateDonXinNghiForm.this, "Tạo đơn xin nghỉ thành công!");
                        saved = true;
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(CreateDonXinNghiForm.this, "Tạo đơn xin nghỉ thất bại!");
                    }
                }
            });



            // Sự kiện nút Cancel
            btnCancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            });
        }

        public boolean isSaved() {
            return saved;
        }
    }
}
