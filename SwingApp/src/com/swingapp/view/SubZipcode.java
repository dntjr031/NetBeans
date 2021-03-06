/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swingapp.view;

import com.swingapp.zipcode.model.ZipcodeDAO;
import com.swingapp.zipcode.model.ZipcodeDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author STU-03
 */
public class SubZipcode extends javax.swing.JFrame implements ActionListener{

    private MemberFrame memberFrame;
    private ZipcodeDAO dao = new ZipcodeDAO();
    private String[] col = {"우편번호","시도","구군","동","번지"};
    DefaultTableModel model;
    /**
     * Creates new form SubZipcode
     */
    public SubZipcode() {
        initComponents();
        init();
        addEvent();
    }

    public SubZipcode(MemberFrame memberFrame) {
        this();
        this.memberFrame = memberFrame;
        
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
        tfDong = new javax.swing.JTextField();
        btSearch = new javax.swing.JButton();
        btClose = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("우편번호 검색");

        jLabel1.setText("지역명(읍면동):");

        btSearch.setText("검색");

        btClose.setText("닫기");

        scrollPane.setEnabled(false);
        scrollPane.setFocusable(false);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "우편번호", "시도", "구군", "동", "번지"
            }
        ));
        scrollPane.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfDong, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btClose, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSearch)
                    .addComponent(btClose))
                .addGap(18, 18, 18)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(SubZipcode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SubZipcode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SubZipcode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SubZipcode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SubZipcode().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btClose;
    private javax.swing.JButton btSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable table;
    private javax.swing.JTextField tfDong;
    // End of variables declaration//GEN-END:variables

    private void init() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        model = new DefaultTableModel();
        
        tableSize();
        
    }

    private void addEvent() {
        btClose.addActionListener(this);
        btSearch.addActionListener(this);
        tfDong.addActionListener(this);
        
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                if(e.getSource() == table){
                    int row = table.getSelectedRow();
                    String address="";
                    String zipcode = table.getValueAt(row, 0).toString();
                    for (int i = 1; i < 4; i++) {
                        address += table.getValueAt(row, i) + " ";
                    }
                    memberFrame.tfZipcode.setText(zipcode);
                    memberFrame.tfAddress1.setText(address);
                }
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if(e.getClickCount() == 2){
                    if(e.getSource() == table){
                    int row = table.getSelectedRow();
                    String address="";
                    String zipcode = table.getValueAt(row, 0).toString();
                    for (int i = 1; i < 4; i++) {
                        address += table.getValueAt(row, i) + " ";
                    }
                    memberFrame.tfZipcode.setText(zipcode);
                    memberFrame.tfAddress1.setText(address);
                    }
                }
            }
            
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btClose){
            this.dispose();
        }
        if(e.getSource() == btSearch || e.getSource() == tfDong){
            try {
                selectByDong();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void selectByDong() throws SQLException {
        //1
        String dong = tfDong.getText();
        
        if(dong == null || dong.isEmpty()){
            JOptionPane.showMessageDialog(this, "동을 입력하셔야 합니다");
            return;
        }
        //2
        ArrayList<ZipcodeDTO> list = dao.selectByDong(dong);
        
        if(list == null || list.isEmpty()){
            JOptionPane.showMessageDialog(this, dong + "의 검색결과가 없습니다.");
            tfDong.setText("");
            tfDong.requestFocus();
        }
        //3
        String[][] data = new String[list.size()][col.length];
        for (int i = 0; i < list.size(); i++) {
            ZipcodeDTO dto = list.get(i);
            
            data[i][0] = dto.getZipcode();
            data[i][1] = dto.getSido();
            data[i][2] = dto.getGugun();
            data[i][3] = dto.getDong();
            /*
            String bunji = "";
            if(dto.getStartbunji() == null || dto.getStartbunji().isEmpty()){
                
            }else{
                if(dto.getEndbunji() == null || dto.getEndbunji().isEmpty()){
                    bunji = dto.getStartbunji();
                }else{
                    bunji = "(" + dto.getStartbunji() + " ~ " + dto.getEndbunji() + ")";
                }
            }
            */
            String bunji = dto.getStartbunji();
            String endbunji = dto.getEndbunji();
            if(endbunji != null && !endbunji.isEmpty()){
                bunji = "(" + bunji + " ~ " + endbunji + ")";
            }
            data[i][4] = bunji;
            
            
        }
        model.setDataVector(data, col);
        table.setModel(model);
        
        tableSize();
    }

    private void tableSize() {
        table.getColumnModel().getColumn(0).setPreferredWidth(70);
        table.getColumnModel().getColumn(1).setPreferredWidth(90);
        table.getColumnModel().getColumn(2).setPreferredWidth(70);
        table.getColumnModel().getColumn(3).setPreferredWidth(90);
        table.getColumnModel().getColumn(4).setPreferredWidth(125);
    }
}
