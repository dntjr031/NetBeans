/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectstore.view;

import com.model.account.AccDAO;
import com.model.account.AccDTO;
import com.model.item.ItemDAO;
import com.model.item.ItemDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 상세정보, 수정 누르면 값 들어가게 수정해야함
 * @author STU-03
 */
public class AccountInsertGUI extends javax.swing.JFrame implements ActionListener {

    private String accCode;
    private AccDAO dao = new AccDAO();
    private ItemDAO daoitem = new ItemDAO();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private AccountGUI accountGUI = null;
    private boolean IdCheck = false;

    /**
     * Creates new form CustomerInsert
     */
    public AccountInsertGUI() {
        initComponents();
        init();
        addEvent();
    }

    AccountInsertGUI(AccountGUI accountGUI) {
        this();
        this.accountGUI = accountGUI;
    }

    AccountInsertGUI(String accCode, boolean state, AccountGUI accountGUI) {
        this();
        this.accCode = accCode;
        this.accountGUI = accountGUI;
        try {
            if (state) {
                detailSearch();
                updateTextSet();
                setTitle("거래처 정보 수정");
            } else {
                detailSearch();
                detailTextSet();
                setTitle("거래처 상세정보");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
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

        jLabel1 = new javax.swing.JLabel();
        tfAccCode = new javax.swing.JTextField();
        tfAccName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfTel2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfZipcode = new javax.swing.JTextField();
        btAddress = new javax.swing.JButton();
        tfAddress1 = new javax.swing.JTextField();
        tfAddress2 = new javax.swing.JTextField();
        btAdd = new javax.swing.JButton();
        btCancle = new javax.swing.JButton();
        tfRepName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btDup = new javax.swing.JButton();
        tfTel1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbTel = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cbItemName = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("거래처 등록");
        setResizable(false);

        jLabel1.setText("업체 코드");

        jLabel2.setText("업체 명");

        jLabel3.setText("연락처");

        jLabel5.setText("담당자 명");

        btAddress.setText("주소검색");

        btAdd.setText("등록");

        btCancle.setText("닫기");

        jLabel6.setText("우편번호");

        btDup.setText("중복검사");

        jLabel7.setText(" - ");

        cbTel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "010", "011", "070" }));

        jLabel8.setText(" - ");

        jLabel12.setText("주소");

        jLabel13.setText("나머지 주소");

        cbItemName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "선택하세요" }));

        jLabel14.setText("품목 명");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfAccCode, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btDup))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfAccName, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel6)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfZipcode, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btAddress)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfAddress1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfAddress2))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfTel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfTel2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfRepName, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(cbItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(btCancle, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfAccCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDup, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfAccName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfRepName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfTel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(cbTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfZipcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(btAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfAddress1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfAddress2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbItemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAdd)
                    .addComponent(btCancle)))
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
            java.util.logging.Logger.getLogger(AccountInsertGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccountInsertGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccountInsertGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccountInsertGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccountInsertGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btAddress;
    private javax.swing.JButton btCancle;
    private javax.swing.JButton btDup;
    private javax.swing.JComboBox<String> cbItemName;
    private javax.swing.JComboBox<String> cbTel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField tfAccCode;
    private javax.swing.JTextField tfAccName;
    public javax.swing.JTextField tfAddress1;
    private javax.swing.JTextField tfAddress2;
    private javax.swing.JTextField tfRepName;
    private javax.swing.JTextField tfTel1;
    private javax.swing.JTextField tfTel2;
    public javax.swing.JTextField tfZipcode;
    // End of variables declaration//GEN-END:variables

    private void init() {

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        comboItem();
        cbItemName.setSelectedItem("선택하세요");

        btAdd.setText("등록");
    }

    private void addEvent() {
        btCancle.addActionListener(this);
        btAdd.addActionListener(this);
        btAddress.addActionListener(this);
        btDup.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btCancle) {
            dispose();
        } else if (e.getSource() == btAddress) {
            SubZipcode s = new SubZipcode(this);
            s.setVisible(true);
        } else if (e.getSource() == btAdd) {
            if (btAdd.getText().equals("수정")) {
                try {
                    update();
                    dispose();
                    accountGUI.accSelectAll();
                    accountGUI.mgrSelectAll();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            } else if (btAdd.getText().equals("등록")) {
                try {
                    insert();
                    accountGUI.accSelectAll();
                    accountGUI.mgrSelectAll();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } else if (e.getSource() == btDup) {
            try {
                idDup();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void detailTextSet() {
        tfAddress1.setEditable(false);
        tfAddress2.setEditable(false);
        tfRepName.setEditable(false);
        tfAccCode.setEditable(false);
        tfAccName.setEditable(false);
        tfTel1.setEditable(false);
        tfTel2.setEditable(false);
        tfZipcode.setEditable(false);

        cbTel.setEnabled(false);
        cbItemName.setEnabled(false);

        btAddress.setEnabled(false);
        btDup.setEnabled(false);
        btAdd.setEnabled(false);
    }

    private void detailSearch() throws SQLException {
        AccDTO dto = dao.selectByCode(accCode);
        tfAccCode.setText(accCode);
        tfAccName.setText(dto.getAccName());
        tfRepName.setText(dto.getRepName());
        tfZipcode.setText(dto.getZipcode());
        tfAddress1.setText(dto.getAddress1());
        tfAddress2.setText(dto.getAddress2());

        String tel = dto.getHp();
        if (tel != null && !tel.isEmpty()) {
            String tel1 = tel.substring(0, tel.indexOf("-"));
            String tel2 = tel.substring(tel.indexOf("-") + 1, tel.lastIndexOf("-"));
            String tel3 = tel.substring(tel.lastIndexOf("-") + 1);

            cbTel.setSelectedItem(tel1);
            tfTel1.setText(tel2);
            tfTel2.setText(tel3);
        }
        
        ItemDTO dtoitem = daoitem.selectByCode(dto.getItemCode());
        cbItemName.setSelectedItem(dtoitem.getName());
    }

    private void updateTextSet() {
        btAdd.setText("수정");
        tfAccCode.setEditable(false);
        tfAccName.setEditable(false);
        btDup.setEnabled(false);
    }

    private void update() throws SQLException {
        String repName = tfRepName.getText();
        
        if(repName == null || repName.isEmpty()){
            JOptionPane.showMessageDialog(this, "담당자 이름을 입력하셔야 합니다.");
            tfRepName.requestFocus();
            return;
        }
        
        String tel1 = (String) cbTel.getSelectedItem();
        String tel2 = tfTel1.getText();
        String tel3 = tfTel2.getText();

        String tel = "";
        if (tel2 != null && !tel2.isEmpty()) {
            if (tel3 != null && !tel3.isEmpty()) {
                tel = tel1 + "-" + tel2 + "-" + tel3;
            }
        }
        String itemName = (String) cbItemName.getSelectedItem();
        ItemDTO dtoitem = daoitem.selectByName(itemName);
        String itemCode = dtoitem.getCode();
        
        if(itemCode.isEmpty() || itemCode == null){
            JOptionPane.showMessageDialog(this, "품목을 선택하셔야 합니다.");
            return;
        }
        
        AccDTO dto = new AccDTO();
        
        dto.setZipcode(tfZipcode.getText());
        dto.setAddress1(tfAddress1.getText());
        dto.setAddress2(tfAddress2.getText());
        dto.setHp(tel);
        dto.setRepName(repName);
        dto.setItemCode(itemCode);
        dto.setCode(tfAccCode.getText());

        int n = dao.update(dto);
        if (n > 0) {
            JOptionPane.showMessageDialog(this, "수정완료!");
        } else {
            JOptionPane.showMessageDialog(this, "수정실패!");
        }
    }

    private void insert() throws SQLException {
        AccDTO dto = new AccDTO();

        String tel1 = (String) cbTel.getSelectedItem();
        String tel2 = tfTel1.getText();
        String tel3 = tfTel2.getText();

        String tel = "";
        if (tel2 != null && !tel2.isEmpty()) {
            if (tel3 != null && !tel3.isEmpty()) {
                tel = tel1 + "-" + tel2 + "-" + tel3;
            }
        }

        if (!IdCheck) {
            JOptionPane.showMessageDialog(this, "업체코드의 중복체크를 해야 합니다.");
            tfAccCode.requestFocus();
            return;
        }

        String accname = tfAccName.getText();
        if (accname == null || accname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "업체 명을 입력해야 합니다.");
            tfAccName.requestFocus();
            return;
        }
        String accCode = tfAccCode.getText();
        if (accCode == null || accCode.isEmpty()) {
            JOptionPane.showMessageDialog(this, "업체 코드를 입력해야 합니다.");
            tfAccCode.requestFocus();
            return;
        }
        String rep = tfRepName.getText();
        if (rep == null || rep.isEmpty()) {
            JOptionPane.showMessageDialog(this, "담당자 이름을 입력해야 합니다.");
            tfRepName.requestFocus();
            return;
        }
        
        String itemName = (String) cbItemName.getSelectedItem();
        ItemDTO dtoitem = daoitem.selectByName(itemName);
        String itemCode = dtoitem.getCode();
        
        if(itemCode.isEmpty() || itemCode == null){
            JOptionPane.showMessageDialog(this, "품목을 선택하셔야 합니다.");
            return;
        }

        dto.setZipcode(tfZipcode.getText());
        dto.setAddress1(tfAddress1.getText());
        dto.setAddress2(tfAddress2.getText());
        dto.setHp(tel);
        dto.setRepName(rep);
        dto.setAccName(accname);
        dto.setCode(accCode);
        dto.setItemCode(itemCode);

        int n = dao.insert(dto);
        if (n > 0) {
            JOptionPane.showMessageDialog(this, "등록완료!");
        } else {
            JOptionPane.showMessageDialog(this, "등록실패!");
        }
        dispose();
    }

    private void idDup() throws SQLException {
        String id = tfAccCode.getText();
        if (id == null || id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "아이디를 입력하셔야 합니다.");
            tfAccCode.requestFocus();
            return;
        }

        int n = dao.idCheck(id);
        if (n == AccDAO.NO) {
            IdCheck = true;
            tfAccCode.setEditable(false);
        } else {
            IdCheck = false;
        }

        if (IdCheck) {
            JOptionPane.showMessageDialog(this, "사용가능한 아이디입니다.");
        } else {
            JOptionPane.showMessageDialog(this, "이미 사용중인 아이디입니다.");
        }
    }

    private void comboItem() {
        try {
            ItemDAO daoitem = new ItemDAO();
            ArrayList<ItemDTO> itemList;
            itemList = daoitem.selectAll();
            for (int i = 0; i < itemList.size(); i++) {
                System.out.println(itemList.get(i).getName());
                cbItemName.addItem(itemList.get(i).getName());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
