/**
 * Class for RowSorterToStringConverter
 * Source: http://netbeans.org/kb/67/java/gui-db-custom.html
 * This class is used for the search function. It performs a filter
 * on the columns, matching a regular expression
 */
package QuotationsPackage;

import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

import org.jdesktop.beansbinding.Converter;

/**
 * Binding converter between String and regex RowFilter (encapsulated by RowSorterToStringConverter).
 * 
*/
public class RowSorterToStringConverter extends Converter {

    /* defining table */
    private JTable table;

    /**
     * getTable method
     * @return the table
     */
    public JTable getTable() {
        return table;
    }

    /**
     * setTable method, 
     */
    public void setTable(JTable table) {
        this.table = table;
    }

    @Override
    public Object convertForward(Object value) {
        return value.toString();
    }

    @Override
    public Object convertReverse(Object mask) {
        TableRowSorter sorter = new TableRowSorter(table.getModel());
        String m = mask.toString();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m.length(); i++) {
            char c = m.charAt(i);
            sb.append('[').append(Character.toLowerCase(c)).append(Character.toUpperCase(c)).append(']');
        }
        sorter.setRowFilter(RowFilter.regexFilter(".*" + sb + ".*"));
        return sorter;
    }
}
