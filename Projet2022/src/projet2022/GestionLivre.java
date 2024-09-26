/*
 * To change this license hebooker, choose License Hebookers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet2022;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;

/**
 * Classe pour la gestion des livres dans la bibliothèque
 * Auteur : Marie-Vonise LORDEUS
 */
public class GestionLivre {

    // Méthode pour ajouter un livre
    public void addLivre(Livre book) {
        ConnectToDb dbConnection = new ConnectToDb();
        String req = "INSERT INTO `livres` (`id`, `titre`, `auteur`, `edition`, `nbreExemp`, `status`, `etat`) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            dbConnection.chargerDriver();
            try (Connection conn = dbConnection.connexion("Yousenie", "lordeus", "bibliotheque_db");
                 PreparedStatement preparedStatement = conn.prepareStatement(req)) {

                preparedStatement.setString(1, book.getCodeLivre());
                preparedStatement.setString(2, book.getTitre());
                preparedStatement.setString(3, book.getAuteur());
                preparedStatement.setString(4, book.getEdition());
                preparedStatement.setInt(5, book.getNbreExemp());
                preparedStatement.setString(6, book.getStatut());
                preparedStatement.setString(7, book.getEtat());

                int rowsUpdated = preparedStatement.executeUpdate();
                System.out.println(rowsUpdated + " livre(s) ajouté(s) avec succès.");
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de l'ajout du livre : " + e);
        }
    }

    // Méthode pour obtenir tous les livres
    public ArrayList<Livre> getAllLivre() {
        ConnectToDb dbConnection = new ConnectToDb();
        ArrayList<Livre> myList = new ArrayList<>();
        
        try {
            dbConnection.chargerDriver();
            try (Connection conn = dbConnection.connexion("Yousenie", "lordeus", "bibliotheque_db");
                 Statement stat = dbConnection.requete(conn)) {

                String req = "SELECT * FROM livres";
                ResultSet res = stat.executeQuery(req);

                while (res.next()) {
                    String id = res.getString("id");
                    String titre = res.getString("titre");
                    String auteur = res.getString("auteur");
                    String edition = res.getString("edition");
                    String status = res.getString("status");
                    String etat = res.getString("etat");
                    int nbreExemp = res.getInt("nbreExemp");

                    Livre book = new Livre(id, auteur, titre, edition, status, etat, nbreExemp);
                    myList.add(book);
                }
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de la récupération des livres : " + e);
        }
        return myList;
    }

    // Méthode pour obtenir un livre par son ID
    public Livre getBookById(String id) {
        ConnectToDb dbConnection = new ConnectToDb();
        Livre book = null;

        try (Connection conn = dbConnection.connexion("Yousenie", "lordeus", "bibliotheque_db");
             PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM livres WHERE id = ?")) {

            preparedStatement.setString(1, id);
            ResultSet res = preparedStatement.executeQuery();

            if (res.next()) {
                String idbook = res.getString("id");
                String titre = res.getString("titre");
                String auteur = res.getString("auteur");
                String edition = res.getString("edition");
                String status = res.getString("status");
                String etat = res.getString("etat");
                int nbreExemp = res.getInt("nbreExemp");

                book = new Livre(idbook, auteur, titre, edition, status, etat, nbreExemp);
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de la récupération du livre : " + e);
        }
        return book;
    }

    // Méthode pour supprimer un livre
    public boolean deleteBook(String id) {
        ConnectToDb dbConnection = new ConnectToDb();
        String req = "DELETE FROM livres WHERE id = ?";

        try (Connection conn = dbConnection.connexion("Yousenie", "lordeus", "bibliotheque_db");
             PreparedStatement preparedStatement = conn.prepareStatement(req)) {

            preparedStatement.setString(1, id);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Livre supprimé avec succès.");
                return true;
            } else {
                System.out.println("Échec de la suppression du livre.");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de la suppression du livre : " + e);
            return false;
        }
    }

    // Méthode pour mettre à jour un livre
    public void updateBook(Livre book) {
        ConnectToDb dbConnection = new ConnectToDb();
        String sql = "UPDATE livres SET titre = ?, auteur = ?, edition = ?, status = ?, etat = ?, nbreExemp = ? WHERE id = ?";

        try (Connection conn = dbConnection.connexion("Yousenie", "lordeus", "bibliotheque_db");
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setString(1, book.getTitre());
            preparedStatement.setString(2, book.getAuteur());
            preparedStatement.setString(3, book.getEdition());
            preparedStatement.setString(4, book.getStatut());
            preparedStatement.setString(5, book.getEtat());
            preparedStatement.setInt(6, book.getNbreExemp());
            preparedStatement.setString(7, book.getCodeLivre());

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(rowsAffected + " livre(s) mis à jour avec succès.");
        } catch (Exception e) {
            System.out.println("Erreur lors de la mise à jour du livre : " + e);
        }
    }
}
