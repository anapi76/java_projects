package solid;
import solid.Animal;

public class Cat extends Animal{
    public Cat(String name, int teeth){
        super(name, teeth);
    }

    public String getSound(){
        return "Meaw";
    }

    public int getFlightDistance(){
        return 0;
    }

    public int getTeeth(){
        return this.teeth;
    }

}
