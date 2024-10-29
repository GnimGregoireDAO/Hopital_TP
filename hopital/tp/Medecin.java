package hopital.tp;
public class Medecin extends Personne{
    private String numeroPermis;
    private String nomUtilisateur;
    private String motDePasse;

    public Medecin() {
    }
    

    public Medecin(String numeroPermis, String nomUtilisateur, String motDePasse, String nom, String prenom, String addresse, String ville, String province, String codePostal, String telephone) {
        super(nom, prenom, addresse, ville, province, codePostal, telephone);
        this.numeroPermis = numeroPermis;
        this.nomUtilisateur = nomUtilisateur;
        this.motDePasse = motDePasse;
    }
    protected void utiliser_donner_conger(Gestionnaire a){
        a.donnerConge_medecin(this);
    }

    public void setNumeroPermis(String numeroPermis) {
        this.numeroPermis = numeroPermis;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getNumeroPermis() {
        return numeroPermis;
    }

    @Override
    public String toString() {
        return super.toString() + "numeroPermis=" + numeroPermis + ", nomUtilisateur=" + nomUtilisateur + ", motDePasse=" + motDePasse;
    }
}