/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package QuotationsPackage;

/**
 *
 * @author c_harford
 */
public class Quotations {
    public static boolean logged_in = false;
    public static int currentUserID = 0;
    public static String currentUserFirst = null;
    public static String currentUserLast = null;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        openMainMenu();
    }
    
    public static int openMainMenu() {
   
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                MainMenu mainMenu = new MainMenu();
                mainMenu.setVisible(true);
                mainMenu.setResizable(false);
            }
        }); 
        return 0;
    }
}
