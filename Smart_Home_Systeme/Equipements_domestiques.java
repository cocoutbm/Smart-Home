package Smart_Home_Systeme;

//class qui definit un équipement domestique
public class Equipements_domestiques {
    protected String nom;                           //nom de l'équipement
    protected double consommation;                  //valeur de la consommation de l'équipement
    private boolean estUtilise;                     //valeur pour savoir si un équipement est utilis (TRUE/FALSE)

//methode permettant de génerer un equipement par défault  
    public Equipements_domestiques(){
        this.nom="ED";
        this.consommation=0.0;
        this.estUtilise = false;
    }
    
 //methode permettant de génerer un equipement selon un nom, une consommation et un etat d'utilisation 
    public Equipements_domestiques(String nom, float consommation, boolean use) {
        this.nom = nom;
        this.consommation = consommation;
        this.estUtilise = use;
    }
    
//methode permettant de rentrer un objet utilisé ou non utilisé
    public void ustiliserEquipementsDomestiques(boolean use) {
        this.estUtilise = use;  //on change l'etat d'utilisation selon le parametre
    }
    
//methode permettant d'afficher un équipement domestique (affiche son nom et sa consommation)
    public void showEquipementsDomestiques() {
        System.out.println("    nom: " + nom + ", consommation: " + consommation + ".");
    }

 //methode permettant de récuperer la consommation d'un equipement
    public double getConsommation() {
        if (estUtilise){                //si il est utilisé on retourne sa conso
            return consommation;
        } else {
            return 0;                   //si il est pas utilisé on retourne 0
        }
    }
    
//methode permettant de retourner l'etat d'un equipement (savoir si il est utilisé ou non)
    public boolean isEstUtilise(){
        return estUtilise;
    }
}
