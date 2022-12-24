package Smart_Home_Syteme;

public class Equipements_domestiques {
    protected String nom;
    protected int prix;

    public Equipements_domestiques(String nom, int prix) {
        this.nom = nom;
        this.prix = prix;
    }

    public void utiliserEquipementDomestique() {
        System.out.println("L'équipement domestique " + nom + " est en train d'être utilisé.");
    }
}