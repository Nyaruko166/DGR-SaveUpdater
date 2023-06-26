/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Nyaruko166.view;

import Nyaruko166.Main;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author ADMIN
 */
public class MainView extends javax.swing.JFrame {

    /**
     * Creates new form MainView
     */
    public MainView() {
        initComponents();
        this.setIconImage(new ImageIcon("./mugi.jpg").getImage());
        CenteredFrame(this);
        readConfig();
    }

    private String steamDir = "";
    private String crackDir = "";

    public Boolean validateDir() {
        if (steamDir.isBlank()) {
            JOptionPane.showMessageDialog(this, "Vcl m deo thêm path thì t chuyển save kiểu buoi gì?", "Path steam đâu?", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (crackDir.isBlank()) {
            JOptionPane.showMessageDialog(this, "Vcl m deo thêm path thì t chuyển save kiểu buoi gì?", "Path crack đâu?", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public String fileChooser() {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("C:\\Program Files (x86)\\Steam\\steamapps\\common\\Deep Rock Galactic\\FSD"));
        chooser.setDialogTitle("Chọn folder Saved");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile().getPath();
        }
        return "";
    }

    public void readConfig() {
        try {

            File f = new File("./config.txt");
            if (f.exists() && !f.isDirectory()) {
                FileReader fr = new FileReader("config.txt");
                BufferedReader br = new BufferedReader(fr);

                for (int i = 0; i < 2; i++) {
                    if (i == 0) {
                        steamDir = br.readLine();
                    } else {
                        crackDir = br.readLine();
                    }
                }
            } else {
                File file = new File("config.txt");
                file.createNewFile();
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void copyDir(Path src, Path dest) {
        String destStr = dest.toString();

        try {
            FileUtils.deleteDirectory(new File(destStr));
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        new File(destStr).mkdirs();

        try {
            Files.walk(src).forEach(s -> {
                try {
                    Files.copy(s, dest.resolve(src.relativize(s)), StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void CenteredFrame(javax.swing.JFrame objFrame) {
        Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int iCoordX = (objDimension.width - objFrame.getWidth()) / 2;
        int iCoordY = (objDimension.height - objFrame.getHeight()) / 2;
        objFrame.setLocation(iCoordX, iCoordY);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblSteam = new javax.swing.JLabel();
        btnSteam = new javax.swing.JButton();
        lblCrack = new javax.swing.JLabel();
        btnCrack = new javax.swing.JButton();
        btnSteamToCrack = new javax.swing.JButton();
        btnCrackToSteam = new javax.swing.JButton();
        btnCrackToSteam1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("App sech");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblSteam.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lblSteam.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSteam.setText("Steam");
        lblSteam.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnSteam.setText("Browse");
        btnSteam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSteamActionPerformed(evt);
            }
        });

        lblCrack.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lblCrack.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCrack.setText("Crack");
        lblCrack.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnCrack.setText("Browse");
        btnCrack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrackActionPerformed(evt);
            }
        });

        btnSteamToCrack.setText("Steam To Crack");
        btnSteamToCrack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSteamToCrackActionPerformed(evt);
            }
        });

        btnCrackToSteam.setText("Crack To Steam");
        btnCrackToSteam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrackToSteamActionPerformed(evt);
            }
        });

        btnCrackToSteam1.setText("Save Config");
        btnCrackToSteam1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrackToSteam1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblCrack, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCrack))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblSteam, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSteam)))
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSteamToCrack)
                    .addComponent(btnCrackToSteam))
                .addContainerGap(39, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCrackToSteam1)
                .addGap(135, 135, 135))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSteam, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSteam, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSteamToCrack, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCrack, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrack, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrackToSteam, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnCrackToSteam1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSteamToCrackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSteamToCrackActionPerformed
        if (validateDir()) {
            int cac = JOptionPane.showConfirmDialog(this, "M có chắc muốn chuyển save từ Steam sang Crack chứ?", "Chắc chưa", JOptionPane.YES_NO_CANCEL_OPTION);
            if (cac == 0) {
                File src = new File(steamDir);
                File dest = new File(crackDir);
                copyDir(src.toPath(), dest.toPath());
                JOptionPane.showMessageDialog(this, "Copy save xong rồi nè ;b");
            }
        }
    }//GEN-LAST:event_btnSteamToCrackActionPerformed

    private void btnSteamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSteamActionPerformed
        steamDir = fileChooser();
    }//GEN-LAST:event_btnSteamActionPerformed

    private void btnCrackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrackActionPerformed
        crackDir = fileChooser();
    }//GEN-LAST:event_btnCrackActionPerformed

    private void btnCrackToSteam1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrackToSteam1ActionPerformed
        if (validateDir()) {
            try {
                FileWriter fw = new FileWriter("config.txt");
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(steamDir);
                bw.newLine();
                bw.write(crackDir);

                bw.close();
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(this, "Save xong rồi nè ;b");
        }
    }//GEN-LAST:event_btnCrackToSteam1ActionPerformed

    private void btnCrackToSteamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrackToSteamActionPerformed
        if (validateDir()) {
            int cac = JOptionPane.showConfirmDialog(this, "M có chắc muốn chuyển save từ Crack sang Steam chứ?", "Chắc chưa", JOptionPane.YES_NO_CANCEL_OPTION);
            if (cac == 0) {
                File src = new File(crackDir);
                File dest = new File(steamDir);
                copyDir(src.toPath(), dest.toPath());
                JOptionPane.showMessageDialog(this, "Copy save xong rồi nè ;b");
            }
        }
    }//GEN-LAST:event_btnCrackToSteamActionPerformed

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
            java.util.logging.Logger.getLogger(MainView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrack;
    private javax.swing.JButton btnCrackToSteam;
    private javax.swing.JButton btnCrackToSteam1;
    private javax.swing.JButton btnSteam;
    private javax.swing.JButton btnSteamToCrack;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCrack;
    private javax.swing.JLabel lblSteam;
    // End of variables declaration//GEN-END:variables
}
