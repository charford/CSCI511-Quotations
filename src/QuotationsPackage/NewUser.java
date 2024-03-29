/**
 * Class for NewUser, makes a form for the user to signup
 * @author Casey Harford
 */
package QuotationsPackage;

import java.sql.ResultSet;
import com.mysql.jdbc.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class NewUser extends javax.swing.JFrame {

    /** Creates new form NewUser */
    public NewUser() {
        
        /* intialize all the components for this window */
        initComponents();
    }

    /** This method is called from within the constructor to			// This method was generated by Netbeans
     * initialize the form.												// I modified as necessary.
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

        titleLabel.setFont(new java.awt.Font("Lucida Grande", 1, 36));
        titleLabel.setText("Sign up");

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

	/**
	 * cancelButtonActionPerformed method, takes care of opening the main menu, and closing the new user screen
	 * @param evt	the event taking place(clicking cancel button)
	 */
	private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
	    
	    /* open the main menu */
	    Quotations.openMainMenu();
	    
	    /* and close this one */
	    this.dispose();
	}//GEN-LAST:event_cancelButtonActionPerformed

	/**
	 * method for signupButton, takes care of retrieving information entered by
	 * the user, and then updating the database with the information
	 * @param evt	the event taking place(signup button pressed)
	 */
	private void signupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupButtonActionPerformed
		
        /** storing the errors in validation in a list, then i will convert to array */
        ArrayList<String> validateErrors = new ArrayList();

		/** once I have all the errors, I will output them as a string */
		StringBuilder builder;

		/** get the first name entered */
	    String firstName = firstNameEntered.getText().trim();
	
		/** get the last name entered */
	    String lastName = lastNameEntered.getText().trim();
	
		/** get the password entered */
	    String password = passwordEntered.getText().trim();
	
		/** validate firstName */
		if(firstName.equalsIgnoreCase("")) validateErrors.add("* firstName cannot be blank.");

		/** validate lastName */
		if(lastName.equalsIgnoreCase("")) validateErrors.add("* lastName cannot be blank.");
		
		/** validate password */
		if(password.equalsIgnoreCase("")) validateErrors.add("* password cannot be blank.");
		
                /** if we had validation errors, display them in a dialog box, return */
		if(validateErrors.size() > 0) {
			builder = new StringBuilder(validateErrors.size());
			for(int i=0; i<validateErrors.toArray().length; builder.append(validateErrors.toArray()[i++])) builder.append("\n");
			JOptionPane.showMessageDialog(null, builder.toString(), "Error", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		/** the default value of userID, if left at 0, will be displayed as Unknown */
                int userID = 0;
	
		/** time to enter this stuff into the database */
                try {
 
			/** track number of rows inserted */
	        int count = 0;
	        
	        /** using a prepared statement for inserting values into database */
 	        PreparedStatement psInsert;

			/** storing the results in a ResultSet */
	        ResultSet rs = null;
	
			/** here's the query to use */
	        psInsert = (PreparedStatement) Quotations.conn.prepareStatement
			("INSERT INTO Users (FirstName,LastName,UserPassword) VALUES (?,?,?)");
	
			/** bind the firstName value */
	        psInsert.setString(1,firstName);
	
			/** bind the lastName value */
	        psInsert.setString(2,lastName);
	
			/** bind the password value */
	        psInsert.setString(3,password);
	
			/** insert the data, and store the number of rows inserted */
	        count = psInsert.executeUpdate();
	
			/** close the prepared statement */
	        psInsert.close();
			
			/* 	was the query successful? if so, open the main menu, display
			 *	success, and close this window
			 */
	        if(count>0) {
   	            Quotations.openMainMenu();
             	JOptionPane.showMessageDialog
				(this,"You're account was created successfuly. You must login now.");
	            this.dispose();
	        }
            else {
            	JOptionPane.showMessageDialog
				(this,"An error occurred trying to create your account. Please try again.");
        	}
	    }
	    catch(Exception e) {}
	}//GEN-LAST:event_signupButtonActionPerformed

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
