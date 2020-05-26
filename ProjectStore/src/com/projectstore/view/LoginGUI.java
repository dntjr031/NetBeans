/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectstore.view;

import com.model.seller.SellerDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author STU-03
 */
public class LoginGUI extends javax.swing.JFrame implements ActionListener{

    /**
     * Creates new form Login
     */
    public LoginGUI() {
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

        jLabel1 = new javax.swing.JLabel();
        pl = new javax.swing.JPanel();
        lbId = new javax.swing.JLabel();
        lbPwd = new javax.swing.JLabel();
        tfId = new javax.swing.JTextField();
        btLogin = new javax.swing.JButton();
        btClose = new javax.swing.JButton();
        tfPwd = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/제목_없는_아트워크 1.jpg"))); // NOI18N

        pl.setBackground(new java.awt.Color(255, 255, 255));
        pl.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.white, java.awt.Color.lightGray, java.awt.Color.white));
        pl.setForeground(new java.awt.Color(102, 102, 102));

        lbId.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbId.setForeground(new java.awt.Color(84, 158, 141));
        lbId.setText("아이디");

        lbPwd.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbPwd.setForeground(new java.awt.Color(85, 160, 143));
        lbPwd.setText("비밀번호");

        tfId.setBackground(new java.awt.Color(114, 214, 191));

        btLogin.setBackground(new java.awt.Color(114, 214, 191));
        btLogin.setForeground(new java.awt.Color(102, 102, 102));
        btLogin.setText("로그인");
        btLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLoginActionPerformed(evt);
            }
        });

        btClose.setBackground(new java.awt.Color(114, 214, 191));
        btClose.setForeground(new java.awt.Color(102, 102, 102));
        btClose.setText("닫기");

        tfPwd.setBackground(new java.awt.Color(114, 214, 191));

        javax.swing.GroupLayout plLayout = new javax.swing.GroupLayout(pl);
        pl.setLayout(plLayout);
        plLayout.setHorizontalGroup(
            plLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plLayout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(plLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(plLayout.createSequentialGroup()
                        .addGroup(plLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbId, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbPwd))
                        .addGap(29, 29, 29)
                        .addGroup(plLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfId, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                            .addComponent(tfPwd)))
                    .addGroup(plLayout.createSequentialGroup()
                        .addComponent(btLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addComponent(btClose, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        plLayout.setVerticalGroup(
            plLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(plLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbId)
                    .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(plLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPwd)
                    .addComponent(tfPwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(plLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btClose, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(btLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btLoginActionPerformed

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
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btClose;
    private javax.swing.JButton btLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbId;
    private javax.swing.JLabel lbPwd;
    private javax.swing.JPanel pl;
    private javax.swing.JTextField tfId;
    private javax.swing.JPasswordField tfPwd;
    // End of variables declaration//GEN-END:variables

    private void init() {
       setLocationRelativeTo(null);
    }

    private void addEvent() {
        btLogin.addActionListener(this);
        btClose.addActionListener(this);
        tfPwd.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btLogin){
            try {
                login();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
           
        }else if(e.getSource() == btClose){
            int n = JOptionPane.showConfirmDialog(this, "정말 종료하시겠습니까?", "프로그램 종료",
                                JOptionPane.YES_NO_OPTION);
            if(n == JOptionPane.YES_OPTION){
                System.exit(0);
            }
        }else if(e.getSource() == tfPwd){
            try {
                login();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void login() throws SQLException {
        String id = tfId.getText();
        String pwd = tfPwd.getText();
        if(id==null || id.isEmpty()){
            JOptionPane.showMessageDialog(this, "아이디를 입력해야 합니다.");
            tfId.requestFocus(true);
            return;
        }
        if(pwd==null || pwd.isEmpty()){
            JOptionPane.showMessageDialog(this, "비밀번호를 입력하세요");
            tfPwd.requestFocus(true);
            return;
        }
        SellerDAO dao = new SellerDAO();
        int n = dao.login(id, pwd);
        if(n == SellerDAO.LOGIN_OK){
            JOptionPane.showMessageDialog(this, "로그인완료!");
            StoreMainGUI s = new StoreMainGUI(id);
            s.setVisible(true);
            dispose();
        }else if(n == SellerDAO.LOGIN_NOID){
            JOptionPane.showMessageDialog(this, "아이디가 없습니다");
            return;
        }else if(n == SellerDAO.LOGIN_NOPWD){
            JOptionPane.showMessageDialog(this, "비밀번호가 틀렸습니다.");
            return;
        }else{
            JOptionPane.showMessageDialog(this, "로그인 오류");
            return;
        }
    }
}
