package hopital.tp;
public class Personne {
    protected String nom;
    protected String prenom;
    protected String addresse;
    protected String ville;
    protected String province;
    protected String codePostal;
    protected String telephone;

    public Personne() {
    }
    public Personne(String nom, String prenom, String addresse, String ville, String province, String codePostal, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.addresse = addresse;
        this.ville = ville;
        this.province = province;
        this.codePostal = codePostal;
        this.telephone = telephone;
    }
    @Override
    public String toString() {
        return "nom=" + nom + ", prenom=" + prenom + ", addresse=" + addresse + ", ville=" + ville + ", province=" + province + ", codePostal=" + codePostal + ", telephone=" + telephone;
    }
}
