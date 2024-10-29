package hopital.tp;
public class Patient extends Personne{
    private String numeroRAMQ;
    private String dateNaissance;
    private Assurance assurance;

    public Patient() {
    }

    public Patient(String numeroRAMQ, String dateNaissance) {
        this.numeroRAMQ = numeroRAMQ;
        this.dateNaissance = dateNaissance;     
    }
    

    public void setNumeroRAMQ(String numeroRAMQ) {
        this.numeroRAMQ = numeroRAMQ;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setAssurance(Assurance assurance) {
        this.assurance = assurance;
    }
    

    public Patient(String numeroRAMQ, String dateNaissance, Assurance assurance, String nom, String prenom, String addresse, String ville, String province, String codePostal, String telephone) {
        super(nom, prenom, addresse, ville, province, codePostal, telephone);
        this.numeroRAMQ = numeroRAMQ;
        this.dateNaissance = dateNaissance;
        this.assurance = assurance;
    }

    public String getNumeroRAMQ() {
        return numeroRAMQ;
    }

    @Override
    public String toString() {
        return super.toString() + "numeroRAMQ=" + numeroRAMQ + ", dateNaissance=" + dateNaissance + ", assurance=" + assurance + '}';
    }
}