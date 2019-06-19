package sr.unasat.jdbc.electronics.app;

import sr.unasat.jdbc.electronics.entities.facturen;
import sr.unasat.jdbc.electronics.entities.klanten;
import sr.unasat.jdbc.electronics.entities.producten;
import sr.unasat.jdbc.electronics.repositories.facturenRepository;
import sr.unasat.jdbc.electronics.repositories.klantenRepository;
import sr.unasat.jdbc.electronics.repositories.productenRepository;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        //TABEL KLANTEN:
        //klantenRepository klantenRepo = new klantenRepository();

        //List<klanten> klantenlijst = klantenRepo.findAllRecords();
        //for (klanten klanten : klantenlijst) {
        //   System.out.println(klanten);
        //}

        //int add = klantenRepo.insertRecord(new klanten(2, "Anna", "Bella", "Annie Beckstraat 5", "FF007781V", "8592222"));
        //int delete = klantenRepo.deleteRecord(new klanten(2));
        //int update = klantenRepo.updateRecord(new klanten("85922223", 2));


        //TABEL PRODUCTEN
        //productenRepository productenRepo = new productenRepository();

        //List<producten> productenlijst = productenRepo.findAllRecords();
        //for (producten producten: productenlijst) {
        //    System.out.println(producten);
        //}

        //int add = productenRepo.insertRecord(new producten(1, "Printers", "HP", "50"));
        //int delete = productenRepo.deleteRecord(new producten(1));
        //int update = productenRepo.updateRecord(new producten("monitors", "36"));



        //TABEL FACTUREN (T3)
        //facturenRepository facturenRepo = new facturenRepository();

        //List<facturen> facturenLijst = facturenRepo.findAllRecords();
        //for (facturen facturen: facturenLijst) {
         //   System.out.println(facturen);
        //}

       //int add = facturenRepo.insertRecord(new facturen(2, "Monitors",500, new klanten(2), new producten(2)));
        //int delete = facturenRepo.deleteRecord(new facturen(1));
        //int update = facturenRepo.updateRecords(new facturen(1, new klanten( 1), new producten(1)));

    }
}
