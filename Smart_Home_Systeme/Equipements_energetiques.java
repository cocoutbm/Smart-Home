package Smart_Home_Systeme;

//classe permettant de definir un equipement energetique
public class Equipements_energetiques {
    private String nom;                     //le nom de l'equipement
    private double prix;                    //le prix de l'equipement
    private double consommation;            //la consommation de l'equipement
    private boolean estUtilise;             //l'etat d'utilisation de l'equipement (utilisé ou pas)
    private boolean estAchete;              //l'etat d'achat de l'equipement (acheté ou pas)
    
//constructeur par défaut d'un equipement energetique
    public Equipements_energetiques(){
        this.nom = "EE";
        this.prix = 0.0;
        this.consommation = 0.0;
        this.estUtilise = false;
        this.estAchete = false;

    }
    
//constructeur d'un equipement selon son nom, prix, sa consommation, son etat d'utilisation et d'achat
    public Equipements_energetiques(String n, double p, double c, boolean use, boolean achete){
        this.nom = n;
        this.prix = p;
        this.consommation = c;
        this.estUtilise = use;
        this.estAchete = achete;

    }
    
//methode permettant d'utiliser un equipement ou d'arreter de l'utiliser
    public void utiliserEquipementsEnergetiques(boolean use) {
        this.estUtilise = use;              //change l'etat d'utilisation selon son parametre
    }
    
//methode permettant d'afficher un equipement energetique sur la console
    public void showEquipementsEnergetiques(){
        System.out.println(" nom: " + nom + ", prix: " + prix + " €, consommation: " + consommation + ".");
    }

//methode permettant d'obtenir le prix d'un equipement energetique
    public double getPrix() {
        return prix;
    }

//methode permettant de changer l'etat d'achat d'un equipement
    public void setEstAchete(boolean achete){
        this.estAchete = achete;
    }
    
//methode permettant de recuperer l'etat d'achat d'un equipement
    public boolean isEstAchete(){
        return estAchete;
    }
    
//methode permettant de recuperer la consommation d'un equipement
    public double getConsommation() {
        if (estUtilise){                //si utilisé on recupere sa conso
            return consommation;
        } else {                        //sinon on renvoie 0
            return 0;
        }
    }

//methode permettant de savoir si un equipement est utilisé
    public boolean isEstUtilise(){
        return estUtilise;
    }
}

