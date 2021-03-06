/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectstore.view;

import com.model.customer.CustomerDAO;
import com.model.customer.CustomerDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author STU-03
 */
public class CustomerInsertGUI extends javax.swing.JFrame implements ActionListener {

    private String userId;
    private CustomerDAO dao = new CustomerDAO();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private CustomerGUI customer = null;
    private boolean IdCheck = false;

    /**
     * Creates new form CustomerInsert
     */
    public CustomerInsertGUI() {
        initComponents();
        init(); // insert 부터 시작!!
        addEvent();
    }

    CustomerInsertGUI(CustomerGUI customer) {
        this();
        this.customer = customer;
    }

    CustomerInsertGUI(String userId, boolean state, CustomerGUI customer) {
        this();
        this.userId = userId;
        this.customer = customer;
        try {
            if (state) {
                detailSearch();
                updateTextSet();
                setTitle("고객 정보 수정");
            } else {
                detailSearch();
                detailTextSet();
                setTitle("고객 상세정보");
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
        tfId = new javax.swing.JTextField();
        tfName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfTel2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfZipcode = new javax.swing.JTextField();
        btAddress = new javax.swing.JButton();
        tfAddress1 = new javax.swing.JTextField();
        tfAddress2 = new javax.swing.JTextField();
        btAdd = new javax.swing.JButton();
        btCancle = new javax.swing.JButton();
        tfGender = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btDup = new javax.swing.JButton();
        tfTel1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbTel = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cbYear = new javax.swing.JComboBox<>();
        cbDay = new javax.swing.JComboBox<>();
        cbMonth = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("고객등록");
        setResizable(false);

        jLabel1.setText("아이디");

        jLabel2.setText("이름");

        jLabel3.setText("핸드폰 번호");

        jLabel4.setText("생일");

        jLabel5.setText("성별");

        btAddress.setText("주소검색");

        btAdd.setText("등록");

        btCancle.setText("닫기");

        jLabel6.setText("우편번호");

        btDup.setText("중복검사");

        jLabel7.setText(" - ");

        cbTel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "010", "011", "070" }));

        jLabel8.setText(" - ");

        cbYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", " ", " " }));

        cbDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", " " }));

        cbMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", " " }));

        jLabel9.setText("년");

        jLabel10.setText("월");

        jLabel11.setText("일");

        jLabel12.setText("주소");

        jLabel13.setText("나머지 주소");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(btAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btCancle, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btDup))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfTel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfTel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel6))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfAddress2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(tfAddress1, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(tfZipcode, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(btAddress)))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfGender, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(10, 10, 10)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDup, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfTel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfTel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(cbTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(cbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAdd)
                    .addComponent(btCancle))
                .addContainerGap())
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
            java.util.logging.Logger.getLogger(CustomerInsertGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerInsertGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerInsertGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerInsertGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerInsertGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btAddress;
    private javax.swing.JButton btCancle;
    private javax.swing.JButton btDup;
    private javax.swing.JComboBox<String> cbDay;
    private javax.swing.JComboBox<String> cbMonth;
    private javax.swing.JComboBox<String> cbTel;
    private javax.swing.JComboBox<String> cbYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JTextField tfAddress1;
    private javax.swing.JTextField tfAddress2;
    private javax.swing.JTextField tfGender;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfTel1;
    private javax.swing.JTextField tfTel2;
    public javax.swing.JTextField tfZipcode;
    // End of variables declaration//GEN-END:variables

    private void init() {

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

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
                    customer.customerSelectAll();
                    customer.panmaeSelectAll();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            } else if (btAdd.getText().equals("등록")) {
                try {
                    insert();
                    customer.customerSelectAll();
                    customer.panmaeSelectAll();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }else if(e.getSource() == btDup){
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
        tfGender.setEditable(false);
        tfId.setEditable(false);
        tfName.setEditable(false);
        tfTel1.setEditable(false);
        tfTel2.setEditable(false);
        tfZipcode.setEditable(false);

        cbDay.setEnabled(false);
        cbMonth.setEnabled(false);
        cbTel.setEnabled(false);
        cbYear.setEnabled(false);

        btAddress.setEnabled(false);
        btDup.setEnabled(false);
        btAdd.setEnabled(false);
    }

    private void detailSearch() throws SQLException {
        CustomerDTO dto = dao.selectById(userId);
        tfId.setText(userId);
        tfName.setText(dto.getName());
        tfGender.setText(dto.getGender());
        tfZipcode.setText(dto.getZipcode());
        tfAddress1.setText(dto.getAddress1());
        tfAddress2.setText(dto.getAddress2());

        String tel = dto.getPh();
        if (tel != null && !tel.isEmpty()) {
            String tel1 = tel.substring(0, tel.indexOf("-"));
            String tel2 = tel.substring(tel.indexOf("-") + 1, tel.lastIndexOf("-"));
            String tel3 = tel.substring(tel.lastIndexOf("-") + 1);

            cbTel.setSelectedItem(tel1);
            tfTel1.setText(tel2);
            tfTel2.setText(tel3);
        }

        String birthday = dateFormat.format(new Date(dto.getBirthday().getTime()));
        if (birthday != null && !birthday.isEmpty()) {
            String year = birthday.substring(0, birthday.indexOf("-"));
            String month = birthday.substring(birthday.indexOf("-") + 1, birthday.lastIndexOf("-"));
            String day = birthday.substring(birthday.lastIndexOf("-") + 1);

            cbYear.setSelectedItem(year);
            cbMonth.setSelectedItem(month);
            cbDay.setSelectedItem(day);
        }
    }

    private void updateTextSet() {
        btAdd.setText("수정");
        tfId.setEditable(false);
        tfName.setEditable(false);
        tfGender.setEditable(false);

        cbDay.setEnabled(false);
        cbMonth.setEnabled(false);
        cbYear.setEnabled(false);

        btDup.setEnabled(false);
    }

    private void update() throws SQLException {
        String tel1 = (String) cbTel.getSelectedItem();
        String tel2 = tfTel1.getText();
        String tel3 = tfTel2.getText();

        String tel = "";
        if (tel2 != null && !tel2.isEmpty()) {
            if (tel3 != null && !tel3.isEmpty()) {
                tel = tel1 + "-" + tel2 + "-" + tel3;
            }
        }
        CustomerDTO dto = new CustomerDTO();
        dto.setId(tfId.getText());
        dto.setZipcode(tfZipcode.getText());
        dto.setAddress1(tfAddress1.getText());
        dto.setAddress2(tfAddress2.getText());
        dto.setPh(tel);

        int n = dao.update(dto);
        if (n > 0) {
            JOptionPane.showMessageDialog(this, "수정완료!");
        } else {
            JOptionPane.showMessageDialog(this, "수정실패!");
        }
    }

    private void insert() throws SQLException {
        CustomerDTO dto = new CustomerDTO();
       
        String tel1 = (String) cbTel.getSelectedItem();
        String tel2 = tfTel1.getText();
        String tel3 = tfTel2.getText();

        String tel = "";
        if (tel2 != null && !tel2.isEmpty()) {
            if (tel3 != null && !tel3.isEmpty()) {
                tel = tel1 + "-" + tel2 + "-" + tel3;
            }
        }
        
        if(!IdCheck){
            JOptionPane.showMessageDialog(this, "아이디 중복체크를 해야 합니다.");
            tfId.requestFocus();
            return;
        }
        
        String name = tfName.getText();
        if(name == null || name.isEmpty()){
            JOptionPane.showMessageDialog(this, "이름을 입력해야 합니다.");
            tfName.requestFocus();
            return;
        }
        String id = tfId.getText();
        if(id == null || id.isEmpty()){
            JOptionPane.showMessageDialog(this, "아이디를 입력해야 합니다.");
            tfId.requestFocus();
            return;
        }
        String gender = tfGender.getText();
        if(gender == null || gender.isEmpty()){
            JOptionPane.showMessageDialog(this, "성별을 입력해야 합니다.");
            tfGender.requestFocus();
            return;
        }
        String day = cbYear.getSelectedItem()+"-"+cbMonth.getSelectedItem()+"-"+cbDay.getSelectedItem();
        Date date = Date.valueOf(day);
        Timestamp birthday = new Timestamp(date.getTime());
        
        dto.setBirthday(birthday);
        dto.setName(name);
        dto.setGender(gender);
        dto.setId(id);
        dto.setZipcode(tfZipcode.getText());
        dto.setAddress1(tfAddress1.getText());
        dto.setAddress2(tfAddress2.getText());
        dto.setPh(tel);
        
        int n = dao.insert(dto);
        if(n>0){
            JOptionPane.showMessageDialog(this, "등록완료!");
        }else{
            JOptionPane.showMessageDialog(this, "등록실패!");
        }
        dispose();
    }

    private void idDup() throws SQLException {
        String id = tfId.getText();
        if(id == null || id.isEmpty()){
            JOptionPane.showMessageDialog(this, "아이디를 입력하셔야 합니다.");
            tfId.requestFocus();
            return;
        }
        
        int n = dao.idCheck(id);
        if(n == CustomerDAO.NO){
            IdCheck = true;
            tfId.setEditable(false);
        }else{
            IdCheck = false;
        }
        
        if(IdCheck){
            JOptionPane.showMessageDialog(this, "사용가능한 아이디입니다.");
        }else{
            JOptionPane.showMessageDialog(this, "이미 사용중인 아이디입니다.");
        }
    }
}
