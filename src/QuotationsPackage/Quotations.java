/**
 * Class for Quotations
 * Contains the main method, and invokes the MainMenu
 * @author Casey Harford
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
        
        /* get the list of authors, and return it */
        return authors;
    }

    /**
	 * main method, connects to database, then displays main menu
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /* connect to the database, this connection will be used throughout*/
        connectDB();
        
        /* open the main menu */
        openMainMenu();
    }

    /**
     * connectDB method, connects the DB and displays error if it can't connect.
     */
    private static void connectDB() {
        
        /* set conn to an initial value */
        conn = null;
        
        try {
            /* set the database user */
            String dbUser = "csci511";
            
            /* set the database password */
            String dbPass = "csci511";
            
            /* the jdbc url to use */
            String URL = "jdbc:mysql://challinger.ecst.csuchico.edu:5551/quotations";
            
            /* create new instance of the database driver */
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            
            /* connect to the databse */
            conn =  (Connection) DriverManager.getConnection(URL,dbUser,dbPass);
        }
        catch (Exception e) {
            
            /* output any errors to the console */
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
            /**
             * run method, opens the main menu
             */
            public void run() {
                
                /* create a new main menu*/
                MainMenu mainMenu = new MainMenu();
                
                /* make it visible */
                mainMenu.setVisible(true);
                
                /* but not resizable */
                mainMenu.setResizable(false);
            }
        }); 
    }
}
