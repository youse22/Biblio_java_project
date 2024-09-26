/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet2022;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 *
 * @author Marie-Vonise LORDEUS
 */
public class GestionAdherant {
    
 public void addAdherant(Adherent ad){
    ConnectToDb dbConnection = new ConnectToDb();
    // Suppression de la colonne 'id_e' de la requête d'insertion
    String req = "INSERT INTO Adherant (cin, last_name, first_name, phone, adresse, faculte, vacation, niveau) "
               + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    try {
        dbConnection.chargerDriver();     
        try (Connection conn = dbConnection.connexion("Yousenie", "lordeus", "bibliotheque_db");
             PreparedStatement stmt = conn.prepareStatement(req)) {

            // Modification pour correspondre aux nouvelles colonnes (sans id_e)
            stmt.setString(1, ad.getCin());
            stmt.setString(2, ad.getLast_name());
            stmt.setString(3, ad.getFirst_name());
            stmt.setString(4, ad.getPhone());
            stmt.setString(5, ad.getAddress());
            stmt.setString(6, ad.getFaculte());
            stmt.setString(7, ad.getVacation());
            stmt.setString(8, ad.getNiveau());

            int rowsUpdated = stmt.executeUpdate();
            System.out.println(rowsUpdated + " row(s) affected.");

        } catch (SQLException e) {
            e.printStackTrace(); // Affiche une trace complète de l'erreur
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

//    public void addAdherant(Adherent ad){
//        ConnectToDb dbConection = new ConnectToDb();
//        
//        //Adherent ad = new Adherent("Etu-002","2930893789","LORDEUS","Vonise","+50938579489","Delmas","FSA","Matin","L4");
//        String b ="";
//        String req3 ="INSERT INTO `Adherant` (`id_e`, `cin`,`last_name`,`first_name`,`phone`,`adresse`,`faculte`,`vacation`,"
//                + "`niveau`)VALUES ('"+ad.getId_etu()+"', '"+ad.getCin()+"', '"+ad.getLast_name()+"', '"+ad.getFirst_name()+"',"
//                + "'"+ad.getPhone()+"','"+ad.getAddress()+"','"+ad.getFaculte()+"','"+ad.getVacation()+"','"+ad.getNiveau()+"')";
//        
//        //String req ="INSERT INTO `Adherant` (`id_e`, `cin`,`last_name`,`first_name`,`phone`,`adresse`,`faculte`,`vacation`,"
//        //       + "`niveau`)VALUES ('Etu-001', '1234987230', 'LORDEUS', 'Max-Gary','50948175665','Delmas 33',"
//        //        + "'FSI','Matin','L3')";
//        
//        try{
//            dbConection.chargerDriver();     
//            try (Connection conn = dbConection.connexion("Yousenie", "lordeus", "bibliotheque_db")) {
//
//                Statement stat = dbConection.requete(conn);
//                //String req1 ="select * from Adherant";
//                int rowsUpdated = stat.executeUpdate(req3);
//                System.out.println(rowsUpdated);
//                //ResultSet res = stat.executeQuery(req1);
//                conn.close();
//            }
//            
//        }catch(Exception e){
//            System.out.println("error"+ e);
//        }
//    }
//    
//    //get all the students
    // Récupérer tous les adhérents avec statut visible
public ArrayList<Adherent> getAllAdherant() {
    // Connexion à la base de données
    ConnectToDb dbConection = new ConnectToDb();
    
    // Déclarer une liste pour ajouter tous les adhérents
    ArrayList<Adherent> myList = new ArrayList<>();
    Adherent adhe;

    try {
        dbConection.chargerDriver();     
        try (Connection conn = dbConection.connexion("Yousenie", "lordeus", "bibliotheque_db")) {

            Statement stat = dbConection.requete(conn);
            // Modifier la requête pour ne récupérer que les adhérents visibles
            String req1 = "SELECT * FROM Adherant WHERE statut = 'visible'";
            ResultSet res = stat.executeQuery(req1);
            
            while (res.next()) {
                String id = res.getString("id_e");
                String cin = res.getString("cin");
                String last_name = res.getString("last_name");
                String first_name = res.getString("first_name");
                String phone = res.getString("phone");
                String address = res.getString("adresse");
                String faculte = res.getString("faculte");
                String vacation = res.getString("vacation");
                String niveau = res.getString("niveau");
                
                adhe = new Adherent(id, cin, last_name, first_name, phone, address, faculte, vacation, niveau);
                myList.add(adhe);
            }
            conn.close();
        }
    } catch (Exception e) {
        System.out.println("Error: " + e);
    }
    
    return myList;
}

//    public ArrayList<Adherent> getAllAdherant(){
//        //connect to the databse
//        ConnectToDb dbConection = new ConnectToDb();
//        
//        //declare a list to add all the students
//        ArrayList<Adherent> myList = new ArrayList<>();
//        Adherent adhe;
//        
//        //= new Adherent("Etu-003","29308i843","LORDEUS","Char","+5093894889","Delmas","FSA","Matin","L4");
//        
//        try{
//            dbConection.chargerDriver();     
//            try (Connection conn = dbConection.connexion("Yousenie", "lordeus", "bibliotheque_db")) {
//
//                Statement stat = dbConection.requete(conn);
//                String req1 ="select * from Adherant";
//                ResultSet res = stat.executeQuery(req1);
//                
//                while(res.next()){
//                    String id = res.getString("id_e");
//                    String cin = res.getString("cin");
//                    String last_name = res.getString("last_name");
//                    String first_name = res.getString("first_name");
//                    String phone= res.getString("phone");
//                    String address = res.getString("adresse");
//                    String faculte = res.getString("faculte");
//                    String vacation = res.getString("vacation");
//                    String niveau = res.getString("niveau");
//                    
//                    adhe = new Adherent(id, cin, last_name,first_name, phone,address,faculte,vacation,niveau);
//                    myList.add(adhe);
//                }
//                conn.close();
//            }
//        }catch(Exception e){
//            System.out.println("error"+ e);
//        }
//        
//        return myList;
//    }
//    
    //get a student by his id
    public Adherent getdAherantById(String id){
        //connect to the databse
        ConnectToDb dbConection = new ConnectToDb();
         Adherent adhe;
       
        try(Connection conn = dbConection.connexion("Yousenie", "lordeus", "bibliotheque_db")){
            Statement stat = dbConection.requete(conn);
            
            String req1 =String.format("select * from Adherant where id_e=\"%s\"", id);
            ResultSet res = stat.executeQuery(req1);
            
            while(res.next()){
                String id1 = res.getString("id_e");
                String cin = res.getString("cin");
                String last_name = res.getString("last_name");
                String first_name = res.getString("first_name");
                String phone= res.getString("phone");
                String address = res.getString("adresse");
                String faculte = res.getString("faculte");
                String vacation = res.getString("vacation");
                String niveau = res.getString("niveau");

                adhe = new Adherent(id1, cin, last_name,first_name, phone,address,faculte,vacation,niveau);
                return adhe;
            }
            conn.close();
        }catch(Exception e){
            System.out.println("error"+ e);
        }
        adhe = new Adherent("null","","","","","","","","");

        return adhe;
    }
    
    //Delete student
    public boolean deleteAdherant(String id) {
    // Connect to the database
    ConnectToDb dbConection = new ConnectToDb();
    
    // SQL query to update the statut to "hidden"
    String req1 = String.format("UPDATE adherant SET statut='hidden' WHERE id_e=\"%s\"", id);
    
    try (Connection conn = dbConection.connexion("Yousenie", "lordeus", "bibliotheque_db")) {
        Statement stat = dbConection.requete(conn);
        
        int rowsAffected = stat.executeUpdate(req1);
        
        if (rowsAffected > 0) {
            System.out.println("Record status updated to hidden successfully.");
            return true;
        } else {
            System.out.println("Failed to update the record status.");
            return false;
        }
        
    } catch (Exception e) {
        System.out.println(e);
        return false;
    }
}

//    public boolean deleteAdherant(String id){
//        //connect to the database
//        ConnectToDb dbConection = new ConnectToDb();
//        
//        String req1 = String.format("delete from adherant where id_e=\"%s\"", id);
//        
//        try(Connection conn = dbConection.connexion("Yousenie", "lordeus", "bibliotheque_db")){
//            Statement stat = dbConection.requete(conn);
//            
//            int rowsAffected = stat.executeUpdate(req1);
//            conn.close();
//            
//            if (rowsAffected > 0) {
//                System.out.println("Record deleted successfully.");
//                return true;
//            } else {
//                System.out.println("Failed to delete the record.");
//                return false;
//            }
//            
//        }catch(Exception e){
//            System.out.println(e);
//            return false;
//        }  
//    }
//    
    //update adherant
    public void updateAdherant(Adherent adhe) {
    ConnectToDb dbConnection = new ConnectToDb();
    PreparedStatement statement = null;
    
    try (Connection conn = dbConnection.connexion("Yousenie", "lordeus", "bibliotheque_db")) {
        if (conn == null) {
            System.out.println("Erreur : la connexion à la base de données a échoué.");
            return;
        }

        // Requête de mise à jour SQL
        String sql = "UPDATE adherant SET last_name = ?, first_name = ?, faculte = ?, niveau = ?, cin = ?, vacation = ?, phone = ? WHERE id_e = ?";
        statement = conn.prepareStatement(sql);
        
        // Affectation des paramètres
        statement.setString(1, adhe.getLast_name());
        statement.setString(2, adhe.getFirst_name());
        statement.setString(3, adhe.getFaculte());
        statement.setString(4, adhe.getNiveau());
        statement.setString(5, adhe.getCin());
        statement.setString(6, adhe.getVacation());
        statement.setString(7, adhe.getPhone());
        statement.setString(8, adhe.getId_etu());

        // Exécution de la mise à jour
        int rowsAffected = statement.executeUpdate();
        
        // Vérification du nombre de lignes mises à jour
        if (rowsAffected > 0) {
            System.out.println(rowsAffected + " ligne(s) mise(s) à jour avec succès.");
        } else {
            System.out.println("Aucune ligne mise à jour. Vérifiez si l'ID existe.");
        }
        
    } catch (SQLException e) {
        System.out.println("Erreur lors de la mise à jour de l'adhérent : " + e.getMessage());
        e.printStackTrace();
    }
}

//    public void updateAdherant(Adherent adhe){
//        ConnectToDb dbConnection = new ConnectToDb();
//        PreparedStatement statement = null;
//        
//        try(Connection conn = dbConnection.connexion("Yousenie", "lordeus", "bibliotheque_db")){
//            //Statement stat = dbConnection.requete(conn);
//            String sql = "UPDATE adherant SET last_name = ?, first_name = ?, faculte = ?, niveau = ?, cin = ?," 
//                    +" vacation =?, phone=? WHERE id_e = ?";
//            statement = conn.prepareStatement(sql);
//            
//            statement.setString(1, adhe.getLast_name());
//            statement.setString(2, adhe.getFirst_name());
//            statement.setString(3, adhe.getFaculte());
//            statement.setString(4, adhe.getNiveau());
//            statement.setString(5, adhe.getCin());
//            statement.setString(6, adhe.getVacation());
//            statement.setString(7, adhe.getPhone());
//            statement.setString(8, adhe.getId_etu());
//            
//            int rowsAffected = statement.executeUpdate();
//            System.out.println(rowsAffected + " row(s) updated successfully.");
//            conn.close();
//        }catch(Exception e){
//            System.out.println(e);
//        }
//    }

}
