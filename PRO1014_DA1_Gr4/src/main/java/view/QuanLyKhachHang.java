package view;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ChiTietSanPham;
import model.KhachHang;
import pagination.EventPagination;
import pagination.Page;
import pagination.style.PaginationItemRenderStyle1;
import service.impl.KhachHangImpl;
import service.IKhachHangService;

public final class QuanLyKhachHang extends javax.swing.JPanel {

    private static final long serialVersionUID = 1L;

    private final IKhachHangService khSer = new KhachHangImpl();
    private List<KhachHang> kh = new ArrayList<>();
    private List<KhachHang> listKH;

    Integer pageSize = 5;
    Integer totalProducts = 0;
    private Page paging = new Page();

    private List<KhachHang> listPaging = new ArrayList<>();

    public QuanLyKhachHang() {
        initComponents();
//        loadKhachHang();

        loadPagination();
        pagination11.setPaginationItemRender(new PaginationItemRenderStyle1());
        pagination11.setPagegination(1, paging.getTotalPage());
    }

    public void loadPagination() {
        String search = txtSearch.getText();

        totalProducts = khSer.filterKhachHang(search).size();

        int total = (int) Math.ceil(totalProducts / pageSize) + 1;
        paging.setTotalPage(total);
        pagination11.setPagegination(1, paging.getTotalPage());

        if (paging.getTotalPage() < paging.getCurrent()) {
            pagination11.setPagegination(paging.getTotalPage(), paging.getTotalPage());
            loadTable(khSer.pageListKhachHang(paging.getTotalPage(), pageSize, search));
        } else {
            pagination11.setPagegination(paging.getCurrent(), paging.getTotalPage());
            loadTable(khSer.pageListKhachHang(paging.getCurrent(), pageSize, search));
        }

        pagination11.addEventPagination((int page) -> {
            loadTable(khSer.pageListKhachHang(page, pageSize, search));
            paging.setCurrent(page);
        });
        lbTotalKhachHang.setText("Total: " + khSer.getSumCustomer());
    }

    public void loadTable(List<KhachHang> kh) {
        DefaultTableModel dtm = (DefaultTableModel) tbKhachHang.getModel();
        dtm.setRowCount(0);

        for (KhachHang x : kh) {
            Object[] rowData = {
                x.getId(), x.getMaKH(), x.getTenKH(), x.getGioiTinh() == true ? "Nam" : "Nữ", x.getDiaChi(),
                x.getSdt(), x.getEmail(), x.getTrangThai() == 1 ? "Đang hoạt động" : "Dừng hoạt động"
            };
            dtm.addRow(rowData);
        }
    }

    void loadKhachHang() {
        DefaultTableModel model = (DefaultTableModel) tbKhachHang.getModel();
        model.setRowCount(0);
        kh = new KhachHangImpl().getAll();
        for (KhachHang x : kh) {
            model.addRow(x.toDataRow());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        msgSdt = new javax.swing.JLabel();
        msgTen = new javax.swing.JLabel();
        msgDiaChi1 = new javax.swing.JLabel();
        msgEmail1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        lbTotalKhachHang = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbKhachHang = new swing.table.Table();
        pagination11 = new pagination.Pagination();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(QuanLyKhachHang.class, "QuanLyKhachHang.jPanel2.border.title"))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(204, 255, 255));

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(QuanLyKhachHang.class, "QuanLyKhachHang.jLabel1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(QuanLyKhachHang.class, "QuanLyKhachHang.jLabel2.text")); // NOI18N

        txtMa.setEditable(false);
        txtMa.setText(org.openide.util.NbBundle.getMessage(QuanLyKhachHang.class, "QuanLyKhachHang.txtMa.text")); // NOI18N
        txtMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaActionPerformed(evt);
            }
        });

        txtTen.setText(org.openide.util.NbBundle.getMessage(QuanLyKhachHang.class, "QuanLyKhachHang.txtTen.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(QuanLyKhachHang.class, "QuanLyKhachHang.jLabel3.text")); // NOI18N

        buttonGroup1.add(rdoNam);
        rdoNam.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(rdoNam, org.openide.util.NbBundle.getMessage(QuanLyKhachHang.class, "QuanLyKhachHang.rdoNam.text")); // NOI18N

        buttonGroup1.add(rdoNu);
        org.openide.awt.Mnemonics.setLocalizedText(rdoNu, org.openide.util.NbBundle.getMessage(QuanLyKhachHang.class, "QuanLyKhachHang.rdoNu.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(QuanLyKhachHang.class, "QuanLyKhachHang.jLabel4.text")); // NOI18N

        txtDiaChi.setText(org.openide.util.NbBundle.getMessage(QuanLyKhachHang.class, "QuanLyKhachHang.txtDiaChi.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(QuanLyKhachHang.class, "QuanLyKhachHang.jLabel5.text")); // NOI18N

        txtSDT.setText(org.openide.util.NbBundle.getMessage(QuanLyKhachHang.class, "QuanLyKhachHang.txtSDT.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel6, org.openide.util.NbBundle.getMessage(QuanLyKhachHang.class, "QuanLyKhachHang.jLabel6.text")); // NOI18N

        txtEmail.setText(org.openide.util.NbBundle.getMessage(QuanLyKhachHang.class, "QuanLyKhachHang.txtEmail.text")); // NOI18N

        btnAdd.setBackground(new java.awt.Color(0, 153, 204));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        org.openide.awt.Mnemonics.setLocalizedText(btnAdd, org.openide.util.NbBundle.getMessage(QuanLyKhachHang.class, "QuanLyKhachHang.btnAdd.text")); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(0, 153, 204));
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        org.openide.awt.Mnemonics.setLocalizedText(btnSua, org.openide.util.NbBundle.getMessage(QuanLyKhachHang.class, "QuanLyKhachHang.btnSua.text")); // NOI18N
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(0, 153, 204));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        org.openide.awt.Mnemonics.setLocalizedText(btnXoa, org.openide.util.NbBundle.getMessage(QuanLyKhachHang.class, "QuanLyKhachHang.btnXoa.text")); // NOI18N
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnClear.setBackground(new java.awt.Color(0, 153, 204));
        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        org.openide.awt.Mnemonics.setLocalizedText(btnClear, org.openide.util.NbBundle.getMessage(QuanLyKhachHang.class, "QuanLyKhachHang.btnClear.text")); // NOI18N
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        msgSdt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(msgSdt, org.openide.util.NbBundle.getMessage(QuanLyKhachHang.class, "QuanLyKhachHang.msgSdt.text")); // NOI18N

        msgTen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(msgTen, org.openide.util.NbBundle.getMessage(QuanLyKhachHang.class, "QuanLyKhachHang.msgTen.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(msgDiaChi1, org.openide.util.NbBundle.getMessage(QuanLyKhachHang.class, "QuanLyKhachHang.msgDiaChi1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(msgEmail1, org.openide.util.NbBundle.getMessage(QuanLyKhachHang.class, "QuanLyKhachHang.msgEmail1.text")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(602, 602, 602)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(29, 29, 29)
                                        .addComponent(rdoNam)
                                        .addGap(28, 28, 28)
                                        .addComponent(rdoNu))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2))
                                        .addGap(38, 38, 38)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(68, 68, 68))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(msgTen, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(msgDiaChi1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtSDT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(msgEmail1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                                .addComponent(msgSdt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 21, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(8, 8, 8))
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(msgDiaChi1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(msgTen, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(msgSdt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(rdoNam)
                    .addComponent(rdoNu)
                    .addComponent(jLabel6)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(msgEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(QuanLyKhachHang.class, "QuanLyKhachHang.jPanel3.border.title"))); // NOI18N

        txtSearch.setText(org.openide.util.NbBundle.getMessage(QuanLyKhachHang.class, "QuanLyKhachHang.txtSearch.text")); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearch)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        lbTotalKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbTotalKhachHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        org.openide.awt.Mnemonics.setLocalizedText(lbTotalKhachHang, org.openide.util.NbBundle.getMessage(QuanLyKhachHang.class, "QuanLyKhachHang.lbTotalKhachHang.text")); // NOI18N

        tbKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Mã KH", "Tên KH", "Giới tính", "Địa chỉ", "Điện thoại", "Email", "Trạng thái"
            }
        ));
        tbKhachHang.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        tbKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbKhachHangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbKhachHang);
        if (tbKhachHang.getColumnModel().getColumnCount() > 0) {
            tbKhachHang.getColumnModel().getColumn(0).setHeaderValue(org.openide.util.NbBundle.getMessage(QuanLyKhachHang.class, "QuanLyKhachHang.tbKhachHang.columnModel.title0")); // NOI18N
            tbKhachHang.getColumnModel().getColumn(1).setHeaderValue(org.openide.util.NbBundle.getMessage(QuanLyKhachHang.class, "QuanLyKhachHang.tbKhachHang.columnModel.title1")); // NOI18N
            tbKhachHang.getColumnModel().getColumn(2).setHeaderValue(org.openide.util.NbBundle.getMessage(QuanLyKhachHang.class, "QuanLyKhachHang.tbKhachHang.columnModel.title2")); // NOI18N
            tbKhachHang.getColumnModel().getColumn(3).setHeaderValue(org.openide.util.NbBundle.getMessage(QuanLyKhachHang.class, "QuanLyKhachHang.tbKhachHang.columnModel.title3")); // NOI18N
            tbKhachHang.getColumnModel().getColumn(4).setHeaderValue(org.openide.util.NbBundle.getMessage(QuanLyKhachHang.class, "QuanLyKhachHang.tbKhachHang.columnModel.title4")); // NOI18N
            tbKhachHang.getColumnModel().getColumn(5).setHeaderValue(org.openide.util.NbBundle.getMessage(QuanLyKhachHang.class, "QuanLyKhachHang.tbKhachHang.columnModel.title5")); // NOI18N
            tbKhachHang.getColumnModel().getColumn(6).setHeaderValue(org.openide.util.NbBundle.getMessage(QuanLyKhachHang.class, "QuanLyKhachHang.tbKhachHang.columnModel.title6")); // NOI18N
            tbKhachHang.getColumnModel().getColumn(7).setHeaderValue(org.openide.util.NbBundle.getMessage(QuanLyKhachHang.class, "QuanLyKhachHang.tbKhachHang.columnModel.title7")); // NOI18N
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(868, 868, 868)
                                .addComponent(pagination11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(405, 405, 405)
                                .addComponent(lbTotalKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1586, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbTotalKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pagination11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        pagination11.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(QuanLyKhachHang.class, "QuanLyKhachHang.pagination11.AccessibleContext.accessibleDescription")); // NOI18N

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbKhachHangMouseClicked
        int row = tbKhachHang.getSelectedRow();
        listKH = khSer.pageListKhachHang(paging.getCurrent(), pageSize, txtSearch.getText());
        KhachHang kh = listKH.get(row);
        txtMa.setText(kh.getMaKH());
        txtTen.setText(kh.getTenKH());
        txtDiaChi.setText(kh.getDiaChi());
        txtSDT.setText(kh.getSdt());
        txtEmail.setText(kh.getEmail());

        Boolean gioiTinh = kh.getGioiTinh();
        if (gioiTinh == true) {
            rdoNam.setSelected(true);
        } else {
            rdoNu.setSelected(true);
        }
    }//GEN-LAST:event_tbKhachHangMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        KhachHang a = this.validateForm();
        if (a != null) {
            int chooser = JOptionPane.showConfirmDialog(this, "Bạn muốn thêm khách hàng mới ?");
            if (chooser == 0) {
                khSer.add(a);
                loadPagination();
                reset();
                JOptionPane.showMessageDialog(this, "Thêm thành công");
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int row = tbKhachHang.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Ban chua chon dong");
            return;
        }
        Integer id = (Integer) tbKhachHang.getValueAt(row, 0);
        KhachHang a = validateForm();
        a.setMaKH((String) tbKhachHang.getValueAt(row, 1));

        if (validateForm() != null) {
            int chooser = JOptionPane.showConfirmDialog(this, "Bạn muốn sửa thông tin khách hàng ?");
            if (chooser == 0) {
                String result = new KhachHangImpl().update(a, id);
                JOptionPane.showMessageDialog(this, result);
                loadPagination();
                reset();
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int row = tbKhachHang.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Ban chua chon dong");
            return;
        } else {

        }
        Integer id = (Integer) tbKhachHang.getValueAt(row, 0);
        int chooser = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa khách hàng?");
        if (chooser == 0) {
            String result = new KhachHangImpl().updateTrangThai(id);
            JOptionPane.showMessageDialog(this, result);
            loadPagination();
            reset();
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        loadPagination();
    }//GEN-LAST:event_txtSearchKeyReleased

    private void reset() {
        txtMa.setText("");
        txtTen.setText("");
        txtSDT.setText("");
        txtEmail.setText("");
        txtDiaChi.setText("");
        buttonGroup1.clearSelection();
        msgDiaChi1.setText("");
        msgEmail1.setText("");
        msgSdt.setText("");
        msgTen.setText("");
    }

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        reset();
    }//GEN-LAST:event_btnClearActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        msgDiaChi1.setText("");
        msgEmail1.setText("");
        msgSdt.setText("");
        msgTen.setText("");
    }//GEN-LAST:event_jPanel1MouseClicked

    private void txtMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaActionPerformed

    void searchByPhone() {
        DefaultTableModel tb = (DefaultTableModel) tbKhachHang.getModel();
        tb.setRowCount(0);
        List<KhachHang> kh = khSer.getAll();
        for (KhachHang x : kh) {
            if (x.getSdt().toLowerCase().contains(txtSearch.getText().trim().toLowerCase())) {
                tb.addRow(x.toDataRow());
            }
        }
    }

    KhachHang findKhachHangByMa(String ma) {
        for (KhachHang a : listKH) {
            if (a.getMaKH().equalsIgnoreCase(ma)) {
                return a;
            }
        }
        return null;
    }

    public KhachHang validateForm() {
        boolean check = true;

        String ma = "";
        ma = "KH" + (khSer.getAllKhachHang().size() + 1);

        String ten = txtTen.getText();
        if (ten.isBlank()) {
            msgTen.setText("Không được bỏ trống tên");
            msgTen.setForeground(Color.red);
            txtTen.requestFocus();
            check = false;
        } else {
            msgTen.setText("");
        }

        String diaChi = txtDiaChi.getText();
        if (diaChi.isBlank()) {
            msgDiaChi1.setText("Không được bỏ trống địa chỉ");
            msgDiaChi1.setForeground(Color.red);
            check = false;
        } else {
            msgDiaChi1.setText("");
        }

        String sdt = txtSDT.getText();
        Pattern sodienthoai = Pattern.compile("^0+[1-9]{9}$");
        Matcher matcherFirst = sodienthoai.matcher(sdt);
        if (sdt.isBlank()) {
            msgSdt.setText("Không được bỏ trống số điện thoại");
            msgSdt.setForeground(Color.red);
            check = false;
        } else {

            if (!matcherFirst.matches()) {
                msgSdt.setText("Số điện thoại phải 10 số");
                msgSdt.setForeground(Color.red);
                check = false;
            } else {
                msgSdt.setText("");
            }
        }

        String email = txtEmail.getText();
        Pattern maiL = Pattern.compile("^(.+)@(.+)$");
        Matcher matcherEmail = maiL.matcher(email);
        if (email.isBlank()) {
            msgEmail1.setText("Không được bỏ trống Email");
            msgEmail1.setForeground(Color.red);
            check = false;
        } else {
            if (!matcherEmail.matches()) {
                msgEmail1.setText("Sai định dạng email");
                msgEmail1.setForeground(Color.red);
                check = false;
            } else {
                msgEmail1.setText("");
            }
        }

        boolean gioiTinh;
        if (rdoNam.isSelected()) {
            gioiTinh = true;
        } else {
            gioiTinh = false;
        }

        int trangThai = 1;

        KhachHang khachHang = null;
        if (check == true) {
            khachHang = new KhachHang(0, ma, ten, gioiTinh, diaChi, sdt, email, trangThai);
        }
        return khachHang;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbTotalKhachHang;
    private javax.swing.JLabel msgDiaChi1;
    private javax.swing.JLabel msgEmail1;
    private javax.swing.JLabel msgSdt;
    private javax.swing.JLabel msgTen;
    private pagination.Pagination pagination11;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private swing.table.Table tbKhachHang;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
