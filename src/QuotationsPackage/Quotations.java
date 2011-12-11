/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package QuotationsPackage;

import java.util.ArrayList;

/**
 *
 * @author c_harford
 */
public class Quotations {
    public static boolean logged_in = false;
    public static int currentUserID = 0;
    public static String currentUserFirst = null;
    public static String currentUserLast = null;
    public static ArrayList<String> authors = new ArrayList();
    
    public static ArrayList<String> getAuthors() {
        return authors;
    }
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
