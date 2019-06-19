package sr.unasat.jdbc.electronics.repositories;

import sr.unasat.jdbc.electronics.entities.klanten;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class klantenRepository {

    private Connection connection;

    public klantenRepository() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //System.out.println("De driver is geregistreerd!");

            String URL = "jdbc:mysql://localhost/electronics n.v.";
            String USER = "root";
            String PASS = "12345678";
            connection = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("\n********************************************************************************************" +
                    "\nSuccessfully connected with database (Klanten): " + connection
            +"\n********************************************************************************************");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: unable to load driver class!");
            System.exit(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<klanten> findAllRecords(){
        List<klanten> klantenlijst = new ArrayList<klanten>();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "select * from klanten";
            ResultSet rs = stmt.executeQuery(sql);
            //System.out.println("resultset: " + rs);

            //Extract data from resultset
            while (rs.next()) {

                int klantID = rs.getInt("KlantID");
                String voornaam = rs.getString("Voornaam");
                String achternaam = rs.getString("Achternaam");
                String adres = rs.getString("Adres");
                String IDnummer = rs.getString("IDnummer");
                String telefoonnummer = rs.getString("Telefoonnummer");

                klantenlijst.add(new klanten(klantID, voornaam, achternaam, adres, IDnummer,telefoonnummer));
            }

            rs.close();

        } catch (SQLException e) {

        } finally {

        }
        return klantenlijst;
    }


    public int insertRecord(klanten klanten) {
        PreparedStatement stmt = null;
        int result = 0;
        try {
            String sql = "INSERT INTO klanten VALUES(?, ?, ?, ?, ?, ? )";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, klanten.getKlantID());
            stmt.setString(2, klanten.getVoornaam());
            stmt.setString(3, klanten.getAchternaam());
            stmt.setString(4, klanten.getAdres());
            stmt.setString(5, klanten.getIDnummer());
            stmt.setString(6, klanten.getTelefoonnummer());
            result = stmt.executeUpdate();
            stmt.close();
            connection.close();
            //System.out.println("resultset: " + result);
            System.out.println("\nKlant toegevoegd!\n");

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

    public int deleteRecord(klanten klanten) {
        PreparedStatement stmt = null;
        int result = 0;
        try {
            String sql = "DELETE FROM klanten WHERE klanten.klantID = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, klanten.getKlantID());
            result = stmt.executeUpdate();
            System.out.println("\nDeleted record with KlantID: " + klanten.getKlantID());

        } catch (SQLException e) {

        } finally {

        }
        return result;
    }

    public int updateRecord(klanten klanten) {
        PreparedStatement stmt = null;
        int result = 0;
        try {
            String sql = "UPDATE klanten SET telefoonnummer = ? WHERE klantID = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, klanten.getTelefoonnummer());
            stmt.setInt(2, klanten.getKlantID());
            result = stmt.executeUpdate();
            System.out.println("\nTelefoonnummer van klant met KlantID: " + klanten.getKlantID()+ " is gewijzigd naar: " + klanten.getTelefoonnummer());

        } catch (SQLException e) {

        } finally {

        }
        return result;
    }
}
