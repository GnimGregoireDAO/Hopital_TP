package groupe_amg_hopital_vf;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Random;

import groupe_amg_hopital_vf.Lit.Type;
import groupe_amg_hopital_vf.exceptions.*;

/**
 * Gestionnaire class to manage hospital operations.
 */
public class Gestionnaire {
    public ArrayList<Admission> admissions = new ArrayList<>();
    public ArrayList<Patient> patients = new ArrayList<>();
    public ArrayList<Medecin> medecins = new ArrayList<>();
    public ArrayList<Lit> lits = new ArrayList<>();
    public ArrayList<Assurance> assurances = new ArrayList<>();
    public ArrayList<Departement> departements = new ArrayList<>();
    private Medecin medecinConnecte;

    public Gestionnaire() {
        // Constructor logic if needed
    }

    public Gestionnaire(Medecin medecinConnecte) {
        this.medecinConnecte = medecinConnecte;
    }

    public void créationLit() {
        // Create departments and generate random beds
        Departement departement1 = new Departement(1, "Urgences");
        Departement departement2 = new Departement(2, "Cardiologie");
        Departement departement3 = new Departement(3, "Neurologie");
        Departement departement4 = new Departement(4, "Oncologie");
        Departement departement5 = new Departement(5, "Orthopédie");
        Departement departement6 = new Departement(6, "Pédiatrie");
        Departement departement7 = new Departement(7, "Gynécologie et obstétrique");
        Departement departement8 = new Departement(8, "Radiologie");
        Departement departement9 = new Departement(9, "Psychiatrie");
        Departement departement10 = new Departement(10, "Chirurgie");
        Departement departement11 = new Departement(11, "Dermatologie");
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

    public void créationMedecin() {
        Medecin medecin1 = new Medecin("1", "medecin1", "crosemont", "DAO", "Gnim", "123 rue de la rue", "Montreal", "Quebec", "H1H 1H1", "514-123-4567");
        Medecin medecin2 = new Medecin("2", "medecin2", "crosemont", "Haile", "Alex", "123 rue de la rue", "Montreal", "Quebec", "H1H 1H1", "514-123-4567");
        Medecin medecin3 = new Medecin("3", "medecin3", "crosemont", "Backiny", "Emmanuel", "123 rue de la rue", "Montreal", "Quebec", "H1H 1H1", "514-123-4567");
        medecins.add(medecin1);
        medecins.add(medecin2);
        medecins.add(medecin3);
    }

    public void creationAssurance() {
        Assurance assurance1 = new Assurance(1, "SunLife");
        Assurance assurance2 = new Assurance(2, "ManuLife");
        Assurance assurance3 = new Assurance(3, "Desjardins");
        assurances.add(assurance1);
        assurances.add(assurance2);
        assurances.add(assurance3);
    }

    public void creerPatient(String nom, String prenom, String addresse, String ville, String province, String codePostal, String telephone, String numeroRAMQ, String dateNaissance, int age) {
        patients.add(new Patient(nom, prenom, addresse, ville, province, codePostal, telephone, numeroRAMQ, dateNaissance, age));
    }

    public void ajouterPatient(Patient patient) {
        patients.add(patient);
    }

    public void creerAdmission(int IDAdmission, boolean chirurgieProgrammée, LocalDate dateAdmission, LocalDate dateChirurgie, boolean televiseurLoué, boolean telephoneLoué, Patient patient, Departement departement) throws LitIndisponibleException {
        // Trouver un lit disponible dans le département spécifié
        Lit litDisponible = null;
        for (Lit lit : lits) {
            if (!lit.isOccupe() && lit.getDepartement().equals(departement)) {
                litDisponible = lit;
                break;
            }
        }

        // Si aucun lit n'est disponible, lancer une exception
        if (litDisponible == null) {
            throw new LitIndisponibleException();
        }

        // Créer l'admission avec le lit disponible
        Admission admission = new Admission(IDAdmission, dateAdmission, dateChirurgie, null, televiseurLoué, telephoneLoué, chirurgieProgrammée, patient, litDisponible, null, departement);
        admissions.add(admission);

        // Marquer le lit comme occupé
        litDisponible.setOccupe(true);
    }

    public void donnerConge(String numeroRAMQ, LocalDate dateConge) {
        for (Admission admission : admissions) {
            if (admission.getPatient().getNumeroRAMQ().equals(numeroRAMQ)) {
                admission.setDateConge(dateConge);
                admission.getLit().setOccupe(false);
                break;
            }
        }
    }

    protected void donnerConge_medecin(Medecin b) {
        b.utiliser_donner_conger(this);
    }

    protected void utiliser_donner_conger(Gestionnaire a) {
        a.donnerConge("someRAMQ", LocalDate.now());
    }

    public void ajouterMedecin(Medecin medecin) {
        medecins.add(medecin);
    }

    public void supprimerMedecin(String numeroPermis) {
        medecins.removeIf(medecin -> medecin.getNumeroPermis().equals(numeroPermis));
    }

    public double calculerFacture(int IDAdmission) {
        for (Admission admission : admissions) {
            if (admission.getIDAdmission() == IDAdmission) {
                long daysBetween = ChronoUnit.DAYS.between(admission.getDateAdmission(), admission.getDateConge());
                double facture = admission.getLit().getPrix() * daysBetween;
                if (admission.isTeleviseurLoué()) {
                    facture += 42.50 * daysBetween;
                }
                if (admission.isTelephoneLoué()) {
                    facture += 7.50 * daysBetween;
                }
                return facture;
            }
        }
        return 0;
    }

    public void sauvegarderAdmissions(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Admission admission : admissions) {
                writer.write(admission.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Patient rechercherPatient(String ramq) throws PatientNotFoundException {
        for (Patient patient : patients) {
            if (patient.getNumeroRAMQ().equals(ramq)) {
                return patient;
            }
        }
        throw new PatientNotFoundException(ramq);
    }

    public boolean VerificationPatient(String ramq) {
        for (Patient patient : patients) {
            if (patient.getNumeroRAMQ().equals(ramq)) {
                return true;
            }
        }
        return false;
    }

    public boolean login(String username, String password, String role) throws LoginException {
        for (Medecin medecin : medecins) {
            if (medecin.getNumeroPermis().equals(username) && medecin.getMotDePasse().equals(password)) {
                if (role.equals("Administrateur") && medecin instanceof Administrateur) {
                    return true;
                } else if (role.equals("Préposé") && medecin instanceof Prepose) {
                    return true;
                } else if (role.equals("Médecin") && !(medecin instanceof Administrateur) && !(medecin instanceof Prepose)) {
                    return true;
                }
            }
        }
        throw new LoginException();
    }

    public Medecin rechercherMedecin(String numeroRAMQ) {

        for (Medecin medecin : medecins) {
            if (medecin.getNumeroPermis().equals(numeroRAMQ)) {
                return medecin;
            }
        }
        return null;
    }

    public Admission getLatestAdmission(Patient patient) {
        Admission latestAdmission = null;
        for (Admission admission : admissions) {
            if (admission.getPatient().equals(patient)) {
                if (latestAdmission == null || admission.getDateAdmission().isAfter(latestAdmission.getDateAdmission())) {
                    latestAdmission = admission;
                }
            }
        }
        return latestAdmission;
    }

    public boolean isAdmin() {
        return false; // Adjust logic as needed
    }

    public boolean isPrep() {
        return false; // Adjust logic as needed
    }

    public boolean isMedecin() {
        return true; // Adjust logic as needed
    }

    public ArrayList<Patient> getPatientsByMedecin(Medecin medecin) {
        ArrayList<Patient> medecinPatients = new ArrayList<>();
        for (Admission admission : admissions) {
            if (admission.getMedecin().equals(medecin) && admission.getDateConge() == null) {
                medecinPatients.add(admission.getPatient());
            }
        }
        return medecinPatients;
    }

    void creerAdmission(int IDAdmission, boolean chirurgieProgrammée, LocalDate dateAdmission, LocalDate dateChirurgie, boolean televiseurLoué, boolean telephoneLoué, Patient patient, Lit lit, Medecin medecin, Departement dept) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Medecin getMedecinConnecte() {
        return medecinConnecte;
    }

    public void setMedecinConnecte(Medecin medecinConnecte) {
        this.medecinConnecte = medecinConnecte;
    }
}
