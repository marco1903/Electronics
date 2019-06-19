package sr.unasat.jdbc.electronics.entities;

public class klanten {

    private int KlantID;
    private String Voornaam;
    private String Achternaam;
    private String Adres;
    private String IDnummer;
    private String Telefoonnummer;

    public klanten(int klantID, String voornaam, String achternaam, String adres, String IDnummer, String telefoonnummer) {
        KlantID = klantID;
        Voornaam = voornaam;
        Achternaam = achternaam;
        Adres = adres;
        this.IDnummer = IDnummer;
        Telefoonnummer = telefoonnummer;
    }

    public klanten(int klantID) {
        this.KlantID = klantID;
    }

    public klanten(String telefoonnummer, int klantID) {
        this.Telefoonnummer = telefoonnummer;
        this.KlantID = klantID;
    }


    //Getters & Setters
    public int getKlantID() {
        return KlantID;
    }

    public void setKlantID(int klantID) {
        KlantID = klantID;
    }

    public String getVoornaam() {
        return Voornaam;
    }

    public void setVoornaam(String voornaam) {
        Voornaam = voornaam;
    }

    public String getAchternaam() {
        return Achternaam;
    }

    public void setAchternaam(String achternaam) {
        Achternaam = achternaam;
    }

    public String getAdres() {
        return Adres;
    }

    public void setAdres(String adres) {
        Adres = adres;
    }

    public String getIDnummer() {
        return IDnummer;
    }

    public void setIDnummer(String IDnummer) {
        this.IDnummer = IDnummer;
    }

    public String getTelefoonnummer() {
        return Telefoonnummer;
    }

    public void setTelefoonnummer(String telefoonnummer) {
        Telefoonnummer = telefoonnummer;
    }

    @Override
    public String toString() {
        return  //"****************************" +
                "KlantID: " + KlantID +
                "\nVoornaam: " + Voornaam  +
                "\nAchternaam: " + Achternaam +
                "\nAdres: " + Adres +
                "\nIDnummer: " + IDnummer +
                "\nTelefoonnummer: " + Telefoonnummer;
    }
}

