
package Smart_Home_Systeme;

//classe permettant de créer une météo "positive"
public class BonTemps extends Meteo {

    //methode permettant de créer une méteo par défaut
    public BonTemps() {
        super();
    }

    //methode permettant de créer une méteo "positive" selon une l'humidité et une temperature
    public BonTemps(double hum, double temp, boolean mtactive, boolean btactive) {
        super(hum, temp, mtactive, btactive);
    }

    //methode permettant de modifier la météo en la rendant plus "positive"
    public void ModifieBonTemps() {
        this.temperature += 1;              //on augmente la temperature de 1
        this.humidite -= 2;                 //on diminue l'humidité de 2
    }
}