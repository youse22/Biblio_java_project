
package projet2022;

public class Adherent extends Personne {

    private String faculte, vacation, niveau;
    private String id_etu;

    public Adherent(String id, String cin, String last_name, String first_name, String phone, String address, String faculte, String vacation, String niveau) {
        super(cin, last_name, first_name, phone, address);
        this.faculte = faculte;
        this.id_etu = id;
        this.vacation = vacation;
        this.niveau = niveau;
    }

    public String getVacation() {
        return vacation;
    }

    public String getNiveau() {
        return niveau;
    }

    public String getFaculte() {
        return faculte;
    }

    public void setVacation(String vacation) {
        this.vacation = vacation;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getId_etu() {
        return id_etu;
    }

    public void setFaculte(String faculte) {
        this.faculte = faculte;
    }

    public void setId_etu(String id_etu) {
        this.id_etu = id_etu;
    }
    
    // Afficher les informations sur les adhérents
    @Override
    public String toString() {
        return "ID adhérent:\t\t" + id_etu +
               "\nNom adhérent:\t\t" + last_name +
               "\nPrénom adhérent:\t" + first_name +
               "\nStatut:\t\t\t" + faculte +
               "\n______________________________";
    }

    // Implémentation des méthodes pour récupérer les informations
    public String getFirstName() {
        return first_name; // Retourne le prénom de l'adhérent
    }

    public String getLastName() {
        return last_name; // Retourne le nom de famille de l'adhérent
    }

    public String getId() {
        return id_etu; // Retourne l'ID de l'adhérent
    }
}
