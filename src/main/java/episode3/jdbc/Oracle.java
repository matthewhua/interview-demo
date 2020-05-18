package episode3.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Oracle {
    public static void main(String[] args) throws ClassCastException, SQLException{

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("驱动加载成功");
           // Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","root");
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String user = "scott";
            String password = "root";
            Connection conn = DriverManager.getConnection(url,user,password);
            System.out.println("连接成功");
            Statement statement=conn.createStatement();
            String sql = "select * from account ";
            ResultSet rs=statement.executeQuery(sql);
            List<Account> accounts=new ArrayList<>();
            //System.out.println(rs.getString("name"));
            //显示全名
           while (rs.next()){
               Account account = new Account();
               account.setName(rs.getString("NAME"));
               accounts.add(account);
            }
            rs.close();
            for (Account a : accounts) {
                System.out.println(a);
            }
            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            //抛出异常
            e.printStackTrace();
        }



    }
}
