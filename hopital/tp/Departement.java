package hopital.tp;
public class Departement {
    private int idDepartement;
    private String nomDepartement;

    public Departement(int idDepartement, String nomDepartement) {
        this.idDepartement = idDepartement;
        this.nomDepartement = nomDepartement;
    }

    public int getIdDepartement() {
        return idDepartement;
    }
    
    @Override
    public String toString() {
        return "Departement{" + "idDepartement=" + idDepartement + ", nomDepartement=" + nomDepartement + '}';
    }
}