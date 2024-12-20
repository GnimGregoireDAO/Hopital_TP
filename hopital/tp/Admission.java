package hopital.tp;

import java.time.LocalDate;

/**
 *
 * @author alexhaile
 */
public class Admission {
    private int IDAdmission;
    private LocalDate dateAdmission, dateChirurgie, dateConge;  
    private boolean televiseurLoué, telephoneLoué, chirurgieProgrammée;
    
    Patient patient;
    Lit lit;
    
    Medecin medecin;
    Departement departement;

    public Admission() {
    }

    public Patient getPatient() {
        return patient;
    }
    

    public void setIDAdmission(int IDAdmission) {
        this.IDAdmission = IDAdmission;
    }

    public void setChirurgieProgrammée(boolean chirurgieProgrammée) {
        this.chirurgieProgrammée = chirurgieProgrammée;
    }

    public void setDateAdmission(LocalDate dateAdmission) {
        this.dateAdmission = dateAdmission;
    }

    public void setDateChirurgie(LocalDate dateChirurgie) {
        this.dateChirurgie = dateChirurgie;
    }

    public void setDateConge(LocalDate dateConge) {
        this.dateConge = dateConge;
    }

    public void setTeleviseurLoué(boolean televiseurLoué) {
        this.televiseurLoué = televiseurLoué;
    }

    public void setTelephoneLoué(boolean telephoneLoué) {
        this.telephoneLoué = telephoneLoué;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setLit(Lit lit) {
        this.lit = lit;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }
    
    
    public int getIDAdmission() {
        return IDAdmission;
    }
    public LocalDate getDateConge() {
        return dateConge;
    }
    public LocalDate getDateAdmission() {
        return dateAdmission;
    }

    public LocalDate getDateChirurgie() {
        return dateChirurgie;
    }
    public Lit getLit() {
        return lit;
    }
    public boolean isTeleviseurLoué() {
        return televiseurLoué;
    }

    public boolean isTelephoneLoué() {
        return telephoneLoué;
    }

    public boolean isChirurgieProgrammée() {
        return chirurgieProgrammée;
    }
    
    @Override
    public String toString() {
        return "Admission{" + "IDAdmission=" + IDAdmission + ", chirurgieProgramm\u00e9e=" + chirurgieProgrammée + ", dateAdmission=" + dateAdmission + ", dateChirurgie=" + dateChirurgie + ", dateConge=" + dateConge + ", televiseurLou\u00e9=" + televiseurLoué + ", telephoneLou\u00e9=" + telephoneLoué + ", patient=" + patient + ", lit=" + lit + ", medecin=" + medecin + ", departement=" + departement + '}';
    } 

    
}