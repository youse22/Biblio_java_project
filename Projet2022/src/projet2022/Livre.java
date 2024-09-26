
package projet2022;

public class Livre {
    private String isbn;
    private String titre;
    private String auteur;
    private int anneePublication; // Suppression de l'année dans le constructeur
    private boolean hidden; // Statut pour masquer le livre
    private String codeLivre;
    private String edition;
    private String statut;
    private int nbreExemp;
    private String etat;

    // Constructeur
    public Livre(String codeLivre, String auteur, String titre, String edition, String statut, String etat, int nbreExemp) {
        this.codeLivre = codeLivre;
        this.auteur = auteur;
        this.titre = titre;
        this.edition = edition;
        this.statut = statut;
        this.etat = etat;
        this.nbreExemp = nbreExemp;
        this.hidden = false; // Par défaut, le livre n'est pas masqué
    }

    public Livre(String bn, String titre, String auteur, int annee) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Getters et setters
    public String getCodeLivre() { return codeLivre; }
    public String getAuteur() { return auteur; }
    public String getTitre() { return titre; }
    public String getEdition() { return edition; }
    public String getStatut() { return statut; }
    public String getEtat() { return etat; }
    public int getNbreExemp() { return nbreExemp; }

    public void setCodeLivre(String codeLivre) { this.codeLivre = codeLivre; }
    public void setAuteur(String auteur) { this.auteur = auteur; }
    public void setTitre(String titre) { this.titre = titre; }
    public void setEdition(String edition) { this.edition = edition; }
    public void setStatut(String statut) { this.statut = statut; }
    public void setEtat(String etat) { this.etat = etat; }
    public void setNbreExemp(int nbreExemp) { this.nbreExemp = nbreExemp; }

    // Méthode toString
    @Override
    public String toString() {
        return "Code du livre: " + codeLivre +
               "\nAuteur: " + auteur +
               "\nTitre du livre: " + titre +
               "\nStatut: " + statut +
               "\nDate d'édition: " + edition +
               "\nNombre d'exemplaires: " + nbreExemp +
               "\n____________________________";
    }

    // Getters pour ISBN et année de publication
    public String getIsbn() {
        return isbn;
    }

    public int getAnneePublication() {
        return anneePublication;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public boolean isHidden() {
        return hidden;
    }

    int getAnnee() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
