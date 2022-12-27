package Smart_Home_Systeme;

public class Maison {
    private float temperature;
    private float humidite;
    private float luminosite;
    private Equipements_domestiques douche;
    private Equipements_domestiques lampes;
    private Equipements_domestiques four;
    private Equipements_domestiques television;
    private Equipements_energetiques Radiateur1;
    private Equipements_energetiques Radiateur2;
    private Equipements_energetiques Radiateur3;
    private Equipements_energetiques Ventilateur1;
    private Equipements_energetiques Ventilateur2;
    private Equipements_energetiques Ventilateur3;
    private Equipements_energetiques Ampoule1;
    private Equipements_energetiques Ampoule2;
    private Equipements_energetiques Ampoule3;

    public Maison(){
        this.temperature = 0;
        this.humidite = 0;
        this.luminosite = 0;
        this.douche = new Equipements_domestiques();
        this.lampes = new Equipements_domestiques();
        this.four = new Equipements_domestiques();
        this.television = new Equipements_domestiques();
        this.Radiateur1 = new Equipements_energetiques();
        this.Radiateur2 = new Equipements_energetiques();
        this.Radiateur3 = new Equipements_energetiques();
        this.Ventilateur1 = new Equipements_energetiques();
        this.Ventilateur2 = new Equipements_energetiques();
        this.Ventilateur3 = new Equipements_energetiques();
        this.Ampoule1 = new Equipements_energetiques();
        this.Ampoule2 = new Equipements_energetiques();
        this.Ampoule3 = new Equipements_energetiques();
    }

    public Maison(float tem, float hum, float lum, Equipements_domestiques dou, Equipements_domestiques lam, Equipements_domestiques fou, Equipements_domestiques tel, Equipements_energetiques R1, Equipements_energetiques R2, Equipements_energetiques R3, Equipements_energetiques V1, Equipements_energetiques V2, Equipements_energetiques V3, Equipements_energetiques A1, Equipements_energetiques A2, Equipements_energetiques A3) {
        this.temperature = tem;
        this.humidite = hum;
        this.luminosite = lum;
        this.douche = dou;
        this.lampes = lam;
        this.four = fou;
        this.television = tel;
        this.Radiateur1 = R1;
        this.Radiateur2 = R2;
        this.Radiateur3 = R3;
        this.Ventilateur1 = V1;
        this.Ventilateur2 = V2;
        this.Ventilateur3 = V3;
        this.Ampoule1 = A1;
        this.Ampoule2 = A2;
        this.Ampoule3 = A3;
    }

    public void showMaison(){
        System.out.println("Température: " + temperature + " °C.");
        System.out.println("Humidité: " + humidite + " %.");
        System.out.println("Luminosité: " + luminosite + " lux.");
        douche.showEquipementsDomestiques();
        lampes.showEquipementsDomestiques();
        four.showEquipementsDomestiques();
        television.showEquipementsDomestiques();
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
}
