package Smart_Home_Systeme;

public class BonTemps extends Meteo {
    public BonTemps() {
        super();
    }

    public BonTemps(float hum, float temp) {
        super(hum, temp);
    }

    public void ModifieBonTemps() {
        this.temperature += 1;
        this.humidite -= 2;

    }

}
