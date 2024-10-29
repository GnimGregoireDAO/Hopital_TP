package hopital.tp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import hopital.tp.Lit.Type;
import static hopital.tp.Lit.Type.Standart;
/**
 * @author alexhaile
 * @author daognimgregoire
 * @author emmanuel
 */
public class Gestionnaire {
   private ArrayList<Admission> admissions = new ArrayList<>();
   private ArrayList<Patient> patients = new ArrayList<>();
   private ArrayList<Medecin> medecins = new ArrayList<>();
   private ArrayList<Lit> lits = new ArrayList<>();
   private ArrayList<Assurance> assurances = new ArrayList<>();
   private ArrayList<Departement> departements = new ArrayList<>();
   private Medecin medecinConnecté;

    public Gestionnaire() {
    }

    public Gestionnaire(Medecin medecinConnecté) {
        this.medecinConnecté = medecinConnecté;
    }
    
  public Patient creerPatient(){
     Patient malade = new Patient();
     System.out.println("Veillez entrez le nom de votre nouveau patient");
     String name = new Scanner(System.in).nextLine();
      malade.nom = name;
      
     System.out.println("Veillez entrez le prénom de votre nouveau patient");
     String Firstname = new Scanner(System.in).nextLine();
      malade.prenom = Firstname;
      
     System.out.println("Veillez entrez le numéro de téléphone de votre nouveau patient");
     String number = new Scanner(System.in).nextLine();
      malade.telephone = number;
      
     System.out.println("Veillez entrez la ville de votre nouveau patient");
     String city = new Scanner(System.in).nextLine();
      malade.ville = city;
      
     System.out.println("Veillez entrez la province de votre nouveau patient");
     String region = new Scanner(System.in).nextLine();
      malade.province = region;
     
     System.out.println("Veillez entrez l'adresse de votre nouveau patient");
     String adress = new Scanner(System.in).nextLine();
      malade.addresse = adress;
      
     System.out.println("Veillez entrez le code postal de votre nouveau patient");
     String mailbox = new Scanner(System.in).nextLine();
      malade.codePostal = mailbox;
      
     System.out.println("Veillez entrez l'id de l'assurance de votre nouveau patient");
     Scanner scn = new Scanner(System.in);
     int id_malade = scn.nextInt();
     System.out.println("Veillez entrez le nom de la compagnie de l'assurance de votre nouveau patient");
     String name_compagnie = new Scanner(System.in).nextLine();
     Assurance assur = new Assurance(id_malade, name_compagnie);
     malade.setAssurance(assur);
     
     System.out.println("Veillez entrez la date de naissance de votre nouveau patient");
     String date_naissance = new Scanner(System.in).nextLine();
     malade.setDateNaissance(date_naissance);
     
     System.out.println("Veillez entrez le numero RAMQ de votre nouveau patient");
     String num = new Scanner(System.in).nextLine();
     malade.setDateNaissance(num);
     
     return malade;      
  }
  public Lit creerLit(){
     Lit lit = new Lit();
      
     System.out.println("Veillez entrez le numéro de lit de votre nouvelle admission");
     String num_lit = new Scanner(System.in).nextLine();
     lit.setNumeroLit(num_lit);
     
     System.out.println("Veillez indiquer si ce lit est occupé");//Si oui j'imagine que l'admission devra en trouvé un autre?
     boolean occ = new Scanner(System.in).nextBoolean();
     lit.setOccupe(occ);
     
     System.out.println("Veillez indiquer le type de ce lit");//Si oui j'imagine que l'admission devra en trouvé un autre?
     String scn = new Scanner(System.in).nextLine();
     Type type_lit= Standart; //Juste pour ne pas avoir d'erreur d'initialisation dans la suite du code
     
     try {
            type_lit = Type.valueOf(scn);
            System.out.println("Type de lit sélectionné : " + type_lit);
        } catch (IllegalArgumentException e) {
            System.out.println("Type de lit invalide. Veuillez entrer Standart, Privé, Public");
        }
     lit.setType(type_lit);
     
     //Définition des différents département existants (Source: https://www.wikiwand.com/fr/articles/H%C3%B4pital)
     //On a considérer que les départements reste relativement inchangés et l'ajout ou la supression se fera à l'aide d'un professionnel
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
     System.out.println("Veillez indiquer dans quel département se trouve ce lit"); // On suppose que les gestionnaires ont connaissance des nombres attribués aux différents départements
     int no_depa = new Scanner(System.in).nextInt();
     Departement departement_rech = new Departement();
     for(int i=0; i<departements.size();i++){
         if(departements.get(i).getIdDepartement()== no_depa){
                departement_rech = departements.get(i);
            }
     }
     lit.setDepartement(departement_rech);
     
       return lit;
  }
  public void ajouterPatient(){
      patients.add(creerPatient());
  } 
 
  public Admission creerAdmission(){
      Admission formulaire = new Admission();
      
     System.out.println("Veillez entrez l'id de votre nouvelle admission");
     int id = new Scanner(System.in).nextInt();
     formulaire.setIDAdmission(id);
     
     System.out.println("Veillez définir s'il y a une chirurgie programmée dans votre nouvelle admission");
     boolean ch_p = new Scanner(System.in).nextBoolean(); ///Rendre simple l'usage du boolean
     formulaire.setChirurgieProgrammée(ch_p);
     
     System.out.println("Veillez définir la date d'admission de votre nouvelle admission");
     String date_a = new Scanner(System.in).nextLine();
     // Définir le format de la date
     DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
     // Convertir la chaîne de caractères en LocalDate
     LocalDate dateAdmission = LocalDate.parse(date_a, formatter1);
     formulaire.setDateAdmission(dateAdmission);
     
     System.out.println("Veillez définir la date de la chirurgie s'il yen a de votre nouvelle admission");//S'il ya une chirurgie?
     String date_c = new Scanner(System.in).nextLine();
      // Définir le format de la date
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        // Convertir la chaîne de caractères en LocalDate
        LocalDate dateChirurgie = LocalDate.parse(date_c, formatter2);
     formulaire.setDateChirurgie(dateChirurgie);
     
     System.out.println("Veillez indiqué si l'option téléviseur loué a été choisi pour votre nouvelle admission");
     boolean télév = new Scanner(System.in).nextBoolean(); ///Rendre simple l'usage du boolean
     formulaire.setTeleviseurLoué(télév);
     
     System.out.println("Veillez indiqué si l'option téléphone loué a été choisi pour votre nouvelle admission");
     boolean télép = new Scanner(System.in).nextBoolean(); ///Rendre simple l'usage du boolean
     formulaire.setTelephoneLoué(télép);
     
     formulaire.setPatient(creerPatient());
     
     formulaire.setLit(creerLit()); //L'attribut département est déja contenu dans l'attribut lit creer récemment
     
     
       return formulaire;
  }
  private Medecin creerMedecin(){//Ameliorer le code en utilisant plutard une méthode creer personne car les memes caractéristiques reviennent
      Medecin infirmier = new Medecin();
     System.out.println("Veillez entrez le nom de votre nouveau patient");
     String name = new Scanner(System.in).nextLine();
      infirmier.nom = name;
      
     System.out.println("Veillez entrez le prénom de votre nouveau patient");
     String Firstname = new Scanner(System.in).nextLine();
      infirmier.prenom = Firstname;
      
     System.out.println("Veillez entrez le numéro de téléphone de votre nouveau patient");
     String number = new Scanner(System.in).nextLine();
      infirmier.telephone = number;
      
     System.out.println("Veillez entrez la ville de votre nouveau patient");
     String city = new Scanner(System.in).nextLine();
      infirmier.ville = city;
      
     System.out.println("Veillez entrez la province de votre nouveau patient");
     String region = new Scanner(System.in).nextLine();
      infirmier.province = region;
     
     System.out.println("Veillez entrez l'adresse de votre nouveau patient");
     String adress = new Scanner(System.in).nextLine();
      infirmier.addresse = adress;
      
     System.out.println("Veillez entrez le code postal de votre nouveau patient");
     String mailbox = new Scanner(System.in).nextLine();
      infirmier.codePostal = mailbox;
      
     System.out.println("Veillez entrez le numero de permis du nouveau medecin");
     String numero_permis = new Scanner(System.in).nextLine();
     infirmier.setNumeroPermis(numero_permis);
     
     System.out.println("Veillez entrez le nom du nouveau medecin");
     String nom_med = new Scanner(System.in).nextLine();
     infirmier.setNomUtilisateur(nom_med);
     
     System.out.println("Veillez entrez le mot de passe du nouveau medecin");
     String mdp = new Scanner(System.in).nextLine();
     infirmier.setMotDePasse(mdp);
     
       return infirmier;
       
  }
  public void ajouterAdmission(){
      admissions.add(creerAdmission());
  } 
  public Patient rechercherPatient(){//Améliorer les codes de recherches en ajoutant d'autres types de recherches
      Patient resultat = new Patient();
      System.out.println("Veuillez indiquer le numéro RAMQ du patient recherché");
      String scn_p = new Scanner(System.in).nextLine();
      for(int i=0; i<patients.size();i++){
            if(patients.get(i).getNumeroRAMQ().equals(scn_p)){
                resultat = patients.get(i);
            }
      }
      return resultat;
  } 
  private void donnerConge(){//Cette méthode ne fonctionne que si on considère que le patient a une seul admission qui lui est propre: L'améliorer
      System.out.println("Veuillez indiquer le numéro RAMQ du patient recherché");
      String scn_p = new Scanner(System.in).nextLine();
      System.out.println("Veuillez entrez la nouvelle date sous le format YYYY-MM-DD du patient recherché");
      String date;
      date = new Scanner(System.in).nextLine();
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
            int scn_tampon = new Scanner(System.in).nextInt();                            
            tableau_patient.get(scn_tampon).setDateConge(dateConge);
            for(int x=0; x < admissions.size(); x++){
                if(tableau_patient.get(scn_tampon).equals(admissions.get(x))){
                    admissions.set(x, tableau_patient.get(scn_tampon));//Utilise admissions.set(x, tableau_patient.get(j)) pour remplacer l'élément à l'index x par celui de tableau_patient
                    admissions.get(x).lit.setOccupe(false);             }
                            }     
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
      String scn_m = new Scanner(System.in).nextLine();
      for(int i=0; i<medecins.size();i++){
            if(medecins.get(i).getNumeroPermis().equals(scn_m)){
                medecins.remove(medecins.get(i));
            }
  } 
  }
    public void afficherFacturePatient(Patient malade_recherche){
      rechercherPatient();//Maintenant qu'on a trouver le patient comment afficher sa facture?
      
  } 
}
//Comment vas t'on ajouter le patients avec ses attributs spécifiques/ Peut etre qu'il faut des méthodes qui crées toutes ces instances?