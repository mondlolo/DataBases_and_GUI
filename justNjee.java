import java.sql.*;
import javax.swing.JOptionPane;
import java.util.*;
import java.io.*;

class justNjee{

public static void main(String args[]){
  String var1 ="";
  String num1, num2;
  int number1, number2, sum;

  num1 = JOptionPane.showInputDialog("num1");
  //number1 = Integer.parseInt(num1);

  num2 = JOptionPane.showInputDialog("num2");
  // number2 = Integer.parseInt(num2);

  String query ="select * from "+ num1 +" WHERE StuID = "+num2;

try{

Connection con=DriverManager.getConnection(
"jdbc:mysql://localhost:3306/Assignment4DataBase","root","l@ppy2018!");

Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery(query);
if(num1 == "UniData"){
  while(rs.next())
  var1 += (rs.getString("Course")+" "+rs.getString("Credits")+" "+rs.getString("StuID"))+"\n";
  con.close();
}else{
  while(rs.next())
  var1 += (rs.getString("FirstName")+" "+rs.getString("Gender")+" "+rs.getString("UCTScore"))+"\n";
  con.close();

}
}catch(Exception e){ System.out.println(e);}

// sum =  number2;
JOptionPane.showMessageDialog(null, "the results are as follows : " + "\n" + var1 , "Results", JOptionPane.PLAIN_MESSAGE );
//System.out.println(var1);
System.exit(0);
}
}
