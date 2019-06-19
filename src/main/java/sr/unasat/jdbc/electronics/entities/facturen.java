package sr.unasat.jdbc.electronics.entities;

public class facturen {

    private int FactuurNummer;
    private String Productnaam;
    private int TotaalBedrag;
    private klanten klanten;
    private producten producten;


    public facturen(int factuurNummer, String productnaam, int totaalBedrag, sr.unasat.jdbc.electronics.entities.klanten klanten, sr.unasat.jdbc.electronics.entities.producten producten) {
        FactuurNummer = factuurNummer;
        Productnaam = productnaam;
        TotaalBedrag = totaalBedrag;
        this.klanten = klanten;
        this.producten = producten;
    }

    public facturen(int factuurNummer) {
        FactuurNummer = factuurNummer;
    }

    public facturen(int factuurNummer, sr.unasat.jdbc.electronics.entities.klanten klanten, sr.unasat.jdbc.electronics.entities.producten producten) {
        this.FactuurNummer = factuurNummer;
        this.klanten = klanten;
        this.producten = producten;
    }

    //Getters & Setters
    public int getFactuurNummer() {
        return FactuurNummer;
    }

    public void setFactuurNummer(int factuurNummer) {
        FactuurNummer = factuurNummer;
    }

    public String getProductnaam() {
        return Productnaam;
    }

    public void setProductnaam(String productnaam) {
        Productnaam = productnaam;
    }

    public int getTotaalBedrag() {
        return TotaalBedrag;
    }

    public void setTotaalBedrag(int totaalBedrag) {
        TotaalBedrag = totaalBedrag;
    }

    public sr.unasat.jdbc.electronics.entities.klanten getKlanten() {
        return klanten;
    }

    public void setKlanten(sr.unasat.jdbc.electronics.entities.klanten klanten) {
        this.klanten = klanten;
    }

    public sr.unasat.jdbc.electronics.entities.producten getProducten() {
        return producten;
    }

    public void setProducten(sr.unasat.jdbc.electronics.entities.producten producten) {
        this.producten = producten;
    }

    @Override
    public String toString() {
        return "Factuurgegevens:" +
                "\nFactuurNummer: " + FactuurNummer +
                "\nProductnaam: " + Productnaam +
                "\nTotaalBedrag: " + TotaalBedrag +
                "\n" +klanten +
                "\n" + producten;
    }
}


