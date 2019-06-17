package ua.kpi.tef;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
	// write your code here

        byte value1 = 123;
        byte value2 = 2;
        TestJUnit test = new TestJUnit();
        byte sum = test.getSum(value1, value2);
        double division = test.getDivision(value1, value2);
        System.out.println("SUM = " + sum);
        System.out.println("DIV = " + division);

        Connection con =
                DriverManager.
                        getConnection(  "jdbc:"+
                                        "mysql:"+
                                        "//localhost/"+
                                        //"world" ,
                                        "mydbtest",
                                "root" ,
                                "root");

        Statement query = con.createStatement();
        //ResultSet rs = query.executeQuery("SELECT * FROM city");
        ResultSet rs = query.executeQuery("SELECT * FROM users");
        while( rs.next()) {
            System.out.println(rs.getString("Name"));
        }
    }

}
