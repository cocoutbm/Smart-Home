package Smart_Home_Systeme;

public class MauvaisTemps extends Meteo {

    public MauvaisTemps() {
        super();
    }

    public MauvaisTemps(double hum, double temp, boolean mtactive, boolean btactive) {
        super(hum, temp, mtactive, btactive);
    }

    public void ModifieMauvaisTemps() {
        this.temperature -= 1;
        this.humidite += 2;
    }

}