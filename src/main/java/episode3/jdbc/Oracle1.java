package episode3.jdbc;

import java.sql.*;

public class Oracle1 {
    public static void main(String[] args) throws ClassCastException,SQLException{

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","root");
            PreparedStatement ps = connection.prepareStatement("select * from account");
            /*ps.setString(2,"laohu");*/
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString("name")+ " - ");
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
