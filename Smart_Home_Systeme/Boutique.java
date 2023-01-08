package Smart_Home_Systeme;

public class Boutique {

    //Definition de tous les objets present dans la boutique

    //Definition 3 types de radiateur selon leurs rendements energetiques
    private Equipements_energetiques Radiateur1;
    private Equipements_energetiques Radiateur2;
    private Equipements_energetiques Radiateur3;

    //Definition 3 types de ventilateur selon leurs rendements energetiques
    private Equipements_energetiques Ventilateur1;
    private Equipements_energetiques Ventilateur2;
    private Equipements_energetiques Ventilateur3;

    //Definition 3 types d'ampoule selon leurs rendements energetiques
    private Equipements_energetiques Ampoule1;
    private Equipements_energetiques Ampoule2;
    private Equipements_energetiques Ampoule3;

    //Constructeur d'une boutique par défaut en ajoutant les equipements avec des valeurs prédefinit
    public Boutique() {
        this.Radiateur1 = new Equipements_energetiques("Radiateur lowcost", 150.0, 100.0,false, false);
        this.Radiateur2 = new Equipements_energetiques("Radiateur populaire", 250.0, 150.0,false, false);
        this.Radiateur3 = new Equipements_energetiques("Radiateur haut de gamme", 350.0, 200.0,false, false);
        this.Ventilateur1 = new Equipements_energetiques("Ventilateur lowcost", 25.0, 50.0,false, false);
        this.Ventilateur2 = new Equipements_energetiques("Ventilateur populaire", 65.0, 100.0,false, false);
        this.Ventilateur3 = new Equipements_energetiques("Ventilateur haut de gamme", 100.0, 150.0,false, false);
        this.Ampoule1 = new Equipements_energetiques("Ampoule Qualité1", 3.5, 10.0,false, false);
        this.Ampoule2 = new Equipements_energetiques("Ampoule qualité2", 7.5, 20.0,false, false);
        this.Ampoule3 = new Equipements_energetiques("Ampoule Qualité3", 14.5, 30.0,false, false);
    }

    //methode permettant d'afficher tous élements present dans la boutique
    public void showBoutique() {
        Radiateur1.showEquipementsEnergetiques();
        Radiateur2.showEquipementsEnergetiques();
        Radiateur3.showEquipementsEnergetiques();
        Ventilateur1.showEquipementsEnergetiques();
        Ventilateur2.showEquipementsEnergetiques();
        Ventilateur3.showEquipementsEnergetiques();
        Ampoule1.showEquipementsEnergetiques();
        Ampoule2.showEquipementsEnergetiques();
        Ampoule3.showEquipementsEnergetiques();
    }

    //methode permettant de récuperer le radiateur bas de gamme
    public Equipements_energetiques getRadiateur1() {
        return Radiateur1;
    }

    //methode permettant de récuperer le radiateur populaire
    public Equipements_energetiques getRadiateur2() {
        return Radiateur2;
    }

    //methode permettant de récuperer haut de gamme
    public Equipements_energetiques getRadiateur3() {
        return Radiateur3;
    }

    //methode permettant de récuperer le ventilateur bas de gamme
    public Equipements_energetiques getVentilateur1() {
        return Ventilateur1;
    }
    //methode permettant de récuperer le ventilateur populaire
    public Equipements_energetiques getVentilateur2() {
        return Ventilateur2;
    }
    //methode permettant de récuperer le ventilateur haut de gamme
    public Equipements_energetiques getVentilateur3() {
        return Ventilateur3;
    }
    //methode permettant de récuperer l'ampoule qualité 1
    public Equipements_energetiques getAmpoule1() {
        return Ampoule1;
    }
    //methode permettant de récuperer l'ampoule qualité 2
    public Equipements_energetiques getAmpoule2() {
        return Ampoule2;
    }
    //methode permettant de récuperer l'ampoule qualité 3
    public Equipements_energetiques getAmpoule3() {
        return Ampoule3;
    }

}
