/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package railway.reservation.system;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.videoio.VideoCapture;

/**
 *
 * @author Gunesh Madusanka
 */
public class user_registration extends javax.swing.JFrame {

    /**
     * Creates new form user_registration
     */
    private DaemonThread myThread = null;
    int count = 0;
    VideoCapture webSource = null;

    Mat frame = new Mat();
    MatOfByte mem = new MatOfByte();
    // CascadeClassifier faceDetector = new CascadeClassifier(facedetection.class.getResource("haarcascade_frontalface_alt.xml").getPath().substring(1));
    CascadeClassifier faceDetector = new CascadeClassifier("C:\\Users\\Gunesh Madusanka\\Documents\\NetBeansProjects\\Railway Reservation System\\src\\railway\\reservation\\system\\haarcascade_frontalface_alt.xml");
    MatOfRect faceDetections = new MatOfRect();

    class DaemonThread implements Runnable {

        protected volatile boolean runnable = false;

        @Override
        public void run() {
            synchronized (this) {
                while (runnable) {
                    if (webSource.grab()) {
                        try {
                            webSource.retrieve(frame);
                            Graphics g = jPanel2.getGraphics();
                            faceDetector.detectMultiScale(frame, faceDetections);
                            for (Rect rect : faceDetections.toArray()) {
                                // System.out.println("ttt");
                                Imgproc.rectangle(frame, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
                                        new Scalar(0, 255, 0));
                            }
                            Imgcodecs.imencode(".bmp", frame, mem);
                            Image im = ImageIO.read(new ByteArrayInputStream(mem.toArray()));

                            BufferedImage buff = (BufferedImage) im;

                            if (g.drawImage(buff, 0, 0, getWidth(), getHeight() - 150, 0, 0, buff.getWidth(), buff.getHeight(), null)) {
                                if (runnable == false) {
                                    System.out.println("Paused");
                                    this.wait();
                                }
                            }
                        } catch (Exception ex) {
                            System.out.println("Error");
                            ex.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public user_registration() {

        initComponents();
        img_holder1.setEnabled(false);
        System.out.println(user_registration.class.getResource("haarcascade_frontalface_alt.xml").getPath().substring(1));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        lname = new javax.swing.JTextField();
        nic = new javax.swing.JTextField();
        un = new javax.swing.JTextField();
        pw = new javax.swing.JPasswordField();
        pw1 = new javax.swing.JPasswordField();
        desi = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        img_holder1 = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 0, 51,100));

        jLabel1.setText("First Name :");

        jLabel4.setText("Last Name :");

        jLabel5.setText("NIC :");

        jLabel6.setText("Designation :");

        jLabel7.setText("UserName :");

        jLabel8.setText("Password :");

        jLabel9.setText("Confirm Password :");

        fname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fnameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fnameKeyReleased(evt);
            }
        });

        lname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lnameKeyPressed(evt);
            }
        });

        nic.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nicKeyPressed(evt);
            }
        });

        un.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                unKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                unKeyReleased(evt);
            }
        });

        pw.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pwKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pwKeyReleased(evt);
            }
        });

        desi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administration Officer", "Officer" }));
        desi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                desiKeyPressed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 51, 204,100));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(img_holder1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(img_holder1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        status.setBackground(new java.awt.Color(204, 204, 255,100));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(37, 37, 37)
                        .addComponent(fname))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(38, 38, 38)
                        .addComponent(lname))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(un)
                            .addComponent(pw)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nic)
                            .addComponent(desi, 0, 159, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(2, 2, 2)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(status, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pw1))))
                .addGap(69, 69, 69)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(nic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(desi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(un, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(pw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(pw1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(149, 149, 149))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 680, 410));

        jPanel5.setBackground(new java.awt.Color(0, 0, 0,100));

        jButton1.setText("Start/Stop");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Capture");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("SAVE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("SEARCH");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(344, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 480, 680, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/railway/reservation/system/train_edit.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/railway/reservation/system/wall1.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(273, 0, 730, 538));

        getAccessibleContext().setAccessibleName("jf");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            webSource = new VideoCapture(0);
            myThread = new user_registration.DaemonThread();
            Thread t = new Thread(myThread);
            t.setDaemon(true);
            myThread.runnable = true;
            t.start();
            jButton1.setEnabled(false);  //start button
            jButton2.setEnabled(true);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            int returnVal = jFileChooser1.showSaveDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = jFileChooser1.getSelectedFile();
                Imgcodecs.imwrite(file.getPath(), frame);
            } else {
                System.out.println("File access cancelled by user.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            if (status.getText().equals("Password Strong")) {

                String driverName = "com.mysql.jdbc.Driver";
                String url = "jdbc:mysql://localhost:3306/";
                String dbName = "railway";
                String userName = "root";
                String password = "123";
                Connection con = null;

                Class.forName(driverName);
                con = DriverManager.getConnection(url + dbName, userName, password);
                Statement st = con.createStatement();
                File path = jFileChooser1.getSelectedFile();
                System.out.println(path);
                File imgfile = new File(path.toString());

                FileInputStream fin = new FileInputStream(imgfile);
//nic, fname, lname, designation, un, pw, image
                PreparedStatement pre
                        = con.prepareStatement("insert into signup values(?,?,?,?,?,?,?)");

                pre.setString(1, nic.getText());
                pre.setString(2, fname.getText());
                pre.setString(3, lname.getText());
                pre.setString(4, desi.getSelectedItem().toString());
                pre.setString(5, un.getText());
                pre.setString(6, pw.getPassword().toString());
                pre.setBinaryStream(7, (InputStream) fin, (int) imgfile.length());
                pre.executeUpdate();
                System.out.println("Successfully inserted the data into the database!");

                pre.close();
                con.close();
                
                db.iud("insert into user (username,password) values ('"+un.getText()+"',md5('"+pw.getText()+"'))");
                
                
            }else{
                JOptionPane.showMessageDialog(rootPane, "Password Must be strong","Thank You", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            img_holder1.setEnabled(true);
            try {
                ResultSet rs;
                Statement st;
                Connection con = db.getDBCon();
                st = con.createStatement();
                //idtest_image, image
                String sql = "select * from signup where nic='" + nic.getText() + "'";
                rs = st.executeQuery(sql);
                System.out.println("out");
                while (rs.next()) {
                    fname.setText(rs.getString("fname"));
                    lname.setText(rs.getString("lname"));
                    desi.setSelectedItem("designation");
                    un.setText("un");
                    byte[] img = rs.getBytes("image");
                    ImageIcon image = new ImageIcon(img);
                    Image im = image.getImage();
                    Image myImg = im.getScaledInstance(img_holder1.getWidth(), img_holder1.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon newImage = new ImageIcon(myImg);
                    img_holder1.setIcon(newImage);
                    //img_holder.setIcon(new ImageIcon("image"));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
        }


    }//GEN-LAST:event_jButton4ActionPerformed

    private void fnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fnameKeyReleased
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_fnameKeyReleased

    private void fnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fnameKeyPressed
        try {
            char c = evt.getKeyChar();
            if (Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {
                fname.setEditable(true);
            } else {
                fname.setEditable(false);
            }
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                lname.grabFocus();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_fnameKeyPressed

    private void lnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lnameKeyPressed
        try {
            char c = evt.getKeyChar();
            if (Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {
                lname.setEditable(true);
            } else {
                lname.setEditable(false);
            }

            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                desi.grabFocus();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_lnameKeyPressed

    private void nicKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nicKeyPressed
        try {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                fname.grabFocus();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_nicKeyPressed

    private void desiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_desiKeyPressed
        try {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                un.grabFocus();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_desiKeyPressed

    private void pwKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pwKeyPressed
        try {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                pw1.grabFocus();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_pwKeyPressed

    private void unKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_unKeyPressed
        try {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                pw.grabFocus();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_unKeyPressed

    private void pwKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pwKeyReleased
        try {
            int pw_len = pw.getText().length();
            if (pw_len < 8) {
                status.setText("Password too short");
                pw.setBackground(Color.red);
            } else if (pw_len == 8) {
                status.setText("Password Medium");
                pw.setBackground(Color.yellow);
            } else if (pw_len > 8) {
                status.setText("Password Strong");
                pw.setBackground(Color.GREEN);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_pwKeyReleased

    private void unKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_unKeyReleased
        try {
             
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_unKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
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
            java.util.logging.Logger.getLogger(user_registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(user_registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(user_registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(user_registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new user_registration().setVisible(true);
            }
        });
    }

    private void validate_nic() {
        try {
            if (!(nic.getText().matches("^[0-9]{9}[vV]$"))) {
                JOptionPane.showMessageDialog(null, "Invalid Input for NIC ", "Error", JOptionPane.ERROR_MESSAGE);
                nic.setBackground(Color.red);
                nic.setForeground(Color.WHITE);
                nic.setText(null);
            } else {
                nic.setBackground(Color.GREEN);
                nic.setForeground(Color.WHITE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox desi;
    private javax.swing.JTextField fname;
    private javax.swing.JLabel img_holder1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField lname;
    private javax.swing.JTextField nic;
    private javax.swing.JPasswordField pw;
    private javax.swing.JPasswordField pw1;
    private javax.swing.JLabel status;
    private javax.swing.JTextField un;
    // End of variables declaration//GEN-END:variables
}