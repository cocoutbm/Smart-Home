package Smart_Home_Systeme;

public class BonTemps extends Meteo {

    public BonTemps() {
        super();
    }

    public BonTemps(double hum, double temp, boolean mtactive, boolean btactive) {
        super(hum, temp, mtactive, btactive);
    }

    public void ModifieBonTemps() {
        this.temperature += 1;
        this.humidite -= 2;
    }
}