
003
import java.sql.Connection;
004
import java.sql.DriverManager;
005
import java.sql.ResultSet;
006
import java.sql.SQLException;
007
import java.sql.Statement;
008

009
public class ScrollableResultSetExample {
010

011
 public static void main(String[] args) {
012

013
   Connection connection = null;
014
   try {
015

016
 // Load the MySQL JDBC driver
017

018
 String driverName = "com.mysql.jdbc.Driver";
019

020
 Class.forName(driverName);
021

022

023
 // Create a connection to the database
024

025
 String serverName = "localhost";
026

027
 String schema = "test";
028

029
 String url = "jdbc:mysql://" + serverName +  "/" + schema;
030

031
 String username = "username";
032

033
 String password = "password";
034

035
 connection = DriverManager.getConnection(url, username, password);
036

037

038

039
 System.out.println("Successfully Connected to the database!");
040

041

042
   } catch (ClassNotFoundException e) {
043

044
 System.out.println("Could not find the database driver " + e.getMessage());
045
   } catch (SQLException e) {
046

047
 System.out.println("Could not connect to the database " + e.getMessage());
048
   }
049

050
   try {
051

052

053
 /*
054

055
   * An insensitive scrollable result set is one where the values captured in the
056

057
   * result set never change, even if changes are made to the table from which the
058

059
   * data was retrieved.
060

061
   * A sensitive scrollable result set is one where the current values in the table
062

063
   * are reflected in the result set. So if a change is made to a row in the table,
064

065
   * the result set will show the new data when the cursor is moved to that row
066

067
   */
068

069

070
 // Create an insensitive scrollable result set (for sensitive scrollable result sets use ResultSet.TYPE_SCROLL_SENSITIVE directive)
071

072
 Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
073

074
 ResultSet results = statement.executeQuery("SELECT * FROM test_table");
075

076

077
 // Get cursor position
078

079
 System.out.println("Cursor position " + results.getRow() + ", is before first ? " + results.isBeforeFirst());
080

081

082
 // Every call to next() moves cursor to the next row - in this case the first row
083

084
 results.next();
085

086

087
 // Get cursor position
088

089
 System.out.println("Cursor position " + results.getRow() + ", is first ? " + results.isFirst());
090

091

092
 // A call to last() moves cursor to the last row; the row number is also the row count
093

094
 results.last();
095

09// Get cursor position
System.out.println("Cursor position " + results.getRow() + ", is last ? " + results.isLast());
// A call to after last moves cursor past last row (before first row)
results.afterLast();
// Get cursor position
System.out.println("Cursor position " + results.getRow() + ", is after last ? " + results.isAfterLast());
// Move cursor to the third row
results.absolute(3);
// Get cursor position
System.out.println("Cursor position " + results.getRow());
// Move cursor to the last row
results.absolute(-1);
// Get cursor position
System.out.println("Cursor position " + results.getRow() + ", is last ? " + results.isLast());
// Move cursor to the forth last row
results.absolute(-4);
 // Get cursor position
System.out.println("Cursor position " + results.getRow());

 // Move cursor down 5 rows from the current row.  If this moves
 // cursor beyond the last row, cursor is put after the last row
results.relative(5);

 // Get cursor position
System.out.println("Cursor position " + results.getRow() + ", is after last ? " + results.isAfterLast());
 // Move cursor up 13 rows from the current row.  If this moves
 // cursor beyond the first row, cursor is put before the first row
results.relative(-13);
 // Get cursor p
System.out.println("Cursor position " + results.getRow() + ", is before first ? " + results.isBeforeFirst());
} catch (SQLException e) {
   System.out.println("Could not retrieve data from the database " + e.getMessage());
}
 }
}
