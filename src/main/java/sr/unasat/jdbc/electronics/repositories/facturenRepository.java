package sr.unasat.jdbc.electronics.repositories;

import sr.unasat.jdbc.electronics.entities.facturen;
import sr.unasat.jdbc.electronics.entities.klanten;
import sr.unasat.jdbc.electronics.entities.producten;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class facturenRepository {
    private Connection connection;

    public facturenRepository() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //System.out.println("De driver is geregistreerd!");

            String URL = "jdbc:mysql://localhost/electronics n.v.";
            String USER = "root";
            String PASS = "12345678";
            connection = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("\n********************************************************************************************" +
                    "\nSuccessfully connected with database (facturen): " + connection
                    +"\n********************************************************************************************");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: unable to load driver class!");
            System.exit(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<facturen> findAllRecords() {
        List<facturen> facturenLijst = new ArrayList<facturen>();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "SELECT f.FactuurNummer, f.ProductNaam, f.TotaalBedrag, f.KlantID, f.ProductID, k.KlantID kKlantID, k.Voornaam kVoornaam, k.Achternaam kAchternaam, k.Adres kAdres, k.IDnummer kIDnummer, k.Telefoonnummer kTelefoonnummer, p.ProductID pProductID, p.Naam pNaam, p.Leverancier pLeverancier, p.VoorraadStatus pVoorraadStatus " +
                    "FROM facturen f " +
                    "JOIN klanten k " +
                    "ON k.KlantID = f.KlantID " +
                    "JOIN producten p " +
                    "ON p.ProductID = f.ProductID ";

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                int factuurnummer = rs.getInt("FactuurNummer");
                String productnaam = rs.getString("ProductNaam");
                int totaalbedrag = rs.getInt("TotaalBedrag");
                int k_klantid = rs.getInt("KlantID");
                int p_productid = rs.getInt("ProductID");

                int klantID = rs.getInt("kKlantid");
                String voornaam = rs.getString("kVoornaam");
                String achternaam = rs.getString("kAchternaam");
                String adres = rs.getString("kAdres");
                String IDnummer = rs.getString("kIDnummer");
                String telefoonnummer = rs.getString("kTelefoonnummer");
                klanten klanten = new klanten(klantID, voornaam, achternaam, adres, IDnummer, telefoonnummer);

                int productID = rs.getInt("pProductID");
                String naam = rs.getString("pNaam");
                String leverancier = rs.getString("pLeverancier");
                String voorraadStatus = rs.getString("pVoorraadStatus");
                producten producten = new producten(productID, naam, leverancier, voorraadStatus);

                facturenLijst.add(new facturen(factuurnummer, productnaam, totaalbedrag, klanten, producten));
            }
            rs.close();

        } catch(SQLException e) {

        }finally {

        }
        return facturenLijst;
    }



    public int insertRecord(facturen facturen) {
        PreparedStatement stmt = null;
        int result = 0;
        try {
            String sql = "INSERT INTO facturen VALUES(?, ?, ?, ?, ?)";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, facturen.getFactuurNummer());
            stmt.setString(2, facturen.getProductnaam());
            stmt.setInt(3, facturen.getTotaalBedrag());
            stmt.setInt(4, facturen.getKlanten().getKlantID());
            stmt.setInt(5, facturen.getProducten().getProductID());

            result = stmt.executeUpdate();
            stmt.close();
            connection.close();
            //System.out.println("resultset: " + result);
            System.out.println("\nNieuwe factuur aangemaakt!\n");

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



    public int deleteRecord(facturen facturen) {
        PreparedStatement stmt = null;
        int result = 0;
        try {
            String sql = "DELETE FROM facturen WHERE facturen.factuurnummer = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, facturen.getFactuurNummer());
            result = stmt.executeUpdate();
            System.out.println("\nFactuur met factuurnummer: " + facturen.getFactuurNummer() + " verwijderd!");

        } catch (SQLException e) {

        } finally {

        }
        return result;
    }

    public int updateRecords(facturen facturen) {
        PreparedStatement stmt = null;
        int result = 0;
        try {
            String sql =  "update facturen " +
                    "set facturen.klantid = ?, facturen.productid = ? " +
                    "where factuurnummer = ? ";

            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, facturen.getKlanten().getKlantID());
            stmt.setInt(2, facturen.getProducten().getProductID());
            stmt.setInt(3,facturen.getFactuurNummer());
            result = stmt.executeUpdate();
            //System.out.println("resultset: " + result);
            System.out.println("\nFactuur updated!");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
        return result;
    }
}
