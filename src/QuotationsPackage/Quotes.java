/**
 * Class for Quotes
 * Contains all the database querys and what not for the Quotes table
 * Some of this was generated with NetBeans, and modified as necessary
 * @author	Casey Harford & NetBeans
 */
package QuotationsPackage;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

@Entity
@Table(name = "Quotes", catalog = "quotations", schema = "")
@NamedQueries({
    @NamedQuery(name = "Quotes.findAll", query = "SELECT q FROM Quotes q"),
    @NamedQuery(name = "Quotes.findByQuoteNumber", query = "SELECT q FROM Quotes q WHERE q.quoteNumber = :quoteNumber"),
    @NamedQuery(name = "Quotes.findByQuote", query = "SELECT q FROM Quotes q WHERE q.quote = :quote"),
    @NamedQuery(name = "Quotes.findByAuthorID", query = "SELECT q FROM Quotes q WHERE q.authorID = :authorID"),
    @NamedQuery(name = "Quotes.findByUserID", query = "SELECT q FROM Quotes q WHERE q.userID = :userID"),
    @NamedQuery(name = "Quotes.findByLikes", query = "SELECT q FROM Quotes q WHERE q.likes = :likes")})
public class Quotes implements Serializable {
    
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "QuoteNumber")
    private Integer quoteNumber;
    @Basic(optional = false)
    @Column(name = "Quote")
    private String quote;
    @Basic(optional = false)
    @Column(name = "AuthorID")
    private int authorID;
    @Basic(optional = false)
    @Column(name = "UserID")
    private int userID;
    @Basic(optional = false)
    @Column(name = "Likes")
    private int likes;

    public Quotes() {
    }

    public Quotes(Integer quoteNumber) {
        this.quoteNumber = quoteNumber;
    }

    public Quotes(Integer quoteNumber, String quote, int authorID, int userID, int likes) {
        this.quoteNumber = quoteNumber;
        this.quote = quote;
        this.authorID = authorID;
        this.userID = userID;
        this.likes = likes;
    }

    public Integer getQuoteNumber() {
        return quoteNumber;
    }

    public void setQuoteNumber(Integer quoteNumber) {
        Integer oldQuoteNumber = this.quoteNumber;
        this.quoteNumber = quoteNumber;
        changeSupport.firePropertyChange("quoteNumber", oldQuoteNumber, quoteNumber);
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        String oldQuote = this.quote;
        this.quote = quote;
        changeSupport.firePropertyChange("quote", oldQuote, quote);
    }

    public int getAuthorID() {
        return authorID;
    }

    public void setAuthorID(int authorID) {
        int oldAuthorID = this.authorID;
        this.authorID = authorID;
        changeSupport.firePropertyChange("authorID", oldAuthorID, authorID);
    }

    public int getUserID() {
        return userID;
    }

    public String getUser() {
        int count = 0;
        String userFirst = "";
        String userLast = "";
        try {
            //check if user and password combo exist
            PreparedStatement ps;
            ResultSet rs = null;
            ps = (PreparedStatement) Quotations.conn.prepareStatement("SELECT FirstName,LastName FROM Users WHERE UserID = ?");
            ps.setInt(1,userID);
            rs = ps.executeQuery();
            while(rs.next()) {
                count++;
                userFirst = rs.getString("FirstName");
                userLast = rs.getString("LastName");
            }

        }
        catch(Exception e) {}
        if(count>0) return userFirst;
        else return "Unknown";
    }
    
    public String getAuthor() {
        int count = 0;
        String authorFirst = "";
        String authorLast = "";
        try {
            //check if user and password combo exist
            PreparedStatement ps;
            ResultSet rs = null;
            ps = (PreparedStatement) Quotations.conn.prepareStatement("SELECT FirstName,LastName FROM Authors WHERE AuthorID = ?");
            ps.setInt(1,authorID);
            rs = ps.executeQuery();
            while(rs.next()) {
                count++;
                authorFirst = rs.getString("FirstName");
                authorLast = rs.getString("LastName");
            }

        }
        catch(Exception e) {}
        if(count>0) { 
            Quotations.authors.add(authorFirst);
            return authorFirst; 
        }
        else return "Unknown";
    }

    public void setUserID(int userID) {
        int oldUserID = this.userID;
        this.userID = userID;
        changeSupport.firePropertyChange("userID", oldUserID, userID);
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        int oldLikes = this.likes;
        this.likes = likes;
        changeSupport.firePropertyChange("likes", oldLikes, likes);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (quoteNumber != null ? quoteNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quotes)) {
            return false;
        }
        Quotes other = (Quotes) object;
        if ((this.quoteNumber == null && other.quoteNumber != null) || (this.quoteNumber != null && !this.quoteNumber.equals(other.quoteNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "finalproject.Quotes[ quoteNumber=" + quoteNumber + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
