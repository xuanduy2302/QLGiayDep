package GUI;

import BUS.DonXinNghiBUS;
import DTO.DonXinNghiDTO;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.Font;
import java.awt.Color;

public class PanelDuyetDonXinNghi extends JPanel {

    private DonXinNghiBUS donBUS = new DonXinNghiBUS();
    private DefaultTableModel model;
    private JTable tableDonXinNghi;
    private TableRowSorter<DefaultTableModel> sorter;
    private JTextField txtSearch;
    private JComboBox<String> cbStatus;
    private JButton btnDuyet, btnTuChoi;
    
    public PanelDuyetDonXinNghi() {
    	this.setPreferredSize(new java.awt.Dimension(960, 740));
        initComponents();
        loadData();
    }
    
    private void initComponents() {
        this.setLayout(new BorderLayout(10, 10));
        
        // Tiêu đề
        JLabel lblTitle = new JLabel("Duyệt Đơn Xin Nghỉ", JLabel.CENTER);
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 24));
        this.add(lblTitle, BorderLayout.NORTH);
        
        // Panel tìm kiếm và lọc
        JPanel panelFilter = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        panelFilter.setBorder(BorderFactory.createTitledBorder("Tìm kiếm & Lọc"));
        panelFilter.add(new JLabel("Mã NV:"));
        txtSearch = new JTextField(10);
        panelFilter.add(txtSearch);
        panelFilter.add(new JLabel("Trạng thái:"));
        cbStatus = new JComboBox<>(new String[] { "Tất cả", "ChuaXuLy", "DaDuyet", "TuChoi" });
        panelFilter.add(cbStatus);
        this.add(panelFilter, BorderLayout.SOUTH);
        
        // Bảng hiển thị đơn xin nghỉ
        model = new DefaultTableModel(new Object[]{"Mã Đơn", "Mã NV", "Lý Do", "Ngày Nghỉ", "Ngày Nộp", "Ngày Duyệt", "Trạng Thái"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableDonXinNghi = new JTable(model);
        sorter = new TableRowSorter<>(model);
        tableDonXinNghi.setRowSorter(sorter);
        
        JScrollPane scrollPane = new JScrollPane(tableDonXinNghi);
        this.add(scrollPane, BorderLayout.CENTER);
        
        // Panel xử lý duyệt/từ chối
        JPanel panelAction = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        btnDuyet = new JButton("Duyệt");
        btnDuyet.setBackground(new Color(76, 175, 80));
        panelAction.add(btnDuyet);
        
        // Sự kiện duyệt đơn
        btnDuyet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tableDonXinNghi.getSelectedRow();
                if (selectedRow < 0) {
                    JOptionPane.showMessageDialog(PanelDuyetDonXinNghi.this, "Vui lòng chọn đơn cần duyệt!");
                    return;
                }
                int modelRow = tableDonXinNghi.convertRowIndexToModel(selectedRow);
                String maDon = model.getValueAt(modelRow, 0).toString();
                String currentStatus = model.getValueAt(modelRow, 6).toString();
                // Nếu đơn không ở trạng thái "ChuaXuLy", không cho duyệt lại
                if (!currentStatus.equals("ChuaXuLy")) {
                    JOptionPane.showMessageDialog(PanelDuyetDonXinNghi.this, "Đơn đã được xử lý. Không thể duyệt lại!");
                    return;
                }
                String ngayDuyet = java.time.LocalDate.now().toString();
                int confirm = JOptionPane.showConfirmDialog(PanelDuyetDonXinNghi.this, "Xác nhận duyệt đơn: " + maDon, "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    int res = donBUS.duyetDonXinNghi(maDon, ngayDuyet);
                    if (res == 1) {
                        JOptionPane.showMessageDialog(PanelDuyetDonXinNghi.this, "Duyệt đơn thành công!");
                        loadData();
                    } else {
                        JOptionPane.showMessageDialog(PanelDuyetDonXinNghi.this, "Lỗi duyệt đơn!");
                    }
                }
            }
        });
        btnTuChoi = new JButton("Từ chối");
        btnTuChoi.setBackground(new Color(244, 67, 54));
        panelAction.add(btnTuChoi);
        
                
                // Sự kiện từ chối đơn
                btnTuChoi.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int selectedRow = tableDonXinNghi.getSelectedRow();
                        if (selectedRow < 0) {
                            JOptionPane.showMessageDialog(PanelDuyetDonXinNghi.this, "Vui lòng chọn đơn cần từ chối!");
                            return;
                        }
                        int modelRow = tableDonXinNghi.convertRowIndexToModel(selectedRow);
                        String maDon = model.getValueAt(modelRow, 0).toString();
                        String currentStatus = model.getValueAt(modelRow, 6).toString();
                        // Nếu đơn không ở trạng thái "ChuaXuLy", không cho từ chối lại
                        if (!currentStatus.equals("ChuaXuLy")) {
                            JOptionPane.showMessageDialog(PanelDuyetDonXinNghi.this, "Đơn đã được xử lý. Không thể từ chối lại!");
                            return;
                        }
                        String ngayDuyet = java.time.LocalDate.now().toString();
                        int confirm = JOptionPane.showConfirmDialog(PanelDuyetDonXinNghi.this, "Xác nhận từ chối đơn: " + maDon, "Xác nhận", JOptionPane.YES_NO_OPTION);
                        if (confirm == JOptionPane.YES_OPTION) {
                            int res = donBUS.tuChoiDonXinNghi(maDon, ngayDuyet);
                            if (res == 1) {
                                JOptionPane.showMessageDialog(PanelDuyetDonXinNghi.this, "Từ chối đơn thành công!");
                                loadData();
                            } else {
                                JOptionPane.showMessageDialog(PanelDuyetDonXinNghi.this, "Lỗi từ chối đơn!");
                            }
                        }
                    }
                });
        this.add(panelAction, BorderLayout.EAST);
        
        // Sự kiện tìm kiếm & lọc
        txtSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                applyFilter();
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                applyFilter();
            }
        });
        cbStatus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                applyFilter();
            }
        });
        
        // Sự kiện chọn dòng trong bảng
        tableDonXinNghi.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // Bạn có thể thêm xử lý khi chọn đơn
            }
        });

    }
    
    // Hàm tải dữ liệu đơn xin nghỉ từ database và cập nhật vào bảng
    private void loadData() {
        ArrayList<DonXinNghiDTO> list = donBUS.docDonXinNghi();
        model.setRowCount(0);
        for (DonXinNghiDTO don : list) {
            // Hiển thị tất cả đơn, sau này lọc theo tìm kiếm và trạng thái
            Object[] row = {
                don.getMaDon(),
                don.getMaNV(),
                don.getLyDo(),
                don.getNgayNghi(),
                don.getNgayNopDon(),
                don.getNgayDuyet(),
                don.getTrangThai().toString()
            };
            model.addRow(row);
        }
    }
    
    // Hàm áp dụng bộ lọc tìm kiếm và lọc theo trạng thái
    private void applyFilter() {
        String searchText = txtSearch.getText().trim();
        String statusFilter = cbStatus.getSelectedItem().toString();
        RowFilter<DefaultTableModel, Object> rf = null;
        try {
            // Bộ lọc tìm kiếm theo cột Mã NV (index 1)
            RowFilter<DefaultTableModel, Object> rf1 = RowFilter.regexFilter("(?i)" + searchText, 1);
            // Bộ lọc theo trạng thái ở cột "Trạng Thái" (index 6)
            RowFilter<DefaultTableModel, Object> rf2 = null;
            if (!statusFilter.equals("Tất cả")) {
                rf2 = RowFilter.regexFilter(statusFilter, 6);
            }
            if (rf2 != null) {
                rf = RowFilter.andFilter(java.util.Arrays.asList(rf1, rf2));
            } else {
                rf = rf1;
            }
        } catch (Exception e) {
            return;
        }
        sorter.setRowFilter(rf);
    }
}
