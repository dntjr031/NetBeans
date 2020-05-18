/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swingapp.view;

import com.swingapp.member.model.MemberDAO;
import com.swingapp.member.model.MemberDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author STU-03
 */
public class MemberFrame extends javax.swing.JFrame implements ActionListener, ItemListener{

    private LoginGUI loginGUI;
    private String[] emailArr
            = {"naver.com","nate.com","daum.net","gmail.com","직접입력"};
    private MemberDAO dao = new MemberDAO();
    private boolean isDuplicate; // 중복확인 여부
    private String userId;
    private int memFlag;
    private static final int MEMBER_REGISTER=1; // 회원가입
    private static final int MEMBER_EDIT=2; //회원수정

    public void setIsDuplicate(boolean isDuplicate) {
        this.isDuplicate = isDuplicate;
    }

    public boolean getIsDuplicate() {
        return isDuplicate;
    }
    /**
     * Creates new form MemberFrame
     */
    public MemberFrame() {
        initComponents();
        
        init();
        addEvent();
    }

    public MemberFrame(LoginGUI loginGUI) {
        this();
        this.loginGUI = loginGUI;
        memFlag = MEMBER_REGISTER;
        settingMember();
    }
    
    public MemberFrame(String userId) {
        this();
        this.userId = userId;
        memFlag = MEMBER_EDIT;
        settingMember();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btCancle = new javax.swing.JButton();
        btAdd = new javax.swing.JButton();
        tfName = new javax.swing.JTextField();
        tfPwd = new javax.swing.JTextField();
        tfId = new javax.swing.JTextField();
        btDup = new javax.swing.JButton();
        tfmail1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tfmail2 = new javax.swing.JTextField();
        cbMail = new javax.swing.JComboBox<>();
        cbTel = new javax.swing.JComboBox<>();
        tfTel2 = new javax.swing.JTextField();
        tfTel1 = new javax.swing.JTextField();
        tfZipcode = new javax.swing.JTextField();
        btZipcode = new javax.swing.JButton();
        tfAddress1 = new javax.swing.JTextField();
        tfAddress2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("회원가입");

        jLabel1.setText("이름");

        jLabel2.setText("아이디");

        jLabel3.setText("이메일");

        jLabel4.setText("비밀번호");

        jLabel5.setText("전화번호");

        jLabel6.setText("주소");

        jLabel7.setText("우편번호");

        jLabel8.setText("상세주소");

        btCancle.setText("취소");

        btAdd.setText("회원가입");

        btDup.setText("중복확인");

        jLabel9.setText(" @ ");

        cbMail.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbTel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "010", "011", "016", "017", "018", "019" }));

        btZipcode.setText("우편번호 찾기");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(tfmail1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbMail, 0, 158, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfmail2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfPwd, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cbTel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tfTel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tfTel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(137, 137, 137))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tfAddress2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfAddress1, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(17, 17, 17))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btDup))
                                    .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tfZipcode, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btZipcode)))
                                .addGap(0, 0, Short.MAX_VALUE))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(btAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btCancle, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDup))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfmail1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(tfmail2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfTel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfTel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfZipcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btZipcode))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfAddress1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfAddress2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAdd)
                    .addComponent(btCancle))
                .addContainerGap(24, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(MemberFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MemberFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MemberFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MemberFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MemberFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btCancle;
    private javax.swing.JButton btDup;
    private javax.swing.JButton btZipcode;
    private javax.swing.JComboBox<String> cbMail;
    private javax.swing.JComboBox<String> cbTel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JTextField tfAddress1;
    public javax.swing.JTextField tfAddress2;
    public javax.swing.JTextField tfId;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfPwd;
    private javax.swing.JTextField tfTel1;
    private javax.swing.JTextField tfTel2;
    public javax.swing.JTextField tfZipcode;
    private javax.swing.JTextField tfmail1;
    private javax.swing.JTextField tfmail2;
    // End of variables declaration//GEN-END:variables

    private void init() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        /*cbTel.addItem("010");
        cbTel.addItem("011");
        cbTel.addItem("016");
        */
        DefaultComboBoxModel model = new DefaultComboBoxModel(emailArr);
        cbMail.setModel(model);
        
        tfmail2.setEnabled(false);
    }

    private void addEvent() {
        btAdd.addActionListener(this);
        btCancle.addActionListener(this);
        btZipcode.addActionListener(this);
        btDup.addActionListener(this);
        
        cbMail.addItemListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == btAdd){
            try {
                //회원가입
                register();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }else if(e.getSource() == btCancle){
            dispose();
        }else if(e.getSource() == btDup){
            //중복확인
            SubUserId subUserId = new SubUserId(this, tfId.getText());
            subUserId.setVisible(true);
        }else if(e.getSource() == btZipcode){
            //우편번호 찾기
            SubZipcode sz = new SubZipcode(this);
            sz.setVisible(true);
        }
        
    }

    private void register() throws SQLException {
        //1
        String name = tfName.getText();
        String id = tfId.getText();
        String pwd = tfPwd.getText();
        String email1 = tfmail1.getText();
        String email2 = (String) cbMail.getSelectedItem();
        String email3 = tfmail2.getText();
        String tel1 =  (String) cbTel.getSelectedItem();
        String tel2 = tfTel1.getText();
        String tel3 = tfTel2.getText();
        String zipcode = tfZipcode.getText();
        String address1 = tfAddress1.getText();
        String address2 = tfAddress2.getText();
        
        //유효성 검사
        if(name == null || name.isEmpty()){
            JOptionPane.showMessageDialog(this, "이름을 입력하세요");
            tfName.requestFocus();
            return;
        }
        if(id == null || id.isEmpty()){
            JOptionPane.showMessageDialog(this, "아이디를 입력하세요");
            tfId.requestFocus();
            return;
        }
        if(pwd == null || pwd.isEmpty()){
            JOptionPane.showMessageDialog(this, "비밀번호를 입력하세요");
            tfPwd.requestFocus();
            return;
        }
        if(!isDuplicate){
            JOptionPane.showMessageDialog(this, "중복확인을 하세요");
            btDup.requestFocus();
            return;
        }
        
        String email = "";
        String tel = "";
        if(email1 != null && !email1.isEmpty()){
            if(email2.equals("직접입력")){
                if(email3 != null){
                    email = email1 + "@" + email3;
                }
            }else{
                email = email1 + "@"+ email2;
            }
        }
        if(tel2 != null && tel1 != null && !tel2.isEmpty() && !tel1.isEmpty()){
            tel = cbTel.getSelectedItem() + "-"+ tfTel1.getText() + "-" + tfTel2.getText();
        }
        //2
        MemberDTO dto = new MemberDTO();
        dto.setAddress1(address1);
        dto.setAddress2(address2);
        dto.setEmail(email);
        dto.setHp(tel);
        dto.setName(name);
        dto.setPwd(pwd);
        dto.setUserid(id);
        dto.setZipcode(zipcode);
        
        int cnt = dao.insertMember(dto);
        //3
        if(cnt>0){
            JOptionPane.showMessageDialog(this, "회원가입 완료!!");
            this.dispose();
            loginGUI.tfId.setText(tfId.getText());
            loginGUI.tfPwd.requestFocus();
        }else{
            JOptionPane.showMessageDialog(this, "회원가입 실패!");
        }
        
    }

    private void settingMember() {
        if(memFlag == MEMBER_REGISTER){
            setTitle("회원가입");
            btAdd.setText("회원가입");
            tfName.setEditable(true);
            tfPwd.setEditable(true);
            tfId.setEditable(true);
            btDup.setEnabled(true);
        }else if(memFlag == MEMBER_EDIT){
            setTitle("회원 정보 수정");
            btAdd.setText("회원수정");
            tfName.setEditable(false);
            tfPwd.setEditable(true);
            tfId.setEditable(false);
            btDup.setEnabled(false);
            
            try {
                showMember();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void showMember() throws SQLException {
        MemberDTO dto = dao.selectMember(userId);
        
        tfAddress1.setText(dto.getAddress1());
        tfAddress2.setText(dto.getAddress2());
        tfZipcode.setText(dto.getZipcode());
        tfName.setText(dto.getName());
        tfId.setText(dto.getUserid());
        
        
        String email=dto.getEmail();
        String hp=dto.getHp();
        
        if(hp!=null && !hp.isEmpty()){
            String[] hparr = hp.split("-");
            tfTel1.setText(hparr[1]);
            tfTel2.setText(hparr[2]);
            cbTel.setSelectedItem(hparr[0]);
        }
        
        if(email!=null && !email.isEmpty()){
            String[] emails = email.split("@");
            tfmail1.setText(emails[0]);
            
            String email2 = emails[1];
            boolean emailExist = false;
            for (int i = 0; i < emailArr.length; i++) {
                if(email2.equals(emailArr[i])){
                    emailExist = true;
                    break;
                }
            }
            
            if(emailExist){
                cbMail.setSelectedItem(email2);
            }else{
                cbMail.setSelectedItem("직접입력");
                tfmail2.setText(email2);
                tfmail2.setEnabled(true);
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource() == cbMail){
            if(e.getStateChange() == ItemEvent.SELECTED){
                String sel = (String) cbMail.getSelectedItem();
                if(sel.equals("직접입력")){
                    tfmail2.setEnabled(true);
                    tfmail2.requestFocus();
                    tfmail2.setText("");
                }else{
                    tfmail2.setText("");
                    tfmail2.setEnabled(false);
                }
            }
        }
    }
    
}
