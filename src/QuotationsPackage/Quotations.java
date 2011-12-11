/**
 * Class for Quotations
 * Contains the main method, and invokes the MainMenu
 */
package QuotationsPackage;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class Quotations {
    public static boolean logged_in = false;
    public static int currentUserID = 0;
    public static String currentUserFirst = null;
    public static String currentUserLast = null;
    public static ArrayList<String> authors = new ArrayList();
    public static Connection conn;
    
    Quotations() {
        
    }
	/**
	 * getAuthors method, returns a list of Authors currently in the list
	 * @return ArrayList<String> authors
	 */
    public static ArrayList<String> getAuthors() {
        return authors;
    }

    /**
	 * main method
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        connectDB();
        openMainMenu();
    }

    /**
     * connectDB method, connects the DB and displays error if it can't connect.
     */
    private static void connectDB() {
        conn = null;
        try {
            String dbUser = "csci511";
            String dbPass = "csci511";
            String URL = "jdbc:mysql://challinger.ecst.csuchico.edu:5551/quotations";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn =  (Connection) DriverManager.getConnection(URL,dbUser,dbPass);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * openMainMenu method, opens the main menu, can be called from outside
     * classes to display main menu
     */
    public static void openMainMenu() {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                MainMenu mainMenu = new MainMenu();
                mainMenu.setVisible(true);
                mainMenu.setResizable(false);
            }
        }); 
    }
}
