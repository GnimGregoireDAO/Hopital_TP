package hopital.tp;

class Lit {
    public enum Type {
        Standart, Privé, SemiPrivé;    
    }
    private String numeroLit;
    private boolean occupe;
    private Type type; // standart, private ou semi-private
    private Departement departement;
    private double prix;
    public static double val = 48.5;
    public static double val2 = 58.0;
    public static double val3 = 278.0;
    public static double val_assur = 0.0;
    
    public Lit(String numeroLit, boolean occupe, Type type, Departement departement) {
        this.numeroLit = numeroLit;
        this.occupe = occupe;
        this.type = type;
        this.departement = departement;        
    }
    public Lit() {
    }

    public Type getType() {
        return type;
    }

    public double setPrix(double prix) { 
        this.prix = prix;
        return prix;
    }
    public double getPrix() {  
        switch (getType()) {
            case Standart ->                 {
                    prix = setPrix(val);
                }
            case Privé ->                 {
                    val2 = 58.0;
                    prix = setPrix(val2);
                }
            case SemiPrivé ->                 {
                    prix = setPrix(val3);
                }
            default -> {
            }
        }

        return prix;
    }

    public void setNumeroLit(String numeroLit) {
        this.numeroLit = numeroLit;
    }

    public void setOccupe(boolean occupe) {
        this.occupe = occupe;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }


    public String getNumeroLit() {
        return numeroLit;
    }
    public Departement getDepartement() {
        return departement;
    }
    public boolean isOccupe() {
        return occupe;
    }

    @Override
    public String toString() {
        return "Lit{" + "numeroLit=" + numeroLit + ", occupe=" + occupe + ", type=" + type + ", departement=" + departement + '}';
    }
    
}