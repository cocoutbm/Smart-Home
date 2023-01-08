package Smart_Home_Systeme;

//classe permettant de créer une météo "negative"
public class MauvaisTemps extends Meteo {

//methode permettant de créer une méteo par défaut
    public MauvaisTemps() {
        super();
    }
    
//methode permettant de créer une méteo "negative" selon une humidité et une temperature
    public MauvaisTemps(double hum, double temp, boolean mtactive, boolean btactive) {
        super(hum, temp, mtactive, btactive);
    }
    
//methode permettant de modifier la météo en la rendant plus "negative"
    public void ModifieMauvaisTemps() {
        this.temperature -= 1;
        this.humidite += 2;
    }

}
