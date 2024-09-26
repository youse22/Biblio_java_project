package projet2022;

import java.util.Date;
import java.util.Calendar;

/**
 *
 * @author Marie-Vonise LORDEUS
 */
public class Pret {
    private String id;
    private String codeLivre;
    private String codeEtu;
    private String datePret;
    private String dateRemise;
    private String description;

    // Constructeur avec un paramètre par défaut pour la durée
    public Pret(String id, String codeLivre, String codeEtu, String description) {
        this(id, codeLivre, codeEtu, 1, description); // 1 jour par défaut
    }

    // Constructeur principal
    public Pret(String id, String codeLivre, String codeEtu, int day, String description) {
        this.id = id;
        this.codeLivre = codeLivre;
        this.codeEtu = codeEtu;
        this.datePret = dateNow();
        this.dateRemise = RemiseDate(day);
        this.description = description;
    }

    // Constructeur par défaut
    public Pret() {
        // Initialisation par défaut sans lancer d'exception
        this.id = "";
        this.codeLivre = "";
        this.codeEtu = "";
        this.datePret = dateNow();
        this.dateRemise = RemiseDate(1); // Valeur par défaut
        this.description = "";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodeLivre() {
        return codeLivre;
    }

    public void setCodeLivre(String codeLivre) {
        this.codeLivre = codeLivre;
    }

    public String getCodeEtu() {
        return codeEtu;
    }

    public void setCodeEtu(String codeEtu) {
        this.codeEtu = codeEtu;
    }

    public String getDatePret() {
        return datePret;
    }

    public void setDatePret(String datePret) {
        this.datePret = datePret;
    }

    public String getDateRemise() {
        return dateRemise;
    }

    public void setDateRemise(String dateRemise) {
        this.dateRemise = dateRemise;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Id\t\t\t: " + id +
               "\nCode livre\t\t: " + codeLivre +
               "\nCode Etudiant\t\t: " + codeEtu +
               "\nDate du prêt\t\t: " + datePret +
               "\nDate de remise\t\t: " + dateRemise +
               "\nDescription\t\t: " + description +
               "\n____________________________";
    }

    private String dateNow() {
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);

        int month = calendar.get(Calendar.MONTH) + 1; // Ajouter 1 pour le mois
        int year = calendar.get(Calendar.YEAR);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        return String.format("%02d/%02d/%d", day, month, year); // Format avec deux chiffres pour le jour et le mois
    }

    private String RemiseDate(int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, day);

        int month = calendar.get(Calendar.MONTH) + 1; // Ajouter 1 pour le mois
        int year = calendar.get(Calendar.YEAR);
        int dayOf = calendar.get(Calendar.DAY_OF_MONTH);

        return String.format("%02d/%02d/%d", dayOf, month, year); // Format avec deux chiffres pour le jour et le mois
    }
}
