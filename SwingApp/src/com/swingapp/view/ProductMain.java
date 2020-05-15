/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swingapp.view;

import com.swingapp.product.model.ProductDAO;
import com.swingapp.product.model.ProductDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.plaf.TabbedPaneUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author STU-03
 */
public class ProductMain extends javax.swing.JFrame implements ItemListener{
    private String[] colNames = {"번호", "상품명","가격"};
    private DefaultTableModel model;
    private ProductDAO dao;
    /**
     * Creates new form ProductMain
     */
    public ProductMain() {
        initComponents();
        init();
        addEvent();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        group = new javax.swing.ButtonGroup();
        taId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        btAdd = new javax.swing.JButton();
        btEdit = new javax.swing.JButton();
        btDel = new javax.swing.JButton();
        btExit = new javax.swing.JButton();
        tabbedPane = new javax.swing.JTabbedPane();
        tab1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        tfNo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfPdName = new javax.swing.JTextField();
        tfPrice = new javax.swing.JTextField();
        tfRegdate = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taDesc = new javax.swing.JTextArea();
        tab2 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        rdPdName = new javax.swing.JRadioButton();
        rdPrice = new javax.swing.JRadioButton();
        cbPdName = new javax.swing.JComboBox<>();
        tfPrice1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfPrice2 = new javax.swing.JTextField();
        btSearch = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        tfId = new javax.swing.JTextField();

        jLabel5.setText("아이디");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("상품관리");

        jToolBar1.setRollover(true);

        btAdd.setText("등록");
        btAdd.setFocusable(false);
        btAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });
        jToolBar1.add(btAdd);

        btEdit.setText("수정");
        btEdit.setFocusable(false);
        btEdit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btEdit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btEdit);

        btDel.setText("삭제");
        btDel.setFocusable(false);
        btDel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btDel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btDel);

        btExit.setText("종료");
        btExit.setFocusable(false);
        btExit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btExit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btExit);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "번호", "상품명", "가격"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);

        jLabel1.setText("상품번호");

        tfNo.setEditable(false);

        jLabel2.setText("상품명");

        jLabel3.setText("가격");

        jLabel4.setText("등록일");

        tfRegdate.setEditable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("상품설명"));

        taDesc.setColumns(20);
        taDesc.setLineWrap(true);
        taDesc.setRows(5);
        jScrollPane2.setViewportView(taDesc);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout tab1Layout = new javax.swing.GroupLayout(tab1);
        tab1.setLayout(tab1Layout);
        tab1Layout.setHorizontalGroup(
            tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tab1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfRegdate)
                            .addComponent(tfPrice)
                            .addComponent(tfPdName)
                            .addComponent(tfNo)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(565, 565, 565))
        );
        tab1Layout.setVerticalGroup(
            tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(tab1Layout.createSequentialGroup()
                        .addGroup(tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tfNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tfPdName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tfPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tfRegdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        tabbedPane.addTab("상품등록", tab1);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("조회조건"));

        group.add(rdPdName);
        rdPdName.setSelected(true);
        rdPdName.setText("상품명으로 검색");

        group.add(rdPrice);
        rdPrice.setText("가격으로 검색");

        cbPdName.setMaximumRowCount(6);
        cbPdName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setText(" ~ ");

        btSearch.setText("검색");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rdPrice)
                        .addGap(18, 18, 18)
                        .addComponent(tfPrice1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfPrice2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSearch))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rdPdName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbPdName, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdPdName)
                    .addComponent(cbPdName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdPrice)
                    .addComponent(tfPrice1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(tfPrice2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSearch))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "번호", "상품명", "가격", "설명", "등록일"
            }
        ));
        jScrollPane3.setViewportView(table2);

        javax.swing.GroupLayout tab2Layout = new javax.swing.GroupLayout(tab2);
        tab2.setLayout(tab2Layout);
        tab2Layout.setHorizontalGroup(
            tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
        );
        tab2Layout.setVerticalGroup(
            tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab2Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabbedPane.addTab("상품검색", tab2);

        jLabel6.setText("아이디 : ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 674, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabbedPane)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        try {
            addPd();
            clear_tf();
            showAll();
        } catch (SQLException ex) {
            Logger.getLogger(ProductMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btAddActionPerformed

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
            java.util.logging.Logger.getLogger(ProductMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btDel;
    private javax.swing.JButton btEdit;
    private javax.swing.JButton btExit;
    private javax.swing.JButton btSearch;
    private javax.swing.JComboBox<String> cbPdName;
    private javax.swing.ButtonGroup group;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JRadioButton rdPdName;
    private javax.swing.JRadioButton rdPrice;
    private javax.swing.JTextArea taDesc;
    private javax.swing.JTextField taId;
    private javax.swing.JPanel tab1;
    private javax.swing.JPanel tab2;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JTable table;
    private javax.swing.JTable table2;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfNo;
    private javax.swing.JTextField tfPdName;
    private javax.swing.JTextField tfPrice;
    private javax.swing.JTextField tfPrice1;
    private javax.swing.JTextField tfPrice2;
    private javax.swing.JTextField tfRegdate;
    // End of variables declaration//GEN-END:variables

    private void init() {
        dao = new ProductDAO();
        model = new DefaultTableModel();
        
        try {
            showAll();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }

    private void showAll() throws SQLException {
        //1
        //2. db
        ArrayList<ProductDTO> list = dao.selectAll();
        //3
        if(list == null || list.isEmpty()){
            JOptionPane.showMessageDialog(this, "데이터가 없습니다.");
            return;
        }
        
        DecimalFormat df = new DecimalFormat("#,###");
        // table에 db에서 읽어온 데이터를 출력해야 한다
        //1) String 2차원 배열이 필요함
        String[][] data = new String[list.size()][3];
        for (int i = 0; i < list.size(); i++) {
            ProductDTO dto = list.get(i);
            
            //2) 2차원 배열에 dto의 값을 넣는다.
            int no = dto.getNo();
            String pdname = dto.getProductName();
           int price =  dto.getPrice();
            
            data[i][0] = no + "";
            data[i][1] = pdname;
            data[i][2] = df.format(price);
        }
        
        //3) model에 2차원 배열의 데이터를 넣는다.
        model.setDataVector(data, colNames);
        
        //4) table에 model을 연결해서 보이게 한다.
        table.setModel(model);
        
        //각 컬럼 사이즈 조절하기
        table.getColumnModel().getColumn(0).setPreferredWidth(40);
        table.getColumnModel().getColumn(1).setPreferredWidth(120);
        
        //가격 오른쪽 정렬하기
        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
        dtcr.setHorizontalAlignment(SwingConstants.RIGHT);
        table.getColumnModel().getColumn(2).setCellRenderer(dtcr);
        
    }
    private void addPd() throws SQLException{
        //1
        String pdName = tfPdName.getText();
        String price = tfPrice.getText();
        String pdDesc = taDesc.getText();
        
        if(pdName == null || pdName.isEmpty()){
            JOptionPane.showMessageDialog(this, "상품명을 입력해야 합니다!");
            tfPdName.requestFocus();
            return;
        }
       
        //2 db
        ProductDTO dto = new ProductDTO();
        dto.setProductName(pdName);
        dto.setPrice(Integer.parseInt(price));
        dto.setDescription(pdDesc);
        
        int cnt = dao.insertPd(dto);
        
        //3
        String result = "";
        if(cnt>0){
            result = "상품 등록되었습니다.";
        }else{
            result = "상품 등록 실패";
        }
        JOptionPane.showMessageDialog(this, result);
    }

    private void clear_tf() {
        tfPdName.setText("");
        tfNo.setText("");
        tfPrice.setText("");
        tfRegdate.setText("");
        taDesc.setText("");
    }
    
    /** Event 연결
     * 
     */
    private void addEvent() {
        table.addMouseListener(new EventHandler());
        btEdit.addActionListener(new EventHandler());
        
        cbPdName.addItemListener(this);
        
        tabbedPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JTabbedPane tpane = (JTabbedPane)e.getSource();
                int index = tpane.getSelectedIndex();
                System.out.println("선택한 index=" + index);
                
                if(index == 0){
                    clear_tf();
                    try {
                        showAll();
                    } catch (SQLException sQLException) {
                        sQLException.printStackTrace();
                    }
                }else if ( index == 1){
                    clear_if2();
                }
            }

        
            
        });
    }
     private void clear_if2() {
        rdPdName.setSelected(true);
        tfPrice1.setText("");
        tfPrice2.setText("");
        
        //상품명조회해서 콤보박스에 출력
        showPdName();
    }

    private void showPdName() {
        try {
            //1
            //2
            Vector<String> vec = dao.selectPdName();
            //3
            DefaultComboBoxModel<String> dcb = new DefaultComboBoxModel<>(vec);
            cbPdName.setModel(dcb);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        //콤보박스가 선택되면 상품명으로 검색 라디오버튼이 자동으로
        // 선택되도록 설정
        if(e.getSource() == cbPdName){
            if (e.getStateChange() == ItemEvent.SELECTED) {
                rdPdName.setSelected(true);
            }
        }
    }
    
    class EventHandler extends MouseAdapter implements ActionListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            int row = table.getSelectedRow();
            String str = (String)table.getValueAt(row, 0);
            
            try {
                //no에 해당하는 레코드 조회
                //db작업
                ProductDTO dto = dao.selectByNo(Integer.parseInt(str));
                
                tfNo.setText(dto.getNo() + "");
                tfPdName.setText(dto.getProductName());
                tfPrice.setText(dto.getPrice() + "");
                taDesc.setText(dto.getDescription());
                tfRegdate.setText(dto.getRegDate() + "");
                
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            
            try {
                if (e.getSource() == btEdit) {
                    editProduct();
                } else if (e.getSource() == btDel) {
                    delProduct();
                }
            } catch (SQLException sQLException) {
                sQLException.printStackTrace();
            }
            
        }

        private void editProduct() throws SQLException {
            //1
            String no = tfNo.getText();
            String pdNmae = tfPdName.getText();
            String price = tfPrice.getText();
            String desc = taDesc.getText();
            
            if(no == null || no.isEmpty()){
                JOptionPane.showMessageDialog(ProductMain.this, "번호가 선택되도록 하세요!");
                return;
            }
            if(pdNmae == null || pdNmae.isEmpty()){
                JOptionPane.showMessageDialog(ProductMain.this, "상품명을 입력하세요!");
                return;
            }
            
            //2
            ProductDTO dto = new ProductDTO();
            
            dto.setDescription(desc);
            dto.setNo(Integer.parseInt(no));
            dto.setPrice(Integer.parseInt(price));
            dto.setProductName(pdNmae);
            
            int cnt = dao.editProduct(dto);
            
            //3
            if(cnt>0){
                JOptionPane.showMessageDialog(ProductMain.this, "수정 완료!");
            }else{
                JOptionPane.showMessageDialog(ProductMain.this, "수정 실패!");
            }
           
        }
        private void delProduct() {
            
        }
        
    }
}
