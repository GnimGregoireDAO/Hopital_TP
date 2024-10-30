package hopital.tp;
/**
 *
 * @author alexhaile
 */
public class Assurance {
    private int idAssurance;
    private String nomCompagnie;

    public Assurance(int idAssurance, String nomCompagnie) {
        this.idAssurance = idAssurance;
        this.nomCompagnie = nomCompagnie;
    }
    @Override
    public String toString() {
        return "Assurance{" + "idAssurance=" + idAssurance + ", nomCompagnie=" + nomCompagnie + '}';
    }
}