package hopital.tp;



class Lit {
    public enum Type {
        Standart, Privé, Public
    }
    private String numeroLit;
    private boolean occupe;
    private Type type; // standart, private ou public
    private Departement departement;
    private double prix;
    private Lit tampon = new Lit();
    
    

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
        switch (tampon.getType()) {
            case Standart ->                 {
                    double val = 48.5;
                    prix = tampon.setPrix(val);
                }
            case Privé ->                 {
                    double val = 58.0;
                    prix = tampon.setPrix(val);
                }
            case Public ->                 {
                    double val = 278.0;
                    prix = tampon.setPrix(val);
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

    @Override
    public String toString() {
        return "Lit{" + "numeroLit=" + numeroLit + ", occupe=" + occupe + ", type=" + type + ", departement=" + departement + '}';
    }
    
}