package hopital.tp;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;
import hopital.tp.Lit.Type;
import java.util.Random;
/**
 * @author alexhaile
 * @author daognimgregoire
 * @author emmanuel
 */
public class Gestionnaire {
   public ArrayList<Admission> admissions = new ArrayList<>();
   public ArrayList<Patient> patients = new ArrayList<>();
   public ArrayList<Medecin> medecins = new ArrayList<>();
   public ArrayList<Lit> lits = new ArrayList<>();
   public ArrayList<Assurance> assurances = new ArrayList<>();
   public ArrayList<Departement> departements = new ArrayList<>();
   public Medecin medecinConnecté;

    public Gestionnaire() {
    }

    public Gestionnaire(Medecin medecinConnecté) {
        this.medecinConnecté = medecinConnecté;
    }
    
    public void créationLit(){
        Departement departement1 = new Departement(1,"Urgences");
        Departement departement2 = new Departement(2,"Cardiologie");
        Departement departement3 = new Departement(3,"Neurologie");
        Departement departement4 = new Departement(4,"Oncologie");
        Departement departement5 = new Departement(5,"Orthopédie");
        Departement departement6 = new Departement(6,"Pédiatrie");
        Departement departement7 = new Departement(7,"Gynécologie et obstétrique");
        Departement departement8 = new Departement(8,"Radiologie");
        Departement departement9 = new Departement(9,"Psychiatrie");
        Departement departement10 = new Departement(10,"Chirurgie");
        Departement departement11 = new Departement(11,"Dermatologie");
        departements.add(departement1);
        departements.add(departement2);
        departements.add(departement3);
        departements.add(departement4);
        departements.add(departement5);
        departements.add(departement6);
        departements.add(departement7);
        departements.add(departement8);
        departements.add(departement9);
        departements.add(departement10);
        departements.add(departement11);
    for (int i = 0; i <= 150; i++) {
        Random random = new Random();
        boolean isOccupe = random.nextBoolean();
        Type istype = Type.values()[random.nextInt(Type.values().length)];
        Departement isdepartement = departements.get(random.nextInt(departements.size()));
        Lit lit = new Lit(String.valueOf(i), isOccupe, istype, isdepartement);
        lits.add(lit);  
    } 
}
public void créationMedecin(){
    Medecin medecin1 = new Medecin("1", "medecin1", "crosemont", "DAO", "Gnim", "123 rue de la rue", "Montreal", "Quebec", "H1H 1H1", "514-123-4567");
    Medecin medecin2 = new Medecin("2", "medecin2", "crosemont", "Haile", "Alex", "123 rue de la rue", "Montreal", "Quebec", "H1H 1H1", "514-123-4567");
    Medecin medecin3 = new Medecin("3", "medecin3", "crosemont", "Backiny", "Emmanuel", "123 rue de la rue", "Montreal", "Quebec", "H1H 1H1", "514-123-4567");
    medecins.add(medecin1);
    medecins.add(medecin2);
    medecins.add(medecin3);
}
public void creationAssurance(){
    Assurance assurance1 = new Assurance(1, "SunLife");
    Assurance assurance2 = new Assurance(2, "ManuLife");
    Assurance assurance3 = new Assurance(3, "Desjardins");
    assurances.add(assurance1);
    assurances.add(assurance2);
    assurances.add(assurance3);
}
  private Scanner scanner = new Scanner(System.in);

  public Patient creerPatient(){
    Patient malade = new Patient();

    System.out.println("Veuillez entrez le numero RAMQ de votre nouveau patient");
    String num = scanner.nextLine();
    if (VerificationPatient(num) == true) {
        System.out.println("Le patient dont vous avez entré le numéro RAMQ existe déjà");
        System.out.println("Validez l'usage des information de ce patient existant (oui/non)");
        String choix = scanner.nextLine();
        if (choix.equalsIgnoreCase("oui")) {//Améliorer plutard pour ajouter l'option du else
            return rechercherPatient(num);
        }
    } else {
        malade.setNumeroRAMQ(num);
        
        System.out.println("Veuillez entrez le nom de votre nouveau patient");
        String name = scanner.nextLine();
        malade.nom = name;
        
        System.out.println("Veuillez entrez le prénom de votre nouveau patient");
        String Firstname = scanner.nextLine();
        malade.prenom = Firstname;
        
        System.out.println("Veuillez entrez le numéro de téléphone de votre nouveau patient");
        String number = scanner.nextLine();
        malade.telephone = number;
        
        System.out.println("Veuillez entrez la ville de votre nouveau patient");
        String city = scanner.nextLine();
        malade.ville = city;
        
        System.out.println("Veuillez entrez la province de votre nouveau patient");
        String region = scanner.nextLine();
        malade.province = region;
        
        System.out.println("Veuillez entrez l'adresse de votre nouveau patient");
        String adress = scanner.nextLine();
        malade.addresse = adress;
        
        System.out.println("Veuillez entrez le code postal de votre nouveau patient");
        String mailbox = scanner.nextLine();
        malade.codePostal = mailbox;
        
        System.out.println("Votre patient a-t-il une assurance (oui/non)");
        String assurance = scanner.nextLine();
        if (assurance.equalsIgnoreCase("oui")) {
            System.out.println("Veillez entrez l'id de l'assurance de votre nouveau patient");
            int id_malade = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Veillez entrez le nom de la compagnie de l'assurance de votre nouveau patient");
            String name_compagnie = scanner.nextLine();
            Assurance assur = new Assurance(id_malade, name_compagnie);
        malade.setAssurance(assur);
        } else {
            malade.setAssurance(null);
        }

        System.out.println("Veillez entrez la date de naissance de votre nouveau patient");
        String date_naissance = scanner.nextLine();
        malade.setDateNaissance(date_naissance);

        System.out.println("Veuillez entrez l'age de votre patient");
        int age = scanner.nextInt();
        malade.setAge(age);
    }
    return malade;
  }
  public void ajouterPatient(){
      patients.add(creerPatient());
  } 
 
  public Admission creerAdmission(){
    créationMedecin();
    créationLit();
    // Verification de la disponibilité des lit:
    int nombreLitDispo=0;
    for (int i = 0; i < lits.size(); i++) {
        while(lits.get(i).isOccupe() == false) {
            nombreLitDispo = nombreLitDispo + 1;
        }
    }
    if (nombreLitDispo == 0) {
        System.out.println("Il n'y a pas de lit disponible pour le moment");
        return null;
    } else {
        Scanner scanner = new Scanner(System.in);
        Admission formulaire = new Admission();
        System.out.println("Veillez entrez l'id de votre nouvelle admission");
        int id = scanner.nextInt();
        formulaire.setIDAdmission(id);
         
        boolean ch_p = false;
        while (true) {
            System.out.println("Veillez définir s'il y a une chirurgie programmée dans votre nouvelle admission (oui/non)");
            String input = scanner.next();
            if (input.equalsIgnoreCase("oui") || input.equalsIgnoreCase("non")) {
               ch_p = input.equalsIgnoreCase("oui");
               break;
            } else {
               System.out.println("Entrée invalide. Veuillez entrer 'oui' ou 'non'.");
            }
        }
        formulaire.setChirurgieProgrammée(ch_p);
    
        System.out.println("Veuillez définir la date d'admission de votre nouvelle admission");
        String date_a = scanner.next();
        // Définir le format de la date
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // Convertir la chaîne de caractères en LocalDate
        LocalDate dateAdmission = LocalDate.parse(date_a, formatter1);
        formulaire.setDateAdmission(dateAdmission);
         
        if (ch_p == true) {
            System.out.println("Veillez définir la date de la chirurgie s'il yen a de votre nouvelle admission");
            String date_c = scanner.next();
            // Définir le format de la date
            DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
            // Convertir la chaîne de caractères en LocalDate
            LocalDate dateChirurgie = LocalDate.parse(date_c, formatter2);
            formulaire.setDateChirurgie(dateChirurgie);
        } else {
            formulaire.setDateChirurgie(null);
        }
    
        System.out.println("Veillez indiqué si l'option téléviseur loué a été choisi pour votre nouvelle admission (true/false)");//Améliorer pour rendre plus compréhensible les choix pour les utilisateurs
        boolean télév = scanner.nextBoolean();
        
        formulaire.setTeleviseurLoué(télév);
         
        System.out.println("Veillez indiqué si l'option téléphone loué a été choisi pour votre nouvelle admission (true/false)");
        boolean télép = scanner.nextBoolean();
        formulaire.setTelephoneLoué(télép);

        formulaire.setPatient(creerPatient());
         
        if (creerPatient().getAssurance() == null) {
            boolean tousEgaux = true;
            for (int i = 0; i < lits.size(); i++) {
                if ((lits.get(i).isOccupe() == true) && (lits.get(i).getType().equals(Type.Standart))) {//
                    tousEgaux = false;
                }            
    }
                if (tousEgaux == false) {
                System.out.println("Le patient ne dispose pas d'assurance privée et il n'y a pas de chambre standart disponible ");
                
                String id_lit = scanner.next();
                
                    if (ch_p == true){
                        for(int i = 0; i < lits.size(); i++) {
                        System.out.println("Veuillez entrez le numero de lit d'une chambre semi privée de votre choix disponible étant dans le departement de chirurgie ");
                        if(lits.get(i).getNumeroLit().equals(id_lit) && lits.get(i).getDepartement().getNomDepartement().equals("Chirurgie")){
                            lits.get(i).setPrix(Lit.val);
                        formulaire.setLit(lits.get(i));
                        }
                        if (formulaire.getPatient().getAge() <= 16) {
                            formulaire.setDepartement((departements.get(5)));
                        }else{
                            formulaire.setDepartement(lits.get(i).getDepartement());
                        }
                    }
                    } else {
                        for(int i = 0; i < lits.size(); i++) {
                        System.out.println("Veuillez entrez le numero de lit d'une chambre semi privée de votre choix disponible ");
                        if(lits.get(i).getNumeroLit().equals(id_lit)){
                            lits.get(i).setPrix(Lit.val);
                        formulaire.setLit(lits.get(i));
                        if (formulaire.getPatient().getAge() <= 16) {
                            formulaire.setDepartement((departements.get(5)));
                        }else{
                            formulaire.setDepartement(lits.get(i).getDepartement());
                        }
                    }
                   
            }
}
        }
            boolean tousEgaux2 = true;
            for (int i = 0; i < lits.size(); i++) {
            if ((lits.get(i).isOccupe() == true) && (lits.get(i).getType().equals(Type.Standart)) && (lits.get(i).getType().equals(Type.SemiPrivé))) {//
                tousEgaux2 = false;
            }            
}           String id_lit = scanner.next();
            if (tousEgaux2 == false) {
                
                System.out.println("Le patient ne dispose pas d'assurance privée et il n'y a pas de chambre standart disponible ni de chambre semi privée ");
                if (ch_p == true) {
                    for(int i = 0; i < lits.size(); i++) {
                        System.out.println("Veuillez entrez le numero de lit d'une chambre privée de votre choix disponible étant dans le departement de chirurgie ");
                        if(lits.get(i).getNumeroLit().equals(id_lit) && lits.get(i).getDepartement().getNomDepartement().equals("Chirurgie")){
                            lits.get(i).setPrix(Lit.val);
                            formulaire.setLit(lits.get(i));
                        }
                        if (formulaire.getPatient().getAge() <= 16) {
                            formulaire.setDepartement((departements.get(5)));
                        }else{
                            formulaire.setDepartement(lits.get(i).getDepartement());
                        }
                    }
                } else {
                    System.out.println("Veuillez entrez le numero de lit d'une chambre privée de votre choix disponible ");
                for(int i = 0; i < lits.size(); i++) {
                    if(lits.get(i).getNumeroLit().equals(id_lit)){
                    lits.get(i).setPrix(Lit.val);
                        formulaire.setLit(lits.get(i));
                        if (formulaire.getPatient().getAge() <= 16) {
                            formulaire.setDepartement((departements.get(5)));
                        }else{
                            formulaire.setDepartement(lits.get(i).getDepartement());
                        }
        }
                }
            }
        } else {
            if (ch_p == true) {
                formulaire.setPatient(creerPatient());
                System.out.println("Veuillez entrez le numero du lit de votre nouvelle admission dans le département de chirurgie");
                String id_lit2 = scanner.next();
                for (int i = 0; i < lits.size(); i++) {
                    if(lits.get(i).getNumeroLit().equals(id_lit2) && lits.get(i).getDepartement().getNomDepartement().equals("Chirurgie")){
                        formulaire.setLit(lits.get(i));
                        if (formulaire.getPatient().getAge() <= 16) {
                            formulaire.setDepartement((departements.get(5)));
                        }else{
                            formulaire.setDepartement(lits.get(i).getDepartement());
                        }
                        
                }
                }
            }
             else {
                formulaire.setPatient(creerPatient());
    
                System.out.println("Veuillez entrez le numero du lit de votre nouvelle admission ");
                String id_lit2 = scanner.next();
                for (int i = 0; i < lits.size(); i++) {
                    if(lits.get(i).getNumeroLit().equals(id_lit2)){
                        formulaire.setLit(lits.get(i));
                        if (formulaire.getPatient().getAge() <= 16) {
                            formulaire.setDepartement((departements.get(5)));
                        }else{
                            formulaire.setDepartement(lits.get(i).getDepartement());
                        }
                        
                }
            }
            }
        while (true) {
            System.out.println("Voulez vous ajouter un nouveau medecin à cette admission (oui/non)");
            String input = scanner.next();
            if (input.equalsIgnoreCase("oui")) {
                  formulaire.setMedecin(creerMedecin());
               break;
                } else if(input.equalsIgnoreCase("non")){
                    Scanner scanner2 = new Scanner(System.in);
                    System.out.println("Veuillez entrez le numero du permis du medecin voulu");
                    String num_permis = scanner2.nextLine();
                    for (int i = 0; i < medecins.size(); i++) {
                        if(medecins.get(i).getNumeroPermis().equals(num_permis)){
                            formulaire.setMedecin(medecins.get(i));
                        }
                    }
                    scanner2.close();
                break;  
            }
        }
    
        scanner.close();
        
        }
        
        }
        return formulaire;
    }
   
       
  }
  public Medecin creerMedecin(){
    Scanner scanner = new Scanner(System.in);
    Medecin infirmier = new Medecin();
    
    System.out.println("Veillez entrez le nom de votre nouveau patient");
    String Lastname = scanner.nextLine();
    infirmier.nom = Lastname;
    
    System.out.println("Veillez entrez le prénom de votre nouveau patient");
    String Firstname = scanner.nextLine();
    infirmier.prenom = Firstname;
    
    System.out.println("Veillez entrez le numéro de téléphone de votre nouveau patient");
    String number = scanner.nextLine();
    infirmier.telephone = number;
    
    System.out.println("Veillez entrez la ville de votre nouveau patient");
    String city = scanner.nextLine();
    infirmier.ville = city;
    
    System.out.println("Veillez entrez la province de votre nouveau patient");
    String region = scanner.nextLine();
    infirmier.province = region;
     
    System.out.println("Veillez entrez l'adresse de votre nouveau patient");
    String adress = scanner.nextLine();
    infirmier.addresse = adress;
    
    System.out.println("Veillez entrez le code postal de votre nouveau patient");
    String mailbox = scanner.nextLine();
    infirmier.codePostal = mailbox;
    
    System.out.println("Veillez entrez le numero de permis du nouveau medecin");
    String numero_permis = scanner.nextLine();
    infirmier.setNumeroPermis(numero_permis);
     
    System.out.println("Veillez entrez le nom du nouveau medecin");
    String nom_med = scanner.nextLine();
    infirmier.setNomUtilisateur(nom_med);
     
    System.out.println("Veillez entrez le mot de passe du nouveau medecin");
    String mdp = scanner.nextLine();
    infirmier.setMotDePasse(mdp);
    scanner.close();
    admissions.add(creerAdmission());
    return infirmier;
      
  } 
  public Patient rechercherPatient(){//Améliorer les codes de recherches en ajoutant d'autres types de recherches
      Patient resultat = new Patient();
      System.out.println("Veuillez indiquer le numéro RAMQ du patient recherché");
      Scanner scanner = new Scanner(System.in);
      String scn_p = scanner.nextLine();
      for(int i=0; i<patients.size();i++){
            if(patients.get(i).getNumeroRAMQ().equals(scn_p)){
                resultat = patients.get(i);
            }
            scanner.close();
      }
      return resultat;
  } 
    public Patient rechercherPatient(String ramq){
        int tampon = 0;
        if (VerificationPatient(ramq)==true) {
            for(int i=0; i<patients.size();i++){
                if(patients.get(i).getNumeroRAMQ().equals(ramq)){
                  tampon = i;                 
            }         
        }
    }    
    return patients.get(tampon); 
    }

  public boolean VerificationPatient(String ramq){//Améliorer les codes de recherches en ajoutant d'autres types de recherches
      
  boolean resultat = true;
      for(int i=0; i<patients.size();i++){
            if (patients.get(i).getNumeroRAMQ().equals(ramq)) {
                resultat = true;
            } else {
                resultat = false;
            }
            
      }
          return resultat;
      
  } 

  private void donnerConge(){//Cette méthode ne fonctionne que si on considère que le patient a une seul admission qui lui est propre: L'améliorer
     Scanner scanner = new Scanner(System.in);  
    System.out.println("Veuillez indiquer le numéro RAMQ du patient recherché");
      String scn_p = scanner.nextLine();
      System.out.println("Veuillez entrez la nouvelle date sous le format YYYY-MM-DD du patient recherché");
      String date;
      date = scanner.nextLine();
      // Définir le format de la date
      DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
      // Convertir la chaîne de caractères en LocalDate
      LocalDate dateConge = LocalDate.parse(date, formatter3);
      ArrayList<Admission> tableau_patient = new ArrayList<>();
      for(int i=0; i<admissions.size();i++){
            if(admissions.get(i).getPatient().getNumeroRAMQ().equals(scn_p)){
                tableau_patient.add(admissions.get(i));
}
      if(tableau_patient.size() == 1){
        admissions.get(0).setDateConge(dateConge);
        admissions.get(0).lit.setOccupe(false);
        } else {
            System.out.println("Le patient choisi possède plusieurs admissions dans cet hopital. Veuillez choisir le bon");
            for (int j = 0; j < tableau_patient.size(); j++) {
                System.out.println("choix {j}: "+tableau_patient.get(j).toString());
}
            System.out.println("Quelle est votre choix d'admissions ?");
            int scn_tampon = scanner.nextInt();                            
            tableau_patient.get(scn_tampon).setDateConge(dateConge);
            for(int x=0; x < admissions.size(); x++){
                if(tableau_patient.get(scn_tampon).equals(admissions.get(x))){
                    admissions.set(x, tableau_patient.get(scn_tampon));//Utilise admissions.set(x, tableau_patient.get(j)) pour remplacer l'élément à l'index x par celui de tableau_patient
                    admissions.get(x).lit.setOccupe(false);             }
                            } 
            scanner.close();    
                        }
                    }  
                }
 
  protected void donnerConge_medecin(Medecin b){
      b.utiliser_donner_conger(this);
  }
  
  protected void utiliser_donner_conger(Gestionnaire a){
      a.donnerConge();
  }
  public void ajouterMedecin(){
       medecins.add(creerMedecin());
  }
  public void supprimerMedecin(){//Améliorer les recherches
      System.out.println("Veuillez indiquer le numéro de permis du medecin à supprimer");
      Scanner scanner = new Scanner(System.in);
      String scn_m = scanner.nextLine();
      for(int i=0; i<medecins.size();i++){
            if(medecins.get(i).getNumeroPermis().equals(scn_m)){
                medecins.remove(medecins.get(i));
              scanner.close();  
            }
  } 
}

public void afficherFacturePatient(){
    for (int i = 0; i < admissions.size(); i++) {
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        scanner.close();
        double facture = 0;
        if (admissions.get(i).getIDAdmission() == id) {

           long daysBetween = ChronoUnit.DAYS.between(admissions.get(i).getDateAdmission(), admissions.get(i).getDateConge());
           facture = (admissions.get(i).getLit().getPrix() * daysBetween);
              if (admissions.get(i).isTeleviseurLoué()) {
                  facture += 42.50 * daysBetween;
              }
                if (admissions.get(i).isTelephoneLoué()) {
                    facture += 7.50 * daysBetween;
                }
        }
        System.out.println("La facture totale du patient est de: " + facture);
        
    }

}
public void sauvegarderAdmissions(String filePath) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
        for (Admission admission : admissions) {
            writer.write(admission.toString());
            writer.newLine();
        }
        System.out.println("Les admissions ont été sauvegardées avec succès.");
    } catch (IOException e) {
        System.err.println("Erreur lors de la sauvegarde des admissions: " + e.getMessage());
    }
}
}