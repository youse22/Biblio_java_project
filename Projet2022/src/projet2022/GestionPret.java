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

/**
 *
 * @author Marie-Vonise LORDEUS
 */
public class GestionPret {
    public void newPret(Pret pret){
        ConnectToDb dbConection = new ConnectToDb();
       
        String req3 ="INSERT INTO `prets` (`id`, `id_etu`,`id_liv`,`datePret`,`dateRemise`,`description`"
                + ")VALUES ('"+pret.getId()+"', '"+pret.getCodeEtu()+"', '"+pret.getCodeLivre()+"', '"+pret.getDatePret()+"',"
                + "'"+pret.getDateRemise()+"','"+pret.getDescription()+"')";
        
        try{
            dbConection.chargerDriver();     
            try (Connection conn = dbConection.connexion("Yousenie", "lordeus", "bibliotheque_db")) {

                Statement stat = dbConection.requete(conn);
                
                int rowsUpdated = stat.executeUpdate(req3);
                System.out.println(rowsUpdated);
                
                conn.close();  
            }
        }catch(Exception e){
            System.out.println("error"+ e);
        }
    }
    
    
    //get all the students
    public ArrayList<Pret> getAllPret() {
    // Connect to the database
    ConnectToDb dbConection = new ConnectToDb();
    
    // Declare a list to add all the prets
    ArrayList<Pret> myList = new ArrayList<>();
    Pret livrePret;

    try {
        dbConection.chargerDriver();     
        try (Connection conn = dbConection.connexion("Yousenie", "lordeus", "bibliotheque_db")) {

            Statement stat = dbConection.requete(conn);
            // Requête modifiée pour ne sélectionner que les prêts avec un statut visible
            String req1 = "SELECT * FROM prets WHERE statut = 'visible'"; 
            ResultSet res = stat.executeQuery(req1);
            
            while (res.next()) {
                String id = res.getString("id");
                String id_etu = res.getString("id_etu");
                String id_liv = res.getString("id_liv");
                String datePret = res.getString("datePret");
                String dateRemise = res.getString("dateRemise");
                String description = res.getString("description");
                
                livrePret = new Pret(id, id_liv, id_etu, description);
                
                // Ajouter les dates dans l'objet prêt
                livrePret.setDatePret(datePret);
                livrePret.setDateRemise(dateRemise);
                
                // Ajouter le prêt à la liste qui contient tous les prêts
                myList.add(livrePret);
            }
            conn.close();
        }
        return myList;
    } catch (Exception e) {
        System.out.println("error: " + e);
    }
    return myList;
}

//    public ArrayList<Pret> getAllPret(){
//        //connect to the databse
//        ConnectToDb dbConection = new ConnectToDb();
//        
//        //declare a list to add all the prets
//        ArrayList<Pret> myList = new ArrayList<>();
//        Pret livrePret;
//        
//        try{
//            dbConection.chargerDriver();     
//            try (Connection conn = dbConection.connexion("Yousenie", "lordeus", "bibliotheque_db")) {
//
//                Statement stat = dbConection.requete(conn);
//                String req1 ="select * from prets";
//                ResultSet res = stat.executeQuery(req1);
//                
//                while(res.next()){
//                    String id = res.getString("id");
//                    String id_etu = res.getString("id_etu");
//                    String id_liv = res.getString("id_liv");
//                    String datePret = res.getString("datePret");
//                    String dateRemise = res.getString("dateRemise");
//                    String description = res.getString("description");
//                 
//                    livrePret = new Pret(id, id_liv, id_etu, description);
//                    
//                    //ajouter vre date liv lan t prete a ak dat lap remet lan
//                    livrePret.setDatePret(datePret);
//                    livrePret.setDateRemise(dateRemise);
//                    
//                    //ajoute pre a nan list kap gn tout pre yo
//                    myList.add(livrePret);
//                }
//                conn.close();
//            }
//            return myList;
//        }catch(Exception e){
//            System.out.println("error"+ e);
//        }
//        return myList;
//    }
//    
    //get a Pret by his id
    public Pret getPretById(String id){
        //connect to the databse
        ConnectToDb dbConection = new ConnectToDb();
        Pret pret;
       
        try(Connection conn = dbConection.connexion("Yousenie", "lordeus", "bibliotheque_db")){
            Statement stat = dbConection.requete(conn);
            
            String req1 =String.format("select * from prets where id=\"%s\"", id);
            ResultSet res = stat.executeQuery(req1);
            
            while(res.next()){
                String idP = res.getString("id");
                String id_etu = res.getString("id_etu");
                String id_liv = res.getString("id_liv");
                String datePret = res.getString("datePret");
                String dateRemise = res.getString("dateRemise");
                String description = res.getString("description");

                pret = new Pret(idP, id_liv, id_etu, description);

                //ajouter vre date liv lan t prete a ak dat lap remet lan
                pret.setDatePret(datePret);
                pret.setDateRemise(dateRemise);
                return pret;
            }
            conn.close(); 
        }catch(Exception e){
            System.out.println("error"+ e);
        }
        pret= new Pret("", "", "", "");
        return pret;
    }
    
//    //Delete Pret
    // Modifier le statut d'un prêt
public boolean deleteBook(String id) {
    // Connexion à la base de données
    ConnectToDb dbConnection = new ConnectToDb();

    // Requête pour mettre à jour le statut du prêt
    String req1 = String.format("UPDATE prets SET statut = 'hidden' WHERE id = '%s'", id);

    try (Connection conn = dbConnection.connexion("Yousenie", "lordeus", "bibliotheque_db")) {
        Statement stat = dbConnection.requete(conn);

        // Exécuter la mise à jour
        int rowsAffected = stat.executeUpdate(req1);
        conn.close();

        if (rowsAffected > 0) {
            System.out.println("Statut mis à jour avec succès.");
            return true;
        } else {
            System.out.println("Échec de la mise à jour du statut.");
            return false;
        }

    } catch (Exception e) {
        System.out.println(e);
        return false;
    }
}

//    public boolean deleteBook(String id){
//        //connect to the database
//        ConnectToDb dbConection = new ConnectToDb();
//        
//        String req1 = String.format("delete from prets where id=\"%s\"", id);
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
    public void updateBook(Pret pret){
        ConnectToDb dbConnection = new ConnectToDb();
        PreparedStatement statement = null;
        
        try(Connection conn = dbConnection.connexion("Yousenie", "lordeus", "bibliotheque_db")){
            //Statement stat = dbConnection.requete(conn);
            String sql = "UPDATE prets SET id_liv = ?, id_etu = ?, dateRemise = ?, datePret = ?, description = ?" 
                    +" WHERE id = ?";
            statement = conn.prepareStatement(sql);
            
            statement.setString(1, pret.getCodeLivre());
            statement.setString(2, pret.getCodeEtu());
            statement.setString(3, pret.getDateRemise());
            statement.setString(4, pret.getDatePret());
            statement.setString(5, pret.getDescription());
            statement.setString(6, pret.getId());
            
            
            int rowsAffected = statement.executeUpdate();
            System.out.println(rowsAffected + " row(s) updated successfully.");
            conn.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }

public boolean addPret(Pret newPret) {
        ConnectToDb dbConnection = new ConnectToDb();
        String req = "INSERT INTO `prets` (`id`, `id_etu`, `id_liv`, `datePret`, `dateRemise`, `description`) " +
                     "VALUES ('" + newPret.getId() + "', '" + newPret.getCodeEtu() + "', '" + newPret.getCodeLivre() + "', '" +
                     newPret.getDatePret() + "', '" + newPret.getDateRemise() + "', '" + newPret.getDescription() + "')";

        try {
            dbConnection.chargerDriver();
            try (Connection conn = dbConnection.connexion("Yousenie", "lordeus", "bibliotheque_db")) {
                Statement stat = conn.createStatement();
                
                int rowsUpdated = stat.executeUpdate(req);
                
                // Vérifiez si l'insertion a réussi
                return rowsUpdated > 0; // Si des lignes ont été insérées, renvoie true
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de l'ajout du prêt : " + e.getMessage());
            return false; // En cas d'erreur, renvoie false
        }
   }
}


