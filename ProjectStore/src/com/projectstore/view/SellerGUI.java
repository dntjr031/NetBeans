/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectstore.view;

import com.model.panmae.PanmaeDAO;
import com.model.panmae.PanmaeDTO;
import com.model.seller.SellerDAO;
import com.model.seller.SellerDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author STU-03
 */
public class SellerGUI extends javax.swing.JFrame implements ActionListener {

    private StoreMainGUI storeMainGUI;

    private String userId;
    private final boolean UPDATE = true, DETAIL = false;
    private SellerDAO daoSel = new SellerDAO();
    private ArrayList<SellerDTO> listSel;
    private ArrayList<PanmaeDTO> listPanmae;
    private PanmaeDAO daoPanmae = new PanmaeDAO();
    private String[] colSel = {"아이디", "이름", "핸드폰번호", "성별", "고용날짜"};
    private String[] colPan = {"판매원 아이디", "상품코드", "가격", "거래날짜"};
    private DefaultTableModel modelSel = new DefaultTableModel();
    private DefaultTableModel modelPanmae = new DefaultTableModel();

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private int totalPrice = 0;

    /**
     * Creates new form CustomerGUI
     */
    public SellerGUI() {
        initComponents();
        init();
        addEvent();
    }

    SellerGUI(StoreMainGUI aThis) {
        this();
        this.storeMainGUI = aThis;
        if (!storeMainGUI.selId.equals("admin")) {
            btDelete.setEnabled(false);
            btInsert.setEnabled(false);
        }
        userId = aThis.selId;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablesel = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablepan = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfselName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfTotal = new javax.swing.JTextField();
        btInsert = new javax.swing.JButton();
        btDetail = new javax.swing.JButton();
        btUpdate = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        tfSearch = new javax.swing.JTextField();
        btSearch = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        btClose = new javax.swing.JButton();
        btSearchAll = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("판매원 관리");
        setResizable(false);

        tablesel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "아이디", "이름", "핸드폰 번호", "성별", "고용 날짜"
            }
        ));
        jScrollPane1.setViewportView(tablesel);

        tablepan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "판매원 이름", "상품 코드", "가격", "판매 날짜"
            }
        ));
        jScrollPane2.setViewportView(tablepan);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("이름 : ");

        tfselName.setEditable(false);

        jLabel2.setText("총 판매금액 :");

        tfTotal.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfselName, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                    .addComponent(tfTotal))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfselName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        btInsert.setText("판매원등록");

        btDetail.setText("상세정보");

        btUpdate.setText("정보수정");

        jLabel3.setText("이름 : ");

        btSearch.setText("검색");

        btDelete.setText("판매원삭제");

        btClose.setText("닫기");

        btSearchAll.setText("전체조회");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btInsert)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btDetail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btDelete))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btSearchAll)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btSearch))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btClose, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btSearch)
                        .addComponent(jLabel3)
                        .addComponent(btClose))
                    .addComponent(btSearchAll))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SellerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SellerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SellerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SellerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SellerGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btClose;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btDetail;
    private javax.swing.JButton btInsert;
    private javax.swing.JButton btSearch;
    private javax.swing.JButton btSearchAll;
    private javax.swing.JButton btUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablepan;
    private javax.swing.JTable tablesel;
    private javax.swing.JTextField tfSearch;
    private javax.swing.JTextField tfTotal;
    private javax.swing.JTextField tfselName;
    // End of variables declaration//GEN-END:variables

    private void addEvent() {
        btClose.addActionListener(this);
        btInsert.addActionListener(this);
        btUpdate.addActionListener(this);
        btDetail.addActionListener(this);
        tablesel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == tablesel) {
                    int row = tablesel.getSelectedRow();
                    String selId = (String) tablesel.getValueAt(row, 0);
                    try {
                        panmaeSelectById(selId);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    tfselName.setText((String) tablesel.getValueAt(row, 1));
                }
            }
        });
        btSearchAll.addActionListener(this);
        btDelete.addActionListener(this);
        btSearch.addActionListener(this);
        tfSearch.addActionListener(this);
    }

    private void init() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        sellerSelectAll();
        panmaeSelectAll();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btClose) {
            dispose();
            storeMainGUI.searchAll();
        } else if (e.getSource() == btInsert) {
            SellerInsertGUI ci = new SellerInsertGUI(this);
            ci.setVisible(true);
            storeMainGUI.searchAll();
        } else if (e.getSource() == btUpdate) {
            int row = tablesel.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "정보를 볼 고객을 선택해야 합니다.");
                return;
            }
            String id = (String) tablesel.getValueAt(row, 0);

            if (userId.equals("admin") || id.equals(userId)) {
                SellerInsertGUI ci = new SellerInsertGUI(id, UPDATE, this);
                ci.setVisible(true);
                storeMainGUI.searchAll();
            }else {
                JOptionPane.showMessageDialog(this, "admin 계정만 다른 판매원 정보수정이 가능합니다.");
            }

        } else if (e.getSource() == btDetail) {
            int row = tablesel.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "정보를 볼 고객을 선택해야 합니다.");
                return;
            }
            String id = (String) tablesel.getValueAt(row, 0);
            SellerInsertGUI ci = new SellerInsertGUI(id, DETAIL, this);
            ci.setVisible(true);
        } else if (e.getSource() == btSearchAll) {
            sellerSelectAll();
            panmaeSelectAll();
            textClear();
        } else if (e.getSource() == btSearch || e.getSource()==tfSearch) {
            try {
                sellerSearchByName();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == btDelete) {
            try {
                sellerDelete();
                storeMainGUI.searchAll();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void sellerSelectAll() {
        try {
            listSel = daoSel.selectAll();

            String[][] data = new String[listSel.size()][colSel.length];
            for (int i = 0; i < listSel.size(); i++) {
                SellerDTO dto = listSel.get(i);
                data[i][0] = dto.getSeller_id();
                data[i][1] = dto.getSeller_name();
                data[i][2] = dto.getSeller_hp();
                data[i][4] = dateFormat.format(new Date(dto.getHiredate().getTime()));
                data[i][3] = dto.getSeller_gender();
            }
            modelSel.setDataVector(data, colSel);
            tablesel.setModel(modelSel);
            sellerWidth();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void sellerWidth() {
        tablesel.getColumnModel().getColumn(0).setPreferredWidth(10);
        tablesel.getColumnModel().getColumn(1).setPreferredWidth(10);
        tablesel.getColumnModel().getColumn(2).setPreferredWidth(30);
        tablesel.getColumnModel().getColumn(3).setPreferredWidth(10);
        tablesel.getColumnModel().getColumn(4).setPreferredWidth(30);
    }

    public void panmaeSelectAll() {
        listPanmae = daoPanmae.searchAll();

        String[][] data = new String[listPanmae.size()][colPan.length];
        for (int i = 0; i < listPanmae.size(); i++) {
            PanmaeDTO dto = listPanmae.get(i);

            data[i][0] = dto.getSellerId();
            data[i][1] = dto.getPcode() + "";
            data[i][2] = dto.getPrice() + "";

            data[i][3] = dateFormat.format(new Date(dto.getDate().getTime()));
        }
        modelPanmae.setDataVector(data, colPan);
        tablepan.setModel(modelPanmae);
        panmaeWidth();
    }

    public void panmaeWidth() {
        tablepan.getColumnModel().getColumn(0).setPreferredWidth(10);
        tablepan.getColumnModel().getColumn(1).setPreferredWidth(20);
        tablepan.getColumnModel().getColumn(2).setPreferredWidth(20);
        tablepan.getColumnModel().getColumn(3).setPreferredWidth(10);

    }

    private void panmaeSelectById(String selId) throws SQLException {
        listPanmae = daoPanmae.searchById(selId);
        totalPrice = 0;

        if (listPanmae == null || listPanmae.size() == 0 || listPanmae.isEmpty()) {
            JOptionPane.showMessageDialog(this, "판매내역이 없습니다.");
            textClear();
            return;
        }

        String[][] data = new String[listPanmae.size()][colPan.length];
        for (int i = 0; i < listPanmae.size(); i++) {
            PanmaeDTO dto = listPanmae.get(i);

            data[i][0] = dto.getSellerId();
            data[i][1] = dto.getPcode();
            data[i][2] = dto.getPrice() + "";
            totalPrice += dto.getPrice();
            data[i][3] = dateFormat.format(new Date(dto.getDate().getTime()));
        }
        modelPanmae.setDataVector(data, colPan);
        tablepan.setModel(modelPanmae);
        panmaeWidth();
        sellerWidth();
        tfTotal.setText(totalPrice + "");
    }

    private void textClear() {
        tfSearch.setText("");
        tfselName.setText("");
        tfTotal.setText("0");
    }

    private void sellerSearchByName() throws SQLException {
        String name = tfSearch.getText();
        if (name == null || name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "찾을 이름을 입력하셔야 합니다.");
            tfSearch.requestFocus();
            return;
        }
        listSel = daoSel.selectByName(name);

        String[][] data = new String[listSel.size()][colSel.length];
        for (int i = 0; i < listSel.size(); i++) {
            SellerDTO dto = listSel.get(i);
            data[i][0] = dto.getSeller_id();
            data[i][1] = dto.getSeller_name();
            data[i][2] = dto.getSeller_hp();
            data[i][4] = dateFormat.format(new Date(dto.getHiredate().getTime()));
            data[i][3] = dto.getSeller_gender();
        }
        modelSel.setDataVector(data, colSel);
        tablesel.setModel(modelSel);
        sellerWidth();
    }

    private void sellerDelete() throws SQLException {
        int row = tablesel.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "삭제할 고객을 선택해야 합니다.");
            return;
        }

        int n = JOptionPane.showConfirmDialog(this, "정말 삭제하시겠습니까?", "삭제", JOptionPane.YES_NO_OPTION);

        if (n == JOptionPane.NO_OPTION) {
            return;
        }

        String selId = (String) tablesel.getValueAt(row, 0);
        int n2 = daoSel.delete(selId);

        if (n2 > 0) {
            JOptionPane.showMessageDialog(this, "삭제 완료!");
            sellerSelectAll();
            panmaeSelectAll();
        } else {
            JOptionPane.showMessageDialog(this, "삭제 실패!");
        }
    }
}
