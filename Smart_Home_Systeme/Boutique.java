package Smart_Home_Systeme;

public class Boutique {
    private Equipements_energetiques Radiateur1;
    private Equipements_energetiques Radiateur2;
    private Equipements_energetiques Radiateur3;
    private Equipements_energetiques Ventilateur1;
    private Equipements_energetiques Ventilateur2;
    private Equipements_energetiques Ventilateur3;
    private Equipements_energetiques Ampoule1;
    private Equipements_energetiques Ampoule2;
    private Equipements_energetiques Ampoule3;

    public Boutique() {
        this.Radiateur1 = new Equipements_energetiques("Radiateur lowcost", 150.0, 100.0,false);
        this.Radiateur2 = new Equipements_energetiques("Radiateur populaire", 250.0, 150.0,false);
        this.Radiateur3 = new Equipements_energetiques("Radiateur haut de' gamme", 350.0, 200.0,false);
        this.Ventilateur1 = new Equipements_energetiques("Ventilateur lowcost", 25.0, 50.0,false);
        this.Ventilateur2 = new Equipements_energetiques("Ventilateur populaire", 65.0, 100.0,false);
        this.Ventilateur3 = new Equipements_energetiques("Ventilateur haut de gamme", 100.0, 150.0,false);
        this.Ampoule1 = new Equipements_energetiques("Ampoule lowcost", 3.5, 10.0,false);
        this.Ampoule2 = new Equipements_energetiques("Ampoule populaire", 7.5, 20.0,false);
        this.Ampoule3 = new Equipements_energetiques("Ampoule haut de gamme", 14.5, 30.0,false);
    }

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

    public Equipements_energetiques getRadiateur1() {
        return Radiateur1;
    }

    public Equipements_energetiques getRadiateur2() {
        return Radiateur2;
    }

    public Equipements_energetiques getRadiateur3() {
        return Radiateur3;
    }

    public Equipements_energetiques getVentilateur1() {
        return Ventilateur1;
    }
    public Equipements_energetiques getVentilateur2() {
        return Ventilateur2;
    }

    public Equipements_energetiques getVentilateur3() {
        return Ventilateur3;
    }

    public Equipements_energetiques getAmpoule1() {
        return Ampoule1;
    }

    public Equipements_energetiques getAmpoule2() {
        return Ampoule2;
    }

    public Equipements_energetiques getAmpoule3() {
        return Ampoule3;
    }

}
