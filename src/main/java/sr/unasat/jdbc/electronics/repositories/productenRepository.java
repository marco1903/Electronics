package sr.unasat.jdbc.electronics.repositories;

import sr.unasat.jdbc.electronics.entities.producten;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class productenRepository {

    private Connection connection;

    public productenRepository() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //System.out.println("De driver is geregistreerd!");

            String URL = "jdbc:mysql://localhost/electronics n.v.";
            String USER = "root";
            String PASS = "12345678";
            connection = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("\n********************************************************************************************" +
                    "\nSuccessfully connected with database (Producten): " + connection
                    +"\n********************************************************************************************");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: unable to load driver class!");
            System.exit(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<producten> findAllRecords(){
        List<producten> productenlijst = new ArrayList<producten>();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "select * from producten";
            ResultSet rs = stmt.executeQuery(sql);
            //System.out.println("resultset: " + rs);

            //Extract data from resultset
            while (rs.next()) {

                int productID = rs.getInt("ProductID");
                String naam = rs.getString("Naam");
                String leverancier = rs.getString("Leverancier");
                String voorraadStatus = rs.getString("VoorraadStatus");

                productenlijst.add(new producten(productID, naam, leverancier, voorraadStatus));
            }

            rs.close();

        } catch (SQLException e) {

        } finally {

        }
        return productenlijst;
    }


    public int insertRecord(producten producten) {
        PreparedStatement stmt = null;
        int result = 0;
        try {
            String sql = "INSERT INTO producten VALUES(?, ?, ?, ?)";
            stmt = connection.prepareStatement(sql);

            stmt.setInt(1, producten.getProductID());
            stmt.setString(2, producten.getNaam());
            stmt.setString(3, producten.getLeverancier());
            stmt.setString(4, producten.getVoorraadStatus());
            result = stmt.executeUpdate();
            stmt.close();
            connection.close();
            //System.out.println("resultset: " + result);
            System.out.println("\nProduct toegevoegd!\n");

        } catch (SQLException e) {

        } finally {
            try {
                if (stmt != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return result;
    }

    public int deleteRecord(producten producten) {
        PreparedStatement stmt = null;
        int result = 0;
        try {
            String sql = "DELETE FROM producten WHERE producten.productID = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, producten.getProductID());
            result = stmt.executeUpdate();
            System.out.println("\nDeleted record with ProductID: " + producten.getProductID() + "\n");

        } catch (SQLException e) {

        } finally {

        }
        return result;
    }

    public int updateRecord(producten producten) {
        PreparedStatement stmt = null;
        int result = 0;
        try {
            String sql = "UPDATE producten SET voorraadstatus = ? WHERE naam = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, producten.getVoorraadStatus());
            stmt.setString(2, producten.getNaam());
            result = stmt.executeUpdate();
            System.out.println("\nDe voorraad van " + producten.getNaam() + " is gewijzigd naar " + producten.getVoorraadStatus() + "\n");

        } catch (SQLException e) {

        } finally {

        }
        return result;
    }
}
