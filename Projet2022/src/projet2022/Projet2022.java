 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet2022;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;

import com.projet2022.front.MainFrame;
/**
 *
 * @author Marie-Vonise LORDEUS
 */
public class Projet2022 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GestionAdherant gestAdherant = new GestionAdherant();
        Adherent adherant = new Adherent("Etu-002","29308i843","LORDEUS","Char","+5093894889","Delmas","FSA","Matin","L4");
        
        //add new adherant
        //gestAdherant.addAdherant(adherant);
        
        //get all the students
        ArrayList<Adherent> allAdherant = new ArrayList<>();
        allAdherant = gestAdherant.getAllAdherant();
        
        //print all the student
        System.out.println("All students");
        for (Adherent el : allAdherant) {
            // Faites quelque chose avec l'élément
            //System.out.println(el.toString());
        }
        
        //get student by id
        Adherent ad1;
        ad1 = gestAdherant.getdAherantById("Etu-001");
        //print a student by his id
        System.out.println("Print the stuent id Etu-001");
        //System.out.println(ad1.toString());
        
        //delete a student by id
        boolean dleete = gestAdherant.deleteAdherant("ETu-003");
        //System.out.println(dleete);
        
        //update a student
        //gestAdherant.updateAdherant(adherant);
        
        
        ///Methode livre
        GestionLivre gestLivre = new GestionLivre();
        Livre book = new Livre("Liv-003", "SHa", "Lavim san lanmou w", "2021", "Disp", "neuve", 2);
        
        //ajouter un nouveau livre
        System.out.println(book.toString());
        //gestLivre.addLivre(book);
        
        //get all the students
        ArrayList<Livre> allBook = new ArrayList<>();
        allBook = gestLivre.getAllLivre();
        
        //print all the student
        System.out.println("All books");
        for (Livre el : allBook) {
            // Faites quelque chose avec l'élément
            System.out.println(el.toString());
        }
        
        //get student by id
        Livre bookID;
        bookID = gestLivre.getBookById("Liv-003");
//        //print a student by his id
//        System.out.println("Print the book id Liv-003");
//        System.out.println(bookID.toString());
        
        //delete a book by id
        //boolean delete = gestLivre.deleteBook("Liv-003");
        //System.out.println(delete);
        
        //update a student
//        bookID.setTitre("mw pa imajine vim san u baby");
        //gestLivre.updateBook(bookID);
        
        //Methode pret
        GestionPret gestPret = new GestionPret();
        Pret pret = new Pret("Pre-001", "Liv-002", "Etu-001", "livre prete pou ...");
        //System.out.println(pret.toString());
        
        //gestPret.newPret(pret);
        
        //rekipere tout pre yo
        ArrayList<Pret> allPret = new ArrayList();
        allPret = gestPret.getAllPret();
        
        System.out.println("All pret");
        for(Pret el: allPret){
            System.out.println(el.toString());
        }
        
        //get student by id
        Pret pretID;
        pretID = gestPret.getPretById("Pre-001");
        //print a student by his id
        System.out.println("Print the pret id Pre-001");
        System.out.println(pretID.toString());
        
        //delete a pret by id
        //boolean deleteP = gestPret.deleteBook("Pre-001");
        //System.out.println(deleteP);
        
        
        //update a student
        pretID.setDescription("Livre prete pou li anpil bagay");
        gestPret.updateBook(pretID);
        
        MainFrame.main(args);
    }
    
}
