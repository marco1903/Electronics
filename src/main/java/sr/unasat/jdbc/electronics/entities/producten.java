package sr.unasat.jdbc.electronics.entities;

public class producten {
    private int ProductID;
    private String Naam;
    private String Leverancier;
    private String VoorraadStatus;


    public producten(int productID, String naam, String leverancier, String voorraadStatus) {
        ProductID = productID;
        Naam = naam;
        Leverancier = leverancier;
        VoorraadStatus = voorraadStatus;
    }

    public producten(int productID) {
        ProductID = productID;
    }

    public producten(String naam, String voorraadStatus) {
        Naam = naam;
        VoorraadStatus = voorraadStatus;
    }

    //Getters & Setters
    public int getProductID() { return ProductID; }

    public void setProductID(int productID) { ProductID = productID; }

    public String getNaam() { return Naam; }

    public void setNaam(String naam) { Naam = naam; }

    public String getLeverancier() { return Leverancier; }

    public void setLeverancier(String leverancier) { Leverancier = leverancier; }

    public String getVoorraadStatus() { return VoorraadStatus; }

    public void setVoorraadStatus(String voorraadStatus) { VoorraadStatus = voorraadStatus; }

    @Override
    public String toString() {
        return  "ProductID: " + ProductID +
                "\nNaam: " + Naam +
                "\nLeverancier: " + Leverancier +
                "\nVoorraadStatus: " + VoorraadStatus;
    }
}
