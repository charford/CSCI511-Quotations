/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainMenu.java
 *
 * Created on Dec 8, 2011, 9:10:49 PM
 */
package QuotationsPackage;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/**
 *
 * @author c_harford
 */
public class MainMenu extends javax.swing.JFrame {
    /** Creates new form MainMenu */
    public MainMenu() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        showQuotesButton = new javax.swing.JButton();
        loginButton = new javax.swing.JButton();
        showQuotesLabel = new javax.swing.JLabel();
        loginLabel = new javax.swing.JLabel();
        signupButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        showQuotesButton.setText("Show Quotes");
        showQuotesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showQuotesButtonActionPerformed(evt);
            }
        });

        if(Quotations.logged_in) loginButton.setText("Logout");
        else
        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        showQuotesLabel.setText("Show quotes by clicking the button below.");

        if(Quotations.logged_in) loginLabel.setText("You are logged in as "+ Quotations.currentUserFirst + " " + Quotations.currentUserLast + ".");
        else
        loginLabel.setText("You must be logged in to save changes.");

        signupButton.setText("Sign up");
        signupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupButtonActionPerformed(evt);
            }
        });

        titleLabel.setFont(new java.awt.Font("Lucida Grande", 1, 36));
        titleLabel.setText("Quotations");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(titleLabel))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(loginButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(showQuotesButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(signupButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 73, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(75, 75, 75)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                            .add(loginLabel)
                            .add(showQuotesLabel))))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(new java.awt.Component[] {loginButton, showQuotesButton, signupButton}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(titleLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(showQuotesLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(loginLabel)
                .add(22, 22, 22)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(loginButton)
                    .add(showQuotesButton)
                    .add(signupButton))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void showQuotesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showQuotesButtonActionPerformed
         /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                final JFrame frame = new JFrame();
                frame.setContentPane(new ShowQuotes());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
                frame.setResizable(true);
                frame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent evt) {
                        Quotations.openMainMenu();
                        frame.dispose();
                    }
                });
            }
        });
        this.dispose();
}//GEN-LAST:event_showQuotesButtonActionPerformed

private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed

    if(Quotations.logged_in) {
        Quotations.logged_in = false;
        Quotations.currentUserID = 0;
        Quotations.currentUserFirst = null;
        Quotations.currentUserLast = null;
        Quotations.openMainMenu();
        this.dispose();
        return;
    }
    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {

        @Override
        public void run() {
            final LoginWindow login = new LoginWindow();
            login.setVisible(true);
            login.setResizable(false);
            login.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent evt) {
                    Quotations.openMainMenu();
                    login.dispose();
                }
            });
        }
    });
    this.dispose();
}//GEN-LAST:event_loginButtonActionPerformed

private void signupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupButtonActionPerformed
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                final NewUser newUserWindow = new NewUser();
                newUserWindow.setVisible(true);
                newUserWindow.setResizable(false);
                newUserWindow.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent evt) {
                        Quotations.openMainMenu();
                        newUserWindow.dispose();
                    }
                });
            }
        });
        this.dispose();
}//GEN-LAST:event_signupButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JButton showQuotesButton;
    private javax.swing.JLabel showQuotesLabel;
    private javax.swing.JButton signupButton;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
