package projet2022;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class GestionLivre {
    private static final String DB_USER = "Yousenie";
    private static final String DB_PASS = "lordeus";
    private static final String DB_NAME = "bibliotheque_db";
public boolean addLivre(Livre livre) {
    ConnectToDb dbConnection = new ConnectToDb();
    String sql = "INSERT INTO livres (isbn, titre, auteur, annee) VALUES (?, ?, ?, ?)";

    try {
        dbConnection.chargerDriver();
        try (Connection conn = dbConnection.connexion(DB_USER, DB_PASS, DB_NAME);
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, livre.getIsbn());
            statement.setString(2, livre.getTitre());
            statement.setString(3, livre.getAuteur());
            statement.setInt(4, livre.getAnnee());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0; // true si l'enregistrement a réussi
        }
    } catch (Exception e) {
        System.out.println("Error while adding book: " + e.getMessage());
        return false;
    }
}

//    public void addLivre(Livre book) {
//        ConnectToDb dbConnection = new ConnectToDb();
//        String sql = "INSERT INTO livres (id, titre, auteur, edition, nbreExemp, status, etat) VALUES (?, ?, ?, ?, ?, ?, ?)";
//
//        try {
//            dbConnection.chargerDriver();
//            try (Connection conn = dbConnection.connexion(DB_USER, DB_PASS, DB_NAME);
//                 PreparedStatement statement = conn.prepareStatement(sql)) {
//                statement.setString(1, book.getCodeLivre());
//                statement.setString(2, book.getTitre());
//                statement.setString(3, book.getAuteur());
//                statement.setString(4, book.getEdition());
//                statement.setInt(5, book.getNbreExemp());
//                statement.setString(6, book.getStatut());
//                statement.setString(7, book.getEtat());
//
//                int rowsUpdated = statement.executeUpdate();
//                System.out.println(rowsUpdated + " record(s) inserted.");
//            }
//        } catch (Exception e) {
//            System.out.println("Error while adding book: " + e.getMessage());
//        }
//    }

    public ArrayList<Livre> getAllLivre() {
        ConnectToDb dbConnection = new ConnectToDb();
        ArrayList<Livre> bookList = new ArrayList<>();

        String sql = "SELECT * FROM livres";

        try {
            dbConnection.chargerDriver();
            try (Connection conn = dbConnection.connexion(DB_USER, DB_PASS, DB_NAME);
                 Statement statement = conn.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {
                
                while (resultSet.next()) {
                    String id = resultSet.getString("id");
                    String titre = resultSet.getString("titre");
                    String auteur = resultSet.getString("auteur");
                    String edition = resultSet.getString("edition");
                    String status = resultSet.getString("status");
                    String etat = resultSet.getString("etat");
                    int nbreExemp = resultSet.getInt("nbreExemp");

                    Livre book = new Livre(id, auteur, titre, edition, status, etat, nbreExemp);
                    bookList.add(book);
                }
            }
        } catch (Exception e) {
            System.out.println("Error while retrieving books: " + e.getMessage());
        }
        return bookList;
    }

    public Livre getBookById(String id) {
        ConnectToDb dbConnection = new ConnectToDb();
        Livre book = null;

        String sql = "SELECT * FROM livres WHERE id = ?";

        try {
            dbConnection.chargerDriver();
            try (Connection conn = dbConnection.connexion(DB_USER, DB_PASS, DB_NAME);
                 PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, id);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    String idbook = resultSet.getString("id");
                    String titre = resultSet.getString("titre");
                    String auteur = resultSet.getString("auteur");
                    String edition = resultSet.getString("edition");
                    String status = resultSet.getString("status");
                    String etat = resultSet.getString("etat");
                    int nbreExemp = resultSet.getInt("nbreExemp");

                    book = new Livre(idbook, auteur, titre, edition, status, etat, nbreExemp);
                }
            }
        } catch (Exception e) {
            System.out.println("Error while retrieving book by ID: " + e.getMessage());
        }
        return book;
    }

    public boolean deleteBook(String id) {
        ConnectToDb dbConnection = new ConnectToDb();
        String sql = "DELETE FROM livres WHERE id = ?";

        try {
            dbConnection.chargerDriver();
            try (Connection conn = dbConnection.connexion(DB_USER, DB_PASS, DB_NAME);
                 PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, id);
                int rowsAffected = statement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Record deleted successfully.");
                    return true;
                } else {
                    System.out.println("Failed to delete the record.");
                    return false;
                }
            }
        } catch (Exception e) {
            System.out.println("Error while deleting book: " + e.getMessage());
            return false;
        }
    }

    public void updateBook(Livre book) {
        ConnectToDb dbConnection = new ConnectToDb();
        String sql = "UPDATE livres SET titre = ?, auteur = ?, edition = ?, status = ?, etat = ?, nbreExemp = ? WHERE id = ?";

        try {
            dbConnection.chargerDriver();
            try (Connection conn = dbConnection.connexion(DB_USER, DB_PASS, DB_NAME);
                 PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, book.getTitre());
                statement.setString(2, book.getAuteur());
                statement.setString(3, book.getEdition());
                statement.setString(4, book.getStatut());
                statement.setString(5, book.getEtat());
                statement.setInt(6, book.getNbreExemp());
                statement.setString(7, book.getCodeLivre());

                int rowsAffected = statement.executeUpdate();
                System.out.println(rowsAffected + " row(s) updated successfully.");
            }
        } catch (Exception e) {
            System.out.println("Error while updating book: " + e.getMessage());
        }
    }

   
}
