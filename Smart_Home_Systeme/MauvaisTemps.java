package Smart_Home_Systeme;

public class MauvaisTemps extends Meteo {
    public MauvaisTemps() {
        super();
    }

    public MauvaisTemps(float hum, float temp) {
        super(hum, temp);
    }

    public void ModifieMauvaisTemps() {
        this.temperature -= 1;
        this.humidite += 2;
    }


}