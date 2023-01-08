//ajout des differents fichiers et package
package Smart_Home_Joueur;
import Smart_Home_Systeme.Boutique;
import Smart_Home_Systeme.Equipements_energetiques;
import java.util.ArrayList;

//definition de la classe Joueur
public class Joueur {
    private int nombre_jour_survie;         //nombre de jour que la partie dure
    private String pseudo;                  //pseudo du joueur
    private double argent;                  //argent que possede le joueur
    private Boutique boutique;              //la boutique

//Initialisation d'un joueur par défaut
    public Joueur(){
        this.nombre_jour_survie = 0;
        this.pseudo = "Player";
        this.argent = 25000.0;
        this.boutique = new Boutique();
    }
    
//construction d'un joueur selon son nom
    public Joueur(String p){
        this.nombre_jour_survie = 0;
        this.pseudo = p;
        this.argent = 25000.0;
        this.boutique = new Boutique();
    }
    
//methode permettant de récouperer le nombre de jour actuel du joueur
    public int getNbJourSurvie(){
        return nombre_jour_survie;
    }
    
//methode permettant de récouperer l'argent que possède le joueur
    public double getArgent() {
        return argent;
    }
    
//methode permettant de changer le pseudo du joueur
    public void setPseudo(String p) {
        pseudo = p;
    }
//methode permettant de recuperer le pseudo du joueur
    public String getPseudo() {
        return pseudo;
    }
    
//methode permettant de changer le nombre de jour actuel du joueur
    public void setNombre_jour_survie() {
        this.nombre_jour_survie += 1;
    }
    
//methode permettant de retirer de l'argent au joueur
    public void setRetrait(double arg){
        this.argent -= arg;
    }
    
//methode permettant d'ajouter de l'argent au joueur
    public void setGain(double arg) {
        this.argent += arg;
    }
//methode permettant d'acheter un équipement énergetique
    public void AcheterEquip(Equipements_energetiques EE, ArrayList<Equipements_energetiques> tab_EE) {
        tab_EE.add(EE);                 //ajoute l'equipement à la liste des equipements que le joueur a acheté
        EE.setEstAchete(true);
        this.argent -= EE.getPrix();     //déduit le prix de l'equipement de l'argent du joueur
    }

}
