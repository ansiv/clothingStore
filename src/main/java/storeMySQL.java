import java.sql.*;

public class storeMySQL {
    // JDBC URL, username and password of MySQL server

    private static final String url = "jdbc:mysql://localhost/store?serverTimezone=Asia/Krasnoyarsk&useSSL=false";
    private static final String user = "root";
    private static final String password = "root";

    // JDBC variables for opening and managing connection
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public static void main(String[] args) {

        String query = "SELECT customers.customer_name, products.product_name, purchases.date_of_purchase, purchases.quantity, purchases.purchase_price, purchases.purchase_price * purchases.quantity AS cost " +
                "FROM store.purchases" +
                " inner join store.customers on customers.id = purchases.customer_id" +
                " inner join store.products on products.id = purchases.product_id" +
                " order by purchases.date_of_purchase";
        try {
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            System.out.printf("%-25s | %-5s | %-19s | %-12s | %-15s | %-15s\n", "Покупатель", "Продукт" , "Дата покупки" , "Колличество" , "Цена товара" , "Сумма покупки");
            while (rs.next()) {
                String customerName = rs.getString("customers.customer_name");
                String productName = rs.getString("products.product_name");
                String date = rs.getString("purchases.date_of_purchase");
                int quantity = rs.getInt("purchases.quantity");
                float purchasePrice = rs.getFloat("purchases.purchase_price");
                float cost = rs.getFloat("cost");
                System.out.printf("%-25s | %-7s | %-5s | %-12d | %-15.1f | %-15.1f\n", customerName, productName , date , quantity , purchasePrice , cost);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try { con.close(); } catch(SQLException se) { /* */ }
            try { stmt.close(); } catch(SQLException se) { /* */ }
            try { rs.close(); } catch(SQLException se) { /**/ }
        }
    }
}
