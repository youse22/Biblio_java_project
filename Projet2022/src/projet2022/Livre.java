/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet2022;

/**
 * Classe représentant un livre dans la bibliothèque
 * Auteur : Marie-Vonise LORDEUS
 */
public class Livre {
    private String codeLivre; // Code unique du livre
    private String auteur; // Auteur du livre
    private String titre; // Titre du livre
    private String edition; // Édition du livre
    private String statut; // Statut du livre (disponible, emprunté, etc.)
    private String etat; // État du livre (bon, abîmé, etc.)
    private int nbreExemp; // Nombre d'exemplaires disponibles

    /**
     * Constructeur de la classe Livre
     * 
     * @param codeLivre Code unique du livre
     * @param auteur Auteur du livre
     * @param titre Titre du livre
     * @param edition Édition du livre
     * @param statut Statut du livre
     * @param etat État du livre
     * @param nbreExemp Nombre d'exemplaires disponibles
     */
    public Livre(String codeLivre, String auteur, String titre, String edition, String statut, String etat, int nbreExemp) {
        this.codeLivre = codeLivre;
        this.auteur = auteur;
        this.titre = titre;
        this.edition = edition;
        this.statut = statut;
        this.etat = etat;
        this.nbreExemp = nbreExemp;
    }

    // Getters et Setters
    public String getCodeLivre() {
        return codeLivre;
    }

    public void setCodeLivre(String codeLivre) {
        this.codeLivre = codeLivre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public int getNbreExemp() {
        return nbreExemp;
    }

    public void setNbreExemp(int nbreExemp) {
        this.nbreExemp = nbreExemp;
    }

    @Override
    public String toString() {
        return "Code du livre\t\t: " + codeLivre +
                "\nAuteur\t\t\t: " + auteur +
                "\nTitre du livre\t\t: " + titre +
                "\nStatut\t\t\t: " + statut +
                "\nÉdition\t\t\t: " + edition +
                "\nNombre d'exemplaires\t: " + nbreExemp +
                "\nÉtat\t\t\t: " + etat +
                "\n____________________________";
    }
}
