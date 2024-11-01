package hopital.tp;
/**
 * @author alexhaile
 */

public class Tp2Hopital {

  
    public static void main(String[] args) {
        
        Medecin medecin = new Medecin("3", "medecin3", "crosemont", "Backiny", "Emmanuel", "123 rue de la rue", "Montreal", "Quebec", "H1H 1H1", "514-123-4567");
        medecin.toString();
        Gestionnaire gestionnaire = new Gestionnaire(medecin);
        gestionnaire.créationLit();
        gestionnaire.créationMedecin();
        gestionnaire.ajouterPatient();
        gestionnaire.creerAdmission();
        gestionnaire.rechercherPatient();
        medecin.utiliser_donner_conger(gestionnaire);
        gestionnaire.afficherFacturePatient();
        
    }
    
}