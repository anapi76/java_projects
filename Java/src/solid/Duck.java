package solid;
import solid.Animal;

public class Duck extends Animal{
    private int flightDistance;

    public Duck(String name, int teeth, int flightDistance){
        super(name, teeth);
        this.flightDistance=flightDistance;
    }

    public int getFlightDistance() {
        return flightDistance;
    }

    public String getSound(){
        return "Quack";
    }

    public int getTeeth(){
        return this.teeth;
    }

}
