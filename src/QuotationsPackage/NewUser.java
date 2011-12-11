/**
 * Class for NewUser, makes a form for the user to signup
 * @author Casey Harford
 */
package QuotationsPackage;

import java.sql.DriverManager;
import java.sql.ResultSet;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class NewUser extends javax.swing.JFrame {

    /** Creates new form NewUser */
    public NewUser() {
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

        firstNameEntered = new javax.swing.JTextField();
        lastNameEntered = new javax.swing.JTextField();
        firstNameLabel = new javax.swing.JLabel();
        lastNameLable = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        signupButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();
        passwordEntered = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        firstNameEntered.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameEnteredActionPerformed(evt);
            }
        });

        lastNameEntered.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNameEnteredActionPerformed(evt);
            }
        });

        firstNameLabel.setText("First Name:");

        lastNameLable.setText("Last Name:");

        passwordLabel.setText("Password:");

        signupButton.setText("Sign up");
        signupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        titleLabel.setFont(new java.awt.Font("Lucida Grande", 1, 36)); // NOI18N
        titleLabel.setText("Sign up");

        passwordEntered.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordEnteredActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                        .add(layout.createSequentialGroup()
                            .add(cancelButton)
                            .add(30, 30, 30)
                            .add(signupButton))
                        .add(layout.createSequentialGroup()
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                .add(passwordLabel)
                                .add(firstNameLabel)
                                .add(lastNameLable))
                            .add(18, 18, 18)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                .add(passwordEntered, 0, 0, Short.MAX_VALUE)
                                .add(org.jdesktop.layout.GroupLayout.TRAILING, firstNameEntered, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                                .add(org.jdesktop.layout.GroupLayout.TRAILING, lastNameEntered))))
                    .add(titleLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 150, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(new java.awt.Component[] {firstNameEntered, lastNameEntered, passwordEntered}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(titleLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 49, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(firstNameEntered, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(firstNameLabel))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lastNameEntered, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lastNameLable))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(passwordEntered, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(passwordLabel))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(signupButton)
                    .add(cancelButton))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void lastNameEnteredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastNameEnteredActionPerformed
	// TODO add your handling code here:
	}//GEN-LAST:event_lastNameEnteredActionPerformed

	private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
	    Quotations.openMainMenu();
	    this.dispose();
	}//GEN-LAST:event_cancelButtonActionPerformed

	private void signupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupButtonActionPerformed

	    Connection conn = null;
	    String firstName = firstNameEntered.getText();
	    String lastName = lastNameEntered.getText();
	    String password = passwordEntered.getText();
	    int userID = 0;
	    try {
 
	        int count = 0;
	        String dbUser = "csci511";
	        String dbPass = "csci511";
	        String URL = "jdbc:mysql://challinger.ecst.csuchico.edu:5551/quotations";
	        Class.forName("com.mysql.jdbc.Driver").newInstance();
	        conn =  (Connection) DriverManager.getConnection(URL,dbUser,dbPass);
        
	        //check if user and password combo exist
	        PreparedStatement ps;
	        ResultSet rs = null;
	        ps = (PreparedStatement) conn.prepareStatement("INSERT INTO Users (FirstName,LastName,UserPassword) VALUES (?,?,?)");
	        ps.setString(1,firstName);
	        ps.setString(2,lastName);
	        ps.setString(3,password);
	        count = ps.executeUpdate();
	        ps.close();
      
	        if(count>0) {
	            count = 0;
	            ps = (PreparedStatement) conn.prepareStatement("SELECT UserID FROM Users WHERE FirstName = ? AND LastName = ? AND UserPassword ?");
	            ps.setString(1,firstName);
	            ps.setString(2,lastName);
	            ps.setString(3,password);
	            rs = ps.executeQuery();
	            while (rs.next()) {
	                count++;
	                userID = rs.getInt("UserID");
	            }
	            ps.close();
	            if(count>0) {
	                Quotations.logged_in = true; 
	                Quotations.currentUserFirst = firstName;
	                Quotations.currentUserLast = lastName;
	                Quotations.currentUserID = userID;
	            }
	            Quotations.openMainMenu();
	            System.out.println("Account created!");
	            this.dispose();
	        }
	    }
	    catch(Exception e) {}
	}//GEN-LAST:event_signupButtonActionPerformed

	private void firstNameEnteredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameEnteredActionPerformed
	// TODO add your handling code here:
	}//GEN-LAST:event_firstNameEnteredActionPerformed

	private void passwordEnteredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordEnteredActionPerformed
	// TODO add your handling code here:
	}//GEN-LAST:event_passwordEnteredActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField firstNameEntered;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JTextField lastNameEntered;
    private javax.swing.JLabel lastNameLable;
    private javax.swing.JPasswordField passwordEntered;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JButton signupButton;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
